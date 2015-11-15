/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

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
@Table(name = "son_tipo_movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimiento.findAll", query = "SELECT t FROM TipoMovimiento t"),
    @NamedQuery(name = "TipoMovimiento.findByIdTipoMov", query = "SELECT t FROM TipoMovimiento t WHERE t.idTipoMov = :idTipoMov"),
    @NamedQuery(name = "TipoMovimiento.findByNombre", query = "SELECT t FROM TipoMovimiento t WHERE t.nombre = :nombre")})
public class TipoMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_mov")
    private Integer idTipoMov;
    @Column(name = "nombre")
    private String nombre;

    public TipoMovimiento() {
    }

    public TipoMovimiento(Integer idTipoMov) {
        this.idTipoMov = idTipoMov;
    }

    public Integer getIdTipoMov() {
        return idTipoMov;
    }

    public void setIdTipoMov(Integer idTipoMov) {
        this.idTipoMov = idTipoMov;
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
        hash += (idTipoMov != null ? idTipoMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimiento)) {
            return false;
        }
        TipoMovimiento other = (TipoMovimiento) object;
        if ((this.idTipoMov == null && other.idTipoMov != null) || (this.idTipoMov != null && !this.idTipoMov.equals(other.idTipoMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model.TipoMovimiento[ idTipoMov=" + idTipoMov + " ]";
    }
    
}
