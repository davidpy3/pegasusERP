/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

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
@Table(name = "com_operacion")
@NamedQueries({
    @NamedQuery(name = "ComOperacion.findAll", query = "SELECT c FROM ComOperacion c")})
public class ComOperacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_tipo_operacion")
    private String idTipoOperacion;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "id_terminal")
    private Integer idTerminal;
    @Column(name = "correlativo")
    private Integer correlativo;
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "id_dir_update")
    private Integer idDirUpdate;
    @Column(name = "id_dep_destino")
    private Integer idDepDestino;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "documento")
    private String documento;
    @Column(name = "id_modalidad")
    private Character idModalidad;

    public ComOperacion() {
    }

    public ComOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ComOperacion(Integer idOperacion, String idTipoOperacion, Date fechaReg, String estado) {
        this.idOperacion = idOperacion;
        this.idTipoOperacion = idTipoOperacion;
        this.fechaReg = fechaReg;
        this.estado = estado;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(String idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdDirUpdate() {
        return idDirUpdate;
    }

    public void setIdDirUpdate(Integer idDirUpdate) {
        this.idDirUpdate = idDirUpdate;
    }

    public Integer getIdDepDestino() {
        return idDepDestino;
    }

    public void setIdDepDestino(Integer idDepDestino) {
        this.idDepDestino = idDepDestino;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Character getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Character idModalidad) {
        this.idModalidad = idModalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacion != null ? idOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOperacion)) {
            return false;
        }
        ComOperacion other = (ComOperacion) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacion[ idOperacion=" + idOperacion + " ]";
    }
    
}
