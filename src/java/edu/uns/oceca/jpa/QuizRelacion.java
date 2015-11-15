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

/**
 *
 * @author USER
 */
@Entity
@Table(name = "quiz_relacion")
@NamedQueries({
    @NamedQuery(name = "QuizRelacion.findAll", query = "SELECT q FROM QuizRelacion q"),
    @NamedQuery(name = "QuizRelacion.findByIdRelacion", query = "SELECT q FROM QuizRelacion q WHERE q.idRelacion = :idRelacion"),
    @NamedQuery(name = "QuizRelacion.findByIdAfectante", query = "SELECT q FROM QuizRelacion q WHERE q.idAfectante = :idAfectante"),
    @NamedQuery(name = "QuizRelacion.findByIdItemAfectante", query = "SELECT q FROM QuizRelacion q WHERE q.idItemAfectante = :idItemAfectante"),
    @NamedQuery(name = "QuizRelacion.findByIdAfectado", query = "SELECT q FROM QuizRelacion q WHERE q.idAfectado = :idAfectado"),
    @NamedQuery(name = "QuizRelacion.findByIdItemAfectado", query = "SELECT q FROM QuizRelacion q WHERE q.idItemAfectado = :idItemAfectado"),
    @NamedQuery(name = "QuizRelacion.findByComparador", query = "SELECT q FROM QuizRelacion q WHERE q.comparador = :comparador"),
    @NamedQuery(name = "QuizRelacion.findByIdOpcion", query = "SELECT q FROM QuizRelacion q WHERE q.idOpcion = :idOpcion"),
    @NamedQuery(name = "QuizRelacion.findByActivo", query = "SELECT q FROM QuizRelacion q WHERE q.activo = :activo"),
    @NamedQuery(name = "QuizRelacion.findByTotal", query = "SELECT q FROM QuizRelacion q WHERE q.total = :total")})
public class QuizRelacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_relacion")
    private Integer idRelacion;
    @Basic(optional = false)
    @Column(name = "id_afectante")
    private int idAfectante;
    @Column(name = "id_item_afectante")
    private Integer idItemAfectante;
    @Basic(optional = false)
    @Column(name = "id_afectado")
    private int idAfectado;
    @Column(name = "id_item_afectado")
    private Integer idItemAfectado;
    @Basic(optional = false)
    @Column(name = "comparador")
    private Character comparador;
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private int idOpcion;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "total")
    private boolean total;

    public QuizRelacion(){
        
    }

    public QuizRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public QuizRelacion(Integer idRelacion, int idAfectante, int idAfectado, Character comparador, int idOpcion, boolean activo, boolean total) {
        this.idRelacion = idRelacion;
        this.idAfectante = idAfectante;
        this.idAfectado = idAfectado;
        this.comparador = comparador;
        this.idOpcion = idOpcion;
        this.activo = activo;
        this.total = total;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public int getIdAfectante() {
        return idAfectante;
    }

    public void setIdAfectante(int idAfectante) {
        this.idAfectante = idAfectante;
    }

    public Integer getIdItemAfectante() {
        return idItemAfectante;
    }

    public void setIdItemAfectante(Integer idItemAfectante) {
        this.idItemAfectante = idItemAfectante;
    }

    public int getIdAfectado() {
        return idAfectado;
    }

    public void setIdAfectado(int idAfectado) {
        this.idAfectado = idAfectado;
    }

    public Integer getIdItemAfectado() {
        return idItemAfectado;
    }

    public void setIdItemAfectado(Integer idItemAfectado) {
        this.idItemAfectado = idItemAfectado;
    }

    public Character getComparador() {
        return comparador;
    }

    public void setComparador(Character comparador) {
        this.comparador = comparador;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacion != null ? idRelacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizRelacion)) {
            return false;
        }
        QuizRelacion other = (QuizRelacion) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.sgc.encuesta.QuizRelacion[ idRelacion=" + idRelacion + " ]";
    }
    
}
