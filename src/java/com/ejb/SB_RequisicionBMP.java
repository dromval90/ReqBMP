/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entities.Detorden;
import com.entities.DetordenFacade;
import com.entities.Documento;
import com.entities.DocumentoController;
import com.entities.DocumentoFacade;
import com.entities.DocumentoPK;
import com.entities.Ordenenc;
import com.entities.OrdenencFacade;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dromero
 */
@Stateless
public class SB_RequisicionBMP {
    @EJB
    private EmailBean emailBean;
    @EJB
    private DocumentoFacade documentoFacade;
    @EJB
    private DetordenFacade detordenFacade;
    @EJB
    private OrdenencFacade ordenencFacade;
    
    
    
   
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   public void insertarRequisicion(Ordenenc EncOrden, List<Detorden> DetalleReq){
       try{
           ordenencFacade.edit(EncOrden);
           for(Detorden DetReq : DetalleReq){
                DetReq.setValorreq(DetReq.getCantidad().multiply(DetReq.getPreciouni()));
                detordenFacade.edit(DetReq);
            }
           this.insertarParaAutorizacion(EncOrden);
       }catch(Exception ex){
           System.out.println("Error");
       }      
   }
   
    public void insertarParaAutorizacion(Ordenenc EncOrden){
        try{
            //DocumentoController docAutorizacion = new DocumentoController();
            Documento docAutorizacion = new Documento();
            DocumentoPK PKdocumento = new DocumentoPK();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            PKdocumento.setCodCia(EncOrden.getOrdenencPK().getCodCia());
            PKdocumento.setCodDepto(EncOrden.getCoddeptoSol());
            PKdocumento.setCodTipoDocto("RMP");
            PKdocumento.setNumDocto(EncOrden.getOrdenencPK().getNumOrden());
            PKdocumento.setNumCaso(1);
            //docAutorizacion.setSelected(docaut);
            docAutorizacion.setDocumentoPK(PKdocumento);
            docAutorizacion.setFechaDocto(EncOrden.getFechaOrden());
            docAutorizacion.setStatusDocto("P");
            docAutorizacion.setObservaciones(EncOrden.getObservaciones());
            docAutorizacion.setDescripcion("RMP-PROV."+EncOrden.getCodProv() + " " + formato.format(EncOrden.getFechaOrden()));
            documentoFacade.edit(docAutorizacion);
            //emailBean.sendMessage(null, null, null);
        }catch(Exception ex){
            System.out.println("Error2");
        }
    }

}
