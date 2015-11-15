/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "esc_partic_comunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscParticComunidad.findAll", query = "SELECT e FROM EscParticComunidad e"),
    @NamedQuery(name = "EscParticComunidad.findByIdComud", query = "SELECT e FROM EscParticComunidad e WHERE e.idComud = :idComud"),
    @NamedQuery(name = "EscParticComunidad.findByIdEsc", query = "SELECT e FROM EscParticComunidad e WHERE e.idEsc = :idEsc"),
    @NamedQuery(name = "EscParticComunidad.findByCargo", query = "SELECT e FROM EscParticComunidad e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "EscParticComunidad.findByFechaInicio", query = "SELECT e FROM EscParticComunidad e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EscParticComunidad.findByFechaFin", query = "SELECT e FROM EscParticComunidad e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EscParticComunidad.findByActivo", query = "SELECT e FROM EscParticComunidad e WHERE e.activo = :activo")})
public class EscParticComunidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_comud")
    private Integer idComud;
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "id_inst", referencedColumnName = "id_inst")
    @ManyToOne(optional = false)
    private EscInstituciones idInst;

    public EscParticComunidad() {
    }

    public EscParticComunidad(Integer idComud) {
        this.idComud = idComud;
    }

    public EscParticComunidad(Integer idComud, int idEsc) {
        this.idComud = idComud;
        this.idEsc = idEsc;
    }

    public Integer getIdComud() {
        return idComud;
    }

    public void setIdComud(Integer idComud) {
        this.idComud = idComud;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public EscInstituciones getIdInst() {
        return idInst;
    }

    public void setIdInst(EscInstituciones idInst) {
        this.idInst = idInst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComud != null ? idComud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscParticComunidad)) {
            return false;
        }
        EscParticComunidad other = (EscParticComunidad) object;
        if ((this.idComud == null && other.idComud != null) || (this.idComud != null && !this.idComud.equals(other.idComud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscParticComunidad[ idComud=" + idComud + " ]";
    }
    
}
