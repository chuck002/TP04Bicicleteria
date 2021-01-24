package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Asiento extends Piezas implements Serializable {

    public Asiento(int codigo, String tipo, double precio, int cantidad) {
        super(codigo, tipo, precio, cantidad);
    }

}
