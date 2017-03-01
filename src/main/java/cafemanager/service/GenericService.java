package cafemanager.service;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
public interface GenericService<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T get(long id);

    List<T> getAll();
}
