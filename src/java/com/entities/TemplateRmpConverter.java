package com.entities;

import com.entities.TemplateRmp;
import com.entities.TemplateRmpFacade;
import com.entities.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class TemplateRmpConverter implements Converter {

    @EJB
    private TemplateRmpFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.entities.TemplateRmpPK getKey(String value) {
        com.entities.TemplateRmpPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.entities.TemplateRmpPK();
        key.setCodCia(Short.parseShort(values[0]));
        key.setCodProd(values[1]);
        return key;
    }

    String getStringKey(com.entities.TemplateRmpPK value) {
        StringBuffer sb = new StringBuffer();
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
        if (object instanceof TemplateRmp) {
            TemplateRmp o = (TemplateRmp) object;
            return getStringKey(o.getTemplateRmpPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TemplateRmp.class.getName()});
            return null;
        }
    }
}
