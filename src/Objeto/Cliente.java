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
public class Cliente {
    
    private Integer id;
    private String nombre;
    private Integer Dni;
    private String razonSocial;
    private Integer telefono;
    
   private TipoCliente tipo;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, Integer Dni, String razonSocial, Integer telefono, TipoCliente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.Dni = Dni;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDni() {
        return Dni;
    }

    public void setDni(Integer Dni) {
        this.Dni = Dni;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    
   

    @Override
    public String toString() {
        return  this.getRazonSocial();
    }

    
   
    

   

    
    
    
}
