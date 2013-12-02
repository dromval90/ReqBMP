package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "unidadesController")
@ViewScoped
public class UnidadesController extends AbstractController<Unidades> implements Serializable {

    @EJB
    private UnidadesFacade ejbFacade;

    public UnidadesController() {
        super(Unidades.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
