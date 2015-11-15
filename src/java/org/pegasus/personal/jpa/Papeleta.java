package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "papeleta")
public class Papeleta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PapeletaPK papeletaPK;
    @Column(name = "tipo_pape")
    private Character tipoPape;
    @Column(name = "regulariza")
    private Character regulariza;
    @Column(name = "peri_pape")
    private Character periPape;
    @Column(name = "fecha_pape")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPape;
    @Column(name = "fecha_del")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDel;
    @Column(name = "fecha_al")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAl;
    @Column(name = "hora_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaIni;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "estado")
    private Character estado;

    public Papeleta() {
    }

    public Papeleta(PapeletaPK papeletaPK) {
        this.papeletaPK = papeletaPK;
    }

    public Papeleta(String anoEje, String nPapeleta) {
        this.papeletaPK = new PapeletaPK(anoEje, nPapeleta);
    }

    public PapeletaPK getPapeletaPK() {
        return papeletaPK;
    }

    public void setPapeletaPK(PapeletaPK papeletaPK) {
        this.papeletaPK = papeletaPK;
    }

    public Character getTipoPape() {
        return tipoPape;
    }

    public void setTipoPape(Character tipoPape) {
        this.tipoPape = tipoPape;
    }

    public Character getRegulariza() {
        return regulariza;
    }

    public void setRegulariza(Character regulariza) {
        this.regulariza = regulariza;
    }

    public Character getPeriPape() {
        return periPape;
    }

    public void setPeriPape(Character periPape) {
        this.periPape = periPape;
    }

    public Date getFechaPape() {
        return fechaPape;
    }

    public void setFechaPape(Date fechaPape) {
        this.fechaPape = fechaPape;
    }

    public Date getFechaDel() {
        return fechaDel;
    }

    public void setFechaDel(Date fechaDel) {
        this.fechaDel = fechaDel;
    }

    public Date getFechaAl() {
        return fechaAl;
    }

    public void setFechaAl(Date fechaAl) {
        this.fechaAl = fechaAl;
    }

    public Date getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Date horaIni) {
        this.horaIni = horaIni;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (papeletaPK != null ? papeletaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Papeleta)) {
            return false;
        }
        Papeleta other = (Papeleta) object;
        if ((this.papeletaPK == null && other.papeletaPK != null) || (this.papeletaPK != null && !this.papeletaPK.equals(other.papeletaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Papeleta[ papeletaPK=" + papeletaPK + " ]";
    }
    
}
