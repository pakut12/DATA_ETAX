/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author pakutsing
 */
public class Utility {

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
