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
 * @author USER
 */
@Entity
@Table(name = "fxa_nivel_acad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FxaNivelAcad.findAll", query = "SELECT f FROM FxaNivelAcad f"),
    @NamedQuery(name = "FxaNivelAcad.findByCodNivAcad", query = "SELECT f FROM FxaNivelAcad f WHERE f.codNivAcad = :codNivAcad"),
    @NamedQuery(name = "FxaNivelAcad.findByNombre", query = "SELECT f FROM FxaNivelAcad f WHERE f.nombre = :nombre")})
public class FxaNivelAcad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_niv_acad")
    private String codNivAcad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    public FxaNivelAcad() {
    }

    public FxaNivelAcad(String codNivAcad) {
        this.codNivAcad = codNivAcad;
    }

    public FxaNivelAcad(String codNivAcad, String nombre) {
        this.codNivAcad = codNivAcad;
        this.nombre = nombre;
    }

    public String getCodNivAcad() {
        return codNivAcad;
    }

    public void setCodNivAcad(String codNivAcad) {
        this.codNivAcad = codNivAcad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNivAcad != null ? codNivAcad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxaNivelAcad)) {
            return false;
        }
        FxaNivelAcad other = (FxaNivelAcad) object;
        if ((this.codNivAcad == null && other.codNivAcad != null) || (this.codNivAcad != null && !this.codNivAcad.equals(other.codNivAcad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.model.FxaNivelAcad[ codNivAcad=" + codNivAcad + " ]";
    }
    
}
