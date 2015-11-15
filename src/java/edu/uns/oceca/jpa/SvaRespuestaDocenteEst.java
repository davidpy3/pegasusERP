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
@Table(name = "sva_respuesta_docente_est")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaRespuestaDocenteEst.findAll", query = "SELECT s FROM SvaRespuestaDocenteEst s"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdParticipacion", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.svaRespuestaDocenteEstPK.idParticipacion = :idParticipacion"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdEncuesta", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.idEncuesta = :idEncuesta"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdAcexp", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.idAcexp = :idAcexp"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdDocente", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.idDocente = :idDocente"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdAsignatura", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdPregunta", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.svaRespuestaDocenteEstPK.idPregunta = :idPregunta"),
    @NamedQuery(name = "SvaRespuestaDocenteEst.findByIdOpcion", query = "SELECT s FROM SvaRespuestaDocenteEst s WHERE s.idOpcion = :idOpcion")})
public class SvaRespuestaDocenteEst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SvaRespuestaDocenteEstPK svaRespuestaDocenteEstPK;
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private int idEncuesta;
    @Basic(optional = false)
    @Column(name = "id_acexp")
    private int idAcexp;
    @Basic(optional = false)
    @Column(name = "id_docente")
    private int idDocente;
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private int idAsignatura;
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private int idOpcion;

    public SvaRespuestaDocenteEst() {
    }

    public SvaRespuestaDocenteEst(SvaRespuestaDocenteEstPK svaRespuestaDocenteEstPK) {
        this.svaRespuestaDocenteEstPK = svaRespuestaDocenteEstPK;
    }

    public SvaRespuestaDocenteEst(SvaRespuestaDocenteEstPK svaRespuestaDocenteEstPK, int idEncuesta, int idAcexp, int idDocente, int idAsignatura, int idOpcion) {
        this.svaRespuestaDocenteEstPK = svaRespuestaDocenteEstPK;
        this.idEncuesta = idEncuesta;
        this.idAcexp = idAcexp;
        this.idDocente = idDocente;
        this.idAsignatura = idAsignatura;
        this.idOpcion = idOpcion;
    }

    public SvaRespuestaDocenteEst(int idParticipacion, int idPregunta) {
        this.svaRespuestaDocenteEstPK = new SvaRespuestaDocenteEstPK(idParticipacion, idPregunta);
    }

    public SvaRespuestaDocenteEstPK getSvaRespuestaDocenteEstPK() {
        return svaRespuestaDocenteEstPK;
    }

    public void setSvaRespuestaDocenteEstPK(SvaRespuestaDocenteEstPK svaRespuestaDocenteEstPK) {
        this.svaRespuestaDocenteEstPK = svaRespuestaDocenteEstPK;
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

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
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
        hash += (svaRespuestaDocenteEstPK != null ? svaRespuestaDocenteEstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaRespuestaDocenteEst)) {
            return false;
        }
        SvaRespuestaDocenteEst other = (SvaRespuestaDocenteEst) object;
        if ((this.svaRespuestaDocenteEstPK == null && other.svaRespuestaDocenteEstPK != null) || (this.svaRespuestaDocenteEstPK != null && !this.svaRespuestaDocenteEstPK.equals(other.svaRespuestaDocenteEstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaRespuestaDocenteEst[ svaRespuestaDocenteEstPK=" + svaRespuestaDocenteEstPK + " ]";
    }
    
}
