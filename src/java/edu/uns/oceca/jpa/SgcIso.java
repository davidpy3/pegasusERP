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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_iso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcIso.findAll", query = "SELECT s FROM SgcIso s"),
    @NamedQuery(name = "SgcIso.findByIdEstandar", query = "SELECT s FROM SgcIso s WHERE s.idEstandar = :idEstandar"),
    @NamedQuery(name = "SgcIso.findByIdTipoIso", query = "SELECT s FROM SgcIso s WHERE s.idTipoIso = :idTipoIso"),
    @NamedQuery(name = "SgcIso.findByCapitulo", query = "SELECT s FROM SgcIso s WHERE s.capitulo = :capitulo"),
    @NamedQuery(name = "SgcIso.findByCapituloNombre", query = "SELECT s FROM SgcIso s WHERE s.capituloNombre = :capituloNombre")})
public class SgcIso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estandar")
    private Integer idEstandar;
    @Column(name = "id_tipo_iso")
    private Integer idTipoIso;
    @Column(name = "capitulo")
    private String capitulo;
    @Column(name = "capitulo_nombre")
    private String capituloNombre;
    @Lob
    @Column(name = "requerimientos")
    private String requerimientos;

    public SgcIso() {
    }

    public SgcIso(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public Integer getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(Integer idEstandar) {
        this.idEstandar = idEstandar;
    }

    public Integer getIdTipoIso() {
        return idTipoIso;
    }

    public void setIdTipoIso(Integer idTipoIso) {
        this.idTipoIso = idTipoIso;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getCapituloNombre() {
        return capituloNombre;
    }

    public void setCapituloNombre(String capituloNombre) {
        this.capituloNombre = capituloNombre;
    }

    public String getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(String requerimientos) {
        this.requerimientos = requerimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstandar != null ? idEstandar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcIso)) {
            return false;
        }
        SgcIso other = (SgcIso) object;
        if ((this.idEstandar == null && other.idEstandar != null) || (this.idEstandar != null && !this.idEstandar.equals(other.idEstandar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcIso[ idEstandar=" + idEstandar + " ]";
    }
    
}
