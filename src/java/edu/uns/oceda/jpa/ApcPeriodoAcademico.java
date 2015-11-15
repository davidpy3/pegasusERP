/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "apc_periodo_academico")
@NamedQueries({
    @NamedQuery(name = "ApcPeriodoAcademico.findAll", query = "SELECT a FROM ApcPeriodoAcademico a")})
public class ApcPeriodoAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acper")
    private Integer idAcper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ambito")
    private short idAmbito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_anio")
    private short codAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sec")
    private short codSec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_acper")
    private String codAcper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cfg")
    private Character fechaCfg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aperturado")
    private boolean aperturado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finalizado")
    private boolean finalizado;
    @Column(name = "contexto")
    private Character contexto;
    @Size(max = 254)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_matricula")
    private boolean periodoMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_notas")
    private boolean periodoNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_web")
    private boolean periodoWeb;
    @Column(name = "periodo_cns_web")
    private Boolean periodoCnsWeb;

    public ApcPeriodoAcademico() {
    }

    public ApcPeriodoAcademico(Integer idAcper) {
        this.idAcper = idAcper;
    }

    public ApcPeriodoAcademico(Integer idAcper, short idAmbito, short codAnio, short codSec, String codAcper, String descripcion, Character fechaCfg, Date fechaInicio, Date fechaTermino, boolean aperturado, boolean finalizado, boolean periodoMatricula, boolean periodoNotas, boolean periodoWeb) {
        this.idAcper = idAcper;
        this.idAmbito = idAmbito;
        this.codAnio = codAnio;
        this.codSec = codSec;
        this.codAcper = codAcper;
        this.descripcion = descripcion;
        this.fechaCfg = fechaCfg;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.aperturado = aperturado;
        this.finalizado = finalizado;
        this.periodoMatricula = periodoMatricula;
        this.periodoNotas = periodoNotas;
        this.periodoWeb = periodoWeb;
    }

    public Integer getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(Integer idAcper) {
        this.idAcper = idAcper;
    }

    public short getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(short idAmbito) {
        this.idAmbito = idAmbito;
    }

    public short getCodAnio() {
        return codAnio;
    }

    public void setCodAnio(short codAnio) {
        this.codAnio = codAnio;
    }

    public short getCodSec() {
        return codSec;
    }

    public void setCodSec(short codSec) {
        this.codSec = codSec;
    }

    public String getCodAcper() {
        return codAcper;
    }

    public void setCodAcper(String codAcper) {
        this.codAcper = codAcper;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getFechaCfg() {
        return fechaCfg;
    }

    public void setFechaCfg(Character fechaCfg) {
        this.fechaCfg = fechaCfg;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public boolean getAperturado() {
        return aperturado;
    }

    public void setAperturado(boolean aperturado) {
        this.aperturado = aperturado;
    }

    public boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Character getContexto() {
        return contexto;
    }

    public void setContexto(Character contexto) {
        this.contexto = contexto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean getPeriodoMatricula() {
        return periodoMatricula;
    }

    public void setPeriodoMatricula(boolean periodoMatricula) {
        this.periodoMatricula = periodoMatricula;
    }

    public boolean getPeriodoNotas() {
        return periodoNotas;
    }

    public void setPeriodoNotas(boolean periodoNotas) {
        this.periodoNotas = periodoNotas;
    }

    public boolean getPeriodoWeb() {
        return periodoWeb;
    }

    public void setPeriodoWeb(boolean periodoWeb) {
        this.periodoWeb = periodoWeb;
    }

    public Boolean getPeriodoCnsWeb() {
        return periodoCnsWeb;
    }

    public void setPeriodoCnsWeb(Boolean periodoCnsWeb) {
        this.periodoCnsWeb = periodoCnsWeb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcper != null ? idAcper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApcPeriodoAcademico)) {
            return false;
        }
        ApcPeriodoAcademico other = (ApcPeriodoAcademico) object;
        if ((this.idAcper == null && other.idAcper != null) || (this.idAcper != null && !this.idAcper.equals(other.idAcper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApcPeriodoAcademico[ idAcper=" + idAcper + " ]";
    }
    
}
