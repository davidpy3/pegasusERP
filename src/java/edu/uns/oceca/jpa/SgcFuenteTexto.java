/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_fuente_texto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcFuenteTexto.findAll", query = "SELECT s FROM SgcFuenteTexto s"),
    @NamedQuery(name = "SgcFuenteTexto.findByIdFuetex", query = "SELECT s FROM SgcFuenteTexto s WHERE s.idFuetex = :idFuetex"),
    @NamedQuery(name = "SgcFuenteTexto.findByIdAutoevaluacion", query = "SELECT s FROM SgcFuenteTexto s WHERE s.idAutoevaluacion = :idAutoevaluacion"),
    @NamedQuery(name = "SgcFuenteTexto.findByIdFuente", query = "SELECT s FROM SgcFuenteTexto s WHERE s.idFuente = :idFuente"),
    @NamedQuery(name = "SgcFuenteTexto.findByTitulo", query = "SELECT s FROM SgcFuenteTexto s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "SgcFuenteTexto.findByPeso", query = "SELECT s FROM SgcFuenteTexto s WHERE s.peso = :peso"),
    @NamedQuery(name = "SgcFuenteTexto.findByPagina", query = "SELECT s FROM SgcFuenteTexto s WHERE s.pagina = :pagina"),
    @NamedQuery(name = "SgcFuenteTexto.findByIdEstado", query = "SELECT s FROM SgcFuenteTexto s WHERE s.idEstado = :idEstado")})
public class SgcFuenteTexto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_fuetex")
    private Integer idFuetex;
    @Column(name = "id_autoevaluacion")
    private Integer idAutoevaluacion;
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private int idFuente;
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "texto")
    private String texto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "pagina")
    private Short pagina;
    @Column(name = "id_estado")
    private String idEstado;

    public SgcFuenteTexto() {
    }

    public SgcFuenteTexto(Integer idFuetex) {
        this.idFuetex = idFuetex;
    }

    public SgcFuenteTexto(Integer idFuetex, int idFuente) {
        this.idFuetex = idFuetex;
        this.idFuente = idFuente;
    }

    public Integer getIdFuetex() {
        return idFuetex;
    }

    public void setIdFuetex(Integer idFuetex) {
        this.idFuetex = idFuetex;
    }

    public Integer getIdAutoevaluacion() {
        return idAutoevaluacion;
    }

    public void setIdAutoevaluacion(Integer idAutoevaluacion) {
        this.idAutoevaluacion = idAutoevaluacion;
    }

    public int getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(int idFuente) {
        this.idFuente = idFuente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Short getPagina() {
        return pagina;
    }

    public void setPagina(Short pagina) {
        this.pagina = pagina;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuetex != null ? idFuetex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteTexto)) {
            return false;
        }
        SgcFuenteTexto other = (SgcFuenteTexto) object;
        if ((this.idFuetex == null && other.idFuetex != null) || (this.idFuetex != null && !this.idFuetex.equals(other.idFuetex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteTexto[ idFuetex=" + idFuetex + " ]";
    }
    
}
