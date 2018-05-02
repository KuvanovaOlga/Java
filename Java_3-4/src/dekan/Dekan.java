package dekan;

import compare.Compare;
import compare.Compare1;
import potok.Potok;
import student.Student;

public class Dekan {

    private static Dekan dekan;

    private Dekan() {
    }

    public static Dekan createInstance(){
        if(dekan ==null)
            return new Dekan();
        return dekan;
    }

    public void countStudents(Potok potok){
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4  = 0;
        for (Student stud: potok.getStream()) {
            if(stud.getCourse() == 1) c1++;
            if(stud.getCourse() == 2) c2++;
            if(stud.getCourse() == 3) c3++;
            if(stud.getCourse() == 4) c4++;
        }
        System.out.println("First course: " + c1);
        System.out.println("Second course: " + c2);
        System.out.println("Third course: " + c3);
        System.out.println("Fourth course: " + c4);
    }

    public void getStudentsByCourse(Potok potok, int course){
        for (Student stud: potok.getStream()){
            if(stud.getCourse() == course)
            {
                System.out.println(stud.getSurname());
            }
        }
    }

    public void getStudentsByMark(Potok potok, int m1, int m2){
        for (Student stud: potok.getStream()){
            if(m1 <=stud.getMark() && m2 >= stud.getMark())
            {
                System.out.println(stud.getSurname());
            }
        }
    }

    public void sortBySurname(Potok potok){
        potok.getStream().sort(new Compare1());
    }

    public void sortByCourse(Potok potok){
        potok.getStream().sort(new Compare());
    }

    public void showStudents(Potok potok){
        for (Student stud:potok.getStream()) {
            System.out.println(stud.toString());

        }
    }
}
