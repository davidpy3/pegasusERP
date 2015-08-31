/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.personal;


import java.io.Serializable;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import org.jsuns.data.JPA;
import org.munisoft.Pegasus;
import org.munisoft.model.Usuario;
 
//import com.journaldev.jsf.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
 
    private static final long serialVersionUID = 1094801825228386363L;
     
    private String pwd;
    private String msg;
    private String user;
 
    public Usuario getUsuario(){
        return (Usuario) Pegasus.getSession().getAttribute("usuario");
    }
    
    public String getPwd() {
        return pwd;
    }
 
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }
 
    //validate login
    public String validateUsernamePassword(){
        EntityManager em=JPA.getInstance().getEntityManager();
       /* for(Object d:em.createQuery("select "
                + "u from Usuario u").getResultList()){
            if(d!=null){
                Usuario u=(Usuario) d;
                String ss="";
                if(u.getClave()!=null)
                for(char c:u.getClave().toCharArray()){
                    int i=(255-(int)c);
                    if(i>0&&i<224)
                            ss=(char)i+ss;
                }
                
                System.out.println(u.getUsuario()+">"+ss);
            }
    }*/
        String ss="";
                for(char c:pwd.toUpperCase().toCharArray()){
                    int i=(255-(int)c);
//                    if(i>0&&i<224)
                            ss=(char)i+ss;
                }
        try{
            Usuario u=em.createQuery("select "
                + "u from Usuario u WHERE usuario=:user AND clave=:pass AND u.usuarioPK.anoEje="+2015,Usuario.class)
               .setParameter("user",user.toUpperCase())
               .setParameter("pass",ss).getSingleResult();
            HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("usuario",u);
             JPA.getInstance().close();
            return "admin";
        }catch(NoResultException e){
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }finally{
             JPA.getInstance().close();
        }
   
  
    }
 
    
    
    //logout event, invalidate session
    public String logout() {
        HttpSession session =Pegasus.getSession();
        session.invalidate();
        return "login";
    }
}