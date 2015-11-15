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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sva_tipo_participante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaTipoParticipante.findAll", query = "SELECT s FROM SvaTipoParticipante s"),
    @NamedQuery(name = "SvaTipoParticipante.findByIdTipo", query = "SELECT s FROM SvaTipoParticipante s WHERE s.idTipo = :idTipo"),
    @NamedQuery(name = "SvaTipoParticipante.findByTipoParticipante", query = "SELECT s FROM SvaTipoParticipante s WHERE s.tipoParticipante = :tipoParticipante"),
    @NamedQuery(name = "SvaTipoParticipante.findByBase", query = "SELECT s FROM SvaTipoParticipante s WHERE s.base = :base"),
    @NamedQuery(name = "SvaTipoParticipante.findByIdTipart", query = "SELECT s FROM SvaTipoParticipante s WHERE s.idTipart = :idTipart"),
    @NamedQuery(name = "SvaTipoParticipante.findByNumero", query = "SELECT s FROM SvaTipoParticipante s WHERE s.numero = :numero")})
public class SvaTipoParticipante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private String idTipo;
    @Basic(optional = false)
    @Column(name = "tipo_participante")
    private String tipoParticipante;
    @Basic(optional = false)
    @Column(name = "base")
    private boolean base;
    @Column(name = "id_tipart")
    private String idTipart;
    @Column(name = "numero")
    private Integer numero;

    public SvaTipoParticipante() {
    }

    public SvaTipoParticipante(String idTipo) {
        this.idTipo = idTipo;
    }

    public SvaTipoParticipante(String idTipo, String tipoParticipante, boolean base) {
        this.idTipo = idTipo;
        this.tipoParticipante = tipoParticipante;
        this.base = base;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(String tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public boolean getBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    public String getIdTipart() {
        return idTipart;
    }

    public void setIdTipart(String idTipart) {
        this.idTipart = idTipart;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SvaTipoParticipante)) {
            return false;
        }
        SvaTipoParticipante other = (SvaTipoParticipante) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaTipoParticipante[ idTipo=" + idTipo + " ]";
    }
    
}
