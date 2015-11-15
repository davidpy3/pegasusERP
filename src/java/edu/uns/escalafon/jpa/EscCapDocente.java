/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "esc_cap_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCapDocente.findAll", query = "SELECT e FROM EscCapDocente e"),
    @NamedQuery(name = "EscCapDocente.findByIdCap", query = "SELECT e FROM EscCapDocente e WHERE e.escCapDocentePK.idCap = :idCap"),
    @NamedQuery(name = "EscCapDocente.findByIdDep", query = "SELECT e FROM EscCapDocente e WHERE e.escCapDocentePK.idDep = :idDep"),
    @NamedQuery(name = "EscCapDocente.findByNroCargo", query = "SELECT e FROM EscCapDocente e WHERE e.nroCargo = :nroCargo"),
    @NamedQuery(name = "EscCapDocente.findByTotalNecesario", query = "SELECT e FROM EscCapDocente e WHERE e.totalNecesario = :totalNecesario"),
    @NamedQuery(name = "EscCapDocente.findByPrevistos", query = "SELECT e FROM EscCapDocente e WHERE e.previstos = :previstos"),
    @NamedQuery(name = "EscCapDocente.findByNombrados", query = "SELECT e FROM EscCapDocente e WHERE e.nombrados = :nombrados"),
    @NamedQuery(name = "EscCapDocente.findByVacantes", query = "SELECT e FROM EscCapDocente e WHERE e.vacantes = :vacantes"),
    @NamedQuery(name = "EscCapDocente.findByObservaciones", query = "SELECT e FROM EscCapDocente e WHERE e.observaciones = :observaciones"),
    @NamedQuery(name = "EscCapDocente.findByCargo", query = "SELECT e FROM EscCapDocente e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "EscCapDocente.findByCodigo", query = "SELECT e FROM EscCapDocente e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "EscCapDocente.findByContratados", query = "SELECT e FROM EscCapDocente e WHERE e.contratados = :contratados")})
public class EscCapDocente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscCapDocentePK escCapDocentePK;
    @Basic(optional = false)
    @Column(name = "nro_cargo")
    private short nroCargo;
    @Basic(optional = false)
    @Column(name = "total_necesario")
    private short totalNecesario;
    @Basic(optional = false)
    @Column(name = "previstos")
    private short previstos;
    @Basic(optional = false)
    @Column(name = "nombrados")
    private short nombrados;
    @Basic(optional = false)
    @Column(name = "vacantes")
    private short vacantes;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "contratados")
    private Integer contratados;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private EscCategoria idCategoria;
    @JoinColumn(name = "id_hist_cap", referencedColumnName = "id_hist_cap")
    @ManyToOne(optional = false)
    private EscHistoriaCap idHistCap;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCapDocente")
    private List<EscPromocionesDoc> escPromocionesDocList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCapDocente")
    private List<EscNombramientosDoc> escNombramientosDocList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCapDocente")
    private List<EscContratosDoc> escContratosDocList;

    public EscCapDocente() {
    }

    public EscCapDocente(EscCapDocentePK escCapDocentePK) {
        this.escCapDocentePK = escCapDocentePK;
    }

    public EscCapDocente(EscCapDocentePK escCapDocentePK, short nroCargo, short totalNecesario, short previstos, short nombrados, short vacantes) {
        this.escCapDocentePK = escCapDocentePK;
        this.nroCargo = nroCargo;
        this.totalNecesario = totalNecesario;
        this.previstos = previstos;
        this.nombrados = nombrados;
        this.vacantes = vacantes;
    }

    public EscCapDocente(int idCap, int idDep) {
        this.escCapDocentePK = new EscCapDocentePK(idCap, idDep);
    }

    public EscCapDocentePK getEscCapDocentePK() {
        return escCapDocentePK;
    }

    public void setEscCapDocentePK(EscCapDocentePK escCapDocentePK) {
        this.escCapDocentePK = escCapDocentePK;
    }

    public short getNroCargo() {
        return nroCargo;
    }

    public void setNroCargo(short nroCargo) {
        this.nroCargo = nroCargo;
    }

    public short getTotalNecesario() {
        return totalNecesario;
    }

    public void setTotalNecesario(short totalNecesario) {
        this.totalNecesario = totalNecesario;
    }

    public short getPrevistos() {
        return previstos;
    }

    public void setPrevistos(short previstos) {
        this.previstos = previstos;
    }

    public short getNombrados() {
        return nombrados;
    }

    public void setNombrados(short nombrados) {
        this.nombrados = nombrados;
    }

    public short getVacantes() {
        return vacantes;
    }

    public void setVacantes(short vacantes) {
        this.vacantes = vacantes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getContratados() {
        return contratados;
    }

    public void setContratados(Integer contratados) {
        this.contratados = contratados;
    }

    public EscCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(EscCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public EscHistoriaCap getIdHistCap() {
        return idHistCap;
    }

    public void setIdHistCap(EscHistoriaCap idHistCap) {
        this.idHistCap = idHistCap;
    }

    @XmlTransient
    public List<EscPromocionesDoc> getEscPromocionesDocList() {
        return escPromocionesDocList;
    }

    public void setEscPromocionesDocList(List<EscPromocionesDoc> escPromocionesDocList) {
        this.escPromocionesDocList = escPromocionesDocList;
    }

    @XmlTransient
    public List<EscNombramientosDoc> getEscNombramientosDocList() {
        return escNombramientosDocList;
    }

    public void setEscNombramientosDocList(List<EscNombramientosDoc> escNombramientosDocList) {
        this.escNombramientosDocList = escNombramientosDocList;
    }

    @XmlTransient
    public List<EscContratosDoc> getEscContratosDocList() {
        return escContratosDocList;
    }

    public void setEscContratosDocList(List<EscContratosDoc> escContratosDocList) {
        this.escContratosDocList = escContratosDocList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escCapDocentePK != null ? escCapDocentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCapDocente)) {
            return false;
        }
        EscCapDocente other = (EscCapDocente) object;
        if ((this.escCapDocentePK == null && other.escCapDocentePK != null) || (this.escCapDocentePK != null && !this.escCapDocentePK.equals(other.escCapDocentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCapDocente[ escCapDocentePK=" + escCapDocentePK + " ]";
    }
    
}
