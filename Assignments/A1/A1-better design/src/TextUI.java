import java.util.ArrayList;
import java.util.List;

/**
 * Application to track games played
 */
public class TextUI {
    private static String[] mainMenuOptions = {
            "List games",
            "Add a new game",
            "Remove a game",
            "Record that you played a game",
            "DEBUG: Dump objects (toString)",
            "Exit"
    };
    private static final int OPTION_LIST = 1;
    private static final int OPTION_ADD = OPTION_LIST + 1;
    private static final int OPTION_REMOVE = OPTION_ADD + 1;
    private static final int OPTION_GAME_PLAYED = OPTION_REMOVE + 1;
    private static final int OPTION_DEBUG = OPTION_GAME_PLAYED + 1;
    private static final int OPTION_EXIT = OPTION_DEBUG + 1;

    private List<Game> game = new ArrayList<>();
    public void start(){
        displayWelcomeMessage();

        TextMenu mainMenu = new TextMenu("Main Menu", mainMenuOptions);
        int option = OPTION_EXIT;
        do{
            mainMenu.display();
            option = mainMenu.getSelection();
            handleMenuOption
        }
    }
}
