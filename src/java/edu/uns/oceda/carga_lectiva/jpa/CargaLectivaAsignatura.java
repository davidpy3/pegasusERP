package edu.uns.oceda.carga_lectiva.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "crl_carga_lectiva_det")
public class CargaLectivaAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;

    
        @Id
    @TableGenerator(table="sequence",pkColumnValue="id_cldet",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_cldet", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_cldet")
    @Basic(optional = false)
    @Column(name ="id_cldet", nullable = false)
    private Integer idCldet;
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private int idAsignatura;
    @Column(name = "id_clcab")
    private Integer idClcab;
    @Column(name = "id_cldet_dep")
    private Integer idCldetDep;
    @Column(name = "id_tcl")
    private Short idTcl;
    @Column(name = "cod_prioridad")
    private Integer codPrioridad;
    @Basic(optional = false)
    @Column(name = "nro_alum")
    private short nroAlum;
    @Basic(optional = false)
    @Column(name = "grupt_teor")
    private short gruptTeor;
    @Basic(optional = false)
    @Column(name = "grupt_prac")
    private short gruptPrac;
    @Basic(optional = false)
    @Column(name = "grup_teor")
    private short grupTeor;
    @Column(name = "grupo_t")
    private String grupoT;
    @Basic(optional = false)
    @Column(name = "grup_prac")
    private short grupPrac;
    @Column(name = "grupo_p")
    private String grupoP;
    @Column(name = "hor_teor")
    private Short horTeor;
    @Column(name = "hor_prac")
    private Short horPrac;
    @Column(name = "subtotal")
    private Short subtotal;
    @Basic(optional = false)
    @Column(name = "est_encarg")
    private boolean estEncarg;
    @Basic(optional = false)
    @Column(name = "est_asigna")
    private boolean estAsigna;
    @Basic(optional = false)
    @Column(name = "est_compartido")
    private boolean estCompartido;
    @Column(name = "tip_comp")
    private String tipComp;
    @Column(name = "tip_enca")
    private String tipEnca;
    @Column(name = "ht")
    private Short ht;
    @Column(name = "hp")
    private Short hp;
    @Column(name = "asig_compartidas")
    private String asigCompartidas;
    @Basic(optional = false)
    @Column(name = "uso")
    private boolean uso=true;
    @Column(name = "id_esp")
    private Integer idEsp;
    @Column(name = "est_exception")
    private Integer estException;
    @Basic(optional = false)
    @Column(name = "id_estado")
    private String id_estado="R";
    @Basic(optional = false)
    @Column(name = "original")
    private boolean original;

    public CargaLectivaAsignatura() {
    }

    public Integer getIdCldet() {
        return idCldet;
    }

    public void setIdCldet(Integer idCldet) {
        this.idCldet = idCldet;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdClcab() {
        return idClcab;
    }

    public void setIdClcab(Integer idClcab) {
        this.idClcab = idClcab;
    }

    public Integer getIdCldetDep() {
        return idCldetDep;
    }

    public void setIdCldetDep(Integer idCldetDep) {
        this.idCldetDep = idCldetDep;
    }

    public Short getIdTcl() {
        return idTcl;
    }

    public void setIdTcl(Short idTcl) {
        this.idTcl = idTcl;
    }

    public Integer getCodPrioridad() {
        return codPrioridad;
    }

    public void setCodPrioridad(Integer codPrioridad) {
        this.codPrioridad = codPrioridad;
    }

    public short getNroAlum() {
        return nroAlum;
    }

    public void setNroAlum(short nroAlum) {
        this.nroAlum = nroAlum;
    }

    public short getGruptTeor() {
        return gruptTeor;
    }

    public void setGruptTeor(short gruptTeor) {
        this.gruptTeor = gruptTeor;
    }

    public short getGruptPrac() {
        return gruptPrac;
    }

    public void setGruptPrac(short gruptPrac) {
        this.gruptPrac = gruptPrac;
    }

    public short getGrupTeor() {
        return grupTeor;
    }

    public void setGrupTeor(short grupTeor) {
        this.grupTeor = grupTeor;
    }

    public String getGrupoT() {
        return grupoT;
    }

    public void setGrupoT(String grupoT) {
        this.grupoT = grupoT;
    }

    public short getGrupPrac() {
        return grupPrac;
    }

    public void setGrupPrac(short grupPrac) {
        this.grupPrac = grupPrac;
    }

    public String getGrupoP() {
        return grupoP;
    }

    public void setGrupoP(String grupoP) {
        this.grupoP = grupoP;
    }

    public Short getHorTeor() {
        return horTeor;
    }

    public void setHorTeor(Short horTeor) {
        this.horTeor = horTeor;
    }

    public Short getHorPrac() {
        return horPrac;
    }

    public void setHorPrac(Short horPrac) {
        this.horPrac = horPrac;
    }

    public Short getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Short subtotal) {
        this.subtotal = subtotal;
    }

    public boolean getEstEncarg() {
        return estEncarg;
    }

    public void setEstEncarg(boolean estEncarg) {
        this.estEncarg = estEncarg;
    }

    public boolean getEstAsigna() {
        return estAsigna;
    }

    public void setEstAsigna(boolean estAsigna) {
        this.estAsigna = estAsigna;
    }

    public boolean getEstCompartido() {
        return estCompartido;
    }

    public void setEstCompartido(boolean estCompartido) {
        this.estCompartido = estCompartido;
    }

    public String getTipComp() {
        return tipComp;
    }

    public void setTipComp(String tipComp) {
        this.tipComp = tipComp;
    }

    public String getTipEnca() {
        return tipEnca;
    }

    public void setTipEnca(String tipEnca) {
        this.tipEnca = tipEnca;
    }

    public Short getHt() {
        return ht;
    }

    public void setHt(Short ht) {
        this.ht = ht;
    }

    public Short getHp() {
        return hp;
    }

    public void setHp(Short hp) {
        this.hp = hp;
    }

    public String getAsigCompartidas() {
        return asigCompartidas;
    }

    public void setAsigCompartidas(String asigCompartidas) {
        this.asigCompartidas = asigCompartidas;
    }

    public boolean getUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

    public Integer getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(Integer idEsp) {
        this.idEsp = idEsp;
    }

    public Integer getEstException() {
        return estException;
    }

    public void setEstException(Integer estException) {
        this.estException = estException;
    }

    public String getIdEstado(){
        return id_estado;
    }

    public void setIdEstado(String estado) {
        this.id_estado=estado;
    }

    public boolean getOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCldet != null ? idCldet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargaLectivaAsignatura)) {
            return false;
        }
        CargaLectivaAsignatura other = (CargaLectivaAsignatura) object;
        if ((this.idCldet == null && other.idCldet != null) || (this.idCldet != null && !this.idCldet.equals(other.idCldet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.carga_lectiva.CargaLectivaAsignatura[ idCldet=" + idCldet + " ]";
    }
    
}
