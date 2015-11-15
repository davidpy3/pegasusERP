/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

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
 * @author Erick alarcon
 */
@Entity
@Table(name = "ecargo")
@NamedQueries({
    @NamedQuery(name = "Ecargo.findAll", query = "SELECT e FROM Ecargo e")})
public class Ecargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cargo")
    private String idCargo;
    @Column(name = "nom_oficina")
    private String nomOficina;
    @Column(name = "abre_cargo")
    private String abreCargo;

    public Ecargo() {
    }

    public Ecargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomOficina() {
        return nomOficina;
    }

    public void setNomOficina(String nomOficina) {
        this.nomOficina = nomOficina;
    }

    public String getAbreCargo() {
        return abreCargo;
    }

    public void setAbreCargo(String abreCargo) {
        this.abreCargo = abreCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecargo)) {
            return false;
        }
        Ecargo other = (Ecargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Ecargo[ idCargo=" + idCargo + " ]";
    }
    
}
