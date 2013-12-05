/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dromero
 */
@Stateless
public class CategoriasFacade extends AbstractFacade<Categorias> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasFacade() {
        super(Categorias.class);
    }
    
    public  Categorias findbyCodcat(String Cod_cat){
        try{
             TypedQuery<Categorias> q;	 
	     LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
		 q = em.createNamedQuery("Categorias.findByCodCat", Categorias.class )		    
		    .setParameter("codCia",  codCia)
		    .setParameter("codCat", "%"+ Cod_cat + "%" );
		 
         return q.getSingleResult(); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
 	   return null;
    }   
    
}
