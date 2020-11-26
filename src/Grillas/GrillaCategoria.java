/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objeto.Categoria;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaCategoria extends AbstractTableModel{
    private ArrayList<Categoria> alCateg = new ArrayList();
    public GrillaCategoria(ArrayList<Categoria> datos) {
        this.alCateg = datos;
        
    }

    @Override
    public int getRowCount() {
      return alCateg.size();
    }

    @Override
    public int getColumnCount() {
          return 2;
          
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Categoria obj = alCateg.get(rowIndex);
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
