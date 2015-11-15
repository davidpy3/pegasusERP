/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.jsuns.commerce.jpa.ComArticulo;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_almacen_articulo")
public class AlmacenArticulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlmacenArticuloPK almacenArticuloPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant")
    private BigDecimal cant;
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SonAlmacen almacen;

    public AlmacenArticulo() {
    }

    public AlmacenArticulo(AlmacenArticuloPK almacenArticuloPK) {
        this.almacenArticuloPK = almacenArticuloPK;
    }

    public AlmacenArticuloPK getAlmacenArticuloPK() {
        return almacenArticuloPK;
    }

    public void setAlmacenArticuloPK(AlmacenArticuloPK almacenArticuloPK) {
        this.almacenArticuloPK = almacenArticuloPK;
    }

    public BigDecimal getCantidad() {
        return cant;
    }

    public void setCantidad(BigDecimal cant) {
        this.cant = cant;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    public SonAlmacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(SonAlmacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almacenArticuloPK != null ? almacenArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmacenArticulo)) {
            return false;
        }
        AlmacenArticulo other = (AlmacenArticulo) object;
        if ((this.almacenArticuloPK == null && other.almacenArticuloPK != null) || (this.almacenArticuloPK != null && !this.almacenArticuloPK.equals(other.almacenArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.AlmacenArticulo[ almacenArticuloPK=" + almacenArticuloPK + " ]";
    }
    
}
