public interface LetterGrader {
    int NUM_CARDS = 54;
    String getGrade(double percent);
    double getMinPercentForGrade(String grade);
    default void hello(){
        System.out.println("hi");
    }
}
