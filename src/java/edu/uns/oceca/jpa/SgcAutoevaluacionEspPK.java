/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorik
 */
@Embeddable
public class SgcAutoevaluacionEspPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_autoevaluacion")
    private int idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private int idEspecialidad;

    public SgcAutoevaluacionEspPK() {
    }

    public SgcAutoevaluacionEspPK(int idAutoevaluacion, int idEspecialidad) {
        this.idAutoevaluacion = idAutoevaluacion;
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAutoevaluacion;
        hash += (int) idEspecialidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAutoevaluacionEspPK)) {
            return false;
        }
        SgcAutoevaluacionEspPK other = (SgcAutoevaluacionEspPK) object;
        if (this.idAutoevaluacion != other.idAutoevaluacion) {
            return false;
        }
        if (this.idEspecialidad != other.idEspecialidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAutoevaluacionEspPK[ idAutoevaluacion=" + idAutoevaluacion + ", idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
