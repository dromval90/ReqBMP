/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dromero
 */
@Entity
@Table(name = "TEMPLATE_RMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TemplateRmp.findAll", query = "SELECT t FROM TemplateRmp t"),
    @NamedQuery(name = "TemplateRmp.findByCodCia", query = "SELECT t FROM TemplateRmp t WHERE t.templateRmpPK.codCia = :codCia"),
    @NamedQuery(name = "TemplateRmp.findByCodProd", query = "SELECT t FROM TemplateRmp t WHERE t.templateRmpPK.codProd = :codProd"),
    @NamedQuery(name = "TemplateRmp.findByNombreProdTemplate", query = "SELECT t FROM TemplateRmp t WHERE t.nombreProdTemplate = :nombreProdTemplate")})
public class TemplateRmp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected com.entities.TemplateRmpPK templateRmpPK;
    @Size(max = 200)
    @Column(name = "NOMBRE_PROD_TEMPLATE")
    private String nombreProdTemplate;
    
    @Column(name = "CODIGO_UNIDAD")
    private Short codigoUnidad;
    
    @JoinColumns({
        @JoinColumn(name = "CODIGO_UNIDAD", referencedColumnName = "CODIGO_UNIDAD", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
     private Unidades unidades;
    
    @JoinColumns({
        @JoinColumn(name = "COD_CIA", referencedColumnName = "COD_CIA", insertable = false, updatable = false),
        @JoinColumn(name = "COD_PROD", referencedColumnName = "COD_PROD", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
     private Productos productos;
    
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;

    public TemplateRmp() {
    }

    public TemplateRmp(com.entities.TemplateRmpPK templateRmpPK) {
        this.templateRmpPK = templateRmpPK;
    }

    public TemplateRmp(short codCia, String codProd) {
        this.templateRmpPK = new TemplateRmpPK(codCia, codProd);
    }

    public com.entities.TemplateRmpPK getTemplateRmpPK() {
        return templateRmpPK;
    }

    public void setTemplateRmpPK(com.entities.TemplateRmpPK templateRmpPK) {
        this.templateRmpPK = templateRmpPK;
    }

    public String getNombreProdTemplate() {
        return nombreProdTemplate;
    }

    public void setNombreProdTemplate(String nombreProdTemplate) {
        this.nombreProdTemplate = nombreProdTemplate;
    }

    public Short getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Short codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public Unidades getUnidades() {
        return unidades;
    }

    public void setUnidades(Unidades unidades) {
        this.unidades = unidades;
    }
    

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (templateRmpPK != null ? templateRmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemplateRmp)) {
            return false;
        }
        TemplateRmp other = (TemplateRmp) object;
        if ((this.templateRmpPK == null && other.templateRmpPK != null) || (this.templateRmpPK != null && !this.templateRmpPK.equals(other.templateRmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.TemplateRmp[ templateRmpPK=" + templateRmpPK + " ]";
    }
    
}
