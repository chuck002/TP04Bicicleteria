/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public class Bicicletero extends Usuario implements Serializable{

    public Bicicletero(String user, String pass, String rol, String Nombre) {
        super(user, pass, rol, Nombre);
    }

    @Override
    public String getVista() {
        return "Bicicletero.jsp";
    }
    
}
