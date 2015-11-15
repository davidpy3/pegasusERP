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
@Table(name = "esc_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscServicios.findAll", query = "SELECT e FROM EscServicios e"),
    @NamedQuery(name = "EscServicios.findByIdServicio", query = "SELECT e FROM EscServicios e WHERE e.idServicio = :idServicio"),
    @NamedQuery(name = "EscServicios.findByServicio", query = "SELECT e FROM EscServicios e WHERE e.servicio = :servicio")})
public class EscServicios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @Column(name = "servicio")
    private String servicio;
    @OneToMany(mappedBy = "idServicio")
    private List<EscContratosOtros> escContratosOtrosList;
    @OneToMany(mappedBy = "idServicio")
    private List<EscCarreraLaboral> escCarreraLaboralList;

    public EscServicios() {
    }

    public EscServicios(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public EscServicios(Integer idServicio, String servicio) {
        this.idServicio = idServicio;
        this.servicio = servicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @XmlTransient
    public List<EscContratosOtros> getEscContratosOtrosList() {
        return escContratosOtrosList;
    }

    public void setEscContratosOtrosList(List<EscContratosOtros> escContratosOtrosList) {
        this.escContratosOtrosList = escContratosOtrosList;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscServicios)) {
            return false;
        }
        EscServicios other = (EscServicios) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscServicios[ idServicio=" + idServicio + " ]";
    }
    
}
