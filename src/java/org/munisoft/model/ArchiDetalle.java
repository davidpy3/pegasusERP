/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "archi_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArchiDetalle.findAll", query = "SELECT a FROM ArchiDetalle a"),
    @NamedQuery(name = "ArchiDetalle.findByAnoEje", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.anoEje = :anoEje"),
    @NamedQuery(name = "ArchiDetalle.findByNArchivador", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.nArchivador = :nArchivador"),
    @NamedQuery(name = "ArchiDetalle.findByNSiaf", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.nSiaf = :nSiaf"),
    @NamedQuery(name = "ArchiDetalle.findByFtoFinanc", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.ftoFinanc = :ftoFinanc"),
    @NamedQuery(name = "ArchiDetalle.findByAnoComprob", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.anoComprob = :anoComprob"),
    @NamedQuery(name = "ArchiDetalle.findByNComprob", query = "SELECT a FROM ArchiDetalle a WHERE a.archiDetallePK.nComprob = :nComprob"),
    @NamedQuery(name = "ArchiDetalle.findBySecFunc", query = "SELECT a FROM ArchiDetalle a WHERE a.secFunc = :secFunc"),
    @NamedQuery(name = "ArchiDetalle.findByMonto", query = "SELECT a FROM ArchiDetalle a WHERE a.monto = :monto"),
    @NamedQuery(name = "ArchiDetalle.findByTipoDocu", query = "SELECT a FROM ArchiDetalle a WHERE a.tipoDocu = :tipoDocu"),
    @NamedQuery(name = "ArchiDetalle.findByNDoc", query = "SELECT a FROM ArchiDetalle a WHERE a.nDoc = :nDoc"),
    @NamedQuery(name = "ArchiDetalle.findByRuc", query = "SELECT a FROM ArchiDetalle a WHERE a.ruc = :ruc"),
    @NamedQuery(name = "ArchiDetalle.findByDni", query = "SELECT a FROM ArchiDetalle a WHERE a.dni = :dni"),
    @NamedQuery(name = "ArchiDetalle.findByOtro", query = "SELECT a FROM ArchiDetalle a WHERE a.otro = :otro"),
    @NamedQuery(name = "ArchiDetalle.findByEstado", query = "SELECT a FROM ArchiDetalle a WHERE a.estado = :estado")})
public class ArchiDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArchiDetallePK archiDetallePK;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Size(max = 2)
    @Column(name = "tipo_docu")
    private String tipoDocu;
    @Column(name = "n_doc")
    private Integer nDoc;
    @Size(max = 11)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 8)
    @Column(name = "dni")
    private String dni;
    @Size(max = 80)
    @Column(name = "otro")
    private String otro;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "n_archivador", referencedColumnName = "n_archivador", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Archivador archivador;

    public ArchiDetalle() {
    }

    public ArchiDetalle(ArchiDetallePK archiDetallePK) {
        this.archiDetallePK = archiDetallePK;
    }

    public ArchiDetalle(String anoEje, int nArchivador, int nSiaf, String ftoFinanc, String anoComprob, int nComprob) {
        this.archiDetallePK = new ArchiDetallePK(anoEje, nArchivador, nSiaf, ftoFinanc, anoComprob, nComprob);
    }

    public ArchiDetallePK getArchiDetallePK() {
        return archiDetallePK;
    }

    public void setArchiDetallePK(ArchiDetallePK archiDetallePK) {
        this.archiDetallePK = archiDetallePK;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public Integer getNDoc() {
        return nDoc;
    }

    public void setNDoc(Integer nDoc) {
        this.nDoc = nDoc;
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

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Archivador getArchivador() {
        return archivador;
    }

    public void setArchivador(Archivador archivador) {
        this.archivador = archivador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (archiDetallePK != null ? archiDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchiDetalle)) {
            return false;
        }
        ArchiDetalle other = (ArchiDetalle) object;
        if ((this.archiDetallePK == null && other.archiDetallePK != null) || (this.archiDetallePK != null && !this.archiDetallePK.equals(other.archiDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ArchiDetalle[ archiDetallePK=" + archiDetallePK + " ]";
    }
    
}
