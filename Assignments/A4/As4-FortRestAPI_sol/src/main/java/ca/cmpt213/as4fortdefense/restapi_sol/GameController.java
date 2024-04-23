package ca.cmpt213.as4fortdefense.restapi_sol;

import ca.cmpt213.as4fortdefense.model.Game;
import ca.cmpt213.as4fortdefense.restapi.ApiBoardDTO;
import ca.cmpt213.as4fortdefense.restapi.ApiGameDTO;
import ca.cmpt213.as4fortdefense.restapi.ApiLocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Blanket Fort Defense Game REST API
 *
 * Example usage:
 *  curl -s -i -X GET http://localhost:8080/api/about
 */
@RestController
@RequestMapping("/api")
public class GameController {
    private final List<Game> games = new ArrayList<>();

    // /about
    @GetMapping("/about")
    public String getAbout() {
        return "Brian Fraser";
    }

    // /games
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Make it receive the number of opponents
    public ApiGameDTO createGame() {
        int numOpponents = 5;
        System.out.println("Num opponents requested: " + numOpponents);
        Game game = new Game(numOpponents);
        ApiGameDTO apiGame = ApiGameDTOSol.makeFromGame(game, games.size());
        games.add(game);
        return apiGame;
    }
    @GetMapping("/games")
    public List<ApiGameDTO> retrieveGames() {
        List<ApiGameDTO> gameDto = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            gameDto.add(ApiGameDTOSol.makeFromGame(game, i));
        }
        return gameDto;
    }
    @GetMapping("/games/{id}")
    public ApiGameDTO retrieveGame(@PathVariable int id) {
        Game game = retrieveGameOrThrow404(id);
        return ApiGameDTOSol.makeFromGame(game, id);
    }

    // /board
    @GetMapping("/games/{id}/board")
    public ApiBoardDTO retrieveGameBoard(@PathVariable int id) {
        Game game = retrieveGameOrThrow404(id);
        return ApiBoardDTOSol.fromGame(game);
    }

    // /moves
    @PostMapping("/games/{id}/moves")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void makeMove(@PathVariable int id, @RequestBody ApiLocationDTO cellLocation) {
        System.out.println("Post on moves for ID " + id + " to " + cellLocation.row + "," + cellLocation.col);
        Game game = retrieveGameOrThrow404(id);

        if (game.hasUserLost() || game.hasUserWon()) {
            throw new BadRequestException("Unable to make a move after game is won or lost.");
        }

        try {
            game.recordPlayerShot(ApiLocationDTOSol.toCellLocation(cellLocation));
            if (!game.hasUserWon()) {
                game.fireEnemyShots();
            }
        } catch(IllegalArgumentException ex) {
            throw new BadRequestException("Illegal argument: " + ex.getMessage());
        }
    }

    // /cheatstate
    @PostMapping("/games/{id}/cheatstate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void setCheatState(@PathVariable int id, @RequestBody String cheat) {
        Game game = retrieveGameOrThrow404(id);
        if (cheat.equals("SHOW_ALL")) {
            System.out.println("Now cheating: showing all!");
            game.setShowAllCheat(true);
        } else {
            throw new BadRequestException("Unknown cheat state command.");
        }
    }

    // Helper functions
    private Game retrieveGameOrThrow404(int id) {
        if (id < 0 || id >= games.size()) {
            throw new FileNotFoundException("Requested game ID does not exist.");
        }
        return games.get(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private static class FileNotFoundException extends RuntimeException {
        private FileNotFoundException() {
        }
        private FileNotFoundException(String msg) {
            super(msg);
        }
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private static class BadRequestException extends RuntimeException {
        private BadRequestException() {
        }
        private BadRequestException(String msg) {
            super(msg);
        }
    }
}
