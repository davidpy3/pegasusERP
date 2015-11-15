package org.pegasus.personal.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marcaciones")
public class Marcacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MarcacionPK marcacionPK;
    @Column(name = "tipo_hor")
    private Character tipoHor;
    @Column(name = "turno")
    private Character turno;
    @Column(name = "registro")
    private Character registro;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "observ")
    private String observ;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "dni", referencedColumnName = "dni", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Personal personal;

    public Marcacion() {
    }

    public Marcacion(MarcacionPK marcacionPK) {
        this.marcacionPK = marcacionPK;
    }

    public Marcacion(String dni, Date fechaHora) {
        this.marcacionPK = new MarcacionPK(dni, fechaHora);
    }

    public MarcacionPK getMarcacionPK() {
        return marcacionPK;
    }

    public void setMarcacionPK(MarcacionPK marcacionPK) {
        this.marcacionPK = marcacionPK;
    }

    public Character getTipoHor() {
        return tipoHor;
    }

    public void setTipoHor(Character tipoHor) {
        this.tipoHor = tipoHor;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public Character getRegistro() {
        return registro;
    }

    public void setRegistro(Character registro) {
        this.registro = registro;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcacionPK != null ? marcacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcacion)) {
            return false;
        }
        Marcacion other = (Marcacion) object;
        if ((this.marcacionPK == null && other.marcacionPK != null) || (this.marcacionPK != null && !this.marcacionPK.equals(other.marcacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Marcacion[ marcacionPK=" + marcacionPK + " ]";
    }
    
}
