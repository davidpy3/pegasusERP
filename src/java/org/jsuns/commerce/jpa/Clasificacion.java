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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_clasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c"),
    @NamedQuery(name = "Clasificacion.findByIdClas", query = "SELECT c FROM Clasificacion c WHERE c.idClas = :idClas"),
    @NamedQuery(name = "Clasificacion.findByDescClas", query = "SELECT c FROM Clasificacion c WHERE c.descClas = :descClas")})
public class Clasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clas")
    private Integer idClas;
    @Column(name = "desc_clas")
    private String descClas;

    public Clasificacion() {
    }

    public Clasificacion(Integer idClas) {
        this.idClas = idClas;
    }

    public Integer getIdClas() {
        return idClas;
    }

    public void setIdClas(Integer idClas) {
        this.idClas = idClas;
    }

    public String getDescripcion() {
        return descClas;
    }

    public void setDescripcion(String descClas) {
        this.descClas = descClas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClas != null ? idClas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idClas == null && other.idClas != null) || (this.idClas != null && !this.idClas.equals(other.idClas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model.Clasificacion[ idClas=" + idClas + " ]";
    }
    
}
