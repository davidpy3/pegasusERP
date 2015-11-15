/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "hcc_detalle")
@NamedQueries({
    @NamedQuery(name = "HccDetalle.findAll", query = "SELECT h FROM HccDetalle h")})
public class HccDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HccDetallePK hccDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "fase")
    private Character fase;

    public HccDetalle() {
    }

    public HccDetalle(HccDetallePK hccDetallePK) {
        this.hccDetallePK = hccDetallePK;
    }

    public HccDetalle(String anoEje, int nHcc, String idClasificador, int correla) {
        this.hccDetallePK = new HccDetallePK(anoEje, nHcc, idClasificador, correla);
    }

    public HccDetallePK getHccDetallePK() {
        return hccDetallePK;
    }

    public void setHccDetallePK(HccDetallePK hccDetallePK) {
        this.hccDetallePK = hccDetallePK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Character getFase() {
        return fase;
    }

    public void setFase(Character fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hccDetallePK != null ? hccDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HccDetalle)) {
            return false;
        }
        HccDetalle other = (HccDetalle) object;
        if ((this.hccDetallePK == null && other.hccDetallePK != null) || (this.hccDetallePK != null && !this.hccDetallePK.equals(other.hccDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.HccDetalle[ hccDetallePK=" + hccDetallePK + " ]";
    }
    
}
