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
@Table(name = "sub_programa_nombre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubProgramaNombre.findAll", query = "SELECT s FROM SubProgramaNombre s"),
    @NamedQuery(name = "SubProgramaNombre.findByAnoEje", query = "SELECT s FROM SubProgramaNombre s WHERE s.subProgramaNombrePK.anoEje = :anoEje"),
    @NamedQuery(name = "SubProgramaNombre.findBySubPrograma", query = "SELECT s FROM SubProgramaNombre s WHERE s.subProgramaNombrePK.subPrograma = :subPrograma"),
    @NamedQuery(name = "SubProgramaNombre.findByNombre", query = "SELECT s FROM SubProgramaNombre s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SubProgramaNombre.findByEstado", query = "SELECT s FROM SubProgramaNombre s WHERE s.estado = :estado")})
public class SubProgramaNombre implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubProgramaNombrePK subProgramaNombrePK;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subProgramaNombre")
    private Collection<SubPrograma> subProgramaCollection;

    public SubProgramaNombre() {
    }

    public SubProgramaNombre(SubProgramaNombrePK subProgramaNombrePK) {
        this.subProgramaNombrePK = subProgramaNombrePK;
    }

    public SubProgramaNombre(String anoEje, String subPrograma) {
        this.subProgramaNombrePK = new SubProgramaNombrePK(anoEje, subPrograma);
    }

    public SubProgramaNombrePK getSubProgramaNombrePK() {
        return subProgramaNombrePK;
    }

    public void setSubProgramaNombrePK(SubProgramaNombrePK subProgramaNombrePK) {
        this.subProgramaNombrePK = subProgramaNombrePK;
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
    public Collection<SubPrograma> getSubProgramaCollection() {
        return subProgramaCollection;
    }

    public void setSubProgramaCollection(Collection<SubPrograma> subProgramaCollection) {
        this.subProgramaCollection = subProgramaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subProgramaNombrePK != null ? subProgramaNombrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubProgramaNombre)) {
            return false;
        }
        SubProgramaNombre other = (SubProgramaNombre) object;
        if ((this.subProgramaNombrePK == null && other.subProgramaNombrePK != null) || (this.subProgramaNombrePK != null && !this.subProgramaNombrePK.equals(other.subProgramaNombrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.SubProgramaNombre[ subProgramaNombrePK=" + subProgramaNombrePK + " ]";
    }
    
}
