/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Epersonal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EPersonal.findAll", query = "SELECT e FROM EPersonal e"),
    @NamedQuery(name = "EPersonal.findByDni", query = "SELECT e FROM EPersonal e WHERE e.dni = :dni"),
    @NamedQuery(name = "EPersonal.findByApematerno", query = "SELECT e FROM EPersonal e WHERE e.apematerno = :apematerno"),
    @NamedQuery(name = "EPersonal.findByApepaterno", query = "SELECT e FROM EPersonal e WHERE e.apepaterno = :apepaterno"),
    @NamedQuery(name = "EPersonal.findByNombres", query = "SELECT e FROM EPersonal e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "EPersonal.findByFecnac", query = "SELECT e FROM EPersonal e WHERE e.fecnac = :fecnac"),
    @NamedQuery(name = "EPersonal.findBySexo", query = "SELECT e FROM EPersonal e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "EPersonal.findByIDcargo", query = "SELECT e FROM EPersonal e WHERE e.iDcargo = :iDcargo"),
    @NamedQuery(name = "EPersonal.findByIDnivel", query = "SELECT e FROM EPersonal e WHERE e.iDnivel = :iDnivel"),
    @NamedQuery(name = "EPersonal.findByIDcondicion", query = "SELECT e FROM EPersonal e WHERE e.iDcondicion = :iDcondicion"),
    @NamedQuery(name = "EPersonal.findByIDoficina", query = "SELECT e FROM EPersonal e WHERE e.iDoficina = :iDoficina"),
    @NamedQuery(name = "EPersonal.findByFotografia", query = "SELECT e FROM EPersonal e WHERE e.fotografia = :fotografia")})
public class EPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 70)
    @Column(name = "Ape_materno")
    private String apematerno;
    @Size(max = 70)
    @Column(name = "Ape_paterno")
    private String apepaterno;
    @Size(max = 70)
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Fec_nac")
    @Temporal(TemporalType.DATE)
    private Date fecnac;
    @Column(name = "Sexo")
    private Character sexo;
    @Size(max = 3)
    @Column(name = "ID_cargo")
    private String iDcargo;
    @Size(max = 2)
    @Column(name = "ID_nivel")
    private String iDnivel;
    @Column(name = "ID_condicion")
    private Integer iDcondicion;
    @Size(max = 2)
    @Column(name = "ID_oficina")
    private String iDoficina;
    @Size(max = 10)
    @Column(name = "Fotografia")
    private String fotografia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ePersonal")
    private Collection<RHaberes> rHaberesCollection;

    public EPersonal() {
    }

    public EPersonal(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApematerno() {
        return apematerno;
    }

    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getIDcargo() {
        return iDcargo;
    }

    public void setIDcargo(String iDcargo) {
        this.iDcargo = iDcargo;
    }

    public String getIDnivel() {
        return iDnivel;
    }

    public void setIDnivel(String iDnivel) {
        this.iDnivel = iDnivel;
    }

    public Integer getIDcondicion() {
        return iDcondicion;
    }

    public void setIDcondicion(Integer iDcondicion) {
        this.iDcondicion = iDcondicion;
    }

    public String getIDoficina() {
        return iDoficina;
    }

    public void setIDoficina(String iDoficina) {
        this.iDoficina = iDoficina;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    @XmlTransient
    public Collection<RHaberes> getRHaberesCollection() {
        return rHaberesCollection;
    }

    public void setRHaberesCollection(Collection<RHaberes> rHaberesCollection) {
        this.rHaberesCollection = rHaberesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EPersonal)) {
            return false;
        }
        EPersonal other = (EPersonal) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.EPersonal[ dni=" + dni + " ]";
    }
    
}
