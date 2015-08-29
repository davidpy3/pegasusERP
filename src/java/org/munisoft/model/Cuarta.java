/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "cuarta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuarta.findAll", query = "SELECT c FROM Cuarta c"),
    @NamedQuery(name = "Cuarta.findByDni", query = "SELECT c FROM Cuarta c WHERE c.dni = :dni"),
    @NamedQuery(name = "Cuarta.findByNSerie", query = "SELECT c FROM Cuarta c WHERE c.nSerie = :nSerie"),
    @NamedQuery(name = "Cuarta.findByNRecibo", query = "SELECT c FROM Cuarta c WHERE c.nRecibo = :nRecibo"),
    @NamedQuery(name = "Cuarta.findByRemAseg", query = "SELECT c FROM Cuarta c WHERE c.remAseg = :remAseg")})
public class Cuarta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "n_serie")
    private Integer nSerie;
    @Column(name = "n_recibo")
    private Integer nRecibo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rem_aseg")
    private BigDecimal remAseg;

    public Cuarta() {
    }

    public Cuarta(Integer dni) {
        this.dni = dni;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getNSerie() {
        return nSerie;
    }

    public void setNSerie(Integer nSerie) {
        this.nSerie = nSerie;
    }

    public Integer getNRecibo() {
        return nRecibo;
    }

    public void setNRecibo(Integer nRecibo) {
        this.nRecibo = nRecibo;
    }

    public BigDecimal getRemAseg() {
        return remAseg;
    }

    public void setRemAseg(BigDecimal remAseg) {
        this.remAseg = remAseg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuarta)) {
            return false;
        }
        Cuarta other = (Cuarta) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Cuarta[ dni=" + dni + " ]";
    }
    
}
