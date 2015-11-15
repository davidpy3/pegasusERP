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
public class BienPK implements Serializable {
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

    public BienPK() {
    }

    public BienPK(String codbien, String correla) {
        this.codbien = codbien;
        this.correla = correla;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbien != null ? codbien.hashCode() : 0);
        hash += (correla != null ? correla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BienPK)) {
            return false;
        }
        BienPK other = (BienPK) object;
        if ((this.codbien == null && other.codbien != null) || (this.codbien != null && !this.codbien.equals(other.codbien))) {
            return false;
        }
        if ((this.correla == null && other.correla != null) || (this.correla != null && !this.correla.equals(other.correla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.bienPK[ codbien=" + codbien + ", correla=" + correla + " ]";
    }
    
}
