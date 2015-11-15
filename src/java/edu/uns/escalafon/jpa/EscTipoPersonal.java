package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import edu.uns.escalafon.jpa.EscCarreraLaboral;
import edu.uns.escalafon.jpa.EscContratosOtros;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "esc_tipo_personal")
public class EscTipoPersonal implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<EscContratosOtros> escContratosOtrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private List<EscCarreraLaboral> escCarreraLaboralList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Short idTipo;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "id_modpers")
    private Short idModpers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escTipoPersonal")
    private Collection<EscPersonal> escPersonalCollection;

    public EscTipoPersonal() {
    }

    public EscTipoPersonal(Short idTipo) {
        this.idTipo = idTipo;
    }

    public EscTipoPersonal(Short idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public Short getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Short idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getIdModpers() {
        return idModpers;
    }

    public void setIdModpers(Short idModpers) {
        this.idModpers = idModpers;
    }

    public Collection<EscPersonal> getEscPersonalCollection() {
        return escPersonalCollection;
    }

    public void setEscPersonalCollection(Collection<EscPersonal> escPersonalCollection) {
        this.escPersonalCollection = escPersonalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscTipoPersonal)) {
            return false;
        }
        EscTipoPersonal other = (EscTipoPersonal) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.ocper.EscTipoPersonal[idTipo=" + idTipo + "]";
    }

    @XmlTransient
    public List<EscContratosOtros> getEscContratosOtrosList() {
        return escContratosOtrosList;
    }

    public void setEscContratosOtrosList(List<EscContratosOtros> escContratosOtrosList) {
        this.escContratosOtrosList = escContratosOtrosList;
    }

    @XmlTransient
    public List<EscCarreraLaboral> getEscCarreraLaboralList() {
        return escCarreraLaboralList;
    }

    public void setEscCarreraLaboralList(List<EscCarreraLaboral> escCarreraLaboralList) {
        this.escCarreraLaboralList = escCarreraLaboralList;
    }

}
