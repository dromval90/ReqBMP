package com.entities;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "detordenController")
@ViewScoped


public class DetordenController extends AbstractController<Detorden> implements Serializable {
    
    @EJB
    private DetordenFacade ejbFacade;
    
    List<Detorden> ListDetorden;
    
    String numOrden;

    public DetordenController() {
        super(Detorden.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDetordenPK().setCodCia(this.getSelected().getOrdenenc().getOrdenencPK().getCodCia());
        this.getSelected().getDetordenPK().setNumOrden(this.getSelected().getOrdenenc().getOrdenencPK().getNumOrden());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDetordenPK(new com.entities.DetordenPK());
    }
    
    @Override
    public void saveNew(ActionEvent event) {
        

    }
    
    public List<Detorden> getListDetorden() {
            return ListDetorden;
    }

    public void setListDetorden(List<Detorden> ListDetorden) {
        this.ListDetorden = ListDetorden;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }
    
    public void BuscarRequesicion(){
        try{
            if(numOrden != null && !(numOrden.equals(""))){
                LoginBean lb= new LoginBean();	
                short codCia = lb.sscia();
                this.setListDetorden(ejbFacade.findNumOrden(codCia, numOrden));
                this.getListDetorden();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
    
    
    
    
}
