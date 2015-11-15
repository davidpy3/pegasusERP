package edu.uns.oceda.carga_lectiva.jpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "crl_carga_lectiva_cab")
public class CargaLectivaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(table="sequence",pkColumnValue="id_clcab",pkColumnName="seq_name",valueColumnName="seq_count",
    name="id_clcab", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="id_clcab")
    @Basic(optional = false)
    @Column(name ="id_clcab", nullable = false)
    private Integer idClcab;
    @Basic(optional = false)
    @Column(name = "id_dcexp")
    private int idDcexp;
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Column(name = "id_dir")
    private Integer idDir;
    @Column(name = "horas")
    private Integer horas;
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "id_dedicacion")
    private Integer idDedicacion;
    @Basic(optional = false)
    @Column(name = "id_carglect")
    private int idCarglect;
    @Column(name = "total_horas")
    private Short totalHoras;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado=true;
    @Column(name = "orden")
    private Short orden;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    public CargaLectivaDocente() {
    }

    public CargaLectivaDocente(Integer idClcab) {
        this.idClcab = idClcab;
    }
    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }
    public CargaLectivaDocente(Integer idClcab, int idDcexp, int idCarglect, boolean estado, String tipo) {
        this.idClcab = idClcab;
        this.idDcexp = idDcexp;
        this.idCarglect = idCarglect;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Integer getIdClcab() {
        return idClcab;
    }

    public void setIdClcab(Integer idClcab) {
        this.idClcab = idClcab;
    }

    public int getIdDcexp() {
        return idDcexp;
    }

    public void setIdDcexp(int idDcexp) {
        this.idDcexp = idDcexp;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdDedicacion() {
        return idDedicacion;
    }

    public void setIdDedicacion(Integer idDedicacion) {
        this.idDedicacion = idDedicacion;
    }

    public int getIdCarglect() {
        return idCarglect;
    }

    public void setIdCarglect(int idCarglect) {
        this.idCarglect = idCarglect;
    }

    public Short getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Short totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClcab != null ? idClcab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargaLectivaDocente)) {
            return false;
        }
        CargaLectivaDocente other = (CargaLectivaDocente) object;
        if ((this.idClcab == null && other.idClcab != null) || (this.idClcab != null && !this.idClcab.equals(other.idClcab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.oceda.carga_lectiva.CargaLectivaDocente[idClcab=" + idClcab + "]";
    }

}
