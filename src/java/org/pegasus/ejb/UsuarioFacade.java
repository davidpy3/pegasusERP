package org.pegasus.ejb;

import java.util.Locale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.jsuns.X;
import org.jsuns.app.User;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.Encrypter;
import org.jsuns.util.XUtil;
import org.pegasus.jpa.Usuario;
import org.pegasus.jpa.UsuarioPK;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @Override
    public Usuario login(String name, String pass) {
        X.log("user=" + name + ";pass=" + pass);
        EntityManager em = getEntityManager();
        String ss = "";
        for (char c : pass.toUpperCase().toCharArray()) {
            int i = (255 - (int) c);
//                    if(i>0&&i<224)
            ss = (char) i + ss;
        }
        /* for(Object d:em.createQuery("select "
         + "u from Usuario u").getResultList()){
         if(d!=null){
         Usuario u=(Usuario) d;
         String ss="";
         if(u.getClave()!=null)
         for(char c:u.getClave().toCharArray()){
         int i=(255-(int)c);
         if(i>0&&i<224)
         ss=(char)i+ss;
         }
                
         System.out.println(u.getUsuario()+">"+ss);
         }
         }*/

        Usuario u = null;
        try {
            u = em.createQuery("SELECT u from Usuario u WHERE u.usuario=:user AND u.clave=:pass AND u.usuarioPK.anoEje='2015'",
                    Usuario.class)
                    .setParameter("user", name.toUpperCase())
                    .setParameter("pass", ss).getSingleResult();
//            em.createQuery("UPDATE FxaEstudiante e SET e.passEnc=:pass")
//                            .setParameter("pass",new Encrypter().encode(Encrypter.SHA1,"holamundo")).executeUpdate();
        } catch (Exception e) {
//            e.printStackTrace();
        }      
        if (u == null) {
            Object row[] = null;
            int codigo = XUtil.intValue(name);
            if (codigo > 0) {
                try {
                    row = (Object[]) em.createQuery("SELECT " + X.FXA_ESTUDIANTE + ",e.codigoEstudiante,e.personaNatural.idDir,e.idAcexp FROM FxaEstudiante e WHERE e.passEnc=:pass AND (e.codigoEstudiante=:codigo OR e.personaNatural.numeroPndid=:codigo)")
                            .setParameter("codigo","0"+codigo)
                            .setParameter("pass",new Encrypter().encode(Encrypter.SHA1, pass))
                            .getSingleResult();
                } catch (Exception e) {
                    e.printStackTrace();//0198711014
                }
            }
            if (row == null) {
                try {
                    codigo = XUtil.intValue(name);
                    if (codigo > 0) {
                        row = (Object[])em.createNativeQuery("SELECT " + X.PSP_USUARIO + ",id_user,id_dir,uid FROM psp_usuario WHERE psp_usuario.id_tarjeta=:id_card AND psp_usuario.pwd=:pwd AND psp_usuario.std_uid=1").
                                setParameter("id_card", codigo).setParameter("pwd", Encrypter.encode(pass)).getSingleResult();
                    } else {
                        row = (Object[])em.createNativeQuery("SELECT " + X.PSP_USUARIO + ",id_user,id_dir,uid FROM psp_usuario WHERE upper(psp_usuario.id_user)=upper(:id_user) AND psp_usuario.pwd=:pwd AND psp_usuario.std_uid=1").
                                setParameter("id_user", name).setParameter("pwd", Encrypter.encode(pass)).getSingleResult();
                    }
                } catch (NoResultException nn) {
                }
            }
            if(row==null)return null;
            int uid = XUtil.intValue(row[0]);
                int id_dir = XUtil.intValue(row[2]);
                //Si el usuario esta registrado se recupera usando jpa
                if (uid > 0) {
//                    u = em.find(User.class, uid);
                   
                } else {
                    User account = null;
                    if (id_dir > 0) {
                        try {
                            em.refresh(account = (User)em.createNamedQuery(User.class.getSimpleName() 
                                    + ".findByIdDir").setParameter("idDir", id_dir).getSingleResult());
                        } catch (Exception ee) {
                        }
                    }
                    if (account != null) {
//                        name = account;
                    } else {
//                        u = new User(uid, (String) row[1]);
                        u=new Usuario();
                        u.setUsuarioPK(new UsuarioPK("0",""+id_dir));
                        u.setUsuario((String)row[1]);
                    }
                }

        }
        X.log("user=" + u);
        return u;

    }

}
