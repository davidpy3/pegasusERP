package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "sgc_estado")
@NamedQueries({
    @NamedQuery(name = "SgcEstado.findAll", query = "SELECT s FROM SgcEstado s")})
public class SgcEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private String idEstado;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    public SgcEstado() {
    }

    public SgcEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public SgcEstado(String idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcEstado)) {
            return false;
        }
        SgcEstado other = (SgcEstado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.jpa.SgcEstado[ idEstado=" + idEstado + " ]";
    }
    
}
