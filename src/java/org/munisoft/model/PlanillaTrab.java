/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Planilla_Trab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanillaTrab.findAll", query = "SELECT p FROM PlanillaTrab p"),
    @NamedQuery(name = "PlanillaTrab.findByNExpediente", query = "SELECT p FROM PlanillaTrab p WHERE p.planillaTrabPK.nExpediente = :nExpediente"),
    @NamedQuery(name = "PlanillaTrab.findByAnoeje", query = "SELECT p FROM PlanillaTrab p WHERE p.planillaTrabPK.anoeje = :anoeje"),
    @NamedQuery(name = "PlanillaTrab.findByDni", query = "SELECT p FROM PlanillaTrab p WHERE p.planillaTrabPK.dni = :dni"),
    @NamedQuery(name = "PlanillaTrab.findByRegpension", query = "SELECT p FROM PlanillaTrab p WHERE p.regpension = :regpension"),
    @NamedQuery(name = "PlanillaTrab.findByNOrden", query = "SELECT p FROM PlanillaTrab p WHERE p.nOrden = :nOrden"),
    @NamedQuery(name = "PlanillaTrab.findByTipoTrab", query = "SELECT p FROM PlanillaTrab p WHERE p.tipoTrab = :tipoTrab"),
    @NamedQuery(name = "PlanillaTrab.findByNivelrem", query = "SELECT p FROM PlanillaTrab p WHERE p.nivelrem = :nivelrem"),
    @NamedQuery(name = "PlanillaTrab.findByCargoFunc", query = "SELECT p FROM PlanillaTrab p WHERE p.cargoFunc = :cargoFunc"),
    @NamedQuery(name = "PlanillaTrab.findByDescCargo", query = "SELECT p FROM PlanillaTrab p WHERE p.descCargo = :descCargo"),
    @NamedQuery(name = "PlanillaTrab.findByFechaIngreso", query = "SELECT p FROM PlanillaTrab p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PlanillaTrab.findByFechaModi", query = "SELECT p FROM PlanillaTrab p WHERE p.fechaModi = :fechaModi"),
    @NamedQuery(name = "PlanillaTrab.findByDniModi", query = "SELECT p FROM PlanillaTrab p WHERE p.dniModi = :dniModi"),
    @NamedQuery(name = "PlanillaTrab.findByMontorem", query = "SELECT p FROM PlanillaTrab p WHERE p.montorem = :montorem"),
    @NamedQuery(name = "PlanillaTrab.findByRemaseg", query = "SELECT p FROM PlanillaTrab p WHERE p.remaseg = :remaseg"),
    @NamedQuery(name = "PlanillaTrab.findByDiasNor", query = "SELECT p FROM PlanillaTrab p WHERE p.diasNor = :diasNor"),
    @NamedQuery(name = "PlanillaTrab.findByDiasDom", query = "SELECT p FROM PlanillaTrab p WHERE p.diasDom = :diasDom"),
    @NamedQuery(name = "PlanillaTrab.findByDiasAgua", query = "SELECT p FROM PlanillaTrab p WHERE p.diasAgua = :diasAgua"),
    @NamedQuery(name = "PlanillaTrab.findByDiasFalt", query = "SELECT p FROM PlanillaTrab p WHERE p.diasFalt = :diasFalt"),
    @NamedQuery(name = "PlanillaTrab.findByMinTard", query = "SELECT p FROM PlanillaTrab p WHERE p.minTard = :minTard"),
    @NamedQuery(name = "PlanillaTrab.findByDiasFer", query = "SELECT p FROM PlanillaTrab p WHERE p.diasFer = :diasFer"),
    @NamedQuery(name = "PlanillaTrab.findByDiasFTrab", query = "SELECT p FROM PlanillaTrab p WHERE p.diasFTrab = :diasFTrab"),
    @NamedQuery(name = "PlanillaTrab.findByHoraExtra", query = "SELECT p FROM PlanillaTrab p WHERE p.horaExtra = :horaExtra"),
    @NamedQuery(name = "PlanillaTrab.findByDiasDM", query = "SELECT p FROM PlanillaTrab p WHERE p.diasDM = :diasDM"),
    @NamedQuery(name = "PlanillaTrab.findByDiasVac", query = "SELECT p FROM PlanillaTrab p WHERE p.diasVac = :diasVac"),
    @NamedQuery(name = "PlanillaTrab.findByDiasTOT", query = "SELECT p FROM PlanillaTrab p WHERE p.diasTOT = :diasTOT"),
    @NamedQuery(name = "PlanillaTrab.findByNHijos", query = "SELECT p FROM PlanillaTrab p WHERE p.nHijos = :nHijos"),
    @NamedQuery(name = "PlanillaTrab.findByNserie", query = "SELECT p FROM PlanillaTrab p WHERE p.nserie = :nserie"),
    @NamedQuery(name = "PlanillaTrab.findByNrecibo", query = "SELECT p FROM PlanillaTrab p WHERE p.nrecibo = :nrecibo"),
    @NamedQuery(name = "PlanillaTrab.findByTotalIngr", query = "SELECT p FROM PlanillaTrab p WHERE p.totalIngr = :totalIngr"),
    @NamedQuery(name = "PlanillaTrab.findByTotalDesc", query = "SELECT p FROM PlanillaTrab p WHERE p.totalDesc = :totalDesc"),
    @NamedQuery(name = "PlanillaTrab.findByTotalApor", query = "SELECT p FROM PlanillaTrab p WHERE p.totalApor = :totalApor"),
    @NamedQuery(name = "PlanillaTrab.findByD01", query = "SELECT p FROM PlanillaTrab p WHERE p.d01 = :d01"),
    @NamedQuery(name = "PlanillaTrab.findByD02", query = "SELECT p FROM PlanillaTrab p WHERE p.d02 = :d02"),
    @NamedQuery(name = "PlanillaTrab.findByD03", query = "SELECT p FROM PlanillaTrab p WHERE p.d03 = :d03"),
    @NamedQuery(name = "PlanillaTrab.findByD04", query = "SELECT p FROM PlanillaTrab p WHERE p.d04 = :d04"),
    @NamedQuery(name = "PlanillaTrab.findByD05", query = "SELECT p FROM PlanillaTrab p WHERE p.d05 = :d05"),
    @NamedQuery(name = "PlanillaTrab.findByD06", query = "SELECT p FROM PlanillaTrab p WHERE p.d06 = :d06"),
    @NamedQuery(name = "PlanillaTrab.findByD07", query = "SELECT p FROM PlanillaTrab p WHERE p.d07 = :d07"),
    @NamedQuery(name = "PlanillaTrab.findByD08", query = "SELECT p FROM PlanillaTrab p WHERE p.d08 = :d08"),
    @NamedQuery(name = "PlanillaTrab.findByD09", query = "SELECT p FROM PlanillaTrab p WHERE p.d09 = :d09"),
    @NamedQuery(name = "PlanillaTrab.findByD10", query = "SELECT p FROM PlanillaTrab p WHERE p.d10 = :d10"),
    @NamedQuery(name = "PlanillaTrab.findByD11", query = "SELECT p FROM PlanillaTrab p WHERE p.d11 = :d11"),
    @NamedQuery(name = "PlanillaTrab.findByD12", query = "SELECT p FROM PlanillaTrab p WHERE p.d12 = :d12"),
    @NamedQuery(name = "PlanillaTrab.findByD13", query = "SELECT p FROM PlanillaTrab p WHERE p.d13 = :d13"),
    @NamedQuery(name = "PlanillaTrab.findByD14", query = "SELECT p FROM PlanillaTrab p WHERE p.d14 = :d14"),
    @NamedQuery(name = "PlanillaTrab.findByD15", query = "SELECT p FROM PlanillaTrab p WHERE p.d15 = :d15"),
    @NamedQuery(name = "PlanillaTrab.findByD16", query = "SELECT p FROM PlanillaTrab p WHERE p.d16 = :d16"),
    @NamedQuery(name = "PlanillaTrab.findByD17", query = "SELECT p FROM PlanillaTrab p WHERE p.d17 = :d17"),
    @NamedQuery(name = "PlanillaTrab.findByD18", query = "SELECT p FROM PlanillaTrab p WHERE p.d18 = :d18"),
    @NamedQuery(name = "PlanillaTrab.findByD19", query = "SELECT p FROM PlanillaTrab p WHERE p.d19 = :d19"),
    @NamedQuery(name = "PlanillaTrab.findByD20", query = "SELECT p FROM PlanillaTrab p WHERE p.d20 = :d20"),
    @NamedQuery(name = "PlanillaTrab.findByD21", query = "SELECT p FROM PlanillaTrab p WHERE p.d21 = :d21"),
    @NamedQuery(name = "PlanillaTrab.findByD22", query = "SELECT p FROM PlanillaTrab p WHERE p.d22 = :d22"),
    @NamedQuery(name = "PlanillaTrab.findByD23", query = "SELECT p FROM PlanillaTrab p WHERE p.d23 = :d23"),
    @NamedQuery(name = "PlanillaTrab.findByD24", query = "SELECT p FROM PlanillaTrab p WHERE p.d24 = :d24"),
    @NamedQuery(name = "PlanillaTrab.findByD25", query = "SELECT p FROM PlanillaTrab p WHERE p.d25 = :d25"),
    @NamedQuery(name = "PlanillaTrab.findByD26", query = "SELECT p FROM PlanillaTrab p WHERE p.d26 = :d26"),
    @NamedQuery(name = "PlanillaTrab.findByD27", query = "SELECT p FROM PlanillaTrab p WHERE p.d27 = :d27"),
    @NamedQuery(name = "PlanillaTrab.findByD28", query = "SELECT p FROM PlanillaTrab p WHERE p.d28 = :d28"),
    @NamedQuery(name = "PlanillaTrab.findByD29", query = "SELECT p FROM PlanillaTrab p WHERE p.d29 = :d29"),
    @NamedQuery(name = "PlanillaTrab.findByD30", query = "SELECT p FROM PlanillaTrab p WHERE p.d30 = :d30"),
    @NamedQuery(name = "PlanillaTrab.findByD31", query = "SELECT p FROM PlanillaTrab p WHERE p.d31 = :d31")})
public class PlanillaTrab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaTrabPK planillaTrabPK;
    @Size(max = 2)
    @Column(name = "Reg_pension")
    private String regpension;
    @Column(name = "N_Orden")
    private Integer nOrden;
    @Size(max = 2)
    @Column(name = "Tipo_Trab")
    private String tipoTrab;
    @Size(max = 2)
    @Column(name = "Nivel_rem")
    private String nivelrem;
    @Size(max = 3)
    @Column(name = "cargo_func")
    private String cargoFunc;
    @Size(max = 100)
    @Column(name = "desc_cargo")
    private String descCargo;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fecha_modi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModi;
    @Size(max = 8)
    @Column(name = "dni_modi")
    private String dniModi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto_rem")
    private BigDecimal montorem;
    @Column(name = "Rem_aseg")
    private BigDecimal remaseg;
    @Column(name = "Dias_Nor")
    private Integer diasNor;
    @Column(name = "Dias_Dom")
    private Integer diasDom;
    @Column(name = "Dias_Agua")
    private Integer diasAgua;
    @Column(name = "Dias_Falt")
    private Integer diasFalt;
    @Column(name = "Min_Tard")
    private BigInteger minTard;
    @Column(name = "Dias_Fer")
    private Integer diasFer;
    @Column(name = "Dias_FTrab")
    private Integer diasFTrab;
    @Column(name = "hora_extra")
    private Integer horaExtra;
    @Column(name = "Dias_DM")
    private Integer diasDM;
    @Column(name = "Dias_Vac")
    private Integer diasVac;
    @Column(name = "Dias_TOT")
    private Integer diasTOT;
    @Column(name = "N_Hijos")
    private Integer nHijos;
    @Size(max = 3)
    @Column(name = "N_serie")
    private String nserie;
    @Size(max = 8)
    @Column(name = "N_recibo")
    private String nrecibo;
    @Column(name = "Total_Ingr")
    private BigDecimal totalIngr;
    @Column(name = "Total_Desc")
    private BigDecimal totalDesc;
    @Column(name = "Total_Apor")
    private BigDecimal totalApor;
    @Column(name = "d01")
    private Character d01;
    @Column(name = "d02")
    private Character d02;
    @Column(name = "d03")
    private Character d03;
    @Column(name = "d04")
    private Character d04;
    @Column(name = "d05")
    private Character d05;
    @Column(name = "d06")
    private Character d06;
    @Column(name = "d07")
    private Character d07;
    @Column(name = "d08")
    private Character d08;
    @Column(name = "d09")
    private Character d09;
    @Column(name = "d10")
    private Character d10;
    @Column(name = "d11")
    private Character d11;
    @Column(name = "d12")
    private Character d12;
    @Column(name = "d13")
    private Character d13;
    @Column(name = "d14")
    private Character d14;
    @Column(name = "d15")
    private Character d15;
    @Column(name = "d16")
    private Character d16;
    @Column(name = "d17")
    private Character d17;
    @Column(name = "d18")
    private Character d18;
    @Column(name = "d19")
    private Character d19;
    @Column(name = "d20")
    private Character d20;
    @Column(name = "d21")
    private Character d21;
    @Column(name = "d22")
    private Character d22;
    @Column(name = "d23")
    private Character d23;
    @Column(name = "d24")
    private Character d24;
    @Column(name = "d25")
    private Character d25;
    @Column(name = "d26")
    private Character d26;
    @Column(name = "d27")
    private Character d27;
    @Column(name = "d28")
    private Character d28;
    @Column(name = "d29")
    private Character d29;
    @Column(name = "d30")
    private Character d30;
    @Column(name = "d31")
    private Character d31;
    @JoinColumn(name = "DNI", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;
    /*@JoinColumns({
        @JoinColumn(name = "N_Expediente", referencedColumnName = "N_Expediente", insertable = false, updatable = false),
        @JoinColumn(name = "Ano_eje", referencedColumnName = "Ano_eje", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Planilla planilla;*/
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "planillaTrab")
    private Collection<PlanillaDet> planillaDetCollection;
*/
    public PlanillaTrab() {
    }

    public PlanillaTrab(PlanillaTrabPK planillaTrabPK) {
        this.planillaTrabPK = planillaTrabPK;
    }

    public PlanillaTrab(String nExpediente, String anoeje, String dni) {
        this.planillaTrabPK = new PlanillaTrabPK(nExpediente, anoeje, dni);
    }

    public PlanillaTrabPK getPlanillaTrabPK() {
        return planillaTrabPK;
    }

    public void setPlanillaTrabPK(PlanillaTrabPK planillaTrabPK) {
        this.planillaTrabPK = planillaTrabPK;
    }

    public String getRegpension() {
        return regpension;
    }

    public void setRegpension(String regpension) {
        this.regpension = regpension;
    }

    public Integer getNOrden() {
        return nOrden;
    }

    public void setNOrden(Integer nOrden) {
        this.nOrden = nOrden;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getNivelrem() {
        return nivelrem;
    }

    public void setNivelrem(String nivelrem) {
        this.nivelrem = nivelrem;
    }

    public String getCargoFunc() {
        return cargoFunc;
    }

    public void setCargoFunc(String cargoFunc) {
        this.cargoFunc = cargoFunc;
    }

    public String getDescCargo() {
        return descCargo;
    }

    public void setDescCargo(String descCargo) {
        this.descCargo = descCargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaModi() {
        return fechaModi;
    }

    public void setFechaModi(Date fechaModi) {
        this.fechaModi = fechaModi;
    }

    public String getDniModi() {
        return dniModi;
    }

    public void setDniModi(String dniModi) {
        this.dniModi = dniModi;
    }

    public BigDecimal getMontorem() {
        return montorem;
    }

    public void setMontorem(BigDecimal montorem) {
        this.montorem = montorem;
    }

    public BigDecimal getRemaseg() {
        return remaseg;
    }

    public void setRemaseg(BigDecimal remaseg) {
        this.remaseg = remaseg;
    }

    public Integer getDiasNor() {
        return diasNor;
    }

    public void setDiasNor(Integer diasNor) {
        this.diasNor = diasNor;
    }

    public Integer getDiasDom() {
        return diasDom;
    }

    public void setDiasDom(Integer diasDom) {
        this.diasDom = diasDom;
    }

    public Integer getDiasAgua() {
        return diasAgua;
    }

    public void setDiasAgua(Integer diasAgua) {
        this.diasAgua = diasAgua;
    }

    public Integer getDiasFalt() {
        return diasFalt;
    }

    public void setDiasFalt(Integer diasFalt) {
        this.diasFalt = diasFalt;
    }

    public BigInteger getMinTard() {
        return minTard;
    }

    public void setMinTard(BigInteger minTard) {
        this.minTard = minTard;
    }

    public Integer getDiasFer() {
        return diasFer;
    }

    public void setDiasFer(Integer diasFer) {
        this.diasFer = diasFer;
    }

    public Integer getDiasFTrab() {
        return diasFTrab;
    }

    public void setDiasFTrab(Integer diasFTrab) {
        this.diasFTrab = diasFTrab;
    }

    public Integer getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Integer horaExtra) {
        this.horaExtra = horaExtra;
    }

    public Integer getDiasDM() {
        return diasDM;
    }

    public void setDiasDM(Integer diasDM) {
        this.diasDM = diasDM;
    }

    public Integer getDiasVac() {
        return diasVac;
    }

    public void setDiasVac(Integer diasVac) {
        this.diasVac = diasVac;
    }

    public Integer getDiasTOT() {
        return diasTOT;
    }

    public void setDiasTOT(Integer diasTOT) {
        this.diasTOT = diasTOT;
    }

    public Integer getNHijos() {
        return nHijos;
    }

    public void setNHijos(Integer nHijos) {
        this.nHijos = nHijos;
    }

    public String getNserie() {
        return nserie;
    }

    public void setNserie(String nserie) {
        this.nserie = nserie;
    }

    public String getNrecibo() {
        return nrecibo;
    }

    public void setNrecibo(String nrecibo) {
        this.nrecibo = nrecibo;
    }

    public BigDecimal getTotalIngr() {
        return totalIngr;
    }

    public void setTotalIngr(BigDecimal totalIngr) {
        this.totalIngr = totalIngr;
    }

    public BigDecimal getTotalDesc() {
        return totalDesc;
    }

    public void setTotalDesc(BigDecimal totalDesc) {
        this.totalDesc = totalDesc;
    }

    public BigDecimal getTotalApor() {
        return totalApor;
    }

    public void setTotalApor(BigDecimal totalApor) {
        this.totalApor = totalApor;
    }

    public Character getD01() {
        return d01;
    }

    public void setD01(Character d01) {
        this.d01 = d01;
    }

    public Character getD02() {
        return d02;
    }

    public void setD02(Character d02) {
        this.d02 = d02;
    }

    public Character getD03() {
        return d03;
    }

    public void setD03(Character d03) {
        this.d03 = d03;
    }

    public Character getD04() {
        return d04;
    }

    public void setD04(Character d04) {
        this.d04 = d04;
    }

    public Character getD05() {
        return d05;
    }

    public void setD05(Character d05) {
        this.d05 = d05;
    }

    public Character getD06() {
        return d06;
    }

    public void setD06(Character d06) {
        this.d06 = d06;
    }

    public Character getD07() {
        return d07;
    }

    public void setD07(Character d07) {
        this.d07 = d07;
    }

    public Character getD08() {
        return d08;
    }

    public void setD08(Character d08) {
        this.d08 = d08;
    }

    public Character getD09() {
        return d09;
    }

    public void setD09(Character d09) {
        this.d09 = d09;
    }

    public Character getD10() {
        return d10;
    }

    public void setD10(Character d10) {
        this.d10 = d10;
    }

    public Character getD11() {
        return d11;
    }

    public void setD11(Character d11) {
        this.d11 = d11;
    }

    public Character getD12() {
        return d12;
    }

    public void setD12(Character d12) {
        this.d12 = d12;
    }

    public Character getD13() {
        return d13;
    }

    public void setD13(Character d13) {
        this.d13 = d13;
    }

    public Character getD14() {
        return d14;
    }

    public void setD14(Character d14) {
        this.d14 = d14;
    }

    public Character getD15() {
        return d15;
    }

    public void setD15(Character d15) {
        this.d15 = d15;
    }

    public Character getD16() {
        return d16;
    }

    public void setD16(Character d16) {
        this.d16 = d16;
    }

    public Character getD17() {
        return d17;
    }

    public void setD17(Character d17) {
        this.d17 = d17;
    }

    public Character getD18() {
        return d18;
    }

    public void setD18(Character d18) {
        this.d18 = d18;
    }

    public Character getD19() {
        return d19;
    }

    public void setD19(Character d19) {
        this.d19 = d19;
    }

    public Character getD20() {
        return d20;
    }

    public void setD20(Character d20) {
        this.d20 = d20;
    }

    public Character getD21() {
        return d21;
    }

    public void setD21(Character d21) {
        this.d21 = d21;
    }

    public Character getD22() {
        return d22;
    }

    public void setD22(Character d22) {
        this.d22 = d22;
    }

    public Character getD23() {
        return d23;
    }

    public void setD23(Character d23) {
        this.d23 = d23;
    }

    public Character getD24() {
        return d24;
    }

    public void setD24(Character d24) {
        this.d24 = d24;
    }

    public Character getD25() {
        return d25;
    }

    public void setD25(Character d25) {
        this.d25 = d25;
    }

    public Character getD26() {
        return d26;
    }

    public void setD26(Character d26) {
        this.d26 = d26;
    }

    public Character getD27() {
        return d27;
    }

    public void setD27(Character d27) {
        this.d27 = d27;
    }

    public Character getD28() {
        return d28;
    }

    public void setD28(Character d28) {
        this.d28 = d28;
    }

    public Character getD29() {
        return d29;
    }

    public void setD29(Character d29) {
        this.d29 = d29;
    }

    public Character getD30() {
        return d30;
    }

    public void setD30(Character d30) {
        this.d30 = d30;
    }

    public Character getD31() {
        return d31;
    }

    public void setD31(Character d31) {
        this.d31 = d31;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    /*public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }*/

    /*@XmlTransient
    public Collection<PlanillaDet> getPlanillaDetCollection() {
        return planillaDetCollection;
    }

    public void setPlanillaDetCollection(Collection<PlanillaDet> planillaDetCollection) {
        this.planillaDetCollection = planillaDetCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaTrabPK != null ? planillaTrabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaTrab)) {
            return false;
        }
        PlanillaTrab other = (PlanillaTrab) object;
        if ((this.planillaTrabPK == null && other.planillaTrabPK != null) || (this.planillaTrabPK != null && !this.planillaTrabPK.equals(other.planillaTrabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PlanillaTrab[ planillaTrabPK=" + planillaTrabPK + " ]";
    }
    
}
