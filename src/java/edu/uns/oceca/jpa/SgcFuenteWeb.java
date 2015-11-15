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
@Table(name = "sgc_fuente_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcFuenteWeb.findAll", query = "SELECT s FROM SgcFuenteWeb s"),
    @NamedQuery(name = "SgcFuenteWeb.findByIdRefweb", query = "SELECT s FROM SgcFuenteWeb s WHERE s.idRefweb = :idRefweb"),
    @NamedQuery(name = "SgcFuenteWeb.findByTitulo", query = "SELECT s FROM SgcFuenteWeb s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "SgcFuenteWeb.findByDireccion", query = "SELECT s FROM SgcFuenteWeb s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "SgcFuenteWeb.findByIdFuente", query = "SELECT s FROM SgcFuenteWeb s WHERE s.idFuente = :idFuente")})
public class SgcFuenteWeb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_refweb")
    private Integer idRefweb;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "id_fuente")
    private Integer idFuente;

    public SgcFuenteWeb() {
    }

    public SgcFuenteWeb(Integer idRefweb) {
        this.idRefweb = idRefweb;
    }

    public SgcFuenteWeb(Integer idRefweb, String titulo, String direccion) {
        this.idRefweb = idRefweb;
        this.titulo = titulo;
        this.direccion = direccion;
    }

    public Integer getIdRefweb() {
        return idRefweb;
    }

    public void setIdRefweb(Integer idRefweb) {
        this.idRefweb = idRefweb;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRefweb != null ? idRefweb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteWeb)) {
            return false;
        }
        SgcFuenteWeb other = (SgcFuenteWeb) object;
        if ((this.idRefweb == null && other.idRefweb != null) || (this.idRefweb != null && !this.idRefweb.equals(other.idRefweb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteWeb[ idRefweb=" + idRefweb + " ]";
    }
    
}
