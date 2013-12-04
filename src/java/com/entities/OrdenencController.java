package com.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
   
      List <Productos> CatxProd;
    @EJB
    private ProductosFacade productosFacade;

    @EJB
    private OrdenencFacade ejbFacade;

    Detorden DetalleRequisicion;
    List <Detorden> detorden;
    
  
    
    public OrdenencController() {
        super(Ordenenc.class);
    }

    @PostConstruct
    public void init() {
        
        super.setFacade(ejbFacade);  
       
    }

    @Override
    protected void initializeEmbeddableKey() {
    
        this.getSelected().setOrdenencPK(new com.entities.OrdenencPK());
    }

    public Detorden getDetalleRequisicion() {
        return DetalleRequisicion;
    }

    public void setDetalleRequisicion(Detorden DetalleRequisicion) {
        this.DetalleRequisicion = DetalleRequisicion;
    }

    public List<Detorden> getDetorden() {
        return detorden;
    }

    public void setDetorden(List<Detorden> detorden) {
        this.detorden = detorden;
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
    

  
       /* public Detorden prepareCreate2() {

        try {
              String var;
              var= OrdenencController.this.getSelected().getCodCat();
              Detorden newItem;  
            newItem = Detorden.class.newInstance();
            this.DetalleRequisicion = newItem;
            //initializeEmbeddableKey();
            this.DetalleRequisicion.setDetordenPK(new com.entities.DetordenPK());
            
            return newItem;
        } catch (InstantiationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
    
    public Detorden prepareCreate2(ActionEvent event) {
        Detorden newItem;
        try {
            //short codcia = this.getSelected().getOrdenencPK().getCodCia();
            newItem = Detorden.class.newInstance();
            this.DetalleRequisicion = newItem;
            //initializeEmbeddableKey();
            return newItem;
            
                /*String orden = this.getSelected().getOrdenencPK().getNumOrden();
                BigDecimal cat = new BigDecimal(this.getSelected().getCodCat());
                String prod = "111";
                DetordenPK PK = new DetordenPK(orden,codcia,prod);
                this.DetalleRequisicion.setDetordenPK(PK);
                this.DetalleRequisicion.setCantidad(cat);
        
                String a = this.DetalleRequisicion.getDetordenPK().getCodProd();
                System.out.print(a);*/
        } catch (InstantiationException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

  
    
    
    
    
}
