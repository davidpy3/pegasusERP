/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_autoevaluacion_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAutoevaluacionPlan.findAll", query = "SELECT s FROM SgcAutoevaluacionPlan s"),
    @NamedQuery(name = "SgcAutoevaluacionPlan.findByIdAutoevaluacion", query = "SELECT s FROM SgcAutoevaluacionPlan s WHERE s.sgcAutoevaluacionPlanPK.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SgcAutoevaluacionPlan.findByIdEstandar", query = "SELECT s FROM SgcAutoevaluacionPlan s WHERE s.sgcAutoevaluacionPlanPK.idEstandar = :idEstandar"),
    @NamedQuery(name = "SgcAutoevaluacionPlan.findByIdPlacti", query = "SELECT s FROM SgcAutoevaluacionPlan s WHERE s.sgcAutoevaluacionPlanPK.idPlacti = :idPlacti"),
    @NamedQuery(name = "SgcAutoevaluacionPlan.findByResponsables", query = "SELECT s FROM SgcAutoevaluacionPlan s WHERE s.responsables = :responsables"),
    @NamedQuery(name = "SgcAutoevaluacionPlan.findByRecursos", query = "SELECT s FROM SgcAutoevaluacionPlan s WHERE s.recursos = :recursos")})
public class SgcAutoevaluacionPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcAutoevaluacionPlanPK sgcAutoevaluacionPlanPK;
    @Column(name = "responsables")
    private String responsables;
    @Column(name = "recursos")
    private String recursos;

    public SgcAutoevaluacionPlan() {
    }

    public SgcAutoevaluacionPlan(SgcAutoevaluacionPlanPK sgcAutoevaluacionPlanPK) {
        this.sgcAutoevaluacionPlanPK = sgcAutoevaluacionPlanPK;
    }

    public SgcAutoevaluacionPlan(int idAutoevaluacion, int idEstandar, int idPlacti) {
        this.sgcAutoevaluacionPlanPK = new SgcAutoevaluacionPlanPK(idAutoevaluacion, idEstandar, idPlacti);
    }

    public SgcAutoevaluacionPlanPK getSgcAutoevaluacionPlanPK() {
        return sgcAutoevaluacionPlanPK;
    }

    public void setSgcAutoevaluacionPlanPK(SgcAutoevaluacionPlanPK sgcAutoevaluacionPlanPK) {
        this.sgcAutoevaluacionPlanPK = sgcAutoevaluacionPlanPK;
    }

    public String getResponsables() {
        return responsables;
    }

    public void setResponsables(String responsables) {
        this.responsables = responsables;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcAutoevaluacionPlanPK != null ? sgcAutoevaluacionPlanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAutoevaluacionPlan)) {
            return false;
        }
        SgcAutoevaluacionPlan other = (SgcAutoevaluacionPlan) object;
        if ((this.sgcAutoevaluacionPlanPK == null && other.sgcAutoevaluacionPlanPK != null) || (this.sgcAutoevaluacionPlanPK != null && !this.sgcAutoevaluacionPlanPK.equals(other.sgcAutoevaluacionPlanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAutoevaluacionPlan[ sgcAutoevaluacionPlanPK=" + sgcAutoevaluacionPlanPK + " ]";
    }
    
}
