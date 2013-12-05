package com.entities;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "documentoController")
@ViewScoped
public class DocumentoController extends AbstractController<Documento> implements Serializable {

    @EJB
    private DocumentoFacade ejbFacade;

    public DocumentoController() {
        super(Documento.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setDocumentoPK(new com.entities.DocumentoPK());
    }
}
