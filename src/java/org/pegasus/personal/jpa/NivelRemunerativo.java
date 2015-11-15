/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import org.pegasus.personal.jpa.TipoTrabajador;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "nivel_remunerativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelRemunerativo.findAll", query = "SELECT n FROM NivelRemunerativo n"),
    @NamedQuery(name = "NivelRemunerativo.findByTipoTrab", query = "SELECT n FROM NivelRemunerativo n WHERE n.nivelRemunerativoPK.tipoTrab = :tipoTrab"),
    @NamedQuery(name = "NivelRemunerativo.findByNivelRem", query = "SELECT n FROM NivelRemunerativo n WHERE n.nivelRemunerativoPK.nivelRem = :nivelRem"),
    @NamedQuery(name = "NivelRemunerativo.findByNombre", query = "SELECT n FROM NivelRemunerativo n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "NivelRemunerativo.findByAbrev", query = "SELECT n FROM NivelRemunerativo n WHERE n.abrev = :abrev"),
    @NamedQuery(name = "NivelRemunerativo.findByPeriodicidad", query = "SELECT n FROM NivelRemunerativo n WHERE n.periodicidad = :periodicidad"),
    @NamedQuery(name = "NivelRemunerativo.findByMontoBasico", query = "SELECT n FROM NivelRemunerativo n WHERE n.montoBasico = :montoBasico"),
    @NamedQuery(name = "NivelRemunerativo.findByMontoTope", query = "SELECT n FROM NivelRemunerativo n WHERE n.montoTope = :montoTope"),
    @NamedQuery(name = "NivelRemunerativo.findByBuc", query = "SELECT n FROM NivelRemunerativo n WHERE n.buc = :buc")})
public class NivelRemunerativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelRemunerativoPK nivelRemunerativoPK;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "periodicidad")
    private Character periodicidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_basico")
    private BigDecimal montoBasico;
    @Column(name = "monto_tope")
    private BigDecimal montoTope;
    @Column(name = "BUC")
    private BigDecimal buc;
    @JoinColumn(name = "tipo_trab", referencedColumnName = "tipo_trab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoTrabajador tipoTrabajador;

    public NivelRemunerativo() {
    }

    public NivelRemunerativo(NivelRemunerativoPK nivelRemunerativoPK) {
        this.nivelRemunerativoPK = nivelRemunerativoPK;
    }

    public NivelRemunerativo(String tipoTrab, String nivelRem) {
        this.nivelRemunerativoPK = new NivelRemunerativoPK(tipoTrab, nivelRem);
    }

    public NivelRemunerativoPK getNivelRemunerativoPK() {
        return nivelRemunerativoPK;
    }

    public void setNivelRemunerativoPK(NivelRemunerativoPK nivelRemunerativoPK) {
        this.nivelRemunerativoPK = nivelRemunerativoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public Character getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Character periodicidad) {
        this.periodicidad = periodicidad;
    }

    public BigDecimal getMontoBasico() {
        return montoBasico;
    }

    public void setMontoBasico(BigDecimal montoBasico) {
        this.montoBasico = montoBasico;
    }

    public BigDecimal getMontoTope() {
        return montoTope;
    }

    public void setMontoTope(BigDecimal montoTope) {
        this.montoTope = montoTope;
    }

    public BigDecimal getBuc() {
        return buc;
    }

    public void setBuc(BigDecimal buc) {
        this.buc = buc;
    }

    public TipoTrabajador getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivelRemunerativoPK != null ? nivelRemunerativoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelRemunerativo)) {
            return false;
        }
        NivelRemunerativo other = (NivelRemunerativo) object;
        if ((this.nivelRemunerativoPK == null && other.nivelRemunerativoPK != null) || (this.nivelRemunerativoPK != null && !this.nivelRemunerativoPK.equals(other.nivelRemunerativoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.NivelRemunerativo[ nivelRemunerativoPK=" + nivelRemunerativoPK + " ]";
    }
    
}
