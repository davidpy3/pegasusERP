/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_historia_cap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscHistoriaCap.findAll", query = "SELECT e FROM EscHistoriaCap e"),
    @NamedQuery(name = "EscHistoriaCap.findByIdHistCap", query = "SELECT e FROM EscHistoriaCap e WHERE e.idHistCap = :idHistCap"),
    @NamedQuery(name = "EscHistoriaCap.findByIdDtra", query = "SELECT e FROM EscHistoriaCap e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscHistoriaCap.findByElaborada", query = "SELECT e FROM EscHistoriaCap e WHERE e.elaborada = :elaborada"),
    @NamedQuery(name = "EscHistoriaCap.findByEstado", query = "SELECT e FROM EscHistoriaCap e WHERE e.estado = :estado"),
    @NamedQuery(name = "EscHistoriaCap.findByFechaDoc", query = "SELECT e FROM EscHistoriaCap e WHERE e.fechaDoc = :fechaDoc")})
public class EscHistoriaCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_hist_cap")
    private Integer idHistCap;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "elaborada")
    private String elaborada;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @OneToMany(mappedBy = "idHistCap")
    private List<EscCap> escCapList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistCap")
    private List<EscCapDocente> escCapDocenteList;
    @OneToMany(mappedBy = "idHistCap")
    private List<EscCapUns> escCapUnsList;

    public EscHistoriaCap() {
    }

    public EscHistoriaCap(Integer idHistCap) {
        this.idHistCap = idHistCap;
    }

    public EscHistoriaCap(Integer idHistCap, String idDtra, boolean estado) {
        this.idHistCap = idHistCap;
        this.idDtra = idDtra;
        this.estado = estado;
    }

    public Integer getIdHistCap() {
        return idHistCap;
    }

    public void setIdHistCap(Integer idHistCap) {
        this.idHistCap = idHistCap;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getElaborada() {
        return elaborada;
    }

    public void setElaborada(String elaborada) {
        this.elaborada = elaborada;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    @XmlTransient
    public List<EscCap> getEscCapList() {
        return escCapList;
    }

    public void setEscCapList(List<EscCap> escCapList) {
        this.escCapList = escCapList;
    }

    @XmlTransient
    public List<EscCapDocente> getEscCapDocenteList() {
        return escCapDocenteList;
    }

    public void setEscCapDocenteList(List<EscCapDocente> escCapDocenteList) {
        this.escCapDocenteList = escCapDocenteList;
    }

    @XmlTransient
    public List<EscCapUns> getEscCapUnsList() {
        return escCapUnsList;
    }

    public void setEscCapUnsList(List<EscCapUns> escCapUnsList) {
        this.escCapUnsList = escCapUnsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistCap != null ? idHistCap.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscHistoriaCap)) {
            return false;
        }
        EscHistoriaCap other = (EscHistoriaCap) object;
        if ((this.idHistCap == null && other.idHistCap != null) || (this.idHistCap != null && !this.idHistCap.equals(other.idHistCap))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscHistoriaCap[ idHistCap=" + idHistCap + " ]";
    }
    
}
