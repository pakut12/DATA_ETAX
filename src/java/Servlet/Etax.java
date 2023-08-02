/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.*;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.MD_Etax;
import org.json.JSONArray;
import org.json.JSONObject;
import service.EtaxService;
import service.SapService;

/**
 *
 * @author pakutsing
 */
public class Etax extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String type = request.getParameter("type").trim();
            if (type.equals("getdataformsap")) {
                try {

                    String BUKRS = request.getParameter("BUKRS").trim();
                    String LBLDAT = request.getParameter("LBLDAT").trim();
                    String HBLDAT = request.getParameter("HBLDAT").trim();
                    String LKUNRG = request.getParameter("LKUNRG").trim();
                    String HKUNRG = request.getParameter("HKUNRG").trim();
                    String LBRNCH = request.getParameter("LBRNCH").trim();
                    String HBRNCH = request.getParameter("HBRNCH").trim();
                    String LDOCTYPE = request.getParameter("LDOCTYPE").trim();
                    String HDOCTYPE = request.getParameter("HDOCTYPE").trim();

                    JSONObject jsontxt = SapService.GetDataEtaxFromSap(BUKRS, LBLDAT, HBLDAT, LKUNRG, HKUNRG, LBRNCH, HBRNCH, LDOCTYPE, HDOCTYPE);

                    out.print(jsontxt);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("savefile")) {
                try {

                    String BUKRS = request.getParameter("BUKRS").trim();
                    String LBLDAT = request.getParameter("LBLDAT").trim();
                    String HBLDAT = request.getParameter("HBLDAT").trim();
                    String LKUNRG = request.getParameter("LKUNRG").trim();
                    String HKUNRG = request.getParameter("HKUNRG").trim();
                    String LBRNCH = request.getParameter("LBRNCH").trim();
                    String HBRNCH = request.getParameter("HBRNCH").trim();
                    String LDOCTYPE = request.getParameter("LDOCTYPE").trim();
                    String HDOCTYPE = request.getParameter("HDOCTYPE").trim();

                    List<MD_Etax> listetax = EtaxService.GetAllListEtax(BUKRS, LBLDAT, HBLDAT, LKUNRG, HKUNRG, LBRNCH, HBRNCH, LDOCTYPE, HDOCTYPE);
                    List<List<String>> list = EtaxService.SaveCsvEtax(listetax);

                    JSONArray arr = new JSONArray();
                    for (List<String> LS : list) {
                        arr.put(LS);
                    }
                    
                    JSONObject obj = new JSONObject();
                    obj.put("data", arr);
                   
                    //String filename = url.replace("file/", "");
/*
                    JSONObject obj = new JSONObject();
                    obj.put("url", url);
                    obj.put("filename", filename);
                     */
                    out.print(obj);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            out.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
// </editor-fold>
}
