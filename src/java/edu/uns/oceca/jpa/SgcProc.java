/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_proc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcProc.findAll", query = "SELECT s FROM SgcProc s"),
    @NamedQuery(name = "SgcProc.findByIdProc", query = "SELECT s FROM SgcProc s WHERE s.idProc = :idProc"),
    @NamedQuery(name = "SgcProc.findByIdTipoproc", query = "SELECT s FROM SgcProc s WHERE s.idTipoproc = :idTipoproc"),
    @NamedQuery(name = "SgcProc.findByCodigo", query = "SELECT s FROM SgcProc s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "SgcProc.findByProceso", query = "SELECT s FROM SgcProc s WHERE s.proceso = :proceso"),
    @NamedQuery(name = "SgcProc.findByIdDoc", query = "SELECT s FROM SgcProc s WHERE s.idDoc = :idDoc"),
    @NamedQuery(name = "SgcProc.findByIdDir", query = "SELECT s FROM SgcProc s WHERE s.idDir = :idDir"),
    @NamedQuery(name = "SgcProc.findByIdDirDoc", query = "SELECT s FROM SgcProc s WHERE s.idDirDoc = :idDirDoc"),
    @NamedQuery(name = "SgcProc.findByIdDepAdministra", query = "SELECT s FROM SgcProc s WHERE s.idDepAdministra = :idDepAdministra"),
    @NamedQuery(name = "SgcProc.findByIdDep", query = "SELECT s FROM SgcProc s WHERE s.idDep = :idDep"),
    @NamedQuery(name = "SgcProc.findByIdCap", query = "SELECT s FROM SgcProc s WHERE s.idCap = :idCap"),
    @NamedQuery(name = "SgcProc.findByDepResponsable", query = "SELECT s FROM SgcProc s WHERE s.depResponsable = :depResponsable"),
    @NamedQuery(name = "SgcProc.findByCreador", query = "SELECT s FROM SgcProc s WHERE s.creador = :creador"),
    @NamedQuery(name = "SgcProc.findByClase", query = "SELECT s FROM SgcProc s WHERE s.clase = :clase"),
    @NamedQuery(name = "SgcProc.findByNivel", query = "SELECT s FROM SgcProc s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "SgcProc.findByEnlace", query = "SELECT s FROM SgcProc s WHERE s.enlace = :enlace")})
public class SgcProc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_proc")
    private Integer idProc;
    @Column(name = "id_tipoproc")
    private Integer idTipoproc;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "proceso")
    private String proceso;
    @Column(name = "id_doc")
    private Integer idDoc;
    @Column(name = "id_dir")
    private Integer idDir;
    @Column(name = "id_dir_doc")
    private Integer idDirDoc;
    @Column(name = "id_dep_administra")
    private Integer idDepAdministra;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "id_cap")
    private Integer idCap;
    @Column(name = "dep_responsable")
    private String depResponsable;
    @Lob
    @Column(name = "meta")
    private String meta;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "base_legal")
    private String baseLegal;
    @Lob
    @Column(name = "requisitos")
    private String requisitos;
    @Lob
    @Column(name = "disposicion")
    private String disposicion;
    @Column(name = "creador")
    private Integer creador;
    @Lob
    @Column(name = "responsabilidad")
    private String responsabilidad;
    @Lob
    @Column(name = "otras_dep")
    private String otrasDep;
    @Lob
    @Column(name = "documentos_generados")
    private String documentosGenerados;
    @Column(name = "clase")
    private Short clase;
    @Column(name = "nivel")
    private Short nivel;
    @Column(name = "enlace")
    private Integer enlace;

    public SgcProc() {
    }

    public SgcProc(Integer idProc) {
        this.idProc = idProc;
    }

    public Integer getIdProc() {
        return idProc;
    }

    public void setIdProc(Integer idProc) {
        this.idProc = idProc;
    }

    public Integer getIdTipoproc() {
        return idTipoproc;
    }

    public void setIdTipoproc(Integer idTipoproc) {
        this.idTipoproc = idTipoproc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public Integer getIdDirDoc() {
        return idDirDoc;
    }

    public void setIdDirDoc(Integer idDirDoc) {
        this.idDirDoc = idDirDoc;
    }

    public Integer getIdDepAdministra() {
        return idDepAdministra;
    }

    public void setIdDepAdministra(Integer idDepAdministra) {
        this.idDepAdministra = idDepAdministra;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdCap() {
        return idCap;
    }

    public void setIdCap(Integer idCap) {
        this.idCap = idCap;
    }

    public String getDepResponsable() {
        return depResponsable;
    }

    public void setDepResponsable(String depResponsable) {
        this.depResponsable = depResponsable;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(String disposicion) {
        this.disposicion = disposicion;
    }

    public Integer getCreador() {
        return creador;
    }

    public void setCreador(Integer creador) {
        this.creador = creador;
    }

    public String getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(String responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public String getOtrasDep() {
        return otrasDep;
    }

    public void setOtrasDep(String otrasDep) {
        this.otrasDep = otrasDep;
    }

    public String getDocumentosGenerados() {
        return documentosGenerados;
    }

    public void setDocumentosGenerados(String documentosGenerados) {
        this.documentosGenerados = documentosGenerados;
    }

    public Short getClase() {
        return clase;
    }

    public void setClase(Short clase) {
        this.clase = clase;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public Integer getEnlace() {
        return enlace;
    }

    public void setEnlace(Integer enlace) {
        this.enlace = enlace;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProc != null ? idProc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcProc)) {
            return false;
        }
        SgcProc other = (SgcProc) object;
        if ((this.idProc == null && other.idProc != null) || (this.idProc != null && !this.idProc.equals(other.idProc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcProc[ idProc=" + idProc + " ]";
    }
    
}
