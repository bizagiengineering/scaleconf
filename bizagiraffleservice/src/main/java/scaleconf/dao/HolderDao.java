package scaleconf.dao;

import scaleconf.model.Holder;

/**
 * Created by dev-camiloh on 3/7/17.
 */
public interface HolderDao {

    /**
     * @param holder
     * @return whether the holder was persisted.
     */
    Holder createHolder(Holder holder) throws HolderDaoException ;

}
