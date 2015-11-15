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
public class ProyInvPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "id_proy")
    private int idProy;

    public ProyInvPK() {
    }

    public ProyInvPK(String anoEje, int idProy) {
        this.anoEje = anoEje;
        this.idProy = idProy;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getIdProy() {
        return idProy;
    }

    public void setIdProy(int idProy) {
        this.idProy = idProy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (int) idProy;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyInvPK)) {
            return false;
        }
        ProyInvPK other = (ProyInvPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.idProy != other.idProy) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.ProyInvPK[ anoEje=" + anoEje + ", idProy=" + idProy + " ]";
    }
    
}
