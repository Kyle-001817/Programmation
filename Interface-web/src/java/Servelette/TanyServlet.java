/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelette;

import interface_foncier.TanyRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Kyle
 */
public class TanyServlet extends HttpServlet {
    
    private TanyRemote tany_remote;
    
    @Override
    public void init()throws ServletException{
        super.init();
        Properties prop = new Properties();
        try{
            prop.load(getServletContext().getResourceAsStream("/WEB-INF/jndi.properties"));
            Context context = new InitialContext();
            tany_remote = (TanyRemote) context.lookup("interface_foncier.TanyRemote");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(" text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String coordinates = request.getParameter("coordinates");
        String frontiere = request.getParameter("frontiere");
        String cin = request.getParameter("cin");
        cin = cin.replace("\r", "").replaceAll("[+\\s]+", "");
        String[] coordsArray = coordinates.split(",");
        String[] latitudeArray = new String[coordsArray.length / 2];
        String[] longitudeArray = new String[coordsArray.length / 2];
        for (int i = 0; i < coordsArray.length; i += 2) {
            latitudeArray[i / 2] = coordsArray[i];
            longitudeArray[i / 2] = coordsArray[i + 1];
//            tany_remote.insert(frontiere,longitudeArray[i / 2],latitudeArray[i / 2], cin);
        }
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
