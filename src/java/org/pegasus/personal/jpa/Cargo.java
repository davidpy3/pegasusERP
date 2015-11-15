package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cargo")
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cargo")
    private Integer idCargo;
    @Size(max = 6)
    @Column(name = "cod_pdt")
    private String codPdt;
    @Size(max = 70)
    @Column(name = "nom_cargo")
    private String nomCargo;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "orden_firma")
    private Integer ordenFirma;
    @Size(max = 15)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Size(max = 50)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "estado")
    private Character estado;

    public Cargo() {
    }

    public Cargo(Integer iDcargo) {
        this.idCargo = iDcargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer iDcargo) {
        this.idCargo = iDcargo;
    }

    public String getCodPdt() {
        return codPdt;
    }

    public void setCodPdt(String codPdt) {
        this.codPdt = codPdt;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOrdenFirma() {
        return ordenFirma;
    }

    public void setOrdenFirma(Integer ordenFirma) {
        this.ordenFirma = ordenFirma;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
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
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Cargo[ iDcargo=" + idCargo + " ]";
    }
    
}
