
public class EasyGrader implements LetterGrader{
    public EasyGrader() {
    }

    @Override
    public String getGrade(double percent) {
        return "EASY";
    }

    @Override
    public double getMinPercentForGrade(String grade) {
        return 0;
    }
}
