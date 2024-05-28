import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicStream {

    public static void main(String[] args) {
        BasicStream bs = new BasicStream();
        bs.run();
    }
    private void run() {
        // Initial Example
        {
            List<Double> heights_m = Arrays.asList(10.0, 30.0, 20.0, 60.0, 50.0);
            heights_m.stream()
                    .map(x -> x * x)
                    .forEach(x -> System.out.println(x));
        }

        List<Student> students = Arrays.asList(
                new Student("Bill", 1.68, 52),
                new Student("Alice", 3.5, 40),
                new Student("Doris", 4.01, 102),
                new Student("Charlie", 3.8, 12)
        );



        // Level 1: Simple
        // --------------------------------------------------------

        // Terminal Operation: forEach
        students.stream()
                .forEach(std -> System.out.println(std.getName()));

        // Intermediate Operation: filter
        students.stream()
                .filter(std -> std.getGpa() >= 3.5)
                .forEach(std -> System.out.println(std.getName()));

        // Terminal Operation: count
        long numFailing = students.stream()
                .filter(std -> std.getGpa() < 1.0)
                .count();

        // Terminal Operation: collector
        List<Student> honourRoll = students.stream()
                .filter(std -> std.getGpa() >= 3.5)
                .collect(Collectors.toList());
        List<Student> studentsWithL = students.stream()
                .filter(std -> std.getName().contains("l"))
                .collect(Collectors.toList());

        // Intermediate Operation: sorted()
        List<Student> sorted = students.stream()
                .sorted()
                .collect(Collectors.toList());


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
        String messageJoin = "Student names: " + students.stream()
                .map(std -> std.getName())
                .collect(Collectors.joining(", "));

//        int sumHeight = heights_m.stream()
//                .collect(Collectors.summingInt());



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
    }
    boolean hasGreatGpa(Student s) {
        return s.getGpa() >= 4.0;
    }


    interface Observer {
        void event(String description);
    }
    class Model {
        public void addObserver(Observer obs) {
            // ...
        }
    }

    class Client {
        private void regObserver() {
            Model model = new Model();

            // Option 1: Anonymous Class
            model.addObserver(new Observer() {
                @Override
                public void event(String description) {
                    handleEvent(description);
                }
            });

            // Option 2: Lambda
            model.addObserver(msg -> handleEvent(msg));

            // Option 3: Method Reference
            model.addObserver(this::handleEvent);
        }

        private void handleEvent(String description) {
            System.out.println(description);
        }
    }

}
