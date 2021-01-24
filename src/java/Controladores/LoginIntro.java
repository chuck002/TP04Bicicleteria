/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Bicicleta;
import Modelos.Usuario;
import ModelosDAO.BicicletasDAO;
import ModelosDAO.UsuariosDAO;
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
public class LoginIntro extends HttpServlet implements Serializable {

    Usuario us = null;

    void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String password = request.getParameter("pass");
        UsuariosDAO dao = new UsuariosDAO(usuario, password);
        us = dao.obtenerUsuario();

        request.setAttribute("nombre", us.getNombre());
        if (us.getVista().equalsIgnoreCase("Vendedor.jsp")) {
            BicicletasDAO biciDAO = new BicicletasDAO();
            List<Bicicleta> lista = new ArrayList<>();
            lista = biciDAO.listar();
            request.setAttribute("listaBici", lista);
        }
        RequestDispatcher v = request.getRequestDispatcher(us.getVista());
        v.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
