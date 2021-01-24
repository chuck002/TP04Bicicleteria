/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelos.Asiento;
import Modelos.Cuadro;
import Modelos.KitMecanico;
import Modelos.Manubrio;
import Modelos.Pedal;
import Modelos.Piezas;
import Modelos.Rueda;
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
public class PiezasDAO implements CRUD, Serializable {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Piezas pieza;

    @Override
    public Object list(int id, String tipo) {
        Piezas pieza = null;
        PiezasDAO dao = new PiezasDAO();
        List<Piezas> lista = new ArrayList<>();
        lista = dao.listar();
        for (Piezas p : lista) {
            if (p.getCodigo() == id && p.getTipo().equalsIgnoreCase(tipo)) {
                pieza = p;
            }
        }
        return pieza;
    }

    @Override
    public boolean agregar(Object obj) {
        try {
            con = cn.getCon();

            Piezas p = (Piezas) obj;
            ps = con.prepareStatement("insert into Piezas(COD, Tipo, Cantidad, Precio) values ('" + p.getCodigo() + "','" + p.getTipo() + "','" + p.getCantidad() + "','" + p.getPrecio() + "')");
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Object obj) {
        try {
            con = cn.getCon();
            Piezas p = (Piezas) obj;
            ps = con.prepareStatement("UPDATE Piezas SET Cantidad='" + p.getCantidad() + "' WHERE COD='" + p.getCodigo() + "' AND Tipo='" + p.getTipo() + "'");
            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean remover(int id, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> List<T> listar() {
        List<T> list = new ArrayList<>();
        int codigo;
        String tipo;
        int cantidad;
        double precio;
        try {
            con = cn.getCon();
            ps = con.prepareStatement("Select * from Piezas");
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("COD");
                tipo = rs.getString("Tipo");
                cantidad = rs.getInt("Cantidad");
                precio = rs.getDouble("Precio");
                switch (tipo) {
                    case "Pedal":
                        pieza = new Pedal(codigo, tipo, precio, cantidad);
                        break;
                    case "Rueda":
                        pieza = new Rueda(codigo, tipo, precio, cantidad);
                        break;
                    case "Manubrio":
                        pieza = new Manubrio(codigo, tipo, precio, cantidad);
                        break;
                    case "Cuadro":
                        pieza = new Cuadro(codigo, tipo, precio, cantidad);
                        break;
                    case "Asiento":
                        pieza = new Asiento(codigo, tipo, precio, cantidad);
                        break;
                    case "Kit Mecanico":
                        pieza = new KitMecanico(codigo, tipo, precio, cantidad);
                        break;
                }
                list.add((T) pieza);
            }
        } catch (SQLException e) {
        }

        return list;

    }

    public <T> List<T> listarPiezaPorTipo(String tipoPieza) {
        List<T> list = new ArrayList<>();
        int codigo;
        String tipo;
        int cantidad;
        double precio;
        try {
            con = cn.getCon();
            ps = con.prepareStatement("Select cod from Piezas Where Tipo='" + tipoPieza + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("COD");
                tipo = rs.getString("Tipo");
                cantidad = rs.getInt("Cantidad");
                precio = rs.getDouble("Precio");
                switch (tipo) {
                    case "Pedal":
                        pieza = new Pedal(codigo, tipo, precio, cantidad);
                        break;
                    case "Rueda":
                        pieza = new Rueda(codigo, tipo, precio, cantidad);
                        break;
                    case "Manubrio":
                        pieza = new Manubrio(codigo, tipo, precio, cantidad);
                        break;
                    case "Cuadro":
                        pieza = new Cuadro(codigo, tipo, precio, cantidad);
                        break;
                    case "Asiento":
                        pieza = new Asiento(codigo, tipo, precio, cantidad);
                        break;
                    case "Kit Mecanico":
                        pieza = new KitMecanico(codigo, tipo, precio, cantidad);
                        break;
                }
                list.add((T) pieza);
            }
        } catch (SQLException e) {
        }

        return list;

    }

    public <T> List<T> listarPiezaPorCodigo(String codigoPieza) {
        List<T> list = new ArrayList<>();
        int codigo;
        String tipo;
        int cantidad;
        double precio;
        try {
            con = cn.getCon();
            ps = con.prepareStatement("Select * from Piezas Where COD='" + codigoPieza + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("COD");
                tipo = rs.getString("Tipo");
                cantidad = rs.getInt("Cantidad");
                precio = rs.getDouble("Precio");
                switch (tipo) {
                    case "Pedal":
                        pieza = new Pedal(codigo, tipo, precio, cantidad);
                        break;
                    case "Rueda":
                        pieza = new Rueda(codigo, tipo, precio, cantidad);
                        break;
                    case "Manubrio":
                        pieza = new Manubrio(codigo, tipo, precio, cantidad);
                        break;
                    case "Cuadro":
                        pieza = new Cuadro(codigo, tipo, precio, cantidad);
                        break;
                    case "Asiento":
                        pieza = new Asiento(codigo, tipo, precio, cantidad);
                        break;
                    case "Kit Mecanico":
                        pieza = new KitMecanico(codigo, tipo, precio, cantidad);
                        break;
                }
                list.add((T) pieza);
            }
        } catch (SQLException e) {
        }

        return list;

    }
}
