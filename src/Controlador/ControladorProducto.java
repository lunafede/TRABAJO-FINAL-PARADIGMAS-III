/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fefe
 */
public class ControladorProducto {
    
    Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
    
     public Producto mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
         Producto obj = null; 
        ControladorCategoria cc = new ControladorCategoria();
       
        try {

            ps = con.prepareStatement("select * from productos where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            
           
            
            obj = new Producto(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getInt(4),
                    cc.mostrar(rs.getInt(5)));

            }
        } catch (Exception e) {
            System.out.println(e+"Producto");
        }
        
        
        
        return obj;
   
    }
     
     
     public ArrayList<Producto> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = null;
       ArrayList<Producto>  alProducto = new ArrayList<> ();
        ControladorCategoria cc = new ControladorCategoria();
          try {
        ps = con.prepareStatement("select * from Productos ");
            
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Producto(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getInt(4),
                    cc.mostrar(rs.getInt(5)));

            
             alProducto.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Producto");
        }
    return alProducto;
    }
     
     
     public void Guardar(Producto p) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = new Producto();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.productos(\n" +
"	 codigo, descripcion, precio, categoria)\n" +
"	VALUES ( ?, ?, ?, ?);");
            
            
           
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getDescripcion());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4,p.getCategoria().getId());
          
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Productos"+e);
        }
        
    }
     
     
            public void Eliminar(Object id){
    
  Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = null; 
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.productos\n" +
"	WHERE  id = ?");
            
            ps.setInt(1, (int)id);
            
            
            
            
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("eliminar "+e);
        }
 
  }
     
   
    public void Modificar(Producto p) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = new Producto();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("UPDATE public.productos\n" +
"	SET  codigo=?, descripcion=?, precio=?, categoria=?\n" +
"	WHERE id = ?");
            
            
           
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getDescripcion());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4,p.getCategoria().getId());
            ps.setInt(5, p.getId());
          
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Modificar Productos"+e);
        }
        
    }
       
    
    
    public void EliminarCategoria(Object id){
    
  Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = null; 
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.productos\n" +
"	WHERE  categoria = ?");
            
            ps.setInt(1, (int)id);
            
            
            
            
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("eliminar "+e);
        }
 
  }
    
    
    
    public ArrayList<Producto> MostrarTodoProductoCate (Integer idCateg){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Producto obj = null;
       ArrayList<Producto>  alProducto = new ArrayList<> ();
        ControladorCategoria cc = new ControladorCategoria();
          try {
        ps = con.prepareStatement("select * from Productos where categoria = ? ");
            
            ps.setInt(1 , idCateg);
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Producto(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getInt(4),
                    cc.mostrar(rs.getInt(5)));

            
             alProducto.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Producto");
        }
    return alProducto;
    }
         
    
}
