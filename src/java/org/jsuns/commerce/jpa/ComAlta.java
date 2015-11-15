/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_alta")
@NamedQueries({
    @NamedQuery(name = "ComAlta.findAll", query = "SELECT c FROM ComAlta c")})
public class ComAlta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alta")
    private Integer idAlta;
    @Column(name = "id_forma_adquisicion")
    private Character idFormaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo")
    private int correlativo;
    @Column(name = "id_operacion")
    private Integer idOperacion;
    @Column(name = "id_item")
    private Integer idItem;
    @Size(max = 50)
    @Column(name = "identificador")
    private String identificador;
    @Size(max = 150)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Column(name = "id_estado")
    private Character idEstado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "id_ultope")
    private Integer idUltope;

    public ComAlta() {
    }

    public ComAlta(Integer idAlta) {
        this.idAlta = idAlta;
    }

    public ComAlta(Integer idAlta, int idArticulo, int correlativo, int idDep) {
        this.idAlta = idAlta;
        this.idArticulo = idArticulo;
        this.correlativo = correlativo;
        this.idDep = idDep;
    }

    public Integer getIdAlta() {
        return idAlta;
    }

    public void setIdAlta(Integer idAlta) {
        this.idAlta = idAlta;
    }

    public Character getIdFormaAdquisicion() {
        return idFormaAdquisicion;
    }

    public void setIdFormaAdquisicion(Character idFormaAdquisicion) {
        this.idFormaAdquisicion = idFormaAdquisicion;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public Character getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Character idEstado) {
        this.idEstado = idEstado;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getIdUltope() {
        return idUltope;
    }

    public void setIdUltope(Integer idUltope) {
        this.idUltope = idUltope;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlta != null ? idAlta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComAlta)) {
            return false;
        }
        ComAlta other = (ComAlta) object;
        if ((this.idAlta == null && other.idAlta != null) || (this.idAlta != null && !this.idAlta.equals(other.idAlta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComAlta[ idAlta=" + idAlta + " ]";
    }
    
}
