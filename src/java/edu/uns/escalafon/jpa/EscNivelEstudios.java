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
@Table(name = "esc_nivel_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscNivelEstudios.findAll", query = "SELECT e FROM EscNivelEstudios e"),
    @NamedQuery(name = "EscNivelEstudios.findByIdNivel", query = "SELECT e FROM EscNivelEstudios e WHERE e.idNivel = :idNivel"),
    @NamedQuery(name = "EscNivelEstudios.findByNivel", query = "SELECT e FROM EscNivelEstudios e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "EscNivelEstudios.findByAbrev", query = "SELECT e FROM EscNivelEstudios e WHERE e.abrev = :abrev"),
    @NamedQuery(name = "EscNivelEstudios.findByAmbito", query = "SELECT e FROM EscNivelEstudios e WHERE e.ambito = :ambito"),
    @NamedQuery(name = "EscNivelEstudios.findByUltimo", query = "SELECT e FROM EscNivelEstudios e WHERE e.ultimo = :ultimo")})
public class EscNivelEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nivel")
    private Short idNivel;
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "ambito")
    private String ambito;
    @Column(name = "ultimo")
    private Boolean ultimo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivel")
    private List<EscEstudio> escEstudioList;

    public EscNivelEstudios() {
    }

    public EscNivelEstudios(Short idNivel) {
        this.idNivel = idNivel;
    }

    public EscNivelEstudios(Short idNivel, String nivel, String abrev) {
        this.idNivel = idNivel;
        this.nivel = nivel;
        this.abrev = abrev;
    }

    public Short getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Short idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Boolean getUltimo() {
        return ultimo;
    }

    public void setUltimo(Boolean ultimo) {
        this.ultimo = ultimo;
    }

    @XmlTransient
    public List<EscEstudio> getEscEstudioList() {
        return escEstudioList;
    }

    public void setEscEstudioList(List<EscEstudio> escEstudioList) {
        this.escEstudioList = escEstudioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscNivelEstudios)) {
            return false;
        }
        EscNivelEstudios other = (EscNivelEstudios) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscNivelEstudios[ idNivel=" + idNivel + " ]";
    }
    
}
