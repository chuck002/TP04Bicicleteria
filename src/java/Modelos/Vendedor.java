/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author javy
 */
public class Vendedor extends Usuario {

    public Vendedor(String user, String pass, String rol, String Nombre) {
        super(user, pass, rol, Nombre);
    }

    @Override
    public String getVista() {
        return "Vendedor.jsp";
    }
}
