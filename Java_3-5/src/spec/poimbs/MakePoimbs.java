package spec.poimbs;

import factory.Factory;
import spec.devi.Devi;
import student.Student;

public class MakePoimbs extends Factory {
    @Override
    public Student createInstance() {
        return new Poimbs();
    }
}
