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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_fuente_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcFuentePregunta.findAll", query = "SELECT s FROM SgcFuentePregunta s"),
    @NamedQuery(name = "SgcFuentePregunta.findByIdFuente", query = "SELECT s FROM SgcFuentePregunta s WHERE s.idFuente = :idFuente"),
    @NamedQuery(name = "SgcFuentePregunta.findByIdPregunta", query = "SELECT s FROM SgcFuentePregunta s WHERE s.idPregunta = :idPregunta"),
    @NamedQuery(name = "SgcFuentePregunta.findByE", query = "SELECT s FROM SgcFuentePregunta s WHERE s.e = :e"),
    @NamedQuery(name = "SgcFuentePregunta.findByS", query = "SELECT s FROM SgcFuentePregunta s WHERE s.s = :s"),
    @NamedQuery(name = "SgcFuentePregunta.findByD", query = "SELECT s FROM SgcFuentePregunta s WHERE s.d = :d"),
    @NamedQuery(name = "SgcFuentePregunta.findByA", query = "SELECT s FROM SgcFuentePregunta s WHERE s.a = :a"),
    @NamedQuery(name = "SgcFuentePregunta.findByB", query = "SELECT s FROM SgcFuentePregunta s WHERE s.b = :b"),
    @NamedQuery(name = "SgcFuentePregunta.findByC", query = "SELECT s FROM SgcFuentePregunta s WHERE s.c = :c"),
    @NamedQuery(name = "SgcFuentePregunta.findByG", query = "SELECT s FROM SgcFuentePregunta s WHERE s.g = :g"),
    @NamedQuery(name = "SgcFuentePregunta.findByV", query = "SELECT s FROM SgcFuentePregunta s WHERE s.v = :v"),
    @NamedQuery(name = "SgcFuentePregunta.findByT", query = "SELECT s FROM SgcFuentePregunta s WHERE s.t = :t"),
    @NamedQuery(name = "SgcFuentePregunta.findByEstado", query = "SELECT s FROM SgcFuentePregunta s WHERE s.estado = :estado")})
public class SgcFuentePregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private int idFuente;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private Integer idPregunta;
    @Basic(optional = false)
    @Column(name = "e")
    private boolean e;
    @Basic(optional = false)
    @Column(name = "s")
    private boolean s;
    @Basic(optional = false)
    @Column(name = "d")
    private boolean d;
    @Basic(optional = false)
    @Column(name = "a")
    private boolean a;
    @Basic(optional = false)
    @Column(name = "b")
    private boolean b;
    @Basic(optional = false)
    @Column(name = "c")
    private boolean c;
    @Basic(optional = false)
    @Column(name = "g")
    private boolean g;
    @Basic(optional = false)
    @Column(name = "v")
    private boolean v;
    @Basic(optional = false)
    @Column(name = "t")
    private boolean t;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    public SgcFuentePregunta() {
    }

    public SgcFuentePregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public SgcFuentePregunta(Integer idPregunta, int idFuente, boolean e, boolean s, boolean d, boolean a, boolean b, boolean c, boolean g, boolean v, boolean t, boolean estado) {
        this.idPregunta = idPregunta;
        this.idFuente = idFuente;
        this.e = e;
        this.s = s;
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
        this.g = g;
        this.v = v;
        this.t = t;
        this.estado = estado;
    }

    public int getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(int idFuente) {
        this.idFuente = idFuente;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public boolean getE() {
        return e;
    }

    public void setE(boolean e) {
        this.e = e;
    }

    public boolean getS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public boolean getD() {
        return d;
    }

    public void setD(boolean d) {
        this.d = d;
    }

    public boolean getA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean getC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean getG() {
        return g;
    }

    public void setG(boolean g) {
        this.g = g;
    }

    public boolean getV() {
        return v;
    }

    public void setV(boolean v) {
        this.v = v;
    }

    public boolean getT() {
        return t;
    }

    public void setT(boolean t) {
        this.t = t;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuentePregunta)) {
            return false;
        }
        SgcFuentePregunta other = (SgcFuentePregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuentePregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
