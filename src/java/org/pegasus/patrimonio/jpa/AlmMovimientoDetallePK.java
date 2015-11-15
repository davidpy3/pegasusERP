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
public class AlmMovimientoDetallePK implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "id_item")
    private String idItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public AlmMovimientoDetallePK() {
    }

    public AlmMovimientoDetallePK(String anoEje, String codAlmacen, Character tipoMov, int nroMov, String idItem, int item) {
        this.anoEje = anoEje;
        this.codAlmacen = codAlmacen;
        this.tipoMov = tipoMov;
        this.nroMov = nroMov;
        this.idItem = idItem;
        this.item = item;
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

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (codAlmacen != null ? codAlmacen.hashCode() : 0);
        hash += (tipoMov != null ? tipoMov.hashCode() : 0);
        hash += (int) nroMov;
        hash += (idItem != null ? idItem.hashCode() : 0);
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmMovimientoDetallePK)) {
            return false;
        }
        AlmMovimientoDetallePK other = (AlmMovimientoDetallePK) object;
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
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AlmMovimientoDetallePK[ anoEje=" + anoEje + ", codAlmacen=" + codAlmacen + ", tipoMov=" + tipoMov + ", nroMov=" + nroMov + ", idItem=" + idItem + ", item=" + item + " ]";
    }
    
}
