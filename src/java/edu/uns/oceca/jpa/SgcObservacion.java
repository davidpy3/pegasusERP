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
@Table(name = "sgc_observacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcObservacion.findAll", query = "SELECT s FROM SgcObservacion s"),
    @NamedQuery(name = "SgcObservacion.findByIdObservacion", query = "SELECT s FROM SgcObservacion s WHERE s.idObservacion = :idObservacion"),
    @NamedQuery(name = "SgcObservacion.findByTipo", query = "SELECT s FROM SgcObservacion s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SgcObservacion.findByIdEstado", query = "SELECT s FROM SgcObservacion s WHERE s.idEstado = :idEstado"),
    @NamedQuery(name = "SgcObservacion.findByFecha", query = "SELECT s FROM SgcObservacion s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SgcObservacion.findByIdDir", query = "SELECT s FROM SgcObservacion s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SgcObservacion.findByIdAutoevaluacion", query = "SELECT s FROM SgcObservacion s WHERE s.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SgcObservacion.findByIdEstandar", query = "SELECT s FROM SgcObservacion s WHERE s.idEstandar = :idEstandar"),
    @NamedQuery(name = "SgcObservacion.findByIdFuente", query = "SELECT s FROM SgcObservacion s WHERE s.idFuente = :idFuente")})
public class SgcObservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_observacion")
    private Integer idObservacion;
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_estado")
    private Character idEstado;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "id_dir")
    private Integer idDir;
    @Column(name = "id_autoevaluacion")
    private Integer idAutoevaluacion;
    @Column(name = "id_estandar")
    private Integer idEstandar;
    @Column(name = "id_fuente")
    private Integer idFuente;

    public SgcObservacion() {
    }

    public SgcObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public SgcObservacion(Integer idObservacion, String descripcion) {
        this.idObservacion = idObservacion;
        this.descripcion = descripcion;
    }

    public Integer getIdObservacion() {
        return idObservacion;
    }

    public void setIdObservacion(Integer idObservacion) {
        this.idObservacion = idObservacion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public Integer getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(Integer idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public Integer getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObservacion != null ? idObservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcObservacion)) {
            return false;
        }
        SgcObservacion other = (SgcObservacion) object;
        if ((this.idObservacion == null && other.idObservacion != null) || (this.idObservacion != null && !this.idObservacion.equals(other.idObservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcObservacion[ idObservacion=" + idObservacion + " ]";
    }
    
}
