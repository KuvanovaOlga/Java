package main;

import dekan.Dekan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import potok.Potok;
import spec.devi.Devi;
import spec.devi.MakeDesigner;
import spec.isit.MakeIsit;
import spec.poit.MakePoit;
import student.Student;

import java.lang.reflect.Type;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
        //DOMConfigurator для отправки одного из предопределенных наборов конфигураций журналов XML
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Start Program.");
        Student stud = (new MakeDesigner()).createInstance();
        Student stud1 = (new MakePoit()).createInstance();
        stud.setCourse(3);
        stud.setSurname("Rabcevich");
        stud.setMark(6);
        stud.setType_educ(Student.TypeEduc.EVENING);
        stud1.setCourse(4);
        stud1.setSurname("Bogdanovich");
        stud1.setMark(6);
        stud1.setType_educ(Student.TypeEduc.EVENING);
        Student ura = (new MakeIsit()).createInstance();
        ura.setCourse(2);
        ura.setSurname("Yurashevich");
        ura.setMark(3);
        ura.setType_educ(Student.TypeEduc.DAY);
        LOG.info("Student's List");
        Student student1 = new Student(Student.TypeEduc.DAY, "Kuvanova", 2, 8);
        Student student3 = new Student(Student.TypeEduc.DAY, "Delikatnaya", 1, 9);
        //Student student2 = (Devi)student3;
        Potok potok = new Potok();
        Student[] students = new Student[]{student1, student3, ura, stud, stud1};
        potok.addStudents(students);
        //potok.addStudent(student2);
        Dekan Shiman = Dekan.createInstance();
        Shiman.countStudents(potok);
        Shiman.sortByCourse(potok);
        Shiman.showStudents(potok);
        Shiman.sortBySurname(potok);
        Shiman.showStudents(potok);

    }
}