/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Embeddable
public class ComConfiguracionDocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal")
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;

    public ComConfiguracionDocumentoPK() {
    }

    public ComConfiguracionDocumentoPK(int idSucursal, int idTipoDocumento) {
        this.idSucursal = idSucursal;
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSucursal;
        hash += (int) idTipoDocumento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComConfiguracionDocumentoPK)) {
            return false;
        }
        ComConfiguracionDocumentoPK other = (ComConfiguracionDocumentoPK) object;
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if (this.idTipoDocumento != other.idTipoDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComConfiguracionDocumentoPK[ idSucursal=" + idSucursal + ", idTipoDocumento=" + idTipoDocumento + " ]";
    }
    
}
