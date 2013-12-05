package com.entities;

import com.entities.FirmasxtipoDocto;
import com.entities.FirmasxtipoDoctoFacade;
import com.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class FirmasxtipoDoctoConverter implements Converter {

    @EJB
    private FirmasxtipoDoctoFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.entities.FirmasxtipoDoctoPK getKey(String value) {
        com.entities.FirmasxtipoDoctoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.entities.FirmasxtipoDoctoPK();
        key.setCodCia(Short.parseShort(values[0]));
        key.setCodDepto(Short.parseShort(values[1]));
        key.setCodTipoDocto(values[2]);
        key.setUsuario(values[3]);
        return key;
    }

    String getStringKey(com.entities.FirmasxtipoDoctoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCodCia());
        sb.append(SEPARATOR);
        sb.append(value.getCodDepto());
        sb.append(SEPARATOR);
        sb.append(value.getCodTipoDocto());
        sb.append(SEPARATOR);
        sb.append(value.getUsuario());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof FirmasxtipoDocto) {
            FirmasxtipoDocto o = (FirmasxtipoDocto) object;
            return getStringKey(o.getFirmasxtipoDoctoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FirmasxtipoDocto.class.getName()});
            return null;
        }
    }
}
