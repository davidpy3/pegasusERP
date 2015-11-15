/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_stock")
@NamedQueries({
    @NamedQuery(name = "ComStock.findAll", query = "SELECT c FROM ComStock c")})
public class ComStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComStockPK comStockPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_x")
    private float cantidadX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_u")
    private float cantidadU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acumulado_s")
    private float acumuladoS;

    public ComStock() {
    }

    public ComStock(ComStockPK comStockPK) {
        this.comStockPK = comStockPK;
    }

    public ComStock(ComStockPK comStockPK, float cantidad, float cantidadX, float cantidadU, float acumuladoS) {
        this.comStockPK = comStockPK;
        this.cantidad = cantidad;
        this.cantidadX = cantidadX;
        this.cantidadU = cantidadU;
        this.acumuladoS = acumuladoS;
    }

    public ComStock(int idDep, int idArticulo) {
        this.comStockPK = new ComStockPK(idDep, idArticulo);
    }

    public ComStockPK getComStockPK() {
        return comStockPK;
    }

    public void setComStockPK(ComStockPK comStockPK) {
        this.comStockPK = comStockPK;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getCantidadX() {
        return cantidadX;
    }

    public void setCantidadX(float cantidadX) {
        this.cantidadX = cantidadX;
    }

    public float getCantidadU() {
        return cantidadU;
    }

    public void setCantidadU(float cantidadU) {
        this.cantidadU = cantidadU;
    }

    public float getAcumuladoS() {
        return acumuladoS;
    }

    public void setAcumuladoS(float acumuladoS) {
        this.acumuladoS = acumuladoS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comStockPK != null ? comStockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComStock)) {
            return false;
        }
        ComStock other = (ComStock) object;
        if ((this.comStockPK == null && other.comStockPK != null) || (this.comStockPK != null && !this.comStockPK.equals(other.comStockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComStock[ comStockPK=" + comStockPK + " ]";
    }
    
}
