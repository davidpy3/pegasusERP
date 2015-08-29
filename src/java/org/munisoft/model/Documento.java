/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByAnoEje", query = "SELECT d FROM Documento d WHERE d.documentoPK.anoEje = :anoEje"),
    @NamedQuery(name = "Documento.findByNExpediente", query = "SELECT d FROM Documento d WHERE d.documentoPK.nExpediente = :nExpediente"),
    @NamedQuery(name = "Documento.findByTipoDoc", query = "SELECT d FROM Documento d WHERE d.documentoPK.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Documento.findByNDoc", query = "SELECT d FROM Documento d WHERE d.documentoPK.nDoc = :nDoc"),
    @NamedQuery(name = "Documento.findByCodOficina", query = "SELECT d FROM Documento d WHERE d.documentoPK.codOficina = :codOficina"),
    @NamedQuery(name = "Documento.findByDni", query = "SELECT d FROM Documento d WHERE d.documentoPK.dni = :dni"),
    @NamedQuery(name = "Documento.findByIdCargo", query = "SELECT d FROM Documento d WHERE d.documentoPK.idCargo = :idCargo"),
    @NamedQuery(name = "Documento.findByCodOficinaDes", query = "SELECT d FROM Documento d WHERE d.codOficinaDes = :codOficinaDes"),
    @NamedQuery(name = "Documento.findByDniDes", query = "SELECT d FROM Documento d WHERE d.dniDes = :dniDes"),
    @NamedQuery(name = "Documento.findByIdCargoDes", query = "SELECT d FROM Documento d WHERE d.idCargoDes = :idCargoDes"),
    @NamedQuery(name = "Documento.findByFecha", query = "SELECT d FROM Documento d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Documento.findByNFolios", query = "SELECT d FROM Documento d WHERE d.nFolios = :nFolios"),
    @NamedQuery(name = "Documento.findByAsunto", query = "SELECT d FROM Documento d WHERE d.asunto = :asunto"),
    @NamedQuery(name = "Documento.findByReferencia", query = "SELECT d FROM Documento d WHERE d.referencia = :referencia"),
    @NamedQuery(name = "Documento.findByDetalle", query = "SELECT d FROM Documento d WHERE d.detalle = :detalle"),
    @NamedQuery(name = "Documento.findByObservacion", query = "SELECT d FROM Documento d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "Documento.findByExterior", query = "SELECT d FROM Documento d WHERE d.exterior = :exterior")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPK documentoPK;
    @Size(max = 5)
    @Column(name = "cod_oficina_des")
    private String codOficinaDes;
    @Size(max = 8)
    @Column(name = "dni_des")
    private String dniDes;
    @Column(name = "id_cargo_des")
    private Integer idCargoDes;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "n_folios")
    private Integer nFolios;
    @Size(max = 150)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 200)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 500)
    @Column(name = "detalle")
    private String detalle;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "exterior")
    private Character exterior;
    /*@JoinTable(name = "expediente_det", joinColumns = {
        @JoinColumn(name = "n_expediente", referencedColumnName = "n_expediente"),
        @JoinColumn(name = "tipo_doc", referencedColumnName = "tipo_doc"),
        @JoinColumn(name = "n_doc", referencedColumnName = "n_doc"),
        @JoinColumn(name = "cod_oficina", referencedColumnName = "cod_oficina"),
        @JoinColumn(name = "dni", referencedColumnName = "dni"),
        @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")}, inverseJoinColumns = {
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje"),
        @JoinColumn(name = "n_expediente", referencedColumnName = "n_expediente")})
    @ManyToMany
    private Collection<Expediente> expedienteCollection;*/

    public Documento() {
    }

    public Documento(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(String anoEje, long nExpediente, int tipoDoc, int nDoc, String codOficina, String dni, int idCargo) {
        this.documentoPK = new DocumentoPK(anoEje, nExpediente, tipoDoc, nDoc, codOficina, dni, idCargo);
    }

    public DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public String getCodOficinaDes() {
        return codOficinaDes;
    }

    public void setCodOficinaDes(String codOficinaDes) {
        this.codOficinaDes = codOficinaDes;
    }

    public String getDniDes() {
        return dniDes;
    }

    public void setDniDes(String dniDes) {
        this.dniDes = dniDes;
    }

    public Integer getIdCargoDes() {
        return idCargoDes;
    }

    public void setIdCargoDes(Integer idCargoDes) {
        this.idCargoDes = idCargoDes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNFolios() {
        return nFolios;
    }

    public void setNFolios(Integer nFolios) {
        this.nFolios = nFolios;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getExterior() {
        return exterior;
    }

    public void setExterior(Character exterior) {
        this.exterior = exterior;
    }
/*
    @XmlTransient
    public Collection<Expediente> getExpedienteCollection() {
        return expedienteCollection;
    }

    public void setExpedienteCollection(Collection<Expediente> expedienteCollection) {
        this.expedienteCollection = expedienteCollection;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
