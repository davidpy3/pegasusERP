/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Eobservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EObservacion.findAll", query = "SELECT e FROM EObservacion e"),
    @NamedQuery(name = "EObservacion.findByDni", query = "SELECT e FROM EObservacion e WHERE e.eObservacionPK.dni = :dni"),
    @NamedQuery(name = "EObservacion.findByAnno", query = "SELECT e FROM EObservacion e WHERE e.eObservacionPK.anno = :anno"),
    @NamedQuery(name = "EObservacion.findByObservacion", query = "SELECT e FROM EObservacion e WHERE e.observacion = :observacion")})
public class EObservacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EObservacionPK eObservacionPK;
    @Size(max = 70)
    @Column(name = "observacion")
    private String observacion;

    public EObservacion() {
    }

    public EObservacion(EObservacionPK eObservacionPK) {
        this.eObservacionPK = eObservacionPK;
    }

    public EObservacion(String dni, Date anno) {
        this.eObservacionPK = new EObservacionPK(dni, anno);
    }

    public EObservacionPK getEObservacionPK() {
        return eObservacionPK;
    }

    public void setEObservacionPK(EObservacionPK eObservacionPK) {
        this.eObservacionPK = eObservacionPK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eObservacionPK != null ? eObservacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EObservacion)) {
            return false;
        }
        EObservacion other = (EObservacion) object;
        if ((this.eObservacionPK == null && other.eObservacionPK != null) || (this.eObservacionPK != null && !this.eObservacionPK.equals(other.eObservacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.EObservacion[ eObservacionPK=" + eObservacionPK + " ]";
    }
    
}
