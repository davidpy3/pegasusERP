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
public class MbienesSinceradosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codbien")
    private String codbien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "correla")
    private String correla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "num_inv")
    private String numInv;

    public MbienesSinceradosPK() {
    }

    public MbienesSinceradosPK(String codbien, String correla, String anoEje, String numInv) {
        this.codbien = codbien;
        this.correla = correla;
        this.anoEje = anoEje;
        this.numInv = numInv;
    }

    public String getCodbien() {
        return codbien;
    }

    public void setCodbien(String codbien) {
        this.codbien = codbien;
    }

    public String getCorrela() {
        return correla;
    }

    public void setCorrela(String correla) {
        this.correla = correla;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getNumInv() {
        return numInv;
    }

    public void setNumInv(String numInv) {
        this.numInv = numInv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbien != null ? codbien.hashCode() : 0);
        hash += (correla != null ? correla.hashCode() : 0);
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (numInv != null ? numInv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MbienesSinceradosPK)) {
            return false;
        }
        MbienesSinceradosPK other = (MbienesSinceradosPK) object;
        if ((this.codbien == null && other.codbien != null) || (this.codbien != null && !this.codbien.equals(other.codbien))) {
            return false;
        }
        if ((this.correla == null && other.correla != null) || (this.correla != null && !this.correla.equals(other.correla))) {
            return false;
        }
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.numInv == null && other.numInv != null) || (this.numInv != null && !this.numInv.equals(other.numInv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.MbienesSinceradosPK[ codbien=" + codbien + ", correla=" + correla + ", anoEje=" + anoEje + ", numInv=" + numInv + " ]";
    }
    
}
