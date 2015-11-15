/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "pecosa_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecosaDetalle.findAll", query = "SELECT p FROM PecosaDetalle p"),
    @NamedQuery(name = "PecosaDetalle.findByAnoEje", query = "SELECT p FROM PecosaDetalle p WHERE p.pecosaDetallePK.anoEje = :anoEje"),
    @NamedQuery(name = "PecosaDetalle.findByNPecosa", query = "SELECT p FROM PecosaDetalle p WHERE p.pecosaDetallePK.nPecosa = :nPecosa"),
    @NamedQuery(name = "PecosaDetalle.findByItem", query = "SELECT p FROM PecosaDetalle p WHERE p.pecosaDetallePK.item = :item"),
    @NamedQuery(name = "PecosaDetalle.findByCantidad", query = "SELECT p FROM PecosaDetalle p WHERE p.cantidad = :cantidad")})
public class PecosaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecosaDetallePK pecosaDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "n_pecosa", referencedColumnName = "n_pecosa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pecosa pecosa;

    public PecosaDetalle() {
    }

    public PecosaDetalle(PecosaDetallePK pecosaDetallePK) {
        this.pecosaDetallePK = pecosaDetallePK;
    }

    public PecosaDetalle(String anoEje, int nPecosa, int item) {
        this.pecosaDetallePK = new PecosaDetallePK(anoEje, nPecosa, item);
    }

    public PecosaDetallePK getPecosaDetallePK() {
        return pecosaDetallePK;
    }

    public void setPecosaDetallePK(PecosaDetallePK pecosaDetallePK) {
        this.pecosaDetallePK = pecosaDetallePK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Pecosa getPecosa() {
        return pecosa;
    }

    public void setPecosa(Pecosa pecosa) {
        this.pecosa = pecosa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecosaDetallePK != null ? pecosaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecosaDetalle)) {
            return false;
        }
        PecosaDetalle other = (PecosaDetalle) object;
        if ((this.pecosaDetallePK == null && other.pecosaDetallePK != null) || (this.pecosaDetallePK != null && !this.pecosaDetallePK.equals(other.pecosaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PecosaDetalle[ pecosaDetallePK=" + pecosaDetallePK + " ]";
    }
    
}
