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
@Table(name = "cas3")
@NamedQueries({
    @NamedQuery(name = "Cas3.findAll", query = "SELECT c FROM Cas3 c")})
public class Cas3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Cas3PK cas3PK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rem_aseg")
    private BigDecimal remAseg;
    @Column(name = "retencion")
    private Character retencion;

    public Cas3() {
    }

    public Cas3(Cas3PK cas3PK) {
        this.cas3PK = cas3PK;
    }

    public Cas3(String dni, int nSerie, int nRecibo) {
        this.cas3PK = new Cas3PK(dni, nSerie, nRecibo);
    }

    public Cas3PK getCas3PK() {
        return cas3PK;
    }

    public void setCas3PK(Cas3PK cas3PK) {
        this.cas3PK = cas3PK;
    }

    public BigDecimal getRemAseg() {
        return remAseg;
    }

    public void setRemAseg(BigDecimal remAseg) {
        this.remAseg = remAseg;
    }

    public Character getRetencion() {
        return retencion;
    }

    public void setRetencion(Character retencion) {
        this.retencion = retencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cas3PK != null ? cas3PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cas3)) {
            return false;
        }
        Cas3 other = (Cas3) object;
        if ((this.cas3PK == null && other.cas3PK != null) || (this.cas3PK != null && !this.cas3PK.equals(other.cas3PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Cas3[ cas3PK=" + cas3PK + " ]";
    }
    
}
