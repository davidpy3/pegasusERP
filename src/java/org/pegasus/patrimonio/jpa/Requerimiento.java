/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Requerimiento")
public class Requerimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequerimientoPK requerimientoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes")
    private int mes;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Size(max = 7)
    @Column(name = "act_proy")
    private String actProy;
    @Size(max = 7)
    @Column(name = "componente")
    private String componente;
    @Size(max = 2)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1000)
    @Column(name = "condiciones")
    private String condiciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 8)
    @Column(name = "DNI")
    private String dni;
    @Column(name = "ID_cargo")
    private Integer iDcargo;
    @Column(name = "insitu")
    private Integer insitu;
    @Size(max = 200)
    @Column(name = "arch_bases")
    private String archBases;
    @Size(max = 2)
    @Column(name = "grupo")
    private String grupo;
    @Size(max = 2)
    @Column(name = "clase")
    private String clase;
    @Size(max = 10)
    @Column(name = "proc_seleccion")
    private String procSeleccion;
    @Column(name = "igv")
    private Integer igv;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "selec")
    private Character selec;
    @Column(name = "paac")
    private Integer paac;
    @Column(name = "fecha_autoriza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutoriza;
    @Size(max = 3)
    @Column(name = "tipo_proc")
    private String tipoProc;
    @Column(name = "n_proc")
    private Integer nProc;
    @Column(name = "est_seace")
    private Character estSeace;
    @Column(name = "fecha_base")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBase;
    @Column(name = "contrato")
    private Integer contrato;
    @Column(name = "fecha_contrato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaContrato;
    @Column(name = "fecha_fin_contrato")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinContrato;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimiento")
    private Collection<Cotizacion> cotizacionCollection;
*/
    public Requerimiento() {
    }

    public Requerimiento(RequerimientoPK requerimientoPK) {
        this.requerimientoPK = requerimientoPK;
    }

    public Requerimiento(RequerimientoPK requerimientoPK, Date fecha, int mes) {
        this.requerimientoPK = requerimientoPK;
        this.fecha = fecha;
        this.mes = mes;
    }

    public Requerimiento(String anoEje, Character clasifica, int nRequer) {
        this.requerimientoPK = new RequerimientoPK(anoEje, clasifica, nRequer);
    }

    public RequerimientoPK getRequerimientoPK() {
        return requerimientoPK;
    }

    public void setRequerimientoPK(RequerimientoPK requerimientoPK) {
        this.requerimientoPK = requerimientoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getActProy() {
        return actProy;
    }

    public void setActProy(String actProy) {
        this.actProy = actProy;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIDcargo() {
        return iDcargo;
    }

    public void setIDcargo(Integer iDcargo) {
        this.iDcargo = iDcargo;
    }

    public Integer getInsitu() {
        return insitu;
    }

    public void setInsitu(Integer insitu) {
        this.insitu = insitu;
    }

    public String getArchBases() {
        return archBases;
    }

    public void setArchBases(String archBases) {
        this.archBases = archBases;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getProcSeleccion() {
        return procSeleccion;
    }

    public void setProcSeleccion(String procSeleccion) {
        this.procSeleccion = procSeleccion;
    }

    public Integer getIgv() {
        return igv;
    }

    public void setIgv(Integer igv) {
        this.igv = igv;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public Integer getPaac() {
        return paac;
    }

    public void setPaac(Integer paac) {
        this.paac = paac;
    }

    public Date getFechaAutoriza() {
        return fechaAutoriza;
    }

    public void setFechaAutoriza(Date fechaAutoriza) {
        this.fechaAutoriza = fechaAutoriza;
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

    public Character getEstSeace() {
        return estSeace;
    }

    public void setEstSeace(Character estSeace) {
        this.estSeace = estSeace;
    }

    public Date getFechaBase() {
        return fechaBase;
    }

    public void setFechaBase(Date fechaBase) {
        this.fechaBase = fechaBase;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    /*@XmlTransient
    public Collection<Cotizacion> getCotizacionCollection() {
        return cotizacionCollection;
    }

    public void setCotizacionCollection(Collection<Cotizacion> cotizacionCollection) {
        this.cotizacionCollection = cotizacionCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requerimientoPK != null ? requerimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.requerimientoPK == null && other.requerimientoPK != null) || (this.requerimientoPK != null && !this.requerimientoPK.equals(other.requerimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Requerimiento[ requerimientoPK=" + requerimientoPK + " ]";
    }
    
}
