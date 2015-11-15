/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaTipoParticipante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaTipoParticipanteFacadeLocal {

    void create(SvaTipoParticipante svaTipoParticipante);

    void edit(SvaTipoParticipante svaTipoParticipante);

    void remove(SvaTipoParticipante svaTipoParticipante);

    SvaTipoParticipante find(Object id);

    List<SvaTipoParticipante> findAll();

    List<SvaTipoParticipante> findRange(int[] range);

    int count();
    
}
