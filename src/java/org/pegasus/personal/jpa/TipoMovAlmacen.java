/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "tipo_mov_almacen")
@NamedQueries({
    @NamedQuery(name = "TipoMovAlmacen.findAll", query = "SELECT t FROM TipoMovAlmacen t")})
public class TipoMovAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_mov")
    private Integer tipoMov;
    @Column(name = "tipo_transac")
    private Character tipoTransac;
    @Column(name = "nombre_mov")
    private String nombreMov;
    @Column(name = "abrev_mov")
    private String abrevMov;
    @Column(name = "estado")
    private Character estado;

    public TipoMovAlmacen() {
    }

    public TipoMovAlmacen(Integer tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Integer getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Integer tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Character getTipoTransac() {
        return tipoTransac;
    }

    public void setTipoTransac(Character tipoTransac) {
        this.tipoTransac = tipoTransac;
    }

    public String getNombreMov() {
        return nombreMov;
    }

    public void setNombreMov(String nombreMov) {
        this.nombreMov = nombreMov;
    }

    public String getAbrevMov() {
        return abrevMov;
    }

    public void setAbrevMov(String abrevMov) {
        this.abrevMov = abrevMov;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoMov != null ? tipoMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovAlmacen)) {
            return false;
        }
        TipoMovAlmacen other = (TipoMovAlmacen) object;
        if ((this.tipoMov == null && other.tipoMov != null) || (this.tipoMov != null && !this.tipoMov.equals(other.tipoMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TipoMovAlmacen[ tipoMov=" + tipoMov + " ]";
    }
    
}
