/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_operacion_compra")
@NamedQueries({
    @NamedQuery(name = "ComOperacionCompra.findAll", query = "SELECT c FROM ComOperacionCompra c")})
public class ComOperacionCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Column(name = "id_dir_proveedor")
    private Integer idDirProveedor;
    @Column(name = "id_fuente_financiamiento")
    private Integer idFuenteFinanciamiento;
    @Column(name = "id_programa")
    private Integer idPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa_impuesto")
    private float tasaImpuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private float subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuesto")
    private float impuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo")
    private float saldo;
    @Column(name = "id_pecosa")
    private Integer idPecosa;

    public ComOperacionCompra() {
    }

    public ComOperacionCompra(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ComOperacionCompra(Integer idOperacion, float tasaImpuesto, float subTotal, float impuesto, float total, float saldo) {
        this.idOperacion = idOperacion;
        this.tasaImpuesto = tasaImpuesto;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.saldo = saldo;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdDirProveedor() {
        return idDirProveedor;
    }

    public void setIdDirProveedor(Integer idDirProveedor) {
        this.idDirProveedor = idDirProveedor;
    }

    public Integer getIdFuenteFinanciamiento() {
        return idFuenteFinanciamiento;
    }

    public void setIdFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public float getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(float tasaImpuesto) {
        this.tasaImpuesto = tasaImpuesto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Integer getIdPecosa() {
        return idPecosa;
    }

    public void setIdPecosa(Integer idPecosa) {
        this.idPecosa = idPecosa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOperacionCompra)) {
            return false;
        }
        ComOperacionCompra other = (ComOperacionCompra) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacionCompra[ idOperacion=" + idOperacion + " ]";
    }
    
}
