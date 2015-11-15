/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_deju_declaracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscDejuDeclaracion.findAll", query = "SELECT e FROM EscDejuDeclaracion e"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIdDec", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.idDec = :idDec"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIdEsc", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.idEsc = :idEsc"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEntidad", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.entidad = :entidad"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireccion", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEjerPre", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ejerPre = :ejerPre"),
    @NamedQuery(name = "EscDejuDeclaracion.findByCargo", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "EscDejuDeclaracion.findByFechaAsume", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.fechaAsume = :fechaAsume"),
    @NamedQuery(name = "EscDejuDeclaracion.findByFechaCese", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.fechaCese = :fechaCese"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTiempoServ", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tiempoServ = :tiempoServ"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAlInicio", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.alInicio = :alInicio"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbPu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbPu = :rbPu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbPr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbPr = :rbPr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbTot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbTot = :rbTot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbiPu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbiPu = :rbiPu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbiPr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbiPr = :rbiPr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRbiTot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.rbiTot = :rbiTot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim1Pu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim1Pu = :oim1Pu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim1Pr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim1Pr = :oim1Pr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim1Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim1Tot = :oim1Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim2Pu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim2Pu = :oim2Pu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim2Pr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim2Pr = :oim2Pr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim2Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim2Tot = :oim2Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim3Pu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim3Pu = :oim3Pu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim3Pr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim3Pr = :oim3Pr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOim3Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.oim3Tot = :oim3Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien1 = :tipBien1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien1 = :direBien1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha1 = :numFicha1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval1 = :autoval1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien2 = :tipBien2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien2 = :direBien2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha2 = :numFicha2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval2 = :autoval2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien3 = :tipBien3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien3 = :direBien3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha3 = :numFicha3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval3 = :autoval3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien4 = :tipBien4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien4 = :direBien4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha4 = :numFicha4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval4 = :autoval4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien5 = :tipBien5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien5 = :direBien5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha5 = :numFicha5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval5 = :autoval5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByTipBien6", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.tipBien6 = :tipBien6"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDireBien6", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.direBien6 = :direBien6"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumFicha6", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numFicha6 = :numFicha6"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAutoval6", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.autoval6 = :autoval6"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehi1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehi1 = :vehi1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiMarca1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiMarca1 = :vehiMarca1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiPlaca1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiPlaca1 = :vehiPlaca1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiValor1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiValor1 = :vehiValor1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehi2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehi2 = :vehi2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiMarca2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiMarca2 = :vehiMarca2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiPlaca2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiPlaca2 = :vehiPlaca2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiValor2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiValor2 = :vehiValor2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehi3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehi3 = :vehi3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiMarca3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiMarca3 = :vehiMarca3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiPlaca3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiPlaca3 = :vehiPlaca3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiValor3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiValor3 = :vehiValor3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehi4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehi4 = :vehi4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiMarca4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiMarca4 = :vehiMarca4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiPlaca4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiPlaca4 = :vehiPlaca4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVehiValor4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.vehiValor4 = :vehiValor4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEf1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ef1 = :ef1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIf1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.if1 = :if1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVal1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.val1 = :val1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEf2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ef2 = :ef2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIf2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.if2 = :if2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVal2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.val2 = :val2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEf3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ef3 = :ef3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIf3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.if3 = :if3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVal3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.val3 = :val3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEf4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ef4 = :ef4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIf4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.if4 = :if4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVal4", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.val4 = :val4"),
    @NamedQuery(name = "EscDejuDeclaracion.findByEf5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.ef5 = :ef5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIf5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.if5 = :if5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByVal5", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.val5 = :val5"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein1 = :dein1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein1Pu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein1Pu = :dein1Pu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein1Pr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein1Pr = :dein1Pr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein1Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein1Tot = :dein1Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein2 = :dein2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein2Pu", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein2Pu = :dein2Pu"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein2Pr", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein2Pr = :dein2Pr"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDein2Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dein2Tot = :dein2Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi1 = :debi1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi1Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi1Tot = :debi1Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi2 = :debi2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi2Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi2Tot = :debi2Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi3 = :debi3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDebi3Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.debi3Tot = :debi3Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre1", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre1 = :acre1"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre1Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre1Tot = :acre1Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre2", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre2 = :acre2"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre2Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre2Tot = :acre2Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre3", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre3 = :acre3"),
    @NamedQuery(name = "EscDejuDeclaracion.findByAcre3Tot", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.acre3Tot = :acre3Tot"),
    @NamedQuery(name = "EscDejuDeclaracion.findByNumPerDep", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.numPerDep = :numPerDep"),
    @NamedQuery(name = "EscDejuDeclaracion.findByFechaElab", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.fechaElab = :fechaElab"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOtraInfo", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.otraInfo = :otraInfo"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOtraInfoTotal", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.otraInfoTotal = :otraInfoTotal"),
    @NamedQuery(name = "EscDejuDeclaracion.findByConDni", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.conDni = :conDni"),
    @NamedQuery(name = "EscDejuDeclaracion.findByConApaterno", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.conApaterno = :conApaterno"),
    @NamedQuery(name = "EscDejuDeclaracion.findByConAmaterno", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.conAmaterno = :conAmaterno"),
    @NamedQuery(name = "EscDejuDeclaracion.findByConNombre", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.conNombre = :conNombre"),
    @NamedQuery(name = "EscDejuDeclaracion.findByConRuc", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.conRuc = :conRuc"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIdMov", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.idMov = :idMov"),
    @NamedQuery(name = "EscDejuDeclaracion.findByIdDtra", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscDejuDeclaracion.findByBonificaciones", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.bonificaciones = :bonificaciones"),
    @NamedQuery(name = "EscDejuDeclaracion.findByRemuneracion", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.remuneracion = :remuneracion"),
    @NamedQuery(name = "EscDejuDeclaracion.findByHonorarios", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.honorarios = :honorarios"),
    @NamedQuery(name = "EscDejuDeclaracion.findByGratificaciones", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.gratificaciones = :gratificaciones"),
    @NamedQuery(name = "EscDejuDeclaracion.findByUtilidades", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.utilidades = :utilidades"),
    @NamedQuery(name = "EscDejuDeclaracion.findByDietas", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.dietas = :dietas"),
    @NamedQuery(name = "EscDejuDeclaracion.findByOtros", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.otros = :otros"),
    @NamedQuery(name = "EscDejuDeclaracion.findByActivo", query = "SELECT e FROM EscDejuDeclaracion e WHERE e.activo = :activo")})
public class EscDejuDeclaracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dec")
    private Integer idDec;
    @Column(name = "id_esc")
    private Integer idEsc;
    @Column(name = "entidad")
    private String entidad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ejer_pre")
    private String ejerPre;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "fecha_asume")
    @Temporal(TemporalType.DATE)
    private Date fechaAsume;
    @Column(name = "fecha_cese")
    @Temporal(TemporalType.DATE)
    private Date fechaCese;
    @Column(name = "tiempo_serv")
    private String tiempoServ;
    @Column(name = "al_inicio")
    private Integer alInicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rb_pu")
    private BigDecimal rbPu;
    @Column(name = "rb_pr")
    private BigDecimal rbPr;
    @Column(name = "rb_tot")
    private BigDecimal rbTot;
    @Column(name = "rbi_pu")
    private BigDecimal rbiPu;
    @Column(name = "rbi_pr")
    private BigDecimal rbiPr;
    @Column(name = "rbi_tot")
    private BigDecimal rbiTot;
    @Column(name = "oim_1_pu")
    private BigDecimal oim1Pu;
    @Column(name = "oim_1_pr")
    private BigDecimal oim1Pr;
    @Column(name = "oim_1_tot")
    private BigDecimal oim1Tot;
    @Column(name = "oim_2_pu")
    private BigDecimal oim2Pu;
    @Column(name = "oim_2_pr")
    private BigDecimal oim2Pr;
    @Column(name = "oim_2_tot")
    private BigDecimal oim2Tot;
    @Column(name = "oim_3_pu")
    private BigDecimal oim3Pu;
    @Column(name = "oim_3_pr")
    private BigDecimal oim3Pr;
    @Column(name = "oim_3_tot")
    private BigDecimal oim3Tot;
    @Column(name = "tip_bien1")
    private String tipBien1;
    @Column(name = "dire_bien1")
    private String direBien1;
    @Column(name = "num_ficha1")
    private String numFicha1;
    @Column(name = "autoval_1")
    private BigDecimal autoval1;
    @Column(name = "tip_bien2")
    private String tipBien2;
    @Column(name = "dire_bien2")
    private String direBien2;
    @Column(name = "num_ficha2")
    private String numFicha2;
    @Column(name = "autoval_2")
    private BigDecimal autoval2;
    @Column(name = "tip_bien3")
    private String tipBien3;
    @Column(name = "dire_bien3")
    private String direBien3;
    @Column(name = "num_ficha3")
    private String numFicha3;
    @Column(name = "autoval_3")
    private BigDecimal autoval3;
    @Column(name = "tip_bien4")
    private String tipBien4;
    @Column(name = "dire_bien4")
    private String direBien4;
    @Column(name = "num_ficha4")
    private String numFicha4;
    @Column(name = "autoval_4")
    private BigDecimal autoval4;
    @Column(name = "tip_bien5")
    private String tipBien5;
    @Column(name = "dire_bien5")
    private String direBien5;
    @Column(name = "num_ficha5")
    private String numFicha5;
    @Column(name = "autoval_5")
    private BigDecimal autoval5;
    @Column(name = "tip_bien6")
    private String tipBien6;
    @Column(name = "dire_bien6")
    private String direBien6;
    @Column(name = "num_ficha6")
    private String numFicha6;
    @Column(name = "autoval_6")
    private BigDecimal autoval6;
    @Column(name = "vehi_1")
    private String vehi1;
    @Column(name = "vehi_marca_1")
    private String vehiMarca1;
    @Column(name = "vehi_placa_1")
    private String vehiPlaca1;
    @Column(name = "vehi_valor_1")
    private BigDecimal vehiValor1;
    @Column(name = "vehi_2")
    private String vehi2;
    @Column(name = "vehi_marca_2")
    private String vehiMarca2;
    @Column(name = "vehi_placa_2")
    private String vehiPlaca2;
    @Column(name = "vehi_valor_2")
    private BigDecimal vehiValor2;
    @Column(name = "vehi_3")
    private String vehi3;
    @Column(name = "vehi_marca_3")
    private String vehiMarca3;
    @Column(name = "vehi_placa_3")
    private String vehiPlaca3;
    @Column(name = "vehi_valor_3")
    private BigDecimal vehiValor3;
    @Column(name = "vehi_4")
    private String vehi4;
    @Column(name = "vehi_marca_4")
    private String vehiMarca4;
    @Column(name = "vehi_placa_4")
    private String vehiPlaca4;
    @Column(name = "vehi_valor_4")
    private BigDecimal vehiValor4;
    @Column(name = "ef_1")
    private String ef1;
    @Column(name = "if_1")
    private String if1;
    @Column(name = "val_1")
    private BigDecimal val1;
    @Column(name = "ef_2")
    private String ef2;
    @Column(name = "if_2")
    private String if2;
    @Column(name = "val_2")
    private BigDecimal val2;
    @Column(name = "ef_3")
    private String ef3;
    @Column(name = "if_3")
    private String if3;
    @Column(name = "val_3")
    private BigDecimal val3;
    @Column(name = "ef_4")
    private String ef4;
    @Column(name = "if_4")
    private String if4;
    @Column(name = "val_4")
    private BigDecimal val4;
    @Column(name = "ef_5")
    private String ef5;
    @Column(name = "if_5")
    private String if5;
    @Column(name = "val_5")
    private BigDecimal val5;
    @Column(name = "dein_1")
    private String dein1;
    @Column(name = "dein_1_pu")
    private BigDecimal dein1Pu;
    @Column(name = "dein_1_pr")
    private BigDecimal dein1Pr;
    @Column(name = "dein_1_tot")
    private BigDecimal dein1Tot;
    @Column(name = "dein_2")
    private String dein2;
    @Column(name = "dein_2_pu")
    private BigDecimal dein2Pu;
    @Column(name = "dein_2_pr")
    private BigDecimal dein2Pr;
    @Column(name = "dein_2_tot")
    private BigDecimal dein2Tot;
    @Column(name = "debi_1")
    private String debi1;
    @Column(name = "debi_1_tot")
    private BigDecimal debi1Tot;
    @Column(name = "debi_2")
    private String debi2;
    @Column(name = "debi_2_tot")
    private BigDecimal debi2Tot;
    @Column(name = "debi_3")
    private String debi3;
    @Column(name = "debi_3_tot")
    private BigDecimal debi3Tot;
    @Column(name = "acre_1")
    private String acre1;
    @Column(name = "acre_1_tot")
    private BigDecimal acre1Tot;
    @Column(name = "acre_2")
    private String acre2;
    @Column(name = "acre_2_tot")
    private BigDecimal acre2Tot;
    @Column(name = "acre_3")
    private String acre3;
    @Column(name = "acre_3_tot")
    private BigDecimal acre3Tot;
    @Column(name = "num_per_dep")
    private Integer numPerDep;
    @Column(name = "fecha_elab")
    @Temporal(TemporalType.DATE)
    private Date fechaElab;
    @Column(name = "otra_info")
    private String otraInfo;
    @Column(name = "otra_info_total")
    private BigDecimal otraInfoTotal;
    @Column(name = "con_dni")
    private String conDni;
    @Column(name = "con_apaterno")
    private String conApaterno;
    @Column(name = "con_amaterno")
    private String conAmaterno;
    @Column(name = "con_nombre")
    private String conNombre;
    @Column(name = "con_ruc")
    private String conRuc;
    @Column(name = "id_mov")
    private String idMov;
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "bonificaciones")
    private BigDecimal bonificaciones;
    @Column(name = "remuneracion")
    private BigDecimal remuneracion;
    @Column(name = "honorarios")
    private BigDecimal honorarios;
    @Column(name = "gratificaciones")
    private BigDecimal gratificaciones;
    @Column(name = "utilidades")
    private BigDecimal utilidades;
    @Column(name = "dietas")
    private BigDecimal dietas;
    @Column(name = "otros")
    private BigDecimal otros;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne
    private EscDejuPeriodo idPeriodo;

    public EscDejuDeclaracion() {
    }

    public EscDejuDeclaracion(Integer idDec) {
        this.idDec = idDec;
    }

    public Integer getIdDec() {
        return idDec;
    }

    public void setIdDec(Integer idDec) {
        this.idDec = idDec;
    }

    public Integer getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEjerPre() {
        return ejerPre;
    }

    public void setEjerPre(String ejerPre) {
        this.ejerPre = ejerPre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaAsume() {
        return fechaAsume;
    }

    public void setFechaAsume(Date fechaAsume) {
        this.fechaAsume = fechaAsume;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getTiempoServ() {
        return tiempoServ;
    }

    public void setTiempoServ(String tiempoServ) {
        this.tiempoServ = tiempoServ;
    }

    public Integer getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(Integer alInicio) {
        this.alInicio = alInicio;
    }

    public BigDecimal getRbPu() {
        return rbPu;
    }

    public void setRbPu(BigDecimal rbPu) {
        this.rbPu = rbPu;
    }

    public BigDecimal getRbPr() {
        return rbPr;
    }

    public void setRbPr(BigDecimal rbPr) {
        this.rbPr = rbPr;
    }

    public BigDecimal getRbTot() {
        return rbTot;
    }

    public void setRbTot(BigDecimal rbTot) {
        this.rbTot = rbTot;
    }

    public BigDecimal getRbiPu() {
        return rbiPu;
    }

    public void setRbiPu(BigDecimal rbiPu) {
        this.rbiPu = rbiPu;
    }

    public BigDecimal getRbiPr() {
        return rbiPr;
    }

    public void setRbiPr(BigDecimal rbiPr) {
        this.rbiPr = rbiPr;
    }

    public BigDecimal getRbiTot() {
        return rbiTot;
    }

    public void setRbiTot(BigDecimal rbiTot) {
        this.rbiTot = rbiTot;
    }

    public BigDecimal getOim1Pu() {
        return oim1Pu;
    }

    public void setOim1Pu(BigDecimal oim1Pu) {
        this.oim1Pu = oim1Pu;
    }

    public BigDecimal getOim1Pr() {
        return oim1Pr;
    }

    public void setOim1Pr(BigDecimal oim1Pr) {
        this.oim1Pr = oim1Pr;
    }

    public BigDecimal getOim1Tot() {
        return oim1Tot;
    }

    public void setOim1Tot(BigDecimal oim1Tot) {
        this.oim1Tot = oim1Tot;
    }

    public BigDecimal getOim2Pu() {
        return oim2Pu;
    }

    public void setOim2Pu(BigDecimal oim2Pu) {
        this.oim2Pu = oim2Pu;
    }

    public BigDecimal getOim2Pr() {
        return oim2Pr;
    }

    public void setOim2Pr(BigDecimal oim2Pr) {
        this.oim2Pr = oim2Pr;
    }

    public BigDecimal getOim2Tot() {
        return oim2Tot;
    }

    public void setOim2Tot(BigDecimal oim2Tot) {
        this.oim2Tot = oim2Tot;
    }

    public BigDecimal getOim3Pu() {
        return oim3Pu;
    }

    public void setOim3Pu(BigDecimal oim3Pu) {
        this.oim3Pu = oim3Pu;
    }

    public BigDecimal getOim3Pr() {
        return oim3Pr;
    }

    public void setOim3Pr(BigDecimal oim3Pr) {
        this.oim3Pr = oim3Pr;
    }

    public BigDecimal getOim3Tot() {
        return oim3Tot;
    }

    public void setOim3Tot(BigDecimal oim3Tot) {
        this.oim3Tot = oim3Tot;
    }

    public String getTipBien1() {
        return tipBien1;
    }

    public void setTipBien1(String tipBien1) {
        this.tipBien1 = tipBien1;
    }

    public String getDireBien1() {
        return direBien1;
    }

    public void setDireBien1(String direBien1) {
        this.direBien1 = direBien1;
    }

    public String getNumFicha1() {
        return numFicha1;
    }

    public void setNumFicha1(String numFicha1) {
        this.numFicha1 = numFicha1;
    }

    public BigDecimal getAutoval1() {
        return autoval1;
    }

    public void setAutoval1(BigDecimal autoval1) {
        this.autoval1 = autoval1;
    }

    public String getTipBien2() {
        return tipBien2;
    }

    public void setTipBien2(String tipBien2) {
        this.tipBien2 = tipBien2;
    }

    public String getDireBien2() {
        return direBien2;
    }

    public void setDireBien2(String direBien2) {
        this.direBien2 = direBien2;
    }

    public String getNumFicha2() {
        return numFicha2;
    }

    public void setNumFicha2(String numFicha2) {
        this.numFicha2 = numFicha2;
    }

    public BigDecimal getAutoval2() {
        return autoval2;
    }

    public void setAutoval2(BigDecimal autoval2) {
        this.autoval2 = autoval2;
    }

    public String getTipBien3() {
        return tipBien3;
    }

    public void setTipBien3(String tipBien3) {
        this.tipBien3 = tipBien3;
    }

    public String getDireBien3() {
        return direBien3;
    }

    public void setDireBien3(String direBien3) {
        this.direBien3 = direBien3;
    }

    public String getNumFicha3() {
        return numFicha3;
    }

    public void setNumFicha3(String numFicha3) {
        this.numFicha3 = numFicha3;
    }

    public BigDecimal getAutoval3() {
        return autoval3;
    }

    public void setAutoval3(BigDecimal autoval3) {
        this.autoval3 = autoval3;
    }

    public String getTipBien4() {
        return tipBien4;
    }

    public void setTipBien4(String tipBien4) {
        this.tipBien4 = tipBien4;
    }

    public String getDireBien4() {
        return direBien4;
    }

    public void setDireBien4(String direBien4) {
        this.direBien4 = direBien4;
    }

    public String getNumFicha4() {
        return numFicha4;
    }

    public void setNumFicha4(String numFicha4) {
        this.numFicha4 = numFicha4;
    }

    public BigDecimal getAutoval4() {
        return autoval4;
    }

    public void setAutoval4(BigDecimal autoval4) {
        this.autoval4 = autoval4;
    }

    public String getTipBien5() {
        return tipBien5;
    }

    public void setTipBien5(String tipBien5) {
        this.tipBien5 = tipBien5;
    }

    public String getDireBien5() {
        return direBien5;
    }

    public void setDireBien5(String direBien5) {
        this.direBien5 = direBien5;
    }

    public String getNumFicha5() {
        return numFicha5;
    }

    public void setNumFicha5(String numFicha5) {
        this.numFicha5 = numFicha5;
    }

    public BigDecimal getAutoval5() {
        return autoval5;
    }

    public void setAutoval5(BigDecimal autoval5) {
        this.autoval5 = autoval5;
    }

    public String getTipBien6() {
        return tipBien6;
    }

    public void setTipBien6(String tipBien6) {
        this.tipBien6 = tipBien6;
    }

    public String getDireBien6() {
        return direBien6;
    }

    public void setDireBien6(String direBien6) {
        this.direBien6 = direBien6;
    }

    public String getNumFicha6() {
        return numFicha6;
    }

    public void setNumFicha6(String numFicha6) {
        this.numFicha6 = numFicha6;
    }

    public BigDecimal getAutoval6() {
        return autoval6;
    }

    public void setAutoval6(BigDecimal autoval6) {
        this.autoval6 = autoval6;
    }

    public String getVehi1() {
        return vehi1;
    }

    public void setVehi1(String vehi1) {
        this.vehi1 = vehi1;
    }

    public String getVehiMarca1() {
        return vehiMarca1;
    }

    public void setVehiMarca1(String vehiMarca1) {
        this.vehiMarca1 = vehiMarca1;
    }

    public String getVehiPlaca1() {
        return vehiPlaca1;
    }

    public void setVehiPlaca1(String vehiPlaca1) {
        this.vehiPlaca1 = vehiPlaca1;
    }

    public BigDecimal getVehiValor1() {
        return vehiValor1;
    }

    public void setVehiValor1(BigDecimal vehiValor1) {
        this.vehiValor1 = vehiValor1;
    }

    public String getVehi2() {
        return vehi2;
    }

    public void setVehi2(String vehi2) {
        this.vehi2 = vehi2;
    }

    public String getVehiMarca2() {
        return vehiMarca2;
    }

    public void setVehiMarca2(String vehiMarca2) {
        this.vehiMarca2 = vehiMarca2;
    }

    public String getVehiPlaca2() {
        return vehiPlaca2;
    }

    public void setVehiPlaca2(String vehiPlaca2) {
        this.vehiPlaca2 = vehiPlaca2;
    }

    public BigDecimal getVehiValor2() {
        return vehiValor2;
    }

    public void setVehiValor2(BigDecimal vehiValor2) {
        this.vehiValor2 = vehiValor2;
    }

    public String getVehi3() {
        return vehi3;
    }

    public void setVehi3(String vehi3) {
        this.vehi3 = vehi3;
    }

    public String getVehiMarca3() {
        return vehiMarca3;
    }

    public void setVehiMarca3(String vehiMarca3) {
        this.vehiMarca3 = vehiMarca3;
    }

    public String getVehiPlaca3() {
        return vehiPlaca3;
    }

    public void setVehiPlaca3(String vehiPlaca3) {
        this.vehiPlaca3 = vehiPlaca3;
    }

    public BigDecimal getVehiValor3() {
        return vehiValor3;
    }

    public void setVehiValor3(BigDecimal vehiValor3) {
        this.vehiValor3 = vehiValor3;
    }

    public String getVehi4() {
        return vehi4;
    }

    public void setVehi4(String vehi4) {
        this.vehi4 = vehi4;
    }

    public String getVehiMarca4() {
        return vehiMarca4;
    }

    public void setVehiMarca4(String vehiMarca4) {
        this.vehiMarca4 = vehiMarca4;
    }

    public String getVehiPlaca4() {
        return vehiPlaca4;
    }

    public void setVehiPlaca4(String vehiPlaca4) {
        this.vehiPlaca4 = vehiPlaca4;
    }

    public BigDecimal getVehiValor4() {
        return vehiValor4;
    }

    public void setVehiValor4(BigDecimal vehiValor4) {
        this.vehiValor4 = vehiValor4;
    }

    public String getEf1() {
        return ef1;
    }

    public void setEf1(String ef1) {
        this.ef1 = ef1;
    }

    public String getIf1() {
        return if1;
    }

    public void setIf1(String if1) {
        this.if1 = if1;
    }

    public BigDecimal getVal1() {
        return val1;
    }

    public void setVal1(BigDecimal val1) {
        this.val1 = val1;
    }

    public String getEf2() {
        return ef2;
    }

    public void setEf2(String ef2) {
        this.ef2 = ef2;
    }

    public String getIf2() {
        return if2;
    }

    public void setIf2(String if2) {
        this.if2 = if2;
    }

    public BigDecimal getVal2() {
        return val2;
    }

    public void setVal2(BigDecimal val2) {
        this.val2 = val2;
    }

    public String getEf3() {
        return ef3;
    }

    public void setEf3(String ef3) {
        this.ef3 = ef3;
    }

    public String getIf3() {
        return if3;
    }

    public void setIf3(String if3) {
        this.if3 = if3;
    }

    public BigDecimal getVal3() {
        return val3;
    }

    public void setVal3(BigDecimal val3) {
        this.val3 = val3;
    }

    public String getEf4() {
        return ef4;
    }

    public void setEf4(String ef4) {
        this.ef4 = ef4;
    }

    public String getIf4() {
        return if4;
    }

    public void setIf4(String if4) {
        this.if4 = if4;
    }

    public BigDecimal getVal4() {
        return val4;
    }

    public void setVal4(BigDecimal val4) {
        this.val4 = val4;
    }

    public String getEf5() {
        return ef5;
    }

    public void setEf5(String ef5) {
        this.ef5 = ef5;
    }

    public String getIf5() {
        return if5;
    }

    public void setIf5(String if5) {
        this.if5 = if5;
    }

    public BigDecimal getVal5() {
        return val5;
    }

    public void setVal5(BigDecimal val5) {
        this.val5 = val5;
    }

    public String getDein1() {
        return dein1;
    }

    public void setDein1(String dein1) {
        this.dein1 = dein1;
    }

    public BigDecimal getDein1Pu() {
        return dein1Pu;
    }

    public void setDein1Pu(BigDecimal dein1Pu) {
        this.dein1Pu = dein1Pu;
    }

    public BigDecimal getDein1Pr() {
        return dein1Pr;
    }

    public void setDein1Pr(BigDecimal dein1Pr) {
        this.dein1Pr = dein1Pr;
    }

    public BigDecimal getDein1Tot() {
        return dein1Tot;
    }

    public void setDein1Tot(BigDecimal dein1Tot) {
        this.dein1Tot = dein1Tot;
    }

    public String getDein2() {
        return dein2;
    }

    public void setDein2(String dein2) {
        this.dein2 = dein2;
    }

    public BigDecimal getDein2Pu() {
        return dein2Pu;
    }

    public void setDein2Pu(BigDecimal dein2Pu) {
        this.dein2Pu = dein2Pu;
    }

    public BigDecimal getDein2Pr() {
        return dein2Pr;
    }

    public void setDein2Pr(BigDecimal dein2Pr) {
        this.dein2Pr = dein2Pr;
    }

    public BigDecimal getDein2Tot() {
        return dein2Tot;
    }

    public void setDein2Tot(BigDecimal dein2Tot) {
        this.dein2Tot = dein2Tot;
    }

    public String getDebi1() {
        return debi1;
    }

    public void setDebi1(String debi1) {
        this.debi1 = debi1;
    }

    public BigDecimal getDebi1Tot() {
        return debi1Tot;
    }

    public void setDebi1Tot(BigDecimal debi1Tot) {
        this.debi1Tot = debi1Tot;
    }

    public String getDebi2() {
        return debi2;
    }

    public void setDebi2(String debi2) {
        this.debi2 = debi2;
    }

    public BigDecimal getDebi2Tot() {
        return debi2Tot;
    }

    public void setDebi2Tot(BigDecimal debi2Tot) {
        this.debi2Tot = debi2Tot;
    }

    public String getDebi3() {
        return debi3;
    }

    public void setDebi3(String debi3) {
        this.debi3 = debi3;
    }

    public BigDecimal getDebi3Tot() {
        return debi3Tot;
    }

    public void setDebi3Tot(BigDecimal debi3Tot) {
        this.debi3Tot = debi3Tot;
    }

    public String getAcre1() {
        return acre1;
    }

    public void setAcre1(String acre1) {
        this.acre1 = acre1;
    }

    public BigDecimal getAcre1Tot() {
        return acre1Tot;
    }

    public void setAcre1Tot(BigDecimal acre1Tot) {
        this.acre1Tot = acre1Tot;
    }

    public String getAcre2() {
        return acre2;
    }

    public void setAcre2(String acre2) {
        this.acre2 = acre2;
    }

    public BigDecimal getAcre2Tot() {
        return acre2Tot;
    }

    public void setAcre2Tot(BigDecimal acre2Tot) {
        this.acre2Tot = acre2Tot;
    }

    public String getAcre3() {
        return acre3;
    }

    public void setAcre3(String acre3) {
        this.acre3 = acre3;
    }

    public BigDecimal getAcre3Tot() {
        return acre3Tot;
    }

    public void setAcre3Tot(BigDecimal acre3Tot) {
        this.acre3Tot = acre3Tot;
    }

    public Integer getNumPerDep() {
        return numPerDep;
    }

    public void setNumPerDep(Integer numPerDep) {
        this.numPerDep = numPerDep;
    }

    public Date getFechaElab() {
        return fechaElab;
    }

    public void setFechaElab(Date fechaElab) {
        this.fechaElab = fechaElab;
    }

    public String getOtraInfo() {
        return otraInfo;
    }

    public void setOtraInfo(String otraInfo) {
        this.otraInfo = otraInfo;
    }

    public BigDecimal getOtraInfoTotal() {
        return otraInfoTotal;
    }

    public void setOtraInfoTotal(BigDecimal otraInfoTotal) {
        this.otraInfoTotal = otraInfoTotal;
    }

    public String getConDni() {
        return conDni;
    }

    public void setConDni(String conDni) {
        this.conDni = conDni;
    }

    public String getConApaterno() {
        return conApaterno;
    }

    public void setConApaterno(String conApaterno) {
        this.conApaterno = conApaterno;
    }

    public String getConAmaterno() {
        return conAmaterno;
    }

    public void setConAmaterno(String conAmaterno) {
        this.conAmaterno = conAmaterno;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
    }

    public String getConRuc() {
        return conRuc;
    }

    public void setConRuc(String conRuc) {
        this.conRuc = conRuc;
    }

    public String getIdMov() {
        return idMov;
    }

    public void setIdMov(String idMov) {
        this.idMov = idMov;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public BigDecimal getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(BigDecimal bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public BigDecimal getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(BigDecimal remuneracion) {
        this.remuneracion = remuneracion;
    }

    public BigDecimal getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(BigDecimal honorarios) {
        this.honorarios = honorarios;
    }

    public BigDecimal getGratificaciones() {
        return gratificaciones;
    }

    public void setGratificaciones(BigDecimal gratificaciones) {
        this.gratificaciones = gratificaciones;
    }

    public BigDecimal getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(BigDecimal utilidades) {
        this.utilidades = utilidades;
    }

    public BigDecimal getDietas() {
        return dietas;
    }

    public void setDietas(BigDecimal dietas) {
        this.dietas = dietas;
    }

    public BigDecimal getOtros() {
        return otros;
    }

    public void setOtros(BigDecimal otros) {
        this.otros = otros;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public EscDejuPeriodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(EscDejuPeriodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDec != null ? idDec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscDejuDeclaracion)) {
            return false;
        }
        EscDejuDeclaracion other = (EscDejuDeclaracion) object;
        if ((this.idDec == null && other.idDec != null) || (this.idDec != null && !this.idDec.equals(other.idDec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDejuDeclaracion[ idDec=" + idDec + " ]";
    }
    
}
