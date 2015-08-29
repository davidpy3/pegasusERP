/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Planilla_Detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanillaDet.findAll", query = "SELECT p FROM PlanillaDet p"),
    @NamedQuery(name = "PlanillaDet.findByNExpediente", query = "SELECT p FROM PlanillaDet p WHERE p.planillaDetPK.nExpediente = :nExpediente"),
    @NamedQuery(name = "PlanillaDet.findByAnoeje", query = "SELECT p FROM PlanillaDet p WHERE p.planillaDetPK.anoeje = :anoeje"),
    @NamedQuery(name = "PlanillaDet.findByDni", query = "SELECT p FROM PlanillaDet p WHERE p.planillaDetPK.dni = :dni"),
    @NamedQuery(name = "PlanillaDet.findByCodigo", query = "SELECT p FROM PlanillaDet p WHERE p.planillaDetPK.codigo = :codigo"),
    @NamedQuery(name = "PlanillaDet.findByInd", query = "SELECT p FROM PlanillaDet p WHERE p.ind = :ind"),
    @NamedQuery(name = "PlanillaDet.findByValor", query = "SELECT p FROM PlanillaDet p WHERE p.valor = :valor"),
    @NamedQuery(name = "PlanillaDet.findByPorcen", query = "SELECT p FROM PlanillaDet p WHERE p.porcen = :porcen"),
    @NamedQuery(name = "PlanillaDet.findByMonto", query = "SELECT p FROM PlanillaDet p WHERE p.monto = :monto"),
    @NamedQuery(name = "PlanillaDet.findByDebeGasto", query = "SELECT p FROM PlanillaDet p WHERE p.debeGasto = :debeGasto"),
    @NamedQuery(name = "PlanillaDet.findByDebeMonto", query = "SELECT p FROM PlanillaDet p WHERE p.debeMonto = :debeMonto"),
    @NamedQuery(name = "PlanillaDet.findByHaberGasto", query = "SELECT p FROM PlanillaDet p WHERE p.haberGasto = :haberGasto"),
    @NamedQuery(name = "PlanillaDet.findByHaberMonto", query = "SELECT p FROM PlanillaDet p WHERE p.haberMonto = :haberMonto"),
    @NamedQuery(name = "PlanillaDet.findByCuenta", query = "SELECT p FROM PlanillaDet p WHERE p.cuenta = :cuenta")})
public class PlanillaDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaDetPK planillaDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ind")
    private Character ind;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor")
    private BigDecimal valor;
    @Column(name = "Porcen")
    private BigDecimal porcen;
    @Column(name = "Monto")
    private BigDecimal monto;
    @Size(max = 8)
    @Column(name = "Debe_Gasto")
    private String debeGasto;
    @Column(name = "Debe_Monto")
    private BigDecimal debeMonto;
    @Size(max = 8)
    @Column(name = "Haber_Gasto")
    private String haberGasto;
    @Column(name = "Haber_Monto")
    private BigDecimal haberMonto;
    @Size(max = 6)
    @Column(name = "Cuenta")
    private String cuenta;

    public PlanillaDet() {
    }

    public PlanillaDet(PlanillaDetPK planillaDetPK) {
        this.planillaDetPK = planillaDetPK;
    }

    public PlanillaDet(PlanillaDetPK planillaDetPK, Character ind) {
        this.planillaDetPK = planillaDetPK;
        this.ind = ind;
    }

    public PlanillaDet(String nExpediente, String anoeje, String dni, String codigo) {
        this.planillaDetPK = new PlanillaDetPK(nExpediente, anoeje, dni, codigo);
    }

    public PlanillaDetPK getPlanillaDetPK() {
        return planillaDetPK;
    }

    public void setPlanillaDetPK(PlanillaDetPK planillaDetPK) {
        this.planillaDetPK = planillaDetPK;
    }

    public Character getInd() {
        return ind;
    }

    public void setInd(Character ind) {
        this.ind = ind;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPorcen() {
        return porcen;
    }

    public void setPorcen(BigDecimal porcen) {
        this.porcen = porcen;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDebeGasto() {
        return debeGasto;
    }

    public void setDebeGasto(String debeGasto) {
        this.debeGasto = debeGasto;
    }

    public BigDecimal getDebeMonto() {
        return debeMonto;
    }

    public void setDebeMonto(BigDecimal debeMonto) {
        this.debeMonto = debeMonto;
    }

    public String getHaberGasto() {
        return haberGasto;
    }

    public void setHaberGasto(String haberGasto) {
        this.haberGasto = haberGasto;
    }

    public BigDecimal getHaberMonto() {
        return haberMonto;
    }

    public void setHaberMonto(BigDecimal haberMonto) {
        this.haberMonto = haberMonto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaDetPK != null ? planillaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaDet)) {
            return false;
        }
        PlanillaDet other = (PlanillaDet) object;
        if ((this.planillaDetPK == null && other.planillaDetPK != null) || (this.planillaDetPK != null && !this.planillaDetPK.equals(other.planillaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PlanillaDet[ planillaDetPK=" + planillaDetPK + " ]";
    }
    
}
