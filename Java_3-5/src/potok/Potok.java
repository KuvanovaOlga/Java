package potok;

import student.Student;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Potok  {
    ArrayList<Student> stream = new ArrayList<>();

    public ArrayList<Student> getStream() {
        return stream;
    }

    public void setStream(ArrayList<Student> stream) {
        this.stream = stream;
    }

    public void addStudent(Student student){
        stream.add(student);
    }

    public void delStudent(Student student)
    {
        stream.remove(student);
    }

    public Student getStudent(String surname){
        for (Student streamy:
             stream) {
            if(streamy.getSurname()==surname)
                return streamy;
        }
        return null;
    }

    public void addStudents(Student[] students){
        for (Student student : students){
            stream.add(student);
        }
    }
}
