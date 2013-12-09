package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController extends AbstractController<TipoDocumento> implements Serializable {

    @EJB
    private TipoDocumentoFacade ejbFacade;

    public TipoDocumentoController() {
        super(TipoDocumento.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setTipoDocumentoPK(new com.entities.TipoDocumentoPK());
    }
}
