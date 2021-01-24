/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Asiento;
import Modelos.Cuadro;
import Modelos.KitMecanico;
import Modelos.Manubrio;
import Modelos.Pedal;
import Modelos.Piezas;
import Modelos.Rueda;
import ModelosDAO.PiezasDAO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javy
 */
public class ControladorEncargado extends HttpServlet implements Serializable {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpServletRequest request;
    HttpServletResponse response;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            PiezasDAO dao = new PiezasDAO();
            List<Piezas> lista = new ArrayList<>();
            lista = dao.listar();
            request.setAttribute("ListaPiezas", lista);
            acceso = "Encargado_Listar.jsp";
        }
        if (accion.equalsIgnoreCase("crear")) {
            acceso = "Encargado_Agregar.jsp";
        }

        if (accion.equalsIgnoreCase("Agregar Pieza")) {
            int codigo = Integer.parseInt(request.getParameter("codigoPieza"));
            String tipo = request.getParameter("Pieza");
            double precio = Double.parseDouble(request.getParameter("precioPieza"));
            int cantidad = Integer.parseInt(request.getParameter("cantidadPieza"));

            Piezas p = null;
            switch (tipo) {
                case "Pedal":
                    p = new Pedal(codigo, tipo, precio, cantidad);
                    break;
                case "Rueda":
                    p = new Rueda(codigo, tipo, precio, cantidad);
                    break;
                case "Manubrio":
                    p = new Manubrio(codigo, tipo, precio, cantidad);
                    break;
                case "Cuadro":
                    p = new Cuadro(codigo, tipo, precio, cantidad);
                    break;
                case "Asiento":
                    p = new Asiento(codigo, tipo, precio, cantidad);
                    break;
                case "Kit Mecanico":
                    p = new KitMecanico(codigo, tipo, precio, cantidad);
                    break;
            }
            PiezasDAO dao = new PiezasDAO();
            List<Piezas> list = new ArrayList<>();
            list = dao.listar();
            boolean esta = false;
            for (Piezas pieza : (List<Piezas>) list) {
                if (pieza.getCodigo() == codigo && pieza.getTipo().equalsIgnoreCase(tipo)) {
                    dao.editar(p);
                    esta = true;
                }

            }
            if (!esta) {
                dao.agregar(p);
            }

            acceso = "Encargado.jsp";
        }

        RequestDispatcher v = request.getRequestDispatcher(acceso);
        v.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
