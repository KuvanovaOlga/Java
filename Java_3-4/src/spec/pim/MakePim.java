package spec.pim;

import factory.Factory;

import student.Student;

public class MakePim extends Factory {

    @Override
    public Student createInstance() {
        return new Pim();
    }
}
