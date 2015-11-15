/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "act_proy_nombre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActProyNombre.findAll", query = "SELECT a FROM ActProyNombre a"),
    @NamedQuery(name = "ActProyNombre.findByAnoEje", query = "SELECT a FROM ActProyNombre a WHERE a.actProyNombrePK.anoEje = :anoEje"),
    @NamedQuery(name = "ActProyNombre.findByActProy", query = "SELECT a FROM ActProyNombre a WHERE a.actProyNombrePK.actProy = :actProy"),
    @NamedQuery(name = "ActProyNombre.findByTipoActProy", query = "SELECT a FROM ActProyNombre a WHERE a.tipoActProy = :tipoActProy"),
    @NamedQuery(name = "ActProyNombre.findByNombre", query = "SELECT a FROM ActProyNombre a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "ActProyNombre.findByEstado", query = "SELECT a FROM ActProyNombre a WHERE a.estado = :estado")})
public class ActProyNombre implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActProyNombrePK actProyNombrePK;
    @Column(name = "tipo_act_proy")
    private Character tipoActProy;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actProyNombre")
    private Collection<ActProy> actProyCollection;

    public ActProyNombre() {
    }

    public ActProyNombre(ActProyNombrePK actProyNombrePK) {
        this.actProyNombrePK = actProyNombrePK;
    }

    public ActProyNombre(String anoEje, String actProy) {
        this.actProyNombrePK = new ActProyNombrePK(anoEje, actProy);
    }

    public ActProyNombrePK getActProyNombrePK() {
        return actProyNombrePK;
    }

    public void setActProyNombrePK(ActProyNombrePK actProyNombrePK) {
        this.actProyNombrePK = actProyNombrePK;
    }

    public Character getTipoActProy() {
        return tipoActProy;
    }

    public void setTipoActProy(Character tipoActProy) {
        this.tipoActProy = tipoActProy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ActProy> getActProyCollection() {
        return actProyCollection;
    }

    public void setActProyCollection(Collection<ActProy> actProyCollection) {
        this.actProyCollection = actProyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actProyNombrePK != null ? actProyNombrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActProyNombre)) {
            return false;
        }
        ActProyNombre other = (ActProyNombre) object;
        if ((this.actProyNombrePK == null && other.actProyNombrePK != null) || (this.actProyNombrePK != null && !this.actProyNombrePK.equals(other.actProyNombrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ActProyNombre[ actProyNombrePK=" + actProyNombrePK + " ]";
    }
    
}
