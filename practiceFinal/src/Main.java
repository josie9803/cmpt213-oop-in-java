//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LetterGrader oops = new EasyGrader();
        String grade = oops.getGrade(85.0);
        System.out.println(grade);
        oops = new HardGrader();
        System.out.println(oops.getGrade(85.0));

        Model myModel = new Model();
        myModel.addObserver(this::print);
        String name = "wow";
        myModel.notifyObserver(name);
//        myModel.addObserver(new Observer() {
//            @Override
//            public void dataChanged() {
//                System.out.println("hello2");
//            }
//        });
//        myModel.notifyObserver();

    }
    void print(String name){
        System.out.println(name);
    }
}