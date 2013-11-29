package com.entities;

import com.entities.Ordenenc;
import com.entities.OrdenencFacade;
import com.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class OrdenencConverter implements Converter {

    @EJB
    private OrdenencFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.entities.OrdenencPK getKey(String value) {
        com.entities.OrdenencPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.entities.OrdenencPK();
        key.setNumOrden(values[0]);
        key.setCodCia(Short.parseShort(values[1]));
        return key;
    }

    String getStringKey(com.entities.OrdenencPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getNumOrden());
        sb.append(SEPARATOR);
        sb.append(value.getCodCia());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Ordenenc) {
            Ordenenc o = (Ordenenc) object;
            return getStringKey(o.getOrdenencPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ordenenc.class.getName()});
            return null;
        }
    }
}
