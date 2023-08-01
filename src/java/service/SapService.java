/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import org.json.JSONArray;
import org.json.JSONObject;
import utility.ConnectSap;

/**
 *
 * @author pakutsing
 */
public class SapService {
    
    

    public static JSONObject GetDataEtaxFromSap(String BUKRS, String LBLDAT, String HBLDAT, String LKUNRG, String HKUNRG, String LBRNCH, String HBRNCH, String LDOCTYPE, String HDOCTYPE) {
        JSONObject txtjson = new JSONObject();
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

            System.out.println("C : " + numColumns);
            System.out.println("R : " + numrow);


            JSONArray data = new JSONArray();
            JSONArray datacol = new JSONArray();

            int a = 0;

            while (a < numrow) {
                output.setRow(a);
                System.out.println("Row: " + String.valueOf(output.getRow()));

                int n = 0;
                JSONObject obj = new JSONObject();
                while (n < numColumns) {
                    obj.put(output.getName(n), output.getString(n));
                    System.out.println(output.getName(n) + " : " + output.getString(n));

                    n++;
                }
                data.put(obj);
                System.out.println("------------------------------------------------------------------");
                a++;
            }

            int n1 = 0;
            while (n1 < numColumns) {

                JSONObject objcol = new JSONObject();
                objcol.put("title", output.getName(n1));
                objcol.put("data", output.getName(n1));
                datacol.put(objcol);
                n1++;
            }

            JSONObject objout = new JSONObject();
            objout.put("data", data);
            objout.put("datacol", datacol);

            txtjson = objout;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return txtjson;
    }
}
