/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.*;

import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.logging.SimpleFormatter;
import javax.servlet.*;
import javax.servlet.http.*;
import model.MD_Etax;
import org.apache.poi.ss.formula.functions.Dec2Bin;
import org.json.JSONArray;
import org.json.JSONObject;
import service.EtaxService;
import service.SapService;

import utility.Utility;

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
                    String LBRNCH = request.getParameter("LBRNCH").trim();
                    String HBRNCH = request.getParameter("HBRNCH").trim();

                    JSONObject jsontxt = SapService.GetDataEtaxFromSap(BUKRS, LBLDAT, HBLDAT, LBRNCH, HBRNCH);

                    out.print(jsontxt);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("savefile")) {
                try {

                    String BUKRS = request.getParameter("BUKRS").trim();
                    String LBLDAT = request.getParameter("LBLDAT").trim();
                    String HBLDAT = request.getParameter("HBLDAT").trim();
                    String LBRNCH = request.getParameter("LBRNCH").trim();
                    String HBRNCH = request.getParameter("HBRNCH").trim();
                    String DOCTYPE = request.getParameter("DOCTYPE").trim();

                    List<String> TYPE = Utility.SetListType(DOCTYPE);
                    List<MD_Etax> listetax = EtaxService.GetAllListEtax(BUKRS, LBLDAT, HBLDAT, LBRNCH, HBRNCH);

                    System.out.println(listetax.size());
                    List<MD_Etax> listbytype = new ArrayList<MD_Etax>();

                    System.out.println("DOCTYPE : " + DOCTYPE);
                    for (MD_Etax t : listetax) {
                        if (TYPE.contains(t.getDOCTYPE())) {
                            System.out.println("getDOCTYPE : " + t.getDOCTYPE());
                            listbytype.add(t);
                        }
                    }

                    List<List<String>> list = EtaxService.SaveCsvEtax(listbytype);

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
            } else if (type.equals("getdatasumetax")) {
                try {

                    String BUKRS = request.getParameter("BUKRS").trim();
                    String LBLDAT = request.getParameter("LBLDAT").trim();
                    String HBLDAT = request.getParameter("HBLDAT").trim();
                    String LBRNCH = request.getParameter("LBRNCH").trim();
                    String HBRNCH = request.getParameter("HBRNCH").trim();
                    String DOCTYPE = request.getParameter("DOCTYPE").trim();

                    List<String> TYPE = Utility.SetListType(DOCTYPE);

                    List<MD_Etax> listetax = EtaxService.GetAllListEtax(BUKRS, LBLDAT, HBLDAT, LBRNCH, HBRNCH);
                    List<MD_Etax> listsum = EtaxService.GetAllSumListEtax(listetax);


                    JSONArray data = new JSONArray();

                    double BASICAMT_TOTAL = 0;
                    double TAXAMT_TOTAL = 0;
                    double GRANDAMT_TOTAL = 0;

                    for (MD_Etax m : listsum) {

                        if (m.getBLDAT() == null && m.getDOCID() == null && m.getSBRANCH() == null && m.getDOCTYPE() == null && m.getDOCNAME() == null && m.getKUNRG() == null && m.getSTAXID() == null && m.getBASICAMT() == null && m.getTAXAMT() == null && m.getGRANDAMT() == null) {
                            continue;
                        } else {
                            System.out.println(m.getDOCTYPE());
                            System.out.println(TYPE);
                            if (TYPE.contains(m.getDOCTYPE())) {


                                JSONObject obj = new JSONObject();
                                obj.put("BLDAT", m.getBLDAT());
                                obj.put("DOCID", m.getDOCID());
                                obj.put("SBRANCH", m.getSBRANCH());
                                obj.put("DOCTYPE", m.getDOCTYPE());
                                obj.put("DOCNAME", m.getDOCNAME());
                                obj.put("KUNRG", m.getKUNRG());
                                obj.put("STAXID", m.getSTAXID());
                                obj.put("BASICAMT", m.getBASICAMT());
                                obj.put("TAXAMT", m.getTAXAMT());
                                obj.put("GRANDAMT", m.getGRANDAMT());
                                data.put(obj);

                                BASICAMT_TOTAL += Double.parseDouble(m.getBASICAMT());
                                TAXAMT_TOTAL += Double.parseDouble(m.getTAXAMT());
                                GRANDAMT_TOTAL += Double.parseDouble(m.getGRANDAMT());


                            }

                        }



                        System.out.println("---------------------------------------------------");
                        System.out.println("BLDAT : " + m.getBLDAT());
                        System.out.println("DOCID : " + m.getDOCID());
                        System.out.println("SBRANCH : " + m.getSBRANCH());
                        System.out.println("DOCTYPE : " + m.getDOCTYPE());
                        System.out.println("DOCNAME : " + m.getDOCNAME());
                        System.out.println("KUNRG : " + m.getKUNRG());
                        System.out.println("STAXID : " + m.getSTAXID());
                        System.out.println("BASICAMT : " + m.getBASICAMT());
                        System.out.println("TAXAMT : " + m.getTAXAMT());
                        System.out.println("GRANDAMT : " + m.getGRANDAMT());
                        System.out.println("---------------------------------------------------");

                    }

                    JSONArray datacol = new JSONArray();
                    String[] cols = {"BLDAT", "DOCID", "SBRANCH", "DOCTYPE", "DOCNAME", "KUNRG", "STAXID", "BASICAMT", "TAXAMT", "GRANDAMT"};

                    for (String c : cols) {

                        JSONObject objcol = new JSONObject();
                        objcol.put("title", c);
                        objcol.put("data", c);
                        datacol.put(objcol);

                    }

                    DecimalFormat df = new DecimalFormat("#,###.00");


                    JSONObject outputdata = new JSONObject();
                    outputdata.put("data", data);
                    outputdata.put("datacols", datacol);
                    outputdata.put("BASICAMT_TOTAL", df.format(BASICAMT_TOTAL));
                    outputdata.put("TAXAMT_TOTAL", df.format(TAXAMT_TOTAL));
                    outputdata.put("GRANDAMT_TOTAL", df.format(GRANDAMT_TOTAL));


                    out.print(outputdata);

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