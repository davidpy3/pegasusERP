/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_prod_cientifica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscProdCientifica.findAll", query = "SELECT e FROM EscProdCientifica e"),
    @NamedQuery(name = "EscProdCientifica.findByIdProdc", query = "SELECT e FROM EscProdCientifica e WHERE e.idProdc = :idProdc"),
    @NamedQuery(name = "EscProdCientifica.findByIdEsc", query = "SELECT e FROM EscProdCientifica e WHERE e.idEsc = :idEsc"),
    @NamedQuery(name = "EscProdCientifica.findByDescripcion", query = "SELECT e FROM EscProdCientifica e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EscProdCientifica.findByFechaPubl", query = "SELECT e FROM EscProdCientifica e WHERE e.fechaPubl = :fechaPubl"),
    @NamedQuery(name = "EscProdCientifica.findByActivo", query = "SELECT e FROM EscProdCientifica e WHERE e.activo = :activo")})
public class EscProdCientifica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_prodc")
    private Integer idProdc;
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_publ")
    @Temporal(TemporalType.DATE)
    private Date fechaPubl;
    @Column(name = "activo")
    private Boolean activo;

    public EscProdCientifica() {
    }

    public EscProdCientifica(Integer idProdc) {
        this.idProdc = idProdc;
    }

    public EscProdCientifica(Integer idProdc, int idEsc) {
        this.idProdc = idProdc;
        this.idEsc = idEsc;
    }

    public Integer getIdProdc() {
        return idProdc;
    }

    public void setIdProdc(Integer idProdc) {
        this.idProdc = idProdc;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPubl() {
        return fechaPubl;
    }

    public void setFechaPubl(Date fechaPubl) {
        this.fechaPubl = fechaPubl;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdc != null ? idProdc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscProdCientifica)) {
            return false;
        }
        EscProdCientifica other = (EscProdCientifica) object;
        if ((this.idProdc == null && other.idProdc != null) || (this.idProdc != null && !this.idProdc.equals(other.idProdc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscProdCientifica[ idProdc=" + idProdc + " ]";
    }
    
}
