/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Trial;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-raghu
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"}, initParams = {
    @WebInitParam(name = "Name", value = "Value")})
public class LoginServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        if(request.getSession(false)!= null)
        {
            
        }
        
        String username = request.getParameter("UserName");
        String password = request.getParameter("Password");
        
        if(username instanceof String && password instanceof String )
        {
            /*PrintWriter out = response.getWriter();
            out.println(String.format("User Name : %s", username));
            out.println(String.format("Password : %s", password));
            */
            request.setAttribute("TestAttribute1","Raghu");
            RequestDispatcher disp = request.getRequestDispatcher("/Authenticator/autho");
            
            disp.forward(request, response);
        }
        else
        {
            RequestDispatcher disp =  request.getRequestDispatcher("Error.html"); //request.getRequestDispatcher("/Error.html"); //getServletContext().getRequestDispatcher("Error.html"); 
            disp.include(request, response);                
           
        }        
        out.println("Servlet Error");
        
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
