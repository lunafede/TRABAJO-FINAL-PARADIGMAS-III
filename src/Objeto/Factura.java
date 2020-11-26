/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objeto;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Fefe
 */
public class Factura {
    
    private Integer id;
    private Integer numero;
    private Date fecha;
    private Integer total, cantidadDeProd;
    private String formasDePago;
    
    
    private Cliente cliente;
    
    private ArrayList<Renglon> detalle;
    

    public Factura() {
    }

    public Factura(Integer id, Integer numero, Date fecha, Integer total, Integer cantidadDeProd, String formasDePago, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.total = total;
        this.cantidadDeProd = cantidadDeProd;
        this.formasDePago = formasDePago;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCantidadDeProd() {
        return cantidadDeProd;
    }

    public void setCantidadDeProd(Integer cantidadDeProd) {
        this.cantidadDeProd = cantidadDeProd;
    }

    public String getFormasDePago() {
        return formasDePago;
    }

    public void setFormasDePago(String formasDePago) {
        this.formasDePago = formasDePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Renglon> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Renglon> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", total=" + total + ", cantidadDeProd=" + cantidadDeProd + ", formasDePago=" + formasDePago + ", cliente=" + cliente + ", detalle=" + detalle + '}';
    }
    
    

    

   
    
    
    
}
