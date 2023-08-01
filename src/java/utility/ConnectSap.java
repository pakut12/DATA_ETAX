/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author pakutsing
 */
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;

public class ConnectSap {
    // The MySAP.com system we gonna be using

    static final String SID = "R3";
    // The repository we will be using

    public ConnectSap() {
        super();
    // TODO Auto-generated constructor stub
    }

    public static JCO.Client createpool() throws JCO.Exception {
        JCO.Pool pool = JCO.getClientPoolManager().getPool(SID);
        if (pool == null) {
            // Add a connection pool to the specified system
            JCO.addClientPool(SID, // Alias for this pool
                    9999, // Max. number of connections
                    "500", // SAP client
                    "ZCPIC", // userid
                    "PGCPIC12", // password
                    "EN", // language
                    "10.0.62.8",// host name
                    "00");
        }
        // Get a client from the pool
        JCO.Client client = JCO.getClient(SID);
        return client;
    }

    public static IRepository createRepository(String nameRep) {
        // Create a new repository
        IRepository repository = JCO.createRepository(nameRep, SID);
        return repository;
    }

    public static String getNamePool() {
        return SID;
    }
}

