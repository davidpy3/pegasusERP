package org.pegasus.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.pegasus.jpa.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @Override
    public Usuario login(String user, String pass) {
        X.log("user="+user+";pass="+pass);
        EntityManager em = getEntityManager();
        String ss = "";
        for (char c : pass.toUpperCase().toCharArray()) {
            int i = (255 - (int) c);
//                    if(i>0&&i<224)
            ss = (char) i + ss;
        }
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

        Usuario u=em.createQuery("SELECT u from Usuario u WHERE u.usuario=:user AND u.clave=:pass AND u.usuarioPK.anoEje='2015'",
                Usuario.class)
                .setParameter("user", user.toUpperCase())
                .setParameter("pass", ss).getSingleResult();
        X.log("user="+u);
        return u;

    }

}
