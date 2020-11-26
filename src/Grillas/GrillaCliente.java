/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objeto.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaCliente extends AbstractTableModel {
    
    private ArrayList<Cliente> alClient = new ArrayList();
    public GrillaCliente(ArrayList<Cliente> datos) {
        this.alClient = datos;
        
    }
    

    @Override
    public int getRowCount() {
        return alClient.size();
    }


    @Override
    public int getColumnCount() {
           return 6;
          
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Cliente obj = alClient.get(rowIndex);
       switch(columnIndex){
           case 0: return obj.getNombre();
           case 1: return obj.getDni();
           case 2: return obj.getRazonSocial();
           case 3: return obj.getTelefono();
           case 4: return obj.getTipo().getDescripcion();
           case 5: return obj.getId();
           
        default : return "";
    }
    }
    
    
     @Override
    public String getColumnName(int column) {
         switch(column){
           case 0: return "nombre";
           case 1: return "Dni";
           case 2: return "Razon social";
           case 3: return "telefono";
           case 4: return "Tipo Cliente";
           case 5: return "id";
        default : return "";
    }
    }
    
    
}
