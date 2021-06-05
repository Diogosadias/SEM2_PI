package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Store {

    List<Object> list;

    public Store () {
        this.list = new ArrayList<>();
    }

    public abstract List getListObjects();

    public abstract String getFileName();

    public abstract void importObject(Object o);
}
