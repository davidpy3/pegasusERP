package org.pegasus.jsf;

import edu.uns.ocid.ejb.DrtDirectorioFacadeLocal;
import edu.uns.ocid.ejb.DrtPersonaNaturalFacadeLocal;
import org.pegasus.jpa.Usuario;
import java.io.Serializable;
import java.util.HashMap;
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
import javax.servlet.http.HttpSession;
import org.jsuns.X;
import org.jsuns.ocid.DrtPersonaNatural;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.Pegasus;
import org.jsuns.util.XUtil;
import org.pegasus.ejb.UsuarioFacadeLocal;
import org.pegasus.jpa.UsuarioPK;

@Named("usuarioController")
@SessionScoped
public class UsuarioController extends AbstractController<Usuario> implements Serializable {
    
    @EJB
    private DrtPersonaNaturalFacadeLocal drtDirectorioFacade;
    
    @EJB
    private org.pegasus.ejb.UsuarioFacadeLocal ejbFacade;
    
    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setUsuarioPK(new org.pegasus.jpa.UsuarioPK());
    }

    private UsuarioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session =Pegasus.getSession();
        session.invalidate();
        return "logout";
    }
    
    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Usuario selected=getSelected();
        if (selected != null) {
            HashMap m=getParams();
            String clave=X.toText(m.remove("clave")).trim();
            String confirm=X.toText(m.remove("confirm")).trim();
            if(clave.length()>0&&clave.equals(confirm)){
                String ss="";
                for(char c:clave.toUpperCase().toCharArray()){
                    int i=(255-(int)c);
//                    if(i>0&&i<224)
                            ss=(char)i+ss;
                }
                selected.setClave(ss);
            }
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle0").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle0").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuario getUsuario(org.pegasus.jpa.UsuarioPK id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        org.pegasus.jpa.UsuarioPK getKey(String value) {
            org.pegasus.jpa.UsuarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.jpa.UsuarioPK();
            key.setAnoEje(values[0]);
            key.setDni(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.jpa.UsuarioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getDni());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getUsuarioPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }

    }

    public String login(){//00011678
        HashMap p=getParams();
        try{
            Usuario u=getFacade().login(X.toText(p.get("user")),X.toText(p.get("pass")));
            if(u!=null){
                UsuarioPK upk=u.getUsuarioPK();
                if("0".equals(upk.getAnoEje())){
                    DrtPersonaNatural pn=drtDirectorioFacade.find(XUtil.intValue(upk.getDni()));
                    Pegasus.getSession().setAttribute("personaNatural",pn);
                }
            }
            Pegasus.getSession().setAttribute("usuario", u);
//            return "admin";
//            return "personal/planilla/List?faces-redirect=true";
            return "oceca/encuestaParticipacion/List?faces-redirect=true";
        }catch(Exception e){
            return "login";
        }
    }
 
}
