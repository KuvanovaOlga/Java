package compare;

import student.Student;

import java.util.Comparator;

public class Compare implements Comparator<Student> {
    public int compare(Student st1, Student st2)
    {
        return Integer.compare(st1.getCourse(),st2.getCourse());
    }
}

