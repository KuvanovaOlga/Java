package belstu.it.tarasevich;

import java.util.List;

public class Teachers
{
    private String nameSurname;
    private String Subject;
    private int lectureCount;

	public Teachers()
	{
	}

	public Teachers(String nameSurname)
	{
		this.nameSurname = nameSurname;
	}

	public Teachers(String nameSurname, String subject, int lectureCount, int studentsCount)
	{

		this.nameSurname = nameSurname;
		Subject = subject;
		this.lectureCount = lectureCount;
		this.studentsCount = studentsCount;
	}

	private int  studentsCount;

	public void setNameSurname(String nameSurname)
	{
		this.nameSurname = nameSurname;
	}

	@Override
    public String toString()
    {
        return "Subjects{" +
                "nameSurname='" + nameSurname + '\'' +
                ", Subject='" + Subject + '\'' +
                ", lectureCount=" + lectureCount +
                ", studentsCount=" + studentsCount +
                '}';
    }
    public String outTeacher ()
    {
        return "Subjects{" +
                "nameSurname='" + nameSurname+ "'"+'}';
    }

	public static void printTeachers(List<Teachers> list)
	{
		for (Teachers teach : list)
		{
			System.out.println(teach.toString());
		}
	}
}
