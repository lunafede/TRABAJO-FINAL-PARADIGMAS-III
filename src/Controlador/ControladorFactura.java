/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Objeto.Renglon;
import Objeto.Factura;
import Util.FechaSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fefe
 */
public class ControladorFactura {
     Connection con;
    PreparedStatement ps,ps2;
    ResultSet rs;
    
      public Factura mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj = null; 
        ControladorCliente cc = new ControladorCliente();
        ControladorFactura cf = new ControladorFactura();
        
        try {

            ps = con.prepareStatement("select * from facturas where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
           
           
            
            obj = new Factura(rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3),
                    rs.getInt(4),
                    rs.getInt(6),
                    rs.getString(5),
                    cc.mostrar(rs.getInt(7)));
                    

            }
        } catch (Exception e) {
            System.out.println(e+"Facturas");
        }

        
        return obj;
   
    }
      
       public ArrayList<Factura> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj =null;
        
        ControladorCliente cc = new ControladorCliente();
        
        
        ArrayList<Factura> alFactura = new ArrayList<>();
        
          try {
        ps = con.prepareStatement("select * from facturas ");
            
            rs = ps.executeQuery();
            while (rs.next()){
            
         
            
            obj = new Factura(rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3),
                    rs.getInt(4),
                    rs.getInt(6),
                    rs.getString(5),
                    cc.mostrar(rs.getInt(7)));

            
             alFactura.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Factura");
        }
    
             return alFactura;
    }
       
       
      public void Guardar(Factura f) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj = new Factura();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.facturas(\n" +
"	 numero, fecha, total, formas_de_pago, cantidad_producto, cliente)\n" +
"	VALUES ( ?, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
            
            
            ps.setInt(1,f.getNumero());
            ps.setDate(2, FechaSQL.convertirfechasql(f.getFecha()));
            ps.setInt(3,f.getTotal());
            ps.setString(4,f.getFormasDePago());
            ps.setInt(5,f.getCantidadDeProd());
            ps.setInt(6,f.getCliente().getId());
            if (ps.executeUpdate()>0) {
                
                rs = ps.getGeneratedKeys();
             
                while (rs.next()) {
                    obj.setId(rs.getInt(1)); 
                    ps2 = con.prepareStatement("INSERT INTO public.renglon(\n" +
"	 cantidad, precio_unitario, subtotal, producto, factura)\n" +
"	VALUES ( ?, ?, ?, ?, ?);");
                    
                    for (Renglon detalle : f.getDetalle()) {
                       
                        ps2.setInt(1, detalle.getCantidad());
                        ps2.setInt(2, detalle.getPrecioUni());
                        ps2.setInt(3, detalle.getSubTotal());
                        ps2.setInt(4, detalle.getProducto().getId());
                        ps2.setInt(5, obj.getId());
                        
                        
                         if (ps2.executeUpdate()>0) {
                            }else{con.rollback();}
                    }
                    
                   
              } 
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Factura"+e);
        }
        
    } 
      
  public void Eliminar(Object id){
    
  Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj = null; 
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.facturas\n" +
"	WHERE  id = ?");
            
            ps.setInt(1, (int)id);
            
            
            
            
            if (ps.executeUpdate()>0) {
                
                
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("eliminar "+e);
        }
 
  }
     public void EliminarFacturaCliente(Integer id){
    
  Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj = null; 
        
        try {
            
            ps=con.prepareStatement("DELETE FROM public.facturas\n" +
"	WHERE  cliente = ?");
            
            ps.setInt(1, (int)id);
            
            
            
            
            if (ps.executeUpdate()>0) {
                
                
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("eliminar "+e);
        }
 
  }
     
   public ArrayList<Factura> MostrarTodoFacturaCliente (Integer idCliente){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj =null;
        
        ControladorCliente cc = new ControladorCliente();
        
        
        ArrayList<Factura> alFactura = new ArrayList<>();
        
          try {
        ps = con.prepareStatement("select * from facturas where cliente = ?");
            
            ps.setInt(1 , idCliente);
            rs = ps.executeQuery();
            while (rs.next()){
            
         
            
            obj = new Factura(rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3),
                    rs.getInt(4),
                    rs.getInt(6),
                    rs.getString(5),
                    cc.mostrar(rs.getInt(7)));

            
             alFactura.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Factura");
        }
    
             return alFactura;
    }
   
   
   public void Modificar(Factura f) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Factura obj = new Factura();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("UPDATE public.facturas\n" +
"	SET  numero=?, fecha=?, total=?, formas_de_pago=?, cantidad_producto=?, cliente=?\n" +
"	WHERE id = ?");
            
            
            ps.setInt(1,f.getNumero());
            ps.setDate(2, FechaSQL.convertirfechasql(f.getFecha()));
            ps.setInt(3,f.getTotal());
            ps.setString(4,f.getFormasDePago());
            ps.setInt(5,f.getCantidadDeProd());
            ps.setInt(6,f.getCliente().getId());
            ps.setInt(7, f.getId());
            if (ps.executeUpdate()>0) {
                
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Modificar Factura"+e);
        }
        
    } 
   
}
