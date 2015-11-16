package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.jsuns.ocid.DrtPersonaNatural;

@Entity
@Table(name = "quiz_encuesta_participacion")
public class QuizEncuestaParticipacion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_participacion")
    private Integer idParticipacion;

    @JoinColumn(name = "id_encuesta", referencedColumnName = "id_encuesta")
    @ManyToOne
    private QuizEncuesta quizEncuesta;

    public QuizEncuesta getQuizEncuesta() {
        return quizEncuesta;
    }

    public void setQuizEncuesta(QuizEncuesta quizEncuesta) {
        this.quizEncuesta = quizEncuesta;
    }
    
    @Basic(optional = false)
    @Column(name = "id_objeto")
    private int idObjeto;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne
    private DrtPersonaNatural personaNatural;
    @Column(name = "flag")
    private char flag;
    @Column(name = "flags")
    private String flags;
    @Column(name = "delta")
    private Integer delta;
    @Basic(optional = false)
    @Column(name = "cerrado")
    private boolean cerrado;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    
    @Transient
    private double progreso;

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }

    public QuizEncuestaParticipacion() {
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public DrtPersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(DrtPersonaNatural personaNatural) {
        this.personaNatural = personaNatural;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaInicio) {
        this.fechaIni = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaCierre) {
        this.fechaFin = fechaCierre;
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
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizEncuestaParticipacion)) {
            return false;
        }
        QuizEncuestaParticipacion other = (QuizEncuestaParticipacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null) || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacion[ idParticipacion=" + idParticipacion + " ]";
    }
}
