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
@Table(name = "com_tipo_giro")
@NamedQueries({
    @NamedQuery(name = "ComTipoGiro.findAll", query = "SELECT c FROM ComTipoGiro c")})
public class ComTipoGiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_giro")
    private Integer idTipoGiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
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

    public ComTipoGiro() {
    }

    public ComTipoGiro(Integer idTipoGiro) {
        this.idTipoGiro = idTipoGiro;
    }

    public ComTipoGiro(Integer idTipoGiro, String nombre, int idUsuario, Date fechaReg, String estado) {
        this.idTipoGiro = idTipoGiro;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.fechaReg = fechaReg;
        this.estado = estado;
    }

    public Integer getIdTipoGiro() {
        return idTipoGiro;
    }

    public void setIdTipoGiro(Integer idTipoGiro) {
        this.idTipoGiro = idTipoGiro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGiro != null ? idTipoGiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComTipoGiro)) {
            return false;
        }
        ComTipoGiro other = (ComTipoGiro) object;
        if ((this.idTipoGiro == null && other.idTipoGiro != null) || (this.idTipoGiro != null && !this.idTipoGiro.equals(other.idTipoGiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComTipoGiro[ idTipoGiro=" + idTipoGiro + " ]";
    }
    
}
