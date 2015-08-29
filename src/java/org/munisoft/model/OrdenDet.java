/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Orden_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDet.findAll", query = "SELECT o FROM OrdenDet o"),
    @NamedQuery(name = "OrdenDet.findByAnoEje", query = "SELECT o FROM OrdenDet o WHERE o.ordenDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "OrdenDet.findByNOrden", query = "SELECT o FROM OrdenDet o WHERE o.ordenDetPK.nOrden = :nOrden"),
    @NamedQuery(name = "OrdenDet.findByTipo", query = "SELECT o FROM OrdenDet o WHERE o.ordenDetPK.tipo = :tipo"),
    @NamedQuery(name = "OrdenDet.findByItem", query = "SELECT o FROM OrdenDet o WHERE o.ordenDetPK.item = :item"),
    @NamedQuery(name = "OrdenDet.findByNumDoc", query = "SELECT o FROM OrdenDet o WHERE o.numDoc = :numDoc"),
    @NamedQuery(name = "OrdenDet.findByEspecifica", query = "SELECT o FROM OrdenDet o WHERE o.especifica = :especifica"),
    @NamedQuery(name = "OrdenDet.findByCantidad", query = "SELECT o FROM OrdenDet o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenDet.findBySaldo", query = "SELECT o FROM OrdenDet o WHERE o.saldo = :saldo"),
    @NamedQuery(name = "OrdenDet.findByFactor", query = "SELECT o FROM OrdenDet o WHERE o.factor = :factor"),
    @NamedQuery(name = "OrdenDet.findBySalida", query = "SELECT o FROM OrdenDet o WHERE o.salida = :salida"),
    @NamedQuery(name = "OrdenDet.findByIdItem", query = "SELECT o FROM OrdenDet o WHERE o.idItem = :idItem"),
    @NamedQuery(name = "OrdenDet.findByUnidad", query = "SELECT o FROM OrdenDet o WHERE o.unidad = :unidad"),
    @NamedQuery(name = "OrdenDet.findByDescInsumo", query = "SELECT o FROM OrdenDet o WHERE o.descInsumo = :descInsumo"),
    @NamedQuery(name = "OrdenDet.findByDescCalidad", query = "SELECT o FROM OrdenDet o WHERE o.descCalidad = :descCalidad"),
    @NamedQuery(name = "OrdenDet.findByPrecioAdj", query = "SELECT o FROM OrdenDet o WHERE o.precioAdj = :precioAdj"),
    @NamedQuery(name = "OrdenDet.findByCantIng", query = "SELECT o FROM OrdenDet o WHERE o.cantIng = :cantIng"),
    @NamedQuery(name = "OrdenDet.findByTemporal", query = "SELECT o FROM OrdenDet o WHERE o.temporal = :temporal"),
    @NamedQuery(name = "OrdenDet.findByUnidadAlm", query = "SELECT o FROM OrdenDet o WHERE o.unidadAlm = :unidadAlm")})
public class OrdenDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenDetPK ordenDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_doc")
    private String numDoc;
    @Size(max = 16)
    @Column(name = "especifica")
    private String especifica;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "factor")
    private Integer factor;
    @Column(name = "salida")
    private BigDecimal salida;
    @Size(max = 13)
    @Column(name = "id_item")
    private String idItem;
    @Size(max = 4)
    @Column(name = "unidad")
    private String unidad;
    @Size(max = 7000)
    @Column(name = "desc_insumo")
    private String descInsumo;
    @Size(max = 1000)
    @Column(name = "desc_calidad")
    private String descCalidad;
    @Column(name = "precio_adj")
    private BigDecimal precioAdj;
    @Column(name = "cant_ing")
    private BigDecimal cantIng;
    @Column(name = "temporal")
    private BigDecimal temporal;
    @Size(max = 10)
    @Column(name = "unidad_alm")
    private String unidadAlm;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "n_orden", referencedColumnName = "n_orden", insertable = false, updatable = false),
        @JoinColumn(name = "tipo", referencedColumnName = "tipo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Orden orden;

    public OrdenDet() {
    }

    public OrdenDet(OrdenDetPK ordenDetPK) {
        this.ordenDetPK = ordenDetPK;
    }

    public OrdenDet(OrdenDetPK ordenDetPK, String numDoc) {
        this.ordenDetPK = ordenDetPK;
        this.numDoc = numDoc;
    }

    public OrdenDet(String anoEje, int nOrden, Character tipo, int item) {
        this.ordenDetPK = new OrdenDetPK(anoEje, nOrden, tipo, item);
    }

    public OrdenDetPK getOrdenDetPK() {
        return ordenDetPK;
    }

    public void setOrdenDetPK(OrdenDetPK ordenDetPK) {
        this.ordenDetPK = ordenDetPK;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getEspecifica() {
        return especifica;
    }

    public void setEspecifica(String especifica) {
        this.especifica = especifica;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public BigDecimal getSalida() {
        return salida;
    }

    public void setSalida(BigDecimal salida) {
        this.salida = salida;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescInsumo() {
        return descInsumo;
    }

    public void setDescInsumo(String descInsumo) {
        this.descInsumo = descInsumo;
    }

    public String getDescCalidad() {
        return descCalidad;
    }

    public void setDescCalidad(String descCalidad) {
        this.descCalidad = descCalidad;
    }

    public BigDecimal getPrecioAdj() {
        return precioAdj;
    }

    public void setPrecioAdj(BigDecimal precioAdj) {
        this.precioAdj = precioAdj;
    }

    public BigDecimal getCantIng() {
        return cantIng;
    }

    public void setCantIng(BigDecimal cantIng) {
        this.cantIng = cantIng;
    }

    public BigDecimal getTemporal() {
        return temporal;
    }

    public void setTemporal(BigDecimal temporal) {
        this.temporal = temporal;
    }

    public String getUnidadAlm() {
        return unidadAlm;
    }

    public void setUnidadAlm(String unidadAlm) {
        this.unidadAlm = unidadAlm;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenDetPK != null ? ordenDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDet)) {
            return false;
        }
        OrdenDet other = (OrdenDet) object;
        if ((this.ordenDetPK == null && other.ordenDetPK != null) || (this.ordenDetPK != null && !this.ordenDetPK.equals(other.ordenDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.OrdenDet[ ordenDetPK=" + ordenDetPK + " ]";
    }
    
}
