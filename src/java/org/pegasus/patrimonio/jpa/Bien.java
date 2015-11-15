package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mbienes0")
public class Bien implements Serializable {

    public int getVidaUtil(){
        return (int)(100.0/this.getCuentac().getProcentDepre().doubleValue());
    }
    
    public Date getFechaVenc(){
        Calendar c=Calendar.getInstance();
        c.setTime(this.getFecReg());
        c.add(Calendar.YEAR,getVidaUtil());
        return c.getTime();
    }

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BienPK BienPK;
    @Column(name = "clasifica")
    private Character clasifica;
    @Size(max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Size(max = 5)
    @Column(name = "codarea")
    private String codarea;
    @Size(max = 5)
    @Column(name = "codoficina")
    private String codoficina;
    @Size(max = 5)
    @Column(name = "codambiente")
    private String codambiente;
    @Size(max = 15)
    @Column(name = "codanterior")
    private String codanterior;
    @Size(max = 8)
    @Column(name = "codusuario")
    private String codusuario;
    @Column(name = "tipo_cta")
    private Character tipoCta;
    @Size(max = 11)
    @Column(name = "cuenta")
    private String cuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorlibro")
    private BigDecimal valorlibro;
    @Column(name = "valortasa")
    private BigDecimal valortasa;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 15)
    @Column(name = "marca")
    private String marca;
    @Size(max = 15)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 15)
    @Column(name = "color")
    private String color;
    @Size(max = 20)
    @Column(name = "serie")
    private String serie;
    @Size(max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 50)
    @Column(name = "edicion")
    private String edicion;
    @Size(max = 100)
    @Column(name = "autor")
    private String autor;
    @Size(max = 100)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 50)
    @Column(name = "product_key")
    private String productKey;
    @Column(name = "vigencia_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaDesde;
    @Column(name = "vigencia_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenciaHasta;
    @Size(max = 20)
    @Column(name = "nummotor")
    private String nummotor;
    @Size(max = 20)
    @Column(name = "numchasis")
    private String numchasis;
    @Size(max = 4)
    @Column(name = "a\u00f1o")
    private String año;
    @Size(max = 15)
    @Column(name = "dimension")
    private String dimension;
    @Size(max = 15)
    @Column(name = "raza")
    private String raza;
    @Size(max = 15)
    @Column(name = "especie")
    private String especie;
    @Size(max = 500)
    @Column(name = "otros")
    private String otros;
    @Column(name = "fec_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReg;
    @Size(max = 10)
    @Column(name = "placa")
    private String placa;
    @Size(max = 5)
    @Column(name = "edad")
    private String edad;
    @Size(max = 15)
    @Column(name = "pais")
    private String pais;
    @Column(name = "condicion")
    private Character condicion;
    @Column(name = "fec_act")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAct;
    @Column(name = "asegurado")
    private Character asegurado;
    @Column(name = "est_bien")
    private Character estBien;
    @Column(name = "flg_causal")
    private Character flgCausal;
    @Size(max = 25)
    @Column(name = "resol_baja")
    private String resolBaja;
    @Column(name = "fec_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecBaja;
    @Size(max = 8)
    @Column(name = "user_baja")
    private String userBaja;
    @Column(name = "flg_acto")
    private Character flgActo;
    @Size(max = 25)
    @Column(name = "resol_disp")
    private String resolDisp;
    @Column(name = "fec_disp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDisp;
    @Size(max = 50)
    @Column(name = "causal_elim")
    private String causalElim;
    @Column(name = "fecha_elim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaElim;
    @Size(max = 8)
    @Column(name = "user_elim")
    private String userElim;
    @Column(name = "est_gestion")
    private Character estGestion;
    @Size(max = 25)
    @Column(name = "resol_afec")
    private String resolAfec;
    @Column(name = "fec_afec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAfec;
    @Column(name = "fec_vafec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVafec;
    @Size(max = 100)
    @Column(name = "ent_afec")
    private String entAfec;
    @Size(max = 25)
    @Column(name = "resol_arre")
    private String resolArre;
    @Column(name = "fec_arre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecArre;
    @Column(name = "fec_varre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVarre;
    @Size(max = 100)
    @Column(name = "ent_arre")
    private String entArre;
    @Size(max = 25)
    @Column(name = "doc_alta")
    private String docAlta;
    @Size(max = 8)
    @Column(name = "user_alta")
    private String userAlta;
    @Size(max = 25)
    @Column(name = "doc_baja")
    private String docBaja;
    @Column(name = "flg_estado")
    private Character flgEstado;
    @Column(name = "selec")
    private Character selec;
    @Column(name = "sbn")
    private Character sbn;
    @Size(max = 4)
    @Column(name = "ano_orden")
    private String anoOrden;
    @Column(name = "n_orden")
    private Integer nOrden;
    @Column(name = "tipo_orden")
    private Character tipoOrden;
    @Size(max = 5)
    @Column(name = "funcionario")
    private String funcionario;
    @Column(name = "srp")
    private Character srp;
    @Column(name = "tasado")
    private Character tasado;
    @Size(max = 11)
    @Column(name = "n_notacargo")
    private String nNotacargo;
    @Size(max = 12)
    @Column(name = "cod_padre")
    private String codPadre;
    @Size(max = 12)
    @Column(name = "cod_madre")
    private String codMadre;
    @Column(name = "sit_binv")
    private Character sitBinv;
    @Column(name = "valoradq")
    private BigDecimal valoradq;
    @Size(max = 100)
    @Column(name = "ent_disp")
    private String entDisp;
    @Size(max = 25)
    @Column(name = "matricula")
    private String matricula;
    @Size(max = 9)
    @Column(name = "anho_fab")
    private String anhoFab;
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Column(name = "altura")
    private BigDecimal altura;
    @Column(name = "ancho")
    private BigDecimal ancho;
    @Size(max = 8)
    @Column(name = "codbien_aux")
    private String codbienAux;
    @Size(max = 4)
    @Column(name = "correla_aux")
    private String correlaAux;
    @JoinColumn(name = "codbien", referencedColumnName = "codbien", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoBien tipoBien;
    @JoinColumn(name = "cuenta", referencedColumnName = "cuenta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuentac cuentac;

    public Cuentac getCuentac() {
        return cuentac;
    }

    public void setCuentac(Cuentac cuentac) {
        this.cuentac = cuentac;
    }

    public Bien() {
    }

    public Bien(BienPK bienPK) {
        this.BienPK = bienPK;
    }

    public Bien(String codbien, String correla) {
        this.BienPK = new BienPK(codbien, correla);
    }

    public BienPK getBienPK() {
        return BienPK;
    }

    public void setBienPK(BienPK bienPK) {
        this.BienPK = bienPK;
    }

    public Character getClasifica() {
        return clasifica;
    }

    public void setClasifica(Character clasifica) {
        this.clasifica = clasifica;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getCodoficina() {
        return codoficina;
    }

    public void setCodoficina(String codoficina) {
        this.codoficina = codoficina;
    }

    public String getCodambiente() {
        return codambiente;
    }

    public void setCodambiente(String codambiente) {
        this.codambiente = codambiente;
    }

    public String getCodanterior() {
        return codanterior;
    }

    public void setCodanterior(String codanterior) {
        this.codanterior = codanterior;
    }

    public String getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(String codusuario) {
        this.codusuario = codusuario;
    }

    public Character getTipoCta() {
        return tipoCta;
    }

    public void setTipoCta(Character tipoCta) {
        this.tipoCta = tipoCta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getValorlibro() {
        return valorlibro;
    }

    public void setValorlibro(BigDecimal valorlibro) {
        this.valorlibro = valorlibro;
    }

    public BigDecimal getValortasa() {
        return valortasa;
    }

    public void setValortasa(BigDecimal valortasa) {
        this.valortasa = valortasa;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Date getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(Date vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public Date getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(Date vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public String getNummotor() {
        return nummotor;
    }

    public void setNummotor(String nummotor) {
        this.nummotor = nummotor;
    }

    public String getNumchasis() {
        return numchasis;
    }

    public void setNumchasis(String numchasis) {
        this.numchasis = numchasis;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public Date getFecReg() {
        return fecReg;
    }

    public void setFecReg(Date fecReg) {
        this.fecReg = fecReg;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Character getCondicion() {
        return condicion;
    }

    public void setCondicion(Character condicion) {
        this.condicion = condicion;
    }

    public Date getFecAct() {
        return fecAct;
    }

    public void setFecAct(Date fecAct) {
        this.fecAct = fecAct;
    }

    public Character getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Character asegurado) {
        this.asegurado = asegurado;
    }

    public Character getEstBien() {
        return estBien;
    }

    public void setEstBien(Character estBien) {
        this.estBien = estBien;
    }

    public Character getFlgCausal() {
        return flgCausal;
    }

    public void setFlgCausal(Character flgCausal) {
        this.flgCausal = flgCausal;
    }

    public String getResolBaja() {
        return resolBaja;
    }

    public void setResolBaja(String resolBaja) {
        this.resolBaja = resolBaja;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public String getUserBaja() {
        return userBaja;
    }

    public void setUserBaja(String userBaja) {
        this.userBaja = userBaja;
    }

    public Character getFlgActo() {
        return flgActo;
    }

    public void setFlgActo(Character flgActo) {
        this.flgActo = flgActo;
    }

    public String getResolDisp() {
        return resolDisp;
    }

    public void setResolDisp(String resolDisp) {
        this.resolDisp = resolDisp;
    }

    public Date getFecDisp() {
        return fecDisp;
    }

    public void setFecDisp(Date fecDisp) {
        this.fecDisp = fecDisp;
    }

    public String getCausalElim() {
        return causalElim;
    }

    public void setCausalElim(String causalElim) {
        this.causalElim = causalElim;
    }

    public Date getFechaElim() {
        return fechaElim;
    }

    public void setFechaElim(Date fechaElim) {
        this.fechaElim = fechaElim;
    }

    public String getUserElim() {
        return userElim;
    }

    public void setUserElim(String userElim) {
        this.userElim = userElim;
    }

    public Character getEstGestion() {
        return estGestion;
    }

    public void setEstGestion(Character estGestion) {
        this.estGestion = estGestion;
    }

    public String getResolAfec() {
        return resolAfec;
    }

    public void setResolAfec(String resolAfec) {
        this.resolAfec = resolAfec;
    }

    public Date getFecAfec() {
        return fecAfec;
    }

    public void setFecAfec(Date fecAfec) {
        this.fecAfec = fecAfec;
    }

    public Date getFecVafec() {
        return fecVafec;
    }

    public void setFecVafec(Date fecVafec) {
        this.fecVafec = fecVafec;
    }

    public String getEntAfec() {
        return entAfec;
    }

    public void setEntAfec(String entAfec) {
        this.entAfec = entAfec;
    }

    public String getResolArre() {
        return resolArre;
    }

    public void setResolArre(String resolArre) {
        this.resolArre = resolArre;
    }

    public Date getFecArre() {
        return fecArre;
    }

    public void setFecArre(Date fecArre) {
        this.fecArre = fecArre;
    }

    public Date getFecVarre() {
        return fecVarre;
    }

    public void setFecVarre(Date fecVarre) {
        this.fecVarre = fecVarre;
    }

    public String getEntArre() {
        return entArre;
    }

    public void setEntArre(String entArre) {
        this.entArre = entArre;
    }

    public String getDocAlta() {
        return docAlta;
    }

    public void setDocAlta(String docAlta) {
        this.docAlta = docAlta;
    }

    public String getUserAlta() {
        return userAlta;
    }

    public void setUserAlta(String userAlta) {
        this.userAlta = userAlta;
    }

    public String getDocBaja() {
        return docBaja;
    }

    public void setDocBaja(String docBaja) {
        this.docBaja = docBaja;
    }

    public Character getFlgEstado() {
        return flgEstado;
    }

    public void setFlgEstado(Character flgEstado) {
        this.flgEstado = flgEstado;
    }

    public Character getSelec() {
        return selec;
    }

    public void setSelec(Character selec) {
        this.selec = selec;
    }

    public Character getSbn() {
        return sbn;
    }

    public void setSbn(Character sbn) {
        this.sbn = sbn;
    }

    public String getAnoOrden() {
        return anoOrden;
    }

    public void setAnoOrden(String anoOrden) {
        this.anoOrden = anoOrden;
    }

    public Integer getNOrden() {
        return nOrden;
    }

    public void setNOrden(Integer nOrden) {
        this.nOrden = nOrden;
    }

    public Character getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(Character tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Character getSrp() {
        return srp;
    }

    public void setSrp(Character srp) {
        this.srp = srp;
    }

    public Character getTasado() {
        return tasado;
    }

    public void setTasado(Character tasado) {
        this.tasado = tasado;
    }

    public String getNNotacargo() {
        return nNotacargo;
    }

    public void setNNotacargo(String nNotacargo) {
        this.nNotacargo = nNotacargo;
    }

    public String getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(String codPadre) {
        this.codPadre = codPadre;
    }

    public String getCodMadre() {
        return codMadre;
    }

    public void setCodMadre(String codMadre) {
        this.codMadre = codMadre;
    }

    public Character getSitBinv() {
        return sitBinv;
    }

    public void setSitBinv(Character sitBinv) {
        this.sitBinv = sitBinv;
    }

    public BigDecimal getValoradq() {
        return valoradq;
    }

    public void setValoradq(BigDecimal valoradq) {
        this.valoradq = valoradq;
    }

    public String getEntDisp() {
        return entDisp;
    }

    public void setEntDisp(String entDisp) {
        this.entDisp = entDisp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnhoFab() {
        return anhoFab;
    }

    public void setAnhoFab(String anhoFab) {
        this.anhoFab = anhoFab;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public String getCodbienAux() {
        return codbienAux;
    }

    public void setCodbienAux(String codbienAux) {
        this.codbienAux = codbienAux;
    }

    public String getCorrelaAux() {
        return correlaAux;
    }

    public void setCorrelaAux(String correlaAux) {
        this.correlaAux = correlaAux;
    }

    public TipoBien getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(TipoBien tipoBien) {
        this.tipoBien = tipoBien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (BienPK != null ? BienPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
        if ((this.BienPK == null && other.BienPK != null) || (this.BienPK != null && !this.BienPK.equals(other.BienPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.MBienes0[ bienPK=" + BienPK + " ]";
    }

}
