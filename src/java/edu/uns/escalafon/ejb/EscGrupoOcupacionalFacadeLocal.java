/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscGrupoOcupacional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscGrupoOcupacionalFacadeLocal {

    void create(EscGrupoOcupacional escGrupoOcupacional);

    void edit(EscGrupoOcupacional escGrupoOcupacional);

    void remove(EscGrupoOcupacional escGrupoOcupacional);

    EscGrupoOcupacional find(Object id);

    List<EscGrupoOcupacional> findAll();

    List<EscGrupoOcupacional> findRange(int[] range);

    int count();
    
}
