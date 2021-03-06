package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Proveedores")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "RUC")
    private String ruc;
    @Size(max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Nombre_Razon")
    private String nombreRazon;
    @Size(max = 70)
    @Column(name = "Tipo_Contrib")
    private String tipoContrib;
    @Size(max = 200)
    @Column(name = "Prof_Oficio")
    private String profOficio;
    @Size(max = 200)
    @Column(name = "Nombre_Comercial")
    private String nombreComercial;
    @Size(max = 80)
    @Column(name = "Condicion_Contrib")
    private String condicionContrib;
    @Size(max = 80)
    @Column(name = "Estado_Contrib")
    private String estadoContrib;
    @Column(name = "Fecha_Inscrip")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscrip;
    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Size(max = 80)
    @Column(name = "Departamento")
    private String departamento;
    @Size(max = 80)
    @Column(name = "Provincia")
    private String provincia;
    @Size(max = 80)
    @Column(name = "Distrito")
    private String distrito;
    @Size(max = 120)
    @Column(name = "Direccion")
    private String direccion;
    @Size(max = 80)
    @Column(name = "Telefonos")
    private String telefonos;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Fax")
    private String fax;
    @Size(max = 200)
    @Column(name = "Acti_exterior")
    private String actiexterior;
    @Size(max = 80)
    @Column(name = "CIIU_Principal")
    private String cIIUPrincipal;
    @Size(max = 80)
    @Column(name = "CIIU_Secun1")
    private String cIIUSecun1;
    @Size(max = 80)
    @Column(name = "CIIU_Secun2")
    private String cIIUSecun2;
    @Size(max = 20)
    @Column(name = "Nuevo_RUS")
    private String nuevoRUS;
    @Size(max = 220)
    @Column(name = "Buen_Contrib")
    private String buenContrib;
    @Size(max = 220)
    @Column(name = "Agente_Reten")
    private String agenteReten;
    @Size(max = 220)
    @Column(name = "Agente_Percep1")
    private String agentePercep1;
    @Size(max = 220)
    @Column(name = "Agente_Percep2")
    private String agentePercep2;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 220)
    @Column(name = "entidad_bancaria")
    private String entidadBancaria;
    @Column(name = "fec_inic")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInic;
    @Column(name = "fec_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 50)
    @Column(name = "numero_cf")
    private String numeroCf;
    @Size(max = 4)
    @Column(name = "secfunc")
    private String secfunc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe")
    private BigDecimal importe;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "rUCpostor")
    private Collection<Cotizacion> cotizacionCollection;*/

    public Proveedor() {
    }

    public Proveedor(String ruc) {
        this.ruc = ruc;
    }

    public Proveedor(String ruc, String nombreRazon) {
        this.ruc = ruc;
        this.nombreRazon = nombreRazon;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getNombreRazon() {
        return nombreRazon;
    }

    public void setNombreRazon(String nombreRazon) {
        this.nombreRazon = nombreRazon;
    }

    public String getTipoContrib() {
        return tipoContrib;
    }

    public void setTipoContrib(String tipoContrib) {
        this.tipoContrib = tipoContrib;
    }

    public String getProfOficio() {
        return profOficio;
    }

    public void setProfOficio(String profOficio) {
        this.profOficio = profOficio;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCondicionContrib() {
        return condicionContrib;
    }

    public void setCondicionContrib(String condicionContrib) {
        this.condicionContrib = condicionContrib;
    }

    public String getEstadoContrib() {
        return estadoContrib;
    }

    public void setEstadoContrib(String estadoContrib) {
        this.estadoContrib = estadoContrib;
    }

    public Date getFechaInscrip() {
        return fechaInscrip;
    }

    public void setFechaInscrip(Date fechaInscrip) {
        this.fechaInscrip = fechaInscrip;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getActiexterior() {
        return actiexterior;
    }

    public void setActiexterior(String actiexterior) {
        this.actiexterior = actiexterior;
    }

    public String getCIIUPrincipal() {
        return cIIUPrincipal;
    }

    public void setCIIUPrincipal(String cIIUPrincipal) {
        this.cIIUPrincipal = cIIUPrincipal;
    }

    public String getCIIUSecun1() {
        return cIIUSecun1;
    }

    public void setCIIUSecun1(String cIIUSecun1) {
        this.cIIUSecun1 = cIIUSecun1;
    }

    public String getCIIUSecun2() {
        return cIIUSecun2;
    }

    public void setCIIUSecun2(String cIIUSecun2) {
        this.cIIUSecun2 = cIIUSecun2;
    }

    public String getNuevoRUS() {
        return nuevoRUS;
    }

    public void setNuevoRUS(String nuevoRUS) {
        this.nuevoRUS = nuevoRUS;
    }

    public String getBuenContrib() {
        return buenContrib;
    }

    public void setBuenContrib(String buenContrib) {
        this.buenContrib = buenContrib;
    }

    public String getAgenteReten() {
        return agenteReten;
    }

    public void setAgenteReten(String agenteReten) {
        this.agenteReten = agenteReten;
    }

    public String getAgentePercep1() {
        return agentePercep1;
    }

    public void setAgentePercep1(String agentePercep1) {
        this.agentePercep1 = agentePercep1;
    }

    public String getAgentePercep2() {
        return agentePercep2;
    }

    public void setAgentePercep2(String agentePercep2) {
        this.agentePercep2 = agentePercep2;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public Date getFecInic() {
        return fecInic;
    }

    public void setFecInic(Date fecInic) {
        this.fecInic = fecInic;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumeroCf() {
        return numeroCf;
    }

    public void setNumeroCf(String numeroCf) {
        this.numeroCf = numeroCf;
    }

    public String getSecfunc() {
        return secfunc;
    }

    public void setSecfunc(String secfunc) {
        this.secfunc = secfunc;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

 /*  @XmlTransient
    public Collection<Cotizacion> getCotizacionCollection() {
        return cotizacionCollection;
    }

    public void setCotizacionCollection(Collection<Cotizacion> cotizacionCollection) {
        this.cotizacionCollection = cotizacionCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Proveedores[ ruc=" + ruc + " ]";
    }
    
}
