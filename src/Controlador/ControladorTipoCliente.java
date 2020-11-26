/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.TipoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fefe
 */
public class ControladorTipoCliente {
     Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
    
    public TipoCliente mostrar(int id){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        TipoCliente obj = null;
        

        
        try {
                    ps = con.prepareStatement("select * from tipo_cliente where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            obj = new TipoCliente(rs.getInt(1),
                    rs.getString(2));
                    

                
            }
        } catch (Exception e) {
            System.out.println(e+"tipo");
        }
        
        
        
        return obj;
    
    }
    
    
      public ArrayList<TipoCliente> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        TipoCliente obj =null;
        
        ArrayList<TipoCliente>  alTipo = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from tipo_cliente");
                    
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new TipoCliente(rs.getInt(1),
                    rs.getString(2));
                    
            
             alTipo.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Tipo");
        }
    return alTipo;
    }
      
       public void Guardar(TipoCliente t) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        TipoCliente obj = new TipoCliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.tipo_cliente(\n" +
"	  descripcion)\n" +
"	VALUES ( ?);");
            
            
            
            ps.setString(1,t.getDescripcion());
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Tipo"+e);
        }
        
    } 
       
        public void Eliminar(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.tipo_cliente\n" +
"	WHERE id = ?");
            
            ps.setInt(1, id);
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino "+e);
        }
 
  }
        
        
        
         public void Modificar(TipoCliente t) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        TipoCliente obj = new TipoCliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("UPDATE public.tipo_cliente\n" +
"	SET  descripcion=?\n" +
"	WHERE id = ?");
            
            
            
            ps.setString(1,t.getDescripcion());
            ps.setInt(2, t.getId());
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Tipo"+e);
        }
        
    } 
      
}
