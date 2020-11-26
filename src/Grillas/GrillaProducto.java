/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Controlador.ControladorProducto;
import Objeto.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaProducto extends AbstractTableModel {
    
     private ArrayList<Producto> alProduc = new ArrayList();

    public GrillaProducto(ArrayList<Producto> datos) {
        this.alProduc = datos;
        
    }
    

    @Override
    public int getRowCount() {
         return alProduc.size();
    }

    @Override
    public int getColumnCount() {
              return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
       Producto obj = alProduc.get(rowIndex);
       switch(columnIndex){
           case 0: return obj.getCodigo();
           case 1: return obj.getDescripcion();
           case 2: return obj.getPrecio();
          case 3: return obj.getCategoria().getDescripcion();
           case 4: return obj.getId();
        default : return "";
    }
    }
    
     @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Codigo";
           case 1: return "Descripcion";
           case 2: return "Precio";
           case 3: return "Categoria";
           case 4: return "id";
        default : return "";
    }
    }
    
}
