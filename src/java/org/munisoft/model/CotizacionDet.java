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
@Table(name = "Cotiza_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotizacionDet.findAll", query = "SELECT c FROM CotizacionDet c"),
    @NamedQuery(name = "CotizacionDet.findByAnoEje", query = "SELECT c FROM CotizacionDet c WHERE c.cotizacionDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "CotizacionDet.findByClasifica", query = "SELECT c FROM CotizacionDet c WHERE c.cotizacionDetPK.clasifica = :clasifica"),
    @NamedQuery(name = "CotizacionDet.findByNRequer", query = "SELECT c FROM CotizacionDet c WHERE c.cotizacionDetPK.nRequer = :nRequer"),
    @NamedQuery(name = "CotizacionDet.findByNCotiza", query = "SELECT c FROM CotizacionDet c WHERE c.cotizacionDetPK.nCotiza = :nCotiza"),
    @NamedQuery(name = "CotizacionDet.findByItem", query = "SELECT c FROM CotizacionDet c WHERE c.cotizacionDetPK.item = :item"),
    @NamedQuery(name = "CotizacionDet.findByRucItem", query = "SELECT c FROM CotizacionDet c WHERE c.rucItem = :rucItem"),
    @NamedQuery(name = "CotizacionDet.findByIdItem", query = "SELECT c FROM CotizacionDet c WHERE c.idItem = :idItem"),
    @NamedQuery(name = "CotizacionDet.findByDetalleItem", query = "SELECT c FROM CotizacionDet c WHERE c.detalleItem = :detalleItem"),
    @NamedQuery(name = "CotizacionDet.findByDescCalidad", query = "SELECT c FROM CotizacionDet c WHERE c.descCalidad = :descCalidad"),
    @NamedQuery(name = "CotizacionDet.findByCantidad", query = "SELECT c FROM CotizacionDet c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CotizacionDet.findByPrecioPostor", query = "SELECT c FROM CotizacionDet c WHERE c.precioPostor = :precioPostor"),
    @NamedQuery(name = "CotizacionDet.findByParticipa", query = "SELECT c FROM CotizacionDet c WHERE c.participa = :participa"),
    @NamedQuery(name = "CotizacionDet.findByGanadorItem", query = "SELECT c FROM CotizacionDet c WHERE c.ganadorItem = :ganadorItem"),
    @NamedQuery(name = "CotizacionDet.findByIdUnidad", query = "SELECT c FROM CotizacionDet c WHERE c.idUnidad = :idUnidad")})
public class CotizacionDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CotizacionDetPK cotizacionDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "ruc_item")
    private String rucItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "id_item")
    private String idItem;
    @Size(max = 7000)
    @Column(name = "detalle_item")
    private String detalleItem;
    @Size(max = 1000)
    @Column(name = "desc_calidad")
    private String descCalidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "precio_postor")
    private BigDecimal precioPostor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "participa")
    private Character participa;
    @Column(name = "ganador_item")
    private Character ganadorItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad")
    private int idUnidad;

    public CotizacionDet() {
    }

    public CotizacionDet(CotizacionDetPK cotizacionDetPK) {
        this.cotizacionDetPK = cotizacionDetPK;
    }

    public CotizacionDet(CotizacionDetPK cotizacionDetPK, String rucItem, String idItem, BigDecimal cantidad, Character participa, int idUnidad) {
        this.cotizacionDetPK = cotizacionDetPK;
        this.rucItem = rucItem;
        this.idItem = idItem;
        this.cantidad = cantidad;
        this.participa = participa;
        this.idUnidad = idUnidad;
    }

    public CotizacionDet(String anoEje, Character clasifica, int nRequer, int nCotiza, int item) {
        this.cotizacionDetPK = new CotizacionDetPK(anoEje, clasifica, nRequer, nCotiza, item);
    }

    public CotizacionDetPK getCotizacionDetPK() {
        return cotizacionDetPK;
    }

    public void setCotizacionDetPK(CotizacionDetPK cotizacionDetPK) {
        this.cotizacionDetPK = cotizacionDetPK;
    }

    public String getRucItem() {
        return rucItem;
    }

    public void setRucItem(String rucItem) {
        this.rucItem = rucItem;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getDetalleItem() {
        return detalleItem;
    }

    public void setDetalleItem(String detalleItem) {
        this.detalleItem = detalleItem;
    }

    public String getDescCalidad() {
        return descCalidad;
    }

    public void setDescCalidad(String descCalidad) {
        this.descCalidad = descCalidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioPostor() {
        return precioPostor;
    }

    public void setPrecioPostor(BigDecimal precioPostor) {
        this.precioPostor = precioPostor;
    }

    public Character getParticipa() {
        return participa;
    }

    public void setParticipa(Character participa) {
        this.participa = participa;
    }

    public Character getGanadorItem() {
        return ganadorItem;
    }

    public void setGanadorItem(Character ganadorItem) {
        this.ganadorItem = ganadorItem;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotizacionDetPK != null ? cotizacionDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDet)) {
            return false;
        }
        CotizacionDet other = (CotizacionDet) object;
        if ((this.cotizacionDetPK == null && other.cotizacionDetPK != null) || (this.cotizacionDetPK != null && !this.cotizacionDetPK.equals(other.cotizacionDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CotizacionDet[ cotizacionDetPK=" + cotizacionDetPK + " ]";
    }
    
}
