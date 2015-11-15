package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Bien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.jsuns.util.AbstractController;
import org.pegasus.patrimonio.ejb.BienFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.XMap;
import org.jsuns.util.XUtil;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


@Named
@SessionScoped
public class BienController extends AbstractController<Bien> implements Serializable {

    
    public List<Bien> complete(String query) {
        return (List<Bien>)getFacade()
                .load(0,-1,null,
                        new XMap(
                                "usuario","32806482",
                                "tipoBien","%"+query.toUpperCase()+"%"
                        ));
    }
    
    @EJB 
    private org.pegasus.patrimonio.ejb.BienFacadeLocal ejbFacade;

    public void inventariar(Object o){
        System.out.println(">>>"+o);
        
    }
    
    public String getDetalleTecnico(Bien b) {

//ls_grupo = Mid(as_codbien, 1, 2)
//ls_clase =Mid(as_codbien, 3, 2)
        String codBien = b.getBienPK().getCodbien();
        int idClase = XUtil.intValue(codBien.substring(2, 4));
        String ls_detalle_tecnico = "";//idClase=" + idClase;
        switch (idClase) {
            case 8:
            case 22:
            case 50:
            case 1:
                ls_detalle_tecnico += "Marca: " + b.getMarca() + ", Modelo: " + b.getModelo() + ", Serie: " + b.getSerie();

                break;
            case 36:
            case 82:
                ls_detalle_tecnico += "Marca: " + b.getMarca() + ", Placa: " + b.getPlaca() + ", Num Motor: " + b.getNummotor();
                break;
            case 64:
                ls_detalle_tecnico += "Dimensión: " + b.getDimension() + ", Color: " + b.getColor() + ", Modelo: " + b.getModelo();
                break;
            case 78:
                ls_detalle_tecnico += "Color: " + b.getColor() + ", Raza: " + b.getRaza() + ", Especie: " + b.getEspecie();
                break;
            case 0:
            /*CHOOSE CASE ls_grupo
             CASE '39'
             ls_detalle_tecnico = "Titulo: " + ls_titulo + ", Edicion: " + ls_edicion
             CASE '74'
             ls_detalle_tecnico = "Producto: " + ls_product_name + ", Versión: " + ls_edicion
             */
        }

        return ls_detalle_tecnico;
    }
    
    private BienFacadeLocal getFacade() {
        return ejbFacade;
    }
        class LazyListModel extends LazyDataModel<Bien> {

        public LazyListModel() {
        }

        @Override
        public Bien getRowData(String rowKey) {
            return ejbFacade.find(rowKey);
        }

        @Override
        public Object getRowKey(Bien car) {
            return car.getBienPK();
        }

        @Override
        public List<Bien> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            
            List data= ejbFacade.findRange(new int[]{first,pageSize});
            if (getRowCount() <= 0) {
                setRowCount(ejbFacade.count());
            }
            return data;
        }

    }

    public List<Bien> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

     @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Bien selected=getSelected();
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

    public Bien getBien(org.pegasus.patrimonio.jpa.BienPK id) {
        return getFacade().find(id);
    }

    public List<Bien> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Bien> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        return new LazyListModel();
    }

    @FacesConverter(forClass=Bien.class)
    public static class BienControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            System.out.println("value======'"+value+"'");
            BienController controller = (BienController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bienController");
            return controller.getBien(getKey(value));
        }

        org.pegasus.patrimonio.jpa.BienPK getKey(String value) {
            org.pegasus.patrimonio.jpa.BienPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.BienPK();
            key.setCodbien(values[0]);
            key.setCorrela(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.BienPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodbien());
            sb.append(SEPARATOR);
            sb.append(value.getCorrela());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Bien) {
                Bien o = (Bien) object;
                return getStringKey(o.getBienPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Bien.class.getName()});
                return null;
            }
        }

    }

}
