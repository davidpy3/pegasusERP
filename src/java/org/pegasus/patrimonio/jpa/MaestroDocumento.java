/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "maestro_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaestroDocumento.findAll", query = "SELECT m FROM MaestroDocumento m"),
    @NamedQuery(name = "MaestroDocumento.findByCodDoc", query = "SELECT m FROM MaestroDocumento m WHERE m.codDoc = :codDoc"),
    @NamedQuery(name = "MaestroDocumento.findByNombre", query = "SELECT m FROM MaestroDocumento m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MaestroDocumento.findByAbreviatura", query = "SELECT m FROM MaestroDocumento m WHERE m.abreviatura = :abreviatura"),
    @NamedQuery(name = "MaestroDocumento.findByEstado", query = "SELECT m FROM MaestroDocumento m WHERE m.estado = :estado"),
    @NamedQuery(name = "MaestroDocumento.findByFlgTramite", query = "SELECT m FROM MaestroDocumento m WHERE m.flgTramite = :flgTramite")})
public class MaestroDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_doc")
    private String codDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Column(name = "flg_tramite")
    private Character flgTramite;

    public MaestroDocumento() {
    }

    public MaestroDocumento(String codDoc) {
        this.codDoc = codDoc;
    }

    public MaestroDocumento(String codDoc, String nombre, String abreviatura, Character estado) {
        this.codDoc = codDoc;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.estado = estado;
    }

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getFlgTramite() {
        return flgTramite;
    }

    public void setFlgTramite(Character flgTramite) {
        this.flgTramite = flgTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDoc != null ? codDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaestroDocumento)) {
            return false;
        }
        MaestroDocumento other = (MaestroDocumento) object;
        if ((this.codDoc == null && other.codDoc != null) || (this.codDoc != null && !this.codDoc.equals(other.codDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.MaestroDocumento[ codDoc=" + codDoc + " ]";
    }
    
}
