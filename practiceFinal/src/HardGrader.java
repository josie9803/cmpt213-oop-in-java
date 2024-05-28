public class HardGrader implements LetterGrader{
    @Override
    public String getGrade(double percent) {
        return "HARD";
    }

    @Override
    public double getMinPercentForGrade(String grade) {
        return 0;
    }
}
