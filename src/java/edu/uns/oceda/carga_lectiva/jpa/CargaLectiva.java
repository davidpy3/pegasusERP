package edu.uns.oceda.carga_lectiva.jpa;

import edu.uns.oceda.jpa.ApcPeriodoAcademico;
import edu.uns.oceda.jpa.ApsDepartamento;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "crl_carga_lectiva")
public class CargaLectiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(table="sequence",pkColumnValue="id_carglect",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_carglect", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_carglect")
    @Column(name = "id_carglect")
    private Integer idCarglect;

    @Column(name = "id_dtra")
    private Integer idDtra;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private ApsDepartamento apsDepartamento;
    
    @JoinColumn(name = "id_acper", referencedColumnName = "id_acper")
    @ManyToOne(optional = false)
    private ApcPeriodoAcademico apcPeriodoAcademico;

    public ApcPeriodoAcademico getApcPeriodoAcademico() {
        return apcPeriodoAcademico;
    }

    public void setApcPeriodoAcademico(ApcPeriodoAcademico apcPeriodoAcademico) {
        this.apcPeriodoAcademico = apcPeriodoAcademico;
    }
    
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private String idTipo;

    public ApsDepartamento getApsDepartamento() {
        return apsDepartamento;
    }

    public void setApsDepartamento(ApsDepartamento apsDepartamento) {
        this.apsDepartamento = apsDepartamento;
    }
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "consolidado")
    private boolean consolidado;
    @Column(name = "id_dir")
    private Integer uid;

    public CargaLectiva() {
    }

    public CargaLectiva(Integer idCarglect) {
        this.idCarglect = idCarglect;
    }

    public Integer getIdCarglect() {
        return idCarglect;
    }

    public void setIdCarglect(Integer idCarglect) {
        this.idCarglect = idCarglect;
    }

    public Integer getIdDtra() {
        return idDtra;
    }

    public void setIdDtra(Integer idDtra) {
        this.idDtra = idDtra;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getConsolidado() {
        return consolidado;
    }

    public void setConsolidado(boolean consolidado) {
        this.consolidado = consolidado;
    }

    public Integer getIdDir(){
        return uid;
    }

    public void setIdDir(Integer uid){
        this.uid = uid;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += (idCarglect != null ? idCarglect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargaLectiva)) {
            return false;
        }
        CargaLectiva other = (CargaLectiva) object;
        if ((this.idCarglect == null && other.idCarglect != null) || (this.idCarglect != null && !this.idCarglect.equals(other.idCarglect))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.CargaLectiva[idCarglect=" + idCarglect + "]";
    }

}
