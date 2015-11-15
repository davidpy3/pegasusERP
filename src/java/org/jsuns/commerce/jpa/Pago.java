/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "son_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pago.findByDni", query = "SELECT p FROM Pago p WHERE p.dni = :dni"),
    @NamedQuery(name = "Pago.findByFecha", query = "SELECT p FROM Pago p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pago.findByComision", query = "SELECT p FROM Pago p WHERE p.comision = :comision"),
    @NamedQuery(name = "Pago.findByOtroIngreso", query = "SELECT p FROM Pago p WHERE p.otroIngreso = :otroIngreso"),
    @NamedQuery(name = "Pago.findByAdelanto", query = "SELECT p FROM Pago p WHERE p.adelanto = :adelanto"),
    @NamedQuery(name = "Pago.findByOtroDescuento", query = "SELECT p FROM Pago p WHERE p.otroDescuento = :otroDescuento"),
    @NamedQuery(name = "Pago.findBySalario", query = "SELECT p FROM Pago p WHERE p.salario = :salario")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "comision")
    private double comision;
    @Basic(optional = false)
    @Column(name = "otro_ingreso")
    private double otroIngreso;
    @Basic(optional = false)
    @Column(name = "adelanto")
    private double adelanto;
    @Basic(optional = false)
    @Column(name = "otro_descuento")
    private double otroDescuento;
    @Basic(optional = false)
    @Column(name = "salario")
    private double salario;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, String dni, Date fecha, double comision, double otroIngreso, double adelanto, double otroDescuento, double salario) {
        this.idPago = idPago;
        this.dni = dni;
        this.fecha = fecha;
        this.comision = comision;
        this.otroIngreso = otroIngreso;
        this.adelanto = adelanto;
        this.otroDescuento = otroDescuento;
        this.salario = salario;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getOtroIngreso() {
        return otroIngreso;
    }

    public void setOtroIngreso(double otroIngreso) {
        this.otroIngreso = otroIngreso;
    }

    public double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(double adelanto) {
        this.adelanto = adelanto;
    }

    public double getOtroDescuento() {
        return otroDescuento;
    }

    public void setOtroDescuento(double otroDescuento) {
        this.otroDescuento = otroDescuento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.Pago[ idPago=" + idPago + " ]";
    }
    
}
