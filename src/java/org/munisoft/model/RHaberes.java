/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Rhaberes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RHaberes.findAll", query = "SELECT r FROM RHaberes r"),
    @NamedQuery(name = "RHaberes.findByDni", query = "SELECT r FROM RHaberes r WHERE r.rHaberesPK.dni = :dni"),
    @NamedQuery(name = "RHaberes.findByMes", query = "SELECT r FROM RHaberes r WHERE r.rHaberesPK.mes = :mes"),
    @NamedQuery(name = "RHaberes.findByAnno", query = "SELECT r FROM RHaberes r WHERE r.rHaberesPK.anno = :anno"),
    @NamedQuery(name = "RHaberes.findByNplan", query = "SELECT r FROM RHaberes r WHERE r.nplan = :nplan"),
    @NamedQuery(name = "RHaberes.findByIDcargo", query = "SELECT r FROM RHaberes r WHERE r.iDcargo = :iDcargo"),
    @NamedQuery(name = "RHaberes.findByIDnivel", query = "SELECT r FROM RHaberes r WHERE r.iDnivel = :iDnivel"),
    @NamedQuery(name = "RHaberes.findByIDcondicion", query = "SELECT r FROM RHaberes r WHERE r.iDcondicion = :iDcondicion"),
    @NamedQuery(name = "RHaberes.findByIDoficina", query = "SELECT r FROM RHaberes r WHERE r.iDoficina = :iDoficina"),
    @NamedQuery(name = "RHaberes.findByDias", query = "SELECT r FROM RHaberes r WHERE r.dias = :dias"),
    @NamedQuery(name = "RHaberes.findByDiaD", query = "SELECT r FROM RHaberes r WHERE r.diaD = :diaD"),
    @NamedQuery(name = "RHaberes.findByRemuneracion", query = "SELECT r FROM RHaberes r WHERE r.remuneracion = :remuneracion"),
    @NamedQuery(name = "RHaberes.findBySubtotal", query = "SELECT r FROM RHaberes r WHERE r.subtotal = :subtotal"),
    @NamedQuery(name = "RHaberes.findByAguinaldo", query = "SELECT r FROM RHaberes r WHERE r.aguinaldo = :aguinaldo"),
    @NamedQuery(name = "RHaberes.findBySsp", query = "SELECT r FROM RHaberes r WHERE r.ssp = :ssp"),
    @NamedQuery(name = "RHaberes.findBySnp", query = "SELECT r FROM RHaberes r WHERE r.snp = :snp"),
    @NamedQuery(name = "RHaberes.findByCone", query = "SELECT r FROM RHaberes r WHERE r.cone = :cone"),
    @NamedQuery(name = "RHaberes.findByConafov", query = "SELECT r FROM RHaberes r WHERE r.conafov = :conafov"),
    @NamedQuery(name = "RHaberes.findByMontepio", query = "SELECT r FROM RHaberes r WHERE r.montepio = :montepio"),
    @NamedQuery(name = "RHaberes.findByImpRem", query = "SELECT r FROM RHaberes r WHERE r.impRem = :impRem"),
    @NamedQuery(name = "RHaberes.findByFanavi", query = "SELECT r FROM RHaberes r WHERE r.fanavi = :fanavi"),
    @NamedQuery(name = "RHaberes.findByAfpPe", query = "SELECT r FROM RHaberes r WHERE r.afpPe = :afpPe"),
    @NamedQuery(name = "RHaberes.findByAfpSe", query = "SELECT r FROM RHaberes r WHERE r.afpSe = :afpSe"),
    @NamedQuery(name = "RHaberes.findByApfCo", query = "SELECT r FROM RHaberes r WHERE r.apfCo = :apfCo"),
    @NamedQuery(name = "RHaberes.findBySegVida", query = "SELECT r FROM RHaberes r WHERE r.segVida = :segVida"),
    @NamedQuery(name = "RHaberes.findByDiaNormal", query = "SELECT r FROM RHaberes r WHERE r.diaNormal = :diaNormal"),
    @NamedQuery(name = "RHaberes.findByDiaDomingo", query = "SELECT r FROM RHaberes r WHERE r.diaDomingo = :diaDomingo"),
    @NamedQuery(name = "RHaberes.findByRemuDnor", query = "SELECT r FROM RHaberes r WHERE r.remuDnor = :remuDnor"),
    @NamedQuery(name = "RHaberes.findByRemuDomi", query = "SELECT r FROM RHaberes r WHERE r.remuDomi = :remuDomi"),
    @NamedQuery(name = "RHaberes.findByMovilidad", query = "SELECT r FROM RHaberes r WHERE r.movilidad = :movilidad"),
    @NamedQuery(name = "RHaberes.findByReintegro", query = "SELECT r FROM RHaberes r WHERE r.reintegro = :reintegro"),
    @NamedQuery(name = "RHaberes.findByIdem", query = "SELECT r FROM RHaberes r WHERE r.idem = :idem"),
    @NamedQuery(name = "RHaberes.findByVaca", query = "SELECT r FROM RHaberes r WHERE r.vaca = :vaca"),
    @NamedQuery(name = "RHaberes.findByOrden", query = "SELECT r FROM RHaberes r WHERE r.orden = :orden")})
public class RHaberes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RHaberesPK rHaberesPK;
    @Column(name = "nplan")
    private Integer nplan;
    @Lob
    @Column(name = "quincena")
    private byte[] quincena;
    @Size(max = 3)
    @Column(name = "ID_cargo")
    private String iDcargo;
    @Size(max = 2)
    @Column(name = "ID_nivel")
    private String iDnivel;
    @Column(name = "ID_condicion")
    private Integer iDcondicion;
    @Size(max = 2)
    @Column(name = "ID_oficina")
    private String iDoficina;
    @Column(name = "dias")
    private Integer dias;
    @Column(name = "dia_d")
    private Integer diaD;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "remuneracion")
    private BigDecimal remuneracion;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "aguinaldo")
    private BigDecimal aguinaldo;
    @Column(name = "SSP")
    private BigDecimal ssp;
    @Column(name = "SNP")
    private BigDecimal snp;
    @Column(name = "cone")
    private BigDecimal cone;
    @Column(name = "conafov")
    private BigDecimal conafov;
    @Column(name = "MONTEPIO")
    private BigDecimal montepio;
    @Column(name = "IMP_REM")
    private BigDecimal impRem;
    @Column(name = "FANAVI")
    private BigDecimal fanavi;
    @Column(name = "AFP_PE")
    private BigDecimal afpPe;
    @Column(name = "AFP_SE")
    private BigDecimal afpSe;
    @Column(name = "APF_CO")
    private BigDecimal apfCo;
    @Column(name = "SEG_VIDA")
    private BigDecimal segVida;
    @Column(name = "dia_normal")
    private Integer diaNormal;
    @Column(name = "dia_domingo")
    private Integer diaDomingo;
    @Column(name = "remu_dnor")
    private BigDecimal remuDnor;
    @Column(name = "remu_domi")
    private BigDecimal remuDomi;
    @Column(name = "movilidad")
    private BigDecimal movilidad;
    @Column(name = "reintegro")
    private BigDecimal reintegro;
    @Column(name = "idem")
    private BigDecimal idem;
    @Column(name = "vaca")
    private BigDecimal vaca;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "DNI", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EPersonal ePersonal;

    public RHaberes() {
    }

    public RHaberes(RHaberesPK rHaberesPK) {
        this.rHaberesPK = rHaberesPK;
    }

    public RHaberes(String dni, String mes, Date anno) {
        this.rHaberesPK = new RHaberesPK(dni, mes, anno);
    }

    public RHaberesPK getRHaberesPK() {
        return rHaberesPK;
    }

    public void setRHaberesPK(RHaberesPK rHaberesPK) {
        this.rHaberesPK = rHaberesPK;
    }

    public Integer getNplan() {
        return nplan;
    }

    public void setNplan(Integer nplan) {
        this.nplan = nplan;
    }

    public byte[] getQuincena() {
        return quincena;
    }

    public void setQuincena(byte[] quincena) {
        this.quincena = quincena;
    }

    public String getIDcargo() {
        return iDcargo;
    }

    public void setIDcargo(String iDcargo) {
        this.iDcargo = iDcargo;
    }

    public String getIDnivel() {
        return iDnivel;
    }

    public void setIDnivel(String iDnivel) {
        this.iDnivel = iDnivel;
    }

    public Integer getIDcondicion() {
        return iDcondicion;
    }

    public void setIDcondicion(Integer iDcondicion) {
        this.iDcondicion = iDcondicion;
    }

    public String getIDoficina() {
        return iDoficina;
    }

    public void setIDoficina(String iDoficina) {
        this.iDoficina = iDoficina;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getDiaD() {
        return diaD;
    }

    public void setDiaD(Integer diaD) {
        this.diaD = diaD;
    }

    public BigDecimal getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(BigDecimal remuneracion) {
        this.remuneracion = remuneracion;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(BigDecimal aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    public BigDecimal getSsp() {
        return ssp;
    }

    public void setSsp(BigDecimal ssp) {
        this.ssp = ssp;
    }

    public BigDecimal getSnp() {
        return snp;
    }

    public void setSnp(BigDecimal snp) {
        this.snp = snp;
    }

    public BigDecimal getCone() {
        return cone;
    }

    public void setCone(BigDecimal cone) {
        this.cone = cone;
    }

    public BigDecimal getConafov() {
        return conafov;
    }

    public void setConafov(BigDecimal conafov) {
        this.conafov = conafov;
    }

    public BigDecimal getMontepio() {
        return montepio;
    }

    public void setMontepio(BigDecimal montepio) {
        this.montepio = montepio;
    }

    public BigDecimal getImpRem() {
        return impRem;
    }

    public void setImpRem(BigDecimal impRem) {
        this.impRem = impRem;
    }

    public BigDecimal getFanavi() {
        return fanavi;
    }

    public void setFanavi(BigDecimal fanavi) {
        this.fanavi = fanavi;
    }

    public BigDecimal getAfpPe() {
        return afpPe;
    }

    public void setAfpPe(BigDecimal afpPe) {
        this.afpPe = afpPe;
    }

    public BigDecimal getAfpSe() {
        return afpSe;
    }

    public void setAfpSe(BigDecimal afpSe) {
        this.afpSe = afpSe;
    }

    public BigDecimal getApfCo() {
        return apfCo;
    }

    public void setApfCo(BigDecimal apfCo) {
        this.apfCo = apfCo;
    }

    public BigDecimal getSegVida() {
        return segVida;
    }

    public void setSegVida(BigDecimal segVida) {
        this.segVida = segVida;
    }

    public Integer getDiaNormal() {
        return diaNormal;
    }

    public void setDiaNormal(Integer diaNormal) {
        this.diaNormal = diaNormal;
    }

    public Integer getDiaDomingo() {
        return diaDomingo;
    }

    public void setDiaDomingo(Integer diaDomingo) {
        this.diaDomingo = diaDomingo;
    }

    public BigDecimal getRemuDnor() {
        return remuDnor;
    }

    public void setRemuDnor(BigDecimal remuDnor) {
        this.remuDnor = remuDnor;
    }

    public BigDecimal getRemuDomi() {
        return remuDomi;
    }

    public void setRemuDomi(BigDecimal remuDomi) {
        this.remuDomi = remuDomi;
    }

    public BigDecimal getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(BigDecimal movilidad) {
        this.movilidad = movilidad;
    }

    public BigDecimal getReintegro() {
        return reintegro;
    }

    public void setReintegro(BigDecimal reintegro) {
        this.reintegro = reintegro;
    }

    public BigDecimal getIdem() {
        return idem;
    }

    public void setIdem(BigDecimal idem) {
        this.idem = idem;
    }

    public BigDecimal getVaca() {
        return vaca;
    }

    public void setVaca(BigDecimal vaca) {
        this.vaca = vaca;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public EPersonal getEPersonal() {
        return ePersonal;
    }

    public void setEPersonal(EPersonal ePersonal) {
        this.ePersonal = ePersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rHaberesPK != null ? rHaberesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RHaberes)) {
            return false;
        }
        RHaberes other = (RHaberes) object;
        if ((this.rHaberesPK == null && other.rHaberesPK != null) || (this.rHaberesPK != null && !this.rHaberesPK.equals(other.rHaberesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RHaberes[ rHaberesPK=" + rHaberesPK + " ]";
    }
    
}
