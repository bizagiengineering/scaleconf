package scaleconf.dao;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;


/**
 * Created by dev-camiloh on 3/7/17.
 */
public class DocumentDBClientFactory {
    private static final String HOST = "https://docdb-java-sample.documents.azure.com:443/";
    private static final String MASTER_KEY = "[YOUR_KEY_HERE]";

    private static DocumentClient documentClient = new DocumentClient(HOST, MASTER_KEY,
            ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);

    public static DocumentClient getDocumentClient() {
        return documentClient;
    }

}