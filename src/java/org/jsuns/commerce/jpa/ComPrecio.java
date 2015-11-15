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
@Table(name = "com_precio")
@NamedQueries({
    @NamedQuery(name = "ComPrecio.findAll", query = "SELECT c FROM ComPrecio c")})
public class ComPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_precio")
    private Integer idPrecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad")
    private int idUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plan")
    private int idPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "meses")
    private int meses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo")
    private int idGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;

    public ComPrecio() {
    }

    public ComPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public ComPrecio(Integer idPrecio, int idArticulo, int idUnidad, int cantidad, int idPlan, int meses, int idGrupo, float precio) {
        this.idPrecio = idPrecio;
        this.idArticulo = idArticulo;
        this.idUnidad = idUnidad;
        this.cantidad = cantidad;
        this.idPlan = idPlan;
        this.meses = meses;
        this.idGrupo = idGrupo;
        this.precio = precio;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPrecio)) {
            return false;
        }
        ComPrecio other = (ComPrecio) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComPrecio[ idPrecio=" + idPrecio + " ]";
    }
    
}
