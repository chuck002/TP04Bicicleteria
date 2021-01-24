package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Cuadro extends Piezas implements Serializable {

    public Cuadro(int codigo, String tipo, double precio, int cantidad) {
        super(codigo, tipo, precio, cantidad);
    }
    
}
