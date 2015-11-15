/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "son_pago_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoEmpleado.findAll", query = "SELECT p FROM PagoEmpleado p"),
    @NamedQuery(name = "PagoEmpleado.findByIdPago", query = "SELECT p FROM PagoEmpleado p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "PagoEmpleado.findByMonto", query = "SELECT p FROM PagoEmpleado p WHERE p.monto = :monto"),
    @NamedQuery(name = "PagoEmpleado.findByFecha", query = "SELECT p FROM PagoEmpleado p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PagoEmpleado.findByEstado", query = "SELECT p FROM PagoEmpleado p WHERE p.estado = :estado"),
    @NamedQuery(name = "PagoEmpleado.findByAdelanto", query = "SELECT p FROM PagoEmpleado p WHERE p.adelanto = :adelanto"),
    @NamedQuery(name = "PagoEmpleado.findByComision", query = "SELECT p FROM PagoEmpleado p WHERE p.comision = :comision"),
    @NamedQuery(name = "PagoEmpleado.findBySalario", query = "SELECT p FROM PagoEmpleado p WHERE p.salario = :salario")})
public class PagoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "adelanto")
    private Double adelanto;
    @Column(name = "comision")
    private Double comision;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Empleado dni;

    public PagoEmpleado() {
    }

    public PagoEmpleado(Integer idPago) {
        this.idPago = idPago;
    }

    public PagoEmpleado(Integer idPago, double salario) {
        this.idPago = idPago;
        this.salario = salario;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Double adelanto) {
        this.adelanto = adelanto;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Empleado getDni() {
        return dni;
    }

    public void setDni(Empleado dni) {
        this.dni = dni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoEmpleado)) {
            return false;
        }
        PagoEmpleado other = (PagoEmpleado) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.PagoEmpleado[ idPago=" + idPago + " ]";
    }
    
}
