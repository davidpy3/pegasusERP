/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByAnoEje", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.anoEje = :anoEje"),
    @NamedQuery(name = "Inventario.findByNumInv", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.numInv = :numInv"),
    @NamedQuery(name = "Inventario.findByTipoInventario", query = "SELECT i FROM Inventario i WHERE i.tipoInventario = :tipoInventario"),
    @NamedQuery(name = "Inventario.findByPeriodo", query = "SELECT i FROM Inventario i WHERE i.periodo = :periodo"),
    @NamedQuery(name = "Inventario.findByFechaIni", query = "SELECT i FROM Inventario i WHERE i.fechaIni = :fechaIni"),
    @NamedQuery(name = "Inventario.findByFechaFin", query = "SELECT i FROM Inventario i WHERE i.fechaFin = :fechaFin"),
    @NamedQuery(name = "Inventario.findByResponsable", query = "SELECT i FROM Inventario i WHERE i.responsable = :responsable"),
    @NamedQuery(name = "Inventario.findByEstado", query = "SELECT i FROM Inventario i WHERE i.estado = :estado"),
    @NamedQuery(name = "Inventario.findByObservacion", query = "SELECT i FROM Inventario i WHERE i.observacion = :observacion")})
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioPK inventarioPK;
    @Column(name = "tipo_inventario")
    private Character tipoInventario;
    @Column(name = "periodo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodo;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 8)
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private Collection<InventarioDetalle> inventarioDetalleCollection;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Inventario(String anoEje, String numInv) {
        this.inventarioPK = new InventarioPK(anoEje, numInv);
    }

    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Character getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(Character tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<InventarioDetalle> getInventarioDetalleCollection() {
        return inventarioDetalleCollection;
    }

    public void setInventarioDetalleCollection(Collection<InventarioDetalle> inventarioDetalleCollection) {
        this.inventarioDetalleCollection = inventarioDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioPK != null ? inventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.inventarioPK == null && other.inventarioPK != null) || (this.inventarioPK != null && !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Inventario[ inventarioPK=" + inventarioPK + " ]";
    }
    
}
