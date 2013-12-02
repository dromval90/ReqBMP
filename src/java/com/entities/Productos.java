/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodCia", query = "SELECT p FROM Productos p WHERE p.productosPK.codCia = :codCia and p.codCat = :codCat"),
    @NamedQuery(name = "Productos.findByCodProd", query = "SELECT p FROM Productos p WHERE p.productosPK.codProd = :codProd"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByNomTecnico", query = "SELECT p FROM Productos p WHERE p.nomTecnico = :nomTecnico"),
    @NamedQuery(name = "Productos.findByCosto", query = "SELECT p FROM Productos p WHERE p.costo = :costo"),
    @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Productos p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productos.findByCodProv", query = "SELECT p FROM Productos p WHERE p.codProv = :codProv"),
    @NamedQuery(name = "Productos.findByUnidadMedida", query = "SELECT p FROM Productos p WHERE p.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "Productos.findByMinimo", query = "SELECT p FROM Productos p WHERE p.minimo = :minimo"),
    @NamedQuery(name = "Productos.findByPrecioV1", query = "SELECT p FROM Productos p WHERE p.precioV1 = :precioV1"),
    @NamedQuery(name = "Productos.findByPrecioV2", query = "SELECT p FROM Productos p WHERE p.precioV2 = :precioV2"),
    @NamedQuery(name = "Productos.findByUnidadV", query = "SELECT p FROM Productos p WHERE p.unidadV = :unidadV"),
    @NamedQuery(name = "Productos.findByCostoFobU", query = "SELECT p FROM Productos p WHERE p.costoFobU = :costoFobU"),
    @NamedQuery(name = "Productos.findByQtySugerida", query = "SELECT p FROM Productos p WHERE p.qtySugerida = :qtySugerida"),
    @NamedQuery(name = "Productos.findByClaseProd", query = "SELECT p FROM Productos p WHERE p.claseProd = :claseProd"),
    @NamedQuery(name = "Productos.findByCostoTotal", query = "SELECT p FROM Productos p WHERE p.costoTotal = :costoTotal"),
    @NamedQuery(name = "Productos.findByQtyAnterior", query = "SELECT p FROM Productos p WHERE p.qtyAnterior = :qtyAnterior"),
    @NamedQuery(name = "Productos.findByCostoTotalAnt", query = "SELECT p FROM Productos p WHERE p.costoTotalAnt = :costoTotalAnt"),
    @NamedQuery(name = "Productos.findByFechaCierre", query = "SELECT p FROM Productos p WHERE p.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "Productos.findByDestino", query = "SELECT p FROM Productos p WHERE p.destino = :destino"),
    @NamedQuery(name = "Productos.findByModelo", query = "SELECT p FROM Productos p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Productos.findByNoParte", query = "SELECT p FROM Productos p WHERE p.noParte = :noParte"),
    @NamedQuery(name = "Productos.findByNumeroDeLote", query = "SELECT p FROM Productos p WHERE p.numeroDeLote = :numeroDeLote"),
    @NamedQuery(name = "Productos.findByFechaCaducidad", query = "SELECT p FROM Productos p WHERE p.fechaCaducidad = :fechaCaducidad"),
    @NamedQuery(name = "Productos.findByDiasEspera", query = "SELECT p FROM Productos p WHERE p.diasEspera = :diasEspera"),
    @NamedQuery(name = "Productos.findBySecuencia", query = "SELECT p FROM Productos p WHERE p.secuencia = :secuencia"),
    @NamedQuery(name = "Productos.findByImpuestos", query = "SELECT p FROM Productos p WHERE p.impuestos = :impuestos"),
    @NamedQuery(name = "Productos.findByPorcDesc", query = "SELECT p FROM Productos p WHERE p.porcDesc = :porcDesc"),
    @NamedQuery(name = "Productos.findByCodigoUnidad", query = "SELECT p FROM Productos p WHERE p.codigoUnidad = :codigoUnidad"),
    @NamedQuery(name = "Productos.findByCodigoUnidadVenta", query = "SELECT p FROM Productos p WHERE p.codigoUnidadVenta = :codigoUnidadVenta"),
    @NamedQuery(name = "Productos.findByCodigoUnidadEmpaque", query = "SELECT p FROM Productos p WHERE p.codigoUnidadEmpaque = :codigoUnidadEmpaque"),
    @NamedQuery(name = "Productos.findByTipoEmpaque", query = "SELECT p FROM Productos p WHERE p.tipoEmpaque = :tipoEmpaque"),
    @NamedQuery(name = "Productos.findByAduana", query = "SELECT p FROM Productos p WHERE p.aduana = :aduana"),
    @NamedQuery(name = "Productos.findByExentoItbm", query = "SELECT p FROM Productos p WHERE p.exentoItbm = :exentoItbm"),
    @NamedQuery(name = "Productos.findByAutoPieza", query = "SELECT p FROM Productos p WHERE p.autoPieza = :autoPieza"),
    @NamedQuery(name = "Productos.findByMaximo", query = "SELECT p FROM Productos p WHERE p.maximo = :maximo"),
    @NamedQuery(name = "Productos.findByAplicarDescuento", query = "SELECT p FROM Productos p WHERE p.aplicarDescuento = :aplicarDescuento"),
    @NamedQuery(name = "Productos.findByTipo", query = "SELECT p FROM Productos p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Productos.findByPeso", query = "SELECT p FROM Productos p WHERE p.peso = :peso"),
    @NamedQuery(name = "Productos.findByCodigoAlterno", query = "SELECT p FROM Productos p WHERE p.codigoAlterno = :codigoAlterno"),
    @NamedQuery(name = "Productos.findByReordenAut", query = "SELECT p FROM Productos p WHERE p.reordenAut = :reordenAut"),
    @NamedQuery(name = "Productos.findByUltCodDoctoi", query = "SELECT p FROM Productos p WHERE p.ultCodDoctoi = :ultCodDoctoi"),
    @NamedQuery(name = "Productos.findByUltimoCosto", query = "SELECT p FROM Productos p WHERE p.ultimoCosto = :ultimoCosto"),
    @NamedQuery(name = "Productos.findByStatus", query = "SELECT p FROM Productos p WHERE p.status = :status"),
    @NamedQuery(name = "Productos.findByVolumenProd", query = "SELECT p FROM Productos p WHERE p.volumenProd = :volumenProd"),
    @NamedQuery(name = "Productos.findByIndicadorVentas", query = "SELECT p FROM Productos p WHERE p.indicadorVentas = :indicadorVentas"),
    @NamedQuery(name = "Productos.findByPctMargenUtilidad", query = "SELECT p FROM Productos p WHERE p.pctMargenUtilidad = :pctMargenUtilidad"),
    @NamedQuery(name = "Productos.findByPctComisionMargen1", query = "SELECT p FROM Productos p WHERE p.pctComisionMargen1 = :pctComisionMargen1"),
    @NamedQuery(name = "Productos.findByPctComisionMargen2", query = "SELECT p FROM Productos p WHERE p.pctComisionMargen2 = :pctComisionMargen2"),
    @NamedQuery(name = "Productos.findByDisponible", query = "SELECT p FROM Productos p WHERE p.disponible = :disponible"),
    @NamedQuery(name = "Productos.findByComprometido", query = "SELECT p FROM Productos p WHERE p.comprometido = :comprometido"),
    @NamedQuery(name = "Productos.findByTransito", query = "SELECT p FROM Productos p WHERE p.transito = :transito"),
    @NamedQuery(name = "Productos.findByBackorder", query = "SELECT p FROM Productos p WHERE p.backorder = :backorder"),
    @NamedQuery(name = "Productos.findByPedido", query = "SELECT p FROM Productos p WHERE p.pedido = :pedido"),
    @NamedQuery(name = "Productos.findByCodGrid", query = "SELECT p FROM Productos p WHERE p.codGrid = :codGrid"),
    @NamedQuery(name = "Productos.findByClasificacion", query = "SELECT p FROM Productos p WHERE p.clasificacion = :clasificacion"),
    @NamedQuery(name = "Productos.findBySubClasificacion", query = "SELECT p FROM Productos p WHERE p.subClasificacion = :subClasificacion"),
    @NamedQuery(name = "Productos.findBySugeridoCompra", query = "SELECT p FROM Productos p WHERE p.sugeridoCompra = :sugeridoCompra"),
    @NamedQuery(name = "Productos.findByVentasPerdidas", query = "SELECT p FROM Productos p WHERE p.ventasPerdidas = :ventasPerdidas"),
    @NamedQuery(name = "Productos.findByCantidadFisica", query = "SELECT p FROM Productos p WHERE p.cantidadFisica = :cantidadFisica"),
    @NamedQuery(name = "Productos.findByTotalVentas", query = "SELECT p FROM Productos p WHERE p.totalVentas = :totalVentas"),
    @NamedQuery(name = "Productos.findByEstadoTomaFisica", query = "SELECT p FROM Productos p WHERE p.estadoTomaFisica = :estadoTomaFisica"),
    @NamedQuery(name = "Productos.findByPrecioCifAutorizado", query = "SELECT p FROM Productos p WHERE p.precioCifAutorizado = :precioCifAutorizado"),
    @NamedQuery(name = "Productos.findByEstilosId", query = "SELECT p FROM Productos p WHERE p.estilosId = :estilosId"),
    @NamedQuery(name = "Productos.findByColorId", query = "SELECT p FROM Productos p WHERE p.colorId = :colorId"),
    @NamedQuery(name = "Productos.findByTallaId", query = "SELECT p FROM Productos p WHERE p.tallaId = :tallaId"),
    @NamedQuery(name = "Productos.findByProdId", query = "SELECT p FROM Productos p WHERE p.prodId = :prodId"),
    @NamedQuery(name = "Productos.findByFechaCreacion", query = "SELECT p FROM Productos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Productos.findByUsuarioCreacion", query = "SELECT p FROM Productos p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Productos.findByCostoA", query = "SELECT p FROM Productos p WHERE p.costoA = :costoA"),
    @NamedQuery(name = "Productos.findByCodUnidadCompra", query = "SELECT p FROM Productos p WHERE p.codUnidadCompra = :codUnidadCompra"),
    @NamedQuery(name = "Productos.findByDiesco", query = "SELECT p FROM Productos p WHERE p.diesco = :diesco")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosPK productosPK;
    @Size(max = 3)
    @Column(name = "COD_CAT")
    private String codCat;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "NOM_TECNICO")
    private String nomTecnico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Size(max = 10)
    @Column(name = "COD_PROV")
    private String codProv;
    @Size(max = 10)
    @Column(name = "UNIDAD_MEDIDA")
    private String unidadMedida;
    @Column(name = "MINIMO")
    private BigDecimal minimo;
    @Column(name = "PRECIO_V1")
    private BigDecimal precioV1;
    @Column(name = "PRECIO_V2")
    private BigDecimal precioV2;
    @Size(max = 10)
    @Column(name = "UNIDAD_V")
    private String unidadV;
    @Column(name = "COSTO_FOB_U")
    private BigDecimal costoFobU;
    @Column(name = "QTY_SUGERIDA")
    private BigDecimal qtySugerida;
    @Size(max = 1)
    @Column(name = "CLASE_PROD")
    private String claseProd;
    @Column(name = "COSTO_TOTAL")
    private BigDecimal costoTotal;
    @Column(name = "QTY_ANTERIOR")
    private BigDecimal qtyAnterior;
    @Column(name = "COSTO_TOTAL_ANT")
    private BigDecimal costoTotalAnt;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Size(max = 70)
    @Column(name = "DESTINO")
    private String destino;
    @Size(max = 30)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 30)
    @Column(name = "NO_PARTE")
    private String noParte;
    @Size(max = 15)
    @Column(name = "NUMERO_DE_LOTE")
    private String numeroDeLote;
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @Column(name = "DIAS_ESPERA")
    private Short diasEspera;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Column(name = "IMPUESTOS")
    private BigDecimal impuestos;
    @Column(name = "PORC_DESC")
    private BigDecimal porcDesc;
    @Column(name = "CODIGO_UNIDAD")
    private Short codigoUnidad;
    @Column(name = "CODIGO_UNIDAD_VENTA")
    private Short codigoUnidadVenta;
    @Column(name = "CODIGO_UNIDAD_EMPAQUE")
    private Short codigoUnidadEmpaque;
    @Size(max = 1)
    @Column(name = "TIPO_EMPAQUE")
    private String tipoEmpaque;
    @Column(name = "ADUANA")
    private BigDecimal aduana;
    @Size(max = 1)
    @Column(name = "EXENTO_ITBM")
    private String exentoItbm;
    @Size(max = 1)
    @Column(name = "AUTO_PIEZA")
    private String autoPieza;
    @Column(name = "MAXIMO")
    private BigDecimal maximo;
    @Size(max = 1)
    @Column(name = "APLICAR_DESCUENTO")
    private String aplicarDescuento;
    @Size(max = 1)
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "PESO")
    private BigDecimal peso;
    @Size(max = 30)
    @Column(name = "CODIGO_ALTERNO")
    private String codigoAlterno;
    @Size(max = 1)
    @Column(name = "REORDEN_AUT")
    private String reordenAut;
    @Column(name = "ULT_COD_DOCTOI")
    private Short ultCodDoctoi;
    @Column(name = "ULTIMO_COSTO")
    private BigDecimal ultimoCosto;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "VOLUMEN_PROD")
    private BigDecimal volumenProd;
    @Column(name = "INDICADOR_VENTAS")
    private Short indicadorVentas;
    @Column(name = "PCT_MARGEN_UTILIDAD")
    private BigDecimal pctMargenUtilidad;
    @Column(name = "PCT_COMISION_MARGEN1")
    private BigDecimal pctComisionMargen1;
    @Column(name = "PCT_COMISION_MARGEN2")
    private BigDecimal pctComisionMargen2;
    @Column(name = "DISPONIBLE")
    private BigDecimal disponible;
    @Column(name = "COMPROMETIDO")
    private BigDecimal comprometido;
    @Column(name = "TRANSITO")
    private BigDecimal transito;
    @Column(name = "BACKORDER")
    private BigDecimal backorder;
    @Column(name = "PEDIDO")
    private BigDecimal pedido;
    @Column(name = "COD_GRID")
    private Short codGrid;
    @Size(max = 2)
    @Column(name = "CLASIFICACION")
    private String clasificacion;
    @Column(name = "SUB_CLASIFICACION")
    private Short subClasificacion;
    @Column(name = "SUGERIDO_COMPRA")
    private BigDecimal sugeridoCompra;
    @Column(name = "VENTAS_PERDIDAS")
    private BigDecimal ventasPerdidas;
    @Column(name = "CANTIDAD_FISICA")
    private BigDecimal cantidadFisica;
    @Column(name = "TOTAL_VENTAS")
    private BigDecimal totalVentas;
    @Size(max = 1)
    @Column(name = "ESTADO_TOMA_FISICA")
    private String estadoTomaFisica;
    @Column(name = "PRECIO_CIF_AUTORIZADO")
    private BigDecimal precioCifAutorizado;
    @Column(name = "ESTILOS_ID")
    private Integer estilosId;
    @Column(name = "COLOR_ID")
    private Integer colorId;
    @Column(name = "TALLA_ID")
    private Integer tallaId;
    @Column(name = "PROD_ID")
    private Integer prodId;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 30)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Column(name = "COSTO_A")
    private BigDecimal costoA;
    @Column(name = "COD_UNIDAD_COMPRA")
    private Short codUnidadCompra;
    @Size(max = 15)
    @Column(name = "DIESCO")
    private String diesco;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<Detorden> detordenList;

    public Productos() {
    }

    public Productos(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public Productos(short codCia, String codProd) {
        this.productosPK = new ProductosPK(codCia, codProd);
    }

    public ProductosPK getProductosPK() {
        return productosPK;
    }

    public void setProductosPK(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getMinimo() {
        return minimo;
    }

    public void setMinimo(BigDecimal minimo) {
        this.minimo = minimo;
    }

    public BigDecimal getPrecioV1() {
        return precioV1;
    }

    public void setPrecioV1(BigDecimal precioV1) {
        this.precioV1 = precioV1;
    }

    public BigDecimal getPrecioV2() {
        return precioV2;
    }

    public void setPrecioV2(BigDecimal precioV2) {
        this.precioV2 = precioV2;
    }

    public String getUnidadV() {
        return unidadV;
    }

    public void setUnidadV(String unidadV) {
        this.unidadV = unidadV;
    }

    public BigDecimal getCostoFobU() {
        return costoFobU;
    }

    public void setCostoFobU(BigDecimal costoFobU) {
        this.costoFobU = costoFobU;
    }

    public BigDecimal getQtySugerida() {
        return qtySugerida;
    }

    public void setQtySugerida(BigDecimal qtySugerida) {
        this.qtySugerida = qtySugerida;
    }

    public String getClaseProd() {
        return claseProd;
    }

    public void setClaseProd(String claseProd) {
        this.claseProd = claseProd;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

    public BigDecimal getQtyAnterior() {
        return qtyAnterior;
    }

    public void setQtyAnterior(BigDecimal qtyAnterior) {
        this.qtyAnterior = qtyAnterior;
    }

    public BigDecimal getCostoTotalAnt() {
        return costoTotalAnt;
    }

    public void setCostoTotalAnt(BigDecimal costoTotalAnt) {
        this.costoTotalAnt = costoTotalAnt;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNoParte() {
        return noParte;
    }

    public void setNoParte(String noParte) {
        this.noParte = noParte;
    }

    public String getNumeroDeLote() {
        return numeroDeLote;
    }

    public void setNumeroDeLote(String numeroDeLote) {
        this.numeroDeLote = numeroDeLote;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Short getDiasEspera() {
        return diasEspera;
    }

    public void setDiasEspera(Short diasEspera) {
        this.diasEspera = diasEspera;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getPorcDesc() {
        return porcDesc;
    }

    public void setPorcDesc(BigDecimal porcDesc) {
        this.porcDesc = porcDesc;
    }

    public Short getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public Short getCodigoUnidadVenta() {
        return codigoUnidadVenta;
    }

    public void setCodigoUnidadVenta(Short codigoUnidadVenta) {
        this.codigoUnidadVenta = codigoUnidadVenta;
    }

    public Short getCodigoUnidadEmpaque() {
        return codigoUnidadEmpaque;
    }

    public void setCodigoUnidadEmpaque(Short codigoUnidadEmpaque) {
        this.codigoUnidadEmpaque = codigoUnidadEmpaque;
    }

    public String getTipoEmpaque() {
        return tipoEmpaque;
    }

    public void setTipoEmpaque(String tipoEmpaque) {
        this.tipoEmpaque = tipoEmpaque;
    }

    public BigDecimal getAduana() {
        return aduana;
    }

    public void setAduana(BigDecimal aduana) {
        this.aduana = aduana;
    }

    public String getExentoItbm() {
        return exentoItbm;
    }

    public void setExentoItbm(String exentoItbm) {
        this.exentoItbm = exentoItbm;
    }

    public String getAutoPieza() {
        return autoPieza;
    }

    public void setAutoPieza(String autoPieza) {
        this.autoPieza = autoPieza;
    }

    public BigDecimal getMaximo() {
        return maximo;
    }

    public void setMaximo(BigDecimal maximo) {
        this.maximo = maximo;
    }

    public String getAplicarDescuento() {
        return aplicarDescuento;
    }

    public void setAplicarDescuento(String aplicarDescuento) {
        this.aplicarDescuento = aplicarDescuento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getReordenAut() {
        return reordenAut;
    }

    public void setReordenAut(String reordenAut) {
        this.reordenAut = reordenAut;
    }

    public Short getUltCodDoctoi() {
        return ultCodDoctoi;
    }

    public void setUltCodDoctoi(Short ultCodDoctoi) {
        this.ultCodDoctoi = ultCodDoctoi;
    }

    public BigDecimal getUltimoCosto() {
        return ultimoCosto;
    }

    public void setUltimoCosto(BigDecimal ultimoCosto) {
        this.ultimoCosto = ultimoCosto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getVolumenProd() {
        return volumenProd;
    }

    public void setVolumenProd(BigDecimal volumenProd) {
        this.volumenProd = volumenProd;
    }

    public Short getIndicadorVentas() {
        return indicadorVentas;
    }

    public void setIndicadorVentas(Short indicadorVentas) {
        this.indicadorVentas = indicadorVentas;
    }

    public BigDecimal getPctMargenUtilidad() {
        return pctMargenUtilidad;
    }

    public void setPctMargenUtilidad(BigDecimal pctMargenUtilidad) {
        this.pctMargenUtilidad = pctMargenUtilidad;
    }

    public BigDecimal getPctComisionMargen1() {
        return pctComisionMargen1;
    }

    public void setPctComisionMargen1(BigDecimal pctComisionMargen1) {
        this.pctComisionMargen1 = pctComisionMargen1;
    }

    public BigDecimal getPctComisionMargen2() {
        return pctComisionMargen2;
    }

    public void setPctComisionMargen2(BigDecimal pctComisionMargen2) {
        this.pctComisionMargen2 = pctComisionMargen2;
    }

    public BigDecimal getDisponible() {
        return disponible;
    }

    public void setDisponible(BigDecimal disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getComprometido() {
        return comprometido;
    }

    public void setComprometido(BigDecimal comprometido) {
        this.comprometido = comprometido;
    }

    public BigDecimal getTransito() {
        return transito;
    }

    public void setTransito(BigDecimal transito) {
        this.transito = transito;
    }

    public BigDecimal getBackorder() {
        return backorder;
    }

    public void setBackorder(BigDecimal backorder) {
        this.backorder = backorder;
    }

    public BigDecimal getPedido() {
        return pedido;
    }

    public void setPedido(BigDecimal pedido) {
        this.pedido = pedido;
    }

    public Short getCodGrid() {
        return codGrid;
    }

    public void setCodGrid(Short codGrid) {
        this.codGrid = codGrid;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Short getSubClasificacion() {
        return subClasificacion;
    }

    public void setSubClasificacion(Short subClasificacion) {
        this.subClasificacion = subClasificacion;
    }

    public BigDecimal getSugeridoCompra() {
        return sugeridoCompra;
    }

    public void setSugeridoCompra(BigDecimal sugeridoCompra) {
        this.sugeridoCompra = sugeridoCompra;
    }

    public BigDecimal getVentasPerdidas() {
        return ventasPerdidas;
    }

    public void setVentasPerdidas(BigDecimal ventasPerdidas) {
        this.ventasPerdidas = ventasPerdidas;
    }

    public BigDecimal getCantidadFisica() {
        return cantidadFisica;
    }

    public void setCantidadFisica(BigDecimal cantidadFisica) {
        this.cantidadFisica = cantidadFisica;
    }

    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getEstadoTomaFisica() {
        return estadoTomaFisica;
    }

    public void setEstadoTomaFisica(String estadoTomaFisica) {
        this.estadoTomaFisica = estadoTomaFisica;
    }

    public BigDecimal getPrecioCifAutorizado() {
        return precioCifAutorizado;
    }

    public void setPrecioCifAutorizado(BigDecimal precioCifAutorizado) {
        this.precioCifAutorizado = precioCifAutorizado;
    }

    public Integer getEstilosId() {
        return estilosId;
    }

    public void setEstilosId(Integer estilosId) {
        this.estilosId = estilosId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getTallaId() {
        return tallaId;
    }

    public void setTallaId(Integer tallaId) {
        this.tallaId = tallaId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public BigDecimal getCostoA() {
        return costoA;
    }

    public void setCostoA(BigDecimal costoA) {
        this.costoA = costoA;
    }

    public Short getCodUnidadCompra() {
        return codUnidadCompra;
    }

    public void setCodUnidadCompra(Short codUnidadCompra) {
        this.codUnidadCompra = codUnidadCompra;
    }

    public String getDiesco() {
        return diesco;
    }

    public void setDiesco(String diesco) {
        this.diesco = diesco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosPK != null ? productosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productosPK == null && other.productosPK != null) || (this.productosPK != null && !this.productosPK.equals(other.productosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Productos[ productosPK=" + productosPK + " ]";
    }

    public List<Detorden> getDetordenList() {
        return detordenList;
    }

    public void setDetordenList(List<Detorden> detordenList) {
        this.detordenList = detordenList;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }
    
    
    
    
}
