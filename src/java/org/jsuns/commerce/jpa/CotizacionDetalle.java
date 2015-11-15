package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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

@Entity
@Table(name = "son_cotizacion_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotizacionDetalle.findAll", query = "SELECT c FROM CotizacionDetalle c"),
    @NamedQuery(name = "CotizacionDetalle.findByIdCotizacion", query = "SELECT c FROM CotizacionDetalle c WHERE c.cotizacionDetallePK.idCotizacion = :idCotizacion"),
    @NamedQuery(name = "CotizacionDetalle.findByIdArticulo", query = "SELECT c FROM CotizacionDetalle c WHERE c.cotizacionDetallePK.idArticulo = :idArticulo"),
    @NamedQuery(name = "CotizacionDetalle.findByCant", query = "SELECT c FROM CotizacionDetalle c WHERE c.cant = :cant"),
    @NamedQuery(name = "CotizacionDetalle.findByPrecioCot", query = "SELECT c FROM CotizacionDetalle c WHERE c.precioCot = :precioCot")})
public class CotizacionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CotizacionDetallePK cotizacionDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cant")
    private BigDecimal cant;
    @Basic(optional = false)
    @Column(name = "precio_cot")
    private BigDecimal precioCot;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;
//    @JoinColumn(name = "id_cotizacion", referencedColumnName = "id_cotizacion", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Cotizacion cotizacion;

    public CotizacionDetalle() {
    }

    public CotizacionDetalle(CotizacionDetallePK cotizacionDetallePK) {
        this.cotizacionDetallePK = cotizacionDetallePK;
    }

    public CotizacionDetalle(CotizacionDetallePK cotizacionDetallePK, BigDecimal cant, BigDecimal precioCot) {
        this.cotizacionDetallePK = cotizacionDetallePK;
        this.cant = cant;
        this.precioCot = precioCot;
    }

    public CotizacionDetalle(int idCotizacion, int idArticulo) {
        this.cotizacionDetallePK = new CotizacionDetallePK(idCotizacion, idArticulo);
    }

    public CotizacionDetallePK getCotizacionDetallePK() {
        return cotizacionDetallePK;
    }

    public void setCotizacionDetallePK(CotizacionDetallePK cotizacionDetallePK) {
        this.cotizacionDetallePK = cotizacionDetallePK;
    }

    public BigDecimal getCant() {
        return cant;
    }

    public void setCant(BigDecimal cant) {
        this.cant = cant;
    }

    public BigDecimal getPrecioCot() {
        return precioCot;
    }

    public void setPrecioCot(BigDecimal precioCot) {
        this.precioCot = precioCot;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

//    public Cotizacion getCotizacion() {
//        return cotizacion;
//    }
//
//    public void setCotizacion(Cotizacion cotizacion) {
//        this.cotizacion = cotizacion;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotizacionDetallePK != null ? cotizacionDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDetalle)) {
            return false;
        }
        CotizacionDetalle other = (CotizacionDetalle) object;
        if ((this.cotizacionDetallePK == null && other.cotizacionDetallePK != null) || (this.cotizacionDetallePK != null && !this.cotizacionDetallePK.equals(other.cotizacionDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.CotizacionDetalle[ cotizacionDetallePK=" + cotizacionDetallePK + " ]";
    }
    
}
