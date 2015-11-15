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
@Table(name = "son_adelanto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adelanto.findAll", query = "SELECT a FROM Adelanto a"),
    @NamedQuery(name = "Adelanto.findByIdAdelanto", query = "SELECT a FROM Adelanto a WHERE a.idAdelanto = :idAdelanto"),
    @NamedQuery(name = "Adelanto.findByFecha", query = "SELECT a FROM Adelanto a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Adelanto.findByMonto", query = "SELECT a FROM Adelanto a WHERE a.monto = :monto"),
    @NamedQuery(name = "Adelanto.findByDni", query = "SELECT a FROM Adelanto a WHERE a.dni = :dni")})
public class Adelanto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adelanto")
    private Integer idAdelanto;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;

    public Adelanto() {
    }

    public Adelanto(Integer idAdelanto) {
        this.idAdelanto = idAdelanto;
    }

    public Adelanto(Integer idAdelanto, Date fecha, double monto, String dni) {
        this.idAdelanto = idAdelanto;
        this.fecha = fecha;
        this.monto = monto;
        this.dni = dni;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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
        if (!(object instanceof Adelanto)) {
            return false;
        }
        Adelanto other = (Adelanto) object;
        if ((this.idAdelanto == null && other.idAdelanto != null) || (this.idAdelanto != null && !this.idAdelanto.equals(other.idAdelanto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Adelanto[ idAdelanto=" + idAdelanto + " ]";
    }
    
}
