/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
 * @author dromero
 */
@Entity
@Table(name = "DETORDEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detorden.findAll", query = "SELECT d FROM Detorden d"),
    @NamedQuery(name = "Detorden.findByNumOrden", query = "SELECT d FROM Detorden d WHERE d.detordenPK.numOrden = :numOrden"),
    @NamedQuery(name = "Detorden.findByCodCia", query = "SELECT d FROM Detorden d WHERE d.detordenPK.codCia = :codCia and d.detordenPK.numOrden = :numOrden"),
    @NamedQuery(name = "Detorden.findByCodProd", query = "SELECT d FROM Detorden d WHERE d.detordenPK.codProd = :codProd"),
    @NamedQuery(name = "Detorden.findByNombre", query = "SELECT d FROM Detorden d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Detorden.findByCodigoUnidad", query = "SELECT d FROM Detorden d WHERE d.codigoUnidad = :codigoUnidad"),
    @NamedQuery(name = "Detorden.findByCantidad", query = "SELECT d FROM Detorden d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detorden.findByPreciouni", query = "SELECT d FROM Detorden d WHERE d.preciouni = :preciouni"),
    @NamedQuery(name = "Detorden.findByValorreq", query = "SELECT d FROM Detorden d WHERE d.valorreq = :valorreq"),
    @NamedQuery(name = "Detorden.findByFecharequerido", query = "SELECT d FROM Detorden d WHERE d.fecharequerido = :fecharequerido"),
    @NamedQuery(name = "Detorden.findByFecharecibido", query = "SELECT d FROM Detorden d WHERE d.fecharecibido = :fecharecibido"),
    @NamedQuery(name = "Detorden.findByRecibido", query = "SELECT d FROM Detorden d WHERE d.recibido = :recibido"),
    @NamedQuery(name = "Detorden.findByCantidadRec", query = "SELECT d FROM Detorden d WHERE d.cantidadRec = :cantidadRec"),
    @NamedQuery(name = "Detorden.findByCalidad", query = "SELECT d FROM Detorden d WHERE d.calidad = :calidad"),
    @NamedQuery(name = "Detorden.findByCantCal", query = "SELECT d FROM Detorden d WHERE d.cantCal = :cantCal"),
    @NamedQuery(name = "Detorden.findByFechaPromesa", query = "SELECT d FROM Detorden d WHERE d.fechaPromesa = :fechaPromesa"),
    @NamedQuery(name = "Detorden.findByFechaSurtido", query = "SELECT d FROM Detorden d WHERE d.fechaSurtido = :fechaSurtido"),
    @NamedQuery(name = "Detorden.findByCantSurtida", query = "SELECT d FROM Detorden d WHERE d.cantSurtida = :cantSurtida")})
public class Detorden implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetordenPK detordenPK;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CODIGO_UNIDAD")
    private Short codigoUnidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "PRECIOUNI")
    private BigDecimal preciouni;
    @Column(name = "VALORREQ")
    private BigDecimal valorreq;
    @Column(name = "FECHAREQUERIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharequerido;
    @Column(name = "FECHARECIBIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecibido;
    @Size(max = 1)
    @Column(name = "RECIBIDO")
    private String recibido;
    @Column(name = "CANTIDAD_REC")
    private BigDecimal cantidadRec;
    @Column(name = "CALIDAD")
    private Long calidad;
    @Column(name = "CANT_CAL")
    private BigDecimal cantCal;
    @Column(name = "FECHA_PROMESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPromesa;
    @Column(name = "FECHA_SURTIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSurtido;
    @Column(name = "CANT_SURTIDA")
    private BigDecimal cantSurtida;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_ORDEN", referencedColumnName = "NUM_ORDEN", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ordenenc ordenenc;

    public Detorden() {
    }

    public Detorden(DetordenPK detordenPK) {
        this.detordenPK = detordenPK;
    }

    public Detorden(String numOrden, short codCia, String codProd) {
        this.detordenPK = new DetordenPK(numOrden, codCia, codProd);
    }

    public DetordenPK getDetordenPK() {
        return detordenPK;
    }

    public void setDetordenPK(DetordenPK detordenPK) {
        this.detordenPK = detordenPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciouni() {
        return preciouni;
    }

    public void setPreciouni(BigDecimal preciouni) {
        this.preciouni = preciouni;
    }

    public BigDecimal getValorreq() {
        return valorreq;
    }

    public void setValorreq(BigDecimal valorreq) {
        this.valorreq = valorreq;
    }

    public Date getFecharequerido() {
        return fecharequerido;
    }

    public void setFecharequerido(Date fecharequerido) {
        this.fecharequerido = fecharequerido;
    }

    public Date getFecharecibido() {
        return fecharecibido;
    }

    public void setFecharecibido(Date fecharecibido) {
        this.fecharecibido = fecharecibido;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public BigDecimal getCantidadRec() {
        return cantidadRec;
    }

    public void setCantidadRec(BigDecimal cantidadRec) {
        this.cantidadRec = cantidadRec;
    }

    public Long getCalidad() {
        return calidad;
    }

    public void setCalidad(Long calidad) {
        this.calidad = calidad;
    }

    public BigDecimal getCantCal() {
        return cantCal;
    }

    public void setCantCal(BigDecimal cantCal) {
        this.cantCal = cantCal;
    }

    public Date getFechaPromesa() {
        return fechaPromesa;
    }

    public void setFechaPromesa(Date fechaPromesa) {
        this.fechaPromesa = fechaPromesa;
    }

    public Date getFechaSurtido() {
        return fechaSurtido;
    }

    public void setFechaSurtido(Date fechaSurtido) {
        this.fechaSurtido = fechaSurtido;
    }

    public BigDecimal getCantSurtida() {
        return cantSurtida;
    }

    public void setCantSurtida(BigDecimal cantSurtida) {
        this.cantSurtida = cantSurtida;
    }

    public Ordenenc getOrdenenc() {
        return ordenenc;
    }

    public void setOrdenenc(Ordenenc ordenenc) {
        this.ordenenc = ordenenc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detordenPK != null ? detordenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detorden)) {
            return false;
        }
        Detorden other = (Detorden) object;
        if ((this.detordenPK == null && other.detordenPK != null) || (this.detordenPK != null && !this.detordenPK.equals(other.detordenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Detorden[ detordenPK=" + detordenPK + " ]";
    }
    
}
