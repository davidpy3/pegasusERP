/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
@Table(name = "Afectaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afectaciones.findAll", query = "SELECT a FROM Afectaciones a"),
    @NamedQuery(name = "Afectaciones.findByTipoTrab", query = "SELECT a FROM Afectaciones a WHERE a.afectacionesPK.tipoTrab = :tipoTrab"),
    @NamedQuery(name = "Afectaciones.findByCodigo", query = "SELECT a FROM Afectaciones a WHERE a.afectacionesPK.codigo = :codigo"),
    @NamedQuery(name = "Afectaciones.findByIden", query = "SELECT a FROM Afectaciones a WHERE a.iden = :iden"),
    @NamedQuery(name = "Afectaciones.findByValor", query = "SELECT a FROM Afectaciones a WHERE a.valor = :valor"),
    @NamedQuery(name = "Afectaciones.findByValorMen", query = "SELECT a FROM Afectaciones a WHERE a.valorMen = :valorMen"),
    @NamedQuery(name = "Afectaciones.findByPorcen", query = "SELECT a FROM Afectaciones a WHERE a.porcen = :porcen"),
    @NamedQuery(name = "Afectaciones.findByPorcenMensual", query = "SELECT a FROM Afectaciones a WHERE a.porcenMensual = :porcenMensual"),
    @NamedQuery(name = "Afectaciones.findByTablaMonto", query = "SELECT a FROM Afectaciones a WHERE a.tablaMonto = :tablaMonto"),
    @NamedQuery(name = "Afectaciones.findByColumnaMonto", query = "SELECT a FROM Afectaciones a WHERE a.columnaMonto = :columnaMonto"),
    @NamedQuery(name = "Afectaciones.findByDn", query = "SELECT a FROM Afectaciones a WHERE a.dn = :dn"),
    @NamedQuery(name = "Afectaciones.findByDd", query = "SELECT a FROM Afectaciones a WHERE a.dd = :dd"),
    @NamedQuery(name = "Afectaciones.findByDfer", query = "SELECT a FROM Afectaciones a WHERE a.dfer = :dfer"),
    @NamedQuery(name = "Afectaciones.findByDftrab", query = "SELECT a FROM Afectaciones a WHERE a.dftrab = :dftrab"),
    @NamedQuery(name = "Afectaciones.findByHoraExt", query = "SELECT a FROM Afectaciones a WHERE a.horaExt = :horaExt"),
    @NamedQuery(name = "Afectaciones.findByGastoDebe", query = "SELECT a FROM Afectaciones a WHERE a.gastoDebe = :gastoDebe"),
    @NamedQuery(name = "Afectaciones.findByGastoHaber", query = "SELECT a FROM Afectaciones a WHERE a.gastoHaber = :gastoHaber"),
    @NamedQuery(name = "Afectaciones.findByCuenta", query = "SELECT a FROM Afectaciones a WHERE a.cuenta = :cuenta"),
    @NamedQuery(name = "Afectaciones.findByRemAseg", query = "SELECT a FROM Afectaciones a WHERE a.remAseg = :remAseg"),
    @NamedQuery(name = "Afectaciones.findByExCodigo", query = "SELECT a FROM Afectaciones a WHERE a.exCodigo = :exCodigo")})
public class Afectaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AfectacionesPK afectacionesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iden")
    private Character iden;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "valor_men")
    private BigDecimal valorMen;
    @Column(name = "porcen")
    private BigDecimal porcen;
    @Column(name = "porcen_mensual")
    private BigDecimal porcenMensual;
    @Size(max = 50)
    @Column(name = "tabla_monto")
    private String tablaMonto;
    @Size(max = 10)
    @Column(name = "columna_monto")
    private String columnaMonto;
    @Column(name = "DN")
    private Integer dn;
    @Column(name = "DD")
    private Integer dd;
    @Column(name = "DFER")
    private Integer dfer;
    @Column(name = "DFTRAB")
    private Integer dftrab;
    @Column(name = "HORA_EXT")
    private Integer horaExt;
    @Column(name = "gasto_debe")
    private Integer gastoDebe;
    @Column(name = "gasto_haber")
    private Integer gastoHaber;
    @Size(max = 4)
    @Column(name = "cuenta")
    private String cuenta;
    @Column(name = "rem_aseg")
    private Character remAseg;
    @Size(max = 4)
    @Column(name = "ex_codigo")
    private String exCodigo;

    public Afectaciones() {
    }

    public Afectaciones(AfectacionesPK afectacionesPK) {
        this.afectacionesPK = afectacionesPK;
    }

    public Afectaciones(AfectacionesPK afectacionesPK, Character iden) {
        this.afectacionesPK = afectacionesPK;
        this.iden = iden;
    }

    public Afectaciones(String tipoTrab, String codigo) {
        this.afectacionesPK = new AfectacionesPK(tipoTrab, codigo);
    }

    public AfectacionesPK getAfectacionesPK() {
        return afectacionesPK;
    }

    public void setAfectacionesPK(AfectacionesPK afectacionesPK) {
        this.afectacionesPK = afectacionesPK;
    }

    public Character getIden() {
        return iden;
    }

    public void setIden(Character iden) {
        this.iden = iden;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorMen() {
        return valorMen;
    }

    public void setValorMen(BigDecimal valorMen) {
        this.valorMen = valorMen;
    }

    public BigDecimal getPorcen() {
        return porcen;
    }

    public void setPorcen(BigDecimal porcen) {
        this.porcen = porcen;
    }

    public BigDecimal getPorcenMensual() {
        return porcenMensual;
    }

    public void setPorcenMensual(BigDecimal porcenMensual) {
        this.porcenMensual = porcenMensual;
    }

    public String getTablaMonto() {
        return tablaMonto;
    }

    public void setTablaMonto(String tablaMonto) {
        this.tablaMonto = tablaMonto;
    }

    public String getColumnaMonto() {
        return columnaMonto;
    }

    public void setColumnaMonto(String columnaMonto) {
        this.columnaMonto = columnaMonto;
    }

    public Integer getDn() {
        return dn;
    }

    public void setDn(Integer dn) {
        this.dn = dn;
    }

    public Integer getDd() {
        return dd;
    }

    public void setDd(Integer dd) {
        this.dd = dd;
    }

    public Integer getDfer() {
        return dfer;
    }

    public void setDfer(Integer dfer) {
        this.dfer = dfer;
    }

    public Integer getDftrab() {
        return dftrab;
    }

    public void setDftrab(Integer dftrab) {
        this.dftrab = dftrab;
    }

    public Integer getHoraExt() {
        return horaExt;
    }

    public void setHoraExt(Integer horaExt) {
        this.horaExt = horaExt;
    }

    public Integer getGastoDebe() {
        return gastoDebe;
    }

    public void setGastoDebe(Integer gastoDebe) {
        this.gastoDebe = gastoDebe;
    }

    public Integer getGastoHaber() {
        return gastoHaber;
    }

    public void setGastoHaber(Integer gastoHaber) {
        this.gastoHaber = gastoHaber;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Character getRemAseg() {
        return remAseg;
    }

    public void setRemAseg(Character remAseg) {
        this.remAseg = remAseg;
    }

    public String getExCodigo() {
        return exCodigo;
    }

    public void setExCodigo(String exCodigo) {
        this.exCodigo = exCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afectacionesPK != null ? afectacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afectaciones)) {
            return false;
        }
        Afectaciones other = (Afectaciones) object;
        if ((this.afectacionesPK == null && other.afectacionesPK != null) || (this.afectacionesPK != null && !this.afectacionesPK.equals(other.afectacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Afectaciones[ afectacionesPK=" + afectacionesPK + " ]";
    }
    
}
