package ui;

import model.Game;
import model.GameManager;

/**
 * GameTextUI class contains the main loop/flow of the game
 * It interacts with user and supports operations such as add/remove/list/debug
 */
public class GameTextUI {
    private final GameManager gameList;
    private GeneralTextMenu menu = new GeneralTextMenu();
    public GameTextUI(GameManager gameList) {
        this.gameList = gameList;
    }
    private void listGame(){
        String prompt = "List of Games: ";
        System.out.println(prompt);
        menu.printStarSymbol(prompt);

        if (gameList.isEmpty()){
            System.out.println("No games found.\n");
        }
        else {
            int i = 1;
            for (Game game : gameList) {
                System.out.println(i + ". "
                        + game.getName() + ", "
                        + game.getWeight() + " weight, "
                        + game.getNumOfPlayedTimes() + " play(s)");
                i++;
            }
        }
    }
    private void addNewGame(){
        String gameName = menu.getString("Enter the game's name: ");
        double gameWeight = menu.getDouble("Enter the game's weight: ", 1.0, 5.0);
        Game g = new Game(gameName, gameWeight, 0);
        gameList.add(g);
    }
    private void removeGame(){
        listGame();
        if (!gameList.isEmpty()) {
            int index = menu.getIndexInteger("(Enter 0 to cancel)\n" + "> ", 0, gameList.getSize());
            gameList.remove(index);
        }
    }
    private void addPlayedGame(){
        listGame();
        if (!gameList.isEmpty()) {
            int index = menu.getIndexInteger("(Enter 0 to cancel)\n" + "> ", 0, gameList.getSize());
            if (index < 0){
                return;
            }
            gameList.getGameAtIndex(index).increaseNumOfPlayedTimes();
        }
    }
    private void debugDump(){
        System.out.println("All game objects: \n");
        int i = 1;
        for (Game game : gameList){
            System.out.println(i + ". " + game);
            i++;
        }
    }
    public void show() {
        boolean isDone = false;
        menu.displayTitle();
        while(!isDone) {
            menu.displayOptions();
            int choice = menu.getIndexInteger("> ", 1, 6) + 1;
            switch(choice){
                case 1:
                    listGame();
                    break;
                case 2:
                    addNewGame();
                    break;
                case 3:
                    removeGame();
                    break;
                case 4:
                    addPlayedGame();
                    break;
                case 5:
                    debugDump();
                    break;
                case 6:
                    isDone= true;
                    break;
                default:
                    System.out.println("Error: Please enter a selection between 1 and 6.");
            }
        }
    }
}