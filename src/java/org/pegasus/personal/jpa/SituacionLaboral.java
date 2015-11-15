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
@Table(name = "situacion_laboral")
@NamedQueries({
    @NamedQuery(name = "SituacionLaboral.findAll", query = "SELECT s FROM SituacionLaboral s")})
public class SituacionLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "situacion_laboral")
    private String situacionLaboral;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;

    public SituacionLaboral() {
    }

    public SituacionLaboral(String situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public String getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(String situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (situacionLaboral != null ? situacionLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionLaboral)) {
            return false;
        }
        SituacionLaboral other = (SituacionLaboral) object;
        if ((this.situacionLaboral == null && other.situacionLaboral != null) || (this.situacionLaboral != null && !this.situacionLaboral.equals(other.situacionLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.SituacionLaboral[ situacionLaboral=" + situacionLaboral + " ]";
    }
    
}
