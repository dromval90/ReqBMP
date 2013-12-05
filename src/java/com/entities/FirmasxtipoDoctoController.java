package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "firmasxtipoDoctoController")
@ViewScoped
public class FirmasxtipoDoctoController extends AbstractController<FirmasxtipoDocto> implements Serializable {

    @EJB
    private FirmasxtipoDoctoFacade ejbFacade;

    public FirmasxtipoDoctoController() {
        super(FirmasxtipoDocto.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setFirmasxtipoDoctoPK(new com.entities.FirmasxtipoDoctoPK());
    }
}
