/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "sgc_doc_revision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcDocRevision.findAll", query = "SELECT s FROM SgcDocRevision s"),
    @NamedQuery(name = "SgcDocRevision.findByIdDocrev", query = "SELECT s FROM SgcDocRevision s WHERE s.idDocrev = :idDocrev"),
    @NamedQuery(name = "SgcDocRevision.findByIdDoc", query = "SELECT s FROM SgcDocRevision s WHERE s.idDoc = :idDoc"),
    @NamedQuery(name = "SgcDocRevision.findByIdFuente", query = "SELECT s FROM SgcDocRevision s WHERE s.idFuente = :idFuente"),
    @NamedQuery(name = "SgcDocRevision.findByCodigo", query = "SELECT s FROM SgcDocRevision s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "SgcDocRevision.findByFecha", query = "SELECT s FROM SgcDocRevision s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SgcDocRevision.findByPaginas", query = "SELECT s FROM SgcDocRevision s WHERE s.paginas = :paginas"),
    @NamedQuery(name = "SgcDocRevision.findByFilename", query = "SELECT s FROM SgcDocRevision s WHERE s.filename = :filename"),
    @NamedQuery(name = "SgcDocRevision.findByIdCreador", query = "SELECT s FROM SgcDocRevision s WHERE s.idCreador = :idCreador")})
public class SgcDocRevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_docrev")
    private Integer idDocrev;
    @Basic(optional = false)
    @Column(name = "id_doc")
    private int idDoc;
    @Column(name = "id_fuente")
    private Integer idFuente;
    @Column(name = "codigo")
    private Short codigo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Lob
    @Column(name = "revision")
    private String revision;
    @Column(name = "paginas")
    private Integer paginas;
    @Basic(optional = false)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "id_creador")
    private int idCreador;

    public SgcDocRevision() {
    }

    public SgcDocRevision(Integer idDocrev) {
        this.idDocrev = idDocrev;
    }

    public SgcDocRevision(Integer idDocrev, int idDoc, String filename, int idCreador) {
        this.idDocrev = idDocrev;
        this.idDoc = idDoc;
        this.filename = filename;
        this.idCreador = idCreador;
    }

    public Integer getIdDocrev() {
        return idDocrev;
    }

    public void setIdDocrev(Integer idDocrev) {
        this.idDocrev = idDocrev;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(Integer idFuente) {
        this.idFuente = idFuente;
    }

    public Short getCodigo() {
        return codigo;
    }

    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocrev != null ? idDocrev.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcDocRevision)) {
            return false;
        }
        SgcDocRevision other = (SgcDocRevision) object;
        if ((this.idDocrev == null && other.idDocrev != null) || (this.idDocrev != null && !this.idDocrev.equals(other.idDocrev))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcDocRevision[ idDocrev=" + idDocrev + " ]";
    }
    
}
