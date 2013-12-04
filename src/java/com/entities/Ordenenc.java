/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "ORDENENC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenenc.findAll", query = "SELECT o FROM Ordenenc o"),
    @NamedQuery(name = "Ordenenc.findByNumOrden", query = "SELECT o FROM Ordenenc o WHERE o.ordenencPK.numOrden = :numOrden"),
    @NamedQuery(name = "Ordenenc.findByFechaOrden", query = "SELECT o FROM Ordenenc o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Ordenenc.findByCodCia", query = "SELECT o FROM Ordenenc o WHERE o.ordenencPK.codCia = :codCia"),
    @NamedQuery(name = "Ordenenc.findByCodigoGrupo", query = "SELECT o FROM Ordenenc o WHERE o.codigoGrupo = :codigoGrupo"),
    @NamedQuery(name = "Ordenenc.findByCodEmp", query = "SELECT o FROM Ordenenc o WHERE o.codEmp = :codEmp"),
    @NamedQuery(name = "Ordenenc.findBySolicitante", query = "SELECT o FROM Ordenenc o WHERE o.solicitante = :solicitante"),
    @NamedQuery(name = "Ordenenc.findByNumPedido", query = "SELECT o FROM Ordenenc o WHERE o.numPedido = :numPedido"),
    @NamedQuery(name = "Ordenenc.findByCodProv", query = "SELECT o FROM Ordenenc o WHERE o.codProv = :codProv"),
    @NamedQuery(name = "Ordenenc.findByFormaPago", query = "SELECT o FROM Ordenenc o WHERE o.formaPago = :formaPago"),
    @NamedQuery(name = "Ordenenc.findByVia", query = "SELECT o FROM Ordenenc o WHERE o.via = :via"),
    @NamedQuery(name = "Ordenenc.findByNumDias", query = "SELECT o FROM Ordenenc o WHERE o.numDias = :numDias"),
    @NamedQuery(name = "Ordenenc.findByObservaciones", query = "SELECT o FROM Ordenenc o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "Ordenenc.findByProyecto", query = "SELECT o FROM Ordenenc o WHERE o.proyecto = :proyecto"),
    @NamedQuery(name = "Ordenenc.findByStatus", query = "SELECT o FROM Ordenenc o WHERE o.status = :status"),
    @NamedQuery(name = "Ordenenc.findByAutorizado", query = "SELECT o FROM Ordenenc o WHERE o.autorizado = :autorizado"),
    @NamedQuery(name = "Ordenenc.findByFechautorizado", query = "SELECT o FROM Ordenenc o WHERE o.fechautorizado = :fechautorizado"),
    @NamedQuery(name = "Ordenenc.findByAtendio", query = "SELECT o FROM Ordenenc o WHERE o.atendio = :atendio"),
    @NamedQuery(name = "Ordenenc.findByAnulado", query = "SELECT o FROM Ordenenc o WHERE o.anulado = :anulado"),
    @NamedQuery(name = "Ordenenc.findByFechaanulado", query = "SELECT o FROM Ordenenc o WHERE o.fechaanulado = :fechaanulado"),
    @NamedQuery(name = "Ordenenc.findByNumReq", query = "SELECT o FROM Ordenenc o WHERE o.numReq = :numReq"),
    @NamedQuery(name = "Ordenenc.findByAnio", query = "SELECT o FROM Ordenenc o WHERE o.anio = :anio"),
    @NamedQuery(name = "Ordenenc.findByCoddeptoSol", query = "SELECT o FROM Ordenenc o WHERE o.coddeptoSol = :coddeptoSol"),
    @NamedQuery(name = "Ordenenc.findByUsuario", query = "SELECT o FROM Ordenenc o WHERE o.usuario = :usuario"),
    @NamedQuery(name = "Ordenenc.findByFechaIng", query = "SELECT o FROM Ordenenc o WHERE o.fechaIng = :fechaIng"),
    @NamedQuery(name = "Ordenenc.findByAutorizada", query = "SELECT o FROM Ordenenc o WHERE o.autorizada = :autorizada"),
    @NamedQuery(name = "Ordenenc.findByCodCat", query = "SELECT o FROM Ordenenc o WHERE o.codCat = :codCat"),
    @NamedQuery(name = "Ordenenc.findByTipoOrden", query = "SELECT o FROM Ordenenc o WHERE o.tipoOrden = :tipoOrden"),
    @NamedQuery(name = "Ordenenc.findByZapateria", query = "SELECT o FROM Ordenenc o WHERE o.zapateria = :zapateria"),
    @NamedQuery(name = "Ordenenc.findByPlanta", query = "SELECT o FROM Ordenenc o WHERE o.planta = :planta"),
    @NamedQuery(name = "Ordenenc.findByCreatedAt", query = "SELECT o FROM Ordenenc o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Ordenenc.findByUpdatedAt", query = "SELECT o FROM Ordenenc o WHERE o.updatedAt = :updatedAt")})
public class Ordenenc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenencPK ordenencPK;
   
    
    @Column(name = "FECHA_ORDEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO_GRUPO")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EMP")
    private int codEmp;
     @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_EMP", referencedColumnName = "COD_EMP", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
     private Empleados empleados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITANTE")
    private int solicitante;
     @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "SOLICITANTE", referencedColumnName = "COD_EMP", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
     private Empleados empleados2;
    @Column(name = "NUM_PEDIDO")
    private String numPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_PROV")
    private String codProv;
    @Size(max = 1)
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Size(max = 1)
    @Column(name = "VIA")
    private String via;
    @Column(name = "NUM_DIAS")
    private Short numDias;
    @Size(max = 150)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PROYECTO")
    private String proyecto;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 150)
    @Column(name = "AUTORIZADO")
    private String autorizado;
    @Column(name = "FECHAUTORIZADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechautorizado;
    @Size(max = 30)
    @Column(name = "ATENDIO")
    private String atendio;
    @Size(max = 15)
    @Column(name = "ANULADO")
    private String anulado;
    @Column(name = "FECHAANULADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaanulado;
    @Size(max = 10)
    @Column(name = "NUM_REQ")
    private String numReq;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "CODDEPTO_SOL")
    private Short coddeptoSol;
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODDEPTO_SOL", referencedColumnName = "COD_DEPTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "FECHA_ING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIng;
    @Size(max = 1)
    @Column(name = "AUTORIZADA")
    private String autorizada;
    @Size(max = 3)
    @Column(name = "COD_CAT")
    private String codCat;
     @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_CAT", referencedColumnName = "COD_CAT", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
     private Categorias categorias;
    @Basic(optional = false)
    @NotNull
    @Size(max = 1)
    @Column(name = "TIPO_ORDEN")
    private String tipoOrden;
    @Size(max = 1)
    @Column(name = "ZAPATERIA")
    private String zapateria;
    @Size(max = 1)
    @Column(name = "PLANTA")
    private String planta;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenenc")
    private List<Detorden> detordenList;


    public Ordenenc() {
    }

    public Ordenenc(OrdenencPK ordenencPK) {
        this.ordenencPK = ordenencPK;
    }

    public Ordenenc(OrdenencPK ordenencPK, String codigoGrupo, int codEmp, int solicitante, String codProv, String proyecto) {
        this.ordenencPK = ordenencPK;
        this.codigoGrupo = codigoGrupo;
        this.codEmp = codEmp;
        this.solicitante = solicitante;
        this.codProv = codProv;
        this.proyecto = proyecto;
    }

    public Ordenenc(String numOrden, short codCia) {
        this.ordenencPK = new OrdenencPK(numOrden, codCia);
    }

    public OrdenencPK getOrdenencPK() {
        return ordenencPK;
    }

    public void setOrdenencPK(OrdenencPK ordenencPK) {
        this.ordenencPK = ordenencPK;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public int getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(int solicitante) {
        this.solicitante = solicitante;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Short getNumDias() {
        return numDias;
    }

    public void setNumDias(Short numDias) {
        this.numDias = numDias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public Date getFechautorizado() {
        return fechautorizado;
    }

    public void setFechautorizado(Date fechautorizado) {
        this.fechautorizado = fechautorizado;
    }

    public String getAtendio() {
        return atendio;
    }

    public void setAtendio(String atendio) {
        this.atendio = atendio;
    }

    public String getAnulado() {
        return anulado;
    }

    public void setAnulado(String anulado) {
        this.anulado = anulado;
    }

    public Date getFechaanulado() {
        return fechaanulado;
    }

    public void setFechaanulado(Date fechaanulado) {
        this.fechaanulado = fechaanulado;
    }

    public String getNumReq() {
        return numReq;
    }

    public void setNumReq(String numReq) {
        this.numReq = numReq;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public Short getCoddeptoSol() {
        return coddeptoSol;
    }

    public void setCoddeptoSol(Short coddeptoSol) {
        this.coddeptoSol = coddeptoSol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getAutorizada() {
        return autorizada;
    }

    public void setAutorizada(String autorizada) {
        this.autorizada = autorizada;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public String getZapateria() {
        return zapateria;
    }

    public void setZapateria(String zapateria) {
        this.zapateria = zapateria;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<Detorden> getDetordenList() {
        return detordenList;
    }

    public void setDetordenList(List<Detorden> detordenList) {
        this.detordenList = detordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenencPK != null ? ordenencPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenenc)) {
            return false;
        }
        Ordenenc other = (Ordenenc) object;
        if ((this.ordenencPK == null && other.ordenencPK != null) || (this.ordenencPK != null && !this.ordenencPK.equals(other.ordenencPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Ordenenc[ ordenencPK=" + ordenencPK + " ]";
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Empleados getEmpleados2() {
        return empleados2;
    }

    public void setEmpleados2(Empleados empleados2) {
        this.empleados2 = empleados2;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }
    
    
    
    
}
