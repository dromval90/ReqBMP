package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "detordenController")
@ViewScoped
public class DetordenController extends AbstractController<Detorden> implements Serializable {

    @EJB
    private DetordenFacade ejbFacade;

    public DetordenController() {
        super(Detorden.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getDetordenPK().setCodCia(this.getSelected().getOrdenenc().getOrdenencPK().getCodCia());
        this.getSelected().getDetordenPK().setNumOrden(this.getSelected().getOrdenenc().getOrdenencPK().getNumOrden());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDetordenPK(new com.entities.DetordenPK());
    }
}
