/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "mbienes0")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MBienes0.findAll", query = "SELECT m FROM MBienes0 m"),
    @NamedQuery(name = "MBienes0.findByCodbien", query = "SELECT m FROM MBienes0 m WHERE m.mBienes0PK.codbien = :codbien"),
    @NamedQuery(name = "MBienes0.findByCorrela", query = "SELECT m FROM MBienes0 m WHERE m.mBienes0PK.correla = :correla"),
    @NamedQuery(name = "MBienes0.findByClasifica", query = "SELECT m FROM MBienes0 m WHERE m.clasifica = :clasifica"),
    @NamedQuery(name = "MBienes0.findByCodlocal", query = "SELECT m FROM MBienes0 m WHERE m.codlocal = :codlocal"),
    @NamedQuery(name = "MBienes0.findByCodarea", query = "SELECT m FROM MBienes0 m WHERE m.codarea = :codarea"),
    @NamedQuery(name = "MBienes0.findByCodoficina", query = "SELECT m FROM MBienes0 m WHERE m.codoficina = :codoficina"),
    @NamedQuery(name = "MBienes0.findByCodambiente", query = "SELECT m FROM MBienes0 m WHERE m.codambiente = :codambiente"),
    @NamedQuery(name = "MBienes0.findByCodanterior", query = "SELECT m FROM MBienes0 m WHERE m.codanterior = :codanterior"),
    @NamedQuery(name = "MBienes0.findByCodusuario", query = "SELECT m FROM MBienes0 m WHERE m.codusuario = :codusuario"),
    @NamedQuery(name = "MBienes0.findByTipoCta", query = "SELECT m FROM MBienes0 m WHERE m.tipoCta = :tipoCta"),
    @NamedQuery(name = "MBienes0.findByCuenta", query = "SELECT m FROM MBienes0 m WHERE m.cuenta = :cuenta"),
    @NamedQuery(name = "MBienes0.findByValorlibro", query = "SELECT m FROM MBienes0 m WHERE m.valorlibro = :valorlibro"),
    @NamedQuery(name = "MBienes0.findByValortasa", query = "SELECT m FROM MBienes0 m WHERE m.valortasa = :valortasa"),
    @NamedQuery(name = "MBienes0.findByEstado", query = "SELECT m FROM MBienes0 m WHERE m.estado = :estado"),
    @NamedQuery(name = "MBienes0.findByMarca", query = "SELECT m FROM MBienes0 m WHERE m.marca = :marca"),
    @NamedQuery(name = "MBienes0.findByModelo", query = "SELECT m FROM MBienes0 m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "MBienes0.findByTipo", query = "SELECT m FROM MBienes0 m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "MBienes0.findByColor", query = "SELECT m FROM MBienes0 m WHERE m.color = :color"),
    @NamedQuery(name = "MBienes0.findBySerie", query = "SELECT m FROM MBienes0 m WHERE m.serie = :serie"),
    @NamedQuery(name = "MBienes0.findByTitulo", query = "SELECT m FROM MBienes0 m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "MBienes0.findByEdicion", query = "SELECT m FROM MBienes0 m WHERE m.edicion = :edicion"),
    @NamedQuery(name = "MBienes0.findByAutor", query = "SELECT m FROM MBienes0 m WHERE m.autor = :autor"),
    @NamedQuery(name = "MBienes0.findByProductName", query = "SELECT m FROM MBienes0 m WHERE m.productName = :productName"),
    @NamedQuery(name = "MBienes0.findByProductKey", query = "SELECT m FROM MBienes0 m WHERE m.productKey = :productKey"),
    @NamedQuery(name = "MBienes0.findByVigenciaDesde", query = "SELECT m FROM MBienes0 m WHERE m.vigenciaDesde = :vigenciaDesde"),
    @NamedQuery(name = "MBienes0.findByVigenciaHasta", query = "SELECT m FROM MBienes0 m WHERE m.vigenciaHasta = :vigenciaHasta"),
    @NamedQuery(name = "MBienes0.findByNummotor", query = "SELECT m FROM MBienes0 m WHERE m.nummotor = :nummotor"),
    @NamedQuery(name = "MBienes0.findByNumchasis", query = "SELECT m FROM MBienes0 m WHERE m.numchasis = :numchasis"),
    @NamedQuery(name = "MBienes0.findByA\u00f1o", query = "SELECT m FROM MBienes0 m WHERE m.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "MBienes0.findByDimension", query = "SELECT m FROM MBienes0 m WHERE m.dimension = :dimension"),
    @NamedQuery(name = "MBienes0.findByRaza", query = "SELECT m FROM MBienes0 m WHERE m.raza = :raza"),
    @NamedQuery(name = "MBienes0.findByEspecie", query = "SELECT m FROM MBienes0 m WHERE m.especie = :especie"),
    @NamedQuery(name = "MBienes0.findByOtros", query = "SELECT m FROM MBienes0 m WHERE m.otros = :otros"),
    @NamedQuery(name = "MBienes0.findByFecReg", query = "SELECT m FROM MBienes0 m WHERE m.fecReg = :fecReg"),
    @NamedQuery(name = "MBienes0.findByPlaca", query = "SELECT m FROM MBienes0 m WHERE m.placa = :placa"),
    @NamedQuery(name = "MBienes0.findByEdad", query = "SELECT m FROM MBienes0 m WHERE m.edad = :edad"),
    @NamedQuery(name = "MBienes0.findByPais", query = "SELECT m FROM MBienes0 m WHERE m.pais = :pais"),
    @NamedQuery(name = "MBienes0.findByCondicion", query = "SELECT m FROM MBienes0 m WHERE m.condicion = :condicion"),
    @NamedQuery(name = "MBienes0.findByFecAct", query = "SELECT m FROM MBienes0 m WHERE m.fecAct = :fecAct"),
    @NamedQuery(name = "MBienes0.findByAsegurado", query = "SELECT m FROM MBienes0 m WHERE m.asegurado = :asegurado"),
    @NamedQuery(name = "MBienes0.findByEstBien", query = "SELECT m FROM MBienes0 m WHERE m.estBien = :estBien"),
    @NamedQuery(name = "MBienes0.findByFlgCausal", query = "SELECT m FROM MBienes0 m WHERE m.flgCausal = :flgCausal"),
    @NamedQuery(name = "MBienes0.findByResolBaja", query = "SELECT m FROM MBienes0 m WHERE m.resolBaja = :resolBaja"),
    @NamedQuery(name = "MBienes0.findByFecBaja", query = "SELECT m FROM MBienes0 m WHERE m.fecBaja = :fecBaja"),
    @NamedQuery(name = "MBienes0.findByUserBaja", query = "SELECT m FROM MBienes0 m WHERE m.userBaja = :userBaja"),
    @NamedQuery(name = "MBienes0.findByFlgActo", query = "SELECT m FROM MBienes0 m WHERE m.flgActo = :flgActo"),
    @NamedQuery(name = "MBienes0.findByResolDisp", query = "SELECT m FROM MBienes0 m WHERE m.resolDisp = :resolDisp"),
    @NamedQuery(name = "MBienes0.findByFecDisp", query = "SELECT m FROM MBienes0 m WHERE m.fecDisp = :fecDisp"),
    @NamedQuery(name = "MBienes0.findByCausalElim", query = "SELECT m FROM MBienes0 m WHERE m.causalElim = :causalElim"),
    @NamedQuery(name = "MBienes0.findByFechaElim", query = "SELECT m FROM MBienes0 m WHERE m.fechaElim = :fechaElim"),
    @NamedQuery(name = "MBienes0.findByUserElim", query = "SELECT m FROM MBienes0 m WHERE m.userElim = :userElim"),
    @NamedQuery(name = "MBienes0.findByEstGestion", query = "SELECT m FROM MBienes0 m WHERE m.estGestion = :estGestion"),
    @NamedQuery(name = "MBienes0.findByResolAfec", query = "SELECT m FROM MBienes0 m WHERE m.resolAfec = :resolAfec"),
    @NamedQuery(name = "MBienes0.findByFecAfec", query = "SELECT m FROM MBienes0 m WHERE m.fecAfec = :fecAfec"),
    @NamedQuery(name = "MBienes0.findByFecVafec", query = "SELECT m FROM MBienes0 m WHERE m.fecVafec = :fecVafec"),
    @NamedQuery(name = "MBienes0.findByEntAfec", query = "SELECT m FROM MBienes0 m WHERE m.entAfec = :entAfec"),
    @NamedQuery(name = "MBienes0.findByResolArre", query = "SELECT m FROM MBienes0 m WHERE m.resolArre = :resolArre"),
    @NamedQuery(name = "MBienes0.findByFecArre", query = "SELECT m FROM MBienes0 m WHERE m.fecArre = :fecArre"),
    @NamedQuery(name = "MBienes0.findByFecVarre", query = "SELECT m FROM MBienes0 m WHERE m.fecVarre = :fecVarre"),
    @NamedQuery(name = "MBienes0.findByEntArre", query = "SELECT m FROM MBienes0 m WHERE m.entArre = :entArre"),
    @NamedQuery(name = "MBienes0.findByDocAlta", query = "SELECT m FROM MBienes0 m WHERE m.docAlta = :docAlta"),
    @NamedQuery(name = "MBienes0.findByUserAlta", query = "SELECT m FROM MBienes0 m WHERE m.userAlta = :userAlta"),
    @NamedQuery(name = "MBienes0.findByDocBaja", query = "SELECT m FROM MBienes0 m WHERE m.docBaja = :docBaja"),
    @NamedQuery(name = "MBienes0.findByFlgEstado", query = "SELECT m FROM MBienes0 m WHERE m.flgEstado = :flgEstado"),
    @NamedQuery(name = "MBienes0.findBySelec", query = "SELECT m FROM MBienes0 m WHERE m.selec = :selec"),
    @NamedQuery(name = "MBienes0.findBySbn", query = "SELECT m FROM MBienes0 m WHERE m.sbn = :sbn"),
    @NamedQuery(name = "MBienes0.findByAnoOrden", query = "SELECT m FROM MBienes0 m WHERE m.anoOrden = :anoOrden"),
    @NamedQuery(name = "MBienes0.findByNOrden", query = "SELECT m FROM MBienes0 m WHERE m.nOrden = :nOrden"),
    @NamedQuery(name = "MBienes0.findByTipoOrden", query = "SELECT m FROM MBienes0 m WHERE m.tipoOrden = :tipoOrden"),
    @NamedQuery(name = "MBienes0.findByFuncionario", query = "SELECT m FROM MBienes0 m WHERE m.funcionario = :funcionario"),
    @NamedQuery(name = "MBienes0.findBySrp", query = "SELECT m FROM MBienes0 m WHERE m.srp = :srp"),
    @NamedQuery(name = "MBienes0.findByTasado", query = "SELECT m FROM MBienes0 m WHERE m.tasado = :tasado"),
    @NamedQuery(name = "MBienes0.findByNNotacargo", query = "SELECT m FROM MBienes0 m WHERE m.nNotacargo = :nNotacargo"),
    @NamedQuery(name = "MBienes0.findByCodPadre", query = "SELECT m FROM MBienes0 m WHERE m.codPadre = :codPadre"),
    @NamedQuery(name = "MBienes0.findByCodMadre", query = "SELECT m FROM MBienes0 m WHERE m.codMadre = :codMadre"),
    @NamedQuery(name = "MBienes0.findBySitBinv", query = "SELECT m FROM MBienes0 m WHERE m.sitBinv = :sitBinv"),
    @NamedQuery(name = "MBienes0.findByValoradq", query = "SELECT m FROM MBienes0 m WHERE m.valoradq = :valoradq"),
    @NamedQuery(name = "MBienes0.findByEntDisp", query = "SELECT m FROM MBienes0 m WHERE m.entDisp = :entDisp"),
    @NamedQuery(name = "MBienes0.findByMatricula", query = "SELECT m FROM MBienes0 m WHERE m.matricula = :matricula"),
    @NamedQuery(name = "MBienes0.findByAnhoFab", query = "SELECT m FROM MBienes0 m WHERE m.anhoFab = :anhoFab"),
    @NamedQuery(name = "MBienes0.findByLongitud", query = "SELECT m FROM MBienes0 m WHERE m.longitud = :longitud"),
    @NamedQuery(name = "MBienes0.findByAltura", query = "SELECT m FROM MBienes0 m WHERE m.altura = :altura"),
    @NamedQuery(name = "MBienes0.findByAncho", query = "SELECT m FROM MBienes0 m WHERE m.ancho = :ancho"),
    @NamedQuery(name = "MBienes0.findByCodbienAux", query = "SELECT m FROM MBienes0 m WHERE m.codbienAux = :codbienAux"),
    @NamedQuery(name = "MBienes0.findByCorrelaAux", query = "SELECT m FROM MBienes0 m WHERE m.correlaAux = :correlaAux")})
public class MBienes0 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MBienes0PK mBienes0PK;
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
    private Tipobien tipobien;

    public MBienes0() {
    }

    public MBienes0(MBienes0PK mBienes0PK) {
        this.mBienes0PK = mBienes0PK;
    }

    public MBienes0(String codbien, String correla) {
        this.mBienes0PK = new MBienes0PK(codbien, correla);
    }

    public MBienes0PK getMBienes0PK() {
        return mBienes0PK;
    }

    public void setMBienes0PK(MBienes0PK mBienes0PK) {
        this.mBienes0PK = mBienes0PK;
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

    public Tipobien getTipobien() {
        return tipobien;
    }

    public void setTipobien(Tipobien tipobien) {
        this.tipobien = tipobien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mBienes0PK != null ? mBienes0PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MBienes0)) {
            return false;
        }
        MBienes0 other = (MBienes0) object;
        if ((this.mBienes0PK == null && other.mBienes0PK != null) || (this.mBienes0PK != null && !this.mBienes0PK.equals(other.mBienes0PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.MBienes0[ mBienes0PK=" + mBienes0PK + " ]";
    }
    
}
