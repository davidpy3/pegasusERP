package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sva_encuesta_participacion")
public class SgcEncuestaParticipante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcEncuestaParticipantePK sgcEncuestaParticipantePK;
    @Column(name = "flags")
    private String flags;
    @Column(name = "id_acexp")
    private Integer idAcexp;
    @Basic(optional = false)
    @Column(name = "cerrado")
    private boolean cerrado;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;

    public SgcEncuestaParticipante() {
    }

    public SgcEncuestaParticipante(SgcEncuestaParticipantePK sgcEncuestaParticipantePK) {
        this.sgcEncuestaParticipantePK = sgcEncuestaParticipantePK;
    }

    public SgcEncuestaParticipante(SgcEncuestaParticipantePK sgcEncuestaParticipantePK, boolean cerrado, Date fechaReg,String flags) {
        this.sgcEncuestaParticipantePK = sgcEncuestaParticipantePK;
        this.cerrado = cerrado;
        this.fechaReg = fechaReg;
        this.flags=flags;
    }

    public SgcEncuestaParticipante(int idEncuesta, char tipo, int idDir) {
        this.sgcEncuestaParticipantePK = new SgcEncuestaParticipantePK(idEncuesta, tipo, idDir);
        
    }

    public SgcEncuestaParticipantePK getSgcEncuestaParticipantePK() {
        return sgcEncuestaParticipantePK;
    }

    public void setSgcEncuestaParticipantePK(SgcEncuestaParticipantePK sgcEncuestaParticipantePK) {
        this.sgcEncuestaParticipantePK = sgcEncuestaParticipantePK;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public Integer getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcEncuestaParticipantePK != null ? sgcEncuestaParticipantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcEncuestaParticipante)) {
            return false;
        }
        SgcEncuestaParticipante other = (SgcEncuestaParticipante) object;
        if ((this.sgcEncuestaParticipantePK == null && other.sgcEncuestaParticipantePK != null) || (this.sgcEncuestaParticipantePK != null && !this.sgcEncuestaParticipantePK.equals(other.sgcEncuestaParticipantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceca.sva.SgcEncuestaParticipante[sgcEncuestaParticipantePK=" + sgcEncuestaParticipantePK + "]";
    }

}
