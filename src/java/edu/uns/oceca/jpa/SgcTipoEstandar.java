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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_tipo_estandar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcTipoEstandar.findAll", query = "SELECT s FROM SgcTipoEstandar s"),
    @NamedQuery(name = "SgcTipoEstandar.findByIdTipo", query = "SELECT s FROM SgcTipoEstandar s WHERE s.idTipo = :idTipo"),
    @NamedQuery(name = "SgcTipoEstandar.findBySimbolo", query = "SELECT s FROM SgcTipoEstandar s WHERE s.simbolo = :simbolo"),
    @NamedQuery(name = "SgcTipoEstandar.findByTipo", query = "SELECT s FROM SgcTipoEstandar s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "SgcTipoEstandar.findByDescripcion", query = "SELECT s FROM SgcTipoEstandar s WHERE s.descripcion = :descripcion")})
public class SgcTipoEstandar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Basic(optional = false)
    @Column(name = "simbolo")
    private String simbolo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public SgcTipoEstandar() {
    }

    public SgcTipoEstandar(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public SgcTipoEstandar(Integer idTipo, String simbolo, String tipo, String descripcion) {
        this.idTipo = idTipo;
        this.simbolo = simbolo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcTipoEstandar)) {
            return false;
        }
        SgcTipoEstandar other = (SgcTipoEstandar) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcTipoEstandar[ idTipo=" + idTipo + " ]";
    }
    
}
