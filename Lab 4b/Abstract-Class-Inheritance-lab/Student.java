public class Student extends Personnel{

    private double gpa;

    public Student(String fullName, double gpa) {
        this.fullName = fullName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return String.format("Student: %s GPA: %s", fullName, gpa);
    }
}
