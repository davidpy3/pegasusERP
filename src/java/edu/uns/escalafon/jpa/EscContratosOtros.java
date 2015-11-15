package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esc_contratos_otros")
public class EscContratosOtros implements Serializable {
    
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap",insertable=false,updatable=false),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep",insertable=false,updatable=false)})
    @ManyToOne(optional = false)
    private EscCap escCap;
    
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc",insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private EscPersonal escPersonal;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio",insertable=false,updatable=false)
    @ManyToOne
    private EscServicios escServicios;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private EscTipoPersonal idTipo;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cno")
    private Integer idCno;
    @Basic(optional = false)
    @Column(name = "fec_inicio")
    @Temporal(TemporalType.DATE)
    private Date fecInicio;
    @Basic(optional = false)
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "mencion")
    private String mencion;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "adhonoren")
    private Boolean adhonoren;



    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "id_cap")
    private Integer idCap;
    @Column(name = "id_esc")
    private Integer idEsc;
@Column(name = "id_servicio")
    private Integer idServicio;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public Integer getIdCap() {
        return idCap;
    }

    public void setIdCap(Integer idCap) {
        this.idCap = idCap;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }


    public EscContratosOtros() {
    }

    public EscContratosOtros(Integer idCno) {
        this.idCno = idCno;
    }

    public EscContratosOtros(Integer idCno, Date fecInicio, Date fecFin, boolean estado) {
        this.idCno = idCno;
        this.fecInicio = fecInicio;
        this.fecFin = fecFin;
        this.estado = estado;
    }

    public Integer getIdCno() {
        return idCno;
    }

    public void setIdCno(Integer idCno) {
        this.idCno = idCno;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Boolean getAdhonoren() {
        return adhonoren;
    }

    public void setAdhonoren(Boolean adhonoren) {
        this.adhonoren = adhonoren;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCno != null ? idCno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscContratosOtros)) {
            return false;
        }
        EscContratosOtros other = (EscContratosOtros) object;
        if ((this.idCno == null && other.idCno != null) || (this.idCno != null && !this.idCno.equals(other.idCno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.ocper.trabajador.EscContratosOtros[idCno=" + idCno + "]";
    }

    public EscCap getEscCap() {
        return escCap;
    }

    public void setEscCap(EscCap escCap) {
        this.escCap = escCap;
    }

    public EscPersonal getEscPersonal() {
        return escPersonal;
    }

    public void setEscPersonal(EscPersonal idEsc) {
        this.escPersonal = idEsc;
    }

    public EscServicios getEscServicios(){
        return escServicios;
    }

    public void setEscServicios(EscServicios idServicio) {
        this.escServicios = idServicio;
    }

    public EscTipoPersonal getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(EscTipoPersonal idTipo) {
        this.idTipo = idTipo;
    }

}
