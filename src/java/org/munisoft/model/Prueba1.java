/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "prueba1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba1.findAll", query = "SELECT p FROM Prueba1 p"),
    @NamedQuery(name = "Prueba1.findByDni", query = "SELECT p FROM Prueba1 p WHERE p.prueba1PK.dni = :dni"),
    @NamedQuery(name = "Prueba1.findByNSerie", query = "SELECT p FROM Prueba1 p WHERE p.prueba1PK.nSerie = :nSerie"),
    @NamedQuery(name = "Prueba1.findByRecibo", query = "SELECT p FROM Prueba1 p WHERE p.prueba1PK.recibo = :recibo"),
    @NamedQuery(name = "Prueba1.findByFecha", query = "SELECT p FROM Prueba1 p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Prueba1.findByMonto", query = "SELECT p FROM Prueba1 p WHERE p.monto = :monto")})
public class Prueba1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Prueba1PK prueba1PK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;

    public Prueba1() {
    }

    public Prueba1(Prueba1PK prueba1PK) {
        this.prueba1PK = prueba1PK;
    }

    public Prueba1(String dni, int nSerie, String recibo) {
        this.prueba1PK = new Prueba1PK(dni, nSerie, recibo);
    }

    public Prueba1PK getPrueba1PK() {
        return prueba1PK;
    }

    public void setPrueba1PK(Prueba1PK prueba1PK) {
        this.prueba1PK = prueba1PK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prueba1PK != null ? prueba1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba1)) {
            return false;
        }
        Prueba1 other = (Prueba1) object;
        if ((this.prueba1PK == null && other.prueba1PK != null) || (this.prueba1PK != null && !this.prueba1PK.equals(other.prueba1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Prueba1[ prueba1PK=" + prueba1PK + " ]";
    }
    
}
