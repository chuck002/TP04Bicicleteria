/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Bicicleta;
import ModelosDAO.BicicletasDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ControladorVendedor extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorVendedor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVendedor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String piezas = request.getParameter("piezas");
        String cantidad = request.getParameter("cantidad");
        String precio = request.getParameter("precio");
        if (accion.equalsIgnoreCase("VenderBicicleta")) {
            request.setAttribute("codigo", codigo);
            request.setAttribute("nombre", nombre);
            request.setAttribute("piezas", piezas);
            request.setAttribute("cantidad", cantidad);
            request.setAttribute("precio", precio);
            acceso = "Vendedor_Vender.jsp";
        }
        if(accion.equalsIgnoreCase("volver"))
        {
            BicicletasDAO biciDAO = new BicicletasDAO();
            List<Bicicleta> lista = new ArrayList<>();
            lista = biciDAO.listar();
            request.setAttribute("listaBici", lista);
            acceso = "Vendedor.jsp";
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
        String acceso = "";
        String cantidadVenta = request.getParameter("cantidadBici");
        String codigo = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        String piezas = request.getParameter("piezas");
        String precio = request.getParameter("precio");

        BicicletasDAO dao = new BicicletasDAO();
        List list = new ArrayList();
        list = dao.listar();

        for (Bicicleta b : (List<Bicicleta>) list) {
            
            if (b.getCodigo() == Integer.parseInt(codigo) && b.getNombre().equalsIgnoreCase(nombre)) {
                
                if (Integer.parseInt(cantidadVenta) < b.getCantidad()) {
                    request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("piezas", piezas);
                    request.setAttribute("cantidad", cantidadVenta);
                    request.setAttribute("precio", String.valueOf(Double.parseDouble(precio) * Integer.parseInt(cantidadVenta)));
                    b.setCantidad(b.getCantidad()-Integer.parseInt(cantidadVenta));
                    dao.editar(b);
                    acceso = "Vendedor_VentaCompleta.jsp";
                } else if (Integer.parseInt(cantidadVenta) == b.getCantidad()) {
                    request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("piezas", piezas);
                    request.setAttribute("cantidad", cantidadVenta);
                    request.setAttribute("precio", String.valueOf(Double.parseDouble(precio) * Integer.parseInt(cantidadVenta)));
                    b.setCantidad(Integer.parseInt(cantidadVenta));
                    dao.remover(b.getCodigo(), b.getNombre());
                    acceso = "Vendedor_VentaCompleta.jsp";
                }
                else
                {
                    request.setAttribute("Error1", "Cantidad no Disponible en el Stock");
                    request.setAttribute("codigo", "1");
                    acceso = "Vista_error.jsp";
                    
                }
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
