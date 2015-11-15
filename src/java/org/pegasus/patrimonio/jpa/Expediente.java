/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "expediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e"),
    @NamedQuery(name = "Expediente.findByAnoEje", query = "SELECT e FROM Expediente e WHERE e.expedientePK.anoEje = :anoEje"),
    @NamedQuery(name = "Expediente.findByNExpediente", query = "SELECT e FROM Expediente e WHERE e.expedientePK.nExpediente = :nExpediente"),
    @NamedQuery(name = "Expediente.findByFecha", query = "SELECT e FROM Expediente e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Expediente.findByDescripcionExp", query = "SELECT e FROM Expediente e WHERE e.descripcionExp = :descripcionExp"),
    @NamedQuery(name = "Expediente.findByCodOficina", query = "SELECT e FROM Expediente e WHERE e.codOficina = :codOficina"),
    @NamedQuery(name = "Expediente.findByDni", query = "SELECT e FROM Expediente e WHERE e.dni = :dni"),
    @NamedQuery(name = "Expediente.findByIdCargo", query = "SELECT e FROM Expediente e WHERE e.idCargo = :idCargo"),
    @NamedQuery(name = "Expediente.findByExpOrigen", query = "SELECT e FROM Expediente e WHERE e.expOrigen = :expOrigen"),
    @NamedQuery(name = "Expediente.findByFlgOrigen", query = "SELECT e FROM Expediente e WHERE e.flgOrigen = :flgOrigen"),
    @NamedQuery(name = "Expediente.findByEstado", query = "SELECT e FROM Expediente e WHERE e.estado = :estado")})
public class Expediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExpedientePK expedientePK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 75)
    @Column(name = "descripcion_exp")
    private String descripcionExp;
    @Size(max = 5)
    @Column(name = "cod_oficina")
    private String codOficina;
    @Size(max = 8)
    @Column(name = "dni")
    private String dni;
    @Column(name = "id_cargo")
    private Integer idCargo;
    @Column(name = "exp_origen")
    private BigInteger expOrigen;
    @Column(name = "flg_origen")
    private Character flgOrigen;
    @Column(name = "estado")
    private Character estado;

    public Expediente() {
    }

    public Expediente(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public Expediente(String anoEje, long nExpediente) {
        this.expedientePK = new ExpedientePK(anoEje, nExpediente);
    }

    public ExpedientePK getExpedientePK() {
        return expedientePK;
    }

    public void setExpedientePK(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getCodOficina() {
        return codOficina;
    }

    public void setCodOficina(String codOficina) {
        this.codOficina = codOficina;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public BigInteger getExpOrigen() {
        return expOrigen;
    }

    public void setExpOrigen(BigInteger expOrigen) {
        this.expOrigen = expOrigen;
    }

    public Character getFlgOrigen() {
        return flgOrigen;
    }

    public void setFlgOrigen(Character flgOrigen) {
        this.flgOrigen = flgOrigen;
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
        hash += (expedientePK != null ? expedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.expedientePK == null && other.expedientePK != null) || (this.expedientePK != null && !this.expedientePK.equals(other.expedientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Expediente[ expedientePK=" + expedientePK + " ]";
    }
    
}
