/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

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
@Table(name = "Cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIDcargo", query = "SELECT c FROM Cargo c WHERE c.iDcargo = :iDcargo"),
    @NamedQuery(name = "Cargo.findByCodPdt", query = "SELECT c FROM Cargo c WHERE c.codPdt = :codPdt"),
    @NamedQuery(name = "Cargo.findByNomCargo", query = "SELECT c FROM Cargo c WHERE c.nomCargo = :nomCargo"),
    @NamedQuery(name = "Cargo.findByNivel", query = "SELECT c FROM Cargo c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "Cargo.findByOrdenFirma", query = "SELECT c FROM Cargo c WHERE c.ordenFirma = :ordenFirma"),
    @NamedQuery(name = "Cargo.findByAbreviatura", query = "SELECT c FROM Cargo c WHERE c.abreviatura = :abreviatura"),
    @NamedQuery(name = "Cargo.findByAbrev", query = "SELECT c FROM Cargo c WHERE c.abrev = :abrev"),
    @NamedQuery(name = "Cargo.findByEstado", query = "SELECT c FROM Cargo c WHERE c.estado = :estado")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_cargo")
    private Integer iDcargo;
    @Size(max = 6)
    @Column(name = "cod_pdt")
    private String codPdt;
    @Size(max = 70)
    @Column(name = "nom_cargo")
    private String nomCargo;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "orden_firma")
    private Integer ordenFirma;
    @Size(max = 15)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Size(max = 50)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "estado")
    private Character estado;

    public Cargo() {
    }

    public Cargo(Integer iDcargo) {
        this.iDcargo = iDcargo;
    }

    public Integer getIDcargo() {
        return iDcargo;
    }

    public void setIDcargo(Integer iDcargo) {
        this.iDcargo = iDcargo;
    }

    public String getCodPdt() {
        return codPdt;
    }

    public void setCodPdt(String codPdt) {
        this.codPdt = codPdt;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOrdenFirma() {
        return ordenFirma;
    }

    public void setOrdenFirma(Integer ordenFirma) {
        this.ordenFirma = ordenFirma;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcargo != null ? iDcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.iDcargo == null && other.iDcargo != null) || (this.iDcargo != null && !this.iDcargo.equals(other.iDcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Cargo[ iDcargo=" + iDcargo + " ]";
    }
    
}
