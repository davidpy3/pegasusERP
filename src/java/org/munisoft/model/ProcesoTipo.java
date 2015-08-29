/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Proceso_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoTipo.findAll", query = "SELECT p FROM ProcesoTipo p"),
    @NamedQuery(name = "ProcesoTipo.findByTipoproceso", query = "SELECT p FROM ProcesoTipo p WHERE p.tipoproceso = :tipoproceso"),
    @NamedQuery(name = "ProcesoTipo.findByNomProceso", query = "SELECT p FROM ProcesoTipo p WHERE p.nomProceso = :nomProceso")})
public class ProcesoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Tipo_proceso")
    private String tipoproceso;
    @Size(max = 100)
    @Column(name = "nom_proceso")
    private String nomProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoTipo")
    private Collection<ProcesoTabla> procesoTablaCollection;

    public ProcesoTipo() {
    }

    public ProcesoTipo(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public String getNomProceso() {
        return nomProceso;
    }

    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    @XmlTransient
    public Collection<ProcesoTabla> getProcesoTablaCollection() {
        return procesoTablaCollection;
    }

    public void setProcesoTablaCollection(Collection<ProcesoTabla> procesoTablaCollection) {
        this.procesoTablaCollection = procesoTablaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoproceso != null ? tipoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoTipo)) {
            return false;
        }
        ProcesoTipo other = (ProcesoTipo) object;
        if ((this.tipoproceso == null && other.tipoproceso != null) || (this.tipoproceso != null && !this.tipoproceso.equals(other.tipoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ProcesoTipo[ tipoproceso=" + tipoproceso + " ]";
    }
    
}
