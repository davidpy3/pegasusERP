package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SgcEncuestaParticipantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "tipo")
    private char tipo;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;

    public SgcEncuestaParticipantePK() {
    }

    public SgcEncuestaParticipantePK(int idEncuesta, char tipo, int idDir) {
        this.idEncuesta = idEncuesta;
        this.tipo = tipo;
        this.idDir = idDir;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEncuesta;
        hash += (int) tipo;
        hash += (int) idDir;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcEncuestaParticipantePK)) {
            return false;
        }
        SgcEncuestaParticipantePK other = (SgcEncuestaParticipantePK) object;
        if (this.idEncuesta != other.idEncuesta) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.idDir != other.idDir) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceca.sva.SgcEncuestaParticipantePK[idEncuesta=" + idEncuesta + ", tipo=" + tipo + ", idDir=" + idDir + "]";
    }

}
