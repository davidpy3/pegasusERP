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
import javax.persistence.JoinColumns;
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
@Table(name = "esc_rotaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscRotaciones.findAll", query = "SELECT e FROM EscRotaciones e"),
    @NamedQuery(name = "EscRotaciones.findByIdRot", query = "SELECT e FROM EscRotaciones e WHERE e.idRot = :idRot"),
    @NamedQuery(name = "EscRotaciones.findByFecInicio", query = "SELECT e FROM EscRotaciones e WHERE e.fecInicio = :fecInicio"),
    @NamedQuery(name = "EscRotaciones.findByFecFin", query = "SELECT e FROM EscRotaciones e WHERE e.fecFin = :fecFin"),
    @NamedQuery(name = "EscRotaciones.findByEstado", query = "SELECT e FROM EscRotaciones e WHERE e.estado = :estado"),
    @NamedQuery(name = "EscRotaciones.findByIdDtra", query = "SELECT e FROM EscRotaciones e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscRotaciones.findByMencion", query = "SELECT e FROM EscRotaciones e WHERE e.mencion = :mencion"),
    @NamedQuery(name = "EscRotaciones.findByJefe", query = "SELECT e FROM EscRotaciones e WHERE e.jefe = :jefe")})
public class EscRotaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rot")
    private Integer idRot;
    @Basic(optional = false)
    @Column(name = "fec_inicio")
    @Temporal(TemporalType.DATE)
    private Date fecInicio;
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Basic(optional = false)
    @Column(name = "jefe")
    private boolean jefe;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCap escCap;
    @JoinColumn(name = "id_desp", referencedColumnName = "id_desp")
    @ManyToOne(optional = false)
    private EscDesplazamiento idDesp;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;

    public EscRotaciones() {
    }

    public EscRotaciones(Integer idRot) {
        this.idRot = idRot;
    }

    public EscRotaciones(Integer idRot, Date fecInicio, boolean estado, boolean jefe) {
        this.idRot = idRot;
        this.fecInicio = fecInicio;
        this.estado = estado;
        this.jefe = jefe;
    }

    public Integer getIdRot() {
        return idRot;
    }

    public void setIdRot(Integer idRot) {
        this.idRot = idRot;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public boolean getJefe() {
        return jefe;
    }

    public void setJefe(boolean jefe) {
        this.jefe = jefe;
    }

    public EscCap getEscCap() {
        return escCap;
    }

    public void setEscCap(EscCap escCap) {
        this.escCap = escCap;
    }

    public EscDesplazamiento getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(EscDesplazamiento idDesp) {
        this.idDesp = idDesp;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRot != null ? idRot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscRotaciones)) {
            return false;
        }
        EscRotaciones other = (EscRotaciones) object;
        if ((this.idRot == null && other.idRot != null) || (this.idRot != null && !this.idRot.equals(other.idRot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscRotaciones[ idRot=" + idRot + " ]";
    }
    
}
