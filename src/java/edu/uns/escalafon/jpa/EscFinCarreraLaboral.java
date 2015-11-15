/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esc_fincarreralaboral")
public class EscFinCarreraLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rcj")
    private Integer idRcj;
    @Basic(optional = false)
    @Column(name = "fecha_efectiva")
    @Temporal(TemporalType.DATE)
    private Date fechaEfectiva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cts")
    private BigDecimal cts;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private EscTipoFinCarreraLab tipo;

    public EscFinCarreraLaboral() {
    }

    public EscFinCarreraLaboral(Integer idRcj) {
        this.idRcj = idRcj;
    }

    public EscFinCarreraLaboral(Integer idRcj, Date fechaEfectiva, String idDtra, boolean activo) {
        this.idRcj = idRcj;
        this.fechaEfectiva = fechaEfectiva;
        this.idDtra = idDtra;
        this.activo = activo;
    }

    public Integer getIdRcj() {
        return idRcj;
    }

    public void setIdRcj(Integer idRcj) {
        this.idRcj = idRcj;
    }

    public Date getFechaEfectiva() {
        return fechaEfectiva;
    }

    public void setFechaEfectiva(Date fechaEfectiva) {
        this.fechaEfectiva = fechaEfectiva;
    }

    public BigDecimal getCts() {
        return cts;
    }

    public void setCts(BigDecimal cts) {
        this.cts = cts;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipoFinCarreraLab getTipo() {
        return tipo;
    }

    public void setTipo(EscTipoFinCarreraLab tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRcj != null ? idRcj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscFinCarreraLaboral)) {
            return false;
        }
        EscFinCarreraLaboral other = (EscFinCarreraLaboral) object;
        if ((this.idRcj == null && other.idRcj != null) || (this.idRcj != null && !this.idRcj.equals(other.idRcj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscFinCarreraLaboral[ idRcj=" + idRcj + " ]";
    }
    
}
