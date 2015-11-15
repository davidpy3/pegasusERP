package edu.uns.escalafon.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "esc_estudios")
public class EscEstudio implements Serializable {

    @Column(name = "nro_matricula")
    private Integer nroMatricula;
    @JoinColumn(name = "id_inst", referencedColumnName = "id_inst")
    @ManyToOne(optional = false)
    private EscInstituciones escInstituciones;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private EscNivelEstudios idNivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escEstudio")
    private List<EscSuscdiploma> escSuscdiplomaList;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "mension")
    private String mension;
    @Basic(optional = false)
    @Column(name = "materia")
    private String materia;
    @Id
    @Basic(optional = false)
    @TableGenerator(table="sequence",pkColumnValue="id_estud",pkColumnName="seq_name",valueColumnName="seq_count",name="id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fecha_aprcu")
    @Temporal(TemporalType.DATE)
    private Date fechaAprcu;
    @Column(name = "nro_libro")
    private Integer nroLibro;
    @Column(name = "folio")
    private Integer folio;
    @Column(name = "nro_orden")
    private Integer nroOrden;
    @Column(name = "grado_abrev")
    private String gradoAbrev;

    public EscEstudio() {
    }

    public EscEstudio(Integer id) {
        this.id = id;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMension() {
        return mension;
    }

    public void setMension(String mension) {
        this.mension = mension;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public Date getFechaAprcu() {
        return fechaAprcu;
    }

    public void setFechaAprcu(Date fechaAprcu) {
        this.fechaAprcu = fechaAprcu;
    }

    public Integer getNroLibro() {
        return nroLibro;
    }

    public void setNroLibro(Integer nroLibro) {
        this.nroLibro = nroLibro;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Integer nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getGradoAbrev() {
        return gradoAbrev;
    }

    public void setGradoAbrev(String gradoAbrev) {
        this.gradoAbrev = gradoAbrev;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscEstudio)) {
            return false;
        }
        EscEstudio other = (EscEstudio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.ocper.trabajador.EscEstudios[id=" + id + "]";
    }


    public Integer getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(Integer nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public EscInstituciones getEscInstituciones() {
        return escInstituciones;
    }

    public void setEscInstituciones(EscInstituciones escInstituciones) {
        this.escInstituciones = escInstituciones;
    }

    public EscNivelEstudios getEscNivelEstudios() {
        return idNivel;
    }

    public void setEscNivelEstudios(EscNivelEstudios idNivel) {
        this.idNivel = idNivel;
    }

    @XmlTransient
    public List<EscSuscdiploma> getEscSuscdiplomaList() {
        return escSuscdiplomaList;
    }

    public void setEscSuscdiplomaList(List<EscSuscdiploma> escSuscdiplomaList) {
        this.escSuscdiplomaList = escSuscdiplomaList;
    }


}
