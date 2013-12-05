package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ciasXUsuarioController")
@ViewScoped
public class CiasXUsuarioController extends AbstractController<CiasXUsuario> implements Serializable {

    @EJB
    private CiasXUsuarioFacade ejbFacade;

    public CiasXUsuarioController() {
        super(CiasXUsuario.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCiasXUsuarioPK(new com.entities.CiasXUsuarioPK());
    }
}
