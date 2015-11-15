/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sva_informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaInforme.findAll", query = "SELECT s FROM SvaInforme s"),
    @NamedQuery(name = "SvaInforme.findByIdAutoinfo", query = "SELECT s FROM SvaInforme s WHERE s.idAutoinfo = :idAutoinfo"),
    @NamedQuery(name = "SvaInforme.findByIdAutoevaluacion", query = "SELECT s FROM SvaInforme s WHERE s.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SvaInforme.findByIdVersion", query = "SELECT s FROM SvaInforme s WHERE s.idVersion = :idVersion"),
    @NamedQuery(name = "SvaInforme.findByIdInstitucion", query = "SELECT s FROM SvaInforme s WHERE s.idInstitucion = :idInstitucion"),
    @NamedQuery(name = "SvaInforme.findByIdUbig", query = "SELECT s FROM SvaInforme s WHERE s.idUbig = :idUbig"),
    @NamedQuery(name = "SvaInforme.findByFechaPresentacion", query = "SELECT s FROM SvaInforme s WHERE s.fechaPresentacion = :fechaPresentacion"),
    @NamedQuery(name = "SvaInforme.findByIdAutoridad", query = "SELECT s FROM SvaInforme s WHERE s.idAutoridad = :idAutoridad"),
    @NamedQuery(name = "SvaInforme.findByIdDtra", query = "SELECT s FROM SvaInforme s WHERE s.idDtra = :idDtra"),
    @NamedQuery(name = "SvaInforme.findByNroMatriculados", query = "SELECT s FROM SvaInforme s WHERE s.nroMatriculados = :nroMatriculados"),
    @NamedQuery(name = "SvaInforme.findByNroPromociones", query = "SELECT s FROM SvaInforme s WHERE s.nroPromociones = :nroPromociones"),
    @NamedQuery(name = "SvaInforme.findByNroGraduados", query = "SELECT s FROM SvaInforme s WHERE s.nroGraduados = :nroGraduados"),
    @NamedQuery(name = "SvaInforme.findByNroTitulados", query = "SELECT s FROM SvaInforme s WHERE s.nroTitulados = :nroTitulados"),
    @NamedQuery(name = "SvaInforme.findByGrado", query = "SELECT s FROM SvaInforme s WHERE s.grado = :grado"),
    @NamedQuery(name = "SvaInforme.findByTitulo", query = "SELECT s FROM SvaInforme s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "SvaInforme.findByFechaReg", query = "SELECT s FROM SvaInforme s WHERE s.fechaReg = :fechaReg"),
    @NamedQuery(name = "SvaInforme.findByEstado", query = "SELECT s FROM SvaInforme s WHERE s.estado = :estado")})
public class SvaInforme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_autoinfo")
    private Integer idAutoinfo;
    @Basic(optional = false)
    @Column(name = "id_autoevaluacion")
    private int idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_version")
    private int idVersion;
    @Basic(optional = false)
    @Column(name = "id_institucion")
    private int idInstitucion;
    @Basic(optional = false)
    @Column(name = "id_ubig")
    private int idUbig;
    @Column(name = "fecha_presentacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPresentacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "resumen_ejecutivo")
    private String resumenEjecutivo;
    @Basic(optional = false)
    @Lob
    @Column(name = "introduccion")
    private String introduccion;
    @Basic(optional = false)
    @Lob
    @Column(name = "carrera_descripcion")
    private String carreraDescripcion;
    @Basic(optional = false)
    @Lob
    @Column(name = "carrera_historia")
    private String carreraHistoria;
    @Basic(optional = false)
    @Lob
    @Column(name = "mision")
    private String mision;
    @Basic(optional = false)
    @Lob
    @Column(name = "vision")
    private String vision;
    @Basic(optional = false)
    @Column(name = "id_autoridad")
    private int idAutoridad;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private int idDtra;
    @Basic(optional = false)
    @Column(name = "nro_matriculados")
    private int nroMatriculados;
    @Basic(optional = false)
    @Column(name = "nro_promociones")
    private int nroPromociones;
    @Basic(optional = false)
    @Column(name = "nro_graduados")
    private int nroGraduados;
    @Basic(optional = false)
    @Column(name = "nro_titulados")
    private int nroTitulados;
    @Basic(optional = false)
    @Column(name = "grado")
    private String grado;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;

    public SvaInforme() {
    }

    public SvaInforme(Integer idAutoinfo) {
        this.idAutoinfo = idAutoinfo;
    }

    public SvaInforme(Integer idAutoinfo, int idAutoevaluacion, int idVersion, int idInstitucion, int idUbig, String resumenEjecutivo, String introduccion, String carreraDescripcion, String carreraHistoria, String mision, String vision, int idAutoridad, int idDtra, int nroMatriculados, int nroPromociones, int nroGraduados, int nroTitulados, String grado, String titulo, Date fechaReg, short estado) {
        this.idAutoinfo = idAutoinfo;
        this.idAutoevaluacion = idAutoevaluacion;
        this.idVersion = idVersion;
        this.idInstitucion = idInstitucion;
        this.idUbig = idUbig;
        this.resumenEjecutivo = resumenEjecutivo;
        this.introduccion = introduccion;
        this.carreraDescripcion = carreraDescripcion;
        this.carreraHistoria = carreraHistoria;
        this.mision = mision;
        this.vision = vision;
        this.idAutoridad = idAutoridad;
        this.idDtra = idDtra;
        this.nroMatriculados = nroMatriculados;
        this.nroPromociones = nroPromociones;
        this.nroGraduados = nroGraduados;
        this.nroTitulados = nroTitulados;
        this.grado = grado;
        this.titulo = titulo;
        this.fechaReg = fechaReg;
        this.estado = estado;
    }

    public Integer getIdAutoinfo() {
        return idAutoinfo;
    }

    public void setIdAutoinfo(Integer idAutoinfo) {
        this.idAutoinfo = idAutoinfo;
    }

    public int getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(int idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public int getIdUbig() {
        return idUbig;
    }

    public void setIdUbig(int idUbig) {
        this.idUbig = idUbig;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public String getResumenEjecutivo() {
        return resumenEjecutivo;
    }

    public void setResumenEjecutivo(String resumenEjecutivo) {
        this.resumenEjecutivo = resumenEjecutivo;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getCarreraDescripcion() {
        return carreraDescripcion;
    }

    public void setCarreraDescripcion(String carreraDescripcion) {
        this.carreraDescripcion = carreraDescripcion;
    }

    public String getCarreraHistoria() {
        return carreraHistoria;
    }

    public void setCarreraHistoria(String carreraHistoria) {
        this.carreraHistoria = carreraHistoria;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public int getIdAutoridad() {
        return idAutoridad;
    }

    public void setIdAutoridad(int idAutoridad) {
        this.idAutoridad = idAutoridad;
    }

    public int getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(int idDtra) {
        this.idDtra = idDtra;
    }

    public int getNroMatriculados() {
        return nroMatriculados;
    }

    public void setNroMatriculados(int nroMatriculados) {
        this.nroMatriculados = nroMatriculados;
    }

    public int getNroPromociones() {
        return nroPromociones;
    }

    public void setNroPromociones(int nroPromociones) {
        this.nroPromociones = nroPromociones;
    }

    public int getNroGraduados() {
        return nroGraduados;
    }

    public void setNroGraduados(int nroGraduados) {
        this.nroGraduados = nroGraduados;
    }

    public int getNroTitulados() {
        return nroTitulados;
    }

    public void setNroTitulados(int nroTitulados) {
        this.nroTitulados = nroTitulados;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutoinfo != null ? idAutoinfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaInforme)) {
            return false;
        }
        SvaInforme other = (SvaInforme) object;
        if ((this.idAutoinfo == null && other.idAutoinfo != null) || (this.idAutoinfo != null && !this.idAutoinfo.equals(other.idAutoinfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaInforme[ idAutoinfo=" + idAutoinfo + " ]";
    }
    
}
