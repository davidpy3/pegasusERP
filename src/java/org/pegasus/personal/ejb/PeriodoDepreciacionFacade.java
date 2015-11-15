/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import org.jsuns.util.SimpleException;
import org.jsuns.util.XDate;
import org.jsuns.util.XUtil;
import org.pegasus.patrimonio.jpa.Bien;
import org.pegasus.patrimonio.jpa.DepreciacionBien;
import org.pegasus.patrimonio.jpa.FactorAjuste;
import org.pegasus.patrimonio.jpa.FactorAjustePK;
import org.pegasus.patrimonio.jpa.PeriodoDepreciacion;

@Stateless
public class PeriodoDepreciacionFacade extends AbstractFacade<PeriodoDepreciacion> implements PeriodoDepreciacionFacadeLocal {

    public PeriodoDepreciacionFacade() {
        super(PeriodoDepreciacion.class);
    }

    @Override
    public Object[] find(int first, int pageSize, String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void procesar(PeriodoDepreciacion selected) {

        long ll_cod_periodo;
        Date ld_periodo_ant, ld_periodo_act,ld_fecha_venc, ld_fecha_reg, 
                ld_ini_periodo_act = null;
        String ls_codbien, ls_correla;
        int ll_n_años, ll_año_act, ll_periodo_final,item;
        BigDecimal DEPRE_ACUM1, DEPRE_ACUM2, DEPRE_PER1, DEPRE_PER2;

        if (selected.getEstado() == '0') {
            EntityManager _em = getEntityManager();
            List<PeriodoDepreciacion> dw_1 =_em.createQuery("SELECT o FROM PeriodoDepreciacion o "
                    + " ORDER BY o.periodo DESC", PeriodoDepreciacion.class).setMaxResults(2).getResultList();
            
            //************* Eliminando los calculos de Depreciacion del periodo ****************
            ll_cod_periodo = selected.getCodPeriodo();
            _em.createQuery("UPDATE DepreciacionBien d SET d.estado='0'").executeUpdate();
            _em.createQuery("DELETE FROM DepreciacionBien d "
                    + "WHERE d.depreciacionBienePK.codPeriodo=:codPeriodo")
                    .setParameter("codPeriodo", ll_cod_periodo).executeUpdate();

            //***********************************************************************************
            if (dw_1.size() > 1) {
                ld_periodo_act = dw_1.get(0).getPeriodo();
                ld_periodo_ant = dw_1.get(1).getPeriodo();
                Calendar c = Calendar.getInstance();
                ld_ini_periodo_act = new Date(XDate.addDays(ld_periodo_ant.getTime(), 1));
            } else {
                ld_periodo_act = selected.getPeriodo();
            }
            List<Bien> dw_2 = _em.createQuery("SELECT b FROM Bien b "
                    + "WHERE b.tipoCta=:tipoCta AND b.estBien=:estBien "
                    + "AND b.srp=:srp AND b.fecReg<=:fecReg", Bien.class)
                    .setParameter("tipoCta", 'A')
                    .setParameter("estBien", 'A')
                    .setParameter("srp", '1')
                    .setParameter("fecReg", ld_periodo_act).getResultList();
            
            for (Bien bien : dw_2) {
                ls_codbien = bien.getBienPK().getCodbien();
                ls_correla = bien.getBienPK().getCorrela();
                Calendar c = Calendar.getInstance();
                c.setTime(bien.getFecReg());
                c.add(Calendar.YEAR, new BigDecimal("100")
                        .divide(bien.getCuentac().getProcentDepre(), 3, RoundingMode.CEILING).intValue());
                ld_fecha_venc = c.getTime();
                //XDate.getDate( XDate.getYear( fec_reg ) +  c_vida_util, XDate.getMonth( fec_reg ),day( fec_reg ) )
                ld_fecha_reg = bien.getFecReg();
                List<DepreciacionBien> dw_3 = _em.createQuery("SELECT d FROM DepreciacionBien d WHERE d.depreciacionBienePK.codBien=:codBien AND d.depreciacionBienePK.correla=:correlativo")
                        .setParameter("codBien", ls_codbien)
                        .setParameter("correlativo", ls_correla)
                        .getResultList();
                item = dw_3.size() + 1;
                if (!ld_fecha_venc.after(ld_periodo_act)) {/*El bien ya vencio*/

                    if (dw_3.isEmpty()) { //No tiene depreacion en la DB
                        ll_n_años = (XDate.getYear(ld_fecha_venc) - XDate.getYear(ld_fecha_reg)) + 1;
                        ll_año_act = XDate.getYear(ld_fecha_reg);
                        for (int i = 1; i <= ll_n_años; i++) {
                            DepreciacionBien db = new DepreciacionBien(
                                    ll_cod_periodo,
                                    ls_codbien,
                                    ls_correla,
                                    i
                            );
                            db.setAno("" + ll_año_act);
                            db.setCuenta(bien.getCuentac().getCuenta());
                            db.setFechaCompra(bien.getFecReg());
                            if (i == 1) {
                                db.setFechaOrigen(bien.getFecReg());
                                db.setFechaFinal(new Date((int) ll_año_act, 12, 31));
                                db.setValorLibros(bien.getValorlibro());
                                db.setPeriodo(XDate.getMonth(bien.getFecReg()));
                                db.setFactorAjuste(
                                        wf_get_factor(XDate.getYear(bien.getFecReg()),
                                                XDate.getMonth(bien.getFecReg()))); //usando el factor del mes

                            } else if (i == ll_n_años) {
                                db.setFechaOrigen(XDate.getDate((int) ll_año_act, 1, 1));
                                c = Calendar.getInstance();
                                c.setTime(ld_fecha_venc);
                                c.add(Calendar.DAY_OF_YEAR, -1);
                                db.setFechaFinal(c.getTime());
                                db.setValorLibros(db.getValorActualizado());
//                                db.setPeriodo(12*);
                                db.setPeriodo(12 * bien.getVidaUtil()); //db.getPeriodo() + 12 
                                db.setFactorAjuste(wf_get_factor(XDate.getYear(db.getFechaFinal()), 14));
//usando el factor del año

                            } else {
                                db.setFechaOrigen(XDate.getDate((int) ll_año_act, 01, 01));
                                db.setFechaFinal(XDate.getDate((int) ll_año_act, 12, 31));
                                db.setValorLibros(db.getValorActualizado());
                                db.setPeriodo(db.getPeriodo() + 12);
                                db.setFactorAjuste(wf_get_factor(XDate.getYear(db.getFechaFinal()), 14)); //usando el factor del año
                            }

                            db.setMes("" + XDate.getMonth(db.getFechaFinal()));
                            db.setValorActualizado(db.getValorLibros().multiply(db.getFactorAjuste()));
                            db.setDiferenciaAjuste(db.getValorLibros().subtract(db.getValorActualizado()).abs());
                            db.setTasa(bien.getCuentac().getProcentDepre());
                            if (i == 1) {
                                db.setDeprePerLibros(wf_depreciacion_parcial(db.getFechaOrigen(),
                                        db.getFechaFinal(),
                                        db.getTasa(),
                                        db.getValorLibros()));
                                db.setDeprePerActual(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                        db.getTasa(), db.getValorActualizado()));
                                db.setDeprePerDiferencia(db.getDeprePerLibros().subtract(db.getDeprePerActual()).abs());
                                db.setDepreActLibros(db.getDeprePerLibros());
                                db.setDepreActActual(db.getDeprePerActual());
                                db.setDepreActDiferencia(db.getDepreActLibros().subtract(db.getDepreActActual()));
                                db.setValorNeto(db.getValorActualizado().subtract(db.getDeprePerLibros()));
                            } else {
                                db.setDeprePerLibros(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                        db.getTasa(), db.getValorLibros()));
                                db.setDeprePerActual(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                        db.getTasa(), db.getValorActualizado()));
                                db.setDeprePerDiferencia(db.getDeprePerLibros().subtract(db.getDeprePerActual()).abs());
                                db.setDepreActLibros(db.getDeprePerLibros().add(db.getDepreActLibros()));
                                db.setDepreActActual(db.getDeprePerActual().add(db.getDepreActActual()));
                                db.setDepreActDiferencia(db.getDepreActLibros().subtract(db.getDepreActActual()).abs()); //							IF db.periodo[ll_fila_act] >= bien.getVidaUtil()*12){
                                db.setValorNeto(db.getValorActualizado().subtract(db.getDepreActLibros()));
                            }
                            _em.persist(db);
                            ll_año_act = ll_año_act + 1;
                        }
                    } else { //Tiene depreaciones anteriores en la DB
                        //VENCE EN EL PERIODO
                        if(ld_ini_periodo_act.before(ld_fecha_venc)&&
                                ld_fecha_venc.before(ld_periodo_act)) {
//El bien ha vencido dentro del periodo
                            ll_año_act = XDate.getYear(ld_periodo_act);
                            item = dw_3.size() + 1;
                            DepreciacionBien db = new DepreciacionBien(
                                    ll_cod_periodo,
                                    ls_codbien,
                                    ls_correla,
                                    item
                            );
                            db.setFechaCompra(bien.getFecReg());
                            db.setAno("" + ll_año_act);
                            db.setMes("" + XDate.getMonth(bien.getFechaVenc()));
                            db.setFechaOrigen(ld_ini_periodo_act);
                            db.setFechaFinal(ld_periodo_act);
                            db.setCuenta(bien.getCuenta());

                            db.setValorLibros(db.getValorActualizado());
                            db.setFactorAjuste(wf_get_factor(XDate.getYear(db.getFechaFinal()), 14)); //usando el factor del año

                            db.setValorActualizado(db.getValorLibros().multiply(db.getFactorAjuste()));

                            db.setDiferenciaAjuste(db.getValorLibros().subtract(db.getValorActualizado()).abs());
                            db.setPeriodo(bien.getVidaUtil() * 12);
                            db.setTasa(bien.getCuentac().getProcentDepre());
                            db.setDeprePerLibros(wf_depreciacion_parcial(db.getFechaOrigen(), bien.getFechaVenc(),
                                    db.getTasa(), db.getValorLibros()));
                            db.setDeprePerActual(wf_depreciacion_parcial(db.getFechaOrigen(), bien.getFechaVenc(),
                                    db.getTasa(), db.getValorActualizado()));
                            db.setDeprePerDiferencia(db.getDeprePerLibros().subtract(db.getDeprePerActual()).abs());

                            db.setDepreActLibros(db.getDeprePerLibros().add(db.getDepreActLibros()));
                            db.setDepreActActual(db.getDeprePerActual().add(db.getDepreActActual()));
                            db.setDepreActDiferencia(db.getDepreActLibros().subtract(db.getDepreActActual()).abs());
                            db.setValorNeto(db.getValorActualizado().subtract(db.getDepreActLibros()));
                            _em.persist(db);
                        }

                    }

                } else { /*El bien aun no vence*/
                    if (dw_3.isEmpty()) {
                        /*El bien no tiene depreciaciones en la base de datos*/
                        ll_n_años = (XDate.getYear(ld_periodo_act) - XDate.getYear(ld_fecha_reg)) + 1;
                        ll_año_act = XDate.getYear(ld_fecha_reg);
                        DEPRE_ACUM1 = BigDecimal.ZERO;
                        DEPRE_ACUM2 = BigDecimal.ZERO;
                        for (int i = 1; i <= ll_n_años; i++) {
                            DepreciacionBien db = new DepreciacionBien(
                                    ll_cod_periodo,
                                    ls_codbien,
                                    ls_correla,
                                    i
                            );
                            db.setAno("" + ll_año_act);
                            db.setCuenta(bien.getCuenta());
                            db.setFechaCompra(bien.getFecReg());
                            if (i == 1) {
                                db.setFechaOrigen(bien.getFecReg());
                                if (ll_año_act == XDate.getYear(ld_periodo_act)) {
                                    db.setFechaFinal(ld_periodo_act);
                                } else {
                                    db.setFechaFinal(XDate.getDate((int) ll_año_act, 12, 31));
                                }
                                db.setValorLibros(bien.getValorlibro());
                                db.setPeriodo(12 - XDate.getMonth(bien.getFecReg()) + 1);
                            } else if (i == ll_n_años) {
                                db.setFechaOrigen(XDate.getDate((int) ll_año_act, 01, 01));
                                db.setFechaFinal(ld_periodo_act);
                                db.setValorLibros(db.getValorActualizado());
                                db.setPeriodo(db.getPeriodo() + XDate.getMonth(ld_periodo_act) - XDate.getMonth(ld_ini_periodo_act) + 1);
                            } else {
                                db.setFechaOrigen(XDate.getDate(ll_año_act, 01, 01));
                                db.setFechaFinal(XDate.getDate(ll_año_act, 12, 31));
                                db.setValorLibros(db.getValorActualizado());
                                db.setPeriodo(db.getPeriodo() + XDate.getMonth(ld_periodo_act) - XDate.getMonth(ld_ini_periodo_act) + 1);
                            }
                            db.setMes("" + XDate.getMonth(db.getFechaFinal()));
                            db.setFactorAjuste(wf_get_factor(XDate.getYear(db.getFechaFinal()), 14)); //usando el factor del año

                            db.setValorActualizado(db.getValorLibros().multiply(db.getFactorAjuste()));

                            db.setDiferenciaAjuste(db.getValorLibros().subtract(db.getValorActualizado()).abs());
                            db.setTasa(bien.getCuentac().getProcentDepre());

                            db.setDeprePerLibros(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                    db.getTasa(), db.getValorLibros()));

                            db.setDeprePerActual(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                    db.getTasa(), db.getValorActualizado()));

                            db.setDeprePerDiferencia(db.getDeprePerLibros().subtract(db.getDeprePerActual()).abs());

                            DEPRE_PER1 = db.getDeprePerLibros();
                            DEPRE_PER2 = db.getDeprePerActual();
                            db.setDepreActLibros(DEPRE_PER1.add(DEPRE_ACUM1));
                            db.setDepreActActual(DEPRE_PER2.add(DEPRE_ACUM2));
                            db.setDepreActDiferencia(db.getDepreActLibros().subtract(db.getDepreActActual()).abs());
                            if (db.getPeriodo()> bien.getVidaUtil() * 12) {
                                db.setPeriodo(bien.getVidaUtil() * 12);
                                db.setValorNeto(BigDecimal.ZERO);
                            } else {
                                db.setValorNeto(db.getValorActualizado().subtract(db.getDepreActLibros()));
                            }
                            DEPRE_ACUM1 = db.getDepreActLibros();
                            DEPRE_ACUM2 = db.getDepreActActual();
                            ll_año_act = ll_año_act + 1;
                            _em.persist(db);
                        }

//				}
                    } else {//******************************* El bien  tiene depreciaciones en la base de datos, AGREGAR UTLIMO REGISTRO	*******************	
                        item = dw_3.size() + 1;
                        ll_año_act = XDate.getYear(ld_periodo_act);
                        DepreciacionBien db = new DepreciacionBien(
                                ll_cod_periodo,
                                ls_codbien,
                                ls_correla,
                                (int) item
                        );
                        db.setAno("" + ll_año_act);
                        db.setFechaCompra(bien.getFecReg());
                        db.setFechaOrigen(ld_ini_periodo_act);//bien.getFecReg()
                        db.setFechaFinal(ld_periodo_act);
                        db.setMes("" + XDate.getMonth(db.getFechaFinal()));
                        db.setCuenta(bien.getCuenta());
                        db.setValorLibros(db.getValorActualizado());
                        db.setFactorAjuste(wf_get_factor(XDate.getYear(db.getFechaFinal()), 14)); //usando el factor del año
                        db.setValorActualizado(db.getValorLibros().multiply(db.getFactorAjuste()));

                        db.setDiferenciaAjuste(db.getValorLibros().subtract(db.getValorActualizado()).abs());
                        db.setPeriodo(db.getPeriodo() + XDate.getMonth(ld_periodo_act) - XDate.getMonth(ld_ini_periodo_act) + 1);

                        db.setTasa(bien.getCuentac().getProcentDepre());

                        db.setDeprePerLibros(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                db.getTasa(), db.getValorLibros()));

                        db.setDeprePerActual(wf_depreciacion_parcial(db.getFechaOrigen(), db.getFechaFinal(),
                                db.getTasa(), db.getValorActualizado()));

                        db.setDeprePerDiferencia(db.getDeprePerLibros().subtract(db.getDeprePerActual()).abs());
                        db.setDepreActLibros(db.getDeprePerLibros().add(db.getDepreActLibros()));
                        db.setDepreActActual(db.getDeprePerActual().add(db.getDepreActActual()));
                        db.setDepreActDiferencia(db.getDepreActLibros().subtract(db.getDepreActActual()).abs());
                        if (db.getPeriodo() > bien.getVidaUtil() * 12) {
                            db.setPeriodo(bien.getVidaUtil() * 12);
                            db.setValorNeto(BigDecimal.ZERO);
                        } else {
                            db.setValorNeto(db.getValorActualizado().subtract(db.getDepreActLibros()));
                        }
                        _em.persist(db);
                    } //**** aun no vence
                }
                _em.createQuery("UPDATE DepreciacionBien d SET d.estado='1' "
                        + "WHERE d.depreciacionBienePK.codBien=:codBien "
                        + "AND d.depreciacionBienePK.correla=:correlativo")
                        .setParameter("codBien", ls_codbien)
                        .setParameter("correlativo", ls_correla)
                        .executeUpdate();
            } // Recorrido de Mbienes
        } else {
            throw new SimpleException("No se pueden Procesar Periodos que ya han sido Cerrados, Verifique?");
        }
    }

    private BigDecimal wf_get_factor(int as_anoeje, int mesEje) {
        FactorAjustePK factorAjustePK = new FactorAjustePK("" + as_anoeje, "" + mesEje);
        BigDecimal ldc_factor = null;
        int anio = XUtil.intValue(as_anoeje);
        if (anio < 1991) {
            ldc_factor = new BigDecimal("0.901");
        } else if (anio >= 1991 && anio <= 2004) {
            List<FactorAjuste> lf = getEntityManager().createQuery("SELECT f FROM FactorAjuste f "
                    + "WHERE f.factorAjustePK=:factorAjustePK", FactorAjuste.class)
                    .setParameter("factorAjustePK", factorAjustePK).getResultList();
            //messagebox("aviso2", string(as_anoeje) + '-->' + string(as_meseje))
//            ds_factor.retrieve(as_anoeje, string(integer(as_meseje), '00'))
            if (lf.size() > 0) {
                ldc_factor = lf.get(0).getFactor();
            }
        } else if (anio > 2004) {
            ldc_factor = BigDecimal.ONE;
        }
        return ldc_factor;
    }

    @Override
    public void cerrar(PeriodoDepreciacion pd) {
        pd.setEstado('1');
//        pd.setUserCierre(X.getUser().);//dni
//        pd.setFechaCierre(f_fechasvr());
        edit(pd);
        throw new RuntimeException("No terminado!");
    }

    private BigDecimal wf_depreciacion_parcial(Date fechaOrigen, Date fechaFinal, BigDecimal as_tasa, BigDecimal as_valor) {
//ll_dia_ini = day(as_fecha)
//ll_mes = month(as_fecha)
        int ll_año = XDate.getYear(fechaFinal);
//ll_mes2 = month(as_fecha_fin)
//ll_dia_fin = diasxmes(ll_mes, ll_año)
//************ Depreciacion Diaria *************
//ll_ndias = ll_dia_fin - (ll_dia_ini )
        int ll_ndias = XDate.getDaysDiff(fechaOrigen.getTime(), fechaFinal.getTime()) + 1;
        return as_tasa.multiply(as_valor)
                .multiply(new BigDecimal(ll_ndias))
                .divide(new BigDecimal(ll_año % 4 == 0 ? 36600 : 36500))
                .setScale(2, BigDecimal.ROUND_HALF_UP);

//messagebox("depre dias", string(ll_ndias) + "val: " + string(ldc_depre_dias))
//************** Depreciacion mensual *******
//ll_nmeses = ll_mes2 - ll_mes
//
//ldc_depre_meses = round((ll_nmeses*(as_tasa/1200)*as_valor), 2)
//messagebox("depre mes", string(ll_nmeses) + "val: " + string(ldc_depre_meses))
//**************** Depreciacion Parcial Total ************
        // + ldc_depre_meses
    }

}
