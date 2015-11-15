/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
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
@Table(name = "sgc_autoevaluacion_esp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAutoevaluacionEsp.findAll", query = "SELECT s FROM SgcAutoevaluacionEsp s"),
    @NamedQuery(name = "SgcAutoevaluacionEsp.findByIdAutoevaluacion", query = "SELECT s FROM SgcAutoevaluacionEsp s WHERE s.sgcAutoevaluacionEspPK.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SgcAutoevaluacionEsp.findByIdEspecialidad", query = "SELECT s FROM SgcAutoevaluacionEsp s WHERE s.sgcAutoevaluacionEspPK.idEspecialidad = :idEspecialidad")})
public class SgcAutoevaluacionEsp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcAutoevaluacionEspPK sgcAutoevaluacionEspPK;

    public SgcAutoevaluacionEsp() {
    }

    public SgcAutoevaluacionEsp(SgcAutoevaluacionEspPK sgcAutoevaluacionEspPK) {
        this.sgcAutoevaluacionEspPK = sgcAutoevaluacionEspPK;
    }

    public SgcAutoevaluacionEsp(int idAutoevaluacion, int idEspecialidad) {
        this.sgcAutoevaluacionEspPK = new SgcAutoevaluacionEspPK(idAutoevaluacion, idEspecialidad);
    }

    public SgcAutoevaluacionEspPK getSgcAutoevaluacionEspPK() {
        return sgcAutoevaluacionEspPK;
    }

    public void setSgcAutoevaluacionEspPK(SgcAutoevaluacionEspPK sgcAutoevaluacionEspPK) {
        this.sgcAutoevaluacionEspPK = sgcAutoevaluacionEspPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcAutoevaluacionEspPK != null ? sgcAutoevaluacionEspPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAutoevaluacionEsp)) {
            return false;
        }
        SgcAutoevaluacionEsp other = (SgcAutoevaluacionEsp) object;
        if ((this.sgcAutoevaluacionEspPK == null && other.sgcAutoevaluacionEspPK != null) || (this.sgcAutoevaluacionEspPK != null && !this.sgcAutoevaluacionEspPK.equals(other.sgcAutoevaluacionEspPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAutoevaluacionEsp[ sgcAutoevaluacionEspPK=" + sgcAutoevaluacionEspPK + " ]";
    }
    
}
