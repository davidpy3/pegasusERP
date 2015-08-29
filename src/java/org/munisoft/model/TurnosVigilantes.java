/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "turnos_vigilantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnosVigilantes.findAll", query = "SELECT t FROM TurnosVigilantes t"),
    @NamedQuery(name = "TurnosVigilantes.findByDni", query = "SELECT t FROM TurnosVigilantes t WHERE t.turnosVigilantesPK.dni = :dni"),
    @NamedQuery(name = "TurnosVigilantes.findByTipoHor", query = "SELECT t FROM TurnosVigilantes t WHERE t.turnosVigilantesPK.tipoHor = :tipoHor"),
    @NamedQuery(name = "TurnosVigilantes.findByFechaIni", query = "SELECT t FROM TurnosVigilantes t WHERE t.turnosVigilantesPK.fechaIni = :fechaIni"),
    @NamedQuery(name = "TurnosVigilantes.findByFechaFin", query = "SELECT t FROM TurnosVigilantes t WHERE t.turnosVigilantesPK.fechaFin = :fechaFin"),
    @NamedQuery(name = "TurnosVigilantes.findByActivo", query = "SELECT t FROM TurnosVigilantes t WHERE t.activo = :activo")})
public class TurnosVigilantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosVigilantesPK turnosVigilantesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private Character activo;

    public TurnosVigilantes() {
    }

    public TurnosVigilantes(TurnosVigilantesPK turnosVigilantesPK) {
        this.turnosVigilantesPK = turnosVigilantesPK;
    }

    public TurnosVigilantes(TurnosVigilantesPK turnosVigilantesPK, Character activo) {
        this.turnosVigilantesPK = turnosVigilantesPK;
        this.activo = activo;
    }

    public TurnosVigilantes(String dni, Character tipoHor, Date fechaIni, Date fechaFin) {
        this.turnosVigilantesPK = new TurnosVigilantesPK(dni, tipoHor, fechaIni, fechaFin);
    }

    public TurnosVigilantesPK getTurnosVigilantesPK() {
        return turnosVigilantesPK;
    }

    public void setTurnosVigilantesPK(TurnosVigilantesPK turnosVigilantesPK) {
        this.turnosVigilantesPK = turnosVigilantesPK;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnosVigilantesPK != null ? turnosVigilantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosVigilantes)) {
            return false;
        }
        TurnosVigilantes other = (TurnosVigilantes) object;
        if ((this.turnosVigilantesPK == null && other.turnosVigilantesPK != null) || (this.turnosVigilantesPK != null && !this.turnosVigilantesPK.equals(other.turnosVigilantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TurnosVigilantes[ turnosVigilantesPK=" + turnosVigilantesPK + " ]";
    }
    
}
