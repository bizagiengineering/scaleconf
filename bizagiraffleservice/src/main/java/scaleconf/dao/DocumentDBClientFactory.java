package scaleconf.dao;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;


/**
 * Created by dev-camiloh on 3/7/17.
 */
public class DocumentDBClientFactory {
    private static final String HOST = "https://scaleconf.documents.azure.com:443/";
    private static final String MASTER_KEY = "L3ZxsbQ0DzwrwXx1EFazVOIOfLcpmEMHuP712PVi2L1jtD33I7gxVVf9AnHCGXR6E6Bgb347GlhA0oJTMOQ4lQ==";

    private static DocumentClient documentClient = new DocumentClient(HOST, MASTER_KEY,
            ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);
    
    public static DocumentClient getDocumentClient() {
        return documentClient;
    }

}