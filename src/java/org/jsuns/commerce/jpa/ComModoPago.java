/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_modo_pago")
@NamedQueries({
    @NamedQuery(name = "ComModoPago.findAll", query = "SELECT c FROM ComModoPago c")})
public class ComModoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "id_modo_pago")
    private String idModoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modo_pago")
    private String modoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente")
    private boolean cliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "referencia")
    private boolean referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defecto")
    private boolean defecto;

    public ComModoPago() {
    }

    public ComModoPago(String idModoPago) {
        this.idModoPago = idModoPago;
    }

    public ComModoPago(String idModoPago, String modoPago, boolean cliente, boolean referencia, boolean defecto) {
        this.idModoPago = idModoPago;
        this.modoPago = modoPago;
        this.cliente = cliente;
        this.referencia = referencia;
        this.defecto = defecto;
    }

    public String getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(String idModoPago) {
        this.idModoPago = idModoPago;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public boolean getCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        this.cliente = cliente;
    }

    public boolean getReferencia() {
        return referencia;
    }

    public void setReferencia(boolean referencia) {
        this.referencia = referencia;
    }

    public boolean getDefecto() {
        return defecto;
    }

    public void setDefecto(boolean defecto) {
        this.defecto = defecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModoPago != null ? idModoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComModoPago)) {
            return false;
        }
        ComModoPago other = (ComModoPago) object;
        if ((this.idModoPago == null && other.idModoPago != null) || (this.idModoPago != null && !this.idModoPago.equals(other.idModoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComModoPago[ idModoPago=" + idModoPago + " ]";
    }
    
}
