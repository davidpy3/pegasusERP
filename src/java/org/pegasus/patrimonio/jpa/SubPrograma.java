/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
@Table(name = "sub_programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubPrograma.findAll", query = "SELECT s FROM SubPrograma s"),
    @NamedQuery(name = "SubPrograma.findByAnoEje", query = "SELECT s FROM SubPrograma s WHERE s.subProgramaPK.anoEje = :anoEje"),
    @NamedQuery(name = "SubPrograma.findByFuncion", query = "SELECT s FROM SubPrograma s WHERE s.subProgramaPK.funcion = :funcion"),
    @NamedQuery(name = "SubPrograma.findByPrograma", query = "SELECT s FROM SubPrograma s WHERE s.subProgramaPK.programa = :programa"),
    @NamedQuery(name = "SubPrograma.findBySubPrograma", query = "SELECT s FROM SubPrograma s WHERE s.subProgramaPK.subPrograma = :subPrograma"),
    @NamedQuery(name = "SubPrograma.findByEstado", query = "SELECT s FROM SubPrograma s WHERE s.estado = :estado")})
public class SubPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubProgramaPK subProgramaPK;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subPrograma1")
    private Collection<ActProy> actProyCollection;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "funcion", referencedColumnName = "funcion", insertable = false, updatable = false),
        @JoinColumn(name = "programa", referencedColumnName = "programa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Programa programa1;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "sub_programa", referencedColumnName = "sub_programa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SubProgramaNombre subProgramaNombre;

    public SubPrograma() {
    }

    public SubPrograma(SubProgramaPK subProgramaPK) {
        this.subProgramaPK = subProgramaPK;
    }

    public SubPrograma(String anoEje, String funcion, String programa, String subPrograma) {
        this.subProgramaPK = new SubProgramaPK(anoEje, funcion, programa, subPrograma);
    }

    public SubProgramaPK getSubProgramaPK() {
        return subProgramaPK;
    }

    public void setSubProgramaPK(SubProgramaPK subProgramaPK) {
        this.subProgramaPK = subProgramaPK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<ActProy> getActProyCollection() {
        return actProyCollection;
    }

    public void setActProyCollection(Collection<ActProy> actProyCollection) {
        this.actProyCollection = actProyCollection;
    }

    public Programa getPrograma1() {
        return programa1;
    }

    public void setPrograma1(Programa programa1) {
        this.programa1 = programa1;
    }

    public SubProgramaNombre getSubProgramaNombre() {
        return subProgramaNombre;
    }

    public void setSubProgramaNombre(SubProgramaNombre subProgramaNombre) {
        this.subProgramaNombre = subProgramaNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subProgramaPK != null ? subProgramaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubPrograma)) {
            return false;
        }
        SubPrograma other = (SubPrograma) object;
        if ((this.subProgramaPK == null && other.subProgramaPK != null) || (this.subProgramaPK != null && !this.subProgramaPK.equals(other.subProgramaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.SubPrograma[ subProgramaPK=" + subProgramaPK + " ]";
    }
    
}
