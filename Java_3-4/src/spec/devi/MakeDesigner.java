package spec.devi;

import factory.Factory;
import student.Student;

public class MakeDesigner extends Factory {
    @Override
public Student createInstance() {
        return new Devi();
        }
}
