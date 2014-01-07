/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author dromero
 */
@Stateless
public class OrdenencFacade extends AbstractFacade<Ordenenc> {
    @EJB
    private EmpleadosFacade empleadosFacade;
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenencFacade() {
        super(Ordenenc.class);
    }
    
    @Override
    public List<Ordenenc> findAll(){
	 TypedQuery<Ordenenc> q;
            LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
            Empleados emp = new Empleados();
            emp = empleadosFacade.findbyUsuario(lb.ssuser());
		 q = em.createNamedQuery("Ordenenc.findAll", Ordenenc.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("coddeptoSol",  emp.getDepartamentos().getDepartamentosPK().getCodDepto())
                    .setParameter("tipoOrden",  "P" );
               
            
         return q.getResultList();
    }
    
    public String findPk(){
        String val="";
        LoginBean lb= new LoginBean();
        short codCia = lb.sscia();

        Query q =  em.createNativeQuery("Select ltrim (to_char (max (to_number (num_orden)) + 1)) from OrdenEnc where cod_Cia = ? ");
                q.setParameter(1, codCia);  
                val = (String) q.getSingleResult();
               
       return val;

    } 
    
    public List<Ordenenc> findDocAutorizados(){
         TypedQuery<Ordenenc> q=null;
        try{
            LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
		 q = em.createNamedQuery("Ordenenc.findDocAutorizados", Ordenenc.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("tipoOrden", "P")
                    .setParameter("xstatus",  "A" )
                    .setParameter("status", "C" );
                
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return q.getResultList();
    
    }
    
    
    public List<Ordenenc> findDocAutorizados(short codCia, String numOrden){
         TypedQuery<Ordenenc> q=null;
        try{
		 q = em.createNamedQuery("Ordenenc.findOrdenAutorizados", Ordenenc.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("numOrden",  numOrden )
                    .setParameter("tipoOrden", "P")
                    .setParameter("xstatus",  "A" )
                    .setParameter("status", "C" );
                
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return q.getResultList();
    
    }
    
    
     public List<Ordenenc> findByNumOrden(short codCia, String numOrden){
         TypedQuery<Ordenenc> q=null;
        try{
		 q = em.createNamedQuery("Ordenenc.findByNumOrden", Ordenenc.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("numOrden", numOrden);
                
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return q.getResultList();
    
    }
    
    
    
}
