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
public class CiasXUsuarioFacade extends AbstractFacade<CiasXUsuario> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiasXUsuarioFacade() {
        super(CiasXUsuario.class);
    }
    
    public List<CiasXUsuario> findCiaEncaragoDepto(short codCia, String usuario){
	 TypedQuery<CiasXUsuario> q;
	
		 q = em.createNamedQuery("CiasXUsuario.findCiaEncaragoDepto", CiasXUsuario.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("usuario",  usuario );
                 if(q.getResultList() != null){
                     return q.getResultList();
                 }else{
                     return null;
                 }
    }
    
}
