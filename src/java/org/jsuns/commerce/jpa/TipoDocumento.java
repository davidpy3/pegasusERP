/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "son_tipo_doc")
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_doc")
    private Integer idTipoDoc;
    @Column(name = "desc_tipd")
    private String descTipd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDoc")
    private Collection<Compra> compraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDoc")
    private Collection<AlmacenDocumento> almacenDocumentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDoc")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDoc")
    private Collection<Kardex> kardexCollection;

    public TipoDocumento(){}

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getDescripcion() {
        return descTipd;
    }

    public void setDescripcion(String descTipd) {
        this.descTipd = descTipd;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<AlmacenDocumento> getAlmacenDocumentoCollection() {
        return almacenDocumentoCollection;
    }

    public void setAlmacenDocumentoCollection(Collection<AlmacenDocumento> almacenDocumentoCollection) {
        this.almacenDocumentoCollection = almacenDocumentoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Kardex> getKardexCollection() {
        return kardexCollection;
    }

    public void setKardexCollection(Collection<Kardex> kardexCollection) {
        this.kardexCollection = kardexCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDoc != null ? idTipoDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipoDoc == null && other.idTipoDoc != null) || (this.idTipoDoc != null && !this.idTipoDoc.equals(other.idTipoDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.TipoDoc[ idTipoDoc=" + idTipoDoc + " ]";
    }
    
}
