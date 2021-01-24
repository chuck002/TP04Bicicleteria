/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Asiento;
import Modelos.Bicicleta;
import Modelos.Cuadro;
import Modelos.KitMecanico;
import Modelos.Manubrio;
import Modelos.Pedal;
import Modelos.Piezas;
import Modelos.Rueda;
import ModelosDAO.BicicletasDAO;
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
public class ControladorBicicletero extends HttpServlet implements Serializable {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            BicicletasDAO biciDAO = new BicicletasDAO();

            List<Bicicleta> list = new ArrayList<>();
            list = biciDAO.listar();
            request.setAttribute("ListaBicis", list);

            acceso = "Bicicletero_Listar.jsp";
        }
        if (accion.equalsIgnoreCase("crear")) {
            String codigo = "0";

            request.setAttribute("codigo", codigo);

             PiezasDAO piezaDAO = new PiezasDAO();
            List<Piezas> lista = new ArrayList<>();
            lista = piezaDAO.listar();
            request.setAttribute("ListaPiezas", lista);
     
            acceso = "Bicicletero_Agregar.jsp";
        }
        if (accion.equalsIgnoreCase("AgregarPieza")) {
            String codigo = request.getParameter("codigo");
            String tipo = request.getParameter("tipo");
            String cantidad = request.getParameter("cantidad");
            String precio = request.getParameter("precio");

            cantidad = String.valueOf(Integer.parseInt(cantidad) - 1);

            Piezas p = null;
            switch (tipo) {
                case "Pedal":
                    p = new Pedal(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    break;
                case "Rueda":
                    p = new Rueda(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    ;
                    break;
                case "Manubrio":
                    p = new Manubrio(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    break;
                case "Cuadro":
                    p = new Cuadro(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    break;
                case "Asiento":
                    p = new Asiento(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    break;
                case "Kit Mecanico":
                    p = new KitMecanico(Integer.parseInt(codigo), tipo, Double.parseDouble(precio), Integer.parseInt(cantidad));
                    break;
            }

            PiezasDAO dao = new PiezasDAO();

            dao.editar((Object) p);

            List lista = new ArrayList<>();
            lista = dao.listar();

            request.setAttribute("ListaPiezas", lista);

            acceso = "Bicicletero_Agregar.jsp";
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
        String accion = request.getParameter("accion");
        String acceso = "";

        String[] cargaPiezas = request.getParameterValues("piezasCargadas");
        String cantidadBici = request.getParameter("cantidadBici");
        String precioBici = request.getParameter("precioBici");
        String nombreBici = request.getParameter("nombreBici");
        String codigoBici = request.getParameter("codigoBici");
        String codigoPiezas = request.getParameter("pruebaCodigo");
        
        if (accion.equalsIgnoreCase("prueba")) {
        
            if (Integer.parseInt(codigoPiezas) > 0) {

                PiezasDAO dao = new PiezasDAO();
                List<Piezas> lista = new ArrayList<>();
                lista = dao.listarPiezaPorCodigo(codigoPiezas);
                
                BicicletasDAO biciDAO = new BicicletasDAO();
                List<Bicicleta> li = new ArrayList<>();
                li = biciDAO.listar();
                                
                       request.setAttribute("proxCodigo", li.size()+1);
               

                if (lista.size() == 6) {
                    request.setAttribute("piezasCodigo", lista);
                    request.setAttribute("codigo", codigoPiezas);
                } else {
                    codigoPiezas = "-1000";
                    request.setAttribute("codigo", codigoPiezas.trim());
                }

                acceso = "Bicicletero_Agregar.jsp";
            } else if (Integer.parseInt(codigoPiezas) == 0) {
                request.setAttribute("codigo", codigoPiezas);
                
               acceso = "Bicicletero_Agregar.jsp";
            }
        }
        
        if (accion.equalsIgnoreCase("agregaBici")) {

            String salida = "";
            if(cargaPiezas.length < 6)
            {
                request.setAttribute("Error2", "No se eligieron todas las piezas.");
                request.setAttribute("codigo", "2");
                acceso = "Vista_Error.jsp";
            }
            else if (precioBici.equalsIgnoreCase("") || nombreBici.equalsIgnoreCase("")) {
                String error = "";
                if(precioBici.equalsIgnoreCase(""))
                {
                    error = "No se eligio un precio para la Bicicleta.";
                }
                else
                {
                    error = "No se eligio un nombre para la Bicicleta.";
                }
                request.setAttribute("Error3", error);
                request.setAttribute("codigo", "3");
                acceso = "Vista_Error.jsp";
                
            } else {

                PiezasDAO dao = new PiezasDAO();
                List<Piezas> lista = new ArrayList<>();
                lista = dao.listarPiezaPorCodigo(codigoPiezas);
                String datos = "";
                for (Piezas p : lista) {
                    switch (p.getTipo()) {
                        case "Pedal":
                            p.setCantidad(p.getCantidad() - 2 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "2 Pedales; ";
                            break;
                        case "Rueda":
                            p.setCantidad(p.getCantidad() - 2 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "2 Ruedas; ";
                            break;
                        case "Manubrio":
                            p.setCantidad(p.getCantidad() - 1 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "1 Manubrio; ";
                            break;
                        case "Cuadro":
                            p.setCantidad(p.getCantidad() - 1 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "1 Cuadro; ";
                            break;
                        case "Asiento":
                            p.setCantidad(p.getCantidad() - 1 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "1 Asiento; ";
                            break;
                        case "Kit Mecanico":
                            p.setCantidad(p.getCantidad() - 1 * Integer.parseInt(cantidadBici));
                            dao.editar(p);
                            datos = datos + "1 Kit Mecanico.";
                            break;
                    }
                }
                BicicletasDAO biciDAO = new BicicletasDAO();
                List<Bicicleta> li = new ArrayList<>();
                li = biciDAO.listar();

                Bicicleta bici = new Bicicleta(Integer.parseInt(codigoBici), nombreBici, Integer.parseInt(cantidadBici), datos, Double.parseDouble(precioBici));

                biciDAO.agregar(bici);
                
                for(Bicicleta b: li)
                {
                    if(b.getCodigo() == Integer.parseInt(codigoBici))
                    {
                        if(b.getCantidad() == Integer.parseInt(cantidadBici))
                        {
                            biciDAO.remover(Integer.parseInt(codigoBici), b.getNombre());
                        }
                        else if(b.getCantidad() > Integer.parseInt(cantidadBici))
                        {
                        b.setCantidad(b.getCantidad()-Integer.parseInt(cantidadBici));
                        biciDAO.editar(b);
                        }
                    }
                }
                acceso = "Bicicletero.jsp";
            }
        }

        RequestDispatcher v = request.getRequestDispatcher(acceso);
        v.forward(request, response);
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
