/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MD_Etax;
import utility.ConnectSap;
import utility.Utility;

/**
 *
 * @author pakutsing
 */
public class EtaxService {

    private static String pathlocal = "C:/Users/pakutsing/Desktop/Github/DATA_ETAX/build/web/file/";
    private static String pathserver = "/web/webapps/DATA_ETAX/file/";

    public static List<MD_Etax> GetAllListEtax(String BUKRS, String LBLDAT, String HBLDAT, String LKUNRG, String HKUNRG, String LBRNCH, String HBRNCH, String LDOCTYPE, String HDOCTYPE) {
        List<MD_Etax> listall = new ArrayList<MD_Etax>();
        try {
            JCO.Client client = ConnectSap.createpool();

            String version = JCO.getVersion();

            System.out.println("SAP : " + version);

            JCO.Repository repository = new JCO.Repository("Myrep", client);
            IFunctionTemplate ftemplate1 = repository.getFunctionTemplate("ZRFC_LIST_ETAX_DATA");
            JCO.Function function1 = new JCO.Function(ftemplate1);
            JCO.ParameterList input1 = function1.getImportParameterList();

            input1.setValue(BUKRS, "BUKRS");
            input1.setValue(LBLDAT, "LBLDAT");
            input1.setValue(HBLDAT, "HBLDAT");
            input1.setValue(LKUNRG, "LKUNRG");
            input1.setValue(HKUNRG, "HKUNRG");
            input1.setValue(LBRNCH, "LBRNCH");
            input1.setValue(HBRNCH, "HBRNCH");
            input1.setValue(LDOCTYPE, "LDOCTYPE");
            input1.setValue(HDOCTYPE, "HDOCTYPE");
            client.execute(function1);

            //System.out.println(function1);
            JCO.Table output = function1.getTableParameterList().getTable("ITAB_ETAX");

            //System.out.println(output);
            int numColumns = output.getFieldCount();
            int numrow = output.getNumRows();

            int a = 0;

            while (a < numrow) {
                output.setRow(a);

                MD_Etax etax = new MD_Etax();
                etax.setBLDAT(output.getString("BLDAT"));
                etax.setBUKRS(output.getString("BUKRS"));
                etax.setBRNCH(output.getString("BRNCH"));
                etax.setDOCID(output.getString("DOCID"));
                etax.setDOCTYPE(output.getString("DOCTYPE"));
                etax.setDOCNAME(output.getString("DOCNAME"));
                etax.setKUNRG(output.getString("KUNRG"));
                etax.setKNAME(output.getString("KNAME"));
                etax.setTAXTYPE(output.getString("TAXTYPE"));
                etax.setDATATYPE(output.getString("DATATYPE"));
                etax.setSTAXID(output.getString("STAXID"));
                etax.setSBRANCH(output.getString("SBRANCH"));
                etax.setPRODUCTID(output.getString("PRODUCTID"));
                etax.setDOCDATE(output.getString("DOCDATE"));
                etax.setPURPOSECODE(output.getString("PURPOSECODE"));
                etax.setPURPOSE(output.getString("PURPOSE"));
                etax.setADDREFID(output.getString("ADDREFID"));
                etax.setADDREFDATE(output.getString("ADDREFDATE"));
                etax.setADDREFTYPE(output.getString("ADDREFTYPE"));
                etax.setADDREFNAME(output.getString("ADDREFNAME"));
                etax.setORDERID(output.getString("ORDERID"));
                etax.setORDERDATE(output.getString("ORDERDATE"));
                etax.setSENDEMAIL(output.getString("SENDEMAIL"));
                etax.setSENDDATE(output.getString("SENDDATE"));
                etax.setBUYERTAXID(output.getString("BUYERTAXID"));
                etax.setBBRANCHID(output.getString("BBRANCHID"));
                etax.setBPOSTCODE(output.getString("BPOSTCODE"));
                etax.setBADDRESS1(output.getString("BADDRESS1"));
                etax.setBADDRESS2(output.getString("BADDRESS2"));
                etax.setBCOUNTRY(output.getString("BCOUNTRY"));
                etax.setLINEID(output.getString("LINEID"));
                etax.setPRODUCTNAME(output.getString("PRODUCTNAME"));
                etax.setPRODUCTDESC(output.getString("PRODUCTDESC"));
                etax.setPRODUCTAMT(output.getString("PRODUCTAMT"));
                etax.setPRODUCTCUR(output.getString("PRODUCTCUR"));
                etax.setPRODUCTQTY(output.getString("PRODUCTQTY"));
                etax.setPRODUCTUNIT(output.getString("PRODUCTUNIT"));
                etax.setLTAXCODE(output.getString("LTAXCODE"));
                etax.setLTAXRATE(output.getString("LTAXRATE"));
                etax.setLBASICAMT(output.getString("LBASICAMT"));
                etax.setLBASICCUR(output.getString("LBASICCUR"));
                etax.setLTAXAMT(output.getString("LTAXAMT"));
                etax.setLTAXCUR(output.getString("LTAXCUR"));
                etax.setLALLOWIND(output.getString("LALLOWIND"));
                etax.setLALLOWAMT(output.getString("LALLOWAMT"));
                etax.setLALLOWCUR(output.getString("LALLOWCUR"));
                etax.setLTOTAMT(output.getString("LTOTAMT"));
                etax.setLTOTCUR(output.getString("LTOTCUR"));
                etax.setLNETAMT(output.getString("LNETAMT"));
                etax.setLNETCUR(output.getString("LNETCUR"));
                etax.setLINCAMT(output.getString("LINCAMT"));
                etax.setLINCCUR(output.getString("LINCCUR"));
                etax.setPREMARK1(output.getString("PREMARK1"));
                etax.setPREMARK2(output.getString("PREMARK2"));
                etax.setPREMARK3(output.getString("PREMARK3"));
                etax.setPREMARK4(output.getString("PREMARK4"));
                etax.setPREMARK5(output.getString("PREMARK5"));
                etax.setPREMARK6(output.getString("PREMARK6"));
                etax.setPREMARK7(output.getString("PREMARK7"));
                etax.setPREMARK8(output.getString("PREMARK8"));
                etax.setPREMARK9(output.getString("PREMARK9"));
                etax.setLINEIDTOT(output.getString("LINEIDTOT"));
                etax.setTAXCODE(output.getString("TAXCODE"));
                etax.setTAXRATE(output.getString("TAXRATE"));
                etax.setBASICAMT(output.getString("BASICAMT"));
                etax.setBASICCUR(output.getString("BASICCUR"));
                etax.setTAXAMT(output.getString("TAXAMT"));
                etax.setTAXCUR(output.getString("TAXCUR"));
                etax.setALLOWIND(output.getString("ALLOWIND"));
                etax.setALLOWAMT(output.getString("ALLOWAMT"));
                etax.setALLOWCUR(output.getString("ALLOWCUR"));
                etax.setORITOTAMT(output.getString("ORITOTAMT"));
                etax.setORITOTCUR(output.getString("ORITOTCUR"));
                etax.setLINETOTAMT(output.getString("LINETOTAMT"));
                etax.setLINETOTCUR(output.getString("LINETOTCUR"));
                etax.setADJUSTAMT(output.getString("ADJUSTAMT"));
                etax.setADJUSTCUR(output.getString("ADJUSTCUR"));
                etax.setALLOWTOTAMT(output.getString("ALLOWTOTAMT"));
                etax.setALLOWTOTCUR(output.getString("ALLOWTOTCUR"));
                etax.setBASICTOTAMT(output.getString("BASICTOTAMT"));
                etax.setBASICTOTCUR(output.getString("BASICTOTCUR"));
                etax.setTAXTOTAMT(output.getString("TAXTOTAMT"));
                etax.setTAXTOTCUR(output.getString("TAXTOTCUR"));
                etax.setGRANDAMT(output.getString("GRANDAMT"));
                etax.setGRANDCUR(output.getString("GRANDCUR"));
                etax.setTERMPAYMENT(output.getString("TERMPAYMENT"));
                etax.setDOCREMARK1(output.getString("DOCREMARK1"));
                etax.setDOCREMARK2(output.getString("DOCREMARK2"));

                listall.add(etax);
                a++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listall;
    }

    private static int getsumdocbydocid(List<MD_Etax> etax, String doc_id) {
        int sumdoc = 0;

        for (MD_Etax listdata : etax) {
            if (doc_id.equals(listdata.getDOCID()) && listdata.getDATATYPE().equals("L")) {
                sumdoc++;
            }
        }

        return sumdoc;

    }

    private static List<String> getSumDoc(List<MD_Etax> etax) {

        int sum = 0;
        List<String> docid = new ArrayList<String>();

        for (MD_Etax doc : etax) {
            if (!docid.contains(doc.getDOCID())) {
                docid.add(doc.getDOCID());
            }
        }



        return docid;
    }

    private static void writeLine(FileWriter writer, List<String> values) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.size(); i++) {
                String txt = "\"" + values.get(i) + "\"";

                sb.append(txt);
                if (i < values.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("\n");
            writer.append(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String SaveCsvEtax(List<MD_Etax> etax) throws IOException, SQLException {


        String url = "";
        try {

            String path = pathlocal + "DATA_ETAX_" + Utility.getdatetoday() + ".csv";
            FileWriter writer = new FileWriter(path);

            List<MD_Etax> Groupdata = Groupdata(etax);
            List<String> docid = getSumDoc(etax);

            System.out.println(Groupdata.size());
            System.out.println(docid.size());

            for (String id : docid) {
                System.out.println(id);
                for (MD_Etax listdata : Groupdata) {
                    if (listdata.getDOCID().equals(id)) {
                        List<String> datarow = getDataByDataType(listdata);
                        writeLine(writer, datarow);
                    }
                }
            }


            List<String> datatypeT = new ArrayList<String>();
            datatypeT.add("T");
            datatypeT.add(String.valueOf(docid.size()));
            writeLine(writer, datatypeT);



            url = "file/DATA_ETAX_" + Utility.getdatetoday() + ".csv";
        } catch (Exception e) {
            e.printStackTrace();
            url = "";
        }

        return url;
    }

    private static List<MD_Etax> Groupdata(List<MD_Etax> etax) {
        List<MD_Etax> listgroup = new ArrayList<MD_Etax>();

        List<String> listtype = new ArrayList<String>();
        try {

            for (MD_Etax doc : etax) {
                if (doc.getDATATYPE().equals("C")) {
                    if (!listtype.contains(doc.getSTAXID() + "#" + doc.getSBRANCH())) {
                        listtype.add(doc.getSTAXID() + "#" + doc.getSBRANCH());
                        listgroup.add(doc);
                    }
                } else {
                    listgroup.add(doc);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return listgroup;
    }

    private static List<String> getDataByDataType(MD_Etax dataetex) {
        List<String> datarow = new ArrayList<String>();
        try {

            if (dataetex.getDATATYPE().equals("C")) {

                if (dataetex.getDOCTYPE().equals("T03")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getSTAXID());
                    datarow.add(dataetex.getSBRANCH());
                    datarow.add("");
                } else if (dataetex.getDOCTYPE().equals("80") || dataetex.getDOCTYPE().equals("81")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getSTAXID());
                    datarow.add(dataetex.getSBRANCH());
                    datarow.add("");
                } else {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getSTAXID());
                    datarow.add(dataetex.getSBRANCH());
                    datarow.add("");
                }
            } else if (dataetex.getDATATYPE().equals("H")) {

                if (dataetex.getDOCTYPE().equals("T03")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getDOCTYPE());
                    datarow.add(dataetex.getDOCNAME());
                    datarow.add(dataetex.getDOCID());
                    datarow.add(dataetex.getDOCDATE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getORDERID());
                    datarow.add(dataetex.getORDERDATE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBRNCH());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getSENDEMAIL());
                } else if (dataetex.getDOCTYPE().equals("80") || dataetex.getDOCTYPE().equals("81")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getDOCTYPE());
                    datarow.add(dataetex.getDOCNAME());
                    datarow.add(dataetex.getDOCID());
                    datarow.add(dataetex.getDOCDATE());
                    datarow.add(dataetex.getPURPOSECODE());
                    datarow.add(dataetex.getPURPOSE());
                    datarow.add(dataetex.getADDREFID());
                    datarow.add(dataetex.getADDREFDATE());
                    datarow.add(dataetex.getADDREFTYPE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getSENDEMAIL());
                } else {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getDOCTYPE());
                    datarow.add(dataetex.getDOCNAME());
                    datarow.add(dataetex.getDOCID());
                    datarow.add(dataetex.getDOCDATE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getORDERID());
                    datarow.add(dataetex.getORDERDATE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBRNCH());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getSENDEMAIL());
                }

            } else if (dataetex.getDATATYPE().equals("B")) {
                if (dataetex.getDOCTYPE().equals("T03") || dataetex.getDOCTYPE().equals("80") || dataetex.getDOCTYPE().equals("81")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getKUNRG());
                    datarow.add(dataetex.getKNAME());
                    datarow.add(dataetex.getTAXTYPE());
                    datarow.add(dataetex.getBUYERTAXID());
                    datarow.add(dataetex.getBBRANCHID());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBPOSTCODE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBADDRESS1());
                    datarow.add(dataetex.getBADDRESS2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBCOUNTRY());
                } else {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getKUNRG());
                    datarow.add(dataetex.getKNAME());
                    datarow.add(dataetex.getTAXTYPE());
                    datarow.add(dataetex.getBUYERTAXID());
                    datarow.add(dataetex.getBBRANCHID());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBPOSTCODE());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBADDRESS1());
                    datarow.add(dataetex.getBADDRESS2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBCOUNTRY());
                }

            } else if (dataetex.getDATATYPE().equals("L")) {
                if (dataetex.getDOCTYPE().equals("T03")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEID());
                    datarow.add(dataetex.getPRODUCTID());
                    datarow.add(dataetex.getPRODUCTNAME());
                    datarow.add(dataetex.getPRODUCTDESC());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTAMT());
                    datarow.add(dataetex.getPRODUCTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTQTY());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTAXCODE());
                    datarow.add(dataetex.getLTAXRATE());
                    datarow.add(dataetex.getLBASICAMT());
                    datarow.add(dataetex.getLBASICCUR());
                    datarow.add(dataetex.getLTAXAMT());
                    datarow.add(dataetex.getLTAXCUR());
                    datarow.add("");
                    datarow.add(dataetex.getLALLOWAMT());
                    datarow.add(dataetex.getLALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTOTAMT());
                    datarow.add(dataetex.getLTOTCUR());
                    datarow.add(dataetex.getLNETAMT());
                    datarow.add(dataetex.getLNETCUR());
                    datarow.add(dataetex.getLINCAMT());
                    datarow.add(dataetex.getLINCCUR());
                    datarow.add("");
                    datarow.add(dataetex.getPREMARK2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                } else if (dataetex.getDOCTYPE().equals("80")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEID());
                    datarow.add(dataetex.getPRODUCTID());
                    datarow.add(dataetex.getPRODUCTNAME());
                    datarow.add(dataetex.getPRODUCTDESC());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTAMT());
                    datarow.add(dataetex.getPRODUCTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTQTY());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTAXCODE());
                    datarow.add(dataetex.getLTAXRATE());
                    datarow.add(dataetex.getLBASICAMT());
                    datarow.add(dataetex.getLBASICCUR());
                    datarow.add(dataetex.getLTAXAMT());
                    datarow.add(dataetex.getLTAXCUR());
                    datarow.add("");
                    datarow.add(dataetex.getLALLOWAMT());
                    datarow.add(dataetex.getLALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTOTAMT());
                    datarow.add(dataetex.getLTOTCUR());
                    datarow.add(dataetex.getLNETAMT());
                    datarow.add(dataetex.getLNETCUR());
                    datarow.add(dataetex.getLINCAMT());
                    datarow.add(dataetex.getLINCCUR());
                    datarow.add("");
                    datarow.add(dataetex.getPREMARK2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                } else if (dataetex.getDOCTYPE().equals("81")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEID());
                    datarow.add(dataetex.getPRODUCTID());
                    datarow.add(dataetex.getPRODUCTNAME());
                    datarow.add(dataetex.getPRODUCTDESC());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTAMT());
                    datarow.add(dataetex.getPRODUCTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTQTY());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTAXCODE());
                    datarow.add(dataetex.getLTAXRATE());
                    datarow.add(dataetex.getLBASICAMT());
                    datarow.add(dataetex.getLBASICCUR());
                    datarow.add(dataetex.getLTAXAMT());
                    datarow.add(dataetex.getLTAXCUR());
                    datarow.add("");
                    datarow.add(dataetex.getLALLOWAMT());
                    datarow.add(dataetex.getLALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTOTAMT());
                    datarow.add(dataetex.getLTOTCUR());
                    datarow.add(dataetex.getLNETAMT());
                    datarow.add(dataetex.getLNETCUR());
                    datarow.add(dataetex.getLINCAMT());
                    datarow.add(dataetex.getLINCCUR());
                    datarow.add(dataetex.getPREMARK1());
                    datarow.add(dataetex.getPREMARK2());
                    datarow.add(dataetex.getPREMARK3());
                    datarow.add(dataetex.getPREMARK4());
                    datarow.add(dataetex.getPREMARK5());
                    datarow.add(dataetex.getPREMARK6());
                    datarow.add(dataetex.getPREMARK7());
                    datarow.add(dataetex.getPREMARK8());
                    datarow.add(dataetex.getPREMARK9());

                } else {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEID());
                    datarow.add(dataetex.getPRODUCTID());
                    datarow.add(dataetex.getPRODUCTNAME());
                    datarow.add(dataetex.getPRODUCTDESC());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTAMT());
                    datarow.add(dataetex.getPRODUCTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getPRODUCTQTY());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTAXCODE());
                    datarow.add(dataetex.getLTAXRATE());
                    datarow.add(dataetex.getLBASICAMT());
                    datarow.add(dataetex.getLBASICCUR());
                    datarow.add(dataetex.getLTAXAMT());
                    datarow.add(dataetex.getLTAXCUR());
                    datarow.add("");
                    datarow.add(dataetex.getLALLOWAMT());
                    datarow.add(dataetex.getLALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLTOTAMT());
                    datarow.add(dataetex.getLTOTCUR());
                    datarow.add(dataetex.getLNETAMT());
                    datarow.add(dataetex.getLNETCUR());
                    datarow.add(dataetex.getLINCAMT());
                    datarow.add(dataetex.getLINCCUR());
                    datarow.add("");
                    datarow.add(dataetex.getPREMARK2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                }

            } else if (dataetex.getDATATYPE().equals("F")) {
                if (dataetex.getDOCTYPE().equals("T03")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEIDTOT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getTAXCODE());
                    datarow.add(dataetex.getTAXRATE());
                    datarow.add(dataetex.getBASICAMT());
                    datarow.add(dataetex.getBASICCUR());
                    datarow.add(dataetex.getTAXAMT());
                    datarow.add(dataetex.getTAXCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getALLOWIND());
                    datarow.add(dataetex.getALLOWAMT());
                    datarow.add(dataetex.getALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLINETOTAMT());
                    datarow.add(dataetex.getLINETOTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getALLOWTOTAMT());
                    datarow.add(dataetex.getALLOWTOTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBASICTOTAMT());
                    datarow.add(dataetex.getBASICTOTCUR());
                    datarow.add(dataetex.getTAXTOTAMT());
                    datarow.add(dataetex.getTAXTOTCUR());
                    datarow.add(dataetex.getGRANDAMT());
                    datarow.add(dataetex.getGRANDCUR());
                    datarow.add(dataetex.getTERMPAYMENT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getDOCREMARK2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                } else if (dataetex.getDOCTYPE().equals("80")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEIDTOT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getTAXCODE());
                    datarow.add(dataetex.getTAXRATE());
                    datarow.add(dataetex.getBASICAMT());
                    datarow.add(dataetex.getBASICCUR());
                    datarow.add(dataetex.getTAXAMT());
                    datarow.add(dataetex.getTAXCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getORITOTAMT());
                    datarow.add(dataetex.getORITOTCUR());
                    datarow.add(dataetex.getLINETOTAMT());
                    datarow.add(dataetex.getLINETOTCUR());
                    datarow.add(dataetex.getADJUSTAMT());
                    datarow.add(dataetex.getADJUSTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBASICTOTAMT());
                    datarow.add(dataetex.getBASICTOTCUR());
                    datarow.add(dataetex.getTAXTOTAMT());
                    datarow.add(dataetex.getTAXTOTCUR());
                    datarow.add(dataetex.getGRANDAMT());
                    datarow.add(dataetex.getGRANDCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getDOCREMARK1());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                } else if (dataetex.getDOCTYPE().equals("81")) {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEIDTOT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getTAXCODE());
                    datarow.add(dataetex.getTAXRATE());
                    datarow.add(dataetex.getBASICAMT());
                    datarow.add(dataetex.getBASICCUR());
                    datarow.add(dataetex.getTAXAMT());
                    datarow.add(dataetex.getTAXCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getORITOTAMT());
                    datarow.add(dataetex.getORITOTCUR());
                    datarow.add(dataetex.getLINETOTAMT());
                    datarow.add(dataetex.getLINETOTCUR());
                    datarow.add(dataetex.getADJUSTAMT());
                    datarow.add(dataetex.getADJUSTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBASICTOTAMT());
                    datarow.add(dataetex.getBASICTOTCUR());
                    datarow.add(dataetex.getTAXTOTAMT());
                    datarow.add(dataetex.getTAXTOTCUR());
                    datarow.add(dataetex.getGRANDAMT());
                    datarow.add(dataetex.getGRANDCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getDOCREMARK1());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                } else {
                    datarow.add(dataetex.getDATATYPE());
                    datarow.add(dataetex.getLINEIDTOT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getTAXCODE());
                    datarow.add(dataetex.getTAXRATE());
                    datarow.add(dataetex.getBASICAMT());
                    datarow.add(dataetex.getBASICCUR());
                    datarow.add(dataetex.getTAXAMT());
                    datarow.add(dataetex.getTAXCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getALLOWIND());
                    datarow.add(dataetex.getALLOWAMT());
                    datarow.add(dataetex.getALLOWCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getLINETOTAMT());
                    datarow.add(dataetex.getLINETOTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getALLOWTOTAMT());
                    datarow.add(dataetex.getALLOWTOTCUR());
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getBASICTOTAMT());
                    datarow.add(dataetex.getBASICTOTCUR());
                    datarow.add(dataetex.getTAXTOTAMT());
                    datarow.add(dataetex.getTAXTOTCUR());
                    datarow.add(dataetex.getGRANDAMT());
                    datarow.add(dataetex.getGRANDCUR());
                    datarow.add(dataetex.getTERMPAYMENT());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add(dataetex.getDOCREMARK2());
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                    datarow.add("");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return datarow;
    }
}
