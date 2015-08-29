/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "act_proy_x_entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActProyXEntidad.findAll", query = "SELECT a FROM ActProyXEntidad a"),
    @NamedQuery(name = "ActProyXEntidad.findByAnoEje", query = "SELECT a FROM ActProyXEntidad a WHERE a.actProyXEntidadPK.anoEje = :anoEje"),
    @NamedQuery(name = "ActProyXEntidad.findByActProy", query = "SELECT a FROM ActProyXEntidad a WHERE a.actProyXEntidadPK.actProy = :actProy"),
    @NamedQuery(name = "ActProyXEntidad.findBySecEjec", query = "SELECT a FROM ActProyXEntidad a WHERE a.secEjec = :secEjec"),
    @NamedQuery(name = "ActProyXEntidad.findByEstado", query = "SELECT a FROM ActProyXEntidad a WHERE a.estado = :estado")})
public class ActProyXEntidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActProyXEntidadPK actProyXEntidadPK;
    @Size(max = 6)
    @Column(name = "sec_ejec")
    private String secEjec;
    @Column(name = "estado")
    private Character estado;

    public ActProyXEntidad() {
    }

    public ActProyXEntidad(ActProyXEntidadPK actProyXEntidadPK) {
        this.actProyXEntidadPK = actProyXEntidadPK;
    }

    public ActProyXEntidad(String anoEje, String actProy) {
        this.actProyXEntidadPK = new ActProyXEntidadPK(anoEje, actProy);
    }

    public ActProyXEntidadPK getActProyXEntidadPK() {
        return actProyXEntidadPK;
    }

    public void setActProyXEntidadPK(ActProyXEntidadPK actProyXEntidadPK) {
        this.actProyXEntidadPK = actProyXEntidadPK;
    }

    public String getSecEjec() {
        return secEjec;
    }

    public void setSecEjec(String secEjec) {
        this.secEjec = secEjec;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actProyXEntidadPK != null ? actProyXEntidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActProyXEntidad)) {
            return false;
        }
        ActProyXEntidad other = (ActProyXEntidad) object;
        if ((this.actProyXEntidadPK == null && other.actProyXEntidadPK != null) || (this.actProyXEntidadPK != null && !this.actProyXEntidadPK.equals(other.actProyXEntidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ActProyXEntidad[ actProyXEntidadPK=" + actProyXEntidadPK + " ]";
    }
    
}
