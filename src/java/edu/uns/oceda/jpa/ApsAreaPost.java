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
@Table(name = "aps_area_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApsAreaPost.findAll", query = "SELECT a FROM ApsAreaPost a"),
    @NamedQuery(name = "ApsAreaPost.findByIdArea", query = "SELECT a FROM ApsAreaPost a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "ApsAreaPost.findByCodArea", query = "SELECT a FROM ApsAreaPost a WHERE a.codArea = :codArea"),
    @NamedQuery(name = "ApsAreaPost.findByArea", query = "SELECT a FROM ApsAreaPost a WHERE a.area = :area")})
public class ApsAreaPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Column(name = "cod_area")
    private String codArea;
    @Column(name = "area")
    private String area;
    @JoinTable(name = "aps_especialidad_post", joinColumns = {
        @JoinColumn(name = "id_area", referencedColumnName = "id_area")}, inverseJoinColumns = {
        @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")})
    @ManyToMany
    private List<ApsEspecialidad> apsEspecialidadList;
    @JoinColumn(name = "id_ambito", referencedColumnName = "id_ambito")
    @ManyToOne
    private ApsAmbitoAcad idAmbito;

    public ApsAreaPost() {
    }

    public ApsAreaPost(Integer idArea) {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        if (!(object instanceof ApsAreaPost)) {
            return false;
        }
        ApsAreaPost other = (ApsAreaPost) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsAreaPost[ idArea=" + idArea + " ]";
    }
    
}
