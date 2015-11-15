/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "gasto")
@NamedQueries({
    @NamedQuery(name = "Gasto.findAll", query = "SELECT g FROM Gasto g")})
public class Gasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GastoPK gastoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "presupuesto")
    private BigDecimal presupuesto;
    @Column(name = "modificacion")
    private BigDecimal modificacion;
    @Column(name = "monto_a_solicitado")
    private BigDecimal montoASolicitado;
    @Column(name = "monto_de_solicitado")
    private BigInteger montoDeSolicitado;
    @Column(name = "ampliacion")
    private BigDecimal ampliacion;
    @Column(name = "ejecucion")
    private BigDecimal ejecucion;
    @Column(name = "compromiso")
    private BigDecimal compromiso;
    @Column(name = "devengado")
    private BigDecimal devengado;
    @Column(name = "girado")
    private BigDecimal girado;
    @Column(name = "pagado")
    private BigDecimal pagado;

    public Gasto() {
    }

    public Gasto(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public Gasto(String anoEje, String secFunc, String fuenteFinanc, String clasificador) {
        this.gastoPK = new GastoPK(anoEje, secFunc, fuenteFinanc, clasificador);
    }

    public GastoPK getGastoPK() {
        return gastoPK;
    }

    public void setGastoPK(GastoPK gastoPK) {
        this.gastoPK = gastoPK;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public BigDecimal getModificacion() {
        return modificacion;
    }

    public void setModificacion(BigDecimal modificacion) {
        this.modificacion = modificacion;
    }

    public BigDecimal getMontoASolicitado() {
        return montoASolicitado;
    }

    public void setMontoASolicitado(BigDecimal montoASolicitado) {
        this.montoASolicitado = montoASolicitado;
    }

    public BigInteger getMontoDeSolicitado() {
        return montoDeSolicitado;
    }

    public void setMontoDeSolicitado(BigInteger montoDeSolicitado) {
        this.montoDeSolicitado = montoDeSolicitado;
    }

    public BigDecimal getAmpliacion() {
        return ampliacion;
    }

    public void setAmpliacion(BigDecimal ampliacion) {
        this.ampliacion = ampliacion;
    }

    public BigDecimal getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(BigDecimal ejecucion) {
        this.ejecucion = ejecucion;
    }

    public BigDecimal getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(BigDecimal compromiso) {
        this.compromiso = compromiso;
    }

    public BigDecimal getDevengado() {
        return devengado;
    }

    public void setDevengado(BigDecimal devengado) {
        this.devengado = devengado;
    }

    public BigDecimal getGirado() {
        return girado;
    }

    public void setGirado(BigDecimal girado) {
        this.girado = girado;
    }

    public BigDecimal getPagado() {
        return pagado;
    }

    public void setPagado(BigDecimal pagado) {
        this.pagado = pagado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gastoPK != null ? gastoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.gastoPK == null && other.gastoPK != null) || (this.gastoPK != null && !this.gastoPK.equals(other.gastoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Gasto[ gastoPK=" + gastoPK + " ]";
    }
    
}
