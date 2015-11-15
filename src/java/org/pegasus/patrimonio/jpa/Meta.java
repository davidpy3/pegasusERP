/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "meta")
public class Meta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MetaPK metaPK;
    @Size(max = 6)
    @Column(name = "sec_ejec")
    private String secEjec;
    @Size(max = 2)
    @Column(name = "funcion")
    private String funcion;
    @Size(max = 3)
    @Column(name = "programa")
    private String programa;
    @Size(max = 4)
    @Column(name = "sub_programa")
    private String subPrograma;
    @Size(max = 7)
    @Column(name = "act_proy")
    private String actProy;
    @Size(max = 7)
    @Column(name = "componente")
    private String componente;
    @Size(max = 5)
    @Column(name = "meta")
    private String meta;
    @Size(max = 7)
    @Column(name = "finalidad")
    private String finalidad;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2)
    @Column(name = "departamento")
    private String departamento;
    @Size(max = 2)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 2)
    @Column(name = "distrito")
    private String distrito;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 4)
    @Column(name = "NM")
    private String nm;
    @Size(max = 250)
    @Column(name = "nombre_nm")
    private String nombreNm;

    public Meta() {
    }

    public Meta(MetaPK metaPK) {
        this.metaPK = metaPK;
    }

    public Meta(String anoEje, String secFunc) {
        this.metaPK = new MetaPK(anoEje, secFunc);
    }

    public MetaPK getMetaPK() {
        return metaPK;
    }

    public void setMetaPK(MetaPK metaPK) {
        this.metaPK = metaPK;
    }

    public String getSecEjec() {
        return secEjec;
    }

    public void setSecEjec(String secEjec) {
        this.secEjec = secEjec;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSubPrograma() {
        return subPrograma;
    }

    public void setSubPrograma(String subPrograma) {
        this.subPrograma = subPrograma;
    }

    public String getActProy() {
        return actProy;
    }

    public void setActProy(String actProy) {
        this.actProy = actProy;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getNombreNm() {
        return nombreNm;
    }

    public void setNombreNm(String nombreNm) {
        this.nombreNm = nombreNm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaPK != null ? metaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meta)) {
            return false;
        }
        Meta other = (Meta) object;
        if ((this.metaPK == null && other.metaPK != null) || (this.metaPK != null && !this.metaPK.equals(other.metaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Meta[ metaPK=" + metaPK + " ]";
    }
    
}
