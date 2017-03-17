package scaleconf.dao;

/**
 * Created by dev-camiloh on 3/6/17.
 */

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.*;
import scaleconf.model.Holder;

import java.util.List;


public class HolderDDBDao implements HolderDao{

    // The name of our database.
    private static final String DATABASE_ID = "BizagiRaffleDB";

    // The name of our collection.
    private static final String COLLECTION_ID = "HolderCollection";

    // We'll use Gson for POJO <=> JSON serialization for this example.
    private static Gson gson = new Gson();

    // The DocumentDB Client
    private static DocumentClient documentClient = DocumentDBClientFactory.getDocumentClient();

    // Cache for the database object, so we don't have to query for it to
    // retrieve self links.
    private static Database databaseCache;

    // Cache for the collection object, so we don't have to query for it to
    // retrieve self links.
    private static DocumentCollection collectionCache;

    @Override
    public Holder createHolder(Holder todoItem) throws HolderDaoException {
        // Serialize the Holder as a JSON Document.
        Document holderDocument = new Document(gson.toJson(todoItem));

        // Annotate the document as a Holder for retrieval (so that we can
        // store multiple entity types in the collection).
        holderDocument.set("entityType", "todoItem");

        try {
            // Persist the document using the DocumentClient.
            holderDocument = documentClient.createDocument(
                    getHolderCollection().getSelfLink(), holderDocument, null,
                    false).getResource();
        } catch (DocumentClientException e) {
           throw new HolderDaoException(e);
        }

        return gson.fromJson(holderDocument.toString(), Holder.class);
    }



    private Database getTodoDatabase() throws HolderDaoException {
        if (databaseCache == null) {
            // Get the database if it exists
            List<Database> databaseList = documentClient
                    .queryDatabases(
                            "SELECT * FROM root r WHERE r.id='" + DATABASE_ID
                                    + "'", null).getQueryIterable().toList();

            if (databaseList.size() > 0) {
                // Cache the database object so we won't have to query for it
                // later to retrieve the selfLink.
                databaseCache = databaseList.get(0);
            } else {
                // Create the database if it doesn't exist.
                try {
                    Database databaseDefinition = new Database();
                    databaseDefinition.setId(DATABASE_ID);

                    databaseCache = documentClient.createDatabase(
                            databaseDefinition, null).getResource();
                } catch (DocumentClientException e) {
                    // Something has gone terribly wrong - the app wasn't
                    // able to query or create the collection.
                    // Verify your connection, endpoint, and key.
                    throw new HolderDaoException(e);
                }
            }
        }

        return databaseCache;
    }

    private DocumentCollection getHolderCollection() throws HolderDaoException {
        if (collectionCache == null) {
            // Get the collection if it exists.
            List<DocumentCollection> collectionList = documentClient
                    .queryCollections(
                            getTodoDatabase().getSelfLink(),
                            "SELECT * FROM root r WHERE r.id='" + COLLECTION_ID
                                    + "'", null).getQueryIterable().toList();

            if (collectionList.size() > 0) {
                // Cache the collection object so we won't have to query for it
                // later to retrieve the selfLink.
                collectionCache = collectionList.get(0);
            } else {
                // Create the collection if it doesn't exist.
                try {
                    DocumentCollection collectionDefinition = new DocumentCollection();
                    collectionDefinition.setId(COLLECTION_ID);

                    collectionCache = documentClient.createCollection(
                            getTodoDatabase().getSelfLink(),
                            collectionDefinition, null).getResource();
                } catch (DocumentClientException e) {
                    // able to query or create the collection.
                    // Verify your connection, endpoint, and key.
                   throw new HolderDaoException(e);
                }
            }
        }

        return collectionCache;
    }


}
