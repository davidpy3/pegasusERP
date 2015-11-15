/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.ejb;

import java.util.List;
import javax.ejb.Local;
import edu.uns.sgsi.jpa.GsiPrrbProgBackup;

/**
 *
 * @author Administrador
 */
@Local
public interface GsiPrrbProgBackupFacadeLocal {

    void create(GsiPrrbProgBackup gsiPrrbProgBackup);

    void edit(GsiPrrbProgBackup gsiPrrbProgBackup);

    void remove(GsiPrrbProgBackup gsiPrrbProgBackup);

    GsiPrrbProgBackup find(Object id);

    List<GsiPrrbProgBackup> findAll();

    List<GsiPrrbProgBackup> findRange(int[] range);

    int count();
    
}
