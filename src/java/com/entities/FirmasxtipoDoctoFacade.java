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
public class FirmasxtipoDoctoFacade extends AbstractFacade<FirmasxtipoDocto> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FirmasxtipoDoctoFacade() {
        super(FirmasxtipoDocto.class);
    }
    
     public List<FirmasxtipoDocto> findEncaragoDepto(short codDepto, String CodTipoDoc, String FirmaActivo, Short prioridad){
	 TypedQuery<FirmasxtipoDocto> q;
	 
	    LoginBean lb= new LoginBean();	
	    short codCia = lb.sscia();
	
		 q = em.createNamedQuery("FirmasxtipoDocto.findEncaragoDepto", FirmasxtipoDocto.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("codDepto",  codDepto )
                    .setParameter("codTipoDocto",  CodTipoDoc )
                    .setParameter("firmaActivo",  FirmaActivo )
                    .setParameter("prioridad",  prioridad );
         if(q.getResultList() != null){
             return q.getResultList();
         }else{
             return null;
         }
    }
    
}
