package org.pegasus.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.jpa.Usuario;

@Local
public interface UsuarioFacadeLocal {

    void create(Usuario banco);

    void edit(Usuario banco);

    void remove(Usuario banco);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario login(String user, String pass);
    
}
