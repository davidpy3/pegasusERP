/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorik
 */
@Embeddable
public class FactorAjustePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "mes_eje")
    private String mesEje;

    public FactorAjustePK() {
    }

    public FactorAjustePK(String anoEje, String mesEje) {
        this.anoEje = anoEje;
        this.mesEje = mesEje;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getMesEje() {
        return mesEje;
    }

    public void setMesEje(String mesEje) {
        this.mesEje = mesEje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (mesEje != null ? mesEje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactorAjustePK)) {
            return false;
        }
        FactorAjustePK other = (FactorAjustePK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.mesEje == null && other.mesEje != null) || (this.mesEje != null && !this.mesEje.equals(other.mesEje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.ocper.FactorAjustePK[ anoEje=" + anoEje + ", mesEje=" + mesEje + " ]";
    }
    
}
