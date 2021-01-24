package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Pedal extends Piezas implements Serializable {

    public Pedal(int codigo, String tipo, double precio, int cantidad) {
        super(codigo, tipo, precio, cantidad);
    }


}
