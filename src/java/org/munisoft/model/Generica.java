/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "generica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generica.findAll", query = "SELECT g FROM Generica g"),
    @NamedQuery(name = "Generica.findByAnoEje", query = "SELECT g FROM Generica g WHERE g.genericaPK.anoEje = :anoEje"),
    @NamedQuery(name = "Generica.findByTipoTransaccion", query = "SELECT g FROM Generica g WHERE g.genericaPK.tipoTransaccion = :tipoTransaccion"),
    @NamedQuery(name = "Generica.findByGenerica", query = "SELECT g FROM Generica g WHERE g.genericaPK.generica = :generica"),
    @NamedQuery(name = "Generica.findByDescripcion", query = "SELECT g FROM Generica g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Generica.findByIdGrupoClasificador", query = "SELECT g FROM Generica g WHERE g.idGrupoClasificador = :idGrupoClasificador"),
    @NamedQuery(name = "Generica.findByAmbito", query = "SELECT g FROM Generica g WHERE g.ambito = :ambito"),
    @NamedQuery(name = "Generica.findByEstado", query = "SELECT g FROM Generica g WHERE g.estado = :estado")})
public class Generica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenericaPK genericaPK;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "id_grupo_clasificador")
    private String idGrupoClasificador;
    @Column(name = "ambito")
    private Character ambito;
    @Column(name = "estado")
    private Character estado;
    @JoinColumns({
        @JoinColumn(name = "ano_eje", referencedColumnName = "ano_eje", insertable = false, updatable = false),
        @JoinColumn(name = "tipo_transaccion", referencedColumnName = "tipo_transaccion", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TipoTransaccion tipoTransaccion1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generica1")
    private Collection<SubGenerica> subGenericaCollection;

    public Generica() {
    }

    public Generica(GenericaPK genericaPK) {
        this.genericaPK = genericaPK;
    }

    public Generica(GenericaPK genericaPK, String idGrupoClasificador) {
        this.genericaPK = genericaPK;
        this.idGrupoClasificador = idGrupoClasificador;
    }

    public Generica(String anoEje, Character tipoTransaccion, String generica) {
        this.genericaPK = new GenericaPK(anoEje, tipoTransaccion, generica);
    }

    public GenericaPK getGenericaPK() {
        return genericaPK;
    }

    public void setGenericaPK(GenericaPK genericaPK) {
        this.genericaPK = genericaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdGrupoClasificador() {
        return idGrupoClasificador;
    }

    public void setIdGrupoClasificador(String idGrupoClasificador) {
        this.idGrupoClasificador = idGrupoClasificador;
    }

    public Character getAmbito() {
        return ambito;
    }

    public void setAmbito(Character ambito) {
        this.ambito = ambito;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public TipoTransaccion getTipoTransaccion1() {
        return tipoTransaccion1;
    }

    public void setTipoTransaccion1(TipoTransaccion tipoTransaccion1) {
        this.tipoTransaccion1 = tipoTransaccion1;
    }

    @XmlTransient
    public Collection<SubGenerica> getSubGenericaCollection() {
        return subGenericaCollection;
    }

    public void setSubGenericaCollection(Collection<SubGenerica> subGenericaCollection) {
        this.subGenericaCollection = subGenericaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genericaPK != null ? genericaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generica)) {
            return false;
        }
        Generica other = (Generica) object;
        if ((this.genericaPK == null && other.genericaPK != null) || (this.genericaPK != null && !this.genericaPK.equals(other.genericaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Generica[ genericaPK=" + genericaPK + " ]";
    }
    
}
