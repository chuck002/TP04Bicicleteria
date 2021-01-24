/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelos.Bicicleta;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javy
 */
public class BicicletasDAO implements CRUD, Serializable {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Bicicleta bici;

    @Override
    public <T> List<T> listar() {
        ArrayList<T> list = new ArrayList<>();
        int codigo;
        String nombre;
        int cantidad;
        String piezas;
        double precio;
        try {
            con = cn.getCon();
            ps = con.prepareStatement("Select * from Bicicletas");
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("COD");
                nombre = rs.getString("Nombre");
                cantidad = rs.getInt("Cantidad");
                piezas = rs.getString("Piezas");
                precio = rs.getDouble("Precio");
                bici = new Bicicleta();
                bici.setCodigo(codigo);
                bici.setCantidad(cantidad);
                bici.setNombre(nombre);
                bici.setPiezas(piezas);
                bici.setPrecio(precio);
                list.add((T) bici);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Object list(int id, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Object obj) {
        try {
            con = cn.getCon();
            Bicicleta bici1 = (Bicicleta) obj;
            ps = con.prepareStatement("INSERT INTO Bicicletas (COD, Nombre, Piezas, Cantidad, Precio) values ('" + bici1.getCodigo() + "','" + bici1.getNombre() + "','" + bici1.getPiezas() + "','" + bici1.getCantidad() + "','" + bici1.getPrecio() + "')");
            System.out.println(bici1.getNombre());
            ps.executeUpdate();

            
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean editar(Object obj) {
        try {
            con = cn.getCon();
            bici = (Bicicleta) obj;
            ps = con.prepareStatement("UPDATE Bicicletas SET Cantidad='"+bici.getCantidad()+"' WHERE COD='"+bici.getCodigo()+"'");
            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean remover(int id, String tipo) {
        try {
            con = cn.getCon();
            ps = con.prepareStatement("DELETE FROM Bicicletas WHERE COD = '"+id+"' AND NOMBRE='"+tipo+"'");
            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return false;
    }

}
