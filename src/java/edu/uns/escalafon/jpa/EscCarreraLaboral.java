/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "esc_carreralaboral")
public class EscCarreraLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_percl")
    private Integer idPercl;
    @Column(name = "id_percl_de")
    private Integer idPerclDe;
    @Column(name = "id_cap")
    private Integer idCap;
    @Column(name = "tipo_cap")
    private Boolean tipoCap;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "cod_dtra")
    private String codDtra;
    @Basic(optional = false)
    @Column(name = "condicion")
    private short condicion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "jefe")
    private boolean jefe;
    @Basic(optional = false)
    @Column(name = "plaza")
    private boolean plaza;
    @Basic(optional = false)
    @Column(name = "servicio")
    private boolean servicio;
    @Column(name = "horas")
    private Short horas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "mencion")
    private String mencion;
    @Basic(optional = false)
    @Column(name = "migrado")
    private boolean migrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCarreraLaboral")
    private List<EscLabordependencias> escLabordependenciasList;
    @JoinColumn(name = "id_desp", referencedColumnName = "id_desp")
    @ManyToOne
    private EscDesplazamiento idDesp;
    @JoinColumn(name = "id_mov", referencedColumnName = "id_mov")
    @ManyToOne(optional = false)
    private EscMovimientos idMov;
    @JoinColumn(name = "id_movmod", referencedColumnName = "id_movmod")
    @ManyToOne(optional = false)
    private EscMovmodalidad idMovmod;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne
    private EscServicios idServicio;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private EscTipoPersonal idTipo;
    @JoinColumn(name = "id_tp", referencedColumnName = "id_tp")
    @ManyToOne
    private EscTipoPromocion idTp;

    public EscCarreraLaboral() {
    }

    public EscCarreraLaboral(Integer idPercl) {
        this.idPercl = idPercl;
    }

    public EscCarreraLaboral(Integer idPercl, Date fechaIni, short condicion, boolean estado, boolean jefe, boolean plaza, boolean servicio, boolean migrado) {
        this.idPercl = idPercl;
        this.fechaIni = fechaIni;
        this.condicion = condicion;
        this.estado = estado;
        this.jefe = jefe;
        this.plaza = plaza;
        this.servicio = servicio;
        this.migrado = migrado;
    }

    public Integer getIdPercl() {
        return idPercl;
    }

    public void setIdPercl(Integer idPercl) {
        this.idPercl = idPercl;
    }

    public Integer getIdPerclDe() {
        return idPerclDe;
    }

    public void setIdPerclDe(Integer idPerclDe) {
        this.idPerclDe = idPerclDe;
    }

    public Integer getIdCap() {
        return idCap;
    }

    public void setIdCap(Integer idCap) {
        this.idCap = idCap;
    }

    public Boolean getTipoCap() {
        return tipoCap;
    }

    public void setTipoCap(Boolean tipoCap) {
        this.tipoCap = tipoCap;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodDtra() {
        return codDtra;
    }

    public void setCodDtra(String codDtra) {
        this.codDtra = codDtra;
    }

    public short getCondicion() {
        return condicion;
    }

    public void setCondicion(short condicion) {
        this.condicion = condicion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getJefe() {
        return jefe;
    }

    public void setJefe(boolean jefe) {
        this.jefe = jefe;
    }

    public boolean getPlaza() {
        return plaza;
    }

    public void setPlaza(boolean plaza) {
        this.plaza = plaza;
    }

    public boolean getServicio() {
        return servicio;
    }

    public void setServicio(boolean servicio) {
        this.servicio = servicio;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public boolean getMigrado() {
        return migrado;
    }

    public void setMigrado(boolean migrado) {
        this.migrado = migrado;
    }

    @XmlTransient
    public List<EscLabordependencias> getEscLabordependenciasList() {
        return escLabordependenciasList;
    }

    public void setEscLabordependenciasList(List<EscLabordependencias> escLabordependenciasList) {
        this.escLabordependenciasList = escLabordependenciasList;
    }

    public EscDesplazamiento getIdDesp() {
        return idDesp;
    }

    public void setIdDesp(EscDesplazamiento idDesp) {
        this.idDesp = idDesp;
    }

    public EscMovimientos getIdMov() {
        return idMov;
    }

    public void setIdMov(EscMovimientos idMov) {
        this.idMov = idMov;
    }

    public EscMovmodalidad getIdMovmod() {
        return idMovmod;
    }

    public void setIdMovmod(EscMovmodalidad idMovmod) {
        this.idMovmod = idMovmod;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscServicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(EscServicios idServicio) {
        this.idServicio = idServicio;
    }

    public EscTipoPersonal getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(EscTipoPersonal idTipo) {
        this.idTipo = idTipo;
    }

    public EscTipoPromocion getIdTp() {
        return idTp;
    }

    public void setIdTp(EscTipoPromocion idTp) {
        this.idTp = idTp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPercl != null ? idPercl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCarreraLaboral)) {
            return false;
        }
        EscCarreraLaboral other = (EscCarreraLaboral) object;
        if ((this.idPercl == null && other.idPercl != null) || (this.idPercl != null && !this.idPercl.equals(other.idPercl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCarreraLaboral[ idPercl=" + idPercl + " ]";
    }
    
}
