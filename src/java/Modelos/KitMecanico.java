package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class KitMecanico extends Piezas implements Serializable {

    public KitMecanico(int codigo, String tipo, double precio, int cantidad) {
        super(codigo, tipo, precio, cantidad);
    }


}
