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
@Table(name = "cur_asignatura")
public class CurAsignatura implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    @TableGenerator(name="CUR_ASIGNAT", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CUR_ASIGNAT")
    
    
    
    
    
    
    
    
    
    
    private Integer idAsignatura;

    @Basic(optional = false)
    @Column(name = "id_ciclo")
    private short idCiclo;

    public short getIdCiclo(){
        return idCiclo;
    }

    public void setIdCiclo(short idCiclo){
        this.idCiclo = idCiclo;
    }
    
    @Basic(optional = false)
    @Column(name = "id_ambito")
    private short idAmbito;
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;
    @Column(name = "codasig")
    private String codasig;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "abrevia")
    private String abrevia;
    @Basic(optional = false)
    @Column(name = "creditaje")
    private short creditaje;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Column(name = "ht")
    private Short ht;
    @Column(name = "hp")
    private Short hp;
    @Column(name = "caracter")
    private Short caracter;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "insert_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertFecha;
    @Column(name = "insert_dir")
    private Integer insertDir;
    @Column(name = "update_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateFecha;
    @Column(name = "update_dir")
    private Integer updateDir;
    @Column(name = "codasig_format")
    private String codasigFormat;
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Column(name = "min_creditos")
    private Short minCreditos;
    @Column(name = "id_asigarea")
    private int idAsigarea;
    @Column(name = "id_asigtipo")
    private int idAsigtipo;


    @Column(name = "id_plancur")
    private int idPlancur;

    public int getIdPlancur() {
        return idPlancur;
    }

    public void setIdPlancur(int idPlancur) {
        this.idPlancur = idPlancur;
    }
    public int getIdAsigarea() {
        return idAsigarea;
    }

    public void setIdAsigarea(int idAsigarea) {
        this.idAsigarea = idAsigarea;
    }

    public int getIdAsigtipo() {
        return idAsigtipo;
    }

    public void setIdAsigtipo(int idAsigtipo) {
        this.idAsigtipo = idAsigtipo;
    }



    public CurAsignatura() {
    }

    public CurAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public CurAsignatura(Integer idAsignatura, short idAmbito, String nombre, short creditaje, short estado) {
        this.idAsignatura = idAsignatura;
        this.idAmbito = idAmbito;
        this.nombre = nombre;
        this.creditaje = creditaje;
        this.estado = estado;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public short getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(short idAmbito) {
        this.idAmbito = idAmbito;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCodasig() {
        return codasig;
    }

    public void setCodasig(String codasig) {
        this.codasig = codasig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrevia() {
        return abrevia;
    }

    public void setAbrevia(String abrevia) {
        this.abrevia = abrevia;
    }

    public short getCreditaje() {
        return creditaje;
    }

    public void setCreditaje(short creditaje) {
        this.creditaje = creditaje;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
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

    public Short getCaracter() {
        return caracter;
    }

    public void setCaracter(Short caracter) {
        this.caracter = caracter;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getInsertFecha() {
        return insertFecha;
    }

    public void setInsertFecha(Date insertFecha) {
        this.insertFecha = insertFecha;
    }

    public Integer getInsertDir() {
        return insertDir;
    }

    public void setInsertDir(Integer insertDir) {
        this.insertDir = insertDir;
    }

    public Date getUpdateFecha() {
        return updateFecha;
    }

    public void setUpdateFecha(Date updateFecha) {
        this.updateFecha = updateFecha;
    }

    public Integer getUpdateDir() {
        return updateDir;
    }

    public void setUpdateDir(Integer updateDir) {
        this.updateDir = updateDir;
    }

    public String getCodasigFormat() {
        return codasigFormat;
    }

    public void setCodasigFormat(String codasigFormat) {
        this.codasigFormat = codasigFormat;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Short getMinCreditos() {
        return minCreditos;
    }

    public void setMinCreditos(Short minCreditos) {
        this.minCreditos = minCreditos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurAsignatura)) {
            return false;
        }
        CurAsignatura other = (CurAsignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.plan_curricular.CurAsignatura[idAsignatura=" + idAsignatura + "]";
    }

}
