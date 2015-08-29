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
public class ActProyNombrePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "act_proy")
    private String actProy;

    public ActProyNombrePK() {
    }

    public ActProyNombrePK(String anoEje, String actProy) {
        this.anoEje = anoEje;
        this.actProy = actProy;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getActProy() {
        return actProy;
    }

    public void setActProy(String actProy) {
        this.actProy = actProy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (actProy != null ? actProy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActProyNombrePK)) {
            return false;
        }
        ActProyNombrePK other = (ActProyNombrePK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.actProy == null && other.actProy != null) || (this.actProy != null && !this.actProy.equals(other.actProy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ActProyNombrePK[ anoEje=" + anoEje + ", actProy=" + actProy + " ]";
    }
    
}
