/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaInforme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaInformeFacadeLocal {

    void create(SvaInforme svaInforme);

    void edit(SvaInforme svaInforme);

    void remove(SvaInforme svaInforme);

    SvaInforme find(Object id);

    List<SvaInforme> findAll();

    List<SvaInforme> findRange(int[] range);

    int count();
    
}
