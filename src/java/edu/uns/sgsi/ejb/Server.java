package edu.uns.sgsi.ejb;

import edu.uns.escalafon.jpa.EscEstadoTrabajador;
import edu.uns.sgsi.jpa.GsiPrrbProgBackup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.persistence.PersistenceContext;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.util.AES;
import org.jsuns.util.XFile;
import org.jsuns.util.Zipper;

@Stateless
public class Server implements ServerLocal {

//    @EJB
////    private FTPServiceLocal FTPService;
//    @EJB
//    private GsiPrrbBackupFacadeLocal gsiPrrbBackupFacade;
    @EJB
    private MailServiceLocal servicioMail;

    private String host = "10.0.0.100";
    private int port = 2638;
    private long lastTime;
    private Date lastDate;
    public String sFecha;
    public String sHora;

    public long getTime() {
        long curdate = (lastDate = new Date()).getTime();
        long p = lastTime;
        lastTime = curdate;
        return curdate - p;
    }

    public Date getLastDate() {
        return lastDate;
    }

    private GsiPrrbProgBackup GsiPrrbProgBackup;

    public Server() {
        nn++;
        id = nn;
        init();
    }

    private void init() {
        GsiPrrbProgBackup = new GsiPrrbProgBackup();
        GsiPrrbProgBackup.setPathFuente("E:\\Seguridad\\");

    }

    public boolean activo() {
        return true;//!disponiblePort(host, port);
    }

    public void MensajeServicio() {
        if (disponiblePort(host, port)) {
            System.out.println("Servidor de Base de datos caido en " + port);
        } else {
            System.out.println("Servidor de Base de datos ejecutandose en " + port);
        }
    }

    private static boolean disponiblePort(String host, int port) {
        try (Socket ignored = new Socket(host, port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }

    private Exception exception;

    public Exception getException() {
        return exception;
    }

    private static boolean bussy = false;

    private static int nn = 0;

    private int id = 0;

    @Override
    public void doBackup() {
        if (exception != null) {
            log("hubo una excepcion la ultima vez " + this.exception);
        }
        if (bussy) {
            log("esta ocupado esta instancia " + id + " morira :(");
            return;
        }
        if (activo() && !bussy) {
            bussy = true;
            File mainDir = XFile.getFile(new File(GsiPrrbProgBackup.getPathFuente()));
            sFecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String unsasa_eva = "unsasa_eva";
            File backup = new File(mainDir, sFecha);
            File fenc = new File(mainDir, unsasa_eva + "-" + sFecha + ".enc");
            if (fenc.exists()) {
                System.out.println("El backup de " + sFecha + " ya existe en '" + fenc + "'");
                bussy = false;
                return;
            }
            EntityManager em0 = null;
            JPA jpa = JPA.getInstance();
            try {
                if (!mainDir.exists()) {
                    throw new RuntimeException("No seha podido crear el directorio '" + mainDir + "'.");
                }
                getTime();
                sHora = new SimpleDateFormat("HH:mm:ss").format(new Date());

                File flog = new File(backup, unsasa_eva + ".log");
                File fdb = new File(backup, unsasa_eva + ".db");
                File fzip = new File(backup, unsasa_eva + ".7z");
                File f0enc = new File(backup, unsasa_eva + ".0.enc");
                do {
                    if (fenc.exists()) {
                        break;
                    } else if (f0enc.exists()) {
                        System.out.println("le cambiare a " + f0enc);
                        //Enviar por ftp
                        try {
                            //                    FTPService.move(f0enc);   
                            f0enc.renameTo(fenc);
                            File tmpBackup = new File(backup, "backup");
                            if (tmpBackup.exists()) {
                                for (File f : tmpBackup.listFiles()) {
                                    f.delete();
                                }
                                tmpBackup.delete();
                            }
                            if (backup.exists()) {
                                for (File f :backup.listFiles()) {
                                    f.delete();
                                }
                                backup.delete();
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (fzip.exists()) {
                        //encripta
                        //GsiPrrbProgBackup
                        AES.encrypt(128, "coyote".toCharArray(),
                                new FileInputStream(fzip),
                                new FileOutputStream(f0enc));
                    } else if (fdb.exists() && flog.exists()) {
                        //comprimir
                        Zipper appZip = new Zipper();
                        appZip.generateFileList(flog);
                        appZip.generateFileList(fdb);
//                        appZip.zip(fzip.toString());
//                        flog.delete();
//                        fdb.delete();
                    } else {
                        File tmpBackup = new File(backup, "backup");
                        String l[] = tmpBackup.list();
                        boolean partsExists = tmpBackup.exists() && l != null && l.length > 0;
                        System.out.println("partsExists=" + partsExists + "" + (l != null ? l.length : 0));
                        if (partsExists) {
                            int max = l.length;
                            for (int i = 1; i <= max; i++) {
                                File fi = new File(tmpBackup, unsasa_eva + "." + i);
                                System.out.println(fi.exists() + "->" + fi);
                                if (!fi.exists()) {
                                    partsExists = false;
                                    break;
                                }
                            }
                        }
                        if (!partsExists) {
                            File f[] = tmpBackup.listFiles();
                            if (f != null) {
                                for (File f1 : f) {
                                    f1.delete();
                                }
                            }
                        }
                        
                        File fi = new File(XFile.getFile(tmpBackup),
                                unsasa_eva);
                        if (partsExists) {
                            //crear en db y log
                            try {
                                if (em0 == null) {
                                    em0 = jpa.getEntityManager();
                                }
                                System.out.println("SELECT fn_gsi_valida_backup('" + fi.getCanonicalPath()
                                        + "','" + fdb.getCanonicalPath() + "')");
                                fdb.delete();
                                flog.delete();
                                em0.createNativeQuery("SELECT fn_gsi_valida_backup(:fullpath,:destino)")
                                        .setParameter("fullpath", fi.getCanonicalPath())
                                        .setParameter("destino", fdb.getCanonicalPath())
                                        .getSingleResult();
                                File flogtmp = new File(mainDir, unsasa_eva + ".log");
                                if (flogtmp.exists()) {
                                    flogtmp.renameTo(flog);
                                }
                                System.out.println("Termina validación de backup");
                                //System.out.println(em);
                            } catch (Exception e) {
                                File f[] = tmpBackup.listFiles();
                                if (f != null) {
                                    for (File f1 : f) {
//                                        f1.delete();
                                    }
                                }
                                throw new RuntimeException(e);
                            }
                        } else {
                            //borrar las partes si hay
                            //generar las partes
                            try {
                                if (em0 == null) {
                                    em0 = jpa.getEntityManager();
                                }
                                System.out.println("SELECT fn_gsi_genera_backup('" + fi.getAbsolutePath() + "')");
                                em0.createNativeQuery("SELECT fn_gsi_genera_backup(:fullpath)")
                                        .setParameter("fullpath", fi.getAbsolutePath())
                                        .getSingleResult();
                                System.out.println("Termina fn_gsi_genera_backup");
                                getTime();
                            } catch (Exception e) {

                                throw new RuntimeException("Error llamando a fn_gsi_genera_backup.", e);
                            }
                        }
                    }

                } while (true);
                EscEstadoTrabajador t=new EscEstadoTrabajador();
//                t.setIdEstado((short)(escEstadoTrabajadorFacade.count()+1));
//                t.setActivo(true);
//                t.setEstado(new Date().toString().substring(0, 4));
//               
//                escEstadoTrabajadorFacade.create(t);
//                GsiPrrbBackup fileBackup = new GsiPrrbBackup();
//                GsiPrrbProgBackup progBackup = new GsiPrrbProgBackup();
//                fileBackup.setTamano((int) (fenc.length() / 100));
                //                fileBackup.setTiempo();
                //                regBackup.getFechaInicio();
                //                regBackup.getFechaTermino();
                //                regBackup.getNombre();
                //                regBackup.getTamano();
                System.out.println("BACKUP TERMINADO SE ENVIA MAIL");
                servicioMail.send("dbaseguridad2015@gmail.com",
                        " UNS-Oficina de Tecnología de Información y Comunicaciones-Seguridad de la Información ", " Se ha realizado backup de la Base de Datos correctamente el día " + " "
                        + this.sFecha + " a las " + this.sHora);
                bussy = false;
            } catch (Exception e) {
                this.exception = e;
//                e.printStackTrace();
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);

                servicioMail.send("dbaseguridad2015@gmail.com",
                        " UNS-Oficina de Tecnología de Información y Comunicaciones-Seguridad de la Información ", "No se ha realizado backup de la Base de Datos el día realice el procedimiento de Gestión de Incidencias " + " "
                        + this.sFecha + " a las " + this.sHora + " " + e.toString() + "<br>" + sw.toString());
            }
            if (em0 != null) {
                jpa.close();
            }
            bussy = false;
        }
    }

    private void log(String string) {

        System.out.println(string);
    }

}
