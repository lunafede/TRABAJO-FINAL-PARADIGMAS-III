/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.Renglon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fefe
 */
public class ControladorRenglon {
    
    Connection con;
    PreparedStatement ps,ps2;
    ResultSet rs;
    
     public Renglon mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Renglon obj = null; 
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
            
        
        try {

            ps = con.prepareStatement("select * from renglon  where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            
           
            
            obj = new Renglon(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));

            }
        } catch (Exception e) {
            System.out.println(e+"DEtalle");
        }
        
        
        
        return obj;
   
    }
     
      public ArrayList<Renglon> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Renglon obj =null;
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
        ArrayList<Renglon>  alDetall = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from renglon");
                    
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new Renglon(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));


            
             alDetall.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Detalles");
        }
    return alDetall;
    }
    
     public void Guardar(Renglon d) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Renglon obj = new Renglon();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.renglon(\n" +
"	 cantidad, precio_unitario, subtotal, producto, factura)\n" +
"	VALUES ( ?, ?, ?, ?, ?);");
            
            
            ps.setInt(1,d.getCantidad());
           ps.setInt(2,d.getPrecioUni());
          ps.setInt(3,d.getSubTotal());
           ps.setInt(4,d.getProducto().getId());
           ps.setInt(5,d.getFactura().getId());
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Detalle "+e);
        }
        
    }
     
     
     
  public void Eliminar(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.renglon\n" +
"	WHERE id = ?");
            
            ps.setInt(1, id);
            
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino "+e);
        }
 
  }
  
    public void EliminarFactura(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.renglon\n" +
"	WHERE factura = ?");
            
            ps.setInt(1, id);
            
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino "+e);
        }
 
  }
    
      public ArrayList<Renglon> MostrarTodoDetalleFactura (Integer idFactura){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Renglon obj =null;
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
        ArrayList<Renglon>  alDetall = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from renglon where factura = ?");
             
            ps.setInt(1 , idFactura);
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new Renglon(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));


            
             alDetall.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Detalles");
        }
    return alDetall;
    }
      
      
      
      
       public void EliminarProducto(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.renglon\n" +
"	WHERE producto = ?");
            
            ps.setInt(1, id);
            
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino "+e);
        }
 
  }
       
       public ArrayList<Renglon> MostrarTodoDetalleProducto (Integer idProducto){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Renglon obj =null;
        ControladorProducto cp = new ControladorProducto();
        ControladorFactura cf = new ControladorFactura();
        ArrayList<Renglon>  alDetall = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from renglon where producto = ?");
             
            ps.setInt(1 , idProducto);
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new Renglon(rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   cp.mostrar(rs.getInt(5)),
                   cf.mostrar(rs.getInt(6)));


            
             alDetall.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Detalles");
        }
    return alDetall;
    }
       
       
       
       
    
    
}
