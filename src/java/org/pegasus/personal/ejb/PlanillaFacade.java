package org.pegasus.personal.ejb;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.Func;
import org.jsuns.util.XUtil;
import org.pegasus.personal.jpa.Planilla;
import org.pegasus.personal.jpa.PlanillaPK;

@Stateless
public class PlanillaFacade extends AbstractFacade<Planilla> implements PlanillaFacadeLocal{

    @Override
    public List<Planilla> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        Object anoEje=filters.get("anoEje");
        int mes=XUtil.intValue(filters.get("mes"));
        Query q=getEntityManager().createQuery("SELECT p FROM Planilla p WHERE  "
                + "p.planillaPK.anoEje=:anoEje"+
        (mes>0?" AND p.mes.mesEje=:mes":""))
                .setParameter("anoEje", anoEje);
        if(mes>0)q.setParameter("mes",String.format("%02d",mes));
        return q.getResultList();
    }

    @Override
    public List getResultList(int first, int pageSize, String sortField, Map<String, Object> filters){
        Planilla p=(Planilla) filters.get("planilla");
//        this.getEntityManager().createQuery("SELECT p FROM Planilla p WHERE p.planillaPK.anoEje=:anoEje AND p.secFunc    ");
//        this.getEntityManager().createQuery("SELECT p FROM PlanillaDet d WHERE   ");
        EntityManager em=getEntityManager();
        
        //para dw_inteface_pago
        X.log(em.createQuery("SELECT p.secFunc,t.personal.dni,t.personal.nombComp,t.personal.numCuenta,"
                + "SUM(t.totalIngr-(CASE WHEN t.totalDesc IS NULL THEN 0 ELSE t.totalDesc END)) "
                    + " FROM Planilla p,PlanillaTrab t WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " GROUP BY p.secFunc,t.personal.dni,t.personal.nombComp,t.personal.numCuenta")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList());
        
        List dl=em.createQuery("SELECT p.secFunc,d.planillaDetPK.codigo,'01',SUM(d.monto),d.concepto.glosa,'1' "
                    + " FROM Planilla p,PlanillaTrab t,PlanillaDet d WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje "
                    + " AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente"
                    + " AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
                    + " AND SUBSTRING(d.planillaDetPK.codigo,1,1) IN ('2','3')"
                    + " AND d.planillaDetPK.codigo NOT IN ('2080', '2081', '2082', '2040', '2041', '2042', '2031')"
                    + " GROUP BY p.secFunc,d.planillaDetPK.codigo,d.concepto.glosa HAVING SUM(d.monto)>0")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList();
        String caja="xxx";
        if(!"".equals(caja)){//para el caso de :caja_x 
            List<Object[]> l2=em.createQuery("SELECT p.secFunc,d.planillaDetPK.codigo,t.regPension,SUM(d.monto),t.regPension,'1' "
                    + " FROM Planilla p,PlanillaTrab t,PlanillaDet d WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje "
                    + " AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente"
                    + " AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
                    + " AND d.planillaDetPK.codigo IN ('2040')"
                    + " AND d.monto<>0"
                    + " GROUP BY p.secFunc,d.planillaDetPK.codigo,t.regPension")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList(); 
            l2.addAll(em.createQuery("SELECT p.secFunc,'2041',t.regPension,SUM(d.monto),t.regPension,'1' "
                    + " FROM Planilla p,PlanillaTrab t,PlanillaDet d WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje "
                    + " AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente"
                    + " AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
                    + " AND d.planillaDetPK.codigo IN ('2041','2042')"
                    + " AND d.monto<>0"
                    + " GROUP BY p.secFunc,d.planillaDetPK.codigo,t.regPension")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList());
            l2.addAll(em.createQuery("SELECT p.secFunc,'2040',1,SUM(d.monto),'"+caja+"','1' "
                    + " FROM Planilla p,PlanillaTrab t,PlanillaDet d WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje "
                    + " AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente"
                    + " AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
                    + " AND d.planillaDetPK.codigo IN ('2040','2041','2042')"
                    + " AND d.monto<>0"
                    + " GROUP BY p.secFunc")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList());
            
            for(Object[] m:l2){
                if("21".equals(m[4])){
                    m[4]="AFP INTEGRA";
                }else if("22".equals(m[4])){
                    m[4]="AFP HORIZONTE";
                }else if("23".equals(m[4])){
                    m[4]="AFP PROFUTURO";
                }else if("24".equals(m[4])){
                    m[4]="AFP PRIMA";
                }
            }
            dl.addAll(l2);
        }
        dl.addAll(em.createQuery("SELECT p.secFunc,"
                + "CASE WHEN j.tipoAbono='O' THEN j.judicialObraPK.docudem WHEN j.tipoAbono='C' THEN d.planillaDetPK.codigo END,"
                    + "'01',SUM(d.monto),"
                + "CASE WHEN j.tipoAbono='O' THEN j.cuentaAbono WHEN j.tipoAbono='C' THEN j.nomDeman END,"
                + "CASE WHEN j.tipoAbono='C' THEN '1' WHEN j.tipoAbono='O' THEN '3' END "
                 
                    + " FROM Planilla p,PlanillaTrab t,PlanillaDet d,JudicialObra j WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje "
                    + " AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente"
                    + " AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
                    + " AND d.planillaDetPK.dni=j.judicialObraPK.docuiden AND d.debeGasto=j.judicialObraPK.docudem "
                    + " AND d.planillaDetPK.codigo IN ('2080','2081','2082')"
                    + " AND d.monto<>0"
                    + " GROUP BY p.secFunc,d.planillaDetPK.codigo,j.tipoAbono,j.cuentaAbono,j.nomDeman,j.judicialObraPK.docudem")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList());
        dl.addAll(em.createQuery("SELECT p.secFunc,t.personal.dni,'01',"
                + "SUM(t.totalIngr-(CASE WHEN t.totalDesc IS NULL THEN 0 ELSE t.totalDesc END)),"
                + "CASE WHEN t.personal.tipoPago='2' THEN t.personal.numCuenta ELSE t.personal.nombComp END,"
                + "CASE WHEN t.personal.tipoPago='2' THEN '2' ELSE '1' END "
                    + " FROM Planilla p,PlanillaTrab t WHERE "
                    + " p.planillaPK.anoEje=:anoEje AND p.mes.mesEje=:mes AND p.estado>='3' AND p.selec='S' "
                    + " AND t.planillaTrabPK.anoEje=p.planillaPK.anoEje AND t.planillaTrabPK.nExpediente=p.planillaPK.nExpediente"
                    + " GROUP BY p.secFunc,t.personal.dni,t.personal.tipoPago,t.personal.numCuenta,t.personal.nombComp")
                .setParameter("anoEje", "2015")
                .setParameter("mes", "02").getResultList());
        
        X.log("dl="+dl.size());
        if(p!=null){
            
            
            
            
            
            getEntityManager().createQuery("SELECT t.planilla.fuenteFinanc FROM PlanillaTrab t");
            
            List<Object[]> l=getEntityManager().createQuery(
                    "SELECT "
                            + "'01',"
                            + "t.planillaTrabPK.dni,"
                            + "t.planilla.fuenteFinanc,"
//                                CODIGO	DESCRIPCION 	ESTADO
//                                00	RECURSOS ORDINARIOS           	1
//                                04	CONTRIBUCIONES A FONDOS       	1
//                                09	RECURSOS DIRECTAMENTE RECAUDAD	1
//                                13	DONACIONES Y TRANSFERENCIAS   	1
//                                15	FONDO DE COMPENSACION REGIONAL	1
//                                18	CANON Y SOB.CAN,REG,RENT.AD,PA	1
//                                19	REC.OPERAC.ESPEC.DE CREDITO   	1
                            + "d.ind,"
                                //TIPO 	DESCRIPCION TIPO CONCEPTO REMUNERATIVO
                                //1	INGRESOS 
                                //2	DESCUENTOS 
                                //3	APORTES 
                                //4	REINTEGROS 
                                //5	ENCARGATURAS
                                //6	OTROS INGRESOS 
                                //9	NETO
                            + "d.planillaDetPK.codigo,"
                            // 4c Informacion de Codigos de Conceptos Remunerativos del Aplicativo AIRHSP 
                            + "'pen',"
                            // Informacion de Descripcion de Conceptos Remunerativos del Aplicativo AIRHSP para el Tipo de concepto 1, las descripcion de los demas tipos debe venir desde el aplicativo externo. 
                            + "d.monto "
//                            + ",t.planillaTrabPK.nExpediente "
                            + "FROM PlanillaTrab t,PlanillaDet d WHERE "
                    + "t.planillaTrabPK.anoEje=:anoEje AND t.planillaTrabPK.nExpediente=:nExpediente"
                    + " AND t.planillaTrabPK.anoEje=d.planillaDetPK.anoEje AND t.planillaTrabPK.nExpediente=d.planillaDetPK.nExpediente AND t.planillaTrabPK.dni=d.planillaDetPK.dni "
            )
                    .setParameter("anoEje", p.getPlanillaPK().getAnoEje())
                    .setParameter("nExpediente", p.getPlanillaPK().getNExpediente())
                    .getResultList();
            Object[] head=new Object[]{
                "001102",
                p.getPlanillaPK().getAnoEje(),
                p.getMes().getMesEje(),
                "01",   
//                    01	ACTIVOS
//                    02	PENSIONISTA
//                    03	BENEFICIARIO
//                    04	DESCUENTO JUDICIAL
//                    05	JUDICIAL
//                    99	OTROS

                "01",   //Clase Planilla
//                        Tipo Planilla	Clase 	Descripcion Clase de Planilla 
//                        01	01	HABERES
//                        01	02	CAFAE
//                        01	03	CAS 
//                        01	04	FAG
//                        01	05	CESIGRA
//                        01	06	PRACTICAS PRE PROFESIONALES
//                        02	07	PENSIONISTAS
//                        03	08	OTROS

                "01",   //Correlativo  es dificil porq no existe un correlativo mensual sino anual
                //.txt Nombre del archivo en total contienen 25 caracteres  PLL EEEEEE YYYY MM TT SS CC . TXT
                l.size(),   //cantidad de registros sin incluir cabecera
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("0"),
                new BigDecimal("0")
            };
            for(Object v[]:l){
//            l.stream().forEach((v) -> {
                int ind=XUtil.intValue(v[3]);
                if (ind>0&&ind<7) {
                    head[6+ind]=((BigDecimal)head[6+ind]).add(new BigDecimal(v[6].toString()));
                }
//            });
            }
                l.add(0, head);
            return l;
        }else
            return Collections.EMPTY_LIST;
    }

    @Override
    public void prepare(Planilla entity){
        EntityManager em=this.getEntityManager();
        int n=0;
        try{
            n=XUtil.intValue(em.createQuery("SELECT MAX(SUBSTRING(p.nPlanilla,2,7)) FROM Planilla p WHERE p.planillaPK.anoEje=:anoEje AND SUBSTRING(p.nPlanilla,1,1)='0'")
                .setParameter("anoEje", "2015")
                .getSingleResult());
        }catch(NoResultException e){}
        n++;
        entity.setNPlanilla(String.format("%80d",n));
        entity.setPlanillaPK(new PlanillaPK("2015","1"+String.format("%70d",n)));
        entity.setEstado('2');
        entity.setFechaPlan(Func.getServerDate());
    }
    
    @Override
    public void create(Planilla entity) {
        super.create(entity);
    }
    
}
