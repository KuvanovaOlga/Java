package student;

public class Student {

    public enum TypeEduc
    {
        DAY, EVENING, ZAOCH
    }
    TypeEduc type_educ;

    String surname;
    int course;
    double mark;

    public Student(TypeEduc type_educ, String surname, int course, double mark) {
        this.type_educ = type_educ;
        this.surname = surname;
        this.course = course;
        this.mark = mark;
    }

    public Student() { }

    public TypeEduc getType_educ() {
        return type_educ;
    }

    public void setType_educ(TypeEduc type_educ) {
        this.type_educ = type_educ;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getSurname()+" Cours: " + getCourse();
    }
}
