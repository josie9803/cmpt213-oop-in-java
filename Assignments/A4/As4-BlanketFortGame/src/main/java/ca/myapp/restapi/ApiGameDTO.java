package ca.myapp.restapi;

import ca.myapp.model.Game;

/**
 * DTO class for the REST API to define object structures required by the front-end.
 * HINT: Create static factory methods (or constructors) which help create this object
 *       from the data stored in the model, or required by the model.
 */
public class ApiGameDTO {
    public int gameNumber;
    public boolean isGameWon;
    public boolean isGameLost;
    public int opponentPoints;
    public long numActiveOpponentForts;

    // Amount of points that the opponents scored on the last time they fired.
    // If opponents have not yet fired, then it should be an empty array (0 size).
    public int[] lastOpponentPoints;

    public ApiGameDTO() {
    }

    // Constructor with parameters
    public ApiGameDTO(int gameNumber, boolean isGameWon, boolean isGameLost, int opponentPoints, long numActiveOpponentForts, int[] lastOpponentPoints) {
        this.gameNumber = gameNumber;
        this.isGameWon = isGameWon;
        this.isGameLost = isGameLost;
        this.opponentPoints = opponentPoints;
        this.numActiveOpponentForts = numActiveOpponentForts;
        this.lastOpponentPoints = lastOpponentPoints;
    }

    // Static factory method to create ApiGameDTO from Game instance
    public static ApiGameDTO fromGame(Game game) {
        return new ApiGameDTO(
                1,
                game.hasUserWon(),
                game.hasUserLost(),
                game.getEnemyPoints(),
                game.getEnemyPoints(),
                game.getLatestEnemyDamages()
        );
    }
}
