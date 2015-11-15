/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_orden_servicio")
@NamedQueries({
    @NamedQuery(name = "ComOrdenServicio.findAll", query = "SELECT c FROM ComOrdenServicio c")})
public class ComOrdenServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_servicio")
    private Integer idOrdenServicio;
    @Column(name = "correlativo")
    private Integer correlativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Column(name = "id_dir_proveedor")
    private Integer idDirProveedor;
    @Column(name = "id_fuente_financiamiento")
    private Integer idFuenteFinanciamiento;
    @Column(name = "id_programa")
    private Integer idPrograma;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "numero")
    private Long numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tasa_impuesto")
    private Float tasaImpuesto;
    @Column(name = "impuesto")
    private Float impuesto;
    @Column(name = "sub_total")
    private Float subTotal;
    @Column(name = "total")
    private Float total;
    @Size(max = 80)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "id_dir_update")
    private Integer idDirUpdate;

    public ComOrdenServicio() {
    }

    public ComOrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public ComOrdenServicio(Integer idOrdenServicio, int idDep) {
        this.idOrdenServicio = idOrdenServicio;
        this.idDep = idDep;
    }

    public Integer getIdOrdenServicio() {
        return idOrdenServicio;
    }

    public void setIdOrdenServicio(Integer idOrdenServicio) {
        this.idOrdenServicio = idOrdenServicio;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public Integer getIdDirProveedor() {
        return idDirProveedor;
    }

    public void setIdDirProveedor(Integer idDirProveedor) {
        this.idDirProveedor = idDirProveedor;
    }

    public Integer getIdFuenteFinanciamiento() {
        return idFuenteFinanciamiento;
    }

    public void setIdFuenteFinanciamiento(Integer idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Float getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(Float tasaImpuesto) {
        this.tasaImpuesto = tasaImpuesto;
    }

    public Float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdDirUpdate() {
        return idDirUpdate;
    }

    public void setIdDirUpdate(Integer idDirUpdate) {
        this.idDirUpdate = idDirUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenServicio != null ? idOrdenServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOrdenServicio)) {
            return false;
        }
        ComOrdenServicio other = (ComOrdenServicio) object;
        if ((this.idOrdenServicio == null && other.idOrdenServicio != null) || (this.idOrdenServicio != null && !this.idOrdenServicio.equals(other.idOrdenServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOrdenServicio[ idOrdenServicio=" + idOrdenServicio + " ]";
    }
    
}
