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
@Table(name = "modalidad_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadLaboral.findAll", query = "SELECT m FROM ModalidadLaboral m"),
    @NamedQuery(name = "ModalidadLaboral.findByModLaboral", query = "SELECT m FROM ModalidadLaboral m WHERE m.modLaboral = :modLaboral"),
    @NamedQuery(name = "ModalidadLaboral.findByNombre", query = "SELECT m FROM ModalidadLaboral m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "ModalidadLaboral.findByAbrev", query = "SELECT m FROM ModalidadLaboral m WHERE m.abrev = :abrev"),
    @NamedQuery(name = "ModalidadLaboral.findByTipoTrab", query = "SELECT m FROM ModalidadLaboral m WHERE m.tipoTrab = :tipoTrab")})
public class ModalidadLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "mod_laboral")
    private String modLaboral;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "abrev")
    private String abrev;
    @Size(max = 2)
    @Column(name = "tipo_trab")
    private String tipoTrab;

    public ModalidadLaboral() {
    }

    public ModalidadLaboral(String modLaboral) {
        this.modLaboral = modLaboral;
    }

    public String getModLaboral() {
        return modLaboral;
    }

    public void setModLaboral(String modLaboral) {
        this.modLaboral = modLaboral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modLaboral != null ? modLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadLaboral)) {
            return false;
        }
        ModalidadLaboral other = (ModalidadLaboral) object;
        if ((this.modLaboral == null && other.modLaboral != null) || (this.modLaboral != null && !this.modLaboral.equals(other.modLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ModalidadLaboral[ modLaboral=" + modLaboral + " ]";
    }
    
}
