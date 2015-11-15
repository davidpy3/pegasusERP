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
@Table(name = "esc_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscMateria.findAll", query = "SELECT e FROM EscMateria e"),
    @NamedQuery(name = "EscMateria.findByIdMateria", query = "SELECT e FROM EscMateria e WHERE e.idMateria = :idMateria"),
    @NamedQuery(name = "EscMateria.findByMateria", query = "SELECT e FROM EscMateria e WHERE e.materia = :materia")})
public class EscMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Basic(optional = false)
    @Column(name = "materia")
    private String materia;

    public EscMateria() {
    }

    public EscMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public EscMateria(Integer idMateria, String materia) {
        this.idMateria = idMateria;
        this.materia = materia;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscMateria)) {
            return false;
        }
        EscMateria other = (EscMateria) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscMateria[ idMateria=" + idMateria + " ]";
    }
    
}
