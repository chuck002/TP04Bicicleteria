/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author javy
 */
public class Conexion implements Serializable {
    
    Connection con;
    
    public Conexion()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           //con = DriverManager.getConnection("jdbc:mysql://node57479-env-1000665.jelastic.saveincloud.net/BicicleteriaWeb","root","U5pdbgwpcg");
           con = DriverManager.getConnection("jdbc:mysql://localhost/BicicleteriaWeb","","");
        } catch (Exception ex) {
            System.err.println("Error"+ex);
        }
    }

    public Connection getCon() {
        return con;
    }

}
