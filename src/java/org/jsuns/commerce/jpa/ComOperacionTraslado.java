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

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_operacion_traslado")
@NamedQueries({
    @NamedQuery(name = "ComOperacionTraslado.findAll", query = "SELECT c FROM ComOperacionTraslado c")})
public class ComOperacionTraslado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fuente_financiamiento")
    private int idFuenteFinanciamiento;
    @Column(name = "id_programa")
    private Integer idPrograma;
    @Column(name = "id_pecosa")
    private Integer idPecosa;
    @Column(name = "id_solicitante")
    private Integer idSolicitante;
    @Column(name = "id_dir_recibe")
    private Short idDirRecibe;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date fechaReg;
    @Column(name = "id_creador")
    private Integer idCreador;
    @Column(name = "id_estado")
    private Integer idEstado;

    public ComOperacionTraslado() {
    }

    public ComOperacionTraslado(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public ComOperacionTraslado(Integer idOperacion, int idFuenteFinanciamiento) {
        this.idOperacion = idOperacion;
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdFuenteFinanciamiento() {
        return idFuenteFinanciamiento;
    }

    public void setIdFuenteFinanciamiento(int idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Integer getIdPecosa() {
        return idPecosa;
    }

    public void setIdPecosa(Integer idPecosa) {
        this.idPecosa = idPecosa;
    }

    public Integer getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Short getIdDirRecibe() {
        return idDirRecibe;
    }

    public void setIdDirRecibe(Short idDirRecibe) {
        this.idDirRecibe = idDirRecibe;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Integer getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(Integer idCreador) {
        this.idCreador = idCreador;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
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
        if (!(object instanceof ComOperacionTraslado)) {
            return false;
        }
        ComOperacionTraslado other = (ComOperacionTraslado) object;
        if ((this.idOperacion == null && other.idOperacion != null) || (this.idOperacion != null && !this.idOperacion.equals(other.idOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacionTraslado[ idOperacion=" + idOperacion + " ]";
    }
    
}
