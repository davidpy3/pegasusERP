/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_orden_servicio_detalle")
@NamedQueries({
    @NamedQuery(name = "ComOrdenServicioDetalle.findAll", query = "SELECT c FROM ComOrdenServicioDetalle c")})
public class ComOrdenServicioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComOrdenServicioDetallePK comOrdenServicioDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio")
    private int idServicio;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_unidad")
    private Integer idUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "precio")
    private Float precio;
    @Column(name = "sub_total")
    private Float subTotal;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "estado")
    private Boolean estado;

    public ComOrdenServicioDetalle() {
    }

    public ComOrdenServicioDetalle(ComOrdenServicioDetallePK comOrdenServicioDetallePK) {
        this.comOrdenServicioDetallePK = comOrdenServicioDetallePK;
    }

    public ComOrdenServicioDetalle(ComOrdenServicioDetallePK comOrdenServicioDetallePK, int idServicio) {
        this.comOrdenServicioDetallePK = comOrdenServicioDetallePK;
        this.idServicio = idServicio;
    }

    public ComOrdenServicioDetalle(int idItem, int idOperacion) {
        this.comOrdenServicioDetallePK = new ComOrdenServicioDetallePK(idItem, idOperacion);
    }

    public ComOrdenServicioDetallePK getComOrdenServicioDetallePK() {
        return comOrdenServicioDetallePK;
    }

    public void setComOrdenServicioDetallePK(ComOrdenServicioDetallePK comOrdenServicioDetallePK) {
        this.comOrdenServicioDetallePK = comOrdenServicioDetallePK;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comOrdenServicioDetallePK != null ? comOrdenServicioDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOrdenServicioDetalle)) {
            return false;
        }
        ComOrdenServicioDetalle other = (ComOrdenServicioDetalle) object;
        if ((this.comOrdenServicioDetallePK == null && other.comOrdenServicioDetallePK != null) || (this.comOrdenServicioDetallePK != null && !this.comOrdenServicioDetallePK.equals(other.comOrdenServicioDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOrdenServicioDetalle[ comOrdenServicioDetallePK=" + comOrdenServicioDetallePK + " ]";
    }
    
}
