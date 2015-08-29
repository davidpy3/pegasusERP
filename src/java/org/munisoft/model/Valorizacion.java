/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Valorizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valorizacion.findAll", query = "SELECT v FROM Valorizacion v"),
    @NamedQuery(name = "Valorizacion.findByAnoEje", query = "SELECT v FROM Valorizacion v WHERE v.valorizacionPK.anoEje = :anoEje"),
    @NamedQuery(name = "Valorizacion.findByTipo", query = "SELECT v FROM Valorizacion v WHERE v.valorizacionPK.tipo = :tipo"),
    @NamedQuery(name = "Valorizacion.findByNOrden", query = "SELECT v FROM Valorizacion v WHERE v.valorizacionPK.nOrden = :nOrden"),
    @NamedQuery(name = "Valorizacion.findByNValor", query = "SELECT v FROM Valorizacion v WHERE v.valorizacionPK.nValor = :nValor"),
    @NamedQuery(name = "Valorizacion.findByFecha", query = "SELECT v FROM Valorizacion v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Valorizacion.findByTipoValor", query = "SELECT v FROM Valorizacion v WHERE v.valorizacionPK.tipoValor = :tipoValor"),
    @NamedQuery(name = "Valorizacion.findByPorcProp", query = "SELECT v FROM Valorizacion v WHERE v.porcProp = :porcProp"),
    @NamedQuery(name = "Valorizacion.findByPorcValor", query = "SELECT v FROM Valorizacion v WHERE v.porcValor = :porcValor"),
    @NamedQuery(name = "Valorizacion.findByMontoProp", query = "SELECT v FROM Valorizacion v WHERE v.montoProp = :montoProp"),
    @NamedQuery(name = "Valorizacion.findByMontoValor", query = "SELECT v FROM Valorizacion v WHERE v.montoValor = :montoValor"),
    @NamedQuery(name = "Valorizacion.findByEstado", query = "SELECT v FROM Valorizacion v WHERE v.estado = :estado")})
public class Valorizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValorizacionPK valorizacionPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "porc_prop")
    private Integer porcProp;
    @Column(name = "porc_valor")
    private Integer porcValor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_prop")
    private BigDecimal montoProp;
    @Column(name = "monto_valor")
    private BigDecimal montoValor;
    @Column(name = "estado")
    private Character estado;

    public Valorizacion() {
    }

    public Valorizacion(ValorizacionPK valorizacionPK) {
        this.valorizacionPK = valorizacionPK;
    }

    public Valorizacion(String anoEje, Character tipo, int nOrden, int nValor, Character tipoValor) {
        this.valorizacionPK = new ValorizacionPK(anoEje, tipo, nOrden, nValor, tipoValor);
    }

    public ValorizacionPK getValorizacionPK() {
        return valorizacionPK;
    }

    public void setValorizacionPK(ValorizacionPK valorizacionPK) {
        this.valorizacionPK = valorizacionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPorcProp() {
        return porcProp;
    }

    public void setPorcProp(Integer porcProp) {
        this.porcProp = porcProp;
    }

    public Integer getPorcValor() {
        return porcValor;
    }

    public void setPorcValor(Integer porcValor) {
        this.porcValor = porcValor;
    }

    public BigDecimal getMontoProp() {
        return montoProp;
    }

    public void setMontoProp(BigDecimal montoProp) {
        this.montoProp = montoProp;
    }

    public BigDecimal getMontoValor() {
        return montoValor;
    }

    public void setMontoValor(BigDecimal montoValor) {
        this.montoValor = montoValor;
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
        hash += (valorizacionPK != null ? valorizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valorizacion)) {
            return false;
        }
        Valorizacion other = (Valorizacion) object;
        if ((this.valorizacionPK == null && other.valorizacionPK != null) || (this.valorizacionPK != null && !this.valorizacionPK.equals(other.valorizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Valorizacion[ valorizacionPK=" + valorizacionPK + " ]";
    }
    
}
