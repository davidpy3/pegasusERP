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

@Entity
@Table(name = "esc_cap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscCap.findAll", query = "SELECT e FROM EscCap e"),
    @NamedQuery(name = "EscCap.findByIdCap", query = "SELECT e FROM EscCap e WHERE e.escCapPK.idCap = :idCap"),
    @NamedQuery(name = "EscCap.findByIdDep", query = "SELECT e FROM EscCap e WHERE e.escCapPK.idDep = :idDep"),
    @NamedQuery(name = "EscCap.findByCodigo", query = "SELECT e FROM EscCap e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "EscCap.findByCargo", query = "SELECT e FROM EscCap e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "EscCap.findByObservaciones", query = "SELECT e FROM EscCap e WHERE e.observaciones = :observaciones"),
    @NamedQuery(name = "EscCap.findByNroCargo", query = "SELECT e FROM EscCap e WHERE e.nroCargo = :nroCargo"),
    @NamedQuery(name = "EscCap.findByTotalNecesario", query = "SELECT e FROM EscCap e WHERE e.totalNecesario = :totalNecesario"),
    @NamedQuery(name = "EscCap.findByPrevistos", query = "SELECT e FROM EscCap e WHERE e.previstos = :previstos"),
    @NamedQuery(name = "EscCap.findByNombrados", query = "SELECT e FROM EscCap e WHERE e.nombrados = :nombrados"),
    @NamedQuery(name = "EscCap.findByContratados", query = "SELECT e FROM EscCap e WHERE e.contratados = :contratados"),
    @NamedQuery(name = "EscCap.findByVacantes", query = "SELECT e FROM EscCap e WHERE e.vacantes = :vacantes")})
public class EscCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscCapPK escCapPK;
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "nro_cargo")
    private Short nroCargo;
    @Column(name = "total_necesario")
    private Short totalNecesario;
    @Column(name = "previstos")
    private Short previstos;
    @Column(name = "nombrados")
    private Short nombrados;
    @Column(name = "contratados")
    private Short contratados;
    @Column(name = "vacantes")
    private Short vacantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscNombramientos> escNombramientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscContratosOtros> escContratosOtrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscContratos> escContratosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscEncargaturas> escEncargaturasList;
    @JoinColumn(name = "id_hist_cap", referencedColumnName = "id_hist_cap")
    @ManyToOne
    private EscHistoriaCap idHistCap;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne
    private EscNivelRemunerativo idNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscPersDep> escPersDepList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscRotaciones> escRotacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscPromociones> escPromocionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escCap")
    private List<EscRotacionesCas> escRotacionesCasList;

    public EscCap() {
    }

    public EscCap(EscCapPK escCapPK) {
        this.escCapPK = escCapPK;
    }

    public EscCap(EscCapPK escCapPK, String cargo) {
        this.escCapPK = escCapPK;
        this.cargo = cargo;
    }

    public EscCap(int idCap, int idDep) {
        this.escCapPK = new EscCapPK(idCap, idDep);
    }

    public EscCapPK getEscCapPK() {
        return escCapPK;
    }

    public void setEscCapPK(EscCapPK escCapPK) {
        this.escCapPK = escCapPK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Short getNroCargo() {
        return nroCargo;
    }

    public void setNroCargo(Short nroCargo) {
        this.nroCargo = nroCargo;
    }

    public Short getTotalNecesario() {
        return totalNecesario;
    }

    public void setTotalNecesario(Short totalNecesario) {
        this.totalNecesario = totalNecesario;
    }

    public Short getPrevistos() {
        return previstos;
    }

    public void setPrevistos(Short previstos) {
        this.previstos = previstos;
    }

    public Short getNombrados() {
        return nombrados;
    }

    public void setNombrados(Short nombrados) {
        this.nombrados = nombrados;
    }

    public Short getContratados() {
        return contratados;
    }

    public void setContratados(Short contratados) {
        this.contratados = contratados;
    }

    public Short getVacantes() {
        return vacantes;
    }

    public void setVacantes(Short vacantes) {
        this.vacantes = vacantes;
    }

    @XmlTransient
    public List<EscNombramientos> getEscNombramientosList() {
        return escNombramientosList;
    }

    public void setEscNombramientosList(List<EscNombramientos> escNombramientosList) {
        this.escNombramientosList = escNombramientosList;
    }

    @XmlTransient
    public List<EscContratosOtros> getEscContratosOtrosList() {
        return escContratosOtrosList;
    }

    public void setEscContratosOtrosList(List<EscContratosOtros> escContratosOtrosList) {
        this.escContratosOtrosList = escContratosOtrosList;
    }

    @XmlTransient
    public List<EscContratos> getEscContratosList() {
        return escContratosList;
    }

    public void setEscContratosList(List<EscContratos> escContratosList) {
        this.escContratosList = escContratosList;
    }

    @XmlTransient
    public List<EscEncargaturas> getEscEncargaturasList() {
        return escEncargaturasList;
    }

    public void setEscEncargaturasList(List<EscEncargaturas> escEncargaturasList) {
        this.escEncargaturasList = escEncargaturasList;
    }

    public EscHistoriaCap getIdHistCap() {
        return idHistCap;
    }

    public void setIdHistCap(EscHistoriaCap idHistCap) {
        this.idHistCap = idHistCap;
    }

    public EscNivelRemunerativo getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(EscNivelRemunerativo idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public List<EscPersDep> getEscPersDepList() {
        return escPersDepList;
    }

    public void setEscPersDepList(List<EscPersDep> escPersDepList) {
        this.escPersDepList = escPersDepList;
    }

    @XmlTransient
    public List<EscRotaciones> getEscRotacionesList() {
        return escRotacionesList;
    }

    public void setEscRotacionesList(List<EscRotaciones> escRotacionesList) {
        this.escRotacionesList = escRotacionesList;
    }

    @XmlTransient
    public List<EscPromociones> getEscPromocionesList() {
        return escPromocionesList;
    }

    public void setEscPromocionesList(List<EscPromociones> escPromocionesList) {
        this.escPromocionesList = escPromocionesList;
    }

    @XmlTransient
    public List<EscRotacionesCas> getEscRotacionesCasList() {
        return escRotacionesCasList;
    }

    public void setEscRotacionesCasList(List<EscRotacionesCas> escRotacionesCasList) {
        this.escRotacionesCasList = escRotacionesCasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escCapPK != null ? escCapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCap)) {
            return false;
        }
        EscCap other = (EscCap) object;
        if ((this.escCapPK == null && other.escCapPK != null) || (this.escCapPK != null && !this.escCapPK.equals(other.escCapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCap[ escCapPK=" + escCapPK + " ]";
    }
    
}
