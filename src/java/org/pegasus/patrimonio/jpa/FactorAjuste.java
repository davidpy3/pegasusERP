/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
 * @author Jorik
 */
@Entity
@Table(name = "factores_ajuste")
@NamedQueries({
    @NamedQuery(name = "FactorAjuste.findAll", query = "SELECT f FROM FactorAjuste f")})
public class FactorAjuste implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactorAjustePK factorAjustePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "factor")
    private BigDecimal factor;

    public FactorAjuste() {
    }

    public FactorAjuste(FactorAjustePK factorAjustePK) {
        this.factorAjustePK = factorAjustePK;
    }

    public FactorAjuste(String anoEje, String mesEje) {
        this.factorAjustePK = new FactorAjustePK(anoEje, mesEje);
    }

    public FactorAjustePK getFactorAjustePK() {
        return factorAjustePK;
    }

    public void setFactorAjustePK(FactorAjustePK factorAjustePK) {
        this.factorAjustePK = factorAjustePK;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factorAjustePK != null ? factorAjustePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactorAjuste)) {
            return false;
        }
        FactorAjuste other = (FactorAjuste) object;
        if ((this.factorAjustePK == null && other.factorAjustePK != null) || (this.factorAjustePK != null && !this.factorAjustePK.equals(other.factorAjustePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.ocper.FactorAjuste[ factorAjustePK=" + factorAjustePK + " ]";
    }
    
}
