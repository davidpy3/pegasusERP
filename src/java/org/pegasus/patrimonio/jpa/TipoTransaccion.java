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
@Table(name = "tipo_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t"),
    @NamedQuery(name = "TipoTransaccion.findByAnoEje", query = "SELECT t FROM TipoTransaccion t WHERE t.tipoTransaccionPK.anoEje = :anoEje"),
    @NamedQuery(name = "TipoTransaccion.findByTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.tipoTransaccionPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "TipoTransaccion.findByDescripcion", query = "SELECT t FROM TipoTransaccion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoTransaccion.findByEstado", query = "SELECT t FROM TipoTransaccion t WHERE t.estado = :estado")})
public class TipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoTransaccionPK tipoTransaccionPK;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTransaccion1")
    private Collection<Generica> genericaCollection;

    public TipoTransaccion() {
    }

    public TipoTransaccion(TipoTransaccionPK tipoTransaccionPK) {
        this.tipoTransaccionPK = tipoTransaccionPK;
    }

    public TipoTransaccion(String anoEje, Character tipoTransaccion) {
        this.tipoTransaccionPK = new TipoTransaccionPK(anoEje, tipoTransaccion);
    }

    public TipoTransaccionPK getTipoTransaccionPK() {
        return tipoTransaccionPK;
    }

    public void setTipoTransaccionPK(TipoTransaccionPK tipoTransaccionPK) {
        this.tipoTransaccionPK = tipoTransaccionPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Generica> getGenericaCollection() {
        return genericaCollection;
    }

    public void setGenericaCollection(Collection<Generica> genericaCollection) {
        this.genericaCollection = genericaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoTransaccionPK != null ? tipoTransaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.tipoTransaccionPK == null && other.tipoTransaccionPK != null) || (this.tipoTransaccionPK != null && !this.tipoTransaccionPK.equals(other.tipoTransaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoTransaccion[ tipoTransaccionPK=" + tipoTransaccionPK + " ]";
    }
    
}
