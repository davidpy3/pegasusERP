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
@Table(name = "sva_respuesta_est")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaRespuestaEst.findAll", query = "SELECT s FROM SvaRespuestaEst s"),
    @NamedQuery(name = "SvaRespuestaEst.findByIdParticipacion", query = "SELECT s FROM SvaRespuestaEst s WHERE s.svaRespuestaEstPK.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "SvaRespuestaEst.findByIdEncuesta", query = "SELECT s FROM SvaRespuestaEst s WHERE s.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "SvaRespuestaEst.findByIdAcexp", query = "SELECT s FROM SvaRespuestaEst s WHERE s.idAcexp = :idAcexp"),
    @NamedQuery(name = "SvaRespuestaEst.findByIdPregunta", query = "SELECT s FROM SvaRespuestaEst s WHERE s.svaRespuestaEstPK.idPregunta = :idPregunta"),
    @NamedQuery(name = "SvaRespuestaEst.findByIdOpcion", query = "SELECT s FROM SvaRespuestaEst s WHERE s.idOpcion = :idOpcion")})
public class SvaRespuestaEst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SvaRespuestaEstPK svaRespuestaEstPK;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_acexp")
    private int idAcexp;
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private int idOpcion;

    public SvaRespuestaEst() {
    }

    public SvaRespuestaEst(SvaRespuestaEstPK svaRespuestaEstPK) {
        this.svaRespuestaEstPK = svaRespuestaEstPK;
    }

    public SvaRespuestaEst(SvaRespuestaEstPK svaRespuestaEstPK, int idEncuesta, int idAcexp, int idOpcion) {
        this.svaRespuestaEstPK = svaRespuestaEstPK;
        this.idEncuesta = idEncuesta;
        this.idAcexp = idAcexp;
        this.idOpcion = idOpcion;
    }

    public SvaRespuestaEst(int idParticipacion, int idPregunta) {
        this.svaRespuestaEstPK = new SvaRespuestaEstPK(idParticipacion, idPregunta);
    }

    public SvaRespuestaEstPK getSvaRespuestaEstPK() {
        return svaRespuestaEstPK;
    }

    public void setSvaRespuestaEstPK(SvaRespuestaEstPK svaRespuestaEstPK) {
        this.svaRespuestaEstPK = svaRespuestaEstPK;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(int idAcexp) {
        this.idAcexp = idAcexp;
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
        hash += (svaRespuestaEstPK != null ? svaRespuestaEstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaRespuestaEst)) {
            return false;
        }
        SvaRespuestaEst other = (SvaRespuestaEst) object;
        if ((this.svaRespuestaEstPK == null && other.svaRespuestaEstPK != null) || (this.svaRespuestaEstPK != null && !this.svaRespuestaEstPK.equals(other.svaRespuestaEstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaRespuestaEst[ svaRespuestaEstPK=" + svaRespuestaEstPK + " ]";
    }
    
}
