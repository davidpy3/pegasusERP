package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "esc_estado_trabajador")
public class EscEstadoTrabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Short idEstado;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escEstadoTrabajador")
    private List<EscPersonal> escPersonalList;

    public EscEstadoTrabajador() {
    }

    public EscEstadoTrabajador(Short idEstado) {
        this.idEstado = idEstado;
    }

    public EscEstadoTrabajador(Short idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Short idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<EscPersonal> getEscPersonalList() {
        return escPersonalList;
    }

    public void setEscPersonalList(List<EscPersonal> escPersonalList) {
        this.escPersonalList = escPersonalList;
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
        if (!(object instanceof EscEstadoTrabajador)) {
            return false;
        }
        EscEstadoTrabajador other = (EscEstadoTrabajador) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscEstadoTrabajador[ idEstado=" + idEstado + " ]";
    }
    
}
