/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sva_respuesta_texto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaRespuestaTexto.findAll", query = "SELECT s FROM SvaRespuestaTexto s"),
    @NamedQuery(name = "SvaRespuestaTexto.findByIdParticipacion", query = "SELECT s FROM SvaRespuestaTexto s WHERE s.svaRespuestaTextoPK.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "SvaRespuestaTexto.findByIdEncuesta", query = "SELECT s FROM SvaRespuestaTexto s WHERE s.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "SvaRespuestaTexto.findByIdDir", query = "SELECT s FROM SvaRespuestaTexto s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SvaRespuestaTexto.findByIdPregunta", query = "SELECT s FROM SvaRespuestaTexto s WHERE s.svaRespuestaTextoPK.idPregunta = :idPregunta")})
public class SvaRespuestaTexto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SvaRespuestaTextoPK svaRespuestaTextoPK;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;
    @Lob
    @Column(name = "respuesta")
    private String respuesta;

    public SvaRespuestaTexto() {
    }

    public SvaRespuestaTexto(SvaRespuestaTextoPK svaRespuestaTextoPK) {
        this.svaRespuestaTextoPK = svaRespuestaTextoPK;
    }

    public SvaRespuestaTexto(SvaRespuestaTextoPK svaRespuestaTextoPK, int idEncuesta, int idDir) {
        this.svaRespuestaTextoPK = svaRespuestaTextoPK;
        this.idEncuesta = idEncuesta;
        this.idDir = idDir;
    }

    public SvaRespuestaTexto(int idParticipacion, int idPregunta) {
        this.svaRespuestaTextoPK = new SvaRespuestaTextoPK(idParticipacion, idPregunta);
    }

    public SvaRespuestaTextoPK getSvaRespuestaTextoPK() {
        return svaRespuestaTextoPK;
    }

    public void setSvaRespuestaTextoPK(SvaRespuestaTextoPK svaRespuestaTextoPK) {
        this.svaRespuestaTextoPK = svaRespuestaTextoPK;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (svaRespuestaTextoPK != null ? svaRespuestaTextoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaRespuestaTexto)) {
            return false;
        }
        SvaRespuestaTexto other = (SvaRespuestaTexto) object;
        if ((this.svaRespuestaTextoPK == null && other.svaRespuestaTextoPK != null) || (this.svaRespuestaTextoPK != null && !this.svaRespuestaTextoPK.equals(other.svaRespuestaTextoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaRespuestaTexto[ svaRespuestaTextoPK=" + svaRespuestaTextoPK + " ]";
    }
    
}
