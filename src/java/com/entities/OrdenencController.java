package com.entities;


import com.ejb.SB_Reportes;
import com.ejb.SB_RequisicionBMP;
import com.entities.util.JsfUtil;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;

@ManagedBean(name = "ordenencController")
@ViewScoped

public class OrdenencController extends AbstractController<Ordenenc> implements Serializable {
    @EJB
    private SB_Reportes reportes;
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
    @EJB
    private OrdenencFacade ordenencFacade;
    
    
    
    
    List <Productos> CatxProd;
    Detorden DetalleRequisicion;
    List <Detorden> detorden ;
    List <Detorden> listDetorden;
    List<Ordenenc> listOrdenenc;
  
    
    public OrdenencController() {
        super(Ordenenc.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);  
        this.detorden = new ArrayList<Detorden>();
    }

    /**
    *initializeEmbeddableKey 
    * Inicializa el Encabezado de la Requisicion de Materia Prima
    * Siempre se inicializaran los datos del solicitante, en base a los datos de su sesion
    * Los Campos Inicializados manualmente, son segun la inicializacion de las Requisiciones de Papeleria
    * @author       Daniel Romero
    * @version      1.0
    */
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
            this.getSelected().setOrdenencPK(new com.entities.OrdenencPK(null,codCia));
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


    public List<Detorden> getListDetorden() {
         if(this.getSelected()!=null ){
            this.setListDetorden(detordenFacade.findNumOrden(this.getSelected().getOrdenencPK().getCodCia(), this.getSelected().getOrdenencPK().getNumOrden()));
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

    public List<Ordenenc> getListOrdenenc() {
        this.listOrdenenc = ejbFacade.findDocAutorizados();
        return listOrdenenc;
    }

    public void setListOrdenenc(List<Ordenenc> listOrdenenc) {
        this.listOrdenenc = listOrdenenc;
    }

    public OrdenencFacade getOrdenencFacade() {
        return ordenencFacade;
    }

    public void setOrdenencFacade(OrdenencFacade ordenencFacade) {
        this.ordenencFacade = ordenencFacade;
    }   
    
    
     /**
    *List<Productos>
    * Se Recuperan los Productos Correspondiente a la Categoria Seleccionada
    * @author       Daniel Romero
    * @version      1.0
    */
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
    
    /**
    *prepareCreate2
    * Se Inicializa el detalle de la Requisicion, para cada producto que se quiera agregar
    * @author       Daniel Romero
    * @version      1.0
    */
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
  
    
     /**
    *addDetalleRequisicion
    * Se agrega al objeto lista this.DetalleRequisicion, el detalle de la requisicion
    * @author       Daniel Romero
    * @version      1.0
    */
    public void addDetalleRequisicion(){
        
       try{
            this.DetalleRequisicion.getDetordenPK().setCodProd(this.DetalleRequisicion.getProductos().getProductosPK().getCodProd());
            this.DetalleRequisicion.setOrdenenc(this.getSelected()); 
            this.DetalleRequisicion.setNombre(this.DetalleRequisicion.getProductos().getNombre());
            this.DetalleRequisicion.setCodigoUnidad(this.DetalleRequisicion.getUnidades().getCodigoUnidad());
            this.DetalleRequisicion.setPreciouni(this.DetalleRequisicion.getProductos().getCosto());
            this.DetalleRequisicion.setFecharequerido(this.getSelected().getFechaOrden());
            this.DetalleRequisicion.setRecibido("G");
            this.getDetorden().add(this.getDetalleRequisicion());   
            JsfUtil.addSuccessMessage("Producto Agregado Correctamente");
       }catch(Exception ex){
           ex.toString();
       }
            
       
    }
    
     /**
    *deleteDetalleRequisicion
    * Se Elimina del objeto lista this.DetalleRequisicion, el detalle de la requisicion
    * @author       Daniel Romero
    * @version      1.0
    */
    public void deleteDetalleRequisicion(Detorden SelectDetOrden){
        try{
           this.getDetorden().remove(SelectDetOrden);
           JsfUtil.addSuccessMessage("Producto Eliminado Correctamente");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
     /**
    *saveNewRequisicion
    * Se Procesa la informacion almacenada en los objetos getSelected(), this.getDetorden()
    * para realizar la persistencia
    * @author       Daniel Romero
    * @version      1.0
    */
    public void saveNewRequisicion(){
        String msg ="";
        String numOrden="";
        numOrden = ordenencFacade.findPk();
        this.getSelected().getOrdenencPK().setNumOrden(numOrden);
        this.getSelected().setCodCat(this.getSelected().getCategorias().getCategoriasPK().getCodCat());
        msg = sB_RequisicionBMP.insertarRequisicion(this.getSelected(), this.getDetorden());
        JsfUtil.addSuccessMessage(msg);
    }
    
    
     /**
    *AnularReq
    * Se Procesa la informacion para la anulacion de una Requisicion de Materia Prima
    * @author       Daniel Romero
    * @version      1.0
    */
    public void AnularReq(){
        String msg="";
        msg = sB_RequisicionBMP.AnularRequisicion(this.getSelected());
        JsfUtil.addSuccessMessage( msg);
    }
    
     /**
    *imprimirRequisicion
    * Procesa la Peticion de Impresion de Una Requisicion, luego de su autorizacion
    * @author       Daniel Romero
    * @version      1.0
    */
    public String imprimirRequisicion() throws NamingException, SQLException, JRException, IOException{
        //try{
            HashMap params = new HashMap();  
            
            params.put("codCia", this.getSelected().getOrdenencPK().getCodCia()); 
            params.put("numOrden",this.getSelected().getOrdenencPK().getNumOrden() );
            reportes.GenerarReporte("/reportes/RMPprincipal.jasper", params);    
        /*}catch(Exception ex){
            ex.printStackTrace();
        }    */
        return "";
    }
    
    public void cargarPlantilla(){
        
    }
    
    
}
