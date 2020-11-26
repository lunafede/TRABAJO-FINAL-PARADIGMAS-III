/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objeto.TipoCliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaTipoCliente extends AbstractTableModel {
    
    private ArrayList<TipoCliente> altipo = new ArrayList();

    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.altipo = datos;
        
    }
    
    
    

    @Override
    public int getRowCount() {
          return altipo.size();
    }

    @Override
    public int getColumnCount() {
               return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      TipoCliente obj = altipo.get(rowIndex);
       switch(columnIndex){
           
           case 0: return obj.getDescripcion();
           case 1: return obj.getId();
           
        default : return "";
    }
    }
    
    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Descripcion";
           case 1: return "id";
          
        default : return "";
    }
    }
    
}
