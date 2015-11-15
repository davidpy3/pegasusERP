package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.jsuns.app.User;

@Entity
@Table(name = "son_solicitud")
public class SRequerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_requerimiento")
    private Integer idSolicitud;
    @Column(name = "fec_sol")
    @Temporal(TemporalType.DATE)
    private Date fecSol;
    @Column(name = "fec_env")
    @Temporal(TemporalType.DATE)
    private Date fecEnv;
    @Column(name = "plazo")
    private Integer plazo;
    @Column(name = "id_alm_ori")
    private Integer idAlmOri;
    @Column(name = "id_alm_des")
    private Integer idAlmDes;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    @ManyToOne(optional = false)
    private User nick;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimiento")
    private Collection<SRequerimientoDetalle> requerimientoDetalleCollection;

    public SRequerimiento() {
    }

    public SRequerimiento(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFecSol() {
        return fecSol;
    }

    public void setFecSol(Date fecSol) {
        this.fecSol = fecSol;
    }

    public Date getFecEnv() {
        return fecEnv;
    }

    public void setFecEnv(Date fecEnv) {
        this.fecEnv = fecEnv;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public Integer getIdAlmOri() {
        return idAlmOri;
    }

    public void setIdAlmOri(Integer idAlmOri) {
        this.idAlmOri = idAlmOri;
    }

    public Integer getIdAlmDes() {
        return idAlmDes;
    }

    public void setIdAlmDes(Integer idAlmDes) {
        this.idAlmDes = idAlmDes;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public User getNick() {
        return nick;
    }

    public void setNick(User nick) {
        this.nick = nick;
    }

    @XmlTransient
    public Collection<SRequerimientoDetalle> getSolicitudDetalleCollection() {
        return requerimientoDetalleCollection;
    }

    public void setSolicitudDetalleCollection(Collection<SRequerimientoDetalle> solicitudDetalleCollection) {
        this.requerimientoDetalleCollection = solicitudDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SRequerimiento)) {
            return false;
        }
        SRequerimiento other = (SRequerimiento) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.SolicitudArticulo[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
