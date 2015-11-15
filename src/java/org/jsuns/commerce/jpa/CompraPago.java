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
import javax.persistence.JoinColumn;
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
@Table(name = "son_compra_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraPago.findAll", query = "SELECT c FROM CompraPago c"),
    @NamedQuery(name = "CompraPago.findByIdPago", query = "SELECT c FROM CompraPago c WHERE c.idPago = :idPago"),
    @NamedQuery(name = "CompraPago.findByFecPago", query = "SELECT c FROM CompraPago c WHERE c.fecPago = :fecPago"),
    @NamedQuery(name = "CompraPago.findByMonto", query = "SELECT c FROM CompraPago c WHERE c.monto = :monto"),
    @NamedQuery(name = "CompraPago.findByFecVenc", query = "SELECT c FROM CompraPago c WHERE c.fecVenc = :fecVenc"),
    @NamedQuery(name = "CompraPago.findByEstado", query = "SELECT c FROM CompraPago c WHERE c.estado = :estado")})
public class CompraPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Column(name = "fec_pago")
    @Temporal(TemporalType.DATE)
    private Date fecPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Basic(optional = false)
    @Column(name = "fec_venc")
    @Temporal(TemporalType.DATE)
    private Date fecVenc;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    @ManyToOne(optional = false)
    private Compra idCompra;

    public CompraPago() {
    }

    public CompraPago(Integer idPago) {
        this.idPago = idPago;
    }

    public CompraPago(Integer idPago, Date fecVenc, int estado) {
        this.idPago = idPago;
        this.fecVenc = fecVenc;
        this.estado = estado;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecVenc() {
        return fecVenc;
    }

    public void setFecVenc(Date fecVenc) {
        this.fecVenc = fecVenc;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPago)) {
            return false;
        }
        CompraPago other = (CompraPago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.CompraPago[ idPago=" + idPago + " ]";
    }
    
}
