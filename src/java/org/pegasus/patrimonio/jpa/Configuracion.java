/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Configuracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c"),
    @NamedQuery(name = "Configuracion.findByAnoEje", query = "SELECT c FROM Configuracion c WHERE c.configuracionPK.anoEje = :anoEje"),
    @NamedQuery(name = "Configuracion.findByRUCentidad", query = "SELECT c FROM Configuracion c WHERE c.configuracionPK.rUCentidad = :rUCentidad"),
    @NamedQuery(name = "Configuracion.findByNombreEntidad", query = "SELECT c FROM Configuracion c WHERE c.nombreEntidad = :nombreEntidad"),
    @NamedQuery(name = "Configuracion.findByDireccionEntidad", query = "SELECT c FROM Configuracion c WHERE c.direccionEntidad = :direccionEntidad"),
    @NamedQuery(name = "Configuracion.findByTelefonoEntidad", query = "SELECT c FROM Configuracion c WHERE c.telefonoEntidad = :telefonoEntidad"),
    @NamedQuery(name = "Configuracion.findByIgv", query = "SELECT c FROM Configuracion c WHERE c.igv = :igv"),
    @NamedQuery(name = "Configuracion.findByUit", query = "SELECT c FROM Configuracion c WHERE c.uit = :uit"),
    @NamedQuery(name = "Configuracion.findByMinimoVital", query = "SELECT c FROM Configuracion c WHERE c.minimoVital = :minimoVital"),
    @NamedQuery(name = "Configuracion.findByAnoDoc", query = "SELECT c FROM Configuracion c WHERE c.anoDoc = :anoDoc"),
    @NamedQuery(name = "Configuracion.findByEssVida", query = "SELECT c FROM Configuracion c WHERE c.essVida = :essVida"),
    @NamedQuery(name = "Configuracion.findByPorcentajeIr", query = "SELECT c FROM Configuracion c WHERE c.porcentajeIr = :porcentajeIr"),
    @NamedQuery(name = "Configuracion.findByActivo", query = "SELECT c FROM Configuracion c WHERE c.activo = :activo"),
    @NamedQuery(name = "Configuracion.findByTieneGratif", query = "SELECT c FROM Configuracion c WHERE c.tieneGratif = :tieneGratif"),
    @NamedQuery(name = "Configuracion.findByTieneVacac", query = "SELECT c FROM Configuracion c WHERE c.tieneVacac = :tieneVacac"),
    @NamedQuery(name = "Configuracion.findByTieneEscol", query = "SELECT c FROM Configuracion c WHERE c.tieneEscol = :tieneEscol"),
    @NamedQuery(name = "Configuracion.findByNroGratif", query = "SELECT c FROM Configuracion c WHERE c.nroGratif = :nroGratif"),
    @NamedQuery(name = "Configuracion.findByNroVacac", query = "SELECT c FROM Configuracion c WHERE c.nroVacac = :nroVacac"),
    @NamedQuery(name = "Configuracion.findByNroEscol", query = "SELECT c FROM Configuracion c WHERE c.nroEscol = :nroEscol"),
    @NamedQuery(name = "Configuracion.findByNroUit", query = "SELECT c FROM Configuracion c WHERE c.nroUit = :nroUit"),
    @NamedQuery(name = "Configuracion.findByNroSueldos", query = "SELECT c FROM Configuracion c WHERE c.nroSueldos = :nroSueldos"),
    @NamedQuery(name = "Configuracion.findByNroDiasEscol", query = "SELECT c FROM Configuracion c WHERE c.nroDiasEscol = :nroDiasEscol"),
    @NamedQuery(name = "Configuracion.findByNroDiasGratif", query = "SELECT c FROM Configuracion c WHERE c.nroDiasGratif = :nroDiasGratif"),
    @NamedQuery(name = "Configuracion.findByNroDiasMes", query = "SELECT c FROM Configuracion c WHERE c.nroDiasMes = :nroDiasMes"),
    @NamedQuery(name = "Configuracion.findByMesInicioEscol", query = "SELECT c FROM Configuracion c WHERE c.mesInicioEscol = :mesInicioEscol")})
public class Configuracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConfiguracionPK configuracionPK;
    @Size(max = 50)
    @Column(name = "nombre_entidad")
    private String nombreEntidad;
    @Size(max = 200)
    @Column(name = "direccion_entidad")
    private String direccionEntidad;
    @Size(max = 20)
    @Column(name = "telefono_entidad")
    private String telefonoEntidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IGV")
    private BigDecimal igv;
    @Column(name = "UIT")
    private BigDecimal uit;
    @Column(name = "minimo_vital")
    private BigDecimal minimoVital;
    @Size(max = 255)
    @Column(name = "ano_doc")
    private String anoDoc;
    @Column(name = "ess_vida")
    private BigDecimal essVida;
    @Column(name = "porcentaje_ir")
    private BigDecimal porcentajeIr;
    @Column(name = "activo")
    private Character activo;
    @Column(name = "tiene_gratif")
    private Integer tieneGratif;
    @Column(name = "tiene_vacac")
    private Integer tieneVacac;
    @Column(name = "tiene_escol")
    private Integer tieneEscol;
    @Column(name = "nro_gratif")
    private Integer nroGratif;
    @Column(name = "nro_vacac")
    private Integer nroVacac;
    @Column(name = "nro_escol")
    private Integer nroEscol;
    @Column(name = "nro_uit")
    private Integer nroUit;
    @Column(name = "nro_sueldos")
    private Integer nroSueldos;
    @Column(name = "nro_dias_escol")
    private Integer nroDiasEscol;
    @Column(name = "nro_dias_gratif")
    private Integer nroDiasGratif;
    @Column(name = "nro_dias_mes")
    private Integer nroDiasMes;
    @Column(name = "mes_inicio_escol")
    private Integer mesInicioEscol;

    public Configuracion() {
    }

    public Configuracion(ConfiguracionPK configuracionPK) {
        this.configuracionPK = configuracionPK;
    }

    public Configuracion(int anoEje, String rUCentidad) {
        this.configuracionPK = new ConfiguracionPK(anoEje, rUCentidad);
    }

    public ConfiguracionPK getConfiguracionPK() {
        return configuracionPK;
    }

    public void setConfiguracionPK(ConfiguracionPK configuracionPK) {
        this.configuracionPK = configuracionPK;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getDireccionEntidad() {
        return direccionEntidad;
    }

    public void setDireccionEntidad(String direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }

    public String getTelefonoEntidad() {
        return telefonoEntidad;
    }

    public void setTelefonoEntidad(String telefonoEntidad) {
        this.telefonoEntidad = telefonoEntidad;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getUit() {
        return uit;
    }

    public void setUit(BigDecimal uit) {
        this.uit = uit;
    }

    public BigDecimal getMinimoVital() {
        return minimoVital;
    }

    public void setMinimoVital(BigDecimal minimoVital) {
        this.minimoVital = minimoVital;
    }

    public String getAnoDoc() {
        return anoDoc;
    }

    public void setAnoDoc(String anoDoc) {
        this.anoDoc = anoDoc;
    }

    public BigDecimal getEssVida() {
        return essVida;
    }

    public void setEssVida(BigDecimal essVida) {
        this.essVida = essVida;
    }

    public BigDecimal getPorcentajeIr() {
        return porcentajeIr;
    }

    public void setPorcentajeIr(BigDecimal porcentajeIr) {
        this.porcentajeIr = porcentajeIr;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    public Integer getTieneGratif() {
        return tieneGratif;
    }

    public void setTieneGratif(Integer tieneGratif) {
        this.tieneGratif = tieneGratif;
    }

    public Integer getTieneVacac() {
        return tieneVacac;
    }

    public void setTieneVacac(Integer tieneVacac) {
        this.tieneVacac = tieneVacac;
    }

    public Integer getTieneEscol() {
        return tieneEscol;
    }

    public void setTieneEscol(Integer tieneEscol) {
        this.tieneEscol = tieneEscol;
    }

    public Integer getNroGratif() {
        return nroGratif;
    }

    public void setNroGratif(Integer nroGratif) {
        this.nroGratif = nroGratif;
    }

    public Integer getNroVacac() {
        return nroVacac;
    }

    public void setNroVacac(Integer nroVacac) {
        this.nroVacac = nroVacac;
    }

    public Integer getNroEscol() {
        return nroEscol;
    }

    public void setNroEscol(Integer nroEscol) {
        this.nroEscol = nroEscol;
    }

    public Integer getNroUit() {
        return nroUit;
    }

    public void setNroUit(Integer nroUit) {
        this.nroUit = nroUit;
    }

    public Integer getNroSueldos() {
        return nroSueldos;
    }

    public void setNroSueldos(Integer nroSueldos) {
        this.nroSueldos = nroSueldos;
    }

    public Integer getNroDiasEscol() {
        return nroDiasEscol;
    }

    public void setNroDiasEscol(Integer nroDiasEscol) {
        this.nroDiasEscol = nroDiasEscol;
    }

    public Integer getNroDiasGratif() {
        return nroDiasGratif;
    }

    public void setNroDiasGratif(Integer nroDiasGratif) {
        this.nroDiasGratif = nroDiasGratif;
    }

    public Integer getNroDiasMes() {
        return nroDiasMes;
    }

    public void setNroDiasMes(Integer nroDiasMes) {
        this.nroDiasMes = nroDiasMes;
    }

    public Integer getMesInicioEscol() {
        return mesInicioEscol;
    }

    public void setMesInicioEscol(Integer mesInicioEscol) {
        this.mesInicioEscol = mesInicioEscol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionPK != null ? configuracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.configuracionPK == null && other.configuracionPK != null) || (this.configuracionPK != null && !this.configuracionPK.equals(other.configuracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Configuracion[ configuracionPK=" + configuracionPK + " ]";
    }
    
}
