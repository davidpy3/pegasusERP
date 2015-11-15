/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorik
 */
@Embeddable
public class PedidoDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;

    public PedidoDetallePK() {
    }

    public PedidoDetallePK(int idPedido, int idArticulo) {
        this.idPedido = idPedido;
        this.idArticulo = idArticulo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetallePK)) {
            return false;
        }
        PedidoDetallePK other = (PedidoDetallePK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.PedidoDetallePK[ idPedido=" + idPedido + ", idArticulo=" + idArticulo + " ]";
    }
    
}
