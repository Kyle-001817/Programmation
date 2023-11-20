package Servelette;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RetraitRemote;
import model.VersementRemote;
import models.Versement;

/**
 *
 * @author Kyle
 */
public class Find extends HttpServlet {
    
    private VersementRemote versement_remote;
    private RetraitRemote retrait_remote;
    
    @Override
    public void init()throws ServletException{
        super.init();
        Properties prop = new Properties();
        try{
            prop.load(getServletContext().getResourceAsStream("/WEB-INF/jndi.properties"));
            Context context = new InitialContext();
            versement_remote = (VersementRemote) context.lookup("model.VersementRemote");
            retrait_remote = (RetraitRemote) context.lookup("model.RetraitRemote");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("cin");
        String webServiceURL = "http://localhost:5124/api/personne/perso?cin="+name;
        URL url = new URL(webServiceURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder resp = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                resp.append(inputLine);
            }
            in.close();
            String jsonResponse = resp.toString();

            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            request.setAttribute("json", jsonObject);
            out.println(jsonObject);
        }
        List<Versement> versements= versement_remote.selectVersementbyId(name);
        double versement = versement_remote.sommeSoldeVersementParPersonne(name);
        request.setAttribute("num", versement);
        request.setAttribute("cin", name);
        
        conn.disconnect();

        request.getRequestDispatcher("sante.jsp").forward(request, response);
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
