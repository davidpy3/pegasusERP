package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "esc_promociones")
public class EscPromociones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pro")
    private Integer idPro;
    @Basic(optional = false)
    @Column(name = "fecha_prom")
    @Temporal(TemporalType.DATE)
    private Date fechaProm;
    @Basic(optional = false)
    @Column(name = "id_dtra")
    private String idDtra;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumns({
        @JoinColumn(name = "id_cap", referencedColumnName = "id_cap"),
        @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")})
    @ManyToOne(optional = false)
    private EscCap escCap;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne(optional = false)
    private EscPersonal idEsc;
    @JoinColumn(name = "id_tp", referencedColumnName = "id_tp")
    @ManyToOne(optional = false)
    private EscTipoPromocion idTp;

    public EscPromociones() {
    }

    public EscPromociones(Integer idPro) {
        this.idPro = idPro;
    }

    public EscPromociones(Integer idPro, Date fechaProm, String idDtra, boolean estado) {
        this.idPro = idPro;
        this.fechaProm = fechaProm;
        this.idDtra = idDtra;
        this.estado = estado;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public Date getFechaProm() {
        return fechaProm;
    }

    public void setFechaProm(Date fechaProm) {
        this.fechaProm = fechaProm;
    }

    public String getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(String idDtra) {
        this.idDtra = idDtra;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EscCap getEscCap() {
        return escCap;
    }

    public void setEscCap(EscCap escCap) {
        this.escCap = escCap;
    }

    public EscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(EscPersonal idEsc) {
        this.idEsc = idEsc;
    }

    public EscTipoPromocion getIdTp() {
        return idTp;
    }

    public void setIdTp(EscTipoPromocion idTp) {
        this.idTp = idTp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPro != null ? idPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPromociones)) {
            return false;
        }
        EscPromociones other = (EscPromociones) object;
        if ((this.idPro == null && other.idPro != null) || (this.idPro != null && !this.idPro.equals(other.idPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscPromociones[ idPro=" + idPro + " ]";
    }
    
}
