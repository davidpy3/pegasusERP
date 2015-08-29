/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Proceso_tabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoTabla.findAll", query = "SELECT p FROM ProcesoTabla p"),
    @NamedQuery(name = "ProcesoTabla.findByTipoproceso", query = "SELECT p FROM ProcesoTabla p WHERE p.procesoTablaPK.tipoproceso = :tipoproceso"),
    @NamedQuery(name = "ProcesoTabla.findByClasifica", query = "SELECT p FROM ProcesoTabla p WHERE p.procesoTablaPK.clasifica = :clasifica"),
    @NamedQuery(name = "ProcesoTabla.findByAnno", query = "SELECT p FROM ProcesoTabla p WHERE p.procesoTablaPK.anno = :anno"),
    @NamedQuery(name = "ProcesoTabla.findByMayor", query = "SELECT p FROM ProcesoTabla p WHERE p.mayor = :mayor"),
    @NamedQuery(name = "ProcesoTabla.findByMenor", query = "SELECT p FROM ProcesoTabla p WHERE p.menor = :menor")})
public class ProcesoTabla implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoTablaPK procesoTablaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mayor")
    private BigDecimal mayor;
    @Column(name = "menor")
    private BigDecimal menor;
    @JoinColumn(name = "Tipo_proceso", referencedColumnName = "Tipo_proceso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProcesoTipo procesoTipo;

    public ProcesoTabla() {
    }

    public ProcesoTabla(ProcesoTablaPK procesoTablaPK) {
        this.procesoTablaPK = procesoTablaPK;
    }

    public ProcesoTabla(String tipoproceso, Character clasifica, int anno) {
        this.procesoTablaPK = new ProcesoTablaPK(tipoproceso, clasifica, anno);
    }

    public ProcesoTablaPK getProcesoTablaPK() {
        return procesoTablaPK;
    }

    public void setProcesoTablaPK(ProcesoTablaPK procesoTablaPK) {
        this.procesoTablaPK = procesoTablaPK;
    }

    public BigDecimal getMayor() {
        return mayor;
    }

    public void setMayor(BigDecimal mayor) {
        this.mayor = mayor;
    }

    public BigDecimal getMenor() {
        return menor;
    }

    public void setMenor(BigDecimal menor) {
        this.menor = menor;
    }

    public ProcesoTipo getProcesoTipo() {
        return procesoTipo;
    }

    public void setProcesoTipo(ProcesoTipo procesoTipo) {
        this.procesoTipo = procesoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoTablaPK != null ? procesoTablaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoTabla)) {
            return false;
        }
        ProcesoTabla other = (ProcesoTabla) object;
        if ((this.procesoTablaPK == null && other.procesoTablaPK != null) || (this.procesoTablaPK != null && !this.procesoTablaPK.equals(other.procesoTablaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ProcesoTabla[ procesoTablaPK=" + procesoTablaPK + " ]";
    }
    
}
