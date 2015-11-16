package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_respuesta")
public class QuizRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SvaRespuestaPK svaRespuestaPK;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private int idOpcion;

    public QuizRespuesta() {
    }

    public QuizRespuesta(SvaRespuestaPK svaRespuestaPK) {
        this.svaRespuestaPK = svaRespuestaPK;
    }

    public QuizRespuesta(SvaRespuestaPK svaRespuestaPK, int idEncuesta, int idOpcion) {
        this.svaRespuestaPK = svaRespuestaPK;
        this.idEncuesta = idEncuesta;
        this.idOpcion = idOpcion;
    }

    public QuizRespuesta(int idParticipacion, int idPregunta) {
        this.svaRespuestaPK = new SvaRespuestaPK(idParticipacion, idPregunta);
    }

    public SvaRespuestaPK getSvaRespuestaPK() {
        return svaRespuestaPK;
    }

    public void setSvaRespuestaPK(SvaRespuestaPK svaRespuestaPK) {
        this.svaRespuestaPK = svaRespuestaPK;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svaRespuestaPK != null ? svaRespuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizRespuesta)) {
            return false;
        }
        QuizRespuesta other = (QuizRespuesta) object;
        if ((this.svaRespuestaPK == null && other.svaRespuestaPK != null) || (this.svaRespuestaPK != null && !this.svaRespuestaPK.equals(other.svaRespuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaRespuesta[ svaRespuestaPK=" + svaRespuestaPK + " ]";
    }
    
}
