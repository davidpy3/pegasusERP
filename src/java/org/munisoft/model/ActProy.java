/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "act_proy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActProy.findAll", query = "SELECT a FROM ActProy a"),
    @NamedQuery(name = "ActProy.findByAnoEje", query = "SELECT a FROM ActProy a WHERE a.actProyPK.anoEje = :anoEje"),
    @NamedQuery(name = "ActProy.findByFuncion", query = "SELECT a FROM ActProy a WHERE a.actProyPK.funcion = :funcion"),
    @NamedQuery(name = "ActProy.findByPrograma", query = "SELECT a FROM ActProy a WHERE a.actProyPK.programa = :programa"),
    @NamedQuery(name = "ActProy.findBySubPrograma", query = "SELECT a FROM ActProy a WHERE a.actProyPK.subPrograma = :subPrograma"),
    @NamedQuery(name = "ActProy.findByActProy", query = "SELECT a FROM ActProy a WHERE a.actProyPK.actProy = :actProy"),
    @NamedQuery(name = "ActProy.findByEstado", query = "SELECT a FROM ActProy a WHERE a.estado = :estado")})
public class ActProy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActProyPK actProyPK;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "act_proy", referencedColumnName = "act_proy", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ActProyNombre actProyNombre;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "funcion", referencedColumnName = "funcion", insertable = false, updatable = false),
        @JoinColumn(name = "programa", referencedColumnName = "programa", insertable = false, updatable = false),
        @JoinColumn(name = "sub_programa", referencedColumnName = "sub_programa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SubPrograma subPrograma1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actProy1")
    private Collection<Componente> componenteCollection;

    public ActProy() {
    }

    public ActProy(ActProyPK actProyPK) {
        this.actProyPK = actProyPK;
    }

    public ActProy(String anoEje, String funcion, String programa, String subPrograma, String actProy) {
        this.actProyPK = new ActProyPK(anoEje, funcion, programa, subPrograma, actProy);
    }

    public ActProyPK getActProyPK() {
        return actProyPK;
    }

    public void setActProyPK(ActProyPK actProyPK) {
        this.actProyPK = actProyPK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public ActProyNombre getActProyNombre() {
        return actProyNombre;
    }

    public void setActProyNombre(ActProyNombre actProyNombre) {
        this.actProyNombre = actProyNombre;
    }

    public SubPrograma getSubPrograma1() {
        return subPrograma1;
    }

    public void setSubPrograma1(SubPrograma subPrograma1) {
        this.subPrograma1 = subPrograma1;
    }

    @XmlTransient
    public Collection<Componente> getComponenteCollection() {
        return componenteCollection;
    }

    public void setComponenteCollection(Collection<Componente> componenteCollection) {
        this.componenteCollection = componenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actProyPK != null ? actProyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActProy)) {
            return false;
        }
        ActProy other = (ActProy) object;
        if ((this.actProyPK == null && other.actProyPK != null) || (this.actProyPK != null && !this.actProyPK.equals(other.actProyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ActProy[ actProyPK=" + actProyPK + " ]";
    }
    
}
