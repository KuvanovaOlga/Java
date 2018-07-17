package belstu.it.tarasevich;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface GroupDao <T,PK extends Serializable>
{
    public T read(String key) throws SQLException;
    public List<T> getAll() throws SQLException;
}
