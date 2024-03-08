import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        GreetingsSelf phoneMsg = new GreetingsSelf("Einstein");
        GreetingsSelf mailMsg = phoneMsg;
        mailMsg.setName("Albert");
        System.out.println(phoneMsg.getName());

        GreetingsSelf newMsg = new GreetingsSelf("Josie");
        newMsg = phoneMsg;
        System.out.println(newMsg.getName());


        String msg = "H"; msg = msg + "i";
        msg += '!';
        int count = msg.length();
        System.out.println(count);

        ArrayList<GreetingsSelf> array = new ArrayList<>();
        List<GreetingsSelf> array1 = new ArrayList<>();
    }
}