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
public class HccDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "n_hcc")
    private int nHcc;
    @Basic(optional = false)
    @Column(name = "id_clasificador")
    private String idClasificador;
    @Basic(optional = false)
    @Column(name = "correla")
    private int correla;

    public HccDetallePK() {
    }

    public HccDetallePK(String anoEje, int nHcc, String idClasificador, int correla) {
        this.anoEje = anoEje;
        this.nHcc = nHcc;
        this.idClasificador = idClasificador;
        this.correla = correla;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getNHcc() {
        return nHcc;
    }

    public void setNHcc(int nHcc) {
        this.nHcc = nHcc;
    }

    public String getIdClasificador() {
        return idClasificador;
    }

    public void setIdClasificador(String idClasificador) {
        this.idClasificador = idClasificador;
    }

    public int getCorrela() {
        return correla;
    }

    public void setCorrela(int correla) {
        this.correla = correla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (int) nHcc;
        hash += (idClasificador != null ? idClasificador.hashCode() : 0);
        hash += (int) correla;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HccDetallePK)) {
            return false;
        }
        HccDetallePK other = (HccDetallePK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nHcc != other.nHcc) {
            return false;
        }
        if ((this.idClasificador == null && other.idClasificador != null) || (this.idClasificador != null && !this.idClasificador.equals(other.idClasificador))) {
            return false;
        }
        if (this.correla != other.correla) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.HccDetallePK[ anoEje=" + anoEje + ", nHcc=" + nHcc + ", idClasificador=" + idClasificador + ", correla=" + correla + " ]";
    }
    
}
