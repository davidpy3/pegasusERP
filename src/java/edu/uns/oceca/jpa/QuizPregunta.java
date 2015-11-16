package edu.uns.oceca.jpa;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Transient;

@Entity
@Table(name = "quiz_pregunta")
public class QuizPregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(table="sequence",pkColumnValue="id_pregunta",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_pregunta", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_pregunta")

    @Column(name = "id_pregunta", nullable = false)
    private Integer idPregunta;
    @Basic(optional = false)
    @Column(name = "id_cuestionario")
    private int idCuestionario;
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_catepre")
    @ManyToOne(optional = true)
    private QuizCategoria categoria;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
//    @OneToMany(fetch=FetchType.LAZY)
//    @JoinColumn(referencedColumnName="id_lista")
    @Transient
    private Collection<QuizOpcionLista> opcionListaCollection;

    public Collection<QuizOpcionLista> getOpcionListCollection() {
        return opcionListaCollection;
    }

    public void setOpcionListCollection(Collection<QuizOpcionLista> opcionListCollection) {
        this.opcionListaCollection = opcionListCollection;
    }

    public QuizCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(QuizCategoria categoria) {
        this.categoria = categoria;
    }

    @Basic(optional = false)
    @Column(name = "id_tipo_pregunta")
    private int idTipoPregunta;
    @Basic(optional = false)
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "id_lista")
    private Integer idLista;
    @Column(name = "id_respuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @Column(name = "opcional")
    private boolean opcional;
    @Basic(optional = false)
    @Column(name = "estado")
    private char estado;

    public QuizPregunta() {
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(int idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizPregunta)) {
            return false;
        }
        QuizPregunta other = (QuizPregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceca.sgc.QuizPregunta[idPregunta=" + idPregunta + "]";
    }

}
