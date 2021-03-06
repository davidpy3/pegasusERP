package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "patri_movimiento")
public class PatriMovimiento implements Serializable {
    
    public static final int 
            GUIAS_DESPLAZAMIENTO = 2, 
            DEVOLUCION_BIENES_PATRIMONIALES = 3;
    public static final char BORRADOR = '0',
            TRAMITE = '1',
            OBSERVADO = '2',
            AUTORIZADO = '3',
            ADJUDICADO = '4',
            ANULADO = '5',
            LIQUIDADO = '6',
            RECHAZADO = '7',
            COTIZADO = '8',
            BUENA_PRO = '9';
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PatriMovimientoPK patriMovimientoPK;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
    @Column(name = "fecha_mov")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "fecha_retorno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRetorno;
    @Column(name = "retorno")
    private Character retorno;
    @Size(max = 8)
    @Column(name = "empl_origen")
    private String emplOrigen;
    @Size(max = 8)
    @Column(name = "empl_destino")
    private String emplDestino;
    @Size(max = 3)
    @Column(name = "local_origen")
    private String localOrigen;
    
    @Transient
    private ELocal origen;
    @Size(max = 3)
    @Column(name = "local_destino")
    private String localDestino;

    public ELocal getOrigen() {
        return origen;
    }

    public void setOrigen(ELocal origen) {
        this.origen = origen;
    }

    public ELocal getDestino() {
        return destino;
    }

    public void setDestino(ELocal destino) {
        this.destino = destino;
    }
    @Transient
    private ELocal destino;
    @Size(max = 70)
    @Column(name = "desc_destino")
    private String descDestino;
    @Size(max = 5)
    @Column(name = "area_origen")
    private String areaOrigen;
    @Size(max = 5)
    @Column(name = "area_destino")
    private String areaDestino;
    @Size(max = 5)
    @Column(name = "oficina_origen")
    private String oficinaOrigen;
    @Size(max = 5)
    @Column(name = "oficina_destino")
    private String oficinaDestino;
    @Size(max = 500)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "selec")
    private Character selec;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patriMovimiento")
    private List<PatriMovimientoDet> patriMovimientoDetCollection;

    public PatriMovimiento() {
    }

    public PatriMovimiento(PatriMovimientoPK patriMovimientoPK) {
        this.patriMovimientoPK = patriMovimientoPK;
    }

    public PatriMovimiento(String anoEje, Character tipoMov, String numMov) {
        this.patriMovimientoPK = new PatriMovimientoPK(anoEje, tipoMov, numMov);
    }

    public PatriMovimientoPK getPatriMovimientoPK() {
        return patriMovimientoPK;
    }

    public void setPatriMovimientoPK(PatriMovimientoPK patriMovimientoPK) {
        this.patriMovimientoPK = patriMovimientoPK;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public Character getRetorno() {
        return retorno;
    }

    public void setRetorno(Character retorno) {
        this.retorno = retorno;
    }

    public String getEmplOrigen() {
        return emplOrigen;
    }

    public void setEmplOrigen(String emplOrigen) {
        this.emplOrigen = emplOrigen;
    }

    public String getEmplDestino() {
        return emplDestino;
    }

    public void setEmplDestino(String emplDestino) {
        this.emplDestino = emplDestino;
    }

    public String getLocalOrigen() {
        return localOrigen;
    }

    public void setLocalOrigen(String localOrigen) {
        this.localOrigen = localOrigen;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public String getDescDestino() {
        return descDestino;
    }

    public void setDescDestino(String descDestino) {
        this.descDestino = descDestino;
    }

    public String getAreaOrigen() {
        return areaOrigen;
    }

    public void setAreaOrigen(String areaOrigen) {
        this.areaOrigen = areaOrigen;
    }

    public String getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(String areaDestino) {
        this.areaDestino = areaDestino;
    }

    public String getOficinaOrigen() {
        return oficinaOrigen;
    }

    public void setOficinaOrigen(String oficinaOrigen) {
        this.oficinaOrigen = oficinaOrigen;
    }

    public String getOficinaDestino() {
        return oficinaDestino;
    }

    public void setOficinaDestino(String oficinaDestino) {
        this.oficinaDestino = oficinaDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<PatriMovimientoDet> getPatriMovimientoDetCollection() {
        return patriMovimientoDetCollection;
    }

    public void setPatriMovimientoDetCollection(List<PatriMovimientoDet> patriMovimientoDetCollection) {
        this.patriMovimientoDetCollection = patriMovimientoDetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patriMovimientoPK != null ? patriMovimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatriMovimiento)) {
            return false;
        }
        PatriMovimiento other = (PatriMovimiento) object;
        if ((this.patriMovimientoPK == null && other.patriMovimientoPK != null) || (this.patriMovimientoPK != null && !this.patriMovimientoPK.equals(other.patriMovimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PatriMovimiento[ patriMovimientoPK=" + patriMovimientoPK + " ]";
    }
    
}
