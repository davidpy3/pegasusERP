/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "fxa_egresado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FxaEgreso.findAll", query = "SELECT f FROM FxaEgreso f"),
    @NamedQuery(name = "FxaEgreso.findByIdAcexp", query = "SELECT f FROM FxaEgreso f WHERE f.idAcexp = :idAcexp"),
    @NamedQuery(name = "FxaEgreso.findByIdPromegr", query = "SELECT f FROM FxaEgreso f WHERE f.idPromegr = :idPromegr"),
    @NamedQuery(name = "FxaEgreso.findByIdEspecialidad", query = "SELECT f FROM FxaEgreso f WHERE f.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "FxaEgreso.findByIdPlancur", query = "SELECT f FROM FxaEgreso f WHERE f.idPlancur = :idPlancur"),
    @NamedQuery(name = "FxaEgreso.findByPromedio", query = "SELECT f FROM FxaEgreso f WHERE f.promedio = :promedio"),
    @NamedQuery(name = "FxaEgreso.findByIdDtra", query = "SELECT f FROM FxaEgreso f WHERE f.idDtra = :idDtra"),
    @NamedQuery(name = "FxaEgreso.findByCodDtra", query = "SELECT f FROM FxaEgreso f WHERE f.codDtra = :codDtra"),
    @NamedQuery(name = "FxaEgreso.findByPuestoAmbito", query = "SELECT f FROM FxaEgreso f WHERE f.puestoAmbito = :puestoAmbito"),
    @NamedQuery(name = "FxaEgreso.findByPuestoEspecialidad", query = "SELECT f FROM FxaEgreso f WHERE f.puestoEspecialidad = :puestoEspecialidad"),
    @NamedQuery(name = "FxaEgreso.findByPromSeccionEgreso", query = "SELECT f FROM FxaEgreso f WHERE f.promSeccionEgreso = :promSeccionEgreso"),
    @NamedQuery(name = "FxaEgreso.findByFechaEgreso", query = "SELECT f FROM FxaEgreso f WHERE f.fechaEgreso = :fechaEgreso"),
    @NamedQuery(name = "FxaEgreso.findByFechaTitulacion", query = "SELECT f FROM FxaEgreso f WHERE f.fechaTitulacion = :fechaTitulacion"),
    @NamedQuery(name = "FxaEgreso.findByObservacion", query = "SELECT f FROM FxaEgreso f WHERE f.observacion = :observacion"),
    @NamedQuery(name = "FxaEgreso.findByIdCreador", query = "SELECT f FROM FxaEgreso f WHERE f.idCreador = :idCreador"),
    @NamedQuery(name = "FxaEgreso.findByFechaReg", query = "SELECT f FROM FxaEgreso f WHERE f.fechaReg = :fechaReg"),
    @NamedQuery(name = "FxaEgreso.findByIdModegr", query = "SELECT f FROM FxaEgreso f WHERE f.idModegr = :idModegr"),
    @NamedQuery(name = "FxaEgreso.findByIdEstado", query = "SELECT f FROM FxaEgreso f WHERE f.idEstado = :idEstado"),
    @NamedQuery(name = "FxaEgreso.findByIdAcper", query = "SELECT f FROM FxaEgreso f WHERE f.idAcper = :idAcper"),
    @NamedQuery(name = "FxaEgreso.findByIdProduc", query = "SELECT f FROM FxaEgreso f WHERE f.idProduc = :idProduc")})
public class FxaEgreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_acexp")
    private Integer idAcexp;
    @Column(name = "id_promegr")
    private Integer idPromegr;
    @Basic(optional = false)
    @Column(name = "id_especialidad")
    private int idEspecialidad;
    @Column(name = "id_plancur")
    private Integer idPlancur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "promedio")
    private BigDecimal promedio;
    @Column(name = "id_dtra")
    private Integer idDtra;
    @Column(name = "cod_dtra")
    private String codDtra;
    @Column(name = "puesto_ambito")
    private Short puestoAmbito;
    @Column(name = "puesto_especialidad")
    private Short puestoEspecialidad;
    @Column(name = "prom_seccion_egreso")
    private Character promSeccionEgreso;
    @Column(name = "fecha_egreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEgreso;
    @Column(name = "fecha_titulacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTitulacion;
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Column(name = "id_creador")
    private int idCreador;
    @Basic(optional = false)
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "id_modegr")
    private Character idModegr;
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Character idEstado;
    @Column(name = "id_acper")
    private Integer idAcper;
    @Column(name = "id_produc")
    private Integer idProduc;

    public FxaEgreso() {
    }

    public FxaEgreso(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public FxaEgreso(Integer idAcexp, int idEspecialidad, int idCreador, Date fechaReg, Character idEstado) {
        this.idAcexp = idAcexp;
        this.idEspecialidad = idEspecialidad;
        this.idCreador = idCreador;
        this.fechaReg = fechaReg;
        this.idEstado = idEstado;
    }

    public Integer getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public Integer getIdPromegr() {
        return idPromegr;
    }

    public void setIdPromegr(Integer idPromegr) {
        this.idPromegr = idPromegr;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdPlancur() {
        return idPlancur;
    }

    public void setIdPlancur(Integer idPlancur) {
        this.idPlancur = idPlancur;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public Integer getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(Integer idDtra) {
        this.idDtra = idDtra;
    }

    public String getCodDtra() {
        return codDtra;
    }

    public void setCodDtra(String codDtra) {
        this.codDtra = codDtra;
    }

    public Short getPuestoAmbito() {
        return puestoAmbito;
    }

    public void setPuestoAmbito(Short puestoAmbito) {
        this.puestoAmbito = puestoAmbito;
    }

    public Short getPuestoEspecialidad() {
        return puestoEspecialidad;
    }

    public void setPuestoEspecialidad(Short puestoEspecialidad) {
        this.puestoEspecialidad = puestoEspecialidad;
    }

    public Character getPromSeccionEgreso() {
        return promSeccionEgreso;
    }

    public void setPromSeccionEgreso(Character promSeccionEgreso) {
        this.promSeccionEgreso = promSeccionEgreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Date getFechaTitulacion() {
        return fechaTitulacion;
    }

    public void setFechaTitulacion(Date fechaTitulacion) {
        this.fechaTitulacion = fechaTitulacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Character getIdModegr() {
        return idModegr;
    }

    public void setIdModegr(Character idModegr) {
        this.idModegr = idModegr;
    }

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(Integer idAcper) {
        this.idAcper = idAcper;
    }

    public Integer getIdProduc() {
        return idProduc;
    }

    public void setIdProduc(Integer idProduc) {
        this.idProduc = idProduc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcexp != null ? idAcexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxaEgreso)) {
            return false;
        }
        FxaEgreso other = (FxaEgreso) object;
        if ((this.idAcexp == null && other.idAcexp != null) || (this.idAcexp != null && !this.idAcexp.equals(other.idAcexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.model.FxaEgreso[ idAcexp=" + idAcexp + " ]";
    }
    
}
