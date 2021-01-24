/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Modelos.Bicicletero;
import Modelos.Encargado;
import Modelos.Usuario;
import Modelos.Vendedor;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author javy
 */
public class UsuariosDAO implements Serializable{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
        
    private String user, pass, nombre, rol;
    private Usuario usuario = null;
    public UsuariosDAO(String user, String pass)
    {
        this.user = user;
        this.pass = pass;
    }
    
    public Usuario obtenerUsuario()
    {
        try {
            con = cn.getCon();
            
            ps = con.prepareStatement("Select * from Usuarios where User='"+user+"' AND Pass='"+pass+"'");
            rs = ps.executeQuery();
            while(rs.next())
            {
                nombre = rs.getString("Nombre");
                rol = rs.getString("Rol");
                
                switch(rol)
                {
                    case "Vendedor":
                        usuario = new Vendedor(user, pass, rol, nombre);
                        break;
                    case "Bicicletero":
                        usuario = new Bicicletero(user, pass, rol, nombre);
                        break;
                    case "Encargado":
                        usuario = new Encargado(user, pass, rol, nombre);
                        break;
                }
            }
        } catch (Exception e) {
        }
        return usuario;
    }
    
}
