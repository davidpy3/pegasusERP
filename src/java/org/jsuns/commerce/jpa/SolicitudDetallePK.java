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
public class SolicitudDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_solicitud")
    private int idSolicitud;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;

    public SolicitudDetallePK() {
    }

    public SolicitudDetallePK(int idSolicitud, int idArticulo) {
        this.idSolicitud = idSolicitud;
        this.idArticulo = idArticulo;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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
        hash += (int) idSolicitud;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudDetallePK)) {
            return false;
        }
        SolicitudDetallePK other = (SolicitudDetallePK) object;
        if (this.idSolicitud != other.idSolicitud) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.SolicitudDetallePK[ idSolicitud=" + idSolicitud + ", idArticulo=" + idArticulo + " ]";
    }
    
}
