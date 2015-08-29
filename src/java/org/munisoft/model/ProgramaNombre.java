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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "programa_nombre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramaNombre.findAll", query = "SELECT p FROM ProgramaNombre p"),
    @NamedQuery(name = "ProgramaNombre.findByAnoEje", query = "SELECT p FROM ProgramaNombre p WHERE p.programaNombrePK.anoEje = :anoEje"),
    @NamedQuery(name = "ProgramaNombre.findByPrograma", query = "SELECT p FROM ProgramaNombre p WHERE p.programaNombrePK.programa = :programa"),
    @NamedQuery(name = "ProgramaNombre.findByNombre", query = "SELECT p FROM ProgramaNombre p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProgramaNombre.findByEstado", query = "SELECT p FROM ProgramaNombre p WHERE p.estado = :estado")})
public class ProgramaNombre implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaNombrePK programaNombrePK;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaNombre")
    private Collection<Programa> programaCollection;

    public ProgramaNombre() {
    }

    public ProgramaNombre(ProgramaNombrePK programaNombrePK) {
        this.programaNombrePK = programaNombrePK;
    }

    public ProgramaNombre(String anoEje, String programa) {
        this.programaNombrePK = new ProgramaNombrePK(anoEje, programa);
    }

    public ProgramaNombrePK getProgramaNombrePK() {
        return programaNombrePK;
    }

    public void setProgramaNombrePK(ProgramaNombrePK programaNombrePK) {
        this.programaNombrePK = programaNombrePK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Programa> getProgramaCollection() {
        return programaCollection;
    }

    public void setProgramaCollection(Collection<Programa> programaCollection) {
        this.programaCollection = programaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programaNombrePK != null ? programaNombrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaNombre)) {
            return false;
        }
        ProgramaNombre other = (ProgramaNombre) object;
        if ((this.programaNombrePK == null && other.programaNombrePK != null) || (this.programaNombrePK != null && !this.programaNombrePK.equals(other.programaNombrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ProgramaNombre[ programaNombrePK=" + programaNombrePK + " ]";
    }
    
}
