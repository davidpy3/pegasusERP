/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Erick alarcon
 */
@Embeddable
public class FinalidadPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "finalidad")
    private String finalidad;

    public FinalidadPK() {
    }

    public FinalidadPK(String anoEje, String finalidad) {
        this.anoEje = anoEje;
        this.finalidad = finalidad;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (finalidad != null ? finalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalidadPK)) {
            return false;
        }
        FinalidadPK other = (FinalidadPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.finalidad == null && other.finalidad != null) || (this.finalidad != null && !this.finalidad.equals(other.finalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.FinalidadPK[ anoEje=" + anoEje + ", finalidad=" + finalidad + " ]";
    }
    
}
