/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esc_cargoinstitucion")
public class EscCargoInstitucional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Basic(optional = false)
    @Column(name = "hasta")
    @Temporal(TemporalType.DATE)
    private Date hasta;
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "condicion")
    private Character condicion;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "aprobado")
    private boolean aprobado;
    @Column(name = "cod_dtra")
    private String codDtra;
    @JoinColumn(name = "id_inst", referencedColumnName = "id_inst")
    @ManyToOne(optional = false)
    private EscInstituciones idInst;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_tc", referencedColumnName = "id_tc")
    @ManyToOne
    private EscTipC idTc;

    public EscCargoInstitucional() {
    }

    public EscCargoInstitucional(Integer id) {
        this.id = id;
    }

    public EscCargoInstitucional(Integer id, Date desde, Date hasta, Character condicion, boolean aprobado) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.condicion = condicion;
        this.aprobado = aprobado;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Character getCondicion() {
        return condicion;
    }

    public void setCondicion(Character condicion) {
        this.condicion = condicion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getCodDtra() {
        return codDtra;
    }

    public void setCodDtra(String codDtra) {
        this.codDtra = codDtra;
    }

    public EscInstituciones getIdInst() {
        return idInst;
    }

    public void setIdInst(EscInstituciones idInst) {
        this.idInst = idInst;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipC getIdTc() {
        return idTc;
    }

    public void setIdTc(EscTipC idTc) {
        this.idTc = idTc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCargoInstitucional)) {
            return false;
        }
        EscCargoInstitucional other = (EscCargoInstitucional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCargoInstitucional[ id=" + id + " ]";
    }
    
}
