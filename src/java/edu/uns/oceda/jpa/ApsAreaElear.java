/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "aps_area_elear")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApsAreaElear.findAll", query = "SELECT a FROM ApsAreaElear a"),
    @NamedQuery(name = "ApsAreaElear.findByIdArea", query = "SELECT a FROM ApsAreaElear a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "ApsAreaElear.findByCodArea", query = "SELECT a FROM ApsAreaElear a WHERE a.codArea = :codArea"),
    @NamedQuery(name = "ApsAreaElear.findByEspecialidad", query = "SELECT a FROM ApsAreaElear a WHERE a.especialidad = :especialidad")})
public class ApsAreaElear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Column(name = "cod_area")
    private String codArea;
    @Column(name = "especialidad")
    private String especialidad;
    @JoinTable(name = "aps_especialidad_elear", joinColumns = {
        @JoinColumn(name = "id_area", referencedColumnName = "id_area")}, inverseJoinColumns = {
        @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")})
    @ManyToMany
    private List<ApsEspecialidad> apsEspecialidadList;
    @JoinColumn(name = "id_ambito", referencedColumnName = "id_ambito")
    @ManyToOne
    private ApsAmbitoAcad idAmbito;

    public ApsAreaElear() {
    }

    public ApsAreaElear(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @XmlTransient
    public List<ApsEspecialidad> getApsEspecialidadList() {
        return apsEspecialidadList;
    }

    public void setApsEspecialidadList(List<ApsEspecialidad> apsEspecialidadList) {
        this.apsEspecialidadList = apsEspecialidadList;
    }

    public ApsAmbitoAcad getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(ApsAmbitoAcad idAmbito) {
        this.idAmbito = idAmbito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsAreaElear)) {
            return false;
        }
        ApsAreaElear other = (ApsAreaElear) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsAreaElear[ idArea=" + idArea + " ]";
    }
    
}
