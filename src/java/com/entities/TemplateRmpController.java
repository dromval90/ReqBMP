package com.entities;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "templateRmpController")
@ViewScoped
public class TemplateRmpController extends AbstractController<TemplateRmp> implements Serializable {

    @EJB
    private TemplateRmpFacade ejbFacade;
    @EJB
    private ProductosFacade productosFacade;
    
    List <Productos> CatxProd;

    public TemplateRmpController() {
        super(TemplateRmp.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        LoginBean lb= new LoginBean();	
        short codCia = lb.sscia();
        this.getSelected().setTemplateRmpPK(new com.entities.TemplateRmpPK(codCia, null));
        this.getSelected();
    }

    public ProductosFacade getProductosFacade() {
        return productosFacade;
    }

    public void setProductosFacade(ProductosFacade productosFacade) {
        this.productosFacade = productosFacade;
    }
    
    
    public List<Productos> getCatxProd() {
        try{
            String varcodcat= "61";
           CatxProd = productosFacade.findCategoria(varcodcat);
        
        }catch(Exception ex){
                 ex.printStackTrace();
        }  
        return CatxProd;
    }

     public void saveTemplateRmp() {
         this.getSelected().getTemplateRmpPK().setCodProd(this.getSelected().getProductos().getProductosPK().getCodProd());
         this.getSelected().setCodigoUnidad(this.getSelected().getUnidades().getCodigoUnidad());
         this.saveNew(null);
    }
}
