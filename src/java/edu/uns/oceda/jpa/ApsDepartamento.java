/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "aps_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApsDepartamento.findAll", query = "SELECT a FROM ApsDepartamento a"),
    @NamedQuery(name = "ApsDepartamento.findByIdDepartamento", query = "SELECT a FROM ApsDepartamento a WHERE a.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "ApsDepartamento.findByIdFacultad", query = "SELECT a FROM ApsDepartamento a WHERE a.idFacultad = :idFacultad"),
    @NamedQuery(name = "ApsDepartamento.findByDepartamento", query = "SELECT a FROM ApsDepartamento a WHERE a.departamento = :departamento"),
    @NamedQuery(name = "ApsDepartamento.findByAbr", query = "SELECT a FROM ApsDepartamento a WHERE a.abr = :abr"),
    @NamedQuery(name = "ApsDepartamento.findByCodOld", query = "SELECT a FROM ApsDepartamento a WHERE a.codOld = :codOld"),
    @NamedQuery(name = "ApsDepartamento.findByIdDep", query = "SELECT a FROM ApsDepartamento a WHERE a.idDep = :idDep")})
public class ApsDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Column(name = "id_facultad")
    private Integer idFacultad;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "abr")
    private String abr;
    @Column(name = "cod_old")
    private String codOld;
    @Column(name = "id_dep")
    private Integer idDep;

    public ApsDepartamento() {
    }

    public ApsDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getCodOld() {
        return codOld;
    }

    public void setCodOld(String codOld) {
        this.codOld = codOld;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsDepartamento)) {
            return false;
        }
        ApsDepartamento other = (ApsDepartamento) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsDepartamento[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
