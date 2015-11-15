/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "aps_situacion_estudiante")
public class ApsSituacionEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_acsit")
    private String codAcsit;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "id_acsit")
    private int idAcsit;

    public ApsSituacionEstudiante() {
    }

    public ApsSituacionEstudiante(String codAcsit) {
        this.codAcsit = codAcsit;
    }

    public ApsSituacionEstudiante(String codAcsit, String nombre, boolean estado, int idAcsit) {
        this.codAcsit = codAcsit;
        this.nombre = nombre;
        this.estado = estado;
        this.idAcsit = idAcsit;
    }

    public String getCodAcsit() {
        return codAcsit;
    }

    public void setCodAcsit(String codAcsit) {
        this.codAcsit = codAcsit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdAcsit() {
        return idAcsit;
    }

    public void setIdAcsit(int idAcsit) {
        this.idAcsit = idAcsit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAcsit != null ? codAcsit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsSituacionEstudiante)) {
            return false;
        }
        ApsSituacionEstudiante other = (ApsSituacionEstudiante) object;
        if ((this.codAcsit == null && other.codAcsit != null) || (this.codAcsit != null && !this.codAcsit.equals(other.codAcsit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsSituacionEstudiante[ codAcsit=" + codAcsit + " ]";
    }
    
}
