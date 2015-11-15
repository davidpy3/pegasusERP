package org.jsuns.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
public class DialogController {
    
    public void open(String url){
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("contentWidth",700);
        options.put("contentHeight",300);
        options.put("modal", true);
        RequestContext.getCurrentInstance().openDialog(url, options, null);
    }
    
    public void open(){
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal",true);
        options.put("contentWidth",700);
        options.put("contentHeight",300);
        options.put("includeViewParams", true);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("size",5);
        Map params = new HashMap();
        List values = new ArrayList();
        values.add("10");
        params.put("size",values);
        RequestContext.getCurrentInstance().openDialog("/dialog",options,params);
        System.out.println("ok");
    }
    
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
         
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void onSelect(SelectEvent event) {
        Object car =event.getObject();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car));
    }
    
    public void showDialog(){
        System.out.println("showDialog()");
        RequestContext.getCurrentInstance().execute("td.show()");
    }
    
}
