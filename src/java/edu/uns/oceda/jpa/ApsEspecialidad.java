/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "aps_especialidad")
public class ApsEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;
    @Column(name = "cod_especialidad")
    private String codEspecialidad;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "grado")
    private String grado;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "id_resolucion")
    private Integer idResolucion;
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    @Column(name = "min_alumno")
    private Integer minAlumno;
    @Column(name = "creditos")
    private Integer creditos;
    @Column(name = "ciclos")
    private Integer ciclos;
    @Column(name = "cod_old")
    private String codOld;
    @Column(name = "abr")
    private String abr;
    @Column(name = "abr1")
    private String abr1;
    @JoinTable(name = "aps_especialidad_pre", joinColumns = {
        @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")}, inverseJoinColumns = {
        @JoinColumn(name = "id_escuela", referencedColumnName = "id_escuela")})
    @ManyToMany
    private List<ApsEscuela> apsEscuelaList;
    @ManyToMany(mappedBy = "apsEspecialidadList")
    private List<ApsAreaPost> apsAreaPostList;
    @ManyToMany(mappedBy = "apsEspecialidadList")
    private List<ApsAreaElear> apsAreaElearList;
    @ManyToMany(mappedBy = "apsEspecialidadList")
    private List<ApsEscuelaEfcap> apsEscuelaEfcapList;
    @JoinColumn(name = "id_ambito", referencedColumnName = "id_ambito")
    @ManyToOne
    private ApsAmbitoAcad idAmbito;

    public ApsEspecialidad() {
    }

    public ApsEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(String codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdResolucion() {
        return idResolucion;
    }

    public void setIdResolucion(Integer idResolucion) {
        this.idResolucion = idResolucion;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Integer getMinAlumno() {
        return minAlumno;
    }

    public void setMinAlumno(Integer minAlumno) {
        this.minAlumno = minAlumno;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCiclos() {
        return ciclos;
    }

    public void setCiclos(Integer ciclos) {
        this.ciclos = ciclos;
    }

    public String getCodOld() {
        return codOld;
    }

    public void setCodOld(String codOld) {
        this.codOld = codOld;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getAbr1() {
        return abr1;
    }

    public void setAbr1(String abr1) {
        this.abr1 = abr1;
    }

    @XmlTransient
    public List<ApsEscuela> getApsEscuelaList() {
        return apsEscuelaList;
    }

    public void setApsEscuelaList(List<ApsEscuela> apsEscuelaList) {
        this.apsEscuelaList = apsEscuelaList;
    }

    @XmlTransient
    public List<ApsAreaPost> getApsAreaPostList() {
        return apsAreaPostList;
    }

    public void setApsAreaPostList(List<ApsAreaPost> apsAreaPostList) {
        this.apsAreaPostList = apsAreaPostList;
    }

    @XmlTransient
    public List<ApsAreaElear> getApsAreaElearList() {
        return apsAreaElearList;
    }

    public void setApsAreaElearList(List<ApsAreaElear> apsAreaElearList) {
        this.apsAreaElearList = apsAreaElearList;
    }

    @XmlTransient
    public List<ApsEscuelaEfcap> getApsEscuelaEfcapList() {
        return apsEscuelaEfcapList;
    }

    public void setApsEscuelaEfcapList(List<ApsEscuelaEfcap> apsEscuelaEfcapList) {
        this.apsEscuelaEfcapList = apsEscuelaEfcapList;
    }

    public ApsAmbitoAcad getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(ApsAmbitoAcad idAmbito) {
        this.idAmbito = idAmbito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsEspecialidad)) {
            return false;
        }
        ApsEspecialidad other = (ApsEspecialidad) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsEspecialidad[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
