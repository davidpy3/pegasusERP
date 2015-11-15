/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_estandar")
@NamedQueries({
    @NamedQuery(name = "SgcEstandar.findAll", query = "SELECT s FROM SgcEstandar s")})
public class SgcEstandar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estandar")
    private Integer idEstandar;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "id_factor")
    private int idFactor;
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private int idCriterio;
    @Basic(optional = false)
    @Column(name = "id_modelo")
    private int idModelo;
    @Basic(optional = false)
//    @Lob
    @Column(name = "estandar")
    private String estandar;
    
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private int idTipo;
  
    
    
    @Column(name = "consideracion")
    private String consideracion;

    public SgcEstandar() {
    }

    public SgcEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public SgcEstandar(Integer idEstandar, int numero, int idFactor, int idCriterio, int idModelo, String estandar, int idTipo) {
        this.idEstandar = idEstandar;
        this.numero = numero;
        this.idFactor = idFactor;
        this.idCriterio = idCriterio;
        this.idModelo = idModelo;
        this.estandar = estandar;
        this.idTipo = idTipo;
    }

    public Integer getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(int idFactor) {
        this.idFactor = idFactor;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getEstandar() {
        return estandar;
    }

    public void setEstandar(String estandar) {
        this.estandar = estandar;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getConsideracion() {
        return consideracion;
    }

    public void setConsideracion(String consideracion) {
        this.consideracion = consideracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstandar != null ? idEstandar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcEstandar)) {
            return false;
        }
        SgcEstandar other = (SgcEstandar) object;
        if ((this.idEstandar == null && other.idEstandar != null) || (this.idEstandar != null && !this.idEstandar.equals(other.idEstandar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.jpa.SgcEstandar[ idEstandar=" + idEstandar + " ]";
    }
    
}
