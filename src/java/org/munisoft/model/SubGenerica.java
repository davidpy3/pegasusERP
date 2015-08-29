/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "subgenerica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubGenerica.findAll", query = "SELECT s FROM SubGenerica s"),
    @NamedQuery(name = "SubGenerica.findByAnoEje", query = "SELECT s FROM SubGenerica s WHERE s.subGenericaPK.anoEje = :anoEje"),
    @NamedQuery(name = "SubGenerica.findByTipoTransaccion", query = "SELECT s FROM SubGenerica s WHERE s.subGenericaPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "SubGenerica.findByGenerica", query = "SELECT s FROM SubGenerica s WHERE s.subGenericaPK.generica = :generica"),
    @NamedQuery(name = "SubGenerica.findBySubgenerica", query = "SELECT s FROM SubGenerica s WHERE s.subGenericaPK.subgenerica = :subgenerica"),
    @NamedQuery(name = "SubGenerica.findByDescripcion", query = "SELECT s FROM SubGenerica s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SubGenerica.findByAmbito", query = "SELECT s FROM SubGenerica s WHERE s.ambito = :ambito"),
    @NamedQuery(name = "SubGenerica.findByEstado", query = "SELECT s FROM SubGenerica s WHERE s.estado = :estado")})
public class SubGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubGenericaPK subGenericaPK;
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
        @JoinColumn(name = "generica", referencedColumnName = "generica", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Generica generica1;

    public SubGenerica() {
    }

    public SubGenerica(SubGenericaPK subGenericaPK) {
        this.subGenericaPK = subGenericaPK;
    }

    public SubGenerica(String anoEje, Character tipoTransaccion, String generica, String subgenerica) {
        this.subGenericaPK = new SubGenericaPK(anoEje, tipoTransaccion, generica, subgenerica);
    }

    public SubGenericaPK getSubGenericaPK() {
        return subGenericaPK;
    }

    public void setSubGenericaPK(SubGenericaPK subGenericaPK) {
        this.subGenericaPK = subGenericaPK;
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

    public Generica getGenerica1() {
        return generica1;
    }

    public void setGenerica1(Generica generica1) {
        this.generica1 = generica1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subGenericaPK != null ? subGenericaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubGenerica)) {
            return false;
        }
        SubGenerica other = (SubGenerica) object;
        if ((this.subGenericaPK == null && other.subGenericaPK != null) || (this.subGenericaPK != null && !this.subGenericaPK.equals(other.subGenericaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.SubGenerica[ subGenericaPK=" + subGenericaPK + " ]";
    }
    
}
