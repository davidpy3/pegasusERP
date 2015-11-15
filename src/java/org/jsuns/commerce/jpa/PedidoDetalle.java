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
@Table(name = "son_pedido_detalle")
public class PedidoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidoDetallePK pedidoDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    public PedidoDetalle() {
    }

    public PedidoDetalle(PedidoDetallePK pedidoDetallePK) {
        this.pedidoDetallePK = pedidoDetallePK;
    }

    public PedidoDetalle(int idPedido, int idArticulo) {
        this.pedidoDetallePK = new PedidoDetallePK(idPedido, idArticulo);
    }

    public PedidoDetallePK getPedidoDetallePK() {
        return pedidoDetallePK;
    }

    public void setPedidoDetallePK(PedidoDetallePK pedidoDetallePK) {
        this.pedidoDetallePK = pedidoDetallePK;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoDetallePK != null ? pedidoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetalle)) {
            return false;
        }
        PedidoDetalle other = (PedidoDetalle) object;
        if ((this.pedidoDetallePK == null && other.pedidoDetallePK != null) || (this.pedidoDetallePK != null && !this.pedidoDetallePK.equals(other.pedidoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.PedidoDetalle[ pedidoDetallePK=" + pedidoDetallePK + " ]";
    }
    
}
