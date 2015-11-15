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

/**
 *
 * @author Jorik
 */
@Embeddable
public class AlmacenDocumentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private int idAlmacen;
    @Basic(optional = false)
    @Column(name = "id_tipo_doc")
    private int idTipoDoc;

    public AlmacenDocumentoPK() {
    }

    public AlmacenDocumentoPK(int idAlmacen, int idTipoDoc) {
        this.idAlmacen = idAlmacen;
        this.idTipoDoc = idTipoDoc;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlmacen;
        hash += (int) idTipoDoc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmacenDocumentoPK)) {
            return false;
        }
        AlmacenDocumentoPK other = (AlmacenDocumentoPK) object;
        if (this.idAlmacen != other.idAlmacen) {
            return false;
        }
        if (this.idTipoDoc != other.idTipoDoc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.AlmacenDocumentoPK[ idAlmacen=" + idAlmacen + ", idTipoDoc=" + idTipoDoc + " ]";
    }
    
}
