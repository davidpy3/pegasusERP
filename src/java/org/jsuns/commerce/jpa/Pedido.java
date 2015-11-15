/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jsuns.app.User;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByFecPed", query = "SELECT p FROM Pedido p WHERE p.fecPed = :fecPed"),
    @NamedQuery(name = "Pedido.findByFecPago", query = "SELECT p FROM Pedido p WHERE p.fecPago = :fecPago"),
    @NamedQuery(name = "Pedido.findByDescuento", query = "SELECT p FROM Pedido p WHERE p.descuento = :descuento"),
    @NamedQuery(name = "Pedido.findByEstPed", query = "SELECT p FROM Pedido p WHERE p.estPed = :estPed"),
    @NamedQuery(name = "Pedido.findBySerieDoc", query = "SELECT p FROM Pedido p WHERE p.serieDoc = :serieDoc"),
    @NamedQuery(name = "Pedido.findByNroDoc", query = "SELECT p FROM Pedido p WHERE p.nroDoc = :nroDoc"),
    @NamedQuery(name = "Pedido.findByAlbaran", query = "SELECT p FROM Pedido p WHERE p.albaran = :albaran"),
    @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Column(name = "fec_ped")
    @Temporal(TemporalType.DATE)
    private Date fecPed;
    @Column(name = "fec_pago")
    @Temporal(TemporalType.DATE)
    private Date fecPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "est_ped")
    private Character estPed;
    @Column(name = "serie_doc")
    private Integer serieDoc;
    @Column(name = "nro_doc")
    private Integer nroDoc;
    @Column(name = "albaran")
    private Integer albaran;
    @Column(name = "total")
    private Double total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Collection<PedidoDetalle> pedidoDetalleCollection;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne(optional = false)
    private SonAlmacen idAlmacen;
    @JoinColumn(name = "cli_doc", referencedColumnName = "nro_doc")
    @ManyToOne
    private Cliente cliDoc;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User nick;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDoc;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecPed;
    }

    public void setFecha(Date fecPed) {
        this.fecPed = fecPed;
    }

    public Date getFechaPago() {
        return fecPago;
    }

    public void setFechaPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Character getEstado() {
        return estPed;
    }

    public void setEstado(Character estPed) {
        this.estPed = estPed;
    }

    public Integer getSerie() {
        return serieDoc;
    }

    public void setSerie(Integer serieDoc) {
        this.serieDoc = serieDoc;
    }

    public Integer getNumero() {
        return nroDoc;
    }

    public void setNumero(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public Integer getAlbaran() {
        return albaran;
    }

    public void setAlbaran(Integer albaran) {
        this.albaran = albaran;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<PedidoDetalle> getPedidoDetalleCollection() {
        return pedidoDetalleCollection;
    }

    public void setPedidoDetalleCollection(Collection<PedidoDetalle> pedidoDetalleCollection) {
        this.pedidoDetalleCollection = pedidoDetalleCollection;
    }

    public SonAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setAlmacen(SonAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public Cliente getCliente() {
        return cliDoc;
    }

    public void setCliente(Cliente cliDoc) {
        this.cliDoc = cliDoc;
    }

    public User getNick() {
        return nick;
    }

    public void setNick(User nick) {
        this.nick = nick;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public TipoDocumento getTipoDoc() {
        return idTipoDoc;
    }

    public void setTipoDoc(TipoDocumento idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
