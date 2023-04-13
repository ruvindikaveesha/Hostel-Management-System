package lk.ijse.hibernate.dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T,ID> extends SuperDAO{
    List<T> getAll() throws IOException;

    boolean save(T entity) throws IOException;

    boolean update(T entity) throws IOException;

    boolean delete(ID id) throws IOException;

    boolean find(ID id) throws SQLException, ClassNotFoundException, IOException;

    String generateNewID() throws IOException ;

    T search(ID id) throws SQLException, ClassNotFoundException, IOException;
}

