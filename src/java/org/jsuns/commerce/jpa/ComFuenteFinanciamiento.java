/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_fuente_financiamiento")
@NamedQueries({
    @NamedQuery(name = "ComFuenteFinanciamiento.findAll", query = "SELECT c FROM ComFuenteFinanciamiento c")})
public class ComFuenteFinanciamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fuente_financiamiento")
    private Integer idFuenteFinanciamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 12)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "uid")
    private Integer uid;

    public ComFuenteFinanciamiento() {
    }

    public ComFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public ComFuenteFinanciamiento(Integer idFuenteFinanciamiento, String nombre, boolean estado) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdFuenteFinanciamiento() {
        return idFuenteFinanciamiento;
    }

    public void setIdFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuenteFinanciamiento != null ? idFuenteFinanciamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComFuenteFinanciamiento)) {
            return false;
        }
        ComFuenteFinanciamiento other = (ComFuenteFinanciamiento) object;
        if ((this.idFuenteFinanciamiento == null && other.idFuenteFinanciamiento != null) || (this.idFuenteFinanciamiento != null && !this.idFuenteFinanciamiento.equals(other.idFuenteFinanciamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComFuenteFinanciamiento[ idFuenteFinanciamiento=" + idFuenteFinanciamiento + " ]";
    }
    
}
