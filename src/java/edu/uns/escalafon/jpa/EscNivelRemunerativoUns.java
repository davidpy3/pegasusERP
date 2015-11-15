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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "esc_nivel_remunerativo_uns")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscNivelRemunerativoUns.findAll", query = "SELECT e FROM EscNivelRemunerativoUns e"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByIdNivel", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.escNivelRemunerativoUnsPK.idNivel = :idNivel"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByTipo", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.escNivelRemunerativoUnsPK.tipo = :tipo"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByNivel", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByDedicacion", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.dedicacion = :dedicacion"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByAbrevCat", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.abrevCat = :abrevCat"),
    @NamedQuery(name = "EscNivelRemunerativoUns.findByAbrevDed", query = "SELECT e FROM EscNivelRemunerativoUns e WHERE e.abrevDed = :abrevDed")})
public class EscNivelRemunerativoUns implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscNivelRemunerativoUnsPK escNivelRemunerativoUnsPK;
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    @Column(name = "dedicacion")
    private String dedicacion;
    @Column(name = "abrev_cat")
    private String abrevCat;
    @Column(name = "abrev_ded")
    private String abrevDed;
    @JoinColumn(name = "id_cat", referencedColumnName = "id_cat")
    @ManyToOne
    private EscCategoriaDoc idCat;
    @JoinColumn(name = "id_go", referencedColumnName = "id_go")
    @ManyToOne(optional = false)
    private EscGrupoOcupacional idGo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escNivelRemunerativoUns")
    private List<EscCapUns> escCapUnsList;

    public EscNivelRemunerativoUns() {
    }

    public EscNivelRemunerativoUns(EscNivelRemunerativoUnsPK escNivelRemunerativoUnsPK) {
        this.escNivelRemunerativoUnsPK = escNivelRemunerativoUnsPK;
    }

    public EscNivelRemunerativoUns(EscNivelRemunerativoUnsPK escNivelRemunerativoUnsPK, String nivel) {
        this.escNivelRemunerativoUnsPK = escNivelRemunerativoUnsPK;
        this.nivel = nivel;
    }

    public EscNivelRemunerativoUns(short idNivel, boolean tipo) {
        this.escNivelRemunerativoUnsPK = new EscNivelRemunerativoUnsPK(idNivel, tipo);
    }

    public EscNivelRemunerativoUnsPK getEscNivelRemunerativoUnsPK() {
        return escNivelRemunerativoUnsPK;
    }

    public void setEscNivelRemunerativoUnsPK(EscNivelRemunerativoUnsPK escNivelRemunerativoUnsPK) {
        this.escNivelRemunerativoUnsPK = escNivelRemunerativoUnsPK;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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

    public EscCategoriaDoc getIdCat() {
        return idCat;
    }

    public void setIdCat(EscCategoriaDoc idCat) {
        this.idCat = idCat;
    }

    public EscGrupoOcupacional getIdGo() {
        return idGo;
    }

    public void setIdGo(EscGrupoOcupacional idGo) {
        this.idGo = idGo;
    }

    @XmlTransient
    public List<EscCapUns> getEscCapUnsList() {
        return escCapUnsList;
    }

    public void setEscCapUnsList(List<EscCapUns> escCapUnsList) {
        this.escCapUnsList = escCapUnsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escNivelRemunerativoUnsPK != null ? escNivelRemunerativoUnsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscNivelRemunerativoUns)) {
            return false;
        }
        EscNivelRemunerativoUns other = (EscNivelRemunerativoUns) object;
        if ((this.escNivelRemunerativoUnsPK == null && other.escNivelRemunerativoUnsPK != null) || (this.escNivelRemunerativoUnsPK != null && !this.escNivelRemunerativoUnsPK.equals(other.escNivelRemunerativoUnsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscNivelRemunerativoUns[ escNivelRemunerativoUnsPK=" + escNivelRemunerativoUnsPK + " ]";
    }
    
}
