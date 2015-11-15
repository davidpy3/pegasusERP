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

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_fuente")
@NamedQueries({
    @NamedQuery(name = "SgcFuente.findAll", query = "SELECT s FROM SgcFuente s")})
public class SgcFuente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private Integer idFuente;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "fuente_verificacion")
    private String fuenteVerificacion;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "delta")
    private Integer delta;

    public SgcFuente() {
    }

    public SgcFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public SgcFuente(Integer idFuente, String tipo, String codigo, String fuenteVerificacion, Character estado, Date fechaReg) {
        this.idFuente = idFuente;
        this.tipo = tipo;
        this.codigo = codigo;
        this.fuenteVerificacion = fuenteVerificacion;
        this.estado = estado;
        this.fechaReg = fechaReg;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFuenteVerificacion() {
        return fuenteVerificacion;
    }

    public void setFuenteVerificacion(String fuenteVerificacion) {
        this.fuenteVerificacion = fuenteVerificacion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuente != null ? idFuente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuente)) {
            return false;
        }
        SgcFuente other = (SgcFuente) object;
        if ((this.idFuente == null && other.idFuente != null) || (this.idFuente != null && !this.idFuente.equals(other.idFuente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.jpa.SgcFuente[ idFuente=" + idFuente + " ]";
    }
    
}
