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
@Table(name = "esc_gocupacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscGrupoOcupacional.findAll", query = "SELECT e FROM EscGrupoOcupacional e"),
    @NamedQuery(name = "EscGrupoOcupacional.findByIdGo", query = "SELECT e FROM EscGrupoOcupacional e WHERE e.idGo = :idGo"),
    @NamedQuery(name = "EscGrupoOcupacional.findByGrupo", query = "SELECT e FROM EscGrupoOcupacional e WHERE e.grupo = :grupo")})
public class EscGrupoOcupacional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_go")
    private Short idGo;
    @Basic(optional = false)
    @Column(name = "grupo")
    private String grupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGo")
    private List<EscNivelRemunerativoUns> escNivelRemunerativoUnsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGo")
    private List<EscNivelRemunerativo> escNivelRemunerativoList;

    public EscGrupoOcupacional() {
    }

    public EscGrupoOcupacional(Short idGo) {
        this.idGo = idGo;
    }

    public EscGrupoOcupacional(Short idGo, String grupo) {
        this.idGo = idGo;
        this.grupo = grupo;
    }

    public Short getIdGo() {
        return idGo;
    }

    public void setIdGo(Short idGo) {
        this.idGo = idGo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @XmlTransient
    public List<EscNivelRemunerativoUns> getEscNivelRemunerativoUnsList() {
        return escNivelRemunerativoUnsList;
    }

    public void setEscNivelRemunerativoUnsList(List<EscNivelRemunerativoUns> escNivelRemunerativoUnsList) {
        this.escNivelRemunerativoUnsList = escNivelRemunerativoUnsList;
    }

    @XmlTransient
    public List<EscNivelRemunerativo> getEscNivelRemunerativoList() {
        return escNivelRemunerativoList;
    }

    public void setEscNivelRemunerativoList(List<EscNivelRemunerativo> escNivelRemunerativoList) {
        this.escNivelRemunerativoList = escNivelRemunerativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGo != null ? idGo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscGrupoOcupacional)) {
            return false;
        }
        EscGrupoOcupacional other = (EscGrupoOcupacional) object;
        if ((this.idGo == null && other.idGo != null) || (this.idGo != null && !this.idGo.equals(other.idGo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscGrupoOcupacional[ idGo=" + idGo + " ]";
    }
    
}
