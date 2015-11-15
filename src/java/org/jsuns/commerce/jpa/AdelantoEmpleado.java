/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_adelanto_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdelantoEmpleado.findAll", query = "SELECT a FROM AdelantoEmpleado a"),
    @NamedQuery(name = "AdelantoEmpleado.findByIdAdelanto", query = "SELECT a FROM AdelantoEmpleado a WHERE a.idAdelanto = :idAdelanto"),
    @NamedQuery(name = "AdelantoEmpleado.findByFecha", query = "SELECT a FROM AdelantoEmpleado a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AdelantoEmpleado.findByMonto", query = "SELECT a FROM AdelantoEmpleado a WHERE a.monto = :monto"),
    @NamedQuery(name = "AdelantoEmpleado.findByEstado", query = "SELECT a FROM AdelantoEmpleado a WHERE a.estado = :estado")})
public class AdelantoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adelanto")
    private Integer idAdelanto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Empleado dni;

    public AdelantoEmpleado() {
    }

    public AdelantoEmpleado(Integer idAdelanto) {
        this.idAdelanto = idAdelanto;
    }

    public Integer getIdAdelanto() {
        return idAdelanto;
    }

    public void setIdAdelanto(Integer idAdelanto) {
        this.idAdelanto = idAdelanto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Empleado getDni() {
        return dni;
    }

    public void setDni(Empleado dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdelanto != null ? idAdelanto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdelantoEmpleado)) {
            return false;
        }
        AdelantoEmpleado other = (AdelantoEmpleado) object;
        if ((this.idAdelanto == null && other.idAdelanto != null) || (this.idAdelanto != null && !this.idAdelanto.equals(other.idAdelanto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.AdelantoEmpleado[ idAdelanto=" + idAdelanto + " ]";
    }
    
}
