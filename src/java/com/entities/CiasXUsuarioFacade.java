/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
