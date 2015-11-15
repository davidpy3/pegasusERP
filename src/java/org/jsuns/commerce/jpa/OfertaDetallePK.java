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
public class OfertaDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_oferta")
    private int idOferta;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;

    public OfertaDetallePK() {
    }

    public OfertaDetallePK(int idOferta, int idArticulo, double cantidad) {
        this.idOferta = idOferta;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOferta;
        hash += (int) idArticulo;
        hash += (int) cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaDetallePK)) {
            return false;
        }
        OfertaDetallePK other = (OfertaDetallePK) object;
        if (this.idOferta != other.idOferta) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.OfertaDetallePK[ idOferta=" + idOferta + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad + " ]";
    }
    
}
