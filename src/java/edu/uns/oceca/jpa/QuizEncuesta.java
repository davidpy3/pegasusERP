package edu.uns.oceca.jpa;

import edu.uns.oceda.jpa.ApcPeriodoAcademico;
import edu.uns.oceda.jpa.ApsEspecialidad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "quiz_encuesta_especialidad")
public class QuizEncuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Transient
    private List<QuizPregunta> preguntaList;

    public List<QuizPregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<QuizPregunta> concepto) {
        this.preguntaList = concepto;
    }
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_encuesta")
    private Integer idEncuesta;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "id_editor")
    private int idEditor;
    @Basic(optional = false)
    @Column(name = "id_creador")
    private int idCreador;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;

    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private ApsEspecialidad apsEspecialidad;
    @JoinColumn(name = "id_acper", referencedColumnName = "id_acper")
    @ManyToOne
    private ApcPeriodoAcademico apcPeriodoAcademico;
    @JoinColumn(name = "id_cuestionario", referencedColumnName = "id_cuestionario")
    @ManyToOne
    private QuizCuestionario quizCuestionario;

    public QuizCuestionario getQuizCuestionario() {
        return quizCuestionario;
    }

    public void setQuizCuestionario(QuizCuestionario quizCuestionario) {
        this.quizCuestionario = quizCuestionario;
    }
    
    public ApsEspecialidad getApsEspecialidad() {
        return apsEspecialidad;
    }

    public void setApsEspecialidad(ApsEspecialidad apsEspecialidad) {
        this.apsEspecialidad = apsEspecialidad;
    }

    public ApcPeriodoAcademico getApcPeriodoAcademico() {
        return apcPeriodoAcademico;
    }

    public void setApcPeriodoAcademico(ApcPeriodoAcademico apcPeriodoAcademico) {
        this.apcPeriodoAcademico = apcPeriodoAcademico;
    }
    
    public QuizEncuesta() {
    }

    public QuizEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(int idEditor) {
        this.idEditor = idEditor;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizEncuesta)) {
            return false;
        }
        QuizEncuesta other = (QuizEncuesta) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaEncuestaEspecialidad[ idEncuesta=" + idEncuesta + " ]";
    }
    
}
