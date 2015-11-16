package org.jsuns.util;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsuns.X;
import org.primefaces.model.LazyDataModel;

public abstract class AbstractController<T> {

    private Class<T> entityClass;
    protected List<T> items = null;
    private T selected;
    private HashMap params=new HashMap();

    public HashMap getParams() {
        return params;
    }

    public void setParams(HashMap params) {
        this.params = params;
    }
    
    public AbstractController() {
        try {
            String g = this.getClass().getGenericSuperclass().toString();
            X.log("Leyendo de controlador generico para "+entityClass);
            entityClass = (Class<T>) Class.forName(g.substring(g.indexOf("<")+1, g.indexOf(">")));
            X.log("Se reconocio generico para "+entityClass);
        } catch (ClassNotFoundException ex) {
            X.alert(ex);
        }
    }

    public T getSelected() {
        return selected;
    }

    public T prepareCreate() {
        try {
            X.log("Preparar instancia de "+entityClass);
            selected = entityClass.newInstance();
            X.log("se creo "+selected);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeEmbeddableKey();
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RecordCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RecordUpdated"));
    }

    protected abstract void persist(JsfUtil.PersistAction persistAction, String successMessage);

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RecordDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            setSelected(null);
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private LazyDataModel dataModel = null;

    public LazyDataModel<T> getDataModel() {
        if (dataModel == null) {
            System.out.println("palayers=" + dataModel);
            dataModel = createLazyListModel();
        }
        return dataModel;
    }

    protected LazyDataModel createLazyListModel(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected void initializeEmbeddableKey(){
        
    }
    
    protected void setEmbeddableKeys(){
        
    }

}
