/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_categoria_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCategoriaDoc.findAll", query = "SELECT e FROM EscCategoriaDoc e"),
    @NamedQuery(name = "EscCategoriaDoc.findByIdCat", query = "SELECT e FROM EscCategoriaDoc e WHERE e.idCat = :idCat"),
    @NamedQuery(name = "EscCategoriaDoc.findByNombre", query = "SELECT e FROM EscCategoriaDoc e WHERE e.nombre = :nombre")})
public class EscCategoriaDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cat")
    private Integer idCat;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idCat")
    private List<EscNivelRemunerativoUns> escNivelRemunerativoUnsList;
    @OneToMany(mappedBy = "idCat")
    private List<EscCategoria> escCategoriaList;

    public EscCategoriaDoc() {
    }

    public EscCategoriaDoc(Integer idCat) {
        this.idCat = idCat;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<EscNivelRemunerativoUns> getEscNivelRemunerativoUnsList() {
        return escNivelRemunerativoUnsList;
    }

    public void setEscNivelRemunerativoUnsList(List<EscNivelRemunerativoUns> escNivelRemunerativoUnsList) {
        this.escNivelRemunerativoUnsList = escNivelRemunerativoUnsList;
    }

    @XmlTransient
    public List<EscCategoria> getEscCategoriaList() {
        return escCategoriaList;
    }

    public void setEscCategoriaList(List<EscCategoria> escCategoriaList) {
        this.escCategoriaList = escCategoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCat != null ? idCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCategoriaDoc)) {
            return false;
        }
        EscCategoriaDoc other = (EscCategoriaDoc) object;
        if ((this.idCat == null && other.idCat != null) || (this.idCat != null && !this.idCat.equals(other.idCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCategoriaDoc[ idCat=" + idCat + " ]";
    }
    
}
