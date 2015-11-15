/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "esc_labordependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscLabordependencias.findAll", query = "SELECT e FROM EscLabordependencias e"),
    @NamedQuery(name = "EscLabordependencias.findByIdPercl", query = "SELECT e FROM EscLabordependencias e WHERE e.escLabordependenciasPK.idPercl = :idPercl"),
    @NamedQuery(name = "EscLabordependencias.findByLabor", query = "SELECT e FROM EscLabordependencias e WHERE e.escLabordependenciasPK.labor = :labor"),
    @NamedQuery(name = "EscLabordependencias.findByIdDep", query = "SELECT e FROM EscLabordependencias e WHERE e.escLabordependenciasPK.idDep = :idDep"),
    @NamedQuery(name = "EscLabordependencias.findByFecIni", query = "SELECT e FROM EscLabordependencias e WHERE e.escLabordependenciasPK.fecIni = :fecIni"),
    @NamedQuery(name = "EscLabordependencias.findByFecFin", query = "SELECT e FROM EscLabordependencias e WHERE e.fecFin = :fecFin"),
    @NamedQuery(name = "EscLabordependencias.findByActivo", query = "SELECT e FROM EscLabordependencias e WHERE e.activo = :activo"),
    @NamedQuery(name = "EscLabordependencias.findByJefe", query = "SELECT e FROM EscLabordependencias e WHERE e.jefe = :jefe"),
    @NamedQuery(name = "EscLabordependencias.findByCodDtra", query = "SELECT e FROM EscLabordependencias e WHERE e.codDtra = :codDtra"),
    @NamedQuery(name = "EscLabordependencias.findByDescripcion", query = "SELECT e FROM EscLabordependencias e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EscLabordependencias.findByMigrado", query = "SELECT e FROM EscLabordependencias e WHERE e.migrado = :migrado")})
public class EscLabordependencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscLabordependenciasPK escLabordependenciasPK;
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "jefe")
    private boolean jefe;
    @Column(name = "cod_dtra")
    private String codDtra;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "migrado")
    private boolean migrado;
    @JoinColumn(name = "id_percl", referencedColumnName = "id_percl", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EscCarreraLaboral escCarreraLaboral;

    public EscLabordependencias() {
    }

    public EscLabordependencias(EscLabordependenciasPK escLabordependenciasPK) {
        this.escLabordependenciasPK = escLabordependenciasPK;
    }

    public EscLabordependencias(EscLabordependenciasPK escLabordependenciasPK, boolean activo, boolean jefe, boolean migrado) {
        this.escLabordependenciasPK = escLabordependenciasPK;
        this.activo = activo;
        this.jefe = jefe;
        this.migrado = migrado;
    }

    public EscLabordependencias(int idPercl, String labor, int idDep, Date fecIni) {
        this.escLabordependenciasPK = new EscLabordependenciasPK(idPercl, labor, idDep, fecIni);
    }

    public EscLabordependenciasPK getEscLabordependenciasPK() {
        return escLabordependenciasPK;
    }

    public void setEscLabordependenciasPK(EscLabordependenciasPK escLabordependenciasPK) {
        this.escLabordependenciasPK = escLabordependenciasPK;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getJefe() {
        return jefe;
    }

    public void setJefe(boolean jefe) {
        this.jefe = jefe;
    }

    public String getCodDtra() {
        return codDtra;
    }

    public void setCodDtra(String codDtra) {
        this.codDtra = codDtra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getMigrado() {
        return migrado;
    }

    public void setMigrado(boolean migrado) {
        this.migrado = migrado;
    }

    public EscCarreraLaboral getEscCarreraLaboral() {
        return escCarreraLaboral;
    }

    public void setEscCarreraLaboral(EscCarreraLaboral escCarreraLaboral) {
        this.escCarreraLaboral = escCarreraLaboral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escLabordependenciasPK != null ? escLabordependenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscLabordependencias)) {
            return false;
        }
        EscLabordependencias other = (EscLabordependencias) object;
        if ((this.escLabordependenciasPK == null && other.escLabordependenciasPK != null) || (this.escLabordependenciasPK != null && !this.escLabordependenciasPK.equals(other.escLabordependenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscLabordependencias[ escLabordependenciasPK=" + escLabordependenciasPK + " ]";
    }
    
}
