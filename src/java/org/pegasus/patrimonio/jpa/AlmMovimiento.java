/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "alm_movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlmMovimiento.findAll", query = "SELECT a FROM AlmMovimiento a"),
    @NamedQuery(name = "AlmMovimiento.findByAnoEje", query = "SELECT a FROM AlmMovimiento a WHERE a.almMovimientoPK.anoEje = :anoEje"),
    @NamedQuery(name = "AlmMovimiento.findByCodAlmacen", query = "SELECT a FROM AlmMovimiento a WHERE a.almMovimientoPK.codAlmacen = :codAlmacen"),
    @NamedQuery(name = "AlmMovimiento.findByTipoMov", query = "SELECT a FROM AlmMovimiento a WHERE a.almMovimientoPK.tipoMov = :tipoMov"),
    @NamedQuery(name = "AlmMovimiento.findByNroMov", query = "SELECT a FROM AlmMovimiento a WHERE a.almMovimientoPK.nroMov = :nroMov"),
    @NamedQuery(name = "AlmMovimiento.findByIdDocAlmacen", query = "SELECT a FROM AlmMovimiento a WHERE a.idDocAlmacen = :idDocAlmacen"),
    @NamedQuery(name = "AlmMovimiento.findByNroDocAlmacen", query = "SELECT a FROM AlmMovimiento a WHERE a.nroDocAlmacen = :nroDocAlmacen"),
    @NamedQuery(name = "AlmMovimiento.findByFecha", query = "SELECT a FROM AlmMovimiento a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AlmMovimiento.findByObra", query = "SELECT a FROM AlmMovimiento a WHERE a.obra = :obra"),
    @NamedQuery(name = "AlmMovimiento.findByRuc", query = "SELECT a FROM AlmMovimiento a WHERE a.ruc = :ruc"),
    @NamedQuery(name = "AlmMovimiento.findByDni", query = "SELECT a FROM AlmMovimiento a WHERE a.dni = :dni"),
    @NamedQuery(name = "AlmMovimiento.findByCodOficina", query = "SELECT a FROM AlmMovimiento a WHERE a.codOficina = :codOficina"),
    @NamedQuery(name = "AlmMovimiento.findByDescCargo", query = "SELECT a FROM AlmMovimiento a WHERE a.descCargo = :descCargo"),
    @NamedQuery(name = "AlmMovimiento.findByTipoDoc2", query = "SELECT a FROM AlmMovimiento a WHERE a.tipoDoc2 = :tipoDoc2"),
    @NamedQuery(name = "AlmMovimiento.findByAnoDoc2", query = "SELECT a FROM AlmMovimiento a WHERE a.anoDoc2 = :anoDoc2"),
    @NamedQuery(name = "AlmMovimiento.findByNroDoc2", query = "SELECT a FROM AlmMovimiento a WHERE a.nroDoc2 = :nroDoc2"),
    @NamedQuery(name = "AlmMovimiento.findBySecFunc", query = "SELECT a FROM AlmMovimiento a WHERE a.secFunc = :secFunc"),
    @NamedQuery(name = "AlmMovimiento.findByNFactura", query = "SELECT a FROM AlmMovimiento a WHERE a.nFactura = :nFactura"),
    @NamedQuery(name = "AlmMovimiento.findByIgv", query = "SELECT a FROM AlmMovimiento a WHERE a.igv = :igv"),
    @NamedQuery(name = "AlmMovimiento.findByComentario", query = "SELECT a FROM AlmMovimiento a WHERE a.comentario = :comentario"),
    @NamedQuery(name = "AlmMovimiento.findByTotal", query = "SELECT a FROM AlmMovimiento a WHERE a.total = :total"),
    @NamedQuery(name = "AlmMovimiento.findByUserRegistra", query = "SELECT a FROM AlmMovimiento a WHERE a.userRegistra = :userRegistra"),
    @NamedQuery(name = "AlmMovimiento.findByUserAnula", query = "SELECT a FROM AlmMovimiento a WHERE a.userAnula = :userAnula"),
    @NamedQuery(name = "AlmMovimiento.findByFechaAnula", query = "SELECT a FROM AlmMovimiento a WHERE a.fechaAnula = :fechaAnula"),
    @NamedQuery(name = "AlmMovimiento.findByMotivo", query = "SELECT a FROM AlmMovimiento a WHERE a.motivo = :motivo"),
    @NamedQuery(name = "AlmMovimiento.findByEstado", query = "SELECT a FROM AlmMovimiento a WHERE a.estado = :estado")})
public class AlmMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlmMovimientoPK almMovimientoPK;
    @Column(name = "id_doc_almacen")
    private Integer idDocAlmacen;
    @Column(name = "nro_doc_almacen")
    private Integer nroDocAlmacen;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "obra")
    private Character obra;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 8)
    @Column(name = "dni")
    private String dni;
    @Size(max = 5)
    @Column(name = "cod_oficina")
    private String codOficina;
    @Size(max = 75)
    @Column(name = "desc_cargo")
    private String descCargo;
    @Size(max = 3)
    @Column(name = "tipo_doc2")
    private String tipoDoc2;
    @Size(max = 4)
    @Column(name = "ano_doc2")
    private String anoDoc2;
    @Column(name = "nro_doc2")
    private Integer nroDoc2;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Size(max = 100)
    @Column(name = "n_factura")
    private String nFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "igv")
    private BigDecimal igv;
    @Size(max = 100)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "total")
    private BigDecimal total;
    @Size(max = 8)
    @Column(name = "user_registra")
    private String userRegistra;
    @Size(max = 8)
    @Column(name = "user_anula")
    private String userAnula;
    @Column(name = "fecha_anula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnula;
    @Size(max = 100)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almMovimiento")
    private Collection<AlmMovimientoDetalle> almMovimientoDetalleCollection;

    public AlmMovimiento() {
    }

    public AlmMovimiento(AlmMovimientoPK almMovimientoPK) {
        this.almMovimientoPK = almMovimientoPK;
    }

    public AlmMovimiento(String anoEje, String codAlmacen, Character tipoMov, int nroMov) {
        this.almMovimientoPK = new AlmMovimientoPK(anoEje, codAlmacen, tipoMov, nroMov);
    }

    public AlmMovimientoPK getAlmMovimientoPK() {
        return almMovimientoPK;
    }

    public void setAlmMovimientoPK(AlmMovimientoPK almMovimientoPK) {
        this.almMovimientoPK = almMovimientoPK;
    }

    public Integer getIdDocAlmacen() {
        return idDocAlmacen;
    }

    public void setIdDocAlmacen(Integer idDocAlmacen) {
        this.idDocAlmacen = idDocAlmacen;
    }

    public Integer getNroDocAlmacen() {
        return nroDocAlmacen;
    }

    public void setNroDocAlmacen(Integer nroDocAlmacen) {
        this.nroDocAlmacen = nroDocAlmacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getObra() {
        return obra;
    }

    public void setObra(Character obra) {
        this.obra = obra;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(String codOficina) {
        this.codOficina = codOficina;
    }

    public String getDescCargo() {
        return descCargo;
    }

    public void setDescCargo(String descCargo) {
        this.descCargo = descCargo;
    }

    public String getTipoDoc2() {
        return tipoDoc2;
    }

    public void setTipoDoc2(String tipoDoc2) {
        this.tipoDoc2 = tipoDoc2;
    }

    public String getAnoDoc2() {
        return anoDoc2;
    }

    public void setAnoDoc2(String anoDoc2) {
        this.anoDoc2 = anoDoc2;
    }

    public Integer getNroDoc2() {
        return nroDoc2;
    }

    public void setNroDoc2(Integer nroDoc2) {
        this.nroDoc2 = nroDoc2;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getNFactura() {
        return nFactura;
    }

    public void setNFactura(String nFactura) {
        this.nFactura = nFactura;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getUserRegistra() {
        return userRegistra;
    }

    public void setUserRegistra(String userRegistra) {
        this.userRegistra = userRegistra;
    }

    public String getUserAnula() {
        return userAnula;
    }

    public void setUserAnula(String userAnula) {
        this.userAnula = userAnula;
    }

    public Date getFechaAnula() {
        return fechaAnula;
    }

    public void setFechaAnula(Date fechaAnula) {
        this.fechaAnula = fechaAnula;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<AlmMovimientoDetalle> getAlmMovimientoDetalleCollection() {
        return almMovimientoDetalleCollection;
    }

    public void setAlmMovimientoDetalleCollection(Collection<AlmMovimientoDetalle> almMovimientoDetalleCollection) {
        this.almMovimientoDetalleCollection = almMovimientoDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almMovimientoPK != null ? almMovimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmMovimiento)) {
            return false;
        }
        AlmMovimiento other = (AlmMovimiento) object;
        if ((this.almMovimientoPK == null && other.almMovimientoPK != null) || (this.almMovimientoPK != null && !this.almMovimientoPK.equals(other.almMovimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AlmMovimiento[ almMovimientoPK=" + almMovimientoPK + " ]";
    }
    
}
