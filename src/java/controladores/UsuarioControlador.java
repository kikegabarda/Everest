/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModUsuario;

/**
 *
 * @author cetecom
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {
    @EJB ModUsuario  modUsuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();
        Usuario usuario4 = new Usuario();
        
        usuario1.setRut("18.156.869-5");
        usuario1.setNombre("Eduardo");
        usuario1.setApellido("Friedman");
        usuario1.setPassword("rustinpiece");
        usuario1.setTelefono("+56985695412");
        usuario1.setDireccion("Guillermo Man 563");
        usuario1.setCorreo("e.fried@gmail.com");
        usuario1.setTipo("Administrador");
        
        usuario2.setRut("5.468.186-1");
        usuario2.setNombre("Javier");
        usuario2.setApellido("Godinez");
        usuario2.setPassword("detodasformasnose");
        usuario2.setTelefono("+569451684232");
        usuario2.setDireccion("Lira 425");
        usuario2.setCorreo("j.godinez@hotmail.com");
        usuario2.setTipo("Empleado");
        
        usuario3.setRut("16.782.694-3");
        usuario3.setNombre("Choro");
        usuario3.setApellido("Navia");
        usuario3.setPassword("gol123");
        usuario3.setTelefono("+56948569124");
        usuario3.setDireccion("San Diego 756");
        usuario3.setCorreo("elchoro@outlook.cl");
        usuario3.setTipo("Empleado");
        
        usuario4.setRut("18.248.318-K");
        usuario4.setNombre("Steve");
        usuario4.setApellido("Jobs");
        usuario4.setPassword("11001101");
        usuario4.setTelefono("+56945896175");
        usuario4.setDireccion("Diagonal Paraguay 502");
        usuario4.setCorreo("steve.jobs@gmail.com");
        usuario4.setTipo("Empleado");
        
        try {
            modUsuario.crearUsuario(usuario1);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Usuario> lista = null;
        
        try {
            lista = modUsuario.todosUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
        request.setAttribute("lista", lista);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/vistas/informe.jsp");
        rd.forward(request, response);
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
