package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Planilla_Detalle")
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
@JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Concepto concepto;

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

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
