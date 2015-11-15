/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_deju_periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscDejuPeriodo.findAll", query = "SELECT e FROM EscDejuPeriodo e"),
    @NamedQuery(name = "EscDejuPeriodo.findByIdPeriodo", query = "SELECT e FROM EscDejuPeriodo e WHERE e.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "EscDejuPeriodo.findByFechaInicio", query = "SELECT e FROM EscDejuPeriodo e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EscDejuPeriodo.findByFechaTermino", query = "SELECT e FROM EscDejuPeriodo e WHERE e.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "EscDejuPeriodo.findByActivo", query = "SELECT e FROM EscDejuPeriodo e WHERE e.activo = :activo"),
    @NamedQuery(name = "EscDejuPeriodo.findByEjerPresupuestal", query = "SELECT e FROM EscDejuPeriodo e WHERE e.ejerPresupuestal = :ejerPresupuestal"),
    @NamedQuery(name = "EscDejuPeriodo.findByTitular", query = "SELECT e FROM EscDejuPeriodo e WHERE e.titular = :titular"),
    @NamedQuery(name = "EscDejuPeriodo.findByDireccion", query = "SELECT e FROM EscDejuPeriodo e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EscDejuPeriodo.findByEntidad", query = "SELECT e FROM EscDejuPeriodo e WHERE e.entidad = :entidad")})
public class EscDejuPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private Integer idPeriodo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "ejer_presupuestal")
    private String ejerPresupuestal;
    @Column(name = "titular")
    private String titular;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "entidad")
    private String entidad;
    @OneToMany(mappedBy = "idPeriodo")
    private List<EscDejuDeclaracion> escDejuDeclaracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escDejuPeriodo")
    private List<EscDejuPersonaPeriodo> escDejuPersonaPeriodoList;

    public EscDejuPeriodo() {
    }

    public EscDejuPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public EscDejuPeriodo(Integer idPeriodo, boolean activo) {
        this.idPeriodo = idPeriodo;
        this.activo = activo;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEjerPresupuestal() {
        return ejerPresupuestal;
    }

    public void setEjerPresupuestal(String ejerPresupuestal) {
        this.ejerPresupuestal = ejerPresupuestal;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @XmlTransient
    public List<EscDejuDeclaracion> getEscDejuDeclaracionList() {
        return escDejuDeclaracionList;
    }

    public void setEscDejuDeclaracionList(List<EscDejuDeclaracion> escDejuDeclaracionList) {
        this.escDejuDeclaracionList = escDejuDeclaracionList;
    }

    @XmlTransient
    public List<EscDejuPersonaPeriodo> getEscDejuPersonaPeriodoList() {
        return escDejuPersonaPeriodoList;
    }

    public void setEscDejuPersonaPeriodoList(List<EscDejuPersonaPeriodo> escDejuPersonaPeriodoList) {
        this.escDejuPersonaPeriodoList = escDejuPersonaPeriodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscDejuPeriodo)) {
            return false;
        }
        EscDejuPeriodo other = (EscDejuPeriodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDejuPeriodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
