package belstu.it.kuvanova;

import java.sql.*;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Dao dao = new Dao();
        List<Subjects> subjectsList;
        List<Teachers> teachersList;
        try
        {
            Connection con = dao.getConnection();
            System.out.println("All subjects");
            GroupDao<Subjects, String> subjectDao = dao.getSubjectDao(con);
            subjectsList = subjectDao.getAll();
            Subjects.printSubjects(subjectsList);

            System.out.println("All teachers");
            GroupDao<Teachers, String> teacherDao  = dao.getTeachersDao(con);
            teachersList = teacherDao.getAll();
            Teachers.printTeachers(teachersList);

            ((DaoSubject)subjectDao).read("MP");
            System.out.println();
            System.out.println("Day name with lecture count = 4");
            Subjects.printSubjects(((DaoSubject)subjectDao).dayNameWithLectureCount());

            System.out.println();
            System.out.println("Day name with lecture hall number = 321 or 211");
            Subjects.printSubjects(((DaoSubject)subjectDao).dayNameWithLectureHallNumber());

            System.out.println();
            System.out.println("Teacher name which have lecture in not this day =  tue");
            Teachers.printTeachers(((DaoTeacher)teacherDao).teacherWithNotDayname());

            System.out.println();
            System.out.println("Teacher name which have lecture in this day = wen and auditorium = 332");
            Teachers.printTeachers(((DaoTeacher)teacherDao).teacherWithLectureNumberAndDayname());
            con.setAutoCommit(false);
            System.out.println("Transaction");
            try
            {
                System.out.println(((DaoSubject) subjectDao).getSubj("wen"));
                ((DaoSubject) subjectDao).updateDayName("wun");
                con.commit();
            }
            catch (Exception ex)
            {
                System.out.println("roll");

                con.rollback();

                System.out.println(ex.getMessage());
            }
            System.out.println("After");
            System.out.println(((DaoSubject)subjectDao).getSubj("mon"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
