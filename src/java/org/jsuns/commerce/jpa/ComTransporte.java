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
@Table(name = "com_transporte")
@NamedQueries({
    @NamedQuery(name = "ComTransporte.findAll", query = "SELECT c FROM ComTransporte c")})
public class ComTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transporte")
    private Integer idTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private int idDir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_transporte")
    private int idTipoTransporte;
    @Size(max = 30)
    @Column(name = "marca")
    private String marca;
    @Column(name = "anio")
    private Integer anio;
    @Size(max = 20)
    @Column(name = "matricula")
    private String matricula;
    @Size(max = 30)
    @Column(name = "color")
    private String color;
    @Size(max = 10)
    @Column(name = "propiedad")
    private String propiedad;
    @Column(name = "estado")
    private Boolean estado;

    public ComTransporte() {
    }

    public ComTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public ComTransporte(Integer idTransporte, int idDir, int idTipoTransporte) {
        this.idTransporte = idTransporte;
        this.idDir = idDir;
        this.idTipoTransporte = idTipoTransporte;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public int getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(int idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComTransporte)) {
            return false;
        }
        ComTransporte other = (ComTransporte) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComTransporte[ idTransporte=" + idTransporte + " ]";
    }
    
}
