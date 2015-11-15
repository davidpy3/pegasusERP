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
public class AlmMovimientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_almacen")
    private String codAlmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_mov")
    private Character tipoMov;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_mov")
    private int nroMov;

    public AlmMovimientoPK() {
    }

    public AlmMovimientoPK(String anoEje, String codAlmacen, Character tipoMov, int nroMov) {
        this.anoEje = anoEje;
        this.codAlmacen = codAlmacen;
        this.tipoMov = tipoMov;
        this.nroMov = nroMov;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(String codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public Character getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Character tipoMov) {
        this.tipoMov = tipoMov;
    }

    public int getNroMov() {
        return nroMov;
    }

    public void setNroMov(int nroMov) {
        this.nroMov = nroMov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (codAlmacen != null ? codAlmacen.hashCode() : 0);
        hash += (tipoMov != null ? tipoMov.hashCode() : 0);
        hash += (int) nroMov;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmMovimientoPK)) {
            return false;
        }
        AlmMovimientoPK other = (AlmMovimientoPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.codAlmacen == null && other.codAlmacen != null) || (this.codAlmacen != null && !this.codAlmacen.equals(other.codAlmacen))) {
            return false;
        }
        if ((this.tipoMov == null && other.tipoMov != null) || (this.tipoMov != null && !this.tipoMov.equals(other.tipoMov))) {
            return false;
        }
        if (this.nroMov != other.nroMov) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AlmMovimientoPK[ anoEje=" + anoEje + ", codAlmacen=" + codAlmacen + ", tipoMov=" + tipoMov + ", nroMov=" + nroMov + " ]";
    }
    
}
