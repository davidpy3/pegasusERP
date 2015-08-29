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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Judicial_Obra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JudicialObra.findAll", query = "SELECT j FROM JudicialObra j"),
    @NamedQuery(name = "JudicialObra.findByDocuiden", query = "SELECT j FROM JudicialObra j WHERE j.judicialObraPK.docuiden = :docuiden"),
    @NamedQuery(name = "JudicialObra.findByDocudem", query = "SELECT j FROM JudicialObra j WHERE j.judicialObraPK.docudem = :docudem"),
    @NamedQuery(name = "JudicialObra.findByNomDeman", query = "SELECT j FROM JudicialObra j WHERE j.nomDeman = :nomDeman"),
    @NamedQuery(name = "JudicialObra.findByDescJudi", query = "SELECT j FROM JudicialObra j WHERE j.descJudi = :descJudi"),
    @NamedQuery(name = "JudicialObra.findByPorcJudi", query = "SELECT j FROM JudicialObra j WHERE j.porcJudi = :porcJudi"),
    @NamedQuery(name = "JudicialObra.findByTipoAbono", query = "SELECT j FROM JudicialObra j WHERE j.tipoAbono = :tipoAbono"),
    @NamedQuery(name = "JudicialObra.findByCuentaAbono", query = "SELECT j FROM JudicialObra j WHERE j.cuentaAbono = :cuentaAbono"),
    @NamedQuery(name = "JudicialObra.findByIndDesc", query = "SELECT j FROM JudicialObra j WHERE j.indDesc = :indDesc"),
    @NamedQuery(name = "JudicialObra.findByEstado", query = "SELECT j FROM JudicialObra j WHERE j.estado = :estado")})
public class JudicialObra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JudicialObraPK judicialObraPK;
    @Size(max = 100)
    @Column(name = "nom_deman")
    private String nomDeman;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desc_judi")
    private BigDecimal descJudi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_judi")
    private BigDecimal porcJudi;
    @Column(name = "tipo_abono")
    private Character tipoAbono;
    @Size(max = 50)
    @Column(name = "cuenta_abono")
    private String cuentaAbono;
    @Size(max = 2)
    @Column(name = "ind_desc")
    private String indDesc;
    @Column(name = "estado")
    private Character estado;

    public JudicialObra() {
    }

    public JudicialObra(JudicialObraPK judicialObraPK) {
        this.judicialObraPK = judicialObraPK;
    }

    public JudicialObra(JudicialObraPK judicialObraPK, BigDecimal porcJudi) {
        this.judicialObraPK = judicialObraPK;
        this.porcJudi = porcJudi;
    }

    public JudicialObra(String docuiden, String docudem) {
        this.judicialObraPK = new JudicialObraPK(docuiden, docudem);
    }

    public JudicialObraPK getJudicialObraPK() {
        return judicialObraPK;
    }

    public void setJudicialObraPK(JudicialObraPK judicialObraPK) {
        this.judicialObraPK = judicialObraPK;
    }

    public String getNomDeman() {
        return nomDeman;
    }

    public void setNomDeman(String nomDeman) {
        this.nomDeman = nomDeman;
    }

    public BigDecimal getDescJudi() {
        return descJudi;
    }

    public void setDescJudi(BigDecimal descJudi) {
        this.descJudi = descJudi;
    }

    public BigDecimal getPorcJudi() {
        return porcJudi;
    }

    public void setPorcJudi(BigDecimal porcJudi) {
        this.porcJudi = porcJudi;
    }

    public Character getTipoAbono() {
        return tipoAbono;
    }

    public void setTipoAbono(Character tipoAbono) {
        this.tipoAbono = tipoAbono;
    }

    public String getCuentaAbono() {
        return cuentaAbono;
    }

    public void setCuentaAbono(String cuentaAbono) {
        this.cuentaAbono = cuentaAbono;
    }

    public String getIndDesc() {
        return indDesc;
    }

    public void setIndDesc(String indDesc) {
        this.indDesc = indDesc;
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
        hash += (judicialObraPK != null ? judicialObraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JudicialObra)) {
            return false;
        }
        JudicialObra other = (JudicialObra) object;
        if ((this.judicialObraPK == null && other.judicialObraPK != null) || (this.judicialObraPK != null && !this.judicialObraPK.equals(other.judicialObraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.JudicialObra[ judicialObraPK=" + judicialObraPK + " ]";
    }
    
}
