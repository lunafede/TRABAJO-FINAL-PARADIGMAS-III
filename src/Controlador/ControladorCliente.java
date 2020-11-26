/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fefe
 */
public class ControladorCliente {
      Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
     public Cliente mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
         Cliente obj = null; 
        ControladorTipoCliente ct = new ControladorTipoCliente();
       
        try {

            ps = con.prepareStatement("select * from clientes where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Cliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(5), rs.getString(3),
                    rs.getInt(6),
                    ct.mostrar(rs.getInt(4)));
                    

            }
        } catch (Exception e) {
            System.out.println(e+"Cliente");
        }
        
        
        
        return obj;
   
    }
     
     public ArrayList<Cliente> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Cliente obj = null;
       ArrayList<Cliente>  alCliente = new ArrayList<> ();
        ControladorTipoCliente ct = new ControladorTipoCliente();
          try {
        ps = con.prepareStatement("select * from clientes ");
            
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Cliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(5), rs.getString(3),
                    rs.getInt(6),
                    ct.mostrar(rs.getInt(4)));
                    

            
             alCliente.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Caso");
        }
    return alCliente;
    }
     
     public void Guardar(Cliente c) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Cliente obj = new Cliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.clientes(\n" +
"	 nombre, razon_social, tipo_cliente_id, \"Dni\", telefono)\n" +
"	VALUES ( ?, ?, ?, ?, ?);");
            
            
            ps.setString(1,c.getNombre());
            
            ps.setString(2,c.getRazonSocial());
            ps.setInt(3,c.getTipo().getId());
           
            ps.setInt(4,c.getDni());
            ps.setInt(5, c.getTelefono());
            
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar clientes"+e);
        }
        
    }
  
    public void Modificar(Cliente c) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Cliente obj = new Cliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("UPDATE public.clientes SET nombre = ?, razon_social= ?, tipo_cliente_id= ?, Dni= ?, telefono= ?  WHERE id = ? ");
            
            
            ps.setString(1,c.getNombre());
            ps.setString(2,c.getRazonSocial());
            ps.setInt(3,c.getTipo().getId());
            ps.setInt(4,c.getDni());
            ps.setInt(5, c.getTelefono());
            ps.setInt(6, c.getId());
            
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar clientes"+e);
        }
        
    }
     
  public void Eliminar(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.clientes \n" +
"	WHERE id = ?");
            
            ps.setInt(1, id);
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino el clientes"+e);
        }
 
  }
  
  
    public void EliminarTipoCliente(Integer id){
    
    Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.clientes \n" +
"	WHERE tipo_cliente_id = ?");
            
            ps.setInt(1, id);
           
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Se elimino el clientes"+e);
        }
 
  }

     
}
