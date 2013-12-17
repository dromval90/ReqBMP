package com.entities;


import com.ejb.SB_RequisicionBMP;
import com.entities.util.JsfUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "ordenencController")
@ViewScoped

public class OrdenencController extends AbstractController<Ordenenc> implements Serializable {
    @EJB
    private DetordenFacade detordenFacade;
    @EJB
    private SB_RequisicionBMP sB_RequisicionBMP;

    @EJB
    private CategoriasFacade categoriasFacade;
    @EJB
    private EmpleadosFacade empleadosFacade;
   
    @EJB
    private ProductosFacade productosFacade;

    @EJB
    private OrdenencFacade ejbFacade;
    
    
    
    
    
    List <Productos> CatxProd;

    Detorden DetalleRequisicion;
    List <Detorden> detorden ;
    List <Detorden> listDetorden;
    
  
    
    public OrdenencController() {
        super(Ordenenc.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);  
        this.detorden = new ArrayList<Detorden>();
    }

    @Override
    protected void initializeEmbeddableKey() {  
        
        try{
            LoginBean lb= new LoginBean();	
            short codCia = lb.sscia();
            Empleados emp = new Empleados();
            emp = empleadosFacade.findbyUsuario(lb.ssuser());	    
            this.getSelected().setEmpleados(emp);
            this.getSelected().setCodEmp(emp.getEmpleadosPK().getCodEmp());
            this.getSelected().setSolicitante(emp.getEmpleadosPK().getCodEmp());
            this.getSelected().setEmpleados2(emp);
            this.getSelected().setCoddeptoSol(emp.getDepartamentos().getDepartamentosPK().getCodDepto());
            this.getSelected().setDepartamentos(emp.getDepartamentos());
            this.getSelected().setProyecto(emp.getDepartamentos().getProyecto());
            Date hoy = new Date();
            this.getSelected().setFechaIng(hoy);
            this.getSelected().setFechaOrden(hoy);
            this.getSelected().setFormaPago("R");
            this.getSelected().setNumDias((short)30);
            this.getSelected().setZapateria("S");
            this.getSelected().setPlanta("N");
            this.getSelected().setAutorizada("N");
            this.getSelected().setStatus("D");
            this.getSelected().setVia("L");
            this.getSelected().setUsuario(lb.ssuser());
            this.getSelected().setOrdenencPK(new com.entities.OrdenencPK("49166",codCia));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public Detorden getDetalleRequisicion() {
        return DetalleRequisicion;
    }

    public void setDetalleRequisicion(Detorden DetalleRequisicion) {
        this.DetalleRequisicion = DetalleRequisicion;
    }

    /* public List<Detorden> getDetorden() {
    if(this.getSelected()!=null ){
    this.setDetorden(detordenFacade.findNumOrden(this.getSelected().getOrdenencPK().getCodCia(), this.getSelected().getOrdenencPK().getNumOrden()));
    return detorden;
    }
    return detorden;
    }*/
    public List<Detorden> getListDetorden() {
         if(this.getSelected()!=null ){
            this.setDetorden(detordenFacade.findNumOrden(this.getSelected().getOrdenencPK().getCodCia(), this.getSelected().getOrdenencPK().getNumOrden()));
            return listDetorden;
        }
        return listDetorden;
    }
  
     public void setListDetorden(List<Detorden> listDetorden) {
        this.listDetorden = listDetorden;
    }
    
    
    public List<Detorden> getDetorden() {
        return detorden;
    }

    public void setDetorden(List<Detorden> detorden) {
        this.detorden = detorden;
    }

    public EmpleadosFacade getEmpleadosFacade() {
        return empleadosFacade;
    }

    public void setEmpleadosFacade(EmpleadosFacade empleadosFacade) {
        this.empleadosFacade = empleadosFacade;
    }

    public ProductosFacade getProductosFacade() {
        return productosFacade;
    }

    public void setProductosFacade(ProductosFacade productosFacade) {
        this.productosFacade = productosFacade;
    }

    public CategoriasFacade getCategoriasFacade() {
        return categoriasFacade;
    }

    public void setCategoriasFacade(CategoriasFacade categoriasFacade) {
        this.categoriasFacade = categoriasFacade;
    }

    public OrdenencFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(OrdenencFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
       

    public List<Productos> getCatxProd() {
        try{
            String varcodcat= this.getSelected().getCategorias().getCategoriasPK().getCodCat();
           CatxProd = productosFacade.findCategoria(varcodcat);
        
        }catch(Exception ex){
                 ex.printStackTrace();
        }  
        return CatxProd;
    }

    public void setCatxProd(List<Productos> CatxProd) {
        this.CatxProd = CatxProd;
    }
    
    public Detorden prepareCreate2(ActionEvent event) {
        Detorden newItem;
        try {           
             newItem = Detorden.class.newInstance();
             this.DetalleRequisicion = newItem;
             DetordenPK PKdetorden = new DetordenPK(this.getSelected().getOrdenencPK().getNumOrden(),this.getSelected().getOrdenencPK().getCodCia(),null);
             this.DetalleRequisicion.setDetordenPK(PKdetorden);
             return newItem;
        } catch (InstantiationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public void addDetalleRequisicion(){
        
       try{
            this.DetalleRequisicion.getDetordenPK().setCodProd(this.DetalleRequisicion.getProductos().getProductosPK().getCodProd());
            this.DetalleRequisicion.setOrdenenc(this.getSelected()); 
            this.DetalleRequisicion.setNombre(this.DetalleRequisicion.getProductos().getNombre());
            this.DetalleRequisicion.setPreciouni(this.DetalleRequisicion.getProductos().getCosto());
            this.DetalleRequisicion.setFecharequerido(this.getSelected().getFechaOrden());
            this.DetalleRequisicion.setRecibido("G");
            this.getDetorden().add(this.getDetalleRequisicion());   
            JsfUtil.addSuccessMessage("Producto Agregado Correctamente");
       }catch(Exception ex){
           ex.toString();
       }
            
       
    }
    
    public void deleteDetalleRequisicion(Detorden SelectDetOrden){
        try{
           this.getDetorden().remove(SelectDetOrden);
           JsfUtil.addSuccessMessage("Producto Eliminado Correctamente");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void saveNewRequisicion(){
        String msg ="";
        this.getSelected().setCodCat(this.getSelected().getCategorias().getCategoriasPK().getCodCat());
        msg = sB_RequisicionBMP.insertarRequisicion(this.getSelected(), this.getDetorden());
        JsfUtil.addSuccessMessage(msg);
    }
    
    public void AnularReq(){
        String msg="";
        msg = sB_RequisicionBMP.AnularRequisicion(this.getSelected());
        JsfUtil.addSuccessMessage( msg);
    }
    
    
}
