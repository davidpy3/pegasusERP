/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByTipoHor", query = "SELECT h FROM Horario h WHERE h.horarioPK.tipoHor = :tipoHor"),
    @NamedQuery(name = "Horario.findByTurno", query = "SELECT h FROM Horario h WHERE h.horarioPK.turno = :turno"),
    @NamedQuery(name = "Horario.findByRegistro", query = "SELECT h FROM Horario h WHERE h.horarioPK.registro = :registro"),
    @NamedQuery(name = "Horario.findByDescripcion", query = "SELECT h FROM Horario h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Horario.findByDesde", query = "SELECT h FROM Horario h WHERE h.desde = :desde"),
    @NamedQuery(name = "Horario.findByHasta", query = "SELECT h FROM Horario h WHERE h.hasta = :hasta"),
    @NamedQuery(name = "Horario.findByTolerancia", query = "SELECT h FROM Horario h WHERE h.tolerancia = :tolerancia")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioPK horarioPK;
    @Size(max = 30)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date desde;
    @Column(name = "Hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hasta;
    @Column(name = "Tolerancia")
    private Integer tolerancia;

    public Horario() {
    }

    public Horario(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public Horario(Character tipoHor, Character turno, Character registro) {
        this.horarioPK = new HorarioPK(tipoHor, turno, registro);
    }

    public HorarioPK getHorarioPK() {
        return horarioPK;
    }

    public void setHorarioPK(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Integer tolerancia) {
        this.tolerancia = tolerancia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioPK != null ? horarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horarioPK == null && other.horarioPK != null) || (this.horarioPK != null && !this.horarioPK.equals(other.horarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Horario[ horarioPK=" + horarioPK + " ]";
    }
    
}
