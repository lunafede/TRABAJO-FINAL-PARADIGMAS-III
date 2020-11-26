/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Date;

/**
 *
 * @author Fefe
 */
public class FechaSQL {
    public static java.sql.Date convertirfechasql(Date fecha){
    
    java.sql.Date fechasql=null;
    fechasql= new java.sql.Date(fecha.getTime());
    return fechasql;
    
    }
    
}
