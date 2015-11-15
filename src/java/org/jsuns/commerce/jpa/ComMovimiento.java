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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "com_movimiento")
@NamedQueries({
    @NamedQuery(name = "ComMovimiento.findAll", query = "SELECT c FROM ComMovimiento c")})
public class ComMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_movimiento")
    private int idTipoMovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_tipo_operacion")
    private String idTipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "id_unidad")
    private Integer idUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private float stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_x")
    private float stockX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_u")
    private float stockU;
    @Column(name = "id_item")
    private Integer idItem;

    public ComMovimiento() {
    }

    public ComMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public ComMovimiento(Integer idMovimiento, int idDep, int idArticulo, int idTipoMovimiento, String idTipoOperacion, Date fecha, float cantidad, float stock, float stockX, float stockU) {
        this.idMovimiento = idMovimiento;
        this.idDep = idDep;
        this.idArticulo = idArticulo;
        this.idTipoMovimiento = idTipoMovimiento;
        this.idTipoOperacion = idTipoOperacion;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.stock = stock;
        this.stockX = stockX;
        this.stockU = stockU;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(String idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getStockX() {
        return stockX;
    }

    public void setStockX(float stockX) {
        this.stockX = stockX;
    }

    public float getStockU() {
        return stockU;
    }

    public void setStockU(float stockU) {
        this.stockU = stockU;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComMovimiento)) {
            return false;
        }
        ComMovimiento other = (ComMovimiento) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComMovimiento[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
