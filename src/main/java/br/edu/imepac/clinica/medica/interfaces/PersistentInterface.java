package br.edu.imepac.clinica.medica.interfaces;

import java.sql.SQLException;

public interface PersistentInterface<T> {

    public boolean save(T entity) throws SQLException;

    public T load(long id);

    public boolean update(T entity);

    public boolean delete(T entity);

}
