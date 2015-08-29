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
public class CalendarioPK implements Serializable {
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

    public CalendarioPK() {
    }

    public CalendarioPK(String anoEje, String mesEje, String fuenteFinanc, Character tipoCalendario, String secFun) {
        this.anoEje = anoEje;
        this.mesEje = mesEje;
        this.fuenteFinanc = fuenteFinanc;
        this.tipoCalendario = tipoCalendario;
        this.secFun = secFun;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (mesEje != null ? mesEje.hashCode() : 0);
        hash += (fuenteFinanc != null ? fuenteFinanc.hashCode() : 0);
        hash += (tipoCalendario != null ? tipoCalendario.hashCode() : 0);
        hash += (secFun != null ? secFun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioPK)) {
            return false;
        }
        CalendarioPK other = (CalendarioPK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.CalendarioPK[ anoEje=" + anoEje + ", mesEje=" + mesEje + ", fuenteFinanc=" + fuenteFinanc + ", tipoCalendario=" + tipoCalendario + ", secFun=" + secFun + " ]";
    }
    
}
