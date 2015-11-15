/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_desplazamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscDesplazamiento.findAll", query = "SELECT e FROM EscDesplazamiento e"),
    @NamedQuery(name = "EscDesplazamiento.findByIdDesp", query = "SELECT e FROM EscDesplazamiento e WHERE e.idDesp = :idDesp"),
    @NamedQuery(name = "EscDesplazamiento.findByDespPersonal", query = "SELECT e FROM EscDesplazamiento e WHERE e.despPersonal = :despPersonal")})
public class EscDesplazamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_desp")
    private Short idDesp;
    @Column(name = "desp_personal")
    private String despPersonal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesp")
    private List<EscEncargaturas> escEncargaturasList;
    @OneToMany(mappedBy = "idDesp")
    private List<EscCarreraLaboral> escCarreraLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesp")
    private List<EscPersDep> escPersDepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesp")
    private List<EscRotaciones> escRotacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesp")
    private List<EscRotacionesCas> escRotacionesCasList;

    public EscDesplazamiento() {
    }

    public EscDesplazamiento(Short idDesp) {
        this.idDesp = idDesp;
    }

    public Short getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(Short idDesp) {
        this.idDesp = idDesp;
    }

    public String getDespPersonal() {
        return despPersonal;
    }

    public void setDespPersonal(String despPersonal) {
        this.despPersonal = despPersonal;
    }

    @XmlTransient
    public List<EscEncargaturas> getEscEncargaturasList() {
        return escEncargaturasList;
    }

    public void setEscEncargaturasList(List<EscEncargaturas> escEncargaturasList) {
        this.escEncargaturasList = escEncargaturasList;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

    @XmlTransient
    public List<EscPersDep> getEscPersDepList() {
        return escPersDepList;
    }

    public void setEscPersDepList(List<EscPersDep> escPersDepList) {
        this.escPersDepList = escPersDepList;
    }

    @XmlTransient
    public List<EscRotaciones> getEscRotacionesList() {
        return escRotacionesList;
    }

    public void setEscRotacionesList(List<EscRotaciones> escRotacionesList) {
        this.escRotacionesList = escRotacionesList;
    }

    @XmlTransient
    public List<EscRotacionesCas> getEscRotacionesCasList() {
        return escRotacionesCasList;
    }

    public void setEscRotacionesCasList(List<EscRotacionesCas> escRotacionesCasList) {
        this.escRotacionesCasList = escRotacionesCasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesp != null ? idDesp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscDesplazamiento)) {
            return false;
        }
        EscDesplazamiento other = (EscDesplazamiento) object;
        if ((this.idDesp == null && other.idDesp != null) || (this.idDesp != null && !this.idDesp.equals(other.idDesp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDesplazamiento[ idDesp=" + idDesp + " ]";
    }
    
}
