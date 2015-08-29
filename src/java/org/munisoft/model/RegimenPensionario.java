/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "regimen_pensionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegimenPensionario.findAll", query = "SELECT r FROM RegimenPensionario r"),
    @NamedQuery(name = "RegimenPensionario.findByRegPension", query = "SELECT r FROM RegimenPensionario r WHERE r.regPension = :regPension"),
    @NamedQuery(name = "RegimenPensionario.findByNombre", query = "SELECT r FROM RegimenPensionario r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RegimenPensionario.findByAbrev", query = "SELECT r FROM RegimenPensionario r WHERE r.abrev = :abrev"),
    @NamedQuery(name = "RegimenPensionario.findByAfpnet", query = "SELECT r FROM RegimenPensionario r WHERE r.afpnet = :afpnet"),
    @NamedQuery(name = "RegimenPensionario.findByAporte", query = "SELECT r FROM RegimenPensionario r WHERE r.aporte = :aporte"),
    @NamedQuery(name = "RegimenPensionario.findByPrima", query = "SELECT r FROM RegimenPensionario r WHERE r.prima = :prima"),
    @NamedQuery(name = "RegimenPensionario.findByComision", query = "SELECT r FROM RegimenPensionario r WHERE r.comision = :comision")})
public class RegimenPensionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "reg_pension")
    private String regPension;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "abrev")
    private String abrev;
    @Size(max = 2)
    @Column(name = "afpnet")
    private String afpnet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aporte")
    private BigDecimal aporte;
    @Column(name = "prima")
    private BigDecimal prima;
    @Column(name = "comision")
    private BigDecimal comision;

    public RegimenPensionario() {
    }

    public RegimenPensionario(String regPension) {
        this.regPension = regPension;
    }

    public String getRegPension() {
        return regPension;
    }

    public void setRegPension(String regPension) {
        this.regPension = regPension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getAfpnet() {
        return afpnet;
    }

    public void setAfpnet(String afpnet) {
        this.afpnet = afpnet;
    }

    public BigDecimal getAporte() {
        return aporte;
    }

    public void setAporte(BigDecimal aporte) {
        this.aporte = aporte;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regPension != null ? regPension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimenPensionario)) {
            return false;
        }
        RegimenPensionario other = (RegimenPensionario) object;
        if ((this.regPension == null && other.regPension != null) || (this.regPension != null && !this.regPension.equals(other.regPension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RegimenPensionario[ regPension=" + regPension + " ]";
    }
    
}
