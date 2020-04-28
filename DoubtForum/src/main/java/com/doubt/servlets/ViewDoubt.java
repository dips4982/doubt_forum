/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doubt.servlets;

import com.doubt.data.DataConnection;
import com.doubt.domain.Doubt;
import com.doubt.data.ItemDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adesh
 */
//@WebServlet(name = "ViewDoubt", urlPatterns = {"/ViewDoubt"})
@WebServlet("")
public class ViewDoubt extends HttpServlet {

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
//        try(PrintWriter out=response.getWriter())
//        {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Add</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> Welcome</h1>");
            ItemDao itemdata=DataConnection.getItemDao();
            List<Doubt> doubtsList = itemdata.getFullItems();
//            int l=0;
//            l=doubtsList.size();
            //out.println("<h1> Baby </h1
//            out.println("<ul>");
//            for( Doubt doubts:doubtsList)
//            out.println("<li>"+doubts.getQuestion()+"</li>");
//            out.println("</ul>");
        request.setAttribute("doubtsList",doubtsList);
        ServletContext context=getServletContext();
        RequestDispatcher dispatch=context.getRequestDispatcher("/index.jsp");
        dispatch.forward(request, response);
//             out.println("</body>");
//               out.println("</html>");
//        }
                
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
