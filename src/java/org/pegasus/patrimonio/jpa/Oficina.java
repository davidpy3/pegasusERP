package org.pegasus.patrimonio.jpa;

import org.pegasus.personal.jpa.Personal;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "oficinas")
public class Oficina implements Serializable {
    @OneToMany(mappedBy = "oficina")
    private Collection<Personal> personalCollection;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OficinaPK oficinaPK;
    @Size(max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Size(max = 100)
    @Column(name = "oficina")
    private String oficina;
    @Size(max = 10)
    @Column(name = "abrev")
    private String abrev;
    @JoinColumn(name = "codarea", referencedColumnName = "codarea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;

    public Oficina() {
    }

    public Oficina(OficinaPK oficinaPK) {
        this.oficinaPK = oficinaPK;
    }

    public Oficina(String codarea, String codoficina) {
        this.oficinaPK = new OficinaPK(codarea, codoficina);
    }

    public OficinaPK getOficinaPK() {
        return oficinaPK;
    }

    public void setOficinaPK(OficinaPK oficinaPK) {
        this.oficinaPK = oficinaPK;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oficinaPK != null ? oficinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.oficinaPK == null && other.oficinaPK != null) || (this.oficinaPK != null && !this.oficinaPK.equals(other.oficinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Oficina[ oficinaPK=" + oficinaPK + " ]";
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }
    
}
