/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "componente_nombre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComponenteNombre.findAll", query = "SELECT c FROM ComponenteNombre c"),
    @NamedQuery(name = "ComponenteNombre.findByAnoEje", query = "SELECT c FROM ComponenteNombre c WHERE c.componenteNombrePK.anoEje = :anoEje"),
    @NamedQuery(name = "ComponenteNombre.findByComponente", query = "SELECT c FROM ComponenteNombre c WHERE c.componenteNombrePK.componente = :componente"),
    @NamedQuery(name = "ComponenteNombre.findByTipoComponente", query = "SELECT c FROM ComponenteNombre c WHERE c.tipoComponente = :tipoComponente"),
    @NamedQuery(name = "ComponenteNombre.findByNombre", query = "SELECT c FROM ComponenteNombre c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ComponenteNombre.findByEstado", query = "SELECT c FROM ComponenteNombre c WHERE c.estado = :estado")})
public class ComponenteNombre implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComponenteNombrePK componenteNombrePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_componente")
    private Character tipoComponente;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componenteNombre")
    private Collection<Componente> componenteCollection;

    public ComponenteNombre() {
    }

    public ComponenteNombre(ComponenteNombrePK componenteNombrePK) {
        this.componenteNombrePK = componenteNombrePK;
    }

    public ComponenteNombre(ComponenteNombrePK componenteNombrePK, Character tipoComponente) {
        this.componenteNombrePK = componenteNombrePK;
        this.tipoComponente = tipoComponente;
    }

    public ComponenteNombre(String anoEje, String componente) {
        this.componenteNombrePK = new ComponenteNombrePK(anoEje, componente);
    }

    public ComponenteNombrePK getComponenteNombrePK() {
        return componenteNombrePK;
    }

    public void setComponenteNombrePK(ComponenteNombrePK componenteNombrePK) {
        this.componenteNombrePK = componenteNombrePK;
    }

    public Character getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(Character tipoComponente) {
        this.tipoComponente = tipoComponente;
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
    public Collection<Componente> getComponenteCollection() {
        return componenteCollection;
    }

    public void setComponenteCollection(Collection<Componente> componenteCollection) {
        this.componenteCollection = componenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componenteNombrePK != null ? componenteNombrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponenteNombre)) {
            return false;
        }
        ComponenteNombre other = (ComponenteNombre) object;
        if ((this.componenteNombrePK == null && other.componenteNombrePK != null) || (this.componenteNombrePK != null && !this.componenteNombrePK.equals(other.componenteNombrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ComponenteNombre[ componenteNombrePK=" + componenteNombrePK + " ]";
    }
    
}
