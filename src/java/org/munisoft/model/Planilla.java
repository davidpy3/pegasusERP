/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "planilla")
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Tipo_Doc")
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 2)
    @Column(name = "Fuente_Financ")
    private String fuenteFinanc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ind")
    private Character ind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Monto")
    private BigDecimal monto;
    @EmbeddedId
    protected PlanillaPK planillaPK;

    public TipoPlanilla getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }
    
    
    private TipoPlanilla tipoPlanilla;
    
    public Planilla() {
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public Character getInd() {
        return ind;
    }

    public void setInd(Character ind) {
        this.ind = ind;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
}
