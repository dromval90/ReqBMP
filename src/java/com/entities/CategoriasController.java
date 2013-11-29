package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "categoriasController")
@ViewScoped
public class CategoriasController extends AbstractController<Categorias> implements Serializable {

    @EJB
    private CategoriasFacade ejbFacade;

    public CategoriasController() {
        super(Categorias.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCategoriasPK(new com.entities.CategoriasPK());
    }
}
