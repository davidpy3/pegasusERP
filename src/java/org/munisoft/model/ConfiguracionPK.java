/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

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
public class ConfiguracionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_eje")
    private int anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUC_entidad")
    private String rUCentidad;

    public ConfiguracionPK() {
    }

    public ConfiguracionPK(int anoEje, String rUCentidad) {
        this.anoEje = anoEje;
        this.rUCentidad = rUCentidad;
    }

    public int getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(int anoEje) {
        this.anoEje = anoEje;
    }

    public String getRUCentidad() {
        return rUCentidad;
    }

    public void setRUCentidad(String rUCentidad) {
        this.rUCentidad = rUCentidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) anoEje;
        hash += (rUCentidad != null ? rUCentidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionPK)) {
            return false;
        }
        ConfiguracionPK other = (ConfiguracionPK) object;
        if (this.anoEje != other.anoEje) {
            return false;
        }
        if ((this.rUCentidad == null && other.rUCentidad != null) || (this.rUCentidad != null && !this.rUCentidad.equals(other.rUCentidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ConfiguracionPK[ anoEje=" + anoEje + ", rUCentidad=" + rUCentidad + " ]";
    }
    
}
