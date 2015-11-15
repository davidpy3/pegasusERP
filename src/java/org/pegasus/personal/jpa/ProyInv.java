/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erick alarcon
 */
@Entity
@Table(name = "proy_inv")
@NamedQueries({
    @NamedQuery(name = "ProyInv.findAll", query = "SELECT p FROM ProyInv p")})
public class ProyInv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyInvPK proyInvPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nivel_gob")
    private String nivelGob;
    @Column(name = "snip")
    private String snip;
    @Column(name = "funcion")
    private String funcion;
    @Column(name = "monto")
    private String monto;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.DATE)
    private Date fecReg;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "distrito")
    private String distrito;

    public ProyInv() {
    }

    public ProyInv(ProyInvPK proyInvPK) {
        this.proyInvPK = proyInvPK;
    }

    public ProyInv(String anoEje, int idProy) {
        this.proyInvPK = new ProyInvPK(anoEje, idProy);
    }

    public ProyInvPK getProyInvPK() {
        return proyInvPK;
    }

    public void setProyInvPK(ProyInvPK proyInvPK) {
        this.proyInvPK = proyInvPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelGob() {
        return nivelGob;
    }

    public void setNivelGob(String nivelGob) {
        this.nivelGob = nivelGob;
    }

    public String getSnip() {
        return snip;
    }

    public void setSnip(String snip) {
        this.snip = snip;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyInvPK != null ? proyInvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyInv)) {
            return false;
        }
        ProyInv other = (ProyInv) object;
        if ((this.proyInvPK == null && other.proyInvPK != null) || (this.proyInvPK != null && !this.proyInvPK.equals(other.proyInvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.ProyInv[ proyInvPK=" + proyInvPK + " ]";
    }
    
}
