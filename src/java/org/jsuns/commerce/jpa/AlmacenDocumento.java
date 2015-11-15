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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_almacen_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlmacenDocumento.findAll", query = "SELECT a FROM AlmacenDocumento a"),
    @NamedQuery(name = "AlmacenDocumento.findByIdAlmacen", query = "SELECT a FROM AlmacenDocumento a WHERE a.almacenDocumentoPK.idAlmacen = :idAlmacen"),
    @NamedQuery(name = "AlmacenDocumento.findByIdTipoDoc", query = "SELECT a FROM AlmacenDocumento a WHERE a.almacenDocumentoPK.idTipoDoc = :idTipoDoc"),
    @NamedQuery(name = "AlmacenDocumento.findBySerDoc", query = "SELECT a FROM AlmacenDocumento a WHERE a.serDoc = :serDoc"),
    @NamedQuery(name = "AlmacenDocumento.findByNroDoc", query = "SELECT a FROM AlmacenDocumento a WHERE a.nroDoc = :nroDoc")})
public class AlmacenDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlmacenDocumentoPK almacenDocumentoPK;
    @Column(name = "ser_doc")
    private Integer serDoc;
    @Column(name = "nro_doc")
    private Integer nroDoc;
    @JoinColumn(name = "id_tipo_doc", referencedColumnName = "id_tipo_doc", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDoc;

    public AlmacenDocumento() {
    }

    public AlmacenDocumento(AlmacenDocumentoPK almacenDocumentoPK) {
        this.almacenDocumentoPK = almacenDocumentoPK;
    }

    public AlmacenDocumento(int idAlmacen, int idTipoDoc) {
        this.almacenDocumentoPK = new AlmacenDocumentoPK(idAlmacen, idTipoDoc);
    }

    public AlmacenDocumentoPK getAlmacenDocumentoPK() {
        return almacenDocumentoPK;
    }

    public void setAlmacenDocumentoPK(AlmacenDocumentoPK almacenDocumentoPK) {
        this.almacenDocumentoPK = almacenDocumentoPK;
    }

    public Integer getSerDoc() {
        return serDoc;
    }

    public void setSerDoc(Integer serDoc) {
        this.serDoc = serDoc;
    }

    public Integer getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public TipoDocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almacenDocumentoPK != null ? almacenDocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmacenDocumento)) {
            return false;
        }
        AlmacenDocumento other = (AlmacenDocumento) object;
        if ((this.almacenDocumentoPK == null && other.almacenDocumentoPK != null) || (this.almacenDocumentoPK != null && !this.almacenDocumentoPK.equals(other.almacenDocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.AlmacenDocumento[ almacenDocumentoPK=" + almacenDocumentoPK + " ]";
    }
    
}
