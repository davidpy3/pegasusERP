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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sva_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaRespuesta.findAll", query = "SELECT s FROM SvaRespuesta s"),
    @NamedQuery(name = "SvaRespuesta.findByIdParticipacion", query = "SELECT s FROM SvaRespuesta s WHERE s.svaRespuestaPK.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "SvaRespuesta.findByIdEncuesta", query = "SELECT s FROM SvaRespuesta s WHERE s.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "SvaRespuesta.findByIdDir", query = "SELECT s FROM SvaRespuesta s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SvaRespuesta.findByIdPregunta", query = "SELECT s FROM SvaRespuesta s WHERE s.svaRespuestaPK.idPregunta = :idPregunta"),
    @NamedQuery(name = "SvaRespuesta.findByIdOpcion", query = "SELECT s FROM SvaRespuesta s WHERE s.idOpcion = :idOpcion")})
public class SvaRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SvaRespuestaPK svaRespuestaPK;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private int idOpcion;

    public SvaRespuesta() {
    }

    public SvaRespuesta(SvaRespuestaPK svaRespuestaPK) {
        this.svaRespuestaPK = svaRespuestaPK;
    }

    public SvaRespuesta(SvaRespuestaPK svaRespuestaPK, int idEncuesta, int idDir, int idOpcion) {
        this.svaRespuestaPK = svaRespuestaPK;
        this.idEncuesta = idEncuesta;
        this.idDir = idDir;
        this.idOpcion = idOpcion;
    }

    public SvaRespuesta(int idParticipacion, int idPregunta) {
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

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
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
        if (!(object instanceof SvaRespuesta)) {
            return false;
        }
        SvaRespuesta other = (SvaRespuesta) object;
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
