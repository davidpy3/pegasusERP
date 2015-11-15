/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "esc_meritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscMeritos.findAll", query = "SELECT e FROM EscMeritos e"),
    @NamedQuery(name = "EscMeritos.findByIdDtra", query = "SELECT e FROM EscMeritos e WHERE e.idDtra = :idDtra"),
    @NamedQuery(name = "EscMeritos.findByMencion", query = "SELECT e FROM EscMeritos e WHERE e.mencion = :mencion"),
    @NamedQuery(name = "EscMeritos.findById", query = "SELECT e FROM EscMeritos e WHERE e.id = :id"),
    @NamedQuery(name = "EscMeritos.findByMerito", query = "SELECT e FROM EscMeritos e WHERE e.merito = :merito"),
    @NamedQuery(name = "EscMeritos.findByFechaMer", query = "SELECT e FROM EscMeritos e WHERE e.fechaMer = :fechaMer"),
    @NamedQuery(name = "EscMeritos.findByFechaInicio", query = "SELECT e FROM EscMeritos e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EscMeritos.findByFechaFin", query = "SELECT e FROM EscMeritos e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "EscMeritos.findByMonto", query = "SELECT e FROM EscMeritos e WHERE e.monto = :monto")})
public class EscMeritos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "merito")
    private String merito;
    @Basic(optional = false)
    @Column(name = "fecha_mer")
    @Temporal(TemporalType.DATE)
    private Date fechaMer;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne
    private EscTipoMeritos idTipo;

    public EscMeritos() {
    }

    public EscMeritos(Integer id) {
        this.id = id;
    }

    public EscMeritos(Integer id, String idDtra, String merito, Date fechaMer) {
        this.id = id;
        this.idDtra = idDtra;
        this.merito = merito;
        this.fechaMer = fechaMer;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerito() {
        return merito;
    }

    public void setMerito(String merito) {
        this.merito = merito;
    }

    public Date getFechaMer() {
        return fechaMer;
    }

    public void setFechaMer(Date fechaMer) {
        this.fechaMer = fechaMer;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipoMeritos getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(EscTipoMeritos idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscMeritos)) {
            return false;
        }
        EscMeritos other = (EscMeritos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscMeritos[ id=" + id + " ]";
    }
    
}
