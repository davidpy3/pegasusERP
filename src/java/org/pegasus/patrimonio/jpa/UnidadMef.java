/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "unidad_mef")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMef.findAll", query = "SELECT u FROM UnidadMef u"),
    @NamedQuery(name = "UnidadMef.findByIdUnidad", query = "SELECT u FROM UnidadMef u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "UnidadMef.findByNombUnidad", query = "SELECT u FROM UnidadMef u WHERE u.nombUnidad = :nombUnidad"),
    @NamedQuery(name = "UnidadMef.findByAbrevUnidad", query = "SELECT u FROM UnidadMef u WHERE u.abrevUnidad = :abrevUnidad")})
public class UnidadMef implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad")
    private Integer idUnidad;
    @Size(max = 50)
    @Column(name = "nomb_unidad")
    private String nombUnidad;
    @Size(max = 50)
    @Column(name = "abrev_unidad")
    private String abrevUnidad;
    @OneToMany(mappedBy = "tipoUnidad")
    private Collection<ItemSeace> itemSeaceCollection;
    @OneToMany(mappedBy = "tipoUnidad")
    private Collection<ItemBienSEACE> itemBienSEACECollection;

    public UnidadMef() {
    }

    public UnidadMef(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombUnidad() {
        return nombUnidad;
    }

    public void setNombUnidad(String nombUnidad) {
        this.nombUnidad = nombUnidad;
    }

    public String getAbrevUnidad() {
        return abrevUnidad;
    }

    public void setAbrevUnidad(String abrevUnidad) {
        this.abrevUnidad = abrevUnidad;
    }

    @XmlTransient
    public Collection<ItemSeace> getItemSeaceCollection() {
        return itemSeaceCollection;
    }

    public void setItemSeaceCollection(Collection<ItemSeace> itemSeaceCollection) {
        this.itemSeaceCollection = itemSeaceCollection;
    }

    @XmlTransient
    public Collection<ItemBienSEACE> getItemBienSEACECollection() {
        return itemBienSEACECollection;
    }

    public void setItemBienSEACECollection(Collection<ItemBienSEACE> itemBienSEACECollection) {
        this.itemBienSEACECollection = itemBienSEACECollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMef)) {
            return false;
        }
        UnidadMef other = (UnidadMef) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.UnidadMef[ idUnidad=" + idUnidad + " ]";
    }
    
}
