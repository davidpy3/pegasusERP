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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jsuns.ocid.DrtPersonaNatural;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "fxa_estudiante")
public class FxaEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_acexp")
    private Integer idAcexp;
    @Basic(optional = false)
    @Column(name = "codigo_estudiante")
    private String codigoEstudiante;
    @Basic(optional = false)
    @Column(name = "prom_seccion")
    private Character promSeccion;
    @Basic(optional = false)
    @Column(name = "ciclo_numero")
    private short cicloNumero;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "anulado")
    private boolean anulado;
    @Column(name = "situacion")
    private String situacion;
    @Basic(optional = false)
    @Column(name = "dateinsert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinsert;
    @Column(name = "migrado")
    private Boolean migrado;
    @Column(name = "promocion_id")
    private Short promocionId;
    @Column(name = "pass_enc")
    private String passEnc;
    @Column(name = "pass_verifica")
    private String passVerifica;
    @JoinColumn(name = "id_ambito", referencedColumnName = "id_ambito")
    @ManyToOne(optional = false)
    private ApsAmbitoAcad idAmbito;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne(optional = false)
    private ApsEspecialidad especialidad;

    @JoinColumn(name = "id_direstudiante", referencedColumnName = "id_dir")
    @ManyToOne
    private DrtPersonaNatural personaNatural;
    @JoinColumn(name = "cod_niv_acad", referencedColumnName = "cod_niv_acad")
    @ManyToOne
    private FxaNivelAcad nivelAcademico;
    @JoinColumn(name = "cod_sit_acad", referencedColumnName = "cod_sit_acad")
    @ManyToOne
    private FxaSituacionAcad situacionAcademico;

    public FxaNivelAcad getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(FxaNivelAcad NivelAcademico) {
        this.nivelAcademico = NivelAcademico;
    }

    public FxaSituacionAcad getSituacionAcademico() {
        return situacionAcademico;
    }

    public void setSituacionAcademico(FxaSituacionAcad SituacionAcademico) {
        this.situacionAcademico = SituacionAcademico;
    }
    

    public DrtPersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(DrtPersonaNatural PersonaNatural) {
        this.personaNatural = PersonaNatural;
    }

    
    public FxaEstudiante() {
    }

    public FxaEstudiante(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public FxaEstudiante(Integer idAcexp, String codigoEstudiante, Character promSeccion, short cicloNumero, boolean activo, boolean anulado, Date dateinsert) {
        this.idAcexp = idAcexp;
        this.codigoEstudiante = codigoEstudiante;
        this.promSeccion = promSeccion;
        this.cicloNumero = cicloNumero;
        this.activo = activo;
        this.anulado = anulado;
        this.dateinsert = dateinsert;
    }

    public Integer getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Character getPromSeccion() {
        return promSeccion;
    }

    public void setPromSeccion(Character promSeccion) {
        this.promSeccion = promSeccion;
    }

    public short getCicloNumero() {
        return cicloNumero;
    }

    public void setCicloNumero(short cicloNumero) {
        this.cicloNumero = cicloNumero;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public void setDateinsert(Date dateinsert) {
        this.dateinsert = dateinsert;
    }

    public Boolean getMigrado() {
        return migrado;
    }

    public void setMigrado(Boolean migrado) {
        this.migrado = migrado;
    }

    public Short getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Short promocionId) {
        this.promocionId = promocionId;
    }

    public String getPassEnc() {
        return passEnc;
    }

    public void setPassEnc(String passEnc) {
        this.passEnc = passEnc;
    }

    public String getPassVerifica() {
        return passVerifica;
    }

    public void setPassVerifica(String passVerifica) {
        this.passVerifica = passVerifica;
    }

    public ApsAmbitoAcad getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(ApsAmbitoAcad idAmbito) {
        this.idAmbito = idAmbito;
    }

    public ApsEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(ApsEspecialidad especialidad) {
        this.especialidad =especialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcexp != null ? idAcexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxaEstudiante)) {
            return false;
        }
        FxaEstudiante other = (FxaEstudiante) object;
        if ((this.idAcexp == null && other.idAcexp != null) || (this.idAcexp != null && !this.idAcexp.equals(other.idAcexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.model.FxaEstudiante[ idAcexp=" + idAcexp + " ]";
    }
    
}
