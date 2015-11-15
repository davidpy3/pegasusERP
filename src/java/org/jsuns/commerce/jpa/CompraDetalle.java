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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.jsuns.commerce.jpa.ComArticulo;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "compra_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraDetalle.findAll", query = "SELECT c FROM CompraDetalle c"),
    @NamedQuery(name = "CompraDetalle.findByIdCompra", query = "SELECT c FROM CompraDetalle c WHERE c.compraDetallePK.idCompra = :idCompra"),
    @NamedQuery(name = "CompraDetalle.findByIdArticulo", query = "SELECT c FROM CompraDetalle c WHERE c.compraDetallePK.idArticulo = :idArticulo"),
    @NamedQuery(name = "CompraDetalle.findByCantCompra", query = "SELECT c FROM CompraDetalle c WHERE c.cantCompra = :cantCompra"),
    @NamedQuery(name = "CompraDetalle.findByPrecioCompra", query = "SELECT c FROM CompraDetalle c WHERE c.precioCompra = :precioCompra")})
public class CompraDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraDetallePK compraDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant_compra")
    private BigDecimal cantCompra;
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compra compra;

    public CompraDetalle() {
    }

    public CompraDetalle(CompraDetallePK compraDetallePK) {
        this.compraDetallePK = compraDetallePK;
    }

    public CompraDetalle(int idCompra, int idArticulo) {
        this.compraDetallePK = new CompraDetallePK(idCompra, idArticulo);
    }

    public CompraDetallePK getCompraDetallePK() {
        return compraDetallePK;
    }

    public void setCompraDetallePK(CompraDetallePK compraDetallePK) {
        this.compraDetallePK = compraDetallePK;
    }

    public BigDecimal getCantCompra() {
        return cantCompra;
    }

    public void setCantCompra(BigDecimal cantCompra) {
        this.cantCompra = cantCompra;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraDetallePK != null ? compraDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraDetalle)) {
            return false;
        }
        CompraDetalle other = (CompraDetalle) object;
        if ((this.compraDetallePK == null && other.compraDetallePK != null) || (this.compraDetallePK != null && !this.compraDetallePK.equals(other.compraDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.CompraDetalle[ compraDetallePK=" + compraDetallePK + " ]";
    }
    
}
