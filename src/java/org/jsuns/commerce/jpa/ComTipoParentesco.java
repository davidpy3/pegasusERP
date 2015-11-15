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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_tipo_parentesco")
@NamedQueries({
    @NamedQuery(name = "ComTipoParentesco.findAll", query = "SELECT c FROM ComTipoParentesco c")})
public class ComTipoParentesco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tippar")
    private Integer idTippar;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;

    public ComTipoParentesco() {
    }

    public ComTipoParentesco(Integer idTippar) {
        this.idTippar = idTippar;
    }

    public Integer getIdTippar() {
        return idTippar;
    }

    public void setIdTippar(Integer idTippar) {
        this.idTippar = idTippar;
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
        hash += (idTippar != null ? idTippar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComTipoParentesco)) {
            return false;
        }
        ComTipoParentesco other = (ComTipoParentesco) object;
        if ((this.idTippar == null && other.idTippar != null) || (this.idTippar != null && !this.idTippar.equals(other.idTippar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComTipoParentesco[ idTippar=" + idTippar + " ]";
    }
    
}
