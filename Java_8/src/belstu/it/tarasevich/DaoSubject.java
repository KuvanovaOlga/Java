package belstu.it.tarasevich;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoSubject implements GroupDao<Subjects, String>
{
	private final Connection connection;

	public DaoSubject(Connection connection)
	{
		this.connection = connection;
	}

	private Subjects readMain(String key) throws SQLException
	{
		String sql = key;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		rs.next();
		Subjects s = new Subjects(rs.getString("dayName"), rs.getInt("lectureHallNumber"), rs.getString("name"), rs.getInt("lectureNumber"));
		return s;
	}

	@Override
	public Subjects read(String key) throws SQLException
	{
		return readMain("SELECT * FROM subjects WHERE Name = '" + key + "';");
	}

	private List<Subjects> getAllMain(String mess) throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = mess;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Subjects> list = new ArrayList<Subjects>();
		while (rs.next())
		{
			Subjects s = new Subjects(rs.getString("dayName"), rs.getInt("lectureHallNumber"), rs.getString("name"), rs.getInt("lectureNumber"));
			list.add(s);
		}
		return list;
	}

	public List<Subjects> getSubj(String mess) throws SQLException
	{
		return getAllMain("select * from Subjects Where dayName = '" + mess + "';");
	}

	@Override
	public List<Subjects> getAll() throws SQLException
	{
		return getAllMain("SELECT * FROM subjects;");
	}

	public List<Subjects> dayNameWithLectureCount() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "select * from Teachers inner join subjects on teachers.subject = subjects.name where Teachers.lecturecount = 4";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Subjects> s = new ArrayList<>();
		while (rs.next())
		{
			s.add(new Subjects(rs.getString("dayName"), rs.getInt("lectureHallNumber"), rs.getString("name"), rs.getInt("lectureNumber")));
		}
		return s;
	}

	public List<Subjects> dayNameWithLectureHallNumber() throws SQLException
	{
		Statement st = connection.createStatement();
		String sql = "select * from Teachers inner join subjects on teachers.subject = subjects.name where Subjects.lecturehallnumber = 321 or Subjects.lecturehallnumber = 211";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		List<Subjects> s = new ArrayList<>();
		while (rs.next())
		{
			s.add(new Subjects(rs.getString("dayName"), rs.getInt("lectureHallNumber"), rs.getString("name"), rs.getInt("lectureNumber")));
		}
		return s;
	}

	public void updateDayName(String oldDayName) throws SQLException
	{
		Subjects subjectMin = readMain("select top(1) * from Subjects Where Subjects.dayName = '" + oldDayName + "' order by Subjects.lectureNumber");
		Subjects subjectMax = readMain("select top(1) * from Subjects Where Subjects.dayName = '" + oldDayName + "' order by Subjects.lectureNumber desc;");
		String sql = "UPDATE Subjects set Subjects.lectureNumber = ? Where Subjects.lectureNumber = ? and Subjects.dayName = ?; ";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, subjectMax.getLectureNumber()+ 1);
		st.setInt(2, subjectMin.getLectureNumber());
		st.setString(3, oldDayName);
		st.executeUpdate();
	}
}
