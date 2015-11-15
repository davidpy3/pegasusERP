package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipo_planilla")
public class TipoPlanilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo_planilla")
    private String tipoPlanilla;
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

    public TipoPlanilla(String tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(String tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
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

    public Collection<Planilla> getPlanillaCollection() {
        return planillaCollection;
    }

    public void setPlanillaCollection(Collection<Planilla> planillaCollection) {
        this.planillaCollection = planillaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPlanilla != null ? tipoPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlanilla)) {
            return false;
        }
        TipoPlanilla other = (TipoPlanilla) object;
        if ((this.tipoPlanilla == null && other.tipoPlanilla != null) || (this.tipoPlanilla != null && !this.tipoPlanilla.equals(other.tipoPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TipoPlanilla[ tipoPlanilla=" + tipoPlanilla + " ]";
    }
    
}
