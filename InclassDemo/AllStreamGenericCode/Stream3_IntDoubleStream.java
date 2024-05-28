import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream3_IntDoubleStream {

    public static void main(String[] args) {
        Stream3_IntDoubleStream bs = new Stream3_IntDoubleStream();
        bs.run();
    }
    private void run() {

        List<Student> students = Arrays.asList(
                new Student("Bill", 1.68, 52),
                new Student("Alice", 3.5, 40),
                new Student("Doris", 4.01, 102),
                new Student("Charlie", 3.8, 12)
        );



        // Level 3: Int/Double Stream
        // --------------------------------------------------------
        // mapToInt() and sum()
        int allHours = students.stream()
                        .mapToInt( std -> std.getCreditHours())
                        .sum();

        // Max/Min/Avg may fail if stream is empty, so they return an Optional
        // Must call "orElse()" on the optional to get a default value
        double maxGpa = students.stream()
                        .mapToDouble( std -> std.getGpa())
                        .max().orElse(0);

        // IntStream.range() to generate a stream
        int sumEvens = IntStream.range(0, 100)
                .filter(x -> x % 2 == 0)
                .sum();


        // Level 4: Method Reference
        students.stream()
                .filter(this::hasGreatGpa)
                .forEach(System.out::println);
        students.stream()
                .filter(Student::canGraduate)
                .forEach(System.out::println);
        students.stream()
                .filter(Student::canGraduate)
                .forEach(std -> System.out.println(std));
    }
    boolean hasGreatGpa(Student s) {
        return s.getGpa() >= 4.0;
    }



}
