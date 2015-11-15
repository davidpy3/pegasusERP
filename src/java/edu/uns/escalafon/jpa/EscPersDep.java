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

@Entity
@Table(name = "esc_pers_dep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscPersDep.findAll", query = "SELECT e FROM EscPersDep e"),
    @NamedQuery(name = "EscPersDep.findByIdPd", query = "SELECT e FROM EscPersDep e WHERE e.idPd = :idPd"),
    @NamedQuery(name = "EscPersDep.findByFecInicio", query = "SELECT e FROM EscPersDep e WHERE e.fecInicio = :fecInicio"),
    @NamedQuery(name = "EscPersDep.findByFecFin", query = "SELECT e FROM EscPersDep e WHERE e.fecFin = :fecFin"),
    @NamedQuery(name = "EscPersDep.findByEstado", query = "SELECT e FROM EscPersDep e WHERE e.estado = :estado"),
    @NamedQuery(name = "EscPersDep.findByIdDtra", query = "SELECT e FROM EscPersDep e WHERE e.idDtra = :idDtra")})
public class EscPersDep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pd")
    private Integer idPd;
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

    public EscPersDep() {
    }

    public EscPersDep(Integer idPd) {
        this.idPd = idPd;
    }

    public EscPersDep(Integer idPd, boolean estado) {
        this.idPd = idPd;
        this.estado = estado;
    }

    public Integer getIdPd() {
        return idPd;
    }

    public void setIdPd(Integer idPd) {
        this.idPd = idPd;
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
        hash += (idPd != null ? idPd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPersDep)) {
            return false;
        }
        EscPersDep other = (EscPersDep) object;
        if ((this.idPd == null && other.idPd != null) || (this.idPd != null && !this.idPd.equals(other.idPd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscPersDep[ idPd=" + idPd + " ]";
    }
    
}
