package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name = "quiz_categoria_pregunta")
public class QuizCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(table="sequence",pkColumnValue="id_catepre",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_catepre", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_catepre")

    @Basic(optional = false)
    @Column(name = "id_catepre")
    private Integer idCategoria;
    @Column(name = "id_cuestionario")
    private Integer id_cuestionario;
    @Column(name = "numero")
    private Integer numero=0;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Transient
    private List<QuizPregunta> preguntaCollection;

    public List<QuizPregunta> getPreguntaCollection() {
        return preguntaCollection;
    }

    public void setPreguntaCollection(List<QuizPregunta> preguntaCollection) {
        this.preguntaCollection = preguntaCollection;
    }
    
    public QuizCategoria() {
    }

    public QuizCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public QuizCategoria(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Integer getIdCuestionario() {
        return id_cuestionario;
    }

    public void setIdCuestionario(Integer id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }
    
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizCategoria)) {
            return false;
        }
        QuizCategoria other = (QuizCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceca.sgc.QuizCategoriaPregunta[idCategoria=" + idCategoria + "]";
    }

}
