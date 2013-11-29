package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ordenencController")
@ViewScoped
public class OrdenencController extends AbstractController<Ordenenc> implements Serializable {

    @EJB
    private OrdenencFacade ejbFacade;

    public OrdenencController() {
        super(Ordenenc.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setOrdenencPK(new com.entities.OrdenencPK());
    }
}
