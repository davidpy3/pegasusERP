/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "son_traslado_articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrasladoArticulo.findAll", query = "SELECT t FROM TrasladoArticulo t"),
    @NamedQuery(name = "TrasladoArticulo.findByIdTraslado", query = "SELECT t FROM TrasladoArticulo t WHERE t.trasladoArticuloPK.idTraslado = :idTraslado"),
    @NamedQuery(name = "TrasladoArticulo.findByIdArticulo", query = "SELECT t FROM TrasladoArticulo t WHERE t.trasladoArticuloPK.idArticulo = :idArticulo"),
    @NamedQuery(name = "TrasladoArticulo.findByCant", query = "SELECT t FROM TrasladoArticulo t WHERE t.cant = :cant")})
public class TrasladoArticulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrasladoArticuloPK trasladoArticuloPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant")
    private BigDecimal cant;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
    @JoinColumn(name = "id_traslado", referencedColumnName = "id_traslado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Traslado traslado;

    public TrasladoArticulo() {
    }

    public TrasladoArticulo(TrasladoArticuloPK trasladoArticuloPK) {
        this.trasladoArticuloPK = trasladoArticuloPK;
    }

    public TrasladoArticulo(int idTraslado, int idArticulo) {
        this.trasladoArticuloPK = new TrasladoArticuloPK(idTraslado, idArticulo);
    }

    public TrasladoArticuloPK getTrasladoArticuloPK() {
        return trasladoArticuloPK;
    }

    public void setTrasladoArticuloPK(TrasladoArticuloPK trasladoArticuloPK) {
        this.trasladoArticuloPK = trasladoArticuloPK;
    }

    public BigDecimal getCant() {
        return cant;
    }

    public void setCantidad(BigDecimal cant) {
        this.cant = cant;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trasladoArticuloPK != null ? trasladoArticuloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoArticulo)) {
            return false;
        }
        TrasladoArticulo other = (TrasladoArticulo) object;
        if ((this.trasladoArticuloPK == null && other.trasladoArticuloPK != null) || (this.trasladoArticuloPK != null && !this.trasladoArticuloPK.equals(other.trasladoArticuloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.TrasladoArticulo[ trasladoArticuloPK=" + trasladoArticuloPK + " ]";
    }
    
}
