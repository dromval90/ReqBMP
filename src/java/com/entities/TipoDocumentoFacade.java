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
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }
    
     public List<TipoDocumento> findNomTipoDoc(String CodTipoDoc,short codDepto){
	 TypedQuery<TipoDocumento> q;	
                LoginBean lb= new LoginBean();	
                short codCia = lb.sscia();
		 q = em.createNamedQuery("TipoDocumento.findNomTipoDoc", TipoDocumento.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("codTipoDocto",  CodTipoDoc )
                    .setParameter("codDepto",  codDepto );
         if(q.getResultList() != null){
            return q.getResultList();
         }else{
            return null;
         }   
    }
}
