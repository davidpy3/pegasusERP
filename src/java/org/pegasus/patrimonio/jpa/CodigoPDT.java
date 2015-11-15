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
@Table(name = "Codigo_PDT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoPDT.findAll", query = "SELECT c FROM CodigoPDT c"),
    @NamedQuery(name = "CodigoPDT.findByCodPdt", query = "SELECT c FROM CodigoPDT c WHERE c.codPdt = :codPdt"),
    @NamedQuery(name = "CodigoPDT.findByNombrePdt", query = "SELECT c FROM CodigoPDT c WHERE c.nombrePdt = :nombrePdt")})
public class CodigoPDT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_pdt")
    private String codPdt;
    @Size(max = 150)
    @Column(name = "nombre_pdt")
    private String nombrePdt;

    public CodigoPDT() {
    }

    public CodigoPDT(String codPdt) {
        this.codPdt = codPdt;
    }

    public String getCodPdt() {
        return codPdt;
    }

    public void setCodPdt(String codPdt) {
        this.codPdt = codPdt;
    }

    public String getNombrePdt() {
        return nombrePdt;
    }

    public void setNombrePdt(String nombrePdt) {
        this.nombrePdt = nombrePdt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPdt != null ? codPdt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoPDT)) {
            return false;
        }
        CodigoPDT other = (CodigoPDT) object;
        if ((this.codPdt == null && other.codPdt != null) || (this.codPdt != null && !this.codPdt.equals(other.codPdt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CodigoPDT[ codPdt=" + codPdt + " ]";
    }
    
}
