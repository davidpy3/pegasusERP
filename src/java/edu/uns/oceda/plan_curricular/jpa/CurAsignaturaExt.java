package edu.uns.oceda.plan_curricular.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "cur_asignatura_ext")
public class CurAsignaturaExt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private Integer idAsignatura;
    @Lob
    @Column(name = "competencia")
    private String competencia;
    @Lob
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "escolaridad")
    private String escolaridad;

    public CurAsignaturaExt() {
    }

    public CurAsignaturaExt(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridadDocente) {
        this.escolaridad = escolaridadDocente;
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
        if (!(object instanceof CurAsignaturaExt)) {
            return false;
        }
        CurAsignaturaExt other = (CurAsignaturaExt) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.plan_curricular.CurAsignaturaExt[idAsignatura=" + idAsignatura + "]";
    }

}
