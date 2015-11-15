/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByAnoEje", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.anoEje = :anoEje"),
    @NamedQuery(name = "Usuario.findByDni", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.dni = :dni"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByIDcargo", query = "SELECT u FROM Usuario u WHERE u.iDcargo = :iDcargo"),
    @NamedQuery(name = "Usuario.findByAnio", query = "SELECT u FROM Usuario u WHERE u.anio = :anio"),
    @NamedQuery(name = "Usuario.findByObra", query = "SELECT u FROM Usuario u WHERE u.obra = :obra"),
    @NamedQuery(name = "Usuario.findByActProy", query = "SELECT u FROM Usuario u WHERE u.actProy = :actProy"),
    @NamedQuery(name = "Usuario.findBySecFunc", query = "SELECT u FROM Usuario u WHERE u.secFunc = :secFunc"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByAutoriza", query = "SELECT u FROM Usuario u WHERE u.autoriza = :autoriza"),
    @NamedQuery(name = "Usuario.findByLocalHost", query = "SELECT u FROM Usuario u WHERE u.localHost = :localHost"),
    @NamedQuery(name = "Usuario.findByLocalIp", query = "SELECT u FROM Usuario u WHERE u.localIp = :localIp"),
    @NamedQuery(name = "Usuario.findByFecHora", query = "SELECT u FROM Usuario u WHERE u.fecHora = :fecHora"),
    @NamedQuery(name = "Usuario.findByVentana", query = "SELECT u FROM Usuario u WHERE u.ventana = :ventana"),
    @NamedQuery(name = "Usuario.findByPConfig", query = "SELECT u FROM Usuario u WHERE u.pConfig = :pConfig"),
    @NamedQuery(name = "Usuario.findByPPresu", query = "SELECT u FROM Usuario u WHERE u.pPresu = :pPresu"),
    @NamedQuery(name = "Usuario.findByPReque", query = "SELECT u FROM Usuario u WHERE u.pReque = :pReque"),
    @NamedQuery(name = "Usuario.findByPAltad", query = "SELECT u FROM Usuario u WHERE u.pAltad = :pAltad"),
    @NamedQuery(name = "Usuario.findByPAbast", query = "SELECT u FROM Usuario u WHERE u.pAbast = :pAbast"),
    @NamedQuery(name = "Usuario.findByPAdqui", query = "SELECT u FROM Usuario u WHERE u.pAdqui = :pAdqui"),
    @NamedQuery(name = "Usuario.findByPAlmac", query = "SELECT u FROM Usuario u WHERE u.pAlmac = :pAlmac"),
    @NamedQuery(name = "Usuario.findByPPerso", query = "SELECT u FROM Usuario u WHERE u.pPerso = :pPerso"),
    @NamedQuery(name = "Usuario.findByPPaac", query = "SELECT u FROM Usuario u WHERE u.pPaac = :pPaac"),
    @NamedQuery(name = "Usuario.findByPConta", query = "SELECT u FROM Usuario u WHERE u.pConta = :pConta"),
    @NamedQuery(name = "Usuario.findByPPatri", query = "SELECT u FROM Usuario u WHERE u.pPatri = :pPatri")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 20)
    @Column(name = "clave")
    private String clave;
    @Column(name = "ID_cargo")
    private Integer iDcargo;
    @Size(max = 4)
    @Column(name = "anio")
    private String anio;
    @Column(name = "obra")
    private Boolean obra;
    @Size(max = 7)
    @Column(name = "act_proy")
    private String actProy;
    @Size(max = 4)
    @Column(name = "sec_func")
    private String secFunc;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "autoriza")
    private Character autoriza;
    @Size(max = 50)
    @Column(name = "local_host")
    private String localHost;
    @Size(max = 15)
    @Column(name = "local_ip")
    private String localIp;
    @Column(name = "fec_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHora;
    @Size(max = 50)
    @Column(name = "ventana")
    private String ventana;
    @Column(name = "p_config")
    private Character pConfig;
    @Column(name = "p_presu")
    private Character pPresu;
    @Column(name = "p_reque")
    private Character pReque;
    @Column(name = "p_altad")
    private Character pAltad;
    @Column(name = "p_abast")
    private Character pAbast;
    @Column(name = "p_adqui")
    private Character pAdqui;
    @Column(name = "p_almac")
    private Character pAlmac;
    @Column(name = "p_perso")
    private Character pPerso;
    @Column(name = "p_paac")
    private Character pPaac;
    @Column(name = "p_conta")
    private Character pConta;
    @Column(name = "p_patri")
    private Character pPatri;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(UsuarioPK usuarioPK, String usuario) {
        this.usuarioPK = usuarioPK;
        this.usuario = usuario;
    }

    public Usuario(String anoEje, String dni) {
        this.usuarioPK = new UsuarioPK(anoEje, dni);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getIDcargo() {
        return iDcargo;
    }

    public void setIDcargo(Integer iDcargo) {
        this.iDcargo = iDcargo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Boolean getObra() {
        return obra;
    }

    public void setObra(Boolean obra) {
        this.obra = obra;
    }

    public String getActProy() {
        return actProy;
    }

    public void setActProy(String actProy) {
        this.actProy = actProy;
    }

    public String getSecFunc() {
        return secFunc;
    }

    public void setSecFunc(String secFunc) {
        this.secFunc = secFunc;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Character getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Character autoriza) {
        this.autoriza = autoriza;
    }

    public String getLocalHost() {
        return localHost;
    }

    public void setLocalHost(String localHost) {
        this.localHost = localHost;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public Date getFecHora() {
        return fecHora;
    }

    public void setFecHora(Date fecHora) {
        this.fecHora = fecHora;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }

    public Character getPConfig() {
        return pConfig;
    }

    public void setPConfig(Character pConfig) {
        this.pConfig = pConfig;
    }

    public Character getPPresu() {
        return pPresu;
    }

    public void setPPresu(Character pPresu) {
        this.pPresu = pPresu;
    }

    public Character getPReque() {
        return pReque;
    }

    public void setPReque(Character pReque) {
        this.pReque = pReque;
    }

    public Character getPAltad() {
        return pAltad;
    }

    public void setPAltad(Character pAltad) {
        this.pAltad = pAltad;
    }

    public Character getPAbast() {
        return pAbast;
    }

    public void setPAbast(Character pAbast) {
        this.pAbast = pAbast;
    }

    public Character getPAdqui() {
        return pAdqui;
    }

    public void setPAdqui(Character pAdqui) {
        this.pAdqui = pAdqui;
    }

    public Character getPAlmac() {
        return pAlmac;
    }

    public void setPAlmac(Character pAlmac) {
        this.pAlmac = pAlmac;
    }

    public Character getPPerso() {
        return pPerso;
    }

    public void setPPerso(Character pPerso) {
        this.pPerso = pPerso;
    }

    public Character getPPaac() {
        return pPaac;
    }

    public void setPPaac(Character pPaac) {
        this.pPaac = pPaac;
    }

    public Character getPConta() {
        return pConta;
    }

    public void setPConta(Character pConta) {
        this.pConta = pConta;
    }

    public Character getPPatri() {
        return pPatri;
    }

    public void setPPatri(Character pPatri) {
        this.pPatri = pPatri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
