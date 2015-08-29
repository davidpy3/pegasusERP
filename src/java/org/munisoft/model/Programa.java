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
@Table(name = "programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programa.findAll", query = "SELECT p FROM Programa p"),
    @NamedQuery(name = "Programa.findByAnoEje", query = "SELECT p FROM Programa p WHERE p.programaPK.anoEje = :anoEje"),
    @NamedQuery(name = "Programa.findByFuncion", query = "SELECT p FROM Programa p WHERE p.programaPK.funcion = :funcion"),
    @NamedQuery(name = "Programa.findByPrograma", query = "SELECT p FROM Programa p WHERE p.programaPK.programa = :programa"),
    @NamedQuery(name = "Programa.findByEstado", query = "SELECT p FROM Programa p WHERE p.estado = :estado")})
public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaPK programaPK;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "funcion", referencedColumnName = "funcion", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Funcion funcion1;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "programa", referencedColumnName = "programa", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ProgramaNombre programaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programa1")
    private Collection<SubPrograma> subProgramaCollection;

    public Programa() {
    }

    public Programa(ProgramaPK programaPK) {
        this.programaPK = programaPK;
    }

    public Programa(String anoEje, String funcion, String programa) {
        this.programaPK = new ProgramaPK(anoEje, funcion, programa);
    }

    public ProgramaPK getProgramaPK() {
        return programaPK;
    }

    public void setProgramaPK(ProgramaPK programaPK) {
        this.programaPK = programaPK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Funcion getFuncion1() {
        return funcion1;
    }

    public void setFuncion1(Funcion funcion1) {
        this.funcion1 = funcion1;
    }

    public ProgramaNombre getProgramaNombre() {
        return programaNombre;
    }

    public void setProgramaNombre(ProgramaNombre programaNombre) {
        this.programaNombre = programaNombre;
    }

    @XmlTransient
    public Collection<SubPrograma> getSubProgramaCollection() {
        return subProgramaCollection;
    }

    public void setSubProgramaCollection(Collection<SubPrograma> subProgramaCollection) {
        this.subProgramaCollection = subProgramaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaPK != null ? programaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programa)) {
            return false;
        }
        Programa other = (Programa) object;
        if ((this.programaPK == null && other.programaPK != null) || (this.programaPK != null && !this.programaPK.equals(other.programaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Programa[ programaPK=" + programaPK + " ]";
    }
    
}
