package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "productosController")
@ViewScoped
public class ProductosController extends AbstractController<Productos> implements Serializable {

    @EJB
    private ProductosFacade ejbFacade;

    public ProductosController() {
        super(Productos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProductosPK(new com.entities.ProductosPK());
    }
}
