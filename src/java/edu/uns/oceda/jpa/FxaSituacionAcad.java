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
@Table(name = "fxa_situacion_acad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FxaSituacionAcad.findAll", query = "SELECT f FROM FxaSituacionAcad f"),
    @NamedQuery(name = "FxaSituacionAcad.findByCodSitAcad", query = "SELECT f FROM FxaSituacionAcad f WHERE f.codSitAcad = :codSitAcad"),
    @NamedQuery(name = "FxaSituacionAcad.findByNombre", query = "SELECT f FROM FxaSituacionAcad f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FxaSituacionAcad.findByDescripcion", query = "SELECT f FROM FxaSituacionAcad f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "FxaSituacionAcad.findByCodAcsit", query = "SELECT f FROM FxaSituacionAcad f WHERE f.codAcsit = :codAcsit")})
public class FxaSituacionAcad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_sit_acad")
    private String codSitAcad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cod_acsit")
    private Character codAcsit;

    public FxaSituacionAcad() {
    }

    public FxaSituacionAcad(String codSitAcad) {
        this.codSitAcad = codSitAcad;
    }

    public FxaSituacionAcad(String codSitAcad, String nombre) {
        this.codSitAcad = codSitAcad;
        this.nombre = nombre;
    }

    public String getCodSitAcad() {
        return codSitAcad;
    }

    public void setCodSitAcad(String codSitAcad) {
        this.codSitAcad = codSitAcad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getCodAcsit() {
        return codAcsit;
    }

    public void setCodAcsit(Character codAcsit) {
        this.codAcsit = codAcsit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSitAcad != null ? codSitAcad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxaSituacionAcad)) {
            return false;
        }
        FxaSituacionAcad other = (FxaSituacionAcad) object;
        if ((this.codSitAcad == null && other.codSitAcad != null) || (this.codSitAcad != null && !this.codSitAcad.equals(other.codSitAcad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.model.FxaSituacionAcad[ codSitAcad=" + codSitAcad + " ]";
    }
    
}
