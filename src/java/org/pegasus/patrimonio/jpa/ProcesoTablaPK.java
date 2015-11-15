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
public class ProcesoTablaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Tipo_proceso")
    private String tipoproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clasifica")
    private Character clasifica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    private int anno;

    public ProcesoTablaPK() {
    }

    public ProcesoTablaPK(String tipoproceso, Character clasifica, int anno) {
        this.tipoproceso = tipoproceso;
        this.clasifica = clasifica;
        this.anno = anno;
    }

    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public Character getClasifica() {
        return clasifica;
    }

    public void setClasifica(Character clasifica) {
        this.clasifica = clasifica;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoproceso != null ? tipoproceso.hashCode() : 0);
        hash += (clasifica != null ? clasifica.hashCode() : 0);
        hash += (int) anno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoTablaPK)) {
            return false;
        }
        ProcesoTablaPK other = (ProcesoTablaPK) object;
        if ((this.tipoproceso == null && other.tipoproceso != null) || (this.tipoproceso != null && !this.tipoproceso.equals(other.tipoproceso))) {
            return false;
        }
        if ((this.clasifica == null && other.clasifica != null) || (this.clasifica != null && !this.clasifica.equals(other.clasifica))) {
            return false;
        }
        if (this.anno != other.anno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ProcesoTablaPK[ tipoproceso=" + tipoproceso + ", clasifica=" + clasifica + ", anno=" + anno + " ]";
    }
    
}
