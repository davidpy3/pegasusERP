/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.util;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.pegasus.personal.jpa.Concepto;

@ManagedBean
@RequestScoped
public class SystemController {

    public String getUrl() {
        return url;
    }

    public String menu;
    public String body;

    public String getBody() {
        return body;
    }
    
    public String getMenu() {
        return menu;
    }

    @PostConstruct
    public void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String q= request.getParameter("q");
        if(q!=null){
            String s[]=q.split(":");
            menu="/" + s[0]+ "/menu.xhtml";
            body=s[1];
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setModule(String module) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.setAttribute("menu", "/" + module + "/men.xhtml");
    }

    private String url;

    public SystemController() {

    }
    private Concepto personal;

    private String dni;

//<ui:include rendered="#{not empty session.getAttribute('url')}" src="#{session.getAttribute('url')}" />
    public String getDni() {
        return dni;
    }

    public String to(String dni) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        System.out.println("to===" + request.getParameter("dni"));
        //url=dni+".xhtml";
        System.out.println(url);
        return url;
    }

    public String to2(String url) throws IOException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        System.out.println("to222===" + request.getParameter("dni"));
        System.out.println("to2>" + url);
        request.setAttribute("url", url + ".xhtml");
        request.getSession().setAttribute("mod", url);
        request.setAttribute("mod", url);
        return "/personal/padre";
        //FacesContext.getCurrentInstance().getExternalContext().redirect(url);
    }

    public Concepto getPersonal() {
        return personal;
    }

    public void delete() {
        EntityManager em = JPA.getInstance().getEntityManager(true);
        em.remove(em.find(Concepto.class, dni));
        JPA.getInstance().close();
    }

    public void setPersonal(Concepto personal) {
        this.personal = personal;
    }

    public Concepto getSelected() {
        return personal;
    }
}
