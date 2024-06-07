package br.edu.imepac.clinica.medica.interfaces;

import java.sql.SQLException;

public interface PersistentInterface<T> {

    public boolean save(T entity) throws SQLException;

    public T load(long id) throws SQLException;

    public boolean update(T entity) throws SQLException;

    public boolean delete(T entity) throws SQLException;

}
