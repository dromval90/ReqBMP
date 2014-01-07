package com.entities;

import com.ejb.SB_RequisicionBMP;
import com.entities.util.JsfUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;

@ManagedBean(name = "detordenController")
@ViewScoped


public class DetordenController extends AbstractController<Detorden> implements Serializable {
    @EJB
    private OrdenencFacade ordenencFacade;
    @EJB
    private SB_RequisicionBMP sB_RequisicionBMP;
    
    @EJB
    private DetordenFacade ejbFacade;
    
    
    
    List<Detorden> ListDetorden;
    List<Ordenenc> ListOrdenenc;
    
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

    public SB_RequisicionBMP getsB_RequisicionBMP() {
        return sB_RequisicionBMP;
    }

    public void setsB_RequisicionBMP(SB_RequisicionBMP sB_RequisicionBMP) {
        this.sB_RequisicionBMP = sB_RequisicionBMP;
    }

    public OrdenencFacade getOrdenencFacade() {
        return ordenencFacade;
    }

    public void setOrdenencFacade(OrdenencFacade ordenencFacade) {
        this.ordenencFacade = ordenencFacade;
    }
    
    public List<Ordenenc> getListOrdenenc() {
        return ListOrdenenc;
    }

    public void setListOrdenenc(List<Ordenenc> ListOrdenenc) {
        this.ListOrdenenc = ListOrdenenc;
    }
    
    
    
    public void BuscarRequesicion(){
        String msg="";
        try{
            this.setListDetorden(null);
            if(numOrden != null && !(numOrden.equals(""))){
                LoginBean lb= new LoginBean();	
                short codCia = lb.sscia();
                this.ListOrdenenc = ordenencFacade.findDocAutorizados(codCia, numOrden);
                if(this.ListOrdenenc.size() > 0){
                    this.setListDetorden(ejbFacade.findNumOrden(codCia, numOrden));
                }else{
                     this.ListOrdenenc = ordenencFacade.findByNumOrden(codCia, numOrden);
                     for(Ordenenc Oenc : this.ListOrdenenc){
                         if(Oenc.getStatus().equals("A")){
                             msg = "La Requisicion No." + numOrden + " Esta Anulada";
                         }else if(Oenc.getStatus().equals("C")){
                             msg = "La Requisicion No." + numOrden + " ha sido Completada";
                         }else if(Oenc.getAutorizado()== null && Oenc.getFechautorizado() == null){
                             msg = "La Requisicion No." + numOrden + " no ha sido Autorizada";
                         }
                     }
                     
                     JsfUtil.addErrorMessage(msg);
               }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
    
     public void onCellEdit(CellEditEvent event) {        
         String msg="";
         Date hoy = new Date();
         try{
             if(this.getSelected().getCantSurtida() != null){
                 if(this.getSelected().getCantSurtida().doubleValue() <= this.getSelected().getCantidad().doubleValue() && this.getSelected().getCantSurtida().doubleValue() > 0){
                      this.getSelected().setFechaSurtido(hoy);
                      msg ="Registro Modificado Correctamente";
                      JsfUtil.addSuccessMessage(msg);
                      this.getSelected().getFechaSurtido();
                 }else{
                     this.getSelected().setCantSurtida(null);
                     msg ="La Cantidad Surtida es Mayor que la Cantidad Solicitada";
                     JsfUtil.addErrorMessage(msg);
                 }
            }else{
                this.getSelected().setCantSurtida(null);
                msg ="La Cantidad Surtida es Nula";
                JsfUtil.addErrorMessage(msg);
            }
         }catch(Exception ex){
             ex.printStackTrace();
         }
    }  
     
   public void onCellEditRecibido(CellEditEvent event){
       String msg="";
       Date hoy = new Date();
       try{
           if(this.getSelected().getCantidadRec()!= null){
                 this.getSelected().setFecharecibido(hoy);
            }else{
                this.getSelected().setCantidadRec(null);
                msg ="La Cantidad Recibida es Nula";
                JsfUtil.addErrorMessage(msg);
            }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
     
     public void surtir(){
       String msg="";
       msg = sB_RequisicionBMP.surtirRequisicion(this.getListDetorden());
       JsfUtil.addSuccessMessage(msg);
     }
    
    public void recibir(){
       String msg="";
       msg = sB_RequisicionBMP.recibirRequisicion(this.getListDetorden());
       JsfUtil.addSuccessMessage(msg);
    }
    
    
    
}
