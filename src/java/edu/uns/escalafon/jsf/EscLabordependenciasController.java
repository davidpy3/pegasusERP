package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscLabordependencias;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscLabordependenciasFacade;
import edu.uns.escalafon.ejb.EscLabordependenciasFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("escLabordependenciasController")
@SessionScoped
public class EscLabordependenciasController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscLabordependenciasFacadeLocal ejbFacade;
    private List<EscLabordependencias> items = null;
    private EscLabordependencias selected;

    public EscLabordependenciasController() {
    }

    public EscLabordependencias getSelected() {
        return selected;
    }

    public void setSelected(EscLabordependencias selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEscLabordependenciasPK().setIdPercl(selected.getEscCarreraLaboral().getIdPercl());
    }

    protected void initializeEmbeddableKey() {
        selected.setEscLabordependenciasPK(new edu.uns.escalafon.jpa.EscLabordependenciasPK());
    }

    private EscLabordependenciasFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscLabordependencias prepareCreate() {
        selected = new EscLabordependencias();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscLabordependenciasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscLabordependenciasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscLabordependenciasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscLabordependencias> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public EscLabordependencias getEscLabordependencias(edu.uns.escalafon.jpa.EscLabordependenciasPK id) {
        return getFacade().find(id);
    }

    public List<EscLabordependencias> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscLabordependencias> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscLabordependencias.class)
    public static class EscLabordependenciasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscLabordependenciasController controller = (EscLabordependenciasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escLabordependenciasController");
            return controller.getEscLabordependencias(getKey(value));
        }

        edu.uns.escalafon.jpa.EscLabordependenciasPK getKey(String value) {
            edu.uns.escalafon.jpa.EscLabordependenciasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscLabordependenciasPK();
            key.setIdPercl(Integer.parseInt(values[0]));
            key.setLabor(values[1]);
            key.setIdDep(Integer.parseInt(values[2]));
            key.setFecIni(java.sql.Date.valueOf(values[3]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscLabordependenciasPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPercl());
            sb.append(SEPARATOR);
            sb.append(value.getLabor());
            sb.append(SEPARATOR);
            sb.append(value.getIdDep());
            sb.append(SEPARATOR);
            sb.append(value.getFecIni());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscLabordependencias) {
                EscLabordependencias o = (EscLabordependencias) object;
                return getStringKey(o.getEscLabordependenciasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscLabordependencias.class.getName()});
                return null;
            }
        }

    }

}
