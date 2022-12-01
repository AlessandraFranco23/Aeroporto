package db;

import java.sql.SQLException;

public interface Database<T> {
    public void update() throws SQLException;
    public void delete() throws SQLException;
}
