
public class Rectangle {

    // fields
    private double length;
    private double width;
    private Point topLeftCorner;

    // default constructor (takes no parameters)
    public Rectangle() {
        // length and width assigned default values (4 for length and 2 for width)
        this.length = 4;
        this.width = 2;
        this.topLeftCorner = new Point();
    }

    // constructor
    public Rectangle(double length, double width, Point corner) {
        this.length = length;
        this.width = width;
        this.topLeftCorner = corner;
    }

    // WRITE an appropriate
    // (1) toString method
    // (2) getter and setter methods for the length field
    // (3) getter and setter methods for the width field
    // (4) getter and setter methods for the topLeftCorner field


    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", topLeftCorner=" + topLeftCorner.toString() +
                '}';
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Point getTopLeftCorner() {
        return topLeftCorner;
    }

    public void setTopLeftCorner(Point topLeftCorner) {
        this.topLeftCorner = topLeftCorner;
    }

    public static void main(String[] args) {
        // Reminder: don't write methods within other methods.
        // Test out toString() method and getters and setters here! (Main method testing)
        Rectangle rectangle1 = new Rectangle(5,10, new Point(16,12));
        Rectangle rectangle2 = new Rectangle(23,4, new Point(72,33));
        Rectangle rectangle3 = new Rectangle(100,176, new Point(2,90));
        Rectangle rectangle4 = new Rectangle(10,14, new Point(18,41));

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);
        System.out.println(rectangle4);

        rectangle1.setLength(4000);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);
        System.out.println(rectangle4);


    }

}
