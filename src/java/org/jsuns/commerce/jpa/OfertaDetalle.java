/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.jsuns.commerce.jpa.ComArticulo;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_oferta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaDetalle.findAll", query = "SELECT o FROM OfertaDetalle o"),
    @NamedQuery(name = "OfertaDetalle.findByIdOferta", query = "SELECT o FROM OfertaDetalle o WHERE o.ofertaDetallePK.idOferta = :idOferta"),
    @NamedQuery(name = "OfertaDetalle.findByIdArticulo", query = "SELECT o FROM OfertaDetalle o WHERE o.ofertaDetallePK.idArticulo = :idArticulo"),
    @NamedQuery(name = "OfertaDetalle.findByPrecio", query = "SELECT o FROM OfertaDetalle o WHERE o.precio = :precio"),
    @NamedQuery(name = "OfertaDetalle.findByCantidad", query = "SELECT o FROM OfertaDetalle o WHERE o.ofertaDetallePK.cantidad = :cantidad")})
public class OfertaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OfertaDetallePK ofertaDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_oferta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;

    public OfertaDetalle() {
    }

    public OfertaDetalle(OfertaDetallePK ofertaDetallePK) {
        this.ofertaDetallePK = ofertaDetallePK;
    }

    public OfertaDetalle(int idOferta, int idArticulo, double cantidad) {
        this.ofertaDetallePK = new OfertaDetallePK(idOferta, idArticulo, cantidad);
    }

    public OfertaDetallePK getOfertaDetallePK() {
        return ofertaDetallePK;
    }

    public void setOfertaDetallePK(OfertaDetallePK ofertaDetallePK) {
        this.ofertaDetallePK = ofertaDetallePK;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofertaDetallePK != null ? ofertaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaDetalle)) {
            return false;
        }
        OfertaDetalle other = (OfertaDetalle) object;
        if ((this.ofertaDetallePK == null && other.ofertaDetallePK != null) || (this.ofertaDetallePK != null && !this.ofertaDetallePK.equals(other.ofertaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.OfertaDetalle[ ofertaDetallePK=" + ofertaDetallePK + " ]";
    }
    
}
