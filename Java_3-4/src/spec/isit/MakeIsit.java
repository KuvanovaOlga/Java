package spec.isit;

import factory.Factory;
import spec.devi.Devi;
import student.Student;

public class MakeIsit extends Factory {
    @Override
    public Student createInstance() {
        return new Isit();
    }
}
