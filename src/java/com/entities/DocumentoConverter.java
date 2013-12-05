package com.entities;

import com.entities.Documento;
import com.entities.DocumentoFacade;
import com.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class DocumentoConverter implements Converter {

    @EJB
    private DocumentoFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.entities.DocumentoPK getKey(String value) {
        com.entities.DocumentoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.entities.DocumentoPK();
        key.setCodCia(Short.parseShort(values[0]));
        key.setCodDepto(Short.parseShort(values[1]));
        key.setCodTipoDocto(values[2]);
        key.setNumDocto(values[3]);
        key.setNumCaso(Long.parseLong(values[4]));
        return key;
    }

    String getStringKey(com.entities.DocumentoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodCia());
        sb.append(SEPARATOR);
        sb.append(value.getCodDepto());
        sb.append(SEPARATOR);
        sb.append(value.getCodTipoDocto());
        sb.append(SEPARATOR);
        sb.append(value.getNumDocto());
        sb.append(SEPARATOR);
        sb.append(value.getNumCaso());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Documento) {
            Documento o = (Documento) object;
            return getStringKey(o.getDocumentoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Documento.class.getName()});
            return null;
        }
    }
}
