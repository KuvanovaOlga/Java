package spec.poit;

import factory.Factory;
import spec.devi.Devi;
import student.Student;

public class MakePoit extends Factory{
    @Override
    public Student createInstance() {
        return new Poit();
    }
}