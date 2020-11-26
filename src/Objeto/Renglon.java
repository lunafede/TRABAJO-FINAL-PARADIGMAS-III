/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

/**
 *
 * @author Fefe
 */
public class Renglon {
    
    
    private Integer id, cantidad, precioUni, subTotal;
    
    
    private Producto producto;
    private Factura factura;

    public Renglon() {
    }

    public Renglon(Integer id,Integer cantidad, Integer precioUni, Integer subTotal, Producto producto, Factura factura) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUni = precioUni;
        this.subTotal = subTotal;
        this.producto = producto;
        this.factura = factura;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Integer precioUni) {
        this.precioUni = precioUni;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    

    @Override
    public String toString() {
        return "Detalle{" + "id=" + id + ", precioUni=" + precioUni + ", subTotal=" + subTotal + ", producto=" + producto + ", factura=" + factura + '}';
    }
    
    
    
    
}
