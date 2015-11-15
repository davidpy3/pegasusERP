package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.jsuns.commerce.jpa.ComArticulo;

@Entity
@Table(name = "son_solicitud_detalle")
public class SRequerimientoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudDetallePK solicitudDetallePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cant_sol")
    private Double cantSol;
    @Column(name = "cant_env")
    private Double cantEnv;
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ComArticulo articulo;

    @JoinColumn(name = "id_requerimiento", referencedColumnName = "id_requerimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SRequerimiento requerimiento;

    public SRequerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(SRequerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }
    
    
    public SRequerimientoDetalle() {
    }

    public SRequerimientoDetalle(SolicitudDetallePK solicitudDetallePK) {
        this.solicitudDetallePK = solicitudDetallePK;
    }

    public SRequerimientoDetalle(int idSolicitud, int idArticulo) {
        this.solicitudDetallePK = new SolicitudDetallePK(idSolicitud, idArticulo);
    }

    public SolicitudDetallePK getSolicitudDetallePK() {
        return solicitudDetallePK;
    }

    public void setSolicitudDetallePK(SolicitudDetallePK solicitudDetallePK) {
        this.solicitudDetallePK = solicitudDetallePK;
    }

    public Double getCantSol() {
        return cantSol;
    }

    public void setCantSol(Double cantSol) {
        this.cantSol = cantSol;
    }

    public Double getCantEnv() {
        return cantEnv;
    }

    public void setCantEnv(Double cantEnv) {
        this.cantEnv = cantEnv;
    }

    public ComArticulo getArticulo() {
        return articulo;
    }

    public void setArticulo(ComArticulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudDetallePK != null ? solicitudDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SRequerimientoDetalle)) {
            return false;
        }
        SRequerimientoDetalle other = (SRequerimientoDetalle) object;
        if ((this.solicitudDetallePK == null && other.solicitudDetallePK != null) || (this.solicitudDetallePK != null && !this.solicitudDetallePK.equals(other.solicitudDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.SolicitudDetalle[ solicitudDetallePK=" + solicitudDetallePK + " ]";
    }
    
}
