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
public class ValorizacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_orden")
    private int nOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_valor")
    private int nValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_valor")
    private Character tipoValor;

    public ValorizacionPK() {
    }

    public ValorizacionPK(String anoEje, Character tipo, int nOrden, int nValor, Character tipoValor) {
        this.anoEje = anoEje;
        this.tipo = tipo;
        this.nOrden = nOrden;
        this.nValor = nValor;
        this.tipoValor = tipoValor;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public int getNOrden() {
        return nOrden;
    }

    public void setNOrden(int nOrden) {
        this.nOrden = nOrden;
    }

    public int getNValor() {
        return nValor;
    }

    public void setNValor(int nValor) {
        this.nValor = nValor;
    }

    public Character getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(Character tipoValor) {
        this.tipoValor = tipoValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (tipo != null ? tipo.hashCode() : 0);
        hash += (int) nOrden;
        hash += (int) nValor;
        hash += (tipoValor != null ? tipoValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorizacionPK)) {
            return false;
        }
        ValorizacionPK other = (ValorizacionPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        if (this.nOrden != other.nOrden) {
            return false;
        }
        if (this.nValor != other.nValor) {
            return false;
        }
        if ((this.tipoValor == null && other.tipoValor != null) || (this.tipoValor != null && !this.tipoValor.equals(other.tipoValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ValorizacionPK[ anoEje=" + anoEje + ", tipo=" + tipo + ", nOrden=" + nOrden + ", nValor=" + nValor + ", tipoValor=" + tipoValor + " ]";
    }
    
}
