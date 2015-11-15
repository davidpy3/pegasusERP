package edu.uns.oceda.plan_curricular.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "cur_plan_curricular")
//@NamedQueries({
//    @NamedQuery(name = "CurPlanCurricular.findAll", query = "SELECT c FROM CurPlanCurricular c"),
//    @NamedQuery(name = "CurPlanCurricular.findByIdPlancur", query = "SELECT c FROM CurPlanCurricular c WHERE c.idPlancur = :idPlancur"),
//    @NamedQuery(name = "CurPlanCurricular.findByIdAnio", query = "SELECT c FROM CurPlanCurricular c WHERE c.idAnio = :idAnio"),
//    @NamedQuery(name = "CurPlanCurricular.findByCodplancur", query = "SELECT c FROM CurPlanCurricular c WHERE c.codplancur = :codplancur"),
//    @NamedQuery(name = "CurPlanCurricular.findByCodplancurDesa", query = "SELECT c FROM CurPlanCurricular c WHERE c.codplancurDesa = :codplancurDesa"),
//    @NamedQuery(name = "CurPlanCurricular.findByDenominacion", query = "SELECT c FROM CurPlanCurricular c WHERE c.denominacion = :denominacion"),
//    @NamedQuery(name = "CurPlanCurricular.findByFecha", query = "SELECT c FROM CurPlanCurricular c WHERE c.fecha = :fecha"),
//    @NamedQuery(name = "CurPlanCurricular.findByEstado", query = "SELECT c FROM CurPlanCurricular c WHERE c.estado = :estado"),
//    @NamedQuery(name = "CurPlanCurricular.findByInsertDir", query = "SELECT c FROM CurPlanCurricular c WHERE c.insertDir = :insertDir"),
//    @NamedQuery(name = "CurPlanCurricular.findByInsertFecha", query = "SELECT c FROM CurPlanCurricular c WHERE c.insertFecha = :insertFecha"),
//    @NamedQuery(name = "CurPlanCurricular.findByUpdateDir", query = "SELECT c FROM CurPlanCurricular c WHERE c.updateDir = :updateDir"),
//    @NamedQuery(name = "CurPlanCurricular.findByUpdateFecha", query = "SELECT c FROM CurPlanCurricular c WHERE c.updateFecha = :updateFecha"),
//    @NamedQuery(name = "CurPlanCurricular.findByReferencia", query = "SELECT c FROM CurPlanCurricular c WHERE c.referencia = :referencia"),
//    @NamedQuery(name = "CurPlanCurricular.findByRglCredTotal", query = "SELECT c FROM CurPlanCurricular c WHERE c.rglCredTotal = :rglCredTotal"),
//    @NamedQuery(name = "CurPlanCurricular.findByRglCredCiclo", query = "SELECT c FROM CurPlanCurricular c WHERE c.rglCredCiclo = :rglCredCiclo"),
//    @NamedQuery(name = "CurPlanCurricular.findByMencion", query = "SELECT c FROM CurPlanCurricular c WHERE c.mencion = :mencion")})
public class CurPlanCurricular implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
    @Basic(optional = false)
    @Column(name = "id_plancur")
    @TableGenerator(name="CUR_PLANCUR", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CUR_PLANCUR")
    private Integer idPlancur;




    @Basic(optional = false)
    @Column(name = "id_anio")
    private short idAnio;
    @Basic(optional = false)
    @Column(name = "codplancur")
    private String codplancur;
    @Column(name = "codplancur_desa")
    private String codplancurDesa;

    public int getIdPlancondi() {
        return idPlancondi;
    }

    public void setIdPlancondi(int idPlancondi) {
        this.idPlancondi = idPlancondi;
    }




    @Column(name = "id_ambito")
    private int idAmbito;
    @Column(name = "id_especialidad")
    private int idEspecialidad;
    @Column(name = "id_plancondi")
    private int idPlancondi;

    public int getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(int idAmbito) {
        this.idAmbito = idAmbito;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }



    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Basic(optional = false)
    @Column(name = "insert_dir")
    private int insertDir;
    @Basic(optional = false)
    @Column(name = "insert_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertFecha;
    @Column(name = "update_dir")
    private Integer updateDir;
    @Column(name = "update_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateFecha;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "rgl_cred_total")
    private Integer rglCredTotal;
    @Column(name = "rgl_cred_ciclo")
    private Integer rglCredCiclo;
    @Column(name = "mencion")
    private String mencion;

        @Column(name = "id_planmoda")
    private Integer idPlanmoda;

    public Integer getIdPlanmoda() {
        return idPlanmoda;
    }

    public void setIdPlanmoda(Integer idPlanmoda) {
        this.idPlanmoda = idPlanmoda;
    }



    public CurPlanCurricular() {
    }

    public CurPlanCurricular(Integer idPlancur) {
        this.idPlancur = idPlancur;
    }

    public CurPlanCurricular(Integer idPlancur, short idAnio, String codplancur, short estado, int insertDir, Date insertFecha) {
        this.idPlancur = idPlancur;
        this.idAnio = idAnio;
        this.codplancur = codplancur;
        this.estado = estado;
        this.insertDir = insertDir;
        this.insertFecha = insertFecha;
    }

    public Integer getIdPlancur() {
        return idPlancur;
    }

    public void setIdPlancur(Integer idPlancur) {
        this.idPlancur = idPlancur;
    }

    public short getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(short idAnio) {
        this.idAnio = idAnio;
    }

    public String getCodplancur() {
        return codplancur;
    }

    public void setCodplancur(String codplancur) {
        this.codplancur = codplancur;
    }

    public String getCodplancurDesa() {
        return codplancurDesa;
    }

    public void setCodplancurDesa(String codplancurDesa) {
        this.codplancurDesa = codplancurDesa;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public int getInsertDir() {
        return insertDir;
    }

    public void setInsertDir(int insertDir) {
        this.insertDir = insertDir;
    }

    public Date getInsertFecha() {
        return insertFecha;
    }

    public void setInsertFecha(Date insertFecha) {
        this.insertFecha = insertFecha;
    }

    public Integer getUpdateDir() {
        return updateDir;
    }

    public void setUpdateDir(Integer updateDir) {
        this.updateDir = updateDir;
    }

    public Date getUpdateFecha() {
        return updateFecha;
    }

    public void setUpdateFecha(Date updateFecha) {
        this.updateFecha = updateFecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getRglCredTotal() {
        return rglCredTotal;
    }

    public void setRglCredTotal(Integer rglCredTotal) {
        this.rglCredTotal = rglCredTotal;
    }

    public Integer getRglCredCiclo() {
        return rglCredCiclo;
    }

    public void setRglCredCiclo(Integer rglCredCiclo) {
        this.rglCredCiclo = rglCredCiclo;
    }

    public String getMencion() {
        return mencion;
    }

    public void setMencion(String mencion) {
        this.mencion = mencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlancur != null ? idPlancur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurPlanCurricular)) {
            return false;
        }
        CurPlanCurricular other = (CurPlanCurricular) object;
        if ((this.idPlancur == null && other.idPlancur != null) || (this.idPlancur != null && !this.idPlancur.equals(other.idPlancur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.plan_curricular.CurPlanCurricular[idPlancur=" + idPlancur + "]";
    }

}
