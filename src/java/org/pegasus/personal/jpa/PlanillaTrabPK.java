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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class PlanillaTrabPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "n_expediente")
    private String nExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;

    public PlanillaTrabPK() {
    }

    public PlanillaTrabPK(String nExpediente, String anoEje, String dni) {
        this.nExpediente = nExpediente;
        this.anoEje = anoEje;
        this.dni = dni;
    }

    public String getNExpediente() {
        return nExpediente;
    }

    public void setNExpediente(String nExpediente) {
        this.nExpediente = nExpediente;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nExpediente != null ? nExpediente.hashCode() : 0);
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanillaTrabPK)) {
            return false;
        }
        PlanillaTrabPK other = (PlanillaTrabPK) object;
        if ((this.nExpediente == null && other.nExpediente != null) || (this.nExpediente != null && !this.nExpediente.equals(other.nExpediente))) {
            return false;
        }
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PlanillaTrabPK[ nExpediente=" + nExpediente + ", anoEje=" + anoEje + ", dni=" + dni + " ]";
    }
    
}
