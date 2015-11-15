/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Embeddable
public class ComCajaArqueoDetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_arqueo")
    private int idArqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medio")
    private Character idMedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_moneda")
    private int idMoneda;

    public ComCajaArqueoDetallePK() {
    }

    public ComCajaArqueoDetallePK(int idArqueo, Character idMedio, int idMoneda) {
        this.idArqueo = idArqueo;
        this.idMedio = idMedio;
        this.idMoneda = idMoneda;
    }

    public int getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(int idArqueo) {
        this.idArqueo = idArqueo;
    }

    public Character getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Character idMedio) {
        this.idMedio = idMedio;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArqueo;
        hash += (idMedio != null ? idMedio.hashCode() : 0);
        hash += (int) idMoneda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComCajaArqueoDetallePK)) {
            return false;
        }
        ComCajaArqueoDetallePK other = (ComCajaArqueoDetallePK) object;
        if (this.idArqueo != other.idArqueo) {
            return false;
        }
        if ((this.idMedio == null && other.idMedio != null) || (this.idMedio != null && !this.idMedio.equals(other.idMedio))) {
            return false;
        }
        if (this.idMoneda != other.idMoneda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComCajaArqueoDetallePK[ idArqueo=" + idArqueo + ", idMedio=" + idMedio + ", idMoneda=" + idMoneda + " ]";
    }
    
}
