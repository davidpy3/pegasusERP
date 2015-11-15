/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "mbienes_sincerados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MbienesSincerados.findAll", query = "SELECT m FROM MbienesSincerados m"),
    @NamedQuery(name = "MbienesSincerados.findByCodbien", query = "SELECT m FROM MbienesSincerados m WHERE m.mbienesSinceradosPK.codbien = :codbien"),
    @NamedQuery(name = "MbienesSincerados.findByCorrela", query = "SELECT m FROM MbienesSincerados m WHERE m.mbienesSinceradosPK.correla = :correla"),
    @NamedQuery(name = "MbienesSincerados.findByAnoEje", query = "SELECT m FROM MbienesSincerados m WHERE m.mbienesSinceradosPK.anoEje = :anoEje"),
    @NamedQuery(name = "MbienesSincerados.findByNumInv", query = "SELECT m FROM MbienesSincerados m WHERE m.mbienesSinceradosPK.numInv = :numInv"),
    @NamedQuery(name = "MbienesSincerados.findByMarca", query = "SELECT m FROM MbienesSincerados m WHERE m.marca = :marca"),
    @NamedQuery(name = "MbienesSincerados.findByModelo", query = "SELECT m FROM MbienesSincerados m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "MbienesSincerados.findByTipo", query = "SELECT m FROM MbienesSincerados m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "MbienesSincerados.findByColor", query = "SELECT m FROM MbienesSincerados m WHERE m.color = :color"),
    @NamedQuery(name = "MbienesSincerados.findBySerie", query = "SELECT m FROM MbienesSincerados m WHERE m.serie = :serie"),
    @NamedQuery(name = "MbienesSincerados.findByNummotor", query = "SELECT m FROM MbienesSincerados m WHERE m.nummotor = :nummotor"),
    @NamedQuery(name = "MbienesSincerados.findByNumchasis", query = "SELECT m FROM MbienesSincerados m WHERE m.numchasis = :numchasis"),
    @NamedQuery(name = "MbienesSincerados.findByA\u00f1o", query = "SELECT m FROM MbienesSincerados m WHERE m.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "MbienesSincerados.findByDimension", query = "SELECT m FROM MbienesSincerados m WHERE m.dimension = :dimension"),
    @NamedQuery(name = "MbienesSincerados.findByRaza", query = "SELECT m FROM MbienesSincerados m WHERE m.raza = :raza"),
    @NamedQuery(name = "MbienesSincerados.findByEspecie", query = "SELECT m FROM MbienesSincerados m WHERE m.especie = :especie"),
    @NamedQuery(name = "MbienesSincerados.findByOtros", query = "SELECT m FROM MbienesSincerados m WHERE m.otros = :otros"),
    @NamedQuery(name = "MbienesSincerados.findByPlaca", query = "SELECT m FROM MbienesSincerados m WHERE m.placa = :placa"),
    @NamedQuery(name = "MbienesSincerados.findByEdad", query = "SELECT m FROM MbienesSincerados m WHERE m.edad = :edad")})
public class MbienesSincerados implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MbienesSinceradosPK mbienesSinceradosPK;
    @Size(max = 15)
    @Column(name = "marca")
    private String marca;
    @Size(max = 15)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 15)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "serie")
    private String serie;
    @Size(max = 15)
    @Column(name = "nummotor")
    private String nummotor;
    @Size(max = 15)
    @Column(name = "numchasis")
    private String numchasis;
    @Size(max = 4)
    @Column(name = "a\u00f1o")
    private String año;
    @Size(max = 15)
    @Column(name = "dimension")
    private String dimension;
    @Size(max = 15)
    @Column(name = "raza")
    private String raza;
    @Size(max = 15)
    @Column(name = "especie")
    private String especie;
    @Size(max = 500)
    @Column(name = "otros")
    private String otros;
    @Size(max = 7)
    @Column(name = "placa")
    private String placa;
    @Size(max = 5)
    @Column(name = "edad")
    private String edad;

    public MbienesSincerados() {
    }

    public MbienesSincerados(MbienesSinceradosPK mbienesSinceradosPK) {
        this.mbienesSinceradosPK = mbienesSinceradosPK;
    }

    public MbienesSincerados(MbienesSinceradosPK mbienesSinceradosPK, String serie) {
        this.mbienesSinceradosPK = mbienesSinceradosPK;
        this.serie = serie;
    }

    public MbienesSincerados(String codbien, String correla, String anoEje, String numInv) {
        this.mbienesSinceradosPK = new MbienesSinceradosPK(codbien, correla, anoEje, numInv);
    }

    public MbienesSinceradosPK getMbienesSinceradosPK() {
        return mbienesSinceradosPK;
    }

    public void setMbienesSinceradosPK(MbienesSinceradosPK mbienesSinceradosPK) {
        this.mbienesSinceradosPK = mbienesSinceradosPK;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNummotor() {
        return nummotor;
    }

    public void setNummotor(String nummotor) {
        this.nummotor = nummotor;
    }

    public String getNumchasis() {
        return numchasis;
    }

    public void setNumchasis(String numchasis) {
        this.numchasis = numchasis;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mbienesSinceradosPK != null ? mbienesSinceradosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MbienesSincerados)) {
            return false;
        }
        MbienesSincerados other = (MbienesSincerados) object;
        if ((this.mbienesSinceradosPK == null && other.mbienesSinceradosPK != null) || (this.mbienesSinceradosPK != null && !this.mbienesSinceradosPK.equals(other.mbienesSinceradosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.MbienesSincerados[ mbienesSinceradosPK=" + mbienesSinceradosPK + " ]";
    }
    
}
