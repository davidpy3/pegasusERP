/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_promociones_doc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscPromocionesDoc.findAll", query = "SELECT e FROM EscPromocionesDoc e"),
    @NamedQuery(name = "EscPromocionesDoc.findByIdProd", query = "SELECT e FROM EscPromocionesDoc e WHERE e.idProd = :idProd"),
    @NamedQuery(name = "EscPromocionesDoc.findByFechaProm", query = "SELECT e FROM EscPromocionesDoc e WHERE e.fechaProm = :fechaProm"),
    @NamedQuery(name = "EscPromocionesDoc.findByIdDtra", query = "SELECT e FROM EscPromocionesDoc e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscPromocionesDoc.findByEstado", query = "SELECT e FROM EscPromocionesDoc e WHERE e.estado = :estado"),
    @NamedQuery(name = "EscPromocionesDoc.findByFechaFin", query = "SELECT e FROM EscPromocionesDoc e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EscPromocionesDoc.findByHoras", query = "SELECT e FROM EscPromocionesDoc e WHERE e.horas = :horas")})
public class EscPromocionesDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_prod")
    private Integer idProd;
    @Basic(optional = false)
    @Column(name = "fecha_prom")
    @Temporal(TemporalType.DATE)
    private Date fechaProm;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "horas")
    private Short horas;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCapDocente escCapDocente;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_tp", referencedColumnName = "id_tp")
    @ManyToOne(optional = false)
    private EscTipoPromocion idTp;

    public EscPromocionesDoc() {
    }

    public EscPromocionesDoc(Integer idProd) {
        this.idProd = idProd;
    }

    public EscPromocionesDoc(Integer idProd, Date fechaProm, String idDtra, boolean estado) {
        this.idProd = idProd;
        this.fechaProm = fechaProm;
        this.idDtra = idDtra;
        this.estado = estado;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public Date getFechaProm() {
        return fechaProm;
    }

    public void setFechaProm(Date fechaProm) {
        this.fechaProm = fechaProm;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public EscCapDocente getEscCapDocente() {
        return escCapDocente;
    }

    public void setEscCapDocente(EscCapDocente escCapDocente) {
        this.escCapDocente = escCapDocente;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipoPromocion getIdTp() {
        return idTp;
    }

    public void setIdTp(EscTipoPromocion idTp) {
        this.idTp = idTp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPromocionesDoc)) {
            return false;
        }
        EscPromocionesDoc other = (EscPromocionesDoc) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscPromocionesDoc[ idProd=" + idProd + " ]";
    }
    
}
