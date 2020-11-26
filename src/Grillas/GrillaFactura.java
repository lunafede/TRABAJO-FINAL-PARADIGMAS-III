/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Objeto.Factura;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaFactura extends AbstractTableModel {
    
     private ArrayList<Factura> alfactura = new ArrayList();

    public GrillaFactura(ArrayList<Factura> datos) {
        this.alfactura = datos;
        
    }
     
     

    @Override
    public int getRowCount() {
         return alfactura.size();
    }

    @Override
    public int getColumnCount() {
           return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Factura obj = alfactura.get(rowIndex);
       switch(columnIndex){
           case 0: return obj.getNumero();
           case 1: return obj.getFecha();
           case 2: return obj.getTotal();
           case 3: return obj.getCliente().getRazonSocial();
           case 4: return obj.getFormasDePago();
           case 5: return obj.getId();
        default : return "";
    }
}
    
     @Override
    public String getColumnName(int column) {
         switch(column){
           case 0: return "Numero";
           case 1: return "Fecha";
           case 2: return "Total";
           case 3: return "Cliente";
           case 4: return "FormasDePago";
           case 5: return "id";
        default : return "";
    }
    }
}
