/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

/**
 *
 * @author mmixco
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public EmpleadosFacade() {
	super(Empleados.class);
    }
    
public  List<Empleados> findbyNameAndPk( int emp,String apellidos,String nombres){
     LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
            
 	     TypedQuery<Empleados> q;
	     if(emp ==0){
		 q = em.createNamedQuery("Empleados.findByFiltros", Empleados.class )		    
		    .setParameter("codCia", "%"+ codCia + "%" )
		    .setParameter("apellidos", "%" + apellidos + "%")
		    .setParameter("nombres", "%" + nombres + "%");	
	     }else{
		    q = em.createNamedQuery("Empleados.findByPk2", Empleados.class )		    
		    .setParameter("codCia",  codCia)			 
		    .setParameter("codEmp",  emp);
	     } 
         return q.getResultList();
    }   

public  Empleados findbyCodemp( int emp){
     LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
            
 	     TypedQuery<Empleados> q;     

		    q = em.createNamedQuery("Empleados.findByPk2", Empleados.class )		    
		    .setParameter("codCia",  codCia)			 
		    .setParameter("codEmp",  emp);

         return q.getSingleResult();
    }  

public  Empleados findbyUsuario(String usuario){
 	     TypedQuery<Empleados> q;	 
	     LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
		 q = em.createNamedQuery("Empleados.findByUsuario", Empleados.class )		    
		    .setParameter("codCia",  codCia)
		    .setParameter("usuario", "%"+ usuario + "%" );
		 
         return q.getSingleResult();
    }   

    @Override
    public List<Empleados> findAll(){
	 TypedQuery<Empleados> q;
	 
	    LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
	
		 q = em.createNamedQuery("Empleados.findByCodCia", Empleados.class )		    
		    .setParameter("codCia",  codCia );
         return q.getResultList();
    
    }

    public List<Empleados> findByNombreNit(String nombreNit){
	 TypedQuery<Empleados> q;
	 
	    LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
	
		 q = em.createNamedQuery("Empleados.findByNombreNit", Empleados.class )		    
		    .setParameter("nombreNit",  "%" +nombreNit  + "%")
		    .setParameter("codCia",  codCia );
         return q.getResultList();
    
    }  
    
    public List<Empleados> activos(){
	 TypedQuery<Empleados> q;
	 
	    LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
	    String act = "A";
	
		 q = em.createNamedQuery("Empleados.findByStatus", Empleados.class )		    
		    .setParameter("status",  "%"+act+"%")
		    .setParameter("codCia",  codCia );
         return q.getResultList();
    
    }      


    
    
}
