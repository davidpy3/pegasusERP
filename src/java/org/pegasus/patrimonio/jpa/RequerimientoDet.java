/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Requer_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequerimientoDet.findAll", query = "SELECT r FROM RequerimientoDet r"),
    @NamedQuery(name = "RequerimientoDet.findByAnoEje", query = "SELECT r FROM RequerimientoDet r WHERE r.requerimientoDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "RequerimientoDet.findByClasifica", query = "SELECT r FROM RequerimientoDet r WHERE r.requerimientoDetPK.clasifica = :clasifica"),
    @NamedQuery(name = "RequerimientoDet.findByNRequer", query = "SELECT r FROM RequerimientoDet r WHERE r.requerimientoDetPK.nRequer = :nRequer"),
    @NamedQuery(name = "RequerimientoDet.findByItem", query = "SELECT r FROM RequerimientoDet r WHERE r.requerimientoDetPK.item = :item"),
    @NamedQuery(name = "RequerimientoDet.findByCantidad", query = "SELECT r FROM RequerimientoDet r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "RequerimientoDet.findByIdItem", query = "SELECT r FROM RequerimientoDet r WHERE r.idItem = :idItem"),
    @NamedQuery(name = "RequerimientoDet.findByPrecioRef", query = "SELECT r FROM RequerimientoDet r WHERE r.precioRef = :precioRef"),
    @NamedQuery(name = "RequerimientoDet.findByDetalle", query = "SELECT r FROM RequerimientoDet r WHERE r.detalle = :detalle"),
    @NamedQuery(name = "RequerimientoDet.findByIdUnidad", query = "SELECT r FROM RequerimientoDet r WHERE r.idUnidad = :idUnidad")})
public class RequerimientoDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequerimientoDetPK requerimientoDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "id_item")
    private String idItem;
    @Column(name = "precio_ref")
    private BigDecimal precioRef;
    @Size(max = 7000)
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "id_unidad")
    private Integer idUnidad;

    public RequerimientoDet() {
    }

    public RequerimientoDet(RequerimientoDetPK requerimientoDetPK) {
        this.requerimientoDetPK = requerimientoDetPK;
    }

    public RequerimientoDet(RequerimientoDetPK requerimientoDetPK, BigDecimal cantidad, String idItem) {
        this.requerimientoDetPK = requerimientoDetPK;
        this.cantidad = cantidad;
        this.idItem = idItem;
    }

    public RequerimientoDet(String anoEje, Character clasifica, int nRequer, int item) {
        this.requerimientoDetPK = new RequerimientoDetPK(anoEje, clasifica, nRequer, item);
    }

    public RequerimientoDetPK getRequerimientoDetPK() {
        return requerimientoDetPK;
    }

    public void setRequerimientoDetPK(RequerimientoDetPK requerimientoDetPK) {
        this.requerimientoDetPK = requerimientoDetPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public BigDecimal getPrecioRef() {
        return precioRef;
    }

    public void setPrecioRef(BigDecimal precioRef) {
        this.precioRef = precioRef;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requerimientoDetPK != null ? requerimientoDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequerimientoDet)) {
            return false;
        }
        RequerimientoDet other = (RequerimientoDet) object;
        if ((this.requerimientoDetPK == null && other.requerimientoDetPK != null) || (this.requerimientoDetPK != null && !this.requerimientoDetPK.equals(other.requerimientoDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RequerimientoDet[ requerimientoDetPK=" + requerimientoDetPK + " ]";
    }
    
}
