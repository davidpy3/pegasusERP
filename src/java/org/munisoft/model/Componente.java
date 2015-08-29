/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "componente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c"),
    @NamedQuery(name = "Componente.findByAnoEje", query = "SELECT c FROM Componente c WHERE c.componentePK.anoEje = :anoEje"),
    @NamedQuery(name = "Componente.findByFuncion", query = "SELECT c FROM Componente c WHERE c.componentePK.funcion = :funcion"),
    @NamedQuery(name = "Componente.findByPrograma", query = "SELECT c FROM Componente c WHERE c.componentePK.programa = :programa"),
    @NamedQuery(name = "Componente.findBySubPrograma", query = "SELECT c FROM Componente c WHERE c.componentePK.subPrograma = :subPrograma"),
    @NamedQuery(name = "Componente.findByActProy", query = "SELECT c FROM Componente c WHERE c.componentePK.actProy = :actProy"),
    @NamedQuery(name = "Componente.findByComponente", query = "SELECT c FROM Componente c WHERE c.componentePK.componente = :componente"),
    @NamedQuery(name = "Componente.findByEstado", query = "SELECT c FROM Componente c WHERE c.estado = :estado"),
    @NamedQuery(name = "Componente.findByFinalidad", query = "SELECT c FROM Componente c WHERE c.finalidad = :finalidad")})
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComponentePK componentePK;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 5)
    @Column(name = "finalidad")
    private String finalidad;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "funcion", referencedColumnName = "funcion", insertable = false, updatable = false),
        @JoinColumn(name = "programa", referencedColumnName = "programa", insertable = false, updatable = false),
        @JoinColumn(name = "sub_programa", referencedColumnName = "sub_programa", insertable = false, updatable = false),
        @JoinColumn(name = "act_proy", referencedColumnName = "act_proy", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ActProy actProy1;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "componente", referencedColumnName = "componente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ComponenteNombre componenteNombre;

    public Componente() {
    }

    public Componente(ComponentePK componentePK) {
        this.componentePK = componentePK;
    }

    public Componente(String anoEje, String funcion, String programa, String subPrograma, String actProy, String componente) {
        this.componentePK = new ComponentePK(anoEje, funcion, programa, subPrograma, actProy, componente);
    }

    public ComponentePK getComponentePK() {
        return componentePK;
    }

    public void setComponentePK(ComponentePK componentePK) {
        this.componentePK = componentePK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    public ActProy getActProy1() {
        return actProy1;
    }

    public void setActProy1(ActProy actProy1) {
        this.actProy1 = actProy1;
    }

    public ComponenteNombre getComponenteNombre() {
        return componenteNombre;
    }

    public void setComponenteNombre(ComponenteNombre componenteNombre) {
        this.componenteNombre = componenteNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentePK != null ? componentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.componentePK == null && other.componentePK != null) || (this.componentePK != null && !this.componentePK.equals(other.componentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Componente[ componentePK=" + componentePK + " ]";
    }
    
}
