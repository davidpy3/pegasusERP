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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "depreciacion_bienes")
@XmlRootElement
public class DepreciacionBien implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepreciacionBienPK depreciacionBienePK;
    @Size(max = 4)
    @Column(name = "ano")
    private String ano;
    @Size(max = 2)
    @Column(name = "mes")
    private String mes;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @Column(name = "fecha_origen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrigen;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Size(max = 11)
    @Column(name = "cuenta")
    private String cuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_libros")
    private BigDecimal valorLibros;
    @Column(name = "factor_ajuste")
    private BigDecimal factorAjuste;
    @Column(name = "valor_actualizado")
    private BigDecimal valorActualizado;
    @Column(name = "diferencia_ajuste")
    private BigDecimal diferenciaAjuste;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "tasa")
    private BigDecimal tasa;
    @Column(name = "depre_act_libros")
    private BigDecimal depreActLibros;
    @Column(name = "depre_act_actual")
    private BigDecimal depreActActual;
    @Column(name = "depre_act_diferencia")
    private BigDecimal depreActDiferencia;
    @Column(name = "depre_per_libros")
    private BigDecimal deprePerLibros;
    @Column(name = "depre_per_actual")
    private BigDecimal deprePerActual;
    @Column(name = "depre_per_diferencia")
    private BigDecimal deprePerDiferencia;
    @Column(name = "valor_neto")
    private BigDecimal valorNeto;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoDepreciacion periodoDepreciacion;

    public DepreciacionBien() {
    }

    public DepreciacionBien(DepreciacionBienPK depreciacionBienePK) {
        this.depreciacionBienePK = depreciacionBienePK;
    }

    public DepreciacionBien(long codPeriodo, String codBien, String correla, int item) {
        this.depreciacionBienePK = new DepreciacionBienPK(codPeriodo, codBien, correla, item);
    }

    public DepreciacionBienPK getDepreciacionBienePK() {
        return depreciacionBienePK;
    }

    public void setDepreciacionBienePK(DepreciacionBienPK depreciacionBienePK) {
        this.depreciacionBienePK = depreciacionBienePK;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaOrigen() {
        return fechaOrigen;
    }

    public void setFechaOrigen(Date fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getValorLibros() {
        return valorLibros;
    }

    public void setValorLibros(BigDecimal valorLibros) {
        this.valorLibros = valorLibros;
    }

    public BigDecimal getFactorAjuste() {
        return factorAjuste;
    }

    public void setFactorAjuste(BigDecimal factorAjuste) {
        this.factorAjuste = factorAjuste;
    }

    public BigDecimal getValorActualizado() {
        return valorActualizado;
    }

    public void setValorActualizado(BigDecimal valorActualizado) {
        this.valorActualizado = valorActualizado;
    }

    public BigDecimal getDiferenciaAjuste() {
        return diferenciaAjuste;
    }

    public void setDiferenciaAjuste(BigDecimal diferenciaAjuste) {
        this.diferenciaAjuste = diferenciaAjuste;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }

    public BigDecimal getDepreActLibros() {
        return depreActLibros;
    }

    public void setDepreActLibros(BigDecimal depreActLibros) {
        this.depreActLibros = depreActLibros;
    }

    public BigDecimal getDepreActActual() {
        return depreActActual;
    }

    public void setDepreActActual(BigDecimal depreActActual) {
        this.depreActActual = depreActActual;
    }

    public BigDecimal getDepreActDiferencia() {
        return depreActDiferencia;
    }

    public void setDepreActDiferencia(BigDecimal depreActDiferencia) {
        this.depreActDiferencia = depreActDiferencia;
    }

    public BigDecimal getDeprePerLibros() {
        return deprePerLibros;
    }

    public void setDeprePerLibros(BigDecimal deprePerLibros) {
        this.deprePerLibros = deprePerLibros;
    }

    public BigDecimal getDeprePerActual() {
        return deprePerActual;
    }

    public void setDeprePerActual(BigDecimal deprePerActual) {
        this.deprePerActual = deprePerActual;
    }

    public BigDecimal getDeprePerDiferencia() {
        return deprePerDiferencia;
    }

    public void setDeprePerDiferencia(BigDecimal deprePerDiferencia) {
        this.deprePerDiferencia = deprePerDiferencia;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(BigDecimal valorNeto) {
        this.valorNeto = valorNeto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public PeriodoDepreciacion getPeriodoDepreciacion() {
        return periodoDepreciacion;
    }

    public void setPeriodoDepreciacion(PeriodoDepreciacion periodoDepreciacion) {
        this.periodoDepreciacion = periodoDepreciacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depreciacionBienePK != null ? depreciacionBienePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepreciacionBien)) {
            return false;
        }
        DepreciacionBien other = (DepreciacionBien) object;
        if ((this.depreciacionBienePK == null && other.depreciacionBienePK != null) || (this.depreciacionBienePK != null && !this.depreciacionBienePK.equals(other.depreciacionBienePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.DepreciacionBiene[ depreciacionBienePK=" + depreciacionBienePK + " ]";
    }
    
}
