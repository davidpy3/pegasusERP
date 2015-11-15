package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "alm_movimiento_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlmMovimientoDetalle.findAll", query = "SELECT a FROM AlmMovimientoDetalle a"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByAnoEje", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.anoEje = :anoEje"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByCodAlmacen", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.codAlmacen = :codAlmacen"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByTipoMov", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.tipoMov = :tipoMov"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByNroMov", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.nroMov = :nroMov"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByIdItem", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.idItem = :idItem"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByItem", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.almMovimientoDetallePK.item = :item"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByCantidad", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByPrecioUnitario", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByUnidad", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.unidad = :unidad"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByDivisionaria", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.divisionaria = :divisionaria"),
    @NamedQuery(name = "AlmMovimientoDetalle.findBySecFunc", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.secFunc = :secFunc"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByMarca", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.marca = :marca"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByModelo", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "AlmMovimientoDetalle.findBySerie", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.serie = :serie"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByComentario", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.comentario = :comentario"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByStock", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.stock = :stock"),
    @NamedQuery(name = "AlmMovimientoDetalle.findByCodigoIngreso", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.codigoIngreso = :codigoIngreso"),
    @NamedQuery(name = "AlmMovimientoDetalle.findBySaneado", query = "SELECT a FROM AlmMovimientoDetalle a WHERE a.saneado = :saneado")})
public class AlmMovimientoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlmMovimientoDetallePK almMovimientoDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @Column(name = "unidad")
    private Integer unidad;
    @Size(max = 11)
    @Column(name = "divisionaria")
    private String divisionaria;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Size(max = 20)
    @Column(name = "marca")
    private String marca;
    @Size(max = 20)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 100)
    @Column(name = "serie")
    private String serie;
    @Size(max = 1000)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "stock")
    private BigDecimal stock;
    @Size(max = 13)
    @Column(name = "codigo_ingreso")
    private String codigoIngreso;
    @Column(name = "saneado")
    private Character saneado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "cod_almacen", referencedColumnName = "cod_almacen", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_mov", referencedColumnName = "tipo_mov", insertable = false, updatable = false),
        @JoinColumn(name = "nro_mov", referencedColumnName = "nro_mov", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AlmMovimiento almMovimiento;
    @JoinColumn(name = "cod_almacen", referencedColumnName = "cod_almacen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Almacen almacen;

    public AlmMovimientoDetalle() {
    }

    public AlmMovimientoDetalle(AlmMovimientoDetallePK almMovimientoDetallePK) {
        this.almMovimientoDetallePK = almMovimientoDetallePK;
    }

    public AlmMovimientoDetalle(AlmMovimientoDetallePK almMovimientoDetallePK, BigDecimal cantidad, BigDecimal precioUnitario) {
        this.almMovimientoDetallePK = almMovimientoDetallePK;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public AlmMovimientoDetalle(String anoEje, String codAlmacen, Character tipoMov, int nroMov, String idItem, int item) {
        this.almMovimientoDetallePK = new AlmMovimientoDetallePK(anoEje, codAlmacen, tipoMov, nroMov, idItem, item);
    }

    public AlmMovimientoDetallePK getAlmMovimientoDetallePK() {
        return almMovimientoDetallePK;
    }

    public void setAlmMovimientoDetallePK(AlmMovimientoDetallePK almMovimientoDetallePK) {
        this.almMovimientoDetallePK = almMovimientoDetallePK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public String getDivisionaria() {
        return divisionaria;
    }

    public void setDivisionaria(String divisionaria) {
        this.divisionaria = divisionaria;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getCodigoIngreso() {
        return codigoIngreso;
    }

    public void setCodigoIngreso(String codigoIngreso) {
        this.codigoIngreso = codigoIngreso;
    }

    public Character getSaneado() {
        return saneado;
    }

    public void setSaneado(Character saneado) {
        this.saneado = saneado;
    }

    public AlmMovimiento getAlmMovimiento() {
        return almMovimiento;
    }

    public void setAlmMovimiento(AlmMovimiento almMovimiento) {
        this.almMovimiento = almMovimiento;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almMovimientoDetallePK != null ? almMovimientoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmMovimientoDetalle)) {
            return false;
        }
        AlmMovimientoDetalle other = (AlmMovimientoDetalle) object;
        if ((this.almMovimientoDetallePK == null && other.almMovimientoDetallePK != null) || (this.almMovimientoDetallePK != null && !this.almMovimientoDetallePK.equals(other.almMovimientoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AlmMovimientoDetalle[ almMovimientoDetallePK=" + almMovimientoDetallePK + " ]";
    }
    
}
