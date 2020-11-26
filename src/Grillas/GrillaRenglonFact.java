/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grillas;

import Controlador.ControladorProducto;
import Objeto.Renglon;
import Objeto.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fefe
 */
public class GrillaRenglonFact extends AbstractTableModel {
    
    private ArrayList<Renglon> alDeta = new ArrayList();

    public GrillaRenglonFact(ArrayList<Renglon> datos) {
        this.alDeta = datos;
        
    }

    @Override
    public int getRowCount() {
       return alDeta.size();
    }

    @Override
    public int getColumnCount() {
           return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ControladorProducto cp = new ControladorProducto();
        Producto p = new Producto();
        Renglon obj = alDeta.get(rowIndex);
       switch(columnIndex){
          
           case 0: return obj.getPrecioUni();
           case 1: return obj.getCantidad();
           case 2: return obj.getSubTotal();
           case 3: return obj.getProducto().getDescripcion();
           case 4: p=cp.mostrar(obj.getProducto().getId());
           return p.getDescripcion();
         
           
           
        default : return "";
    }
    
}
    
    
     @Override
    public String getColumnName(int column) {
         switch(column){
           case 0: return "precioUnitario";
           case 1: return "Cantidad";
           case 2: return "Subtotal";
           case 3: return "descripcion";
           
           case 4: return "Producto";
        default : return "";
    }
    }
    
}
