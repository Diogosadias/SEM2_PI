package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Store {

    /**
     * List Object.
     */

    List<Object> list;

    /**
     * Constructor Store.
     */

    public Store () {
        this.list = new ArrayList<>();
    }

    /**
     * Return the List's store.
     *
     * @return List
     */

    public abstract List getListObjects();

    /**
     * Get the name of the file.
     *
     * @return File's name
     */

    public abstract String getFileName();

    /**
     * Read Object from File and import as this store's object class.
     *
     * @param o Object
     */

    public abstract void importObject(Object o);
}
