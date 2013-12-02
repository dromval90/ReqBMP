/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dromero
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
    @Override
    public List<Productos> findAll(){
	 TypedQuery<Productos> q;
	 
	    LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
	
		 q = em.createNamedQuery("Productos.findByCodCia", Productos.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("codCat",  "81" );
                 
         return q.getResultList();
    
    }
    
}
