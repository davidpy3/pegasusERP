/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "tipo_trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTrabajador.findAll", query = "SELECT t FROM TipoTrabajador t"),
    @NamedQuery(name = "TipoTrabajador.findByTipoTrab", query = "SELECT t FROM TipoTrabajador t WHERE t.tipoTrab = :tipoTrab"),
    @NamedQuery(name = "TipoTrabajador.findByNombre", query = "SELECT t FROM TipoTrabajador t WHERE t.nombre = :nombre")})
public class TipoTrabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_trab")
    private String tipoTrab;
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;

    public TipoTrabajador() {
    }

    public TipoTrabajador(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoTrab != null ? tipoTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTrabajador)) {
            return false;
        }
        TipoTrabajador other = (TipoTrabajador) object;
        if ((this.tipoTrab == null && other.tipoTrab != null) || (this.tipoTrab != null && !this.tipoTrab.equals(other.tipoTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoTrabajador[ tipoTrab=" + tipoTrab + " ]";
    }
    
}
