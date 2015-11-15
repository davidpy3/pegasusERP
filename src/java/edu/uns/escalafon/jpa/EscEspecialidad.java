/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

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
@Table(name = "esc_especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscEspecialidad.findAll", query = "SELECT e FROM EscEspecialidad e"),
    @NamedQuery(name = "EscEspecialidad.findByIdEsp", query = "SELECT e FROM EscEspecialidad e WHERE e.idEsp = :idEsp"),
    @NamedQuery(name = "EscEspecialidad.findByEspecialidad", query = "SELECT e FROM EscEspecialidad e WHERE e.especialidad = :especialidad"),
    @NamedQuery(name = "EscEspecialidad.findByAbrev", query = "SELECT e FROM EscEspecialidad e WHERE e.abrev = :abrev")})
public class EscEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_esp")
    private Short idEsp;
    @Basic(optional = false)
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "abrev")
    private String abrev;

    public EscEspecialidad() {
    }

    public EscEspecialidad(Short idEsp) {
        this.idEsp = idEsp;
    }

    public EscEspecialidad(Short idEsp, String especialidad) {
        this.idEsp = idEsp;
        this.especialidad = especialidad;
    }

    public Short getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(Short idEsp) {
        this.idEsp = idEsp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsp != null ? idEsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscEspecialidad)) {
            return false;
        }
        EscEspecialidad other = (EscEspecialidad) object;
        if ((this.idEsp == null && other.idEsp != null) || (this.idEsp != null && !this.idEsp.equals(other.idEsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscEspecialidad[ idEsp=" + idEsp + " ]";
    }
    
}
