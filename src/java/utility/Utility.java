/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author pakutsing
 */
public class Utility {

    public static List<String> SetListType(String type) {
        List<String> list = new ArrayList<String>();
        try {
            if (type.equals("ALL")) {
                list.add("T03");
                list.add("80");
                list.add("81");
                list.add("388");
            } else if (type.equals("80")) {
                list.add("80");
            } else if (type.equals("81")) {
                list.add("81");
            } else if (type.equals("388")) {
                list.add("388");
            } else if (type.equals("T03")) {
                list.add("T03");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static String ChackNull(String txt) {
        if (txt == null) {
            txt = "";
        }
        return txt;
    }

    public static String CoverDateForInput(String txt) {

        String coverdate = "";
        if (txt == null) {
            coverdate = "";
        } else {
            String date = txt.replace(" 00:00:00.0", "");
            coverdate = date;
        }

        return coverdate;
    }

    public static String CoverDate(String txt) {

        String coverdate = "";
        if (txt == null) {
            coverdate = "";
        } else {
            String[] date = txt.replace(" 00:00:00.0", "").split("-");
            coverdate = date[2] + "/" + date[1] + "/" + date[0];
        }

        return coverdate;
    }

    public static String getdatetoday() throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = new Date();
        return formatter.format(date);
    }
}
