/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "funcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByAnoEje", query = "SELECT f FROM Funcion f WHERE f.funcionPK.anoEje = :anoEje"),
    @NamedQuery(name = "Funcion.findByFuncion", query = "SELECT f FROM Funcion f WHERE f.funcionPK.funcion = :funcion"),
    @NamedQuery(name = "Funcion.findByNombre", query = "SELECT f FROM Funcion f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Funcion.findByCuentaBien", query = "SELECT f FROM Funcion f WHERE f.cuentaBien = :cuentaBien"),
    @NamedQuery(name = "Funcion.findByClasiContrata", query = "SELECT f FROM Funcion f WHERE f.clasiContrata = :clasiContrata"),
    @NamedQuery(name = "Funcion.findByClasiPlanilla", query = "SELECT f FROM Funcion f WHERE f.clasiPlanilla = :clasiPlanilla"),
    @NamedQuery(name = "Funcion.findByClasiBien", query = "SELECT f FROM Funcion f WHERE f.clasiBien = :clasiBien"),
    @NamedQuery(name = "Funcion.findByClasiServicio", query = "SELECT f FROM Funcion f WHERE f.clasiServicio = :clasiServicio"),
    @NamedQuery(name = "Funcion.findByEstado", query = "SELECT f FROM Funcion f WHERE f.estado = :estado")})
public class Funcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionPK funcionPK;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 11)
    @Column(name = "cuenta_bien")
    private String cuentaBien;
    @Size(max = 7)
    @Column(name = "clasi_contrata")
    private String clasiContrata;
    @Size(max = 7)
    @Column(name = "clasi_planilla")
    private String clasiPlanilla;
    @Size(max = 7)
    @Column(name = "clasi_bien")
    private String clasiBien;
    @Size(max = 7)
    @Column(name = "clasi_servicio")
    private String clasiServicio;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcion1")
    private Collection<Programa> programaCollection;

    public Funcion() {
    }

    public Funcion(FuncionPK funcionPK) {
        this.funcionPK = funcionPK;
    }

    public Funcion(String anoEje, String funcion) {
        this.funcionPK = new FuncionPK(anoEje, funcion);
    }

    public FuncionPK getFuncionPK() {
        return funcionPK;
    }

    public void setFuncionPK(FuncionPK funcionPK) {
        this.funcionPK = funcionPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuentaBien() {
        return cuentaBien;
    }

    public void setCuentaBien(String cuentaBien) {
        this.cuentaBien = cuentaBien;
    }

    public String getClasiContrata() {
        return clasiContrata;
    }

    public void setClasiContrata(String clasiContrata) {
        this.clasiContrata = clasiContrata;
    }

    public String getClasiPlanilla() {
        return clasiPlanilla;
    }

    public void setClasiPlanilla(String clasiPlanilla) {
        this.clasiPlanilla = clasiPlanilla;
    }

    public String getClasiBien() {
        return clasiBien;
    }

    public void setClasiBien(String clasiBien) {
        this.clasiBien = clasiBien;
    }

    public String getClasiServicio() {
        return clasiServicio;
    }

    public void setClasiServicio(String clasiServicio) {
        this.clasiServicio = clasiServicio;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Programa> getProgramaCollection() {
        return programaCollection;
    }

    public void setProgramaCollection(Collection<Programa> programaCollection) {
        this.programaCollection = programaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionPK != null ? funcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.funcionPK == null && other.funcionPK != null) || (this.funcionPK != null && !this.funcionPK.equals(other.funcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Funcion[ funcionPK=" + funcionPK + " ]";
    }
    
}
