public class Faculty extends Personnel{

    public double averageReview;

    public Faculty(String fullName, double averageReview) {
        this.fullName = fullName;
        this.averageReview = averageReview;
    }

    @Override
    public String toString() {
        return String.format("Faculty: %s Average Review: %s", fullName, averageReview);
    }
}
