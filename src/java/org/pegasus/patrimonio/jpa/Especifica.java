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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "especifica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especifica.findAll", query = "SELECT e FROM Especifica e"),
    @NamedQuery(name = "Especifica.findByAnoEje", query = "SELECT e FROM Especifica e WHERE e.especificaPK.anoEje = :anoEje"),
    @NamedQuery(name = "Especifica.findByTipoTransaccion", query = "SELECT e FROM Especifica e WHERE e.especificaPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "Especifica.findByGenerica", query = "SELECT e FROM Especifica e WHERE e.especificaPK.generica = :generica"),
    @NamedQuery(name = "Especifica.findBySubgenerica", query = "SELECT e FROM Especifica e WHERE e.especificaPK.subgenerica = :subgenerica"),
    @NamedQuery(name = "Especifica.findBySubgenericaDet", query = "SELECT e FROM Especifica e WHERE e.especificaPK.subgenericaDet = :subgenericaDet"),
    @NamedQuery(name = "Especifica.findByEspecifica", query = "SELECT e FROM Especifica e WHERE e.especificaPK.especifica = :especifica"),
    @NamedQuery(name = "Especifica.findByDescripcion", query = "SELECT e FROM Especifica e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Especifica.findByAmbito", query = "SELECT e FROM Especifica e WHERE e.ambito = :ambito"),
    @NamedQuery(name = "Especifica.findByEstado", query = "SELECT e FROM Especifica e WHERE e.estado = :estado")})
public class Especifica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecificaPK especificaPK;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ambito")
    private Character ambito;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_transaccion", referencedColumnName = "tipo_transaccion", insertable = false, updatable = false),
        @JoinColumn(name = "generica", referencedColumnName = "generica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica", referencedColumnName = "subgenerica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica_det", referencedColumnName = "subgenerica_det", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SubGenericaDet subGenericaDet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especifica1")
    private Collection<EspecificaDet> especificaDetCollection;

    public Especifica() {
    }

    public Especifica(EspecificaPK especificaPK) {
        this.especificaPK = especificaPK;
    }

    public Especifica(String anoEje, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet, String especifica) {
        this.especificaPK = new EspecificaPK(anoEje, tipoTransaccion, generica, subgenerica, subgenericaDet, especifica);
    }

    public EspecificaPK getEspecificaPK() {
        return especificaPK;
    }

    public void setEspecificaPK(EspecificaPK especificaPK) {
        this.especificaPK = especificaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getAmbito() {
        return ambito;
    }

    public void setAmbito(Character ambito) {
        this.ambito = ambito;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public SubGenericaDet getSubGenericaDet() {
        return subGenericaDet;
    }

    public void setSubGenericaDet(SubGenericaDet subGenericaDet) {
        this.subGenericaDet = subGenericaDet;
    }

    @XmlTransient
    public Collection<EspecificaDet> getEspecificaDetCollection() {
        return especificaDetCollection;
    }

    public void setEspecificaDetCollection(Collection<EspecificaDet> especificaDetCollection) {
        this.especificaDetCollection = especificaDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especificaPK != null ? especificaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especifica)) {
            return false;
        }
        Especifica other = (Especifica) object;
        if ((this.especificaPK == null && other.especificaPK != null) || (this.especificaPK != null && !this.especificaPK.equals(other.especificaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Especifica[ especificaPK=" + especificaPK + " ]";
    }
    
}
