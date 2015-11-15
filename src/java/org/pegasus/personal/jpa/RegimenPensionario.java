package org.pegasus.personal.jpa;

import org.pegasus.personal.jpa.Personal;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "regimen_pensionario")
public class RegimenPensionario implements Serializable {
    @OneToMany(mappedBy = "regPension")
    private Collection<Personal> personalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "reg_pension")
    private String id;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "abrev")
    private String abrev;
    @Size(max = 2)
    @Column(name = "afpnet")
    private String afpnet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aporte")
    private BigDecimal aporte;
    @Column(name = "prima")
    private BigDecimal prima;
    @Column(name = "comision")
    private BigDecimal comision;

    public RegimenPensionario() {
    }

    public RegimenPensionario(String regPension) {
        this.id = regPension;
    }

    public String getId() {
        return id;
    }

    public void setId(String regPension) {
        this.id = regPension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getAfpnet() {
        return afpnet;
    }

    public void setAfpnet(String afpnet) {
        this.afpnet = afpnet;
    }

    public BigDecimal getAporte() {
        return aporte;
    }

    public void setAporte(BigDecimal aporte) {
        this.aporte = aporte;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegimenPensionario)) {
            return false;
        }
        RegimenPensionario other = (RegimenPensionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.RegimenPensionario[ regPension=" + id + " ]";
    }

    @XmlTransient
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
    }
    
}
