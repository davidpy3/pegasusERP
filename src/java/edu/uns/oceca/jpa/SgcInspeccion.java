/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_inspeccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcInspeccion.findAll", query = "SELECT s FROM SgcInspeccion s"),
    @NamedQuery(name = "SgcInspeccion.findByIdInspec", query = "SELECT s FROM SgcInspeccion s WHERE s.idInspec = :idInspec"),
    @NamedQuery(name = "SgcInspeccion.findByIdTipins", query = "SELECT s FROM SgcInspeccion s WHERE s.idTipins = :idTipins"),
    @NamedQuery(name = "SgcInspeccion.findByDetalle", query = "SELECT s FROM SgcInspeccion s WHERE s.detalle = :detalle"),
    @NamedQuery(name = "SgcInspeccion.findByFechaPlan", query = "SELECT s FROM SgcInspeccion s WHERE s.fechaPlan = :fechaPlan"),
    @NamedQuery(name = "SgcInspeccion.findByFecha", query = "SELECT s FROM SgcInspeccion s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SgcInspeccion.findByIdObjeto", query = "SELECT s FROM SgcInspeccion s WHERE s.idObjeto = :idObjeto"),
    @NamedQuery(name = "SgcInspeccion.findByIdInspector", query = "SELECT s FROM SgcInspeccion s WHERE s.idInspector = :idInspector"),
    @NamedQuery(name = "SgcInspeccion.findByIdTestigo", query = "SELECT s FROM SgcInspeccion s WHERE s.idTestigo = :idTestigo"),
    @NamedQuery(name = "SgcInspeccion.findByIdEstado", query = "SELECT s FROM SgcInspeccion s WHERE s.idEstado = :idEstado"),
    @NamedQuery(name = "SgcInspeccion.findByIdExpe", query = "SELECT s FROM SgcInspeccion s WHERE s.idExpe = :idExpe")})
public class SgcInspeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_inspec")
    private Integer idInspec;
    @Column(name = "id_tipins")
    private Character idTipins;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "fecha_plan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPlan;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "id_objeto")
    private Integer idObjeto;
    @Column(name = "id_inspector")
    private Integer idInspector;
    @Column(name = "id_testigo")
    private Integer idTestigo;
    @Lob
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "id_estado")
    private Character idEstado;
    @Column(name = "id_expe")
    private Integer idExpe;

    public SgcInspeccion() {
    }

    public SgcInspeccion(Integer idInspec) {
        this.idInspec = idInspec;
    }

    public SgcInspeccion(Integer idInspec, String detalle) {
        this.idInspec = idInspec;
        this.detalle = detalle;
    }

    public Integer getIdInspec() {
        return idInspec;
    }

    public void setIdInspec(Integer idInspec) {
        this.idInspec = idInspec;
    }

    public Character getIdTipins() {
        return idTipins;
    }

    public void setIdTipins(Character idTipins) {
        this.idTipins = idTipins;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaPlan() {
        return fechaPlan;
    }

    public void setFechaPlan(Date fechaPlan) {
        this.fechaPlan = fechaPlan;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Integer getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Integer idInspector) {
        this.idInspector = idInspector;
    }

    public Integer getIdTestigo() {
        return idTestigo;
    }

    public void setIdTestigo(Integer idTestigo) {
        this.idTestigo = idTestigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdExpe() {
        return idExpe;
    }

    public void setIdExpe(Integer idExpe) {
        this.idExpe = idExpe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInspec != null ? idInspec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcInspeccion)) {
            return false;
        }
        SgcInspeccion other = (SgcInspeccion) object;
        if ((this.idInspec == null && other.idInspec != null) || (this.idInspec != null && !this.idInspec.equals(other.idInspec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcInspeccion[ idInspec=" + idInspec + " ]";
    }
    
}
