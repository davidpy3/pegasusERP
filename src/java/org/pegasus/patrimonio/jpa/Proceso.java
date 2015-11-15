/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p"),
    @NamedQuery(name = "Proceso.findByAnoEje", query = "SELECT p FROM Proceso p WHERE p.procesoPK.anoEje = :anoEje"),
    @NamedQuery(name = "Proceso.findByClasifica", query = "SELECT p FROM Proceso p WHERE p.procesoPK.clasifica = :clasifica"),
    @NamedQuery(name = "Proceso.findByNRequer", query = "SELECT p FROM Proceso p WHERE p.procesoPK.nRequer = :nRequer"),
    @NamedQuery(name = "Proceso.findByItem", query = "SELECT p FROM Proceso p WHERE p.procesoPK.item = :item"),
    @NamedQuery(name = "Proceso.findByAnoProceso", query = "SELECT p FROM Proceso p WHERE p.anoProceso = :anoProceso"),
    @NamedQuery(name = "Proceso.findByTipoProc", query = "SELECT p FROM Proceso p WHERE p.tipoProc = :tipoProc"),
    @NamedQuery(name = "Proceso.findByNProc", query = "SELECT p FROM Proceso p WHERE p.nProc = :nProc"),
    @NamedQuery(name = "Proceso.findByContrato", query = "SELECT p FROM Proceso p WHERE p.contrato = :contrato"),
    @NamedQuery(name = "Proceso.findByRUCBuenaPro", query = "SELECT p FROM Proceso p WHERE p.rUCBuenaPro = :rUCBuenaPro"),
    @NamedQuery(name = "Proceso.findByFechaLanza", query = "SELECT p FROM Proceso p WHERE p.fechaLanza = :fechaLanza"),
    @NamedQuery(name = "Proceso.findByFechaVenta", query = "SELECT p FROM Proceso p WHERE p.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Proceso.findByDiasVenta", query = "SELECT p FROM Proceso p WHERE p.diasVenta = :diasVenta"),
    @NamedQuery(name = "Proceso.findByFechaAdj", query = "SELECT p FROM Proceso p WHERE p.fechaAdj = :fechaAdj"),
    @NamedQuery(name = "Proceso.findByMontoAdj", query = "SELECT p FROM Proceso p WHERE p.montoAdj = :montoAdj"),
    @NamedQuery(name = "Proceso.findByIdComite", query = "SELECT p FROM Proceso p WHERE p.idComite = :idComite"),
    @NamedQuery(name = "Proceso.findByJustificacion", query = "SELECT p FROM Proceso p WHERE p.justificacion = :justificacion")})
public class Proceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoPK procesoPK;
    @Size(max = 4)
    @Column(name = "ano_proceso")
    private String anoProceso;
    @Size(max = 3)
    @Column(name = "tipo_proc")
    private String tipoProc;
    @Column(name = "n_proc")
    private Integer nProc;
    @Column(name = "Contrato")
    private Integer contrato;
    @Size(max = 11)
    @Column(name = "RUC_Buena_Pro")
    private String rUCBuenaPro;
    @Column(name = "fecha_lanza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLanza;
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @Column(name = "dias_venta")
    private Integer diasVenta;
    @Column(name = "Fecha_Adj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdj;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto_Adj")
    private BigDecimal montoAdj;
    @Column(name = "id_comite")
    private Integer idComite;
    @Size(max = 200)
    @Column(name = "Justificacion")
    private String justificacion;

    public Proceso() {
    }

    public Proceso(ProcesoPK procesoPK) {
        this.procesoPK = procesoPK;
    }

    public Proceso(String anoEje, Character clasifica, int nRequer, int item) {
        this.procesoPK = new ProcesoPK(anoEje, clasifica, nRequer, item);
    }

    public ProcesoPK getProcesoPK() {
        return procesoPK;
    }

    public void setProcesoPK(ProcesoPK procesoPK) {
        this.procesoPK = procesoPK;
    }

    public String getAnoProceso() {
        return anoProceso;
    }

    public void setAnoProceso(String anoProceso) {
        this.anoProceso = anoProceso;
    }

    public String getTipoProc() {
        return tipoProc;
    }

    public void setTipoProc(String tipoProc) {
        this.tipoProc = tipoProc;
    }

    public Integer getNProc() {
        return nProc;
    }

    public void setNProc(Integer nProc) {
        this.nProc = nProc;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public String getRUCBuenaPro() {
        return rUCBuenaPro;
    }

    public void setRUCBuenaPro(String rUCBuenaPro) {
        this.rUCBuenaPro = rUCBuenaPro;
    }

    public Date getFechaLanza() {
        return fechaLanza;
    }

    public void setFechaLanza(Date fechaLanza) {
        this.fechaLanza = fechaLanza;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Integer getDiasVenta() {
        return diasVenta;
    }

    public void setDiasVenta(Integer diasVenta) {
        this.diasVenta = diasVenta;
    }

    public Date getFechaAdj() {
        return fechaAdj;
    }

    public void setFechaAdj(Date fechaAdj) {
        this.fechaAdj = fechaAdj;
    }

    public BigDecimal getMontoAdj() {
        return montoAdj;
    }

    public void setMontoAdj(BigDecimal montoAdj) {
        this.montoAdj = montoAdj;
    }

    public Integer getIdComite() {
        return idComite;
    }

    public void setIdComite(Integer idComite) {
        this.idComite = idComite;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoPK != null ? procesoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.procesoPK == null && other.procesoPK != null) || (this.procesoPK != null && !this.procesoPK.equals(other.procesoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Proceso[ procesoPK=" + procesoPK + " ]";
    }
    
}
