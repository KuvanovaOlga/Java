package compare;

import student.Student;

import java.util.Comparator;

public class Compare1 implements Comparator<Student> {
    public int compare(Student st1, Student st2) {
        return st1.getSurname().compareTo(st2.getSurname());
    }
}