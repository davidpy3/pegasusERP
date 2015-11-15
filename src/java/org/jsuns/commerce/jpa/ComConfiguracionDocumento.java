/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_configuracion_documento")
@NamedQueries({
    @NamedQuery(name = "ComConfiguracionDocumento.findAll", query = "SELECT c FROM ComConfiguracionDocumento c")})
public class ComConfiguracionDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComConfiguracionDocumentoPK comConfiguracionDocumentoPK;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "serie")
    private Integer serie;

    public ComConfiguracionDocumento() {
    }

    public ComConfiguracionDocumento(ComConfiguracionDocumentoPK comConfiguracionDocumentoPK) {
        this.comConfiguracionDocumentoPK = comConfiguracionDocumentoPK;
    }

    public ComConfiguracionDocumento(int idSucursal, int idTipoDocumento) {
        this.comConfiguracionDocumentoPK = new ComConfiguracionDocumentoPK(idSucursal, idTipoDocumento);
    }

    public ComConfiguracionDocumentoPK getComConfiguracionDocumentoPK() {
        return comConfiguracionDocumentoPK;
    }

    public void setComConfiguracionDocumentoPK(ComConfiguracionDocumentoPK comConfiguracionDocumentoPK) {
        this.comConfiguracionDocumentoPK = comConfiguracionDocumentoPK;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comConfiguracionDocumentoPK != null ? comConfiguracionDocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComConfiguracionDocumento)) {
            return false;
        }
        ComConfiguracionDocumento other = (ComConfiguracionDocumento) object;
        if ((this.comConfiguracionDocumentoPK == null && other.comConfiguracionDocumentoPK != null) || (this.comConfiguracionDocumentoPK != null && !this.comConfiguracionDocumentoPK.equals(other.comConfiguracionDocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComConfiguracionDocumento[ comConfiguracionDocumentoPK=" + comConfiguracionDocumentoPK + " ]";
    }
    
}
