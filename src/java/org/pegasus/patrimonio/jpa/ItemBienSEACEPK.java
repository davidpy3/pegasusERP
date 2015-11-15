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
public class ItemBienSEACEPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_bien")
    private Character tipoBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "grupo_bien")
    private String grupoBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "clase_bien")
    private String claseBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "familia_bien")
    private String familiaBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "item_bien")
    private String itemBien;

    public ItemBienSEACEPK() {
    }

    public ItemBienSEACEPK(Character tipoBien, String grupoBien, String claseBien, String familiaBien, String itemBien) {
        this.tipoBien = tipoBien;
        this.grupoBien = grupoBien;
        this.claseBien = claseBien;
        this.familiaBien = familiaBien;
        this.itemBien = itemBien;
    }

    public Character getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(Character tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getGrupoBien() {
        return grupoBien;
    }

    public void setGrupoBien(String grupoBien) {
        this.grupoBien = grupoBien;
    }

    public String getClaseBien() {
        return claseBien;
    }

    public void setClaseBien(String claseBien) {
        this.claseBien = claseBien;
    }

    public String getFamiliaBien() {
        return familiaBien;
    }

    public void setFamiliaBien(String familiaBien) {
        this.familiaBien = familiaBien;
    }

    public String getItemBien() {
        return itemBien;
    }

    public void setItemBien(String itemBien) {
        this.itemBien = itemBien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoBien != null ? tipoBien.hashCode() : 0);
        hash += (grupoBien != null ? grupoBien.hashCode() : 0);
        hash += (claseBien != null ? claseBien.hashCode() : 0);
        hash += (familiaBien != null ? familiaBien.hashCode() : 0);
        hash += (itemBien != null ? itemBien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemBienSEACEPK)) {
            return false;
        }
        ItemBienSEACEPK other = (ItemBienSEACEPK) object;
        if ((this.tipoBien == null && other.tipoBien != null) || (this.tipoBien != null && !this.tipoBien.equals(other.tipoBien))) {
            return false;
        }
        if ((this.grupoBien == null && other.grupoBien != null) || (this.grupoBien != null && !this.grupoBien.equals(other.grupoBien))) {
            return false;
        }
        if ((this.claseBien == null && other.claseBien != null) || (this.claseBien != null && !this.claseBien.equals(other.claseBien))) {
            return false;
        }
        if ((this.familiaBien == null && other.familiaBien != null) || (this.familiaBien != null && !this.familiaBien.equals(other.familiaBien))) {
            return false;
        }
        if ((this.itemBien == null && other.itemBien != null) || (this.itemBien != null && !this.itemBien.equals(other.itemBien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ItemBienSEACEPK[ tipoBien=" + tipoBien + ", grupoBien=" + grupoBien + ", claseBien=" + claseBien + ", familiaBien=" + familiaBien + ", itemBien=" + itemBien + " ]";
    }
    
}
