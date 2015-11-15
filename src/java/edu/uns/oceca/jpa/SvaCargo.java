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
@Table(name = "sva_cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SvaCargo.findAll", query = "SELECT s FROM SvaCargo s"),
    @NamedQuery(name = "SvaCargo.findByIdCargo", query = "SELECT s FROM SvaCargo s WHERE s.idCargo = :idCargo"),
    @NamedQuery(name = "SvaCargo.findByCargo", query = "SELECT s FROM SvaCargo s WHERE s.cargo = :cargo"),
    @NamedQuery(name = "SvaCargo.findByEstado", query = "SELECT s FROM SvaCargo s WHERE s.estado = :estado")})
public class SvaCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cargo")
    private Integer idCargo;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    public SvaCargo() {
    }

    public SvaCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public SvaCargo(Integer idCargo, String cargo, boolean estado) {
        this.idCargo = idCargo;
        this.cargo = cargo;
        this.estado = estado;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        if (!(object instanceof SvaCargo)) {
            return false;
        }
        SvaCargo other = (SvaCargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SvaCargo[ idCargo=" + idCargo + " ]";
    }
    
}
