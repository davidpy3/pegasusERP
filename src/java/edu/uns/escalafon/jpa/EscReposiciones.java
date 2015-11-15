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
@Table(name = "esc_reposiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscReposiciones.findAll", query = "SELECT e FROM EscReposiciones e"),
    @NamedQuery(name = "EscReposiciones.findByIdRep", query = "SELECT e FROM EscReposiciones e WHERE e.idRep = :idRep"),
    @NamedQuery(name = "EscReposiciones.findByIdDtra", query = "SELECT e FROM EscReposiciones e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscReposiciones.findByMencion", query = "SELECT e FROM EscReposiciones e WHERE e.mencion = :mencion"),
    @NamedQuery(name = "EscReposiciones.findByFechaRep", query = "SELECT e FROM EscReposiciones e WHERE e.fechaRep = :fechaRep"),
    @NamedQuery(name = "EscReposiciones.findByFechaIni", query = "SELECT e FROM EscReposiciones e WHERE e.fechaIni = :fechaIni"),
    @NamedQuery(name = "EscReposiciones.findByActivo", query = "SELECT e FROM EscReposiciones e WHERE e.activo = :activo")})
public class EscReposiciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rep")
    private Integer idRep;
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Column(name = "fecha_rep")
    @Temporal(TemporalType.DATE)
    private Date fechaRep;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EscDemeritos id;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;

    public EscReposiciones() {
    }

    public EscReposiciones(Integer idRep) {
        this.idRep = idRep;
    }

    public EscReposiciones(Integer idRep, boolean activo) {
        this.idRep = idRep;
        this.activo = activo;
    }

    public Integer getIdRep() {
        return idRep;
    }

    public void setIdRep(Integer idRep) {
        this.idRep = idRep;
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

    public Date getFechaRep() {
        return fechaRep;
    }

    public void setFechaRep(Date fechaRep) {
        this.fechaRep = fechaRep;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public EscDemeritos getId() {
        return id;
    }

    public void setId(EscDemeritos id) {
        this.id = id;
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
        hash += (idRep != null ? idRep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscReposiciones)) {
            return false;
        }
        EscReposiciones other = (EscReposiciones) object;
        if ((this.idRep == null && other.idRep != null) || (this.idRep != null && !this.idRep.equals(other.idRep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscReposiciones[ idRep=" + idRep + " ]";
    }
    
}
