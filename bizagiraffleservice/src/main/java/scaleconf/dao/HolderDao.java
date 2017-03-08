package scaleconf.dao;

import java.util.List;

/**
 * Created by dev-camiloh on 3/7/17.
 */
public interface HolderDao {

    /**
     * @return A list of Holders
     */
    List<Holder> readHolders();

    /**
     * @param todoItem
     * @return whether the todoItem was persisted.
     */
    Holder createHolder(Holder todoItem);

    /**
     * @param id
     * @return the Holder
     */
    Holder readHolder(String id);

    /**
     * @param id
     * @return the Holder
     */
    Holder updateHolder(String id, boolean isComplete);

    /**
     * @param id
     * @return whether the delete was successful.
     */
    boolean deleteHolder(String id);
}
