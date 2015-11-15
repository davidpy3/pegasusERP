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
 * @author JC
 */
@Entity
@Table(name = "com_unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UMedida.findAll", query = "SELECT u FROM UMedida u"),
    @NamedQuery(name = "UMedida.findByIdUnidad", query = "SELECT u FROM UMedida u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "UMedida.findByUnidad", query = "SELECT u FROM UMedida u WHERE u.unidad = :unidad"),
    @NamedQuery(name = "UMedida.findByAbreviatura", query = "SELECT u FROM UMedida u WHERE u.abreviatura = :abreviatura")})
public class UMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad")
    private Integer idUnidad;
    @Basic(optional = false)
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "abreviatura")
    private String abreviatura;

    public UMedida() {
    }

    public UMedida(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public UMedida(Integer idUnidad, String unidad) {
        this.idUnidad = idUnidad;
        this.unidad = unidad;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UMedida)) {
            return false;
        }
        UMedida other = (UMedida) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.jpa.UMedida[ idUnidad=" + idUnidad + " ]";
    }
    
}
