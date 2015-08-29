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
public class RequerimientoDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clasifica")
    private Character clasifica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_requer")
    private int nRequer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public RequerimientoDetPK() {
    }

    public RequerimientoDetPK(String anoEje, Character clasifica, int nRequer, int item) {
        this.anoEje = anoEje;
        this.clasifica = clasifica;
        this.nRequer = nRequer;
        this.item = item;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public Character getClasifica() {
        return clasifica;
    }

    public void setClasifica(Character clasifica) {
        this.clasifica = clasifica;
    }

    public int getNRequer() {
        return nRequer;
    }

    public void setNRequer(int nRequer) {
        this.nRequer = nRequer;
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
        hash += (clasifica != null ? clasifica.hashCode() : 0);
        hash += (int) nRequer;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequerimientoDetPK)) {
            return false;
        }
        RequerimientoDetPK other = (RequerimientoDetPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.clasifica == null && other.clasifica != null) || (this.clasifica != null && !this.clasifica.equals(other.clasifica))) {
            return false;
        }
        if (this.nRequer != other.nRequer) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RequerimientoDetPK[ anoEje=" + anoEje + ", clasifica=" + clasifica + ", nRequer=" + nRequer + ", item=" + item + " ]";
    }
    
}
