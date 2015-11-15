/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.ejb;

import java.util.List;
import javax.ejb.Local;
import edu.uns.sgsi.jpa.GsiPrrbBackup;

/**
 *
 * @author Administrador
 */
@Local
public interface GsiPrrbBackupFacadeLocal {

    void create(GsiPrrbBackup gsiPrrbBackup);

    void edit(GsiPrrbBackup gsiPrrbBackup);

    void remove(GsiPrrbBackup gsiPrrbBackup);

    GsiPrrbBackup find(Object id);

    List<GsiPrrbBackup> findAll();

    List<GsiPrrbBackup> findRange(int[] range);

    int count();
    
}
