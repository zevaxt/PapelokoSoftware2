/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgModelo.GestionUsuario;

/**
 *
 * @author EDUARD
 */
@WebServlet(name = "LogicaUsuarios", urlPatterns
        = {
            "/LogicaUsuarios"
        })

public class LogicaUsuarios extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private GestionUsuario Usuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String Operacion = request.getParameter("Operacion");
        this.Usuario = new GestionUsuario();

        if( Operacion.equals("Agregar") ){
            try {
               
                this.Usuario.ingresarUsuario(Integer.parseInt( request.getParameter("Id") ), request.getParameter("Nombre"), request.getParameter("Apellido"),
                                        request.getParameter("Rol"), request.getParameter("Credencial"));
            //response.getWriter().print(this.Usuario.getUsuariosID(1));*/
                response.getWriter().print("Exito");
            } 
            catch (Exception e) {
                response.getWriter().print("Error");
            }
            

            //Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        else if( Operacion.equals("Actualizar") ){

        }
        else if( Operacion.equals("Eliminar") ){

        }
        else if( Operacion.equals("Consultar") ){

        }
        else{

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LogicaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LogicaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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
