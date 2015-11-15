/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "esc_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCategoria.findAll", query = "SELECT e FROM EscCategoria e"),
    @NamedQuery(name = "EscCategoria.findByIdCategoria", query = "SELECT e FROM EscCategoria e WHERE e.idCategoria = :idCategoria"),
    @NamedQuery(name = "EscCategoria.findByCategoria", query = "SELECT e FROM EscCategoria e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "EscCategoria.findByDedicacion", query = "SELECT e FROM EscCategoria e WHERE e.dedicacion = :dedicacion"),
    @NamedQuery(name = "EscCategoria.findByAbrevCat", query = "SELECT e FROM EscCategoria e WHERE e.abrevCat = :abrevCat"),
    @NamedQuery(name = "EscCategoria.findByAbrevDed", query = "SELECT e FROM EscCategoria e WHERE e.abrevDed = :abrevDed")})
public class EscCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Short idCategoria;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "dedicacion")
    private String dedicacion;
    @Basic(optional = false)
    @Column(name = "abrev_cat")
    private String abrevCat;
    @Column(name = "abrev_ded")
    private String abrevDed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<EscCapDocente> escCapDocenteList;
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    @ManyToOne
    private EscCategoriaDoc idCat;

    public EscCategoria() {
    }

    public EscCategoria(Short idCategoria) {
        this.idCategoria = idCategoria;
    }

    public EscCategoria(Short idCategoria, String categoria, String abrevCat) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.abrevCat = abrevCat;
    }

    public Short getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Short idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
    }

    public String getAbrevCat() {
        return abrevCat;
    }

    public void setAbrevCat(String abrevCat) {
        this.abrevCat = abrevCat;
    }

    public String getAbrevDed() {
        return abrevDed;
    }

    public void setAbrevDed(String abrevDed) {
        this.abrevDed = abrevDed;
    }

    @XmlTransient
    public List<EscCapDocente> getEscCapDocenteList() {
        return escCapDocenteList;
    }

    public void setEscCapDocenteList(List<EscCapDocente> escCapDocenteList) {
        this.escCapDocenteList = escCapDocenteList;
    }

    public EscCategoriaDoc getIdCat() {
        return idCat;
    }

    public void setIdCat(EscCategoriaDoc idCat) {
        this.idCat = idCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCategoria)) {
            return false;
        }
        EscCategoria other = (EscCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
