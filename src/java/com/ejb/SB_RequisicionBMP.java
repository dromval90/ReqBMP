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
import com.entities.Ordenenc;
import com.entities.OrdenencFacade;
import com.entities.TipoDocumento;
import com.entities.TipoDocumentoFacade;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            NotificarEncargadoDepto(PKdocumento.getCodDepto(), PKdocumento.getCodTipoDocto(),EncOrden.getOrdenencPK().getNumOrden());
        }catch(Exception ex){
            System.out.println("Error2");
        }
    }
    
    public void NotificarEncargadoDepto(short codDepto, String codTipoDocto, String NumDoc) throws MessagingException{
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
                            CuerpoMsg = "Estimado(a) Usuario(a): <br/><br/>Tiene pendiente la autorización de un(a) "+ nombreTipoDoc +"<br/>No Documento: " + NumDoc + " <br/>Favor, de verificar el documento en el módulo de autorizaciones.<br/><br/>Atte.<br/>MODULO DE AUTORIZACIÓN DE DOCUMENTOS<br/>Departamento de Informática.";																							
                            emailBean.sendMessage(CiaUsu.getCorreoUsuario(), Asunto, CuerpoMsg);
                        }else{
                            Asunto= "CORREO DE USUARIO PARA AUTORIZACION (Correo Enviado Automáticamente)";
                            CuerpoMsg ="Señores(as) de Informática:<br/>Se solicita hacer el ingreso a la base de datos(ADMAPPLI.CIAS_X_USUARIO), el correo del usuario:"+ CiaUsu.getCiasXUsuarioPK().getUsuario() +"<br/> con codigo de empleado:"+CiaUsu.getCodEmp()+"<br/> y puesto <br/>"+ CiaUsu.getDescripcion() +"<br/>para las Requisiciones de Materia Prima, en el departamento" + codDepto + ", ya que por el momento no hay ninguno.<br/><br/>Luego notificar al o los usuarios que tienen pendiente una autorización de un(a)"+ nombreTipoDoc + "<br/>No"+ NumDoc +"<br/><br/>Atte.<br/>MODULO DE AUTORIZACIÓN DE DOCUMENTOS<br/>Departamento de Informática.";
                            emailBean.sendMessage("desarrollosistemas@caricia.com", Asunto, CuerpoMsg);
                        }
                    }
                }
            }else{
                 Asunto= "INGRESO DE USUARIO(S) PARA AUTORIZACION (Correo Enviado Automáticamente)";
                 CuerpoMsg ="Señores(as) de Informática:<br/>Se solicita hacer el ingreso a la base de datos(AUTORIZACION.FIRMASXTIPO_DOCTO), de los usuarios con firma de autorización<br/>para las Requisiciones de Materia Prima, en el departamento" + codDepto + ", ya que por el momento no hay ninguno.<br/><br/>Luego notificar al o los usuarios que tienen pendiente una autorización de un(a)"+ nombreTipoDoc + "<br/>No"+ NumDoc +"<br/><br/>Atte.<br/>MODULO DE AUTORIZACIÓN DE DOCUMENTOS<br/>Departamento de Informática.";
                 emailBean.sendMessage("desarrollosistemas@caricia.com", Asunto, CuerpoMsg);
            }
    }

}
