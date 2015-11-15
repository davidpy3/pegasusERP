package org.pegasus.personal.jpa;

import org.pegasus.personal.jpa.TipoPlanilla;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.pegasus.patrimonio.jpa.Entidad;
import org.pegasus.patrimonio.jpa.Mes;
import org.pegasus.patrimonio.jpa.Meta;
import org.pegasus.patrimonio.jpa.Sector;

@Entity
@Table(name = "planilla")
public class Planilla implements Serializable {
    public static int PLANILLA_TRABAJADORES=0;
    public static int HOJA_TAREO=1;
    
    public String getKey(){
        return this.getPlanillaPK()!=null?this.getPlanillaPK().getAnoEje()+"-"+this.getPlanillaPK().getNExpediente():null;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planilla")
    private Collection<PlanillaTrab> planillaTrabCollection;
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanillaPK planillaPK;
    @Size(max = 8)
    @Column(name = "n_planilla")
    private String nPlanilla;
    
    @JoinColumn(name = "entidad", referencedColumnName = "cod_sect")
    @ManyToOne
    private Sector sector;
    
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    
    @Size(max = 6)
    @Column(name = "sec_func")
    private String secFunc;
    @JoinColumns({
        @JoinColumn(name = "sec_func", referencedColumnName = "sec_func",insertable=false,updatable=false),
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje",insertable=false,updatable=false)})
    @ManyToOne
    
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
    @Size(max = 2)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;
    @Size(max = 2)
    @Column(name = "tipo_trab")
    private String tipoTrab;

    public ModalidadLaboral getModalidadLaboral() {
        return modalidadLaboral;
    }

    public void setModalidadLaboral(ModalidadLaboral modalidadLaboral) {
        this.modalidadLaboral = modalidadLaboral;
    }
    
    @JoinColumn(name = "mod_laboral", referencedColumnName = "mod_laboral")
    @ManyToOne
    private ModalidadLaboral modalidadLaboral;
    
    @Size(max = 300)
    @Column(name = "trabajos")
    private String trabajos;
    @Column(name = "fecha_exp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExp;
    @Column(name = "fecha_plan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPlan;
    @Column(name = "periodo_ini")
    @Temporal(TemporalType.DATE)
    private Date periodoIni;
    @Column(name = "periodo_fin")
    @Temporal(TemporalType.DATE)
    private Date periodoFin;
    @Size(max = 8)
    @Column(name = "elaborado_por")
    private String elaboradoPor;
    @Size(max = 8)
    @Column(name = "tareado_por")
    private String tareadoPor;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "selec")
    private Character selec;
    @JoinColumn(name = "mes", referencedColumnName = "mes_eje")
    @ManyToOne
    private Mes mes;
    @JoinColumn(name = "tipo_planilla", referencedColumnName = "tipo_planilla")
    @ManyToOne
    private TipoPlanilla tipoPlanilla;

    public Planilla() {
    }

    public Planilla(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public Planilla(String nExpediente, String anoEje) {
        this.planillaPK = new PlanillaPK(nExpediente, anoEje);
    }

    public PlanillaPK getPlanillaPK() {
        return planillaPK;
    }

    public void setPlanillaPK(PlanillaPK planillaPK) {
        this.planillaPK = planillaPK;
    }

    public String getNPlanilla() {
        return nPlanilla;
    }

    public void setNPlanilla(String nPlanilla) {
        this.nPlanilla = nPlanilla;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(String trabajos) {
        this.trabajos = trabajos;
    }

    public Date getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(Date fechaExp) {
        this.fechaExp = fechaExp;
    }

    public Date getFechaPlan() {
        return fechaPlan;
    }

    public void setFechaPlan(Date fechaPlan) {
        this.fechaPlan = fechaPlan;
    }

    public Date getPeriodoIni() {
        return periodoIni;
    }

    public void setPeriodoIni(Date periodoIni) {
        this.periodoIni = periodoIni;
    }

    public Date getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Date periodoFin) {
        this.periodoFin = periodoFin;
    }

    public String getElaboradoPor() {
        return elaboradoPor;
    }

    public void setElaboradoPor(String elaboradoPor) {
        this.elaboradoPor = elaboradoPor;
    }

    public String getTareadoPor() {
        return tareadoPor;
    }

    public void setTareadoPor(String tareadoPor) {
        this.tareadoPor = tareadoPor;
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

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

    public TipoPlanilla getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(TipoPlanilla tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planillaPK != null ? planillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.planillaPK == null && other.planillaPK != null) || (this.planillaPK != null && !this.planillaPK.equals(other.planillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Planilla[ planillaPK=" + planillaPK + " ]";
    }

    @XmlTransient
    public Collection<PlanillaTrab> getPlanillaTrabCollection() {
        return planillaTrabCollection;
    }

    public void setPlanillaTrabCollection(Collection<PlanillaTrab> planillaTrabCollection) {
        this.planillaTrabCollection = planillaTrabCollection;
    }
    
}
