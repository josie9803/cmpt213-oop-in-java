import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2_MapReduce {

    public static void main(String[] args) {
        Stream2_MapReduce bs = new Stream2_MapReduce();
        bs.run();
    }
    private void run() {
        List<Student> students = Arrays.asList(
                new Student("Bill", 1.68, 52),
                new Student("Alice", 3.5, 40),
                new Student("Doris", 4.01, 102),
                new Student("Charlie", 3.8, 12)
        );

        // Level 2: Map & Reduce
        // --------------------------------------------------------

        // Map:
        // - change the value
        List<Double> heights_m = Arrays.asList(10.0, 30.0, 20.0, 60.0, 50.0);
        final double INCHES_PER_M = 39.3701;
        List<Double> heights_inch = heights_m.stream()
                .map( m -> m * INCHES_PER_M)
                .collect(Collectors.toList());

        // - change the type
        List<String> honourRoleNames = students.stream()
                .filter(std -> std.getGpa() >= 3.5)
                .map(std -> std.getName())
                .collect(Collectors.toList());


        // Reduce:
        // Takes stream of type Z and returns one element of type Z
        String message = "Student names: " + students.stream()
                .map(std -> std.getName())
                .reduce("", (ans, name) -> ans + "," + name);
        System.out.println(message);

        String messageJoin = "Student names: " + students.stream()
                .map(std -> std.getName())
                .collect(Collectors.joining(", "));
        System.out.println(messageJoin);

//        int sumHeight = heights_m.stream()
//                .collect(Collectors.summingInt());



    }
    boolean hasGreatGpa(Student s) {
        return s.getGpa() >= 4.0;
    }


}
