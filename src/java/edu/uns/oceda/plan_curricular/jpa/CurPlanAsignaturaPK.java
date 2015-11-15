package edu.uns.oceda.plan_curricular.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CurPlanAsignaturaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_asignatura_base")
    private int idAsignaturaBase;
    @Basic(optional = false)
    @Column(name = "id_asignatura_req")
    private int idAsignaturaReq;

    public CurPlanAsignaturaPK() {
    }

    public CurPlanAsignaturaPK(int idAsignaturaBase, int idAsignaturaReq) {
        this.idAsignaturaBase = idAsignaturaBase;
        this.idAsignaturaReq = idAsignaturaReq;
    }

    public int getIdAsignaturaBase() {
        return idAsignaturaBase;
    }

    public void setIdAsignaturaBase(int idAsignaturaBase) {
        this.idAsignaturaBase = idAsignaturaBase;
    }

    public int getIdAsignaturaReq() {
        return idAsignaturaReq;
    }

    public void setIdAsignaturaReq(int idAsignaturaReq) {
        this.idAsignaturaReq = idAsignaturaReq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAsignaturaBase;
        hash += (int) idAsignaturaReq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurPlanAsignaturaPK)) {
            return false;
        }
        CurPlanAsignaturaPK other = (CurPlanAsignaturaPK) object;
        if (this.idAsignaturaBase != other.idAsignaturaBase) {
            return false;
        }
        if (this.idAsignaturaReq != other.idAsignaturaReq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.plan_curricular.CurPlanAsignaturaPK[idAsignaturaBase=" + idAsignaturaBase + ", idAsignaturaReq=" + idAsignaturaReq + "]";
    }

}
