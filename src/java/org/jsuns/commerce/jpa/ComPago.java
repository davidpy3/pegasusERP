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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_pago")
@NamedQueries({
    @NamedQuery(name = "ComPago.findAll", query = "SELECT c FROM ComPago c")})
public class ComPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cajope")
    private Integer idCajope;
    @Column(name = "id_arqueo")
    private Integer idArqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_movimiento")
    private short idMovimiento;
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Column(name = "id_motivo")
    private Integer idMotivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_medio")
    private Character idMedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_moneda")
    private int idMoneda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "razon_cambio")
    private float razonCambio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vuelto")
    private float vuelto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado")
    private Character idEstado;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "id_dir")
    private Integer idDir;

    public ComPago() {
    }

    public ComPago(Integer idCajope) {
        this.idCajope = idCajope;
    }

    public ComPago(Integer idCajope, short idMovimiento, Character idMedio, float cantidad, int idMoneda, float razonCambio, float vuelto, Character idEstado, Date fecha) {
        this.idCajope = idCajope;
        this.idMovimiento = idMovimiento;
        this.idMedio = idMedio;
        this.cantidad = cantidad;
        this.idMoneda = idMoneda;
        this.razonCambio = razonCambio;
        this.vuelto = vuelto;
        this.idEstado = idEstado;
        this.fecha = fecha;
    }

    public Integer getIdCajope() {
        return idCajope;
    }

    public void setIdCajope(Integer idCajope) {
        this.idCajope = idCajope;
    }

    public Integer getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(Integer idArqueo) {
        this.idArqueo = idArqueo;
    }

    public short getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(short idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Character getIdMedio() {
        return idMedio;
    }

    public void setIdMedio(Character idMedio) {
        this.idMedio = idMedio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public float getRazonCambio() {
        return razonCambio;
    }

    public void setRazonCambio(float razonCambio) {
        this.razonCambio = razonCambio;
    }

    public float getVuelto() {
        return vuelto;
    }

    public void setVuelto(float vuelto) {
        this.vuelto = vuelto;
    }

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCajope != null ? idCajope.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPago)) {
            return false;
        }
        ComPago other = (ComPago) object;
        if ((this.idCajope == null && other.idCajope != null) || (this.idCajope != null && !this.idCajope.equals(other.idCajope))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComPago[ idCajope=" + idCajope + " ]";
    }
    
}
