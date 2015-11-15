/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
public class CalendarioDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "mes_eje")
    private String mesEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_calendario")
    private Character tipoCalendario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sec_fun")
    private String secFun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "meta")
    private String meta;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "especifica_det")
    private String especificaDet;

    public CalendarioDetPK() {
    }

    public CalendarioDetPK(String anoEje, String mesEje, String fuenteFinanc, Character tipoCalendario, String secFun, String meta, Character tipoTransaccion, String generica, String subgenerica, String subgenericaDet, String especifica, String especificaDet) {
        this.anoEje = anoEje;
        this.mesEje = mesEje;
        this.fuenteFinanc = fuenteFinanc;
        this.tipoCalendario = tipoCalendario;
        this.secFun = secFun;
        this.meta = meta;
        this.tipoTransaccion = tipoTransaccion;
        this.generica = generica;
        this.subgenerica = subgenerica;
        this.subgenericaDet = subgenericaDet;
        this.especifica = especifica;
        this.especificaDet = especificaDet;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getMesEje() {
        return mesEje;
    }

    public void setMesEje(String mesEje) {
        this.mesEje = mesEje;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public Character getTipoCalendario() {
        return tipoCalendario;
    }

    public void setTipoCalendario(Character tipoCalendario) {
        this.tipoCalendario = tipoCalendario;
    }

    public String getSecFun() {
        return secFun;
    }

    public void setSecFun(String secFun) {
        this.secFun = secFun;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
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

    public String getEspecificaDet() {
        return especificaDet;
    }

    public void setEspecificaDet(String especificaDet) {
        this.especificaDet = especificaDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (mesEje != null ? mesEje.hashCode() : 0);
        hash += (fuenteFinanc != null ? fuenteFinanc.hashCode() : 0);
        hash += (tipoCalendario != null ? tipoCalendario.hashCode() : 0);
        hash += (secFun != null ? secFun.hashCode() : 0);
        hash += (meta != null ? meta.hashCode() : 0);
        hash += (tipoTransaccion != null ? tipoTransaccion.hashCode() : 0);
        hash += (generica != null ? generica.hashCode() : 0);
        hash += (subgenerica != null ? subgenerica.hashCode() : 0);
        hash += (subgenericaDet != null ? subgenericaDet.hashCode() : 0);
        hash += (especifica != null ? especifica.hashCode() : 0);
        hash += (especificaDet != null ? especificaDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioDetPK)) {
            return false;
        }
        CalendarioDetPK other = (CalendarioDetPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.mesEje == null && other.mesEje != null) || (this.mesEje != null && !this.mesEje.equals(other.mesEje))) {
            return false;
        }
        if ((this.fuenteFinanc == null && other.fuenteFinanc != null) || (this.fuenteFinanc != null && !this.fuenteFinanc.equals(other.fuenteFinanc))) {
            return false;
        }
        if ((this.tipoCalendario == null && other.tipoCalendario != null) || (this.tipoCalendario != null && !this.tipoCalendario.equals(other.tipoCalendario))) {
            return false;
        }
        if ((this.secFun == null && other.secFun != null) || (this.secFun != null && !this.secFun.equals(other.secFun))) {
            return false;
        }
        if ((this.meta == null && other.meta != null) || (this.meta != null && !this.meta.equals(other.meta))) {
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
        if ((this.especificaDet == null && other.especificaDet != null) || (this.especificaDet != null && !this.especificaDet.equals(other.especificaDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CalendarioDetPK[ anoEje=" + anoEje + ", mesEje=" + mesEje + ", fuenteFinanc=" + fuenteFinanc + ", tipoCalendario=" + tipoCalendario + ", secFun=" + secFun + ", meta=" + meta + ", tipoTransaccion=" + tipoTransaccion + ", generica=" + generica + ", subgenerica=" + subgenerica + ", subgenericaDet=" + subgenericaDet + ", especifica=" + especifica + ", especificaDet=" + especificaDet + " ]";
    }
    
}
