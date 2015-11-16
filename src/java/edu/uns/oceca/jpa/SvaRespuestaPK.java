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
public class SvaRespuestaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_participacion")
    private int idParticipacion;
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private int idPregunta;

    public SvaRespuestaPK() {
    }

    public SvaRespuestaPK(int idParticipacion, int idPregunta) {
        this.idParticipacion = idParticipacion;
        this.idPregunta = idPregunta;
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(int idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idParticipacion;
        hash += (int) idPregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaRespuestaPK)) {
            return false;
        }
        SvaRespuestaPK other = (SvaRespuestaPK) object;
        if (this.idParticipacion != other.idParticipacion) {
            return false;
        }
        if (this.idPregunta != other.idPregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaRespuestaPK[ idParticipacion=" + idParticipacion + ", idPregunta=" + idPregunta + " ]";
    }
    
}
