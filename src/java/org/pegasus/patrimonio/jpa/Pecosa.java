/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "PECOSA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pecosa.findAll", query = "SELECT p FROM Pecosa p"),
    @NamedQuery(name = "Pecosa.findByAnoEje", query = "SELECT p FROM Pecosa p WHERE p.pecosaPK.anoEje = :anoEje"),
    @NamedQuery(name = "Pecosa.findByNPecosa", query = "SELECT p FROM Pecosa p WHERE p.pecosaPK.nPecosa = :nPecosa"),
    @NamedQuery(name = "Pecosa.findByAnoEjeO", query = "SELECT p FROM Pecosa p WHERE p.anoEjeO = :anoEjeO"),
    @NamedQuery(name = "Pecosa.findByNOrden", query = "SELECT p FROM Pecosa p WHERE p.nOrden = :nOrden"),
    @NamedQuery(name = "Pecosa.findByTipo", query = "SELECT p FROM Pecosa p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pecosa.findByFecha", query = "SELECT p FROM Pecosa p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pecosa.findByEntregarA", query = "SELECT p FROM Pecosa p WHERE p.entregarA = :entregarA"),
    @NamedQuery(name = "Pecosa.findByNSiaf", query = "SELECT p FROM Pecosa p WHERE p.nSiaf = :nSiaf"),
    @NamedQuery(name = "Pecosa.findBySerieFact", query = "SELECT p FROM Pecosa p WHERE p.serieFact = :serieFact"),
    @NamedQuery(name = "Pecosa.findByNumFact", query = "SELECT p FROM Pecosa p WHERE p.numFact = :numFact"),
    @NamedQuery(name = "Pecosa.findByObservaciones", query = "SELECT p FROM Pecosa p WHERE p.observaciones = :observaciones")})
public class Pecosa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecosaPK pecosaPK;
    @Size(max = 4)
    @Column(name = "ano_eje_o")
    private String anoEjeO;
    @Column(name = "n_orden")
    private Integer nOrden;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "entregar_a")
    private String entregarA;
    @Column(name = "n_siaf")
    private Integer nSiaf;
    @Column(name = "serie_fact")
    private Integer serieFact;
    @Column(name = "num_fact")
    private BigInteger numFact;
    @Size(max = 300)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pecosa")
    private Collection<PecosaDetalle> pecosaDetalleCollection;

    public Pecosa() {
    }

    public Pecosa(PecosaPK pecosaPK) {
        this.pecosaPK = pecosaPK;
    }

    public Pecosa(String anoEje, int nPecosa) {
        this.pecosaPK = new PecosaPK(anoEje, nPecosa);
    }

    public PecosaPK getPecosaPK() {
        return pecosaPK;
    }

    public void setPecosaPK(PecosaPK pecosaPK) {
        this.pecosaPK = pecosaPK;
    }

    public String getAnoEjeO() {
        return anoEjeO;
    }

    public void setAnoEjeO(String anoEjeO) {
        this.anoEjeO = anoEjeO;
    }

    public Integer getNOrden() {
        return nOrden;
    }

    public void setNOrden(Integer nOrden) {
        this.nOrden = nOrden;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEntregarA() {
        return entregarA;
    }

    public void setEntregarA(String entregarA) {
        this.entregarA = entregarA;
    }

    public Integer getNSiaf() {
        return nSiaf;
    }

    public void setNSiaf(Integer nSiaf) {
        this.nSiaf = nSiaf;
    }

    public Integer getSerieFact() {
        return serieFact;
    }

    public void setSerieFact(Integer serieFact) {
        this.serieFact = serieFact;
    }

    public BigInteger getNumFact() {
        return numFact;
    }

    public void setNumFact(BigInteger numFact) {
        this.numFact = numFact;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<PecosaDetalle> getPecosaDetalleCollection() {
        return pecosaDetalleCollection;
    }

    public void setPecosaDetalleCollection(Collection<PecosaDetalle> pecosaDetalleCollection) {
        this.pecosaDetalleCollection = pecosaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecosaPK != null ? pecosaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pecosa)) {
            return false;
        }
        Pecosa other = (Pecosa) object;
        if ((this.pecosaPK == null && other.pecosaPK != null) || (this.pecosaPK != null && !this.pecosaPK.equals(other.pecosaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Pecosa[ pecosaPK=" + pecosaPK + " ]";
    }
    
}
