import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream1_Simple {

    public static void main(String[] args) {
        Stream1_Simple bs = new Stream1_Simple();
        bs.run();
    }
    private void run() {
        // Initial Example
//        {
//            List<Double> heights_m = Arrays.asList(10.0, 30.0, 20.0, 60.0, 50.0);
//            heights_m.stream()
//                    .map(x -> x * x)
//                    .forEach(x -> System.out.println(x));
//        }

        List<Student> students = Arrays.asList(
                new Student("Bill", 1.68, 52),
                new Student("Alice", 4.5, 40),
                new Student("Doris", 4.01, 103),
                new Student("Charlie", 3.8, 12),
                new Student("M", 1.0, 0)
        );

        // Print second letter of each student's name,
        // who had even number of credit hours
        // ordered by GPA
        students.stream()
                .filter(s -> s.getCreditHours() % 2 == 0)
                .filter(s -> s.getName().length() >= 2)
                .sorted(Student.getGpaComparator())
                .map(s -> s.getName().charAt(1))
                .forEach(ch -> System.out.println(ch));
//        students.stream()
//                .sorted(Student.getGpaComparator())
//                .forEach(s -> {
//                    if (s.getCreditHours() % 2 == 0) {
//                        System.out.println(s.getName().charAt(1));
//                    }
//                });

//        // Print out the GPA of everyone who has taken 45 or more credit hours.
//        students.stream()
//                .filter(s -> s.getCreditHours() >= 45)
//                .forEach(s -> System.out.println(s.getGpa()));
//        students.stream()
//                .filter(s -> s.getCreditHours() >= 45)
//                .map(myStd -> myStd.getGpa())
//                .forEach(gpa -> System.out.println(gpa));
//
//
//
//        // Level 1: Simple
//        // --------------------------------------------------------
//
//        // Terminal Operation: forEach
//        students.stream()
//                .forEach(std -> System.out.println(std.getName()));
//        students.stream()
//                .map(mystd -> myStd.getName())
//                .forEach(std -> System.out.println(std);
//
//        // Intermediate Operation: filter
//        students.stream()
//                .filter(std -> std.getGpa() >= 3.5)
//                .forEach(std -> System.out.println(std.getName()));
//
//        // Terminal Operation: count
//        long numFailing = students.stream()
//                .filter(std -> std.getGpa() < 1.0)
//                .count();
//
//        // Terminal Operation: collector
//        List<Student> honourRoll = students.stream()
//                .filter(std -> std.getGpa() >= 3.5)
//                .collect(Collectors.toList());
//        List<Student> studentsWithL = students.stream()
//                .filter(std -> std.getName().contains("l"))
//                .collect(Collectors.toList());
//
//        // Intermediate Operation: sorted()
//        List<Student> sorted = students.stream()
//                .sorted()
//                .collect(Collectors.toList());

    }
}
