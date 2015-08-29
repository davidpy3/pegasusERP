/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "especifica_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecificaDet.findAll", query = "SELECT e FROM EspecificaDet e"),
    @NamedQuery(name = "EspecificaDet.findByAnoEje", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.anoEje = :anoEje"),
    @NamedQuery(name = "EspecificaDet.findByTipoTransaccion", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "EspecificaDet.findByGenerica", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.generica = :generica"),
    @NamedQuery(name = "EspecificaDet.findBySubgenerica", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.subgenerica = :subgenerica"),
    @NamedQuery(name = "EspecificaDet.findBySubgenericaDet", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.subgenericaDet = :subgenericaDet"),
    @NamedQuery(name = "EspecificaDet.findByEspecifica", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.especifica = :especifica"),
    @NamedQuery(name = "EspecificaDet.findByEspecificaDet", query = "SELECT e FROM EspecificaDet e WHERE e.especificaDetPK.especificaDet = :especificaDet"),
    @NamedQuery(name = "EspecificaDet.findByIdClasificador", query = "SELECT e FROM EspecificaDet e WHERE e.idClasificador = :idClasificador"),
    @NamedQuery(name = "EspecificaDet.findByDescripcion", query = "SELECT e FROM EspecificaDet e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EspecificaDet.findByAmbito", query = "SELECT e FROM EspecificaDet e WHERE e.ambito = :ambito"),
    @NamedQuery(name = "EspecificaDet.findByEstado", query = "SELECT e FROM EspecificaDet e WHERE e.estado = :estado"),
    @NamedQuery(name = "EspecificaDet.findByExclusivoTp", query = "SELECT e FROM EspecificaDet e WHERE e.exclusivoTp = :exclusivoTp")})
public class EspecificaDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecificaDetPK especificaDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "id_clasificador")
    private String idClasificador;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ambito")
    private Character ambito;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "exclusivo_tp")
    private Character exclusivoTp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especificaDet1")
    private Collection<CalendarioDet> calendarioDetCollection;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_transaccion", referencedColumnName = "tipo_transaccion", insertable = false, updatable = false),
        @JoinColumn(name = "generica", referencedColumnName = "generica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica", referencedColumnName = "subgenerica", insertable = false, updatable = false),
        @JoinColumn(name = "subgenerica_det", referencedColumnName = "subgenerica_det", insertable = false, updatable = false),
        @JoinColumn(name = "especifica", referencedColumnName = "especifica", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Especifica especifica1;

    public EspecificaDet() {
    }

    public EspecificaDet(EspecificaDetPK especificaDetPK) {
        this.especificaDetPK = especificaDetPK;
    }

    public EspecificaDet(EspecificaDetPK especificaDetPK, String idClasificador) {
        this.especificaDetPK = especificaDetPK;
        this.idClasificador = idClasificador;
    }

    public EspecificaDet(String anoEje, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet, String especifica, String especificaDet) {
        this.especificaDetPK = new EspecificaDetPK(anoEje, tipoTransaccion, generica, subgenerica, subgenericaDet, especifica, especificaDet);
    }

    public EspecificaDetPK getEspecificaDetPK() {
        return especificaDetPK;
    }

    public void setEspecificaDetPK(EspecificaDetPK especificaDetPK) {
        this.especificaDetPK = especificaDetPK;
    }

    public String getIdClasificador() {
        return idClasificador;
    }

    public void setIdClasificador(String idClasificador) {
        this.idClasificador = idClasificador;
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

    public Character getExclusivoTp() {
        return exclusivoTp;
    }

    public void setExclusivoTp(Character exclusivoTp) {
        this.exclusivoTp = exclusivoTp;
    }

    @XmlTransient
    public Collection<CalendarioDet> getCalendarioDetCollection() {
        return calendarioDetCollection;
    }

    public void setCalendarioDetCollection(Collection<CalendarioDet> calendarioDetCollection) {
        this.calendarioDetCollection = calendarioDetCollection;
    }

    public Especifica getEspecifica1() {
        return especifica1;
    }

    public void setEspecifica1(Especifica especifica1) {
        this.especifica1 = especifica1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especificaDetPK != null ? especificaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecificaDet)) {
            return false;
        }
        EspecificaDet other = (EspecificaDet) object;
        if ((this.especificaDetPK == null && other.especificaDetPK != null) || (this.especificaDetPK != null && !this.especificaDetPK.equals(other.especificaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.EspecificaDet[ especificaDetPK=" + especificaDetPK + " ]";
    }
    
}
