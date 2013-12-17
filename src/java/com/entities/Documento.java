/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author dromero
 */
@Entity
@Table(name = "DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByNumDocto", query = "SELECT d FROM Documento d WHERE d.documentoPK.codCia = :codCia and d.documentoPK.numDocto = :numDocto and d.documentoPK.codDepto = :codDepto and d.documentoPK.codTipoDocto = :codTipoDocto"),
    @NamedQuery(name = "Documento.findByCodCia", query = "SELECT d FROM Documento d WHERE d.documentoPK.codCia = :codCia"),
    @NamedQuery(name = "Documento.findByCodDepto", query = "SELECT d FROM Documento d WHERE d.documentoPK.codDepto = :codDepto"),
    @NamedQuery(name = "Documento.findByCodTipoDocto", query = "SELECT d FROM Documento d WHERE d.documentoPK.codTipoDocto = :codTipoDocto"),
    @NamedQuery(name = "Documento.findByNumCaso", query = "SELECT d FROM Documento d WHERE d.documentoPK.numCaso = :numCaso"),
    @NamedQuery(name = "Documento.findByFechaDocto", query = "SELECT d FROM Documento d WHERE d.fechaDocto = :fechaDocto"),
    @NamedQuery(name = "Documento.findByStatusDocto", query = "SELECT d FROM Documento d WHERE d.statusDocto = :statusDocto"),
    @NamedQuery(name = "Documento.findByObservaciones", query = "SELECT d FROM Documento d WHERE d.observaciones = :observaciones"),
    @NamedQuery(name = "Documento.findByDescripcion", query = "SELECT d FROM Documento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Documento.findByValor", query = "SELECT d FROM Documento d WHERE d.valor = :valor"),
    @NamedQuery(name = "Documento.findByUsuario", query = "SELECT d FROM Documento d WHERE d.usuario = :usuario"),
    @NamedQuery(name = "Documento.findByEnvioCorreo", query = "SELECT d FROM Documento d WHERE d.envioCorreo = :envioCorreo")})
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected com.entities.DocumentoPK documentoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DOCTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_DOCTO")
    private String statusDocto;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "ENVIO_CORREO")
    private Short envioCorreo;

    public Documento() {
    }

    public Documento(com.entities.DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(com.entities.DocumentoPK documentoPK, Date fechaDocto, String statusDocto) {
        this.documentoPK = documentoPK;
        this.fechaDocto = fechaDocto;
        this.statusDocto = statusDocto;
    }

    public Documento(short codCia, short codDepto, String codTipoDocto, String numDocto, long numCaso) {
        this.documentoPK = new DocumentoPK(codCia, codDepto, codTipoDocto, numDocto, numCaso);
    }

    public com.entities.DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(com.entities.DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Date getFechaDocto() {
        return fechaDocto;
    }

    public void setFechaDocto(Date fechaDocto) {
        this.fechaDocto = fechaDocto;
    }

    public String getStatusDocto() {
        return statusDocto;
    }

    public void setStatusDocto(String statusDocto) {
        this.statusDocto = statusDocto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Short getEnvioCorreo() {
        return envioCorreo;
    }

    public void setEnvioCorreo(Short envioCorreo) {
        this.envioCorreo = envioCorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
