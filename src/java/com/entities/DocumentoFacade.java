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
public class DocumentoFacade extends AbstractFacade<Documento> {
    @PersistenceContext(unitName = "RequisicionBMPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoFacade() {
        super(Documento.class);
    }
    
    public List<Documento>findByNumDocto(short codCia, String numDocumento, short codDepto, String CodTipoDoc){
	 TypedQuery<Documento> q;
	
		 q = em.createNamedQuery("Documento.findByNumDocto", Documento.class )		    
		    .setParameter("codCia",  codCia )
                    .setParameter("numDocto",  numDocumento )
                    .setParameter("codDepto",  codDepto )
                    .setParameter("codTipoDocto",  CodTipoDoc );
         return q.getResultList();
    
    }
    
}
