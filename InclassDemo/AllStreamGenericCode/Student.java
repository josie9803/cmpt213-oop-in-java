import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int creditHours;

    public Student(String name, double gpa, int creditHours) {
        this.name = name;
        this.gpa = gpa;
        this.creditHours = creditHours;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public boolean canGraduate() {
        return gpa >= 2.0 && creditHours >= 120;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

    public static Comparator<Student> getGpaComparator() {
        return (o1, o2) -> (int)(Math.signum(o1.getGpa() - o2.getGpa()));
    }
}
