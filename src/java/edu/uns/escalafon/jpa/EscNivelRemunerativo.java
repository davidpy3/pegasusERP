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
@Table(name = "esc_nivel_remunerativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscNivelRemunerativo.findAll", query = "SELECT e FROM EscNivelRemunerativo e"),
    @NamedQuery(name = "EscNivelRemunerativo.findByIdNivel", query = "SELECT e FROM EscNivelRemunerativo e WHERE e.idNivel = :idNivel"),
    @NamedQuery(name = "EscNivelRemunerativo.findByNivel", query = "SELECT e FROM EscNivelRemunerativo e WHERE e.nivel = :nivel")})
public class EscNivelRemunerativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nivel")
    private Short idNivel;
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @OneToMany(mappedBy = "idNivel")
    private List<EscCap> escCapList;
    @JoinColumn(name = "id_go", referencedColumnName = "id_go")
    @ManyToOne(optional = false)
    private EscGrupoOcupacional idGo;

    public EscNivelRemunerativo() {
    }

    public EscNivelRemunerativo(Short idNivel) {
        this.idNivel = idNivel;
    }

    public EscNivelRemunerativo(Short idNivel, String nivel) {
        this.idNivel = idNivel;
        this.nivel = nivel;
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

    @XmlTransient
    public List<EscCap> getEscCapList() {
        return escCapList;
    }

    public void setEscCapList(List<EscCap> escCapList) {
        this.escCapList = escCapList;
    }

    public EscGrupoOcupacional getIdGo() {
        return idGo;
    }

    public void setIdGo(EscGrupoOcupacional idGo) {
        this.idGo = idGo;
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
        if (!(object instanceof EscNivelRemunerativo)) {
            return false;
        }
        EscNivelRemunerativo other = (EscNivelRemunerativo) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscNivelRemunerativo[ idNivel=" + idNivel + " ]";
    }
    
}
