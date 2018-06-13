package belstu.it.kuvanova;

import java.util.List;

public class Subjects
{
	public void setDayName(String dayName)
	{
		this.dayName = dayName;
	}

	public Subjects()
	{
	}

	public int getLectureNumber()
	{
		return lectureNumber;
	}

	public static void printSubjects(List<Subjects> list)
	{
		for (Subjects subj: list)
		{
			System.out.println(subj.toString());
		}
	}

	public Subjects(String dayName)
	{
		this.dayName = dayName;
	}

	public Subjects(String dayName, int lectureHallNumber, String name, int lectureNumber)
	{
		this.name = name;
		this.dayName = dayName;
		this.lectureHallNumber = lectureHallNumber;
		this.lectureNumber = lectureNumber;

	}

	private String name;
	private String dayName;
	private int lectureHallNumber;
	private int lectureNumber;

	@Override
	public String toString()
	{
		return "Subjects{" +
				"name='" + name + '\'' +
				", dayName='" + dayName + '\'' +
				", lectureHallNumber=" + lectureHallNumber +
				", lectureNumber=" + lectureNumber +
				'}';
	}

	public String outSubject()
	{
		return "Subjects{" +
				"dayName='" + dayName + "'" + '}';
	}
}
