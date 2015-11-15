/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "esc_tipo_fincarreralab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscTipoFinCarreraLab.findAll", query = "SELECT e FROM EscTipoFinCarreraLab e"),
    @NamedQuery(name = "EscTipoFinCarreraLab.findByIdTipo", query = "SELECT e FROM EscTipoFinCarreraLab e WHERE e.idTipo = :idTipo"),
    @NamedQuery(name = "EscTipoFinCarreraLab.findByNombre", query = "SELECT e FROM EscTipoFinCarreraLab e WHERE e.nombre = :nombre")})
public class EscTipoFinCarreraLab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private String idTipo;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<EscFinCarreraLaboral> escFinCarreraLaboralList;

    public EscTipoFinCarreraLab() {
    }

    public EscTipoFinCarreraLab(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<EscFinCarreraLaboral> getEscFinCarreraLaboralList() {
        return escFinCarreraLaboralList;
    }

    public void setEscFinCarreraLaboralList(List<EscFinCarreraLaboral> escFinCarreraLaboralList) {
        this.escFinCarreraLaboralList = escFinCarreraLaboralList;
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
        if (!(object instanceof EscTipoFinCarreraLab)) {
            return false;
        }
        EscTipoFinCarreraLab other = (EscTipoFinCarreraLab) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscTipoFinCarreraLab[ idTipo=" + idTipo + " ]";
    }
    
}
