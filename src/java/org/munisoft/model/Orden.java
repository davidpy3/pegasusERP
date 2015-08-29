/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByAnoEje", query = "SELECT o FROM Orden o WHERE o.ordenPK.anoEje = :anoEje"),
    @NamedQuery(name = "Orden.findByNOrden", query = "SELECT o FROM Orden o WHERE o.ordenPK.nOrden = :nOrden"),
    @NamedQuery(name = "Orden.findByTipo", query = "SELECT o FROM Orden o WHERE o.ordenPK.tipo = :tipo"),
    @NamedQuery(name = "Orden.findByCodDoc", query = "SELECT o FROM Orden o WHERE o.codDoc = :codDoc"),
    @NamedQuery(name = "Orden.findByNumDoc", query = "SELECT o FROM Orden o WHERE o.numDoc = :numDoc"),
    @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Orden.findBySecFunc", query = "SELECT o FROM Orden o WHERE o.secFunc = :secFunc"),
    @NamedQuery(name = "Orden.findByFuenteFinanc", query = "SELECT o FROM Orden o WHERE o.fuenteFinanc = :fuenteFinanc"),
    @NamedQuery(name = "Orden.findByRUCprov", query = "SELECT o FROM Orden o WHERE o.rUCprov = :rUCprov"),
    @NamedQuery(name = "Orden.findByCondiciones", query = "SELECT o FROM Orden o WHERE o.condiciones = :condiciones"),
    @NamedQuery(name = "Orden.findByRUCfact", query = "SELECT o FROM Orden o WHERE o.rUCfact = :rUCfact"),
    @NamedQuery(name = "Orden.findByTotal", query = "SELECT o FROM Orden o WHERE o.total = :total"),
    @NamedQuery(name = "Orden.findByJustificacion", query = "SELECT o FROM Orden o WHERE o.justificacion = :justificacion"),
    @NamedQuery(name = "Orden.findByEstado", query = "SELECT o FROM Orden o WHERE o.estado = :estado"),
    @NamedQuery(name = "Orden.findByEstCont", query = "SELECT o FROM Orden o WHERE o.estCont = :estCont"),
    @NamedQuery(name = "Orden.findByNRegSiaf", query = "SELECT o FROM Orden o WHERE o.nRegSiaf = :nRegSiaf"),
    @NamedQuery(name = "Orden.findByObservaciones", query = "SELECT o FROM Orden o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "Orden.findByFechComp", query = "SELECT o FROM Orden o WHERE o.fechComp = :fechComp"),
    @NamedQuery(name = "Orden.findByReferencia", query = "SELECT o FROM Orden o WHERE o.referencia = :referencia"),
    @NamedQuery(name = "Orden.findByAnoRequer", query = "SELECT o FROM Orden o WHERE o.anoRequer = :anoRequer"),
    @NamedQuery(name = "Orden.findByFechaAnul", query = "SELECT o FROM Orden o WHERE o.fechaAnul = :fechaAnul")})
public class Orden implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenPK ordenPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_doc")
    private String codDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_doc")
    private String numDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUC_prov")
    private String rUCprov;
    @Size(max = 1000)
    @Column(name = "condiciones")
    private String condiciones;
    @Size(max = 11)
    @Column(name = "RUC_fact")
    private String rUCfact;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Size(max = 400)
    @Column(name = "justificacion")
    private String justificacion;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "est_cont")
    private Character estCont;
    @Column(name = "n_reg_siaf")
    private Integer nRegSiaf;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fech_comp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechComp;
    @Size(max = 50)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 4)
    @Column(name = "ano_requer")
    private String anoRequer;
    @Column(name = "fecha_anul")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnul;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private Collection<OrdenDet> ordenDetCollection;

    public Orden() {
    }

    public Orden(OrdenPK ordenPK) {
        this.ordenPK = ordenPK;
    }

    public Orden(OrdenPK ordenPK, String codDoc, String numDoc, Date fecha, String secFunc, String fuenteFinanc, String rUCprov) {
        this.ordenPK = ordenPK;
        this.codDoc = codDoc;
        this.numDoc = numDoc;
        this.fecha = fecha;
        this.secFunc = secFunc;
        this.fuenteFinanc = fuenteFinanc;
        this.rUCprov = rUCprov;
    }

    public Orden(String anoEje, int nOrden, Character tipo) {
        this.ordenPK = new OrdenPK(anoEje, nOrden, tipo);
    }

    public OrdenPK getOrdenPK() {
        return ordenPK;
    }

    public void setOrdenPK(OrdenPK ordenPK) {
        this.ordenPK = ordenPK;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getRUCprov() {
        return rUCprov;
    }

    public void setRUCprov(String rUCprov) {
        this.rUCprov = rUCprov;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getRUCfact() {
        return rUCfact;
    }

    public void setRUCfact(String rUCfact) {
        this.rUCfact = rUCfact;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getEstCont() {
        return estCont;
    }

    public void setEstCont(Character estCont) {
        this.estCont = estCont;
    }

    public Integer getNRegSiaf() {
        return nRegSiaf;
    }

    public void setNRegSiaf(Integer nRegSiaf) {
        this.nRegSiaf = nRegSiaf;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechComp() {
        return fechComp;
    }

    public void setFechComp(Date fechComp) {
        this.fechComp = fechComp;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getAnoRequer() {
        return anoRequer;
    }

    public void setAnoRequer(String anoRequer) {
        this.anoRequer = anoRequer;
    }

    public Date getFechaAnul() {
        return fechaAnul;
    }

    public void setFechaAnul(Date fechaAnul) {
        this.fechaAnul = fechaAnul;
    }

    @XmlTransient
    public Collection<OrdenDet> getOrdenDetCollection() {
        return ordenDetCollection;
    }

    public void setOrdenDetCollection(Collection<OrdenDet> ordenDetCollection) {
        this.ordenDetCollection = ordenDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenPK != null ? ordenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.ordenPK == null && other.ordenPK != null) || (this.ordenPK != null && !this.ordenPK.equals(other.ordenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Orden[ ordenPK=" + ordenPK + " ]";
    }
    
}
