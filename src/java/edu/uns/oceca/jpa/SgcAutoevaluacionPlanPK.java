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
public class SgcAutoevaluacionPlanPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_autoevaluacion")
    private int idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_estandar")
    private int idEstandar;
    @Basic(optional = false)
    @Column(name = "id_placti")
    private int idPlacti;

    public SgcAutoevaluacionPlanPK() {
    }

    public SgcAutoevaluacionPlanPK(int idAutoevaluacion, int idEstandar, int idPlacti) {
        this.idAutoevaluacion = idAutoevaluacion;
        this.idEstandar = idEstandar;
        this.idPlacti = idPlacti;
    }

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(int idEstandar) {
        this.idEstandar = idEstandar;
    }

    public int getIdPlacti() {
        return idPlacti;
    }

    public void setIdPlacti(int idPlacti) {
        this.idPlacti = idPlacti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAutoevaluacion;
        hash += (int) idEstandar;
        hash += (int) idPlacti;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAutoevaluacionPlanPK)) {
            return false;
        }
        SgcAutoevaluacionPlanPK other = (SgcAutoevaluacionPlanPK) object;
        if (this.idAutoevaluacion != other.idAutoevaluacion) {
            return false;
        }
        if (this.idEstandar != other.idEstandar) {
            return false;
        }
        if (this.idPlacti != other.idPlacti) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK[ idAutoevaluacion=" + idAutoevaluacion + ", idEstandar=" + idEstandar + ", idPlacti=" + idPlacti + " ]";
    }
    
}
