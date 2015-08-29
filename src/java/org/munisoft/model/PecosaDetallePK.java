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
public class PecosaDetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_pecosa")
    private int nPecosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public PecosaDetallePK() {
    }

    public PecosaDetallePK(String anoEje, int nPecosa, int item) {
        this.anoEje = anoEje;
        this.nPecosa = nPecosa;
        this.item = item;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getNPecosa() {
        return nPecosa;
    }

    public void setNPecosa(int nPecosa) {
        this.nPecosa = nPecosa;
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
        hash += (int) nPecosa;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecosaDetallePK)) {
            return false;
        }
        PecosaDetallePK other = (PecosaDetallePK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nPecosa != other.nPecosa) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PecosaDetallePK[ anoEje=" + anoEje + ", nPecosa=" + nPecosa + ", item=" + item + " ]";
    }
    
}
