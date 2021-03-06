/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb;

import com.entities.CiasXUsuario;
import com.entities.CiasXUsuarioFacade;
import com.entities.Detorden;
import com.entities.DetordenFacade;
import com.entities.Documento;
import com.entities.DocumentoController;
import com.entities.DocumentoFacade;
import com.entities.DocumentoPK;
import com.entities.FirmasxtipoDocto;
import com.entities.FirmasxtipoDoctoFacade;
import com.entities.LoginBean;
import com.entities.Ordenenc;
import com.entities.OrdenencFacade;
import com.entities.TipoDocumento;
import com.entities.TipoDocumentoFacade;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;

/**
 *
 * @author dromero
 */
@Stateless
public class SB_RequisicionBMP {
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    @EJB
    private CiasXUsuarioFacade ciasXUsuarioFacade;
    @EJB
    private FirmasxtipoDoctoFacade firmasxtipoDoctoFacade;
    @EJB
    private EmailBean emailBean;
    @EJB
    private DocumentoFacade documentoFacade;
    @EJB
    private DetordenFacade detordenFacade;
    @EJB
    private OrdenencFacade ordenencFacade;
    
    
    
    
    
   
   /**
    *insertarRequisicion
    * Proceso de Negocio que permite realizar la persistencia, para almacenar 
    * la Requision de Materia Prima, y invocando al metodo que permite la persistencia
    * para ingresarlo en documentos a autorizar
    * @author       Daniel Romero
    * @version      1.0
    */
   public String insertarRequisicion(Ordenenc EncOrden, List<Detorden> DetalleReq){
       String msg ="";
       try{
           ordenencFacade.edit(EncOrden);
          
           
           msg="**Encabezado Requisicion Almacenado Correctamente";
           for(Detorden DetReq : DetalleReq){
                DetReq.setValorreq(DetReq.getCantidad().multiply(DetReq.getPreciouni()));
                DetReq.getDetordenPK().setNumOrden(EncOrden.getOrdenencPK().getNumOrden());
                DetReq.getOrdenenc().getOrdenencPK().setNumOrden(EncOrden.getOrdenencPK().getNumOrden());
                detordenFacade.edit(DetReq);
            }
           msg+=" **Detalle Requisicion Almacenado Correctamente";
           msg+=this.insertarParaAutorizacion(EncOrden);
     
       }catch(Exception ex){
           msg="Ocurrior Un Error, No pudo completarse el Ingreso de la Requisicion:" + EncOrden.getOrdenencPK().getNumOrden();
       }   
       return msg;
   }
   
    /**
    *insertarParaAutorizacion
    * Proceso de Negocio que permite realizar la persistencia, para almacenar 
    * la Requision de Materia Prima, en las tabla de Documento para su autorizacion
    * @author       Daniel Romero
    * @version      1.0
    */
   
    public String insertarParaAutorizacion(Ordenenc EncOrden){
        String msg ="";
        try{
            Documento docAutorizacion = new Documento();
            DocumentoPK PKdocumento = new DocumentoPK();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            PKdocumento.setCodCia(EncOrden.getOrdenencPK().getCodCia());
            PKdocumento.setCodDepto(EncOrden.getCoddeptoSol());
            PKdocumento.setCodTipoDocto("RMP");
            PKdocumento.setNumDocto(EncOrden.getOrdenencPK().getNumOrden());
            PKdocumento.setNumCaso(1);
            docAutorizacion.setDocumentoPK(PKdocumento);
            docAutorizacion.setFechaDocto(EncOrden.getFechaOrden());
            docAutorizacion.setStatusDocto("P");
            docAutorizacion.setObservaciones(EncOrden.getObservaciones());
            docAutorizacion.setDescripcion("RMP-PROV."+EncOrden.getCodProv() + " " + formato.format(EncOrden.getFechaOrden()));
            documentoFacade.edit(docAutorizacion);
            msg+=" **Se Ingresado la Requisicion para Autorizacion ";
            msg+= NotificarEncargadoDepto(PKdocumento.getCodDepto(), PKdocumento.getCodTipoDocto(),EncOrden.getOrdenencPK().getNumOrden());
        }catch(Exception ex){
            System.out.println("Error2");
        }
        return msg;
        
    }
    
     /**
    *NotificarEncargadoDepto
    * Proceso de Negocio que permite realizar la Notificacion al encargado del
    * Departamento para la autorizacion de la Requisicion
    * @author       Daniel Romero
    * @version      1.0
    */
    
    public String NotificarEncargadoDepto(short codDepto, String codTipoDocto, String NumDoc) throws MessagingException{
        String msg=""; 
        List<FirmasxtipoDocto> EncargadoDepto;
         EncargadoDepto = new ArrayList<FirmasxtipoDocto>();
         List<CiasXUsuario> CiaEncagadoDepto;
         CiaEncagadoDepto = new ArrayList<CiasXUsuario>();
         List<TipoDocumento> TipoDoc;
         TipoDoc = new ArrayList<TipoDocumento>();
         String nombreTipoDoc="";
         String Asunto, CuerpoMsg;         
         TipoDoc = tipoDocumentoFacade.findNomTipoDoc(codTipoDocto, codDepto);
         for(TipoDocumento tipodoc: TipoDoc){
             nombreTipoDoc = tipodoc.getNomTipoDocto();
         }
            EncargadoDepto =  firmasxtipoDoctoFacade.findEncaragoDepto(codDepto, codTipoDocto, "S", (short) 1);
            if(EncargadoDepto != null){
                for(FirmasxtipoDocto EncDoc : EncargadoDepto){
                    CiaEncagadoDepto = ciasXUsuarioFacade.findCiaEncaragoDepto(EncDoc.getFirmasxtipoDoctoPK().getCodCia(), EncDoc.getFirmasxtipoDoctoPK().getUsuario());
                    for(CiasXUsuario CiaUsu: CiaEncagadoDepto){
                        if(CiaUsu.getCorreoUsuario() != null){
                            Asunto= "AUTORIZACION DE "+ nombreTipoDoc +" (Correo Enviado Automáticamente)";
                            CuerpoMsg = "Estimado(a) Usuario(a): Tiene pendiente la autorización de un(a) "+ nombreTipoDoc +"No Documento: " + NumDoc + " Favor, de verificar el documento en el módulo de autorizaciones.Atte.MODULO DE AUTORIZACIÓN DE DOCUMENTOSDepartamento de Informática.";																							
                            emailBean.sendMessage(CiaUsu.getCorreoUsuario(), Asunto, CuerpoMsg);
                        }else{
                            Asunto= "CORREO DE USUARIO PARA AUTORIZACION (Correo Enviado Automáticamente)";
                            CuerpoMsg ="Señores(as) de Informática:Se solicita hacer el ingreso a la base de datos(ADMAPPLI.CIAS_X_USUARIO), el correo del usuario:"+ CiaUsu.getCiasXUsuarioPK().getUsuario() +" con codigo de empleado:"+CiaUsu.getCodEmp()+" y puesto "+ CiaUsu.getDescripcion() +"para las Requisiciones de Materia Prima, en el departamento" + codDepto + ", ya que por el momento no hay ninguno.Luego notificar al o los usuarios que tienen pendiente una autorización de un(a)"+ nombreTipoDoc + "No"+ NumDoc +"Atte.MODULO DE AUTORIZACIÓN DE DOCUMENTOSDepartamento de Informática.";
                            emailBean.sendMessage("desarrollosistemas@caricia.com", Asunto, CuerpoMsg);
                        }
                    }
                }
            }else{
                 Asunto= "INGRESO DE USUARIO(S) PARA AUTORIZACION (Correo Enviado Automáticamente)";
                 CuerpoMsg ="Señores(as) de Informática:Se solicita hacer el ingreso a la base de datos(AUTORIZACION.FIRMASXTIPO_DOCTO), de los usuarios con firma de autorizaciónpara las Requisiciones de Materia Prima, en el departamento" + codDepto + ", ya que por el momento no hay ninguno.Luego notificar al o los usuarios que tienen pendiente una autorización de un(a)"+ nombreTipoDoc + "No"+ NumDoc +"Atte.MODULO DE AUTORIZACIÓN DE DOCUMENTOSDepartamento de Informática.";
                 emailBean.sendMessage("desarrollosistemas@caricia.com", Asunto, CuerpoMsg);
            }
            msg+=" **Se ha Notificado a Encargado de Departamento de Requisicion ";
            return msg;
    }
    
     /**
    *AnularRequisicion
    * Proceso de Negocio que permite la Persistencia para la anulacion de la Requisicion
    * @author       Daniel Romero
    * @version      1.0
    */
    
    public String AnularRequisicion(Ordenenc EncOrden){
        String msg="";
        try{
            List<Detorden> DetalleOrden;
            DetalleOrden = new ArrayList<Detorden>();
            List<Documento> ListDocumento;
            ListDocumento = new ArrayList<Documento>();
            int CantidadSurtida=0;
            Date hoy = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            DetalleOrden = detordenFacade.findNumOrden(EncOrden.getOrdenencPK().getCodCia(), EncOrden.getOrdenencPK().getNumOrden());
            ListDocumento = documentoFacade.findByNumDocto(EncOrden.getOrdenencPK().getCodCia(), EncOrden.getOrdenencPK().getNumOrden(), EncOrden.getDepartamentos().getDepartamentosPK().getCodDepto(), "RMP");
            LoginBean lb= new LoginBean();
            
            for(Detorden detorden : DetalleOrden){
                if(detorden.getCantSurtida() != null){
                     CantidadSurtida = CantidadSurtida + detorden.getCantSurtida().intValue();
                }else{
                    CantidadSurtida = CantidadSurtida + 0;
                }
            }
            if((!(EncOrden.getStatus().equals("A")) && !(EncOrden.getStatus().equals("C"))) && (CantidadSurtida == 0)){
                EncOrden.setAnulado(lb.ssuser());
                EncOrden.setFechaanulado(hoy);
                EncOrden.setStatus("A");
                
                ordenencFacade.edit(EncOrden);
                for(Documento docAutorizacion : ListDocumento ){
                    docAutorizacion.setStatusDocto("D");
                    docAutorizacion.setObservaciones("DENEGADA POR ANULACION POR EL USUARIO " + lb.ssuser() + " " + formato.format(hoy));
                    documentoFacade.edit(docAutorizacion);
                }
                msg="Se ha Anulado la Requisicion: " + EncOrden.getOrdenencPK().getNumOrden() + " Satisfactoriamente ";
            }else{
                msg="La Requisicion " + EncOrden.getOrdenencPK().getNumOrden() + " No puede ser Anulada, Verifique que no este Completada, o que no haya sido Surtida ";
            }
            
        }catch(Exception ex){
            msg="Ocurrior Un Error, No pudo completarse la anulacion de la Requisicion:" + EncOrden.getOrdenencPK().getNumOrden();
            ex.printStackTrace();
        }
        return msg;
    }
    
     /**
    *surtirRequisicion
    * Proceso de Negocio que permite realizar la persistencia para el Surtido de La Requisicion en la 
    * Bodega de Materia Prima
    * @author       Daniel Romero
    * @version      1.0
    */
    
     public String surtirRequisicion(List<Detorden> DetalleReq){
       String msg ="";
       try{
           
           for(Detorden DetReq : DetalleReq){
                detordenFacade.edit(DetReq);
            }
                     
           msg+=" **Requisicion Surtida";
           
       }catch(Exception ex){
           msg+=" **Ocurrio un error, No se pudo completar el Surtido de la Requisicion";
       }   
       return msg;
   }
     
      /**
    *recibirRequisicion
    * Proceso de Negocio que permite realizar la persistencia para la Recepcion de la materia prima
    * por los departamento que la solicitaron
    * @author       Daniel Romero
    * @version      1.0
    */
     
    public String recibirRequisicion(List<Detorden> DetalleReq){
       String msg ="";
        List<Ordenenc> ListOrdenenc;
        ListOrdenenc = new ArrayList<Ordenenc>();
        double canRecibida=0, canSolicitada=0;
        short codCia = 0;
        String numOrden="";
       try{
           
           for(Detorden DetReq : DetalleReq){
                codCia = DetReq.getDetordenPK().getCodCia();
                numOrden = DetReq.getDetordenPK().getNumOrden();
                canRecibida =   DetReq.getCantidadRec().doubleValue();
                canSolicitada = DetReq.getCantidad().doubleValue();
                detordenFacade.edit(DetReq);
            }
           ListOrdenenc = ordenencFacade.findDocAutorizados(codCia, numOrden);
           if(canRecibida == canSolicitada){
               for(Ordenenc EncOrden : ListOrdenenc){
                   EncOrden.setStatus("C");
                   ordenencFacade.edit(EncOrden);
               }
           }else{
                for(Ordenenc EncOrden : ListOrdenenc){
                   EncOrden.setStatus("P");
                   ordenencFacade.edit(EncOrden);
               }
           }
           
           
                     
           msg+=" **Requisicion Recibida";
           
       }catch(Exception ex){
           msg+=" **No se ha Podido Procesar la Peticion de Recepcion";
           ex.printStackTrace();
       }   
       return msg;
   }
   
    

}
