/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Erick alarcon
 */
@Embeddable
public class GastoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "sec_func")
    private String secFunc;
    @Basic(optional = false)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Basic(optional = false)
    @Column(name = "clasificador")
    private String clasificador;

    public GastoPK() {
    }

    public GastoPK(String anoEje, String secFunc, String fuenteFinanc, String clasificador) {
        this.anoEje = anoEje;
        this.secFunc = secFunc;
        this.fuenteFinanc = fuenteFinanc;
        this.clasificador = clasificador;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (secFunc != null ? secFunc.hashCode() : 0);
        hash += (fuenteFinanc != null ? fuenteFinanc.hashCode() : 0);
        hash += (clasificador != null ? clasificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoPK)) {
            return false;
        }
        GastoPK other = (GastoPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.secFunc == null && other.secFunc != null) || (this.secFunc != null && !this.secFunc.equals(other.secFunc))) {
            return false;
        }
        if ((this.fuenteFinanc == null && other.fuenteFinanc != null) || (this.fuenteFinanc != null && !this.fuenteFinanc.equals(other.fuenteFinanc))) {
            return false;
        }
        if ((this.clasificador == null && other.clasificador != null) || (this.clasificador != null && !this.clasificador.equals(other.clasificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.GastoPK[ anoEje=" + anoEje + ", secFunc=" + secFunc + ", fuenteFinanc=" + fuenteFinanc + ", clasificador=" + clasificador + " ]";
    }
    
}
