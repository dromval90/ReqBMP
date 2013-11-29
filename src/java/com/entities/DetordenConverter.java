package com.entities;

import com.entities.Detorden;
import com.entities.DetordenFacade;
import com.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class DetordenConverter implements Converter {

    @EJB
    private DetordenFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.entities.DetordenPK getKey(String value) {
        com.entities.DetordenPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.entities.DetordenPK();
        key.setNumOrden(values[0]);
        key.setCodCia(Short.parseShort(values[1]));
        key.setCodProd(values[2]);
        return key;
    }

    String getStringKey(com.entities.DetordenPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getNumOrden());
        sb.append(SEPARATOR);
        sb.append(value.getCodCia());
        sb.append(SEPARATOR);
        sb.append(value.getCodProd());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Detorden) {
            Detorden o = (Detorden) object;
            return getStringKey(o.getDetordenPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detorden.class.getName()});
            return null;
        }
    }
}
