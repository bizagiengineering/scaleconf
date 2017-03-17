package scaleconf.dao;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


/**
 * Created by dev-camiloh on 3/7/17.
 */
public class DocumentDBClientFactory {

    @Autowired
    private static Environment environment;
    //private static final String HOST = environment.getProperty("hostDocumentDB");
    //private static final String MASTER_KEY = environment.getProperty("keyDocumentDB");
    private static final String HOST = "https://scaleconf.documents.azure.com:443/";
    private static final String MASTER_KEY = "bNnQ05Sra5g9k7T4KdfXIzs0ZwxlSwAf8o69bBQB5c1u8k0VoKZmM9ne0ie1Ul6yFZ7BUUyA8vaBxigGgMIVug==";

    private static DocumentClient documentClient = new DocumentClient(HOST, MASTER_KEY,
            ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);

    public static DocumentClient getDocumentClient() {
        return documentClient;
    }

}