/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_articulo")
@NamedQueries({
    @NamedQuery(name = "ComArticulo.findAll", query = "SELECT c FROM ComArticulo c")})
public class ComArticulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private Integer idArticulo;
    @Size(max = 2)
    @Column(name = "id_grupo")
    private String idGrupo;
    @Size(max = 2)
    @Column(name = "id_clase")
    private String idClase;
    @Size(max = 4)
    @Column(name = "id_familia")
    private String idFamilia;
    @Size(max = 4)
    @Column(name = "numero")
    private String numero;
    @Size(max = 13)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 4)
    @Column(name = "siglas")
    private String siglas;
    @Size(max = 17)
    @Column(name = "barras")
    private String barras;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_unidad")
    private Integer idUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_unidad")
    private Float cantidadUnidad;
    @Column(name = "composicion")
    private Character composicion;
    @Column(name = "stock_min")
    private Long stockMin;
    @Column(name = "stock_max")
    private Long stockMax;
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "precio")
    private BigDecimal precio;
    @Size(max = 30)
    @Column(name = "marca")
    private String marca;
    @Size(max = 30)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 30)
    @Column(name = "serie")
    private String serie;
    @Size(max = 30)
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventariable")
    private boolean inventariable;
    @Size(max = 20)
    @Column(name = "id_cuenta_mayor")
    private String idCuentaMayor;
    @Size(max = 2)
    @Column(name = "id_sub_cuenta")
    private String idSubCuenta;
    @Size(max = 2)
    @Column(name = "id_divisionaria")
    private String idDivisionaria;
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "fid")
    private Integer fid;
    @Column(name = "comision")
    private BigDecimal comision;

    public ComArticulo() {
    }

    public ComArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public ComArticulo(Integer idArticulo, boolean inventariable) {
        this.idArticulo = idArticulo;
        this.inventariable = inventariable;
    }

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getBarras() {
        return barras;
    }

    public void setBarras(String barras) {
        this.barras = barras;
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

    public Float getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(Float cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }

    public Character getComposicion() {
        return composicion;
    }

    public void setComposicion(Character composicion) {
        this.composicion = composicion;
    }

    public Long getStockMin() {
        return stockMin;
    }

    public void setStockMin(Long stockMin) {
        this.stockMin = stockMin;
    }

    public Long getStockMax() {
        return stockMax;
    }

    public void setStockMax(Long stockMax) {
        this.stockMax = stockMax;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public boolean getInventariable() {
        return inventariable;
    }

    public void setInventariable(boolean inventariable) {
        this.inventariable = inventariable;
    }

    public String getIdCuentaMayor() {
        return idCuentaMayor;
    }

    public void setIdCuentaMayor(String idCuentaMayor) {
        this.idCuentaMayor = idCuentaMayor;
    }

    public String getIdSubCuenta() {
        return idSubCuenta;
    }

    public void setIdSubCuenta(String idSubCuenta) {
        this.idSubCuenta = idSubCuenta;
    }

    public String getIdDivisionaria() {
        return idDivisionaria;
    }

    public void setIdDivisionaria(String idDivisionaria) {
        this.idDivisionaria = idDivisionaria;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComArticulo)) {
            return false;
        }
        ComArticulo other = (ComArticulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComArticulo[ idArticulo=" + idArticulo + " ]";
    }
    
}
