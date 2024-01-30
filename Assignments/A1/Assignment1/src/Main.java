import model.GameManager;
import ui.GameTextUI;
/**
 * Main class acts as an entry point of the program
 * It has an instance of @GameManager and @GameTextUI to interact with the game
 */

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        GameTextUI ui = new GameTextUI(manager);
        ui.show();
    }
}