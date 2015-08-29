/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "periodos_depreciacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodosDepreciacion.findAll", query = "SELECT p FROM PeriodosDepreciacion p"),
    @NamedQuery(name = "PeriodosDepreciacion.findByCodPeriodo", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.codPeriodo = :codPeriodo"),
    @NamedQuery(name = "PeriodosDepreciacion.findByPeriodo", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.periodo = :periodo"),
    @NamedQuery(name = "PeriodosDepreciacion.findByUserRegistra", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.userRegistra = :userRegistra"),
    @NamedQuery(name = "PeriodosDepreciacion.findByFechaRegistra", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.fechaRegistra = :fechaRegistra"),
    @NamedQuery(name = "PeriodosDepreciacion.findByUserCierre", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.userCierre = :userCierre"),
    @NamedQuery(name = "PeriodosDepreciacion.findByFechaCierre", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "PeriodosDepreciacion.findByEstado", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.estado = :estado"),
    @NamedQuery(name = "PeriodosDepreciacion.findByAnoInv", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.anoInv = :anoInv"),
    @NamedQuery(name = "PeriodosDepreciacion.findByNumInv", query = "SELECT p FROM PeriodosDepreciacion p WHERE p.numInv = :numInv")})
public class PeriodosDepreciacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_periodo")
    private Long codPeriodo;
    @Column(name = "periodo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodo;
    @Size(max = 8)
    @Column(name = "user_registra")
    private String userRegistra;
    @Column(name = "fecha_registra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistra;
    @Size(max = 8)
    @Column(name = "user_cierre")
    private String userCierre;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 4)
    @Column(name = "ANO_INV")
    private String anoInv;
    @Size(max = 4)
    @Column(name = "NUM_INV")
    private String numInv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodosDepreciacion")
    private Collection<DepreciacionBiene> depreciacionBieneCollection;

    public PeriodosDepreciacion() {
    }

    public PeriodosDepreciacion(Long codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Long getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Long codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public String getUserRegistra() {
        return userRegistra;
    }

    public void setUserRegistra(String userRegistra) {
        this.userRegistra = userRegistra;
    }

    public Date getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(Date fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public String getUserCierre() {
        return userCierre;
    }

    public void setUserCierre(String userCierre) {
        this.userCierre = userCierre;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getAnoInv() {
        return anoInv;
    }

    public void setAnoInv(String anoInv) {
        this.anoInv = anoInv;
    }

    public String getNumInv() {
        return numInv;
    }

    public void setNumInv(String numInv) {
        this.numInv = numInv;
    }

    @XmlTransient
    public Collection<DepreciacionBiene> getDepreciacionBieneCollection() {
        return depreciacionBieneCollection;
    }

    public void setDepreciacionBieneCollection(Collection<DepreciacionBiene> depreciacionBieneCollection) {
        this.depreciacionBieneCollection = depreciacionBieneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodosDepreciacion)) {
            return false;
        }
        PeriodosDepreciacion other = (PeriodosDepreciacion) object;
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PeriodosDepreciacion[ codPeriodo=" + codPeriodo + " ]";
    }
    
}
