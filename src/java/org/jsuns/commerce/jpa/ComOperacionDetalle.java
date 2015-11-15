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
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_operacion_detalle")
@NamedQueries({
    @NamedQuery(name = "ComOperacionDetalle.findAll", query = "SELECT c FROM ComOperacionDetalle c")})
public class ComOperacionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComOperacionDetallePK comOperacionDetallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 13)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Column(name = "id_plan")
    private Integer idPlan;
    @Column(name = "meses")
    private Integer meses;
    @Column(name = "id_grupo")
    private Integer idGrupo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private float costo;
    @Size(max = 10)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "alta")
    private String alta;
    @Column(name = "id_marca")
    private Integer idMarca;
    @Column(name = "id_modelo")
    private Integer idModelo;
    @Column(name = "disponible")
    private Float disponible;
    @Size(max = 100)
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "id_unidad")
    private Integer idUnidad;
    @Column(name = "cantidad_paquete")
    private Integer cantidadPaquete;
    @Column(name = "sub_total")
    private Float subTotal;
    @Column(name = "id_operacion_origen")
    private Integer idOperacionOrigen;
    @Column(name = "id_item_origen")
    private Integer idItemOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_alta")
    private Integer idAlta;

    public ComOperacionDetalle() {
    }

    public ComOperacionDetalle(ComOperacionDetallePK comOperacionDetallePK) {
        this.comOperacionDetallePK = comOperacionDetallePK;
    }

    public ComOperacionDetalle(ComOperacionDetallePK comOperacionDetallePK, int idArticulo, String descripcion, float cantidad, float costo, boolean estado) {
        this.comOperacionDetallePK = comOperacionDetallePK;
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
        this.estado = estado;
    }

    public ComOperacionDetalle(int idItem, int idOperacion) {
        this.comOperacionDetallePK = new ComOperacionDetallePK(idItem, idOperacion);
    }

    public ComOperacionDetallePK getComOperacionDetallePK() {
        return comOperacionDetallePK;
    }

    public void setComOperacionDetallePK(ComOperacionDetallePK comOperacionDetallePK) {
        this.comOperacionDetallePK = comOperacionDetallePK;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAlta() {
        return alta;
    }

    public void setAlta(String alta) {
        this.alta = alta;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Float getDisponible() {
        return disponible;
    }

    public void setDisponible(Float disponible) {
        this.disponible = disponible;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getCantidadPaquete() {
        return cantidadPaquete;
    }

    public void setCantidadPaquete(Integer cantidadPaquete) {
        this.cantidadPaquete = cantidadPaquete;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIdOperacionOrigen() {
        return idOperacionOrigen;
    }

    public void setIdOperacionOrigen(Integer idOperacionOrigen) {
        this.idOperacionOrigen = idOperacionOrigen;
    }

    public Integer getIdItemOrigen() {
        return idItemOrigen;
    }

    public void setIdItemOrigen(Integer idItemOrigen) {
        this.idItemOrigen = idItemOrigen;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdAlta() {
        return idAlta;
    }

    public void setIdAlta(Integer idAlta) {
        this.idAlta = idAlta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comOperacionDetallePK != null ? comOperacionDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOperacionDetalle)) {
            return false;
        }
        ComOperacionDetalle other = (ComOperacionDetalle) object;
        if ((this.comOperacionDetallePK == null && other.comOperacionDetallePK != null) || (this.comOperacionDetallePK != null && !this.comOperacionDetallePK.equals(other.comOperacionDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacionDetalle[ comOperacionDetallePK=" + comOperacionDetallePK + " ]";
    }
    
}
