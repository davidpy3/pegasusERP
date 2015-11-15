/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_letras_pedido")
public class LetraPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_letra_pedido")
    private Integer idLetraPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;

    public LetraPedido() {
    }

    public LetraPedido(Integer idLetraPedido) {
        this.idLetraPedido = idLetraPedido;
    }

    public LetraPedido(Integer idLetraPedido, int idPedido) {
        this.idLetraPedido = idLetraPedido;
        this.idPedido = idPedido;
    }

    public Integer getIdLetraPedido() {
        return idLetraPedido;
    }

    public void setIdLetraPedido(Integer idLetraPedido) {
        this.idLetraPedido = idLetraPedido;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLetraPedido != null ? idLetraPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LetraPedido)) {
            return false;
        }
        LetraPedido other = (LetraPedido) object;
        if ((this.idLetraPedido == null && other.idLetraPedido != null) || (this.idLetraPedido != null && !this.idLetraPedido.equals(other.idLetraPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.LetrasPedido[ idLetraPedido=" + idLetraPedido + " ]";
    }
    
}
