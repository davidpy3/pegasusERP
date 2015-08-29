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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "subgenerica_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubGenericaDet.findAll", query = "SELECT s FROM SubGenericaDet s"),
    @NamedQuery(name = "SubGenericaDet.findByAnoEje", query = "SELECT s FROM SubGenericaDet s WHERE s.subGenericaDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "SubGenericaDet.findByTipoTransaccion", query = "SELECT s FROM SubGenericaDet s WHERE s.subGenericaDetPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "SubGenericaDet.findByGenerica", query = "SELECT s FROM SubGenericaDet s WHERE s.subGenericaDetPK.generica = :generica"),
    @NamedQuery(name = "SubGenericaDet.findBySubgenerica", query = "SELECT s FROM SubGenericaDet s WHERE s.subGenericaDetPK.subgenerica = :subgenerica"),
    @NamedQuery(name = "SubGenericaDet.findBySubgenericaDet", query = "SELECT s FROM SubGenericaDet s WHERE s.subGenericaDetPK.subgenericaDet = :subgenericaDet"),
    @NamedQuery(name = "SubGenericaDet.findByDescripcion", query = "SELECT s FROM SubGenericaDet s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SubGenericaDet.findByCategoriaGasto", query = "SELECT s FROM SubGenericaDet s WHERE s.categoriaGasto = :categoriaGasto"),
    @NamedQuery(name = "SubGenericaDet.findByTipoActProy", query = "SELECT s FROM SubGenericaDet s WHERE s.tipoActProy = :tipoActProy"),
    @NamedQuery(name = "SubGenericaDet.findByTipoGasto", query = "SELECT s FROM SubGenericaDet s WHERE s.tipoGasto = :tipoGasto"),
    @NamedQuery(name = "SubGenericaDet.findByAmbito", query = "SELECT s FROM SubGenericaDet s WHERE s.ambito = :ambito"),
    @NamedQuery(name = "SubGenericaDet.findByEstado", query = "SELECT s FROM SubGenericaDet s WHERE s.estado = :estado")})
public class SubGenericaDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubGenericaDetPK subGenericaDetPK;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "categoria_gasto")
    private Character categoriaGasto;
    @Column(name = "tipo_act_proy")
    private Character tipoActProy;
    @Column(name = "tipo_gasto")
    private Character tipoGasto;
    @Column(name = "ambito")
    private Character ambito;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subGenericaDet")
    private Collection<Especifica> especificaCollection;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_transaccion", referencedColumnName = "tipo_transaccion", insertable = false, updatable = false),
        @JoinColumn(name = "generica", referencedColumnName = "generica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica", referencedColumnName = "subgenerica", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SubGenerica subGenerica;

    public SubGenericaDet() {
    }

    public SubGenericaDet(SubGenericaDetPK subGenericaDetPK) {
        this.subGenericaDetPK = subGenericaDetPK;
    }

    public SubGenericaDet(String anoEje, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet) {
        this.subGenericaDetPK = new SubGenericaDetPK(anoEje, tipoTransaccion, generica, subgenerica, subgenericaDet);
    }

    public SubGenericaDetPK getSubGenericaDetPK() {
        return subGenericaDetPK;
    }

    public void setSubGenericaDetPK(SubGenericaDetPK subGenericaDetPK) {
        this.subGenericaDetPK = subGenericaDetPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getCategoriaGasto() {
        return categoriaGasto;
    }

    public void setCategoriaGasto(Character categoriaGasto) {
        this.categoriaGasto = categoriaGasto;
    }

    public Character getTipoActProy() {
        return tipoActProy;
    }

    public void setTipoActProy(Character tipoActProy) {
        this.tipoActProy = tipoActProy;
    }

    public Character getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(Character tipoGasto) {
        this.tipoGasto = tipoGasto;
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

    @XmlTransient
    public Collection<Especifica> getEspecificaCollection() {
        return especificaCollection;
    }

    public void setEspecificaCollection(Collection<Especifica> especificaCollection) {
        this.especificaCollection = especificaCollection;
    }

    public SubGenerica getSubGenerica() {
        return subGenerica;
    }

    public void setSubGenerica(SubGenerica subGenerica) {
        this.subGenerica = subGenerica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subGenericaDetPK != null ? subGenericaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubGenericaDet)) {
            return false;
        }
        SubGenericaDet other = (SubGenericaDet) object;
        if ((this.subGenericaDetPK == null && other.subGenericaDetPK != null) || (this.subGenericaDetPK != null && !this.subGenericaDetPK.equals(other.subGenericaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.SubGenericaDet[ subGenericaDetPK=" + subGenericaDetPK + " ]";
    }
    
}
