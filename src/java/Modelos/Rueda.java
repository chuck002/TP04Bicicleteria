package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Rueda extends Piezas implements Serializable {

    public Rueda(int codigo, String tipo, double precio, int cantidad) {
        super(codigo, tipo, precio, cantidad);
    }

}
