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
@Table(name = "com_caja_arqueo_detalle")
@NamedQueries({
    @NamedQuery(name = "ComCajaArqueoDetalle.findAll", query = "SELECT c FROM ComCajaArqueoDetalle c")})
public class ComCajaArqueoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComCajaArqueoDetallePK comCajaArqueoDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "razon_cambio")
    private float razonCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;

    public ComCajaArqueoDetalle() {
    }

    public ComCajaArqueoDetalle(ComCajaArqueoDetallePK comCajaArqueoDetallePK) {
        this.comCajaArqueoDetallePK = comCajaArqueoDetallePK;
    }

    public ComCajaArqueoDetalle(ComCajaArqueoDetallePK comCajaArqueoDetallePK, float razonCambio, float cantidad) {
        this.comCajaArqueoDetallePK = comCajaArqueoDetallePK;
        this.razonCambio = razonCambio;
        this.cantidad = cantidad;
    }

    public ComCajaArqueoDetalle(int idArqueo, Character idMedio, int idMoneda) {
        this.comCajaArqueoDetallePK = new ComCajaArqueoDetallePK(idArqueo, idMedio, idMoneda);
    }

    public ComCajaArqueoDetallePK getComCajaArqueoDetallePK() {
        return comCajaArqueoDetallePK;
    }

    public void setComCajaArqueoDetallePK(ComCajaArqueoDetallePK comCajaArqueoDetallePK) {
        this.comCajaArqueoDetallePK = comCajaArqueoDetallePK;
    }

    public float getRazonCambio() {
        return razonCambio;
    }

    public void setRazonCambio(float razonCambio) {
        this.razonCambio = razonCambio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comCajaArqueoDetallePK != null ? comCajaArqueoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComCajaArqueoDetalle)) {
            return false;
        }
        ComCajaArqueoDetalle other = (ComCajaArqueoDetalle) object;
        if ((this.comCajaArqueoDetallePK == null && other.comCajaArqueoDetallePK != null) || (this.comCajaArqueoDetallePK != null && !this.comCajaArqueoDetallePK.equals(other.comCajaArqueoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComCajaArqueoDetalle[ comCajaArqueoDetallePK=" + comCajaArqueoDetallePK + " ]";
    }
    
}
