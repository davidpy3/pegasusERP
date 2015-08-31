
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Personal_dscto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalDscto.findAll", query = "SELECT p FROM PersonalDscto p"),
    @NamedQuery(name = "PersonalDscto.findByDni", query = "SELECT p FROM PersonalDscto p WHERE p.personalDsctoPK.dni = :dni"),
    @NamedQuery(name = "PersonalDscto.findByCodigo", query = "SELECT p FROM PersonalDscto p WHERE p.personalDsctoPK.codigo = :codigo"),
    @NamedQuery(name = "PersonalDscto.findByMonto", query = "SELECT p FROM PersonalDscto p WHERE p.monto = :monto"),
    @NamedQuery(name = "PersonalDscto.findByPorcentaje", query = "SELECT p FROM PersonalDscto p WHERE p.porcentaje = :porcentaje"),
    @NamedQuery(name = "PersonalDscto.findByFechaIni", query = "SELECT p FROM PersonalDscto p WHERE p.fechaIni = :fechaIni"),
    @NamedQuery(name = "PersonalDscto.findByFechaFin", query = "SELECT p FROM PersonalDscto p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "PersonalDscto.findByGlosa", query = "SELECT p FROM PersonalDscto p WHERE p.glosa = :glosa"),
    @NamedQuery(name = "PersonalDscto.findByEstado", query = "SELECT p FROM PersonalDscto p WHERE p.estado = :estado")})
public class PersonalDscto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonalDsctoPK personalDsctoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Size(max = 80)
    @Column(name = "glosa")
    private String glosa;
    @Column(name = "estado")
    private Character estado;

    public PersonalDscto() {
    }

    public PersonalDscto(PersonalDsctoPK personalDsctoPK) {
        this.personalDsctoPK = personalDsctoPK;
    }

    public PersonalDscto(String dni, String codigo) {
        this.personalDsctoPK = new PersonalDsctoPK(dni, codigo);
    }

    public PersonalDsctoPK getPersonalDsctoPK() {
        return personalDsctoPK;
    }

    public void setPersonalDsctoPK(PersonalDsctoPK personalDsctoPK) {
        this.personalDsctoPK = personalDsctoPK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personalDsctoPK != null ? personalDsctoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalDscto)) {
            return false;
        }
        PersonalDscto other = (PersonalDscto) object;
        if ((this.personalDsctoPK == null && other.personalDsctoPK != null) || (this.personalDsctoPK != null && !this.personalDsctoPK.equals(other.personalDsctoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PersonalDscto[ personalDsctoPK=" + personalDsctoPK + " ]";
    }
    
}
