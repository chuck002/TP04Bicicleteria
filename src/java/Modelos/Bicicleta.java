package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Bicicleta implements Serializable{
    
   
    double precio;
    int codigo;
    String nombre;
    int cantidad;
    String piezas;

    public String getPiezas() {
        return piezas;
    }

    public void setPiezas(String piezas) {
        this.piezas = piezas;
    }

    public Bicicleta() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Bicicleta(int codigo, String nombre, int cantidad, String piezas, double precio) {
        
        this.precio = precio;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.piezas = piezas; 
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return piezas;
    }
    
}
