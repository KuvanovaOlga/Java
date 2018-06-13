package belstu.it.kuvanova;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTeacher implements GroupDao<Teachers, String>
{
	private final Connection connection;

	public DaoTeacher(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public Teachers read(String key) throws SQLException
	{
		String sql = "SELECT * FROM teachers WHERE Name = ?;";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setString(1, key);
		ResultSet rs = stm.executeQuery();
		rs.next();
		Teachers teachers = new Teachers(rs.getString("nameSurname"), rs.getString("subject"), rs.getInt("lectureCount"), rs.getInt("studentsCount"));
		return teachers;
	}

	@Override
	public List<Teachers> getAll() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "SELECT * FROM teachers;";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Teachers> list = new ArrayList<Teachers>();
		while (rs.next())
		{
			Teachers teachers = new Teachers(rs.getString("nameSurname"), rs.getString("subject"), rs.getInt("lectureCount"), rs.getInt("studentsCount"));
			list.add(teachers);
		}
		return list;
	}

	public List<Teachers> teacherWithLectureNumberAndDayname() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "select * from teachers inner join subjects on teachers.subject = subjects.name where subjects.lectureHallNumber = 332 and Subjects.dayname = 'wed'";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Teachers> teachers = new ArrayList<Teachers>();
		while (rs.next())
		{
			teachers.add(new Teachers(rs.getString("nameSurname"), rs.getString("subject"), rs.getInt("lectureCount"), rs.getInt("studentsCount")));
		}
		return teachers;
	}

	public List<Teachers> teacherWithNotDayname() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "select * from Teachers inner join Subjects on Teachers.subject = Subjects.name where not Subjects.dayname = 'tue'";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Teachers> teachers = new ArrayList<Teachers>();
		while (rs.next())
		{
			teachers.add(new Teachers(rs.getString("nameSurname"), rs.getString("subject"), rs.getInt("lectureCount"), rs.getInt("studentsCount")));
		}
		return teachers;
	}
}
