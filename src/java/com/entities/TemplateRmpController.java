package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "templateRmpController")
@ViewScoped
public class TemplateRmpController extends AbstractController<TemplateRmp> implements Serializable {

    @EJB
    private TemplateRmpFacade ejbFacade;

    public TemplateRmpController() {
        super(TemplateRmp.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setTemplateRmpPK(new com.entities.TemplateRmpPK());
    }
}
