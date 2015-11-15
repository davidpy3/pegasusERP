/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class RHaberesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    @Temporal(TemporalType.DATE)
    private Date anno;

    public RHaberesPK() {
    }

    public RHaberesPK(String dni, String mes, Date anno) {
        this.dni = dni;
        this.mes = mes;
        this.anno = anno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (mes != null ? mes.hashCode() : 0);
        hash += (anno != null ? anno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RHaberesPK)) {
            return false;
        }
        RHaberesPK other = (RHaberesPK) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if ((this.mes == null && other.mes != null) || (this.mes != null && !this.mes.equals(other.mes))) {
            return false;
        }
        if ((this.anno == null && other.anno != null) || (this.anno != null && !this.anno.equals(other.anno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RHaberesPK[ dni=" + dni + ", mes=" + mes + ", anno=" + anno + " ]";
    }
    
}
