/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class EspecificaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_transaccion")
    private Character tipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "generica")
    private String generica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "subgenerica")
    private String subgenerica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "subgenerica_det")
    private String subgenericaDet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "especifica")
    private String especifica;

    public EspecificaPK() {
    }

    public EspecificaPK(String anoEje, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet, String especifica) {
        this.anoEje = anoEje;
        this.tipoTransaccion = tipoTransaccion;
        this.generica = generica;
        this.subgenerica = subgenerica;
        this.subgenericaDet = subgenericaDet;
        this.especifica = especifica;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public Character getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Character tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getGenerica() {
        return generica;
    }

    public void setGenerica(String generica) {
        this.generica = generica;
    }

    public String getSubgenerica() {
        return subgenerica;
    }

    public void setSubgenerica(String subgenerica) {
        this.subgenerica = subgenerica;
    }

    public String getSubgenericaDet() {
        return subgenericaDet;
    }

    public void setSubgenericaDet(String subgenericaDet) {
        this.subgenericaDet = subgenericaDet;
    }

    public String getEspecifica() {
        return especifica;
    }

    public void setEspecifica(String especifica) {
        this.especifica = especifica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (tipoTransaccion != null ? tipoTransaccion.hashCode() : 0);
        hash += (generica != null ? generica.hashCode() : 0);
        hash += (subgenerica != null ? subgenerica.hashCode() : 0);
        hash += (subgenericaDet != null ? subgenericaDet.hashCode() : 0);
        hash += (especifica != null ? especifica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecificaPK)) {
            return false;
        }
        EspecificaPK other = (EspecificaPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.tipoTransaccion == null && other.tipoTransaccion != null) || (this.tipoTransaccion != null && !this.tipoTransaccion.equals(other.tipoTransaccion))) {
            return false;
        }
        if ((this.generica == null && other.generica != null) || (this.generica != null && !this.generica.equals(other.generica))) {
            return false;
        }
        if ((this.subgenerica == null && other.subgenerica != null) || (this.subgenerica != null && !this.subgenerica.equals(other.subgenerica))) {
            return false;
        }
        if ((this.subgenericaDet == null && other.subgenericaDet != null) || (this.subgenericaDet != null && !this.subgenericaDet.equals(other.subgenericaDet))) {
            return false;
        }
        if ((this.especifica == null && other.especifica != null) || (this.especifica != null && !this.especifica.equals(other.especifica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.EspecificaPK[ anoEje=" + anoEje + ", tipoTransaccion=" + tipoTransaccion + ", generica=" + generica + ", subgenerica=" + subgenerica + ", subgenericaDet=" + subgenericaDet + ", especifica=" + especifica + " ]";
    }
    
}
