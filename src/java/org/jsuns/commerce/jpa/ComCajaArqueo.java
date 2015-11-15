package org.jsuns.commerce.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "com_caja_arqueo")
public class ComCajaArqueo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arqueo")
    private Integer idArqueo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private int idDir;
    @Column(name = "id_terminal")
    private Integer idTerminal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_ini")
    private float cantidadIni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad_fin")
    private Float cantidadFin;

    public ComCajaArqueo() {
    }

    public ComCajaArqueo(Integer idArqueo) {
        this.idArqueo = idArqueo;
    }

    public Integer getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(Integer idArqueo) {
        this.idArqueo = idArqueo;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCantidadIni() {
        return cantidadIni;
    }

    public void setCantidadIni(float cantidadIni) {
        this.cantidadIni = cantidadIni;
    }

    public Float getCantidadFin() {
        return cantidadFin;
    }

    public void setCantidadFin(Float cantidadFin) {
        this.cantidadFin = cantidadFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArqueo != null ? idArqueo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComCajaArqueo)) {
            return false;
        }
        ComCajaArqueo other = (ComCajaArqueo) object;
        if ((this.idArqueo == null && other.idArqueo != null) || (this.idArqueo != null && !this.idArqueo.equals(other.idArqueo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComCajaArqueo[ idArqueo=" + idArqueo + " ]";
    }
    
}
