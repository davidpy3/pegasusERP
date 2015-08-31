/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "conceptos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c"),
    @NamedQuery(name = "Concepto.findByCodigo", query = "SELECT c FROM Concepto c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Concepto.findByConcepto", query = "SELECT c FROM Concepto c WHERE c.concepto = :concepto"),
    @NamedQuery(name = "Concepto.findByCodPDT", query = "SELECT c FROM Concepto c WHERE c.codPDT = :codPDT"),
    @NamedQuery(name = "Concepto.findByCalculo", query = "SELECT c FROM Concepto c WHERE c.calculo = :calculo"),
    @NamedQuery(name = "Concepto.findByProcesar", query = "SELECT c FROM Concepto c WHERE c.procesar = :procesar"),
    @NamedQuery(name = "Concepto.findBySelec", query = "SELECT c FROM Concepto c WHERE c.selec = :selec"),
    @NamedQuery(name = "Concepto.findByGlosa", query = "SELECT c FROM Concepto c WHERE c.glosa = :glosa")})
public class Concepto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 100)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_PDT")
    private String codPDT;
    @Column(name = "calculo")
    private Character calculo;
    @Column(name = "procesar")
    private Character procesar;
    @Column(name = "selec")
    private Character selec;
    @Size(max = 100)
    @Column(name = "glosa")
    private String glosa;

    public Concepto() {
    }

    public Concepto(String codigo) {
        this.codigo = codigo;
    }

    public Concepto(String codigo, String codPDT) {
        this.codigo = codigo;
        this.codPDT = codPDT;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getCodPDT() {
        return codPDT;
    }

    public void setCodPDT(String codPDT) {
        this.codPDT = codPDT;
    }

    public Character getCalculo() {
        return calculo;
    }

    public void setCalculo(Character calculo) {
        this.calculo = calculo;
    }

    public Character getProcesar() {
        return procesar;
    }

    public void setProcesar(Character procesar) {
        this.procesar = procesar;
    }

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Concepto[ codigo=" + codigo + " ]";
    }
    
}
