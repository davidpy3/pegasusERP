/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_tipo_meritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoMeritos.findAll", query = "SELECT e FROM EscTipoMeritos e"),
    @NamedQuery(name = "EscTipoMeritos.findByIdTipo", query = "SELECT e FROM EscTipoMeritos e WHERE e.idTipo = :idTipo"),
    @NamedQuery(name = "EscTipoMeritos.findByNombre", query = "SELECT e FROM EscTipoMeritos e WHERE e.nombre = :nombre")})
public class EscTipoMeritos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Short idTipo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idTipo")
    private List<EscMeritos> escMeritosList;

    public EscTipoMeritos() {
    }

    public EscTipoMeritos(Short idTipo) {
        this.idTipo = idTipo;
    }

    public EscTipoMeritos(Short idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public Short getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Short idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<EscMeritos> getEscMeritosList() {
        return escMeritosList;
    }

    public void setEscMeritosList(List<EscMeritos> escMeritosList) {
        this.escMeritosList = escMeritosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoMeritos)) {
            return false;
        }
        EscTipoMeritos other = (EscTipoMeritos) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoMeritos[ idTipo=" + idTipo + " ]";
    }
    
}
