package belstu.it.kuvanova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dao implements DaoFactory {
        private String user = "User";
        private String password = "1";
        private String url = "jdbc:sqlserver://localhost;databaseName=TimetableOfClasses";

    public Dao(){
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e) {
            e.printStackTrace();
       }
    }
    @Override
    public Connection getConnection() throws SQLException  //соединение
    {
        return DriverManager.getConnection(url,user,password);
    }
    @Override
    public GroupDao<Subjects, String> getSubjectDao(Connection connection)
    {
            return new DaoSubject(connection);
    }

    @Override
    public GroupDao<Teachers, String> getTeachersDao(Connection connection)
    {
        return new DaoTeacher(connection);
    }
}

