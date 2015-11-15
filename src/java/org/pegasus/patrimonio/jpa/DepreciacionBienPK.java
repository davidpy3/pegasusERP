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
public class DepreciacionBienPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_periodo")
    private long codPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cod_bien")
    private String codBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "correla")
    private String correla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item")
    private int item;

    public DepreciacionBienPK() {
    }

    public DepreciacionBienPK(long codPeriodo, String codBien, String correla, int item) {
        this.codPeriodo = codPeriodo;
        this.codBien = codBien;
        this.correla = correla;
        this.item = item;
    }

    public long getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(long codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getCodBien() {
        return codBien;
    }

    public void setCodBien(String codBien) {
        this.codBien = codBien;
    }

    public String getCorrela() {
        return correla;
    }

    public void setCorrela(String correla) {
        this.correla = correla;
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
        hash += (int) codPeriodo;
        hash += (codBien != null ? codBien.hashCode() : 0);
        hash += (correla != null ? correla.hashCode() : 0);
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepreciacionBienPK)) {
            return false;
        }
        DepreciacionBienPK other = (DepreciacionBienPK) object;
        if (this.codPeriodo != other.codPeriodo) {
            return false;
        }
        if ((this.codBien == null && other.codBien != null) || (this.codBien != null && !this.codBien.equals(other.codBien))) {
            return false;
        }
        if ((this.correla == null && other.correla != null) || (this.correla != null && !this.correla.equals(other.correla))) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.DepreciacionBienePK[ codPeriodo=" + codPeriodo + ", codBien=" + codBien + ", correla=" + correla + ", item=" + item + " ]";
    }
    
}
