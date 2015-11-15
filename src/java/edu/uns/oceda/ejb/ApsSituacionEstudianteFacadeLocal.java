/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsSituacionEstudiante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsSituacionEstudianteFacadeLocal {

    void create(ApsSituacionEstudiante apsSituacionEstudiante);

    void edit(ApsSituacionEstudiante apsSituacionEstudiante);

    void remove(ApsSituacionEstudiante apsSituacionEstudiante);

    ApsSituacionEstudiante find(Object id);

    List<ApsSituacionEstudiante> findAll();

    List<ApsSituacionEstudiante> findRange(int[] range);

    int count();
    
}
