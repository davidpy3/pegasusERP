/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "finalidad")
@NamedQueries({
    @NamedQuery(name = "Finalidad.findAll", query = "SELECT f FROM Finalidad f")})
public class Finalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinalidadPK finalidadPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "ambito")
    private Character ambito;
    @Column(name = "es_presupuestal")
    private Character esPresupuestal;
    @Column(name = "ambito_en")
    private Character ambitoEn;
    @Column(name = "ambito_programa")
    private String ambitoPrograma;
    @Column(name = "es_generico")
    private Character esGenerico;

    public Finalidad() {
    }

    public Finalidad(FinalidadPK finalidadPK) {
        this.finalidadPK = finalidadPK;
    }

    public Finalidad(String anoEje, String finalidad) {
        this.finalidadPK = new FinalidadPK(anoEje, finalidad);
    }

    public FinalidadPK getFinalidadPK() {
        return finalidadPK;
    }

    public void setFinalidadPK(FinalidadPK finalidadPK) {
        this.finalidadPK = finalidadPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getAmbito() {
        return ambito;
    }

    public void setAmbito(Character ambito) {
        this.ambito = ambito;
    }

    public Character getEsPresupuestal() {
        return esPresupuestal;
    }

    public void setEsPresupuestal(Character esPresupuestal) {
        this.esPresupuestal = esPresupuestal;
    }

    public Character getAmbitoEn() {
        return ambitoEn;
    }

    public void setAmbitoEn(Character ambitoEn) {
        this.ambitoEn = ambitoEn;
    }

    public String getAmbitoPrograma() {
        return ambitoPrograma;
    }

    public void setAmbitoPrograma(String ambitoPrograma) {
        this.ambitoPrograma = ambitoPrograma;
    }

    public Character getEsGenerico() {
        return esGenerico;
    }

    public void setEsGenerico(Character esGenerico) {
        this.esGenerico = esGenerico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finalidadPK != null ? finalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finalidad)) {
            return false;
        }
        Finalidad other = (Finalidad) object;
        if ((this.finalidadPK == null && other.finalidadPK != null) || (this.finalidadPK != null && !this.finalidadPK.equals(other.finalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Finalidad[ finalidadPK=" + finalidadPK + " ]";
    }
    
}
