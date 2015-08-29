/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByAnoEje", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionPK.anoEje = :anoEje"),
    @NamedQuery(name = "Cotizacion.findByClasifica", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionPK.clasifica = :clasifica"),
    @NamedQuery(name = "Cotizacion.findByNRequer", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionPK.nRequer = :nRequer"),
    @NamedQuery(name = "Cotizacion.findByNCotiza", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionPK.nCotiza = :nCotiza"),
    @NamedQuery(name = "Cotizacion.findByFecha", query = "SELECT c FROM Cotizacion c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cotizacion.findByCondiciones", query = "SELECT c FROM Cotizacion c WHERE c.condiciones = :condiciones"),
    @NamedQuery(name = "Cotizacion.findByTotal", query = "SELECT c FROM Cotizacion c WHERE c.total = :total"),
    @NamedQuery(name = "Cotizacion.findByObservacion", query = "SELECT c FROM Cotizacion c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "Cotizacion.findByGanador", query = "SELECT c FROM Cotizacion c WHERE c.ganador = :ganador")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CotizacionPK cotizacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 1000)
    @Column(name = "condiciones")
    private String condiciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "ganador")
    private Character ganador;

    public Cotizacion() {
    }

    public Cotizacion(CotizacionPK cotizacionPK) {
        this.cotizacionPK = cotizacionPK;
    }

    public Cotizacion(CotizacionPK cotizacionPK, Date fecha) {
        this.cotizacionPK = cotizacionPK;
        this.fecha = fecha;
    }

    public Cotizacion(String anoEje, Character clasifica, int nRequer, int nCotiza) {
        this.cotizacionPK = new CotizacionPK(anoEje, clasifica, nRequer, nCotiza);
    }

    public CotizacionPK getCotizacionPK() {
        return cotizacionPK;
    }

    public void setCotizacionPK(CotizacionPK cotizacionPK) {
        this.cotizacionPK = cotizacionPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getGanador() {
        return ganador;
    }

    public void setGanador(Character ganador) {
        this.ganador = ganador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotizacionPK != null ? cotizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.cotizacionPK == null && other.cotizacionPK != null) || (this.cotizacionPK != null && !this.cotizacionPK.equals(other.cotizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Cotizacion[ cotizacionPK=" + cotizacionPK + " ]";
    }
    
}
