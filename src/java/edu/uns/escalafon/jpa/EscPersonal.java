package edu.uns.escalafon.jpa;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.jsuns.ocid.DrtPersonaNatural;

@Entity
@Table(name = "esc_personal")
public class EscPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_esc")
    private Integer idEsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion")
    private boolean condicion;
    @Size(max = 25)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 20)
    @Column(name = "abrev_esp")
    private String abrevEsp;
    @Column(name = "fecha_cese")
    @Temporal(TemporalType.DATE)
    private Date fechaCese;
    @Size(max = 400)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 60)
    @Column(name = "id_dtra_cese")
    private String idDtraCese;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private EscTipoPersonal escTipoPersonal;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EscEstadoTrabajador escEstadoTrabajador;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private DrtPersonaNatural drtPersonaNatural;

    public EscPersonal() {
    }

    public EscPersonal(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public EscPersonal(Integer idEsc, Date fechaIng, boolean condicion) {
        this.idEsc = idEsc;
        this.fechaIng = fechaIng;
        this.condicion = condicion;
    }

    public Integer getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(Integer idEsc) {
        this.idEsc = idEsc;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public boolean getCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAbrevEsp() {
        return abrevEsp;
    }

    public void setAbrevEsp(String abrevEsp) {
        this.abrevEsp = abrevEsp;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdDtraCese() {
        return idDtraCese;
    }

    public void setIdDtraCese(String idDtraCese) {
        this.idDtraCese = idDtraCese;
    }

    public EscTipoPersonal getEscTipoPersonal() {
        return escTipoPersonal;
    }

    public void setEscTipoPersonal(EscTipoPersonal idTipo) {
        this.escTipoPersonal = idTipo;
    }

    public EscEstadoTrabajador getEscEstadoTrabajador() {
        return escEstadoTrabajador;
    }

    public void setEscEstadoTrabajador(EscEstadoTrabajador idEstado) {
        this.escEstadoTrabajador = idEstado;
    }

    public DrtPersonaNatural getDrtPersonaNatural() {
        return drtPersonaNatural;
    }

    public void setDrtPersonaNatural(DrtPersonaNatural idDir) {
        this.drtPersonaNatural = idDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsc != null ? idEsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPersonal)) {
            return false;
        }
        EscPersonal other = (EscPersonal) object;
        if ((this.idEsc == null && other.idEsc != null) || (this.idEsc != null && !this.idEsc.equals(other.idEsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgsi.entity.EscPersonal[ idEsc=" + idEsc + " ]";
    }
    
}
