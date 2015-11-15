package org.jsuns.commerce;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TipoDocumentoService {

    public int ver_ser (int iddoc, int idalm) {
        int ser = 0;
//            Statement st = con.conexion();
//            String ver_ser_doc = "select ser_doc from documento_almacen where idtipo_doc = '"+iddoc+"' and idAlmacen = '"+idalm+"'";
//            ResultSet rs = con.consulta(st, ver_ser_doc);
//            if (rs.next()) {
//                ser = rs.getInt("ser_doc");
//            }
//            con.cerrar(rs);
//            con.cerrar(st);
        return ser;
    }
    
    public int ver_num (int iddoc, int idalm) {
        int num = 0;
      
//            String ver_ser_doc = "select nro_doc from documento_almacen where idtipo_doc = '"+iddoc+"' and idAlmacen = '"+idalm+"'";
//            ResultSet rs = con.consulta(st, ver_ser_doc);
//            if (rs.next()) {
//                num = rs.getInt("nro_doc");
//            }

        return num;
    }
        
    public void act_doc (int serie, int nro, int idalm, int tido) {
//            String upd_doc = "update documento_almacen 
        //set ser_doc = '"+serie+"', nro_doc = '"+nro+"'"
//                    + " where idAlmacen = '"+idalm+"' 
        //and idtipo_doc = '"+tido+"'";
      
    }
    
}
