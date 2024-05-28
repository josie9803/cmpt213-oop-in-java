package ca.cmpt213.as4fortdefense.restapi_sol;

import ca.cmpt213.as4fortdefense.model.Game;
import ca.cmpt213.as4fortdefense.restapi.ApiGameDTO;

/**
 * SOLUTION: Complete the API DOT with factory methods
 */
public class ApiGameDTOSol extends ApiGameDTO {
    public static ApiGameDTO makeFromGame(Game game, int id) {
        ApiGameDTO gameDto = new ApiGameDTO();
        gameDto.gameNumber = id;
        gameDto.isGameWon = game.hasUserWon();
        gameDto.isGameLost = game.hasUserLost();
        gameDto.opponentPoints = game.getEnemyPoints();
        gameDto.numActiveOpponentForts = game.getNumberActiveOpponentForts();
        gameDto.lastOpponentPoints = game.getLatestEnemyPoints();
        return gameDto;
    }
}
