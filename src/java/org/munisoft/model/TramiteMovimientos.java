/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "tramite_movimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TramiteMovimientos.findAll", query = "SELECT t FROM TramiteMovimientos t"),
    @NamedQuery(name = "TramiteMovimientos.findByAnoEje", query = "SELECT t FROM TramiteMovimientos t WHERE t.tramiteMovimientosPK.anoEje = :anoEje"),
    @NamedQuery(name = "TramiteMovimientos.findByNExpediente", query = "SELECT t FROM TramiteMovimientos t WHERE t.tramiteMovimientosPK.nExpediente = :nExpediente"),
    @NamedQuery(name = "TramiteMovimientos.findByNumMov", query = "SELECT t FROM TramiteMovimientos t WHERE t.tramiteMovimientosPK.numMov = :numMov"),
    @NamedQuery(name = "TramiteMovimientos.findByOficinaOrigen", query = "SELECT t FROM TramiteMovimientos t WHERE t.oficinaOrigen = :oficinaOrigen"),
    @NamedQuery(name = "TramiteMovimientos.findByOficinaDestino", query = "SELECT t FROM TramiteMovimientos t WHERE t.oficinaDestino = :oficinaDestino"),
    @NamedQuery(name = "TramiteMovimientos.findByEntidadOrigen", query = "SELECT t FROM TramiteMovimientos t WHERE t.entidadOrigen = :entidadOrigen"),
    @NamedQuery(name = "TramiteMovimientos.findByEntidadDestino", query = "SELECT t FROM TramiteMovimientos t WHERE t.entidadDestino = :entidadDestino"),
    @NamedQuery(name = "TramiteMovimientos.findByUsuarioOrigen", query = "SELECT t FROM TramiteMovimientos t WHERE t.usuarioOrigen = :usuarioOrigen"),
    @NamedQuery(name = "TramiteMovimientos.findByUsuarioDestino", query = "SELECT t FROM TramiteMovimientos t WHERE t.usuarioDestino = :usuarioDestino"),
    @NamedQuery(name = "TramiteMovimientos.findByIdCargoOrigen", query = "SELECT t FROM TramiteMovimientos t WHERE t.idCargoOrigen = :idCargoOrigen"),
    @NamedQuery(name = "TramiteMovimientos.findByIdCargoDestino", query = "SELECT t FROM TramiteMovimientos t WHERE t.idCargoDestino = :idCargoDestino"),
    @NamedQuery(name = "TramiteMovimientos.findByFechaEnvio", query = "SELECT t FROM TramiteMovimientos t WHERE t.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "TramiteMovimientos.findByFechaRecepcion", query = "SELECT t FROM TramiteMovimientos t WHERE t.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "TramiteMovimientos.findByFechaArchivado", query = "SELECT t FROM TramiteMovimientos t WHERE t.fechaArchivado = :fechaArchivado"),
    @NamedQuery(name = "TramiteMovimientos.findByTipoProveido", query = "SELECT t FROM TramiteMovimientos t WHERE t.tipoProveido = :tipoProveido"),
    @NamedQuery(name = "TramiteMovimientos.findByProveido", query = "SELECT t FROM TramiteMovimientos t WHERE t.proveido = :proveido"),
    @NamedQuery(name = "TramiteMovimientos.findByPrioridad", query = "SELECT t FROM TramiteMovimientos t WHERE t.prioridad = :prioridad"),
    @NamedQuery(name = "TramiteMovimientos.findByEstado", query = "SELECT t FROM TramiteMovimientos t WHERE t.estado = :estado")})
public class TramiteMovimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TramiteMovimientosPK tramiteMovimientosPK;
    @Size(max = 5)
    @Column(name = "oficina_origen")
    private String oficinaOrigen;
    @Size(max = 5)
    @Column(name = "oficina_destino")
    private String oficinaDestino;
    @Size(max = 3)
    @Column(name = "entidad_origen")
    private String entidadOrigen;
    @Size(max = 3)
    @Column(name = "entidad_destino")
    private String entidadDestino;
    @Size(max = 8)
    @Column(name = "usuario_origen")
    private String usuarioOrigen;
    @Size(max = 8)
    @Column(name = "usuario_destino")
    private String usuarioDestino;
    @Column(name = "id_cargo_origen")
    private Integer idCargoOrigen;
    @Column(name = "id_cargo_destino")
    private Integer idCargoDestino;
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Column(name = "fecha_archivado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaArchivado;
    @Column(name = "tipo_proveido")
    private Integer tipoProveido;
    @Size(max = 100)
    @Column(name = "proveido")
    private String proveido;
    @Column(name = "prioridad")
    private Character prioridad;
    @Column(name = "estado")
    private Character estado;
    /*@JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "n_expediente", referencedColumnName = "n_expediente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Expediente expediente;*/

    public TramiteMovimientos() {
    }

    public TramiteMovimientos(TramiteMovimientosPK tramiteMovimientosPK) {
        this.tramiteMovimientosPK = tramiteMovimientosPK;
    }

    public TramiteMovimientos(String anoEje, long nExpediente, String numMov) {
        this.tramiteMovimientosPK = new TramiteMovimientosPK(anoEje, nExpediente, numMov);
    }

    public TramiteMovimientosPK getTramiteMovimientosPK() {
        return tramiteMovimientosPK;
    }

    public void setTramiteMovimientosPK(TramiteMovimientosPK tramiteMovimientosPK) {
        this.tramiteMovimientosPK = tramiteMovimientosPK;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public String getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(String oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public String getEntidadOrigen() {
        return entidadOrigen;
    }

    public void setEntidadOrigen(String entidadOrigen) {
        this.entidadOrigen = entidadOrigen;
    }

    public String getEntidadDestino() {
        return entidadDestino;
    }

    public void setEntidadDestino(String entidadDestino) {
        this.entidadDestino = entidadDestino;
    }

    public String getUsuarioOrigen() {
        return usuarioOrigen;
    }

    public void setUsuarioOrigen(String usuarioOrigen) {
        this.usuarioOrigen = usuarioOrigen;
    }

    public String getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(String usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public Integer getIdCargoOrigen() {
        return idCargoOrigen;
    }

    public void setIdCargoOrigen(Integer idCargoOrigen) {
        this.idCargoOrigen = idCargoOrigen;
    }

    public Integer getIdCargoDestino() {
        return idCargoDestino;
    }

    public void setIdCargoDestino(Integer idCargoDestino) {
        this.idCargoDestino = idCargoDestino;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Date getFechaArchivado() {
        return fechaArchivado;
    }

    public void setFechaArchivado(Date fechaArchivado) {
        this.fechaArchivado = fechaArchivado;
    }

    public Integer getTipoProveido() {
        return tipoProveido;
    }

    public void setTipoProveido(Integer tipoProveido) {
        this.tipoProveido = tipoProveido;
    }

    public String getProveido() {
        return proveido;
    }

    public void setProveido(String proveido) {
        this.proveido = proveido;
    }

    public Character getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Character prioridad) {
        this.prioridad = prioridad;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

   /* public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tramiteMovimientosPK != null ? tramiteMovimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramiteMovimientos)) {
            return false;
        }
        TramiteMovimientos other = (TramiteMovimientos) object;
        if ((this.tramiteMovimientosPK == null && other.tramiteMovimientosPK != null) || (this.tramiteMovimientosPK != null && !this.tramiteMovimientosPK.equals(other.tramiteMovimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TramiteMovimientos[ tramiteMovimientosPK=" + tramiteMovimientosPK + " ]";
    }
    
}
