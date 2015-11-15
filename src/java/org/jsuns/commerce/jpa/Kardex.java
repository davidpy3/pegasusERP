package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.jsuns.commerce.jpa.ComArticulo;

@Entity
@Table(name = "son_kardex")
public class Kardex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kardex")
    private Integer idKardex;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant_ing")
    private BigDecimal cantIng;
    @Column(name = "pre_uni_ing")
    private BigDecimal preUniIng;
    @Column(name = "cant_sal")
    private BigDecimal cantSal;
    @Column(name = "pre_uni_sal")
    private BigDecimal preUniSal;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "nro_doc")
    private String nroDoc;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "doc_nro")
    private String docNro;
    @JoinColumn(name = "id_tipo_mov", referencedColumnName = "id_tipo_mov")
    @ManyToOne
    private TipoMovimiento tipoMovimiento;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private ComArticulo idArticulo;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDoc;
    @JoinColumn(name = "id_almacen", referencedColumnName = "id_almacen")
    @ManyToOne(optional = false)
    private SonAlmacen idAlmacen;

    public Kardex() {
    }

    public Kardex(Integer idKardex) {
        this.idKardex = idKardex;
    }

    public Kardex(Integer idKardex, String docNro) {
        this.idKardex = idKardex;
        this.docNro = docNro;
    }

    public Integer getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(Integer idKardex) {
        this.idKardex = idKardex;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantIng() {
        return cantIng;
    }

    public void setCantIng(BigDecimal cantIng) {
        this.cantIng = cantIng;
    }

    public BigDecimal getPreUniIng() {
        return preUniIng;
    }

    public void setPreUniIng(BigDecimal preUniIng) {
        this.preUniIng = preUniIng;
    }

    public BigDecimal getCantSal() {
        return cantSal;
    }

    public void setCantSal(BigDecimal cantSal) {
        this.cantSal = cantSal;
    }

    public BigDecimal getPreUniSal() {
        return preUniSal;
    }

    public void setPreUniSal(BigDecimal preUniSal) {
        this.preUniSal = preUniSal;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setRucPro(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocNro() {
        return docNro;
    }

    public void setDocNro(String docNro) {
        this.docNro = docNro;
    }

    public TipoMovimiento getIdTipoMov() {
        return tipoMovimiento;
    }

    public void setIdTipoMov(TipoMovimiento idTipoMov) {
        this.tipoMovimiento = idTipoMov;
    }

    public ComArticulo getIdArticulo() {
        return idArticulo;
    }

    public void setArticulo(ComArticulo idArticulo) {
        this.idArticulo = idArticulo;
    }

    public TipoDocumento getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(TipoDocumento idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public SonAlmacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(SonAlmacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKardex != null ? idKardex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.idKardex == null && other.idKardex != null) || (this.idKardex != null && !this.idKardex.equals(other.idKardex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Kardex[ idKardex=" + idKardex + " ]";
    }
    
}
