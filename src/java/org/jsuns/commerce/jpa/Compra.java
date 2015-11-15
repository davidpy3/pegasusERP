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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "son_compra")
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra")
    private Integer idCompra;
    @Basic(optional = false)
    @Column(name = "ruc_pro")
    private String rucPro;
    @Column(name = "glosa")
    private String glosa;
    @Column(name = "serie_doc")
    private Integer serieDoc;
    @Column(name = "nro_doc")
    private Integer nroDoc;
    @Column(name = "fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date fechaDoc;
    @Basic(optional = false)
    @Column(name = "id_tipo_pago")
    private int idTipoPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "nick")
    private String nick;
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private int idAlmacen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "tipo_compra")
    private Character tipoCompra;
    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompra")
    private Collection<CompraPago> compraPagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private Collection<CompraDetalle> compraDetalleCollection;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, String rucPro, int idTipoPago, String nick, int idAlmacen, String ruc) {
        this.idCompra = idCompra;
        this.rucPro = rucPro;
        this.idTipoPago = idTipoPago;
        this.nick = nick;
        this.idAlmacen = idAlmacen;
        this.ruc = ruc;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getRucPro() {
        return rucPro;
    }

    public void setRucPro(String rucPro) {
        this.rucPro = rucPro;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
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

    public void setNroDoc(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Character getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(Character tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public TipoDocumento getTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(TipoDocumento idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    @XmlTransient
    public Collection<CompraPago> getCompraPagoCollection() {
        return compraPagoCollection;
    }

    public void setCompraPagoCollection(Collection<CompraPago> compraPagoCollection) {
        this.compraPagoCollection = compraPagoCollection;
    }

    @XmlTransient
    public Collection<CompraDetalle> getCompraDetalleCollection() {
        return compraDetalleCollection;
    }

    public void setCompraDetalleCollection(Collection<CompraDetalle> compraDetalleCollection) {
        this.compraDetalleCollection = compraDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
