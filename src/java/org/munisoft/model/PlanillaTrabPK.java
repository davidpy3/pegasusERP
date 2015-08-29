/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

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
    @Column(name = "N_Expediente")
    private String nExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Ano_eje")
    private String anoeje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;

    public PlanillaTrabPK() {
    }

    public PlanillaTrabPK(String nExpediente, String anoeje, String dni) {
        this.nExpediente = nExpediente;
        this.anoeje = anoeje;
        this.dni = dni;
    }

    public String getNExpediente() {
        return nExpediente;
    }

    public void setNExpediente(String nExpediente) {
        this.nExpediente = nExpediente;
    }

    public String getAnoeje() {
        return anoeje;
    }

    public void setAnoeje(String anoeje) {
        this.anoeje = anoeje;
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
        hash += (anoeje != null ? anoeje.hashCode() : 0);
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
        if ((this.anoeje == null && other.anoeje != null) || (this.anoeje != null && !this.anoeje.equals(other.anoeje))) {
            return false;
        }
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PlanillaTrabPK[ nExpediente=" + nExpediente + ", anoeje=" + anoeje + ", dni=" + dni + " ]";
    }
    
}
