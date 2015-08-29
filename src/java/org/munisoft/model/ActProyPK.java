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
public class ActProyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "funcion")
    private String funcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "programa")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sub_programa")
    private String subPrograma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "act_proy")
    private String actProy;

    public ActProyPK() {
    }

    public ActProyPK(String anoEje, String funcion, String programa, String subPrograma, String actProy) {
        this.anoEje = anoEje;
        this.funcion = funcion;
        this.programa = programa;
        this.subPrograma = subPrograma;
        this.actProy = actProy;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSubPrograma() {
        return subPrograma;
    }

    public void setSubPrograma(String subPrograma) {
        this.subPrograma = subPrograma;
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
        hash += (funcion != null ? funcion.hashCode() : 0);
        hash += (programa != null ? programa.hashCode() : 0);
        hash += (subPrograma != null ? subPrograma.hashCode() : 0);
        hash += (actProy != null ? actProy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActProyPK)) {
            return false;
        }
        ActProyPK other = (ActProyPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.funcion == null && other.funcion != null) || (this.funcion != null && !this.funcion.equals(other.funcion))) {
            return false;
        }
        if ((this.programa == null && other.programa != null) || (this.programa != null && !this.programa.equals(other.programa))) {
            return false;
        }
        if ((this.subPrograma == null && other.subPrograma != null) || (this.subPrograma != null && !this.subPrograma.equals(other.subPrograma))) {
            return false;
        }
        if ((this.actProy == null && other.actProy != null) || (this.actProy != null && !this.actProy.equals(other.actProy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ActProyPK[ anoEje=" + anoEje + ", funcion=" + funcion + ", programa=" + programa + ", subPrograma=" + subPrograma + ", actProy=" + actProy + " ]";
    }
    
}
