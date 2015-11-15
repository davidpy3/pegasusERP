package edu.uns.oceda.plan_curricular.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "cur_plan_asignatura")
//@NamedQueries({
//    @NamedQuery(name = "CurPlanAsignatura.findAll", query = "SELECT c FROM CurPlanAsignatura c"),
//    @NamedQuery(name = "CurPlanAsignatura.findByIdAsignaturaBase", query = "SELECT c FROM CurPlanAsignatura c WHERE c.curPlanAsignaturaPK.idAsignaturaBase = :idAsignaturaBase"),
//    @NamedQuery(name = "CurPlanAsignatura.findByIdAsignaturaReq", query = "SELECT c FROM CurPlanAsignatura c WHERE c.curPlanAsignaturaPK.idAsignaturaReq = :idAsignaturaReq"),
//    @NamedQuery(name = "CurPlanAsignatura.findByFecha", query = "SELECT c FROM CurPlanAsignatura c WHERE c.fecha = :fecha"),
//    @NamedQuery(name = "CurPlanAsignatura.findByEstado", query = "SELECT c FROM CurPlanAsignatura c WHERE c.estado = :estado"),
//    @NamedQuery(name = "CurPlanAsignatura.findByReferencia", query = "SELECT c FROM CurPlanAsignatura c WHERE c.referencia = :referencia"),
//    @NamedQuery(name = "CurPlanAsignatura.findByUpdateFecha", query = "SELECT c FROM CurPlanAsignatura c WHERE c.updateFecha = :updateFecha"),
//    @NamedQuery(name = "CurPlanAsignatura.findByUpdateDir", query = "SELECT c FROM CurPlanAsignatura c WHERE c.updateDir = :updateDir")})
public class CurPlanAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurPlanAsignaturaPK curPlanAsignaturaPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "update_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateFecha;
    @Column(name = "update_dir")
    private Integer updateDir;

    public CurPlanAsignatura() {
    }

    public CurPlanAsignatura(CurPlanAsignaturaPK curPlanAsignaturaPK) {
        this.curPlanAsignaturaPK = curPlanAsignaturaPK;
    }

    public CurPlanAsignatura(CurPlanAsignaturaPK curPlanAsignaturaPK, short estado) {
        this.curPlanAsignaturaPK = curPlanAsignaturaPK;
        this.estado = estado;
    }

    public CurPlanAsignatura(int idAsignaturaBase, int idAsignaturaReq) {
        this.curPlanAsignaturaPK = new CurPlanAsignaturaPK(idAsignaturaBase, idAsignaturaReq);
    }

    public CurPlanAsignaturaPK getCurPlanAsignaturaPK() {
        return curPlanAsignaturaPK;
    }

    public void setCurPlanAsignaturaPK(CurPlanAsignaturaPK curPlanAsignaturaPK) {
        this.curPlanAsignaturaPK = curPlanAsignaturaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getUpdateFecha() {
        return updateFecha;
    }

    public void setUpdateFecha(Date updateFecha) {
        this.updateFecha = updateFecha;
    }

    public Integer getUpdateDir() {
        return updateDir;
    }

    public void setUpdateDir(Integer updateDir) {
        this.updateDir = updateDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curPlanAsignaturaPK != null ? curPlanAsignaturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurPlanAsignatura)) {
            return false;
        }
        CurPlanAsignatura other = (CurPlanAsignatura) object;
        if ((this.curPlanAsignaturaPK == null && other.curPlanAsignaturaPK != null) || (this.curPlanAsignaturaPK != null && !this.curPlanAsignaturaPK.equals(other.curPlanAsignaturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.plan_curricular.CurPlanAsignatura[curPlanAsignaturaPK=" + curPlanAsignaturaPK + "]";
    }

}
