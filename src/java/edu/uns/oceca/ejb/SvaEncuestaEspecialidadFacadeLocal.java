/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaEncuestaEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaEncuestaEspecialidadFacadeLocal {

    void create(SvaEncuestaEspecialidad svaEncuestaEspecialidad);

    void edit(SvaEncuestaEspecialidad svaEncuestaEspecialidad);

    void remove(SvaEncuestaEspecialidad svaEncuestaEspecialidad);

    SvaEncuestaEspecialidad find(Object id);

    List<SvaEncuestaEspecialidad> findAll();

    List<SvaEncuestaEspecialidad> findRange(int[] range);

    int count();

    public SvaEncuestaEspecialidad load(SvaEncuestaEspecialidad selected);
    
    
    
}
