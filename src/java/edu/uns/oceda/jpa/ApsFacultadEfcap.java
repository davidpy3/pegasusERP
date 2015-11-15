/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "aps_facultad_efcap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApsFacultadEfcap.findAll", query = "SELECT a FROM ApsFacultadEfcap a"),
    @NamedQuery(name = "ApsFacultadEfcap.findByIdFacultad", query = "SELECT a FROM ApsFacultadEfcap a WHERE a.idFacultad = :idFacultad"),
    @NamedQuery(name = "ApsFacultadEfcap.findByFacultad", query = "SELECT a FROM ApsFacultadEfcap a WHERE a.facultad = :facultad"),
    @NamedQuery(name = "ApsFacultadEfcap.findByEstado", query = "SELECT a FROM ApsFacultadEfcap a WHERE a.estado = :estado")})
public class ApsFacultadEfcap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_facultad")
    private Integer idFacultad;
    @Column(name = "facultad")
    private String facultad;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(mappedBy = "idFacultad")
    private List<ApsEscuelaEfcap> apsEscuelaEfcapList;
    @JoinColumn(name = "id_ambito", referencedColumnName = "id_ambito")
    @ManyToOne
    private ApsAmbitoAcad idAmbito;

    public ApsFacultadEfcap() {
    }

    public ApsFacultadEfcap(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public ApsFacultadEfcap(Integer idFacultad, boolean estado) {
        this.idFacultad = idFacultad;
        this.estado = estado;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ApsEscuelaEfcap> getApsEscuelaEfcapList() {
        return apsEscuelaEfcapList;
    }

    public void setApsEscuelaEfcapList(List<ApsEscuelaEfcap> apsEscuelaEfcapList) {
        this.apsEscuelaEfcapList = apsEscuelaEfcapList;
    }

    public ApsAmbitoAcad getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(ApsAmbitoAcad idAmbito) {
        this.idAmbito = idAmbito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacultad != null ? idFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApsFacultadEfcap)) {
            return false;
        }
        ApsFacultadEfcap other = (ApsFacultadEfcap) object;
        if ((this.idFacultad == null && other.idFacultad != null) || (this.idFacultad != null && !this.idFacultad.equals(other.idFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceda.jpa.ApsFacultadEfcap[ idFacultad=" + idFacultad + " ]";
    }
    
}
