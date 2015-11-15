/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

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

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_tipo_operacion")
@NamedQueries({
    @NamedQuery(name = "ComTipoOperacion.findAll", query = "SELECT c FROM ComTipoOperacion c")})
public class ComTipoOperacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_tipo_operacion")
    private String idTipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_operacion")
    private String tipoOperacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movimiento")
    private int movimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cierra")
    private int cierra;

    public ComTipoOperacion() {
    }

    public ComTipoOperacion(String idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public ComTipoOperacion(String idTipoOperacion, String tipoOperacion, int movimiento, int cierra) {
        this.idTipoOperacion = idTipoOperacion;
        this.tipoOperacion = tipoOperacion;
        this.movimiento = movimiento;
        this.cierra = cierra;
    }

    public String getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(String idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

    public int getCierra() {
        return cierra;
    }

    public void setCierra(int cierra) {
        this.cierra = cierra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOperacion != null ? idTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComTipoOperacion)) {
            return false;
        }
        ComTipoOperacion other = (ComTipoOperacion) object;
        if ((this.idTipoOperacion == null && other.idTipoOperacion != null) || (this.idTipoOperacion != null && !this.idTipoOperacion.equals(other.idTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComTipoOperacion[ idTipoOperacion=" + idTipoOperacion + " ]";
    }
    
}
