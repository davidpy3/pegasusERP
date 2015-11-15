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
@Table(name = "sgc_audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAudit.findAll", query = "SELECT s FROM SgcAudit s"),
    @NamedQuery(name = "SgcAudit.findByIdAudit", query = "SELECT s FROM SgcAudit s WHERE s.idAudit = :idAudit"),
    @NamedQuery(name = "SgcAudit.findByCodigo", query = "SELECT s FROM SgcAudit s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "SgcAudit.findByIdTipoAudit", query = "SELECT s FROM SgcAudit s WHERE s.idTipoAudit = :idTipoAudit"),
    @NamedQuery(name = "SgcAudit.findByIdDep", query = "SELECT s FROM SgcAudit s WHERE s.idDep = :idDep"),
    @NamedQuery(name = "SgcAudit.findByIdAuditado", query = "SELECT s FROM SgcAudit s WHERE s.idAuditado = :idAuditado"),
    @NamedQuery(name = "SgcAudit.findByAuditoria", query = "SELECT s FROM SgcAudit s WHERE s.auditoria = :auditoria"),
    @NamedQuery(name = "SgcAudit.findByFechaRealizado", query = "SELECT s FROM SgcAudit s WHERE s.fechaRealizado = :fechaRealizado"),
    @NamedQuery(name = "SgcAudit.findByEjecutado", query = "SELECT s FROM SgcAudit s WHERE s.ejecutado = :ejecutado"),
    @NamedQuery(name = "SgcAudit.findByIdDocumento", query = "SELECT s FROM SgcAudit s WHERE s.idDocumento = :idDocumento"),
    @NamedQuery(name = "SgcAudit.findByComentario", query = "SELECT s FROM SgcAudit s WHERE s.comentario = :comentario"),
    @NamedQuery(name = "SgcAudit.findByCumplimiento", query = "SELECT s FROM SgcAudit s WHERE s.cumplimiento = :cumplimiento"),
    @NamedQuery(name = "SgcAudit.findByIdFuente", query = "SELECT s FROM SgcAudit s WHERE s.idFuente = :idFuente"),
    @NamedQuery(name = "SgcAudit.findByIdCreador", query = "SELECT s FROM SgcAudit s WHERE s.idCreador = :idCreador"),
    @NamedQuery(name = "SgcAudit.findByFechaReg", query = "SELECT s FROM SgcAudit s WHERE s.fechaReg = :fechaReg"),
    @NamedQuery(name = "SgcAudit.findByFechaPlanificada", query = "SELECT s FROM SgcAudit s WHERE s.fechaPlanificada = :fechaPlanificada"),
    @NamedQuery(name = "SgcAudit.findByConclusion", query = "SELECT s FROM SgcAudit s WHERE s.conclusion = :conclusion")})
public class SgcAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_audit")
    private Integer idAudit;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "id_tipo_audit")
    private Integer idTipoAudit;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "id_auditado")
    private Integer idAuditado;
    @Column(name = "auditoria")
    private String auditoria;
    @Column(name = "fecha_realizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizado;
    @Column(name = "ejecutado")
    private Short ejecutado;
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Column(name = "comentario")
    private String comentario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cumplimiento")
    private Double cumplimiento;
    @Column(name = "id_fuente")
    private Integer idFuente;
    @Column(name = "id_creador")
    private Integer idCreador;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "fecha_planificada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPlanificada;
    @Column(name = "conclusion")
    private String conclusion;

    public SgcAudit() {
    }

    public SgcAudit(Integer idAudit) {
        this.idAudit = idAudit;
    }

    public SgcAudit(Integer idAudit, Date fechaReg) {
        this.idAudit = idAudit;
        this.fechaReg = fechaReg;
    }

    public Integer getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(Integer idAudit) {
        this.idAudit = idAudit;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdTipoAudit() {
        return idTipoAudit;
    }

    public void setIdTipoAudit(Integer idTipoAudit) {
        this.idTipoAudit = idTipoAudit;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdAuditado() {
        return idAuditado;
    }

    public void setIdAuditado(Integer idAuditado) {
        this.idAuditado = idAuditado;
    }

    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public Short getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(Short ejecutado) {
        this.ejecutado = ejecutado;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(Double cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public Integer getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Integer idCreador) {
        this.idCreador = idCreador;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Date getFechaPlanificada() {
        return fechaPlanificada;
    }

    public void setFechaPlanificada(Date fechaPlanificada) {
        this.fechaPlanificada = fechaPlanificada;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAudit != null ? idAudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAudit)) {
            return false;
        }
        SgcAudit other = (SgcAudit) object;
        if ((this.idAudit == null && other.idAudit != null) || (this.idAudit != null && !this.idAudit.equals(other.idAudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAudit[ idAudit=" + idAudit + " ]";
    }
    
}
