package core;

import java.sql.SQLException;
import java.util.List;

public abstract class Search {
    public abstract Object getById(Integer id) throws SQLException, Exception;

    public abstract List getAll() throws SQLException, Exception;
}
