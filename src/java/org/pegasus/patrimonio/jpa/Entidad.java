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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "entidad")
public class Entidad implements Serializable {
    @OneToMany(mappedBy = "codinst")
    private Collection<ELocal> localCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codinst")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entidad")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "siglas")
    private String siglas;

    public Entidad() {
    }

    public Entidad(String codinst) {
        this.id = codinst;
    }

    public Entidad(String codinst, String entidad, String siglas) {
        this.id = codinst;
        this.nombre = entidad;
        this.siglas = siglas;
    }

    public String getId() {
        return id;
    }

    public void setId(String codinst) {
        this.id = codinst;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String entidad) {
        this.nombre = entidad;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Entidad[ codinst=" + id + " ]";
    }

    @XmlTransient
    public Collection<ELocal> getLocalCollection() {
        return localCollection;
    }

    public void setLocalCollection(Collection<ELocal> localCollection) {
        this.localCollection = localCollection;
    }
    
}
