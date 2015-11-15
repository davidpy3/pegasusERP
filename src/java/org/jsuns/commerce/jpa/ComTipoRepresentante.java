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
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_tipo_representante")
@NamedQueries({
    @NamedQuery(name = "ComTipoRepresentante.findAll", query = "SELECT c FROM ComTipoRepresentante c")})
public class ComTipoRepresentante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tiprep")
    private Integer idTiprep;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;

    public ComTipoRepresentante() {
    }

    public ComTipoRepresentante(Integer idTiprep) {
        this.idTiprep = idTiprep;
    }

    public Integer getIdTiprep() {
        return idTiprep;
    }

    public void setIdTiprep(Integer idTiprep) {
        this.idTiprep = idTiprep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiprep != null ? idTiprep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComTipoRepresentante)) {
            return false;
        }
        ComTipoRepresentante other = (ComTipoRepresentante) object;
        if ((this.idTiprep == null && other.idTiprep != null) || (this.idTiprep != null && !this.idTiprep.equals(other.idTiprep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComTipoRepresentante[ idTiprep=" + idTiprep + " ]";
    }
    
}
