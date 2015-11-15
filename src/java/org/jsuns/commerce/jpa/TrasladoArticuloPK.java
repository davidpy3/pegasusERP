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

/**
 *
 * @author Jorik
 */
@Embeddable
public class TrasladoArticuloPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_traslado")
    private int idTraslado;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;

    public TrasladoArticuloPK() {
    }

    public TrasladoArticuloPK(int idTraslado, int idArticulo) {
        this.idTraslado = idTraslado;
        this.idArticulo = idArticulo;
    }

    public int getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(int idTraslado) {
        this.idTraslado = idTraslado;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTraslado;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrasladoArticuloPK)) {
            return false;
        }
        TrasladoArticuloPK other = (TrasladoArticuloPK) object;
        if (this.idTraslado != other.idTraslado) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.TrasladoArticuloPK[ idTraslado=" + idTraslado + ", idArticulo=" + idArticulo + " ]";
    }
    
}
