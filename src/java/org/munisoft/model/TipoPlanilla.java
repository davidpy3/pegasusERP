/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "Tipo_Planilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlanilla.findAll", query = "SELECT t FROM TipoPlanilla t"),
    @NamedQuery(name = "TipoPlanilla.findByTipoplanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.tipoplanilla = :tipoplanilla"),
    @NamedQuery(name = "TipoPlanilla.findByNombrePlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.nombrePlanilla = :nombrePlanilla"),
    @NamedQuery(name = "TipoPlanilla.findByAbrevPlanilla", query = "SELECT t FROM TipoPlanilla t WHERE t.abrevPlanilla = :abrevPlanilla")})
public class TipoPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Tipo_planilla")
    private String tipoplanilla;
    @Size(max = 50)
    @Column(name = "nombre_planilla")
    private String nombrePlanilla;
    @Size(max = 20)
    @Column(name = "abrev_planilla")
    private String abrevPlanilla;
    @OneToMany(mappedBy = "tipoPlanilla")
    private Collection<Planilla> planillaCollection;

    public TipoPlanilla() {
    }

    public TipoPlanilla(String tipoplanilla) {
        this.tipoplanilla = tipoplanilla;
    }

    public String getTipoplanilla() {
        return tipoplanilla;
    }

    public void setTipoplanilla(String tipoplanilla) {
        this.tipoplanilla = tipoplanilla;
    }

    public String getNombrePlanilla() {
        return nombrePlanilla;
    }

    public void setNombrePlanilla(String nombrePlanilla) {
        this.nombrePlanilla = nombrePlanilla;
    }

    public String getAbrevPlanilla() {
        return abrevPlanilla;
    }

    public void setAbrevPlanilla(String abrevPlanilla) {
        this.abrevPlanilla = abrevPlanilla;
    }

    @XmlTransient
    public Collection<Planilla> getPlanillaCollection() {
        return planillaCollection;
    }

    public void setPlanillaCollection(Collection<Planilla> planillaCollection) {
        this.planillaCollection = planillaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoplanilla != null ? tipoplanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanilla)) {
            return false;
        }
        TipoPlanilla other = (TipoPlanilla) object;
        if ((this.tipoplanilla == null && other.tipoplanilla != null) || (this.tipoplanilla != null && !this.tipoplanilla.equals(other.tipoplanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoPlanilla[ tipoplanilla=" + tipoplanilla + " ]";
    }
    
}
