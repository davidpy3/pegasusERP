/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByDni", query = "SELECT p FROM Personal p WHERE p.dni = :dni"),
    @NamedQuery(name = "Personal.findByApPaterno", query = "SELECT p FROM Personal p WHERE p.apPaterno = :apPaterno"),
    @NamedQuery(name = "Personal.findByApMaterno", query = "SELECT p FROM Personal p WHERE p.apMaterno = :apMaterno"),
    @NamedQuery(name = "Personal.findByNombres", query = "SELECT p FROM Personal p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Personal.findByNombComp", query = "SELECT p FROM Personal p WHERE p.nombComp = :nombComp"),
    @NamedQuery(name = "Personal.findByFechaNac", query = "SELECT p FROM Personal p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Personal.findBySexo", query = "SELECT p FROM Personal p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Personal.findByEntidad", query = "SELECT p FROM Personal p WHERE p.entidad = :entidad"),
    @NamedQuery(name = "Personal.findByTelefono", query = "SELECT p FROM Personal p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Personal.findByCorreoE", query = "SELECT p FROM Personal p WHERE p.correoE = :correoE"),
    @NamedQuery(name = "Personal.findByEssaludVida", query = "SELECT p FROM Personal p WHERE p.essaludVida = :essaludVida"),
    @NamedQuery(name = "Personal.findByDomicilio", query = "SELECT p FROM Personal p WHERE p.domicilio = :domicilio"),
    @NamedQuery(name = "Personal.findByEstadoCivil", query = "SELECT p FROM Personal p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Personal.findByNombrePareja", query = "SELECT p FROM Personal p WHERE p.nombrePareja = :nombrePareja"),
    @NamedQuery(name = "Personal.findByNumHijos", query = "SELECT p FROM Personal p WHERE p.numHijos = :numHijos"),
    @NamedQuery(name = "Personal.findByUbicaFoto", query = "SELECT p FROM Personal p WHERE p.ubicaFoto = :ubicaFoto"),
    @NamedQuery(name = "Personal.findByRuc", query = "SELECT p FROM Personal p WHERE p.ruc = :ruc"),
    @NamedQuery(name = "Personal.findByRetencion", query = "SELECT p FROM Personal p WHERE p.retencion = :retencion"),
    @NamedQuery(name = "Personal.findByDiscapacidad", query = "SELECT p FROM Personal p WHERE p.discapacidad = :discapacidad"),
    @NamedQuery(name = "Personal.findByFechaInscrip", query = "SELECT p FROM Personal p WHERE p.fechaInscrip = :fechaInscrip"),
    @NamedQuery(name = "Personal.findByCuspp", query = "SELECT p FROM Personal p WHERE p.cuspp = :cuspp"),
    @NamedQuery(name = "Personal.findBySCTRsalud", query = "SELECT p FROM Personal p WHERE p.sCTRsalud = :sCTRsalud"),
    @NamedQuery(name = "Personal.findBySCTRpension", query = "SELECT p FROM Personal p WHERE p.sCTRpension = :sCTRpension"),
    @NamedQuery(name = "Personal.findByHorNocturno", query = "SELECT p FROM Personal p WHERE p.horNocturno = :horNocturno"),
    @NamedQuery(name = "Personal.findBySindicalizado", query = "SELECT p FROM Personal p WHERE p.sindicalizado = :sindicalizado"),
    @NamedQuery(name = "Personal.findByDescJudicial", query = "SELECT p FROM Personal p WHERE p.descJudicial = :descJudicial"),
    @NamedQuery(name = "Personal.findByPeriodicidad", query = "SELECT p FROM Personal p WHERE p.periodicidad = :periodicidad"),
    @NamedQuery(name = "Personal.findBySituacion", query = "SELECT p FROM Personal p WHERE p.situacion = :situacion"),
    @NamedQuery(name = "Personal.findBySitEspecial", query = "SELECT p FROM Personal p WHERE p.sitEspecial = :sitEspecial"),
    @NamedQuery(name = "Personal.findByTipoPago", query = "SELECT p FROM Personal p WHERE p.tipoPago = :tipoPago"),
    @NamedQuery(name = "Personal.findByNumCuenta", query = "SELECT p FROM Personal p WHERE p.numCuenta = :numCuenta"),
    @NamedQuery(name = "Personal.findByNivelRem", query = "SELECT p FROM Personal p WHERE p.nivelRem = :nivelRem"),
    @NamedQuery(name = "Personal.findByIdCargo", query = "SELECT p FROM Personal p WHERE p.idCargo = :idCargo"),
    @NamedQuery(name = "Personal.findByCargoFunc", query = "SELECT p FROM Personal p WHERE p.cargoFunc = :cargoFunc"),
    @NamedQuery(name = "Personal.findByDescCargo", query = "SELECT p FROM Personal p WHERE p.descCargo = :descCargo"),
    @NamedQuery(name = "Personal.findByTipoHor", query = "SELECT p FROM Personal p WHERE p.tipoHor = :tipoHor"),
    @NamedQuery(name = "Personal.findByMontoRem", query = "SELECT p FROM Personal p WHERE p.montoRem = :montoRem"),
    @NamedQuery(name = "Personal.findByMontoIncafp", query = "SELECT p FROM Personal p WHERE p.montoIncafp = :montoIncafp"),
    @NamedQuery(name = "Personal.findByFechaIngreso", query = "SELECT p FROM Personal p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Personal.findByFechaCese", query = "SELECT p FROM Personal p WHERE p.fechaCese = :fechaCese"),
    @NamedQuery(name = "Personal.findByFechaReg", query = "SELECT p FROM Personal p WHERE p.fechaReg = :fechaReg"),
    @NamedQuery(name = "Personal.findByFechaMod", query = "SELECT p FROM Personal p WHERE p.fechaMod = :fechaMod"),
    @NamedQuery(name = "Personal.findByEstado", query = "SELECT p FROM Personal p WHERE p.estado = :estado"),
    @NamedQuery(name = "Personal.findBySelec", query = "SELECT p FROM Personal p WHERE p.selec = :selec"),
    @NamedQuery(name = "Personal.findByMarcacion", query = "SELECT p FROM Personal p WHERE p.marcacion = :marcacion"),
    @NamedQuery(name = "Personal.findByIndexdb", query = "SELECT p FROM Personal p WHERE p.indexdb = :indexdb"),
    @NamedQuery(name = "Personal.findBySecFun", query = "SELECT p FROM Personal p WHERE p.secFun = :secFun"),
    @NamedQuery(name = "Personal.findByFuenteF", query = "SELECT p FROM Personal p WHERE p.fuenteF = :fuenteF"),
    @NamedQuery(name = "Personal.findByFuncionario", query = "SELECT p FROM Personal p WHERE p.funcionario = :funcionario"),
    @NamedQuery(name = "Personal.findByCodReso", query = "SELECT p FROM Personal p WHERE p.codReso = :codReso"),
    @NamedQuery(name = "Personal.findByCodPlza", query = "SELECT p FROM Personal p WHERE p.codPlza = :codPlza"),
    @NamedQuery(name = "Personal.findByCodCts", query = "SELECT p FROM Personal p WHERE p.codCts = :codCts"),
    @NamedQuery(name = "Personal.findByTipoPension", query = "SELECT p FROM Personal p WHERE p.tipoPension = :tipoPension")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 40)
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Size(max = 40)
    @Column(name = "ap_materno")
    private String apMaterno;
    @Size(max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 120)
    @Column(name = "nomb_comp")
    private String nombComp;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;
    @Column(name = "sexo")
    private Character sexo;
    @Size(max = 2)
    @Column(name = "Entidad")
    private String entidad;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "correo_e")
    private String correoE;
    @Column(name = "essalud_vida")
    private Character essaludVida;
    @Size(max = 150)
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "estado_civil")
    private Character estadoCivil;
    @Size(max = 120)
    @Column(name = "nombre_pareja")
    private String nombrePareja;
    @Column(name = "num_hijos")
    private Integer numHijos;
    @Size(max = 255)
    @Column(name = "ubica_foto")
    private String ubicaFoto;
    @Size(max = 11)
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "retencion")
    private Character retencion;
    @Column(name = "discapacidad")
    private Character discapacidad;
    @Column(name = "fecha_inscrip")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInscrip;
    @Size(max = 12)
    @Column(name = "CUSPP")
    private String cuspp;
    @Column(name = "SCTR_salud")
    private Character sCTRsalud;
    @Column(name = "SCTR_pension")
    private Character sCTRpension;
    @Column(name = "hor_nocturno")
    private Character horNocturno;
    @Column(name = "sindicalizado")
    private Character sindicalizado;
    @Column(name = "desc_judicial")
    private Character descJudicial;
    @Column(name = "periodicidad")
    private Character periodicidad;
    @Size(max = 2)
    @Column(name = "situacion")
    private String situacion;
    @Column(name = "sit_especial")
    private Character sitEspecial;
    @Column(name = "tipo_pago")
    private Character tipoPago;
    @Size(max = 11)
    @Column(name = "num_cuenta")
    private String numCuenta;
    @Size(max = 2)
    @Column(name = "nivel_rem")
    private String nivelRem;
    @Column(name = "id_cargo")
    private Integer idCargo;
    @Size(max = 3)
    @Column(name = "cargo_func")
    private String cargoFunc;
    @Size(max = 100)
    @Column(name = "desc_cargo")
    private String descCargo;
    @Column(name = "tipo_hor")
    private Character tipoHor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_rem")
    private BigDecimal montoRem;
    @Column(name = "monto_incafp")
    private BigDecimal montoIncafp;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fecha_cese")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCese;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "selec")
    private Character selec;
    @Column(name = "marcacion")
    private Character marcacion;
    @Column(name = "indexdb")
    private BigInteger indexdb;
    @Size(max = 4)
    @Column(name = "sec_fun")
    private String secFun;
    @Size(max = 2)
    @Column(name = "fuente_f")
    private String fuenteF;
    @Size(max = 5)
    @Column(name = "funcionario")
    private String funcionario;
    @Size(max = 200)
    @Column(name = "cod_reso")
    private String codReso;
    @Size(max = 10)
    @Column(name = "cod_plza")
    private String codPlza;
    @Size(max = 20)
    @Column(name = "cod_cts")
    private String codCts;
    @Size(max = 1)
    @Column(name = "tipo_pension")
    private String tipoPension;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private Collection<PlanillaTrab> planillaTrabCollection;
    @JoinColumn(name = "codlocal", referencedColumnName = "codlocal")
    @ManyToOne
    private Locales codlocal;
    @JoinColumn(name = "mod_laboral", referencedColumnName = "mod_laboral")
    @ManyToOne
    private ModalidadLaboral modLaboral;
    @JoinColumn(name = "nivel_educativo", referencedColumnName = "nivel_educativo")
    @ManyToOne
    private NivelEducativo nivelEducativo;
    @JoinColumn(name = "ocupacion", referencedColumnName = "ocupacion")
    @ManyToOne
    private Ocupacion ocupacion;
    @JoinColumns({
        @JoinColumn(name = "codarea", referencedColumnName = "codarea"),
        @JoinColumn(name = "codoficina", referencedColumnName = "codoficina")})
    @ManyToOne
    private Oficina oficina;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "pais")
    @ManyToOne
    private Pais nacionalidad;
    @JoinColumn(name = "reg_pension", referencedColumnName = "reg_pension")
    @ManyToOne
    private RegimenPensionario regPension;
    @JoinColumn(name = "tipo_contrato", referencedColumnName = "tipo_contrato")
    @ManyToOne
    private TipoContrato tipoContrato;
    @JoinColumn(name = "tipo_trab", referencedColumnName = "tipo_trab")
    @ManyToOne
    private TipoTrabajador tipoTrab;
    @JoinColumn(name = "zona", referencedColumnName = "zona")
    @ManyToOne
    private Zona zona;

    public Personal() {
    }

    public Personal(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombComp() {
        return nombComp;
    }

    public void setNombComp(String nombComp) {
        this.nombComp = nombComp;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public Character getEssaludVida() {
        return essaludVida;
    }

    public void setEssaludVida(Character essaludVida) {
        this.essaludVida = essaludVida;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombrePareja() {
        return nombrePareja;
    }

    public void setNombrePareja(String nombrePareja) {
        this.nombrePareja = nombrePareja;
    }

    public Integer getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(Integer numHijos) {
        this.numHijos = numHijos;
    }

    public String getUbicaFoto() {
        return ubicaFoto;
    }

    public void setUbicaFoto(String ubicaFoto) {
        this.ubicaFoto = ubicaFoto;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Character getRetencion() {
        return retencion;
    }

    public void setRetencion(Character retencion) {
        this.retencion = retencion;
    }

    public Character getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Character discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Date getFechaInscrip() {
        return fechaInscrip;
    }

    public void setFechaInscrip(Date fechaInscrip) {
        this.fechaInscrip = fechaInscrip;
    }

    public String getCuspp() {
        return cuspp;
    }

    public void setCuspp(String cuspp) {
        this.cuspp = cuspp;
    }

    public Character getSCTRsalud() {
        return sCTRsalud;
    }

    public void setSCTRsalud(Character sCTRsalud) {
        this.sCTRsalud = sCTRsalud;
    }

    public Character getSCTRpension() {
        return sCTRpension;
    }

    public void setSCTRpension(Character sCTRpension) {
        this.sCTRpension = sCTRpension;
    }

    public Character getHorNocturno() {
        return horNocturno;
    }

    public void setHorNocturno(Character horNocturno) {
        this.horNocturno = horNocturno;
    }

    public Character getSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(Character sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    public Character getDescJudicial() {
        return descJudicial;
    }

    public void setDescJudicial(Character descJudicial) {
        this.descJudicial = descJudicial;
    }

    public Character getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Character periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Character getSitEspecial() {
        return sitEspecial;
    }

    public void setSitEspecial(Character sitEspecial) {
        this.sitEspecial = sitEspecial;
    }

    public Character getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Character tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNivelRem() {
        return nivelRem;
    }

    public void setNivelRem(String nivelRem) {
        this.nivelRem = nivelRem;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargoFunc() {
        return cargoFunc;
    }

    public void setCargoFunc(String cargoFunc) {
        this.cargoFunc = cargoFunc;
    }

    public String getDescCargo() {
        return descCargo;
    }

    public void setDescCargo(String descCargo) {
        this.descCargo = descCargo;
    }

    public Character getTipoHor() {
        return tipoHor;
    }

    public void setTipoHor(Character tipoHor) {
        this.tipoHor = tipoHor;
    }

    public BigDecimal getMontoRem() {
        return montoRem;
    }

    public void setMontoRem(BigDecimal montoRem) {
        this.montoRem = montoRem;
    }

    public BigDecimal getMontoIncafp() {
        return montoIncafp;
    }

    public void setMontoIncafp(BigDecimal montoIncafp) {
        this.montoIncafp = montoIncafp;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public Character getMarcacion() {
        return marcacion;
    }

    public void setMarcacion(Character marcacion) {
        this.marcacion = marcacion;
    }

    public BigInteger getIndexdb() {
        return indexdb;
    }

    public void setIndexdb(BigInteger indexdb) {
        this.indexdb = indexdb;
    }

    public String getSecFun() {
        return secFun;
    }

    public void setSecFun(String secFun) {
        this.secFun = secFun;
    }

    public String getFuenteF() {
        return fuenteF;
    }

    public void setFuenteF(String fuenteF) {
        this.fuenteF = fuenteF;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getCodReso() {
        return codReso;
    }

    public void setCodReso(String codReso) {
        this.codReso = codReso;
    }

    public String getCodPlza() {
        return codPlza;
    }

    public void setCodPlza(String codPlza) {
        this.codPlza = codPlza;
    }

    public String getCodCts() {
        return codCts;
    }

    public void setCodCts(String codCts) {
        this.codCts = codCts;
    }

    public String getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(String tipoPension) {
        this.tipoPension = tipoPension;
    }

    @XmlTransient
    public Collection<PlanillaTrab> getPlanillaTrabCollection() {
        return planillaTrabCollection;
    }

    public void setPlanillaTrabCollection(Collection<PlanillaTrab> planillaTrabCollection) {
        this.planillaTrabCollection = planillaTrabCollection;
    }

    public Locales getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(Locales codlocal) {
        this.codlocal = codlocal;
    }

    public ModalidadLaboral getModLaboral() {
        return modLaboral;
    }

    public void setModLaboral(ModalidadLaboral modLaboral) {
        this.modLaboral = modLaboral;
    }

    public NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public RegimenPensionario getRegPension() {
        return regPension;
    }

    public void setRegPension(RegimenPensionario regPension) {
        this.regPension = regPension;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public TipoTrabajador getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(TipoTrabajador tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Personal[ dni=" + dni + " ]";
    }
    
}
