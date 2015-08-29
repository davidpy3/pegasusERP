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
@Table(name = "cuentac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentac.findAll", query = "SELECT c FROM Cuentac c"),
    @NamedQuery(name = "Cuentac.findByAnoEje", query = "SELECT c FROM Cuentac c WHERE c.anoEje = :anoEje"),
    @NamedQuery(name = "Cuentac.findByCuenta", query = "SELECT c FROM Cuentac c WHERE c.cuenta = :cuenta"),
    @NamedQuery(name = "Cuentac.findByDenomina", query = "SELECT c FROM Cuentac c WHERE c.denomina = :denomina"),
    @NamedQuery(name = "Cuentac.findByTipoCta", query = "SELECT c FROM Cuentac c WHERE c.tipoCta = :tipoCta"),
    @NamedQuery(name = "Cuentac.findByFlagCtaEsp", query = "SELECT c FROM Cuentac c WHERE c.flagCtaEsp = :flagCtaEsp"),
    @NamedQuery(name = "Cuentac.findByTipUsoCta", query = "SELECT c FROM Cuentac c WHERE c.tipUsoCta = :tipUsoCta"),
    @NamedQuery(name = "Cuentac.findByProcentDepre", query = "SELECT c FROM Cuentac c WHERE c.procentDepre = :procentDepre"),
    @NamedQuery(name = "Cuentac.findByFlgPatri", query = "SELECT c FROM Cuentac c WHERE c.flgPatri = :flgPatri"),
    @NamedQuery(name = "Cuentac.findByFlgAlma", query = "SELECT c FROM Cuentac c WHERE c.flgAlma = :flgAlma")})
public class Cuentac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cuenta")
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "denomina")
    private String denomina;
    @Size(max = 20)
    @Column(name = "tipo_cta")
    private String tipoCta;
    @Column(name = "flag_cta_esp")
    private Boolean flagCtaEsp;
    @Column(name = "tip_uso_cta")
    private Character tipUsoCta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "procent_depre")
    private BigDecimal procentDepre;
    @Column(name = "flg_patri")
    private Character flgPatri;
    @Column(name = "flg_alma")
    private Character flgAlma;

    public Cuentac() {
    }

    public Cuentac(String cuenta) {
        this.cuenta = cuenta;
    }

    public Cuentac(String cuenta, String denomina) {
        this.cuenta = cuenta;
        this.denomina = denomina;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDenomina() {
        return denomina;
    }

    public void setDenomina(String denomina) {
        this.denomina = denomina;
    }

    public String getTipoCta() {
        return tipoCta;
    }

    public void setTipoCta(String tipoCta) {
        this.tipoCta = tipoCta;
    }

    public Boolean getFlagCtaEsp() {
        return flagCtaEsp;
    }

    public void setFlagCtaEsp(Boolean flagCtaEsp) {
        this.flagCtaEsp = flagCtaEsp;
    }

    public Character getTipUsoCta() {
        return tipUsoCta;
    }

    public void setTipUsoCta(Character tipUsoCta) {
        this.tipUsoCta = tipUsoCta;
    }

    public BigDecimal getProcentDepre() {
        return procentDepre;
    }

    public void setProcentDepre(BigDecimal procentDepre) {
        this.procentDepre = procentDepre;
    }

    public Character getFlgPatri() {
        return flgPatri;
    }

    public void setFlgPatri(Character flgPatri) {
        this.flgPatri = flgPatri;
    }

    public Character getFlgAlma() {
        return flgAlma;
    }

    public void setFlgAlma(Character flgAlma) {
        this.flgAlma = flgAlma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuenta != null ? cuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentac)) {
            return false;
        }
        Cuentac other = (Cuentac) object;
        if ((this.cuenta == null && other.cuenta != null) || (this.cuenta != null && !this.cuenta.equals(other.cuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Cuentac[ cuenta=" + cuenta + " ]";
    }
    
}
