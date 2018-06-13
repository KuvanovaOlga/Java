package belstu.it.kuvanova;
import java.sql.Connection;
import java.sql.SQLException;
public interface DaoFactory
{
    public Connection getConnection() throws SQLException;
    public GroupDao<Subjects,String> getSubjectDao(Connection connection);
    public GroupDao<Teachers,String> getTeachersDao(Connection connection);
}
