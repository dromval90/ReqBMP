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
public class DetordenFacade extends AbstractFacade<Detorden> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetordenFacade() {
        super(Detorden.class);
    }
    
 @Override
    public List<Detorden> findAll(){
	 TypedQuery<Detorden> q;	
		 q = em.createNamedQuery("Detorden.findByCodCia", Detorden.class )		    
		    .setParameter("codCia",  0 );
         return q.getResultList();
    
    }
 
    public List<Detorden> findNumOrden(short codCia, String numOrden){
	 TypedQuery<Detorden> q;
	
		 q = em.createNamedQuery("Detorden.findByNumOrden", Detorden.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("numOrden",  numOrden );
         return q.getResultList();
    
    }
    
   
    
}
