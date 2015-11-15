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
@Table(name = "esc_contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscContratos.findAll", query = "SELECT e FROM EscContratos e"),
    @NamedQuery(name = "EscContratos.findByIdDtra", query = "SELECT e FROM EscContratos e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscContratos.findByMencion", query = "SELECT e FROM EscContratos e WHERE e.mencion = :mencion"),
    @NamedQuery(name = "EscContratos.findByFechaIni", query = "SELECT e FROM EscContratos e WHERE e.fechaIni = :fechaIni"),
    @NamedQuery(name = "EscContratos.findByFechaFin", query = "SELECT e FROM EscContratos e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EscContratos.findByIdCn", query = "SELECT e FROM EscContratos e WHERE e.idCn = :idCn"),
    @NamedQuery(name = "EscContratos.findByEstado", query = "SELECT e FROM EscContratos e WHERE e.estado = :estado"),
    @NamedQuery(name = "EscContratos.findByJefe", query = "SELECT e FROM EscContratos e WHERE e.jefe = :jefe"),
    @NamedQuery(name = "EscContratos.findByPlaza", query = "SELECT e FROM EscContratos e WHERE e.plaza = :plaza")})
public class EscContratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cn")
    private Integer idCn;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "jefe")
    private boolean jefe;
    @Column(name = "plaza")
    private Boolean plaza;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCap escCap;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;

    public EscContratos() {
    }

    public EscContratos(Integer idCn) {
        this.idCn = idCn;
    }

    public EscContratos(Integer idCn, String idDtra, Date fechaIni, Date fechaFin, boolean estado, boolean jefe) {
        this.idCn = idCn;
        this.idDtra = idDtra;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.jefe = jefe;
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

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdCn() {
        return idCn;
    }

    public void setIdCn(Integer idCn) {
        this.idCn = idCn;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getJefe() {
        return jefe;
    }

    public void setJefe(boolean jefe) {
        this.jefe = jefe;
    }

    public Boolean getPlaza() {
        return plaza;
    }

    public void setPlaza(Boolean plaza) {
        this.plaza = plaza;
    }

    public EscCap getEscCap() {
        return escCap;
    }

    public void setEscCap(EscCap escCap) {
        this.escCap = escCap;
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
        hash += (idCn != null ? idCn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscContratos)) {
            return false;
        }
        EscContratos other = (EscContratos) object;
        if ((this.idCn == null && other.idCn != null) || (this.idCn != null && !this.idCn.equals(other.idCn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscContratos[ idCn=" + idCn + " ]";
    }
    
}
