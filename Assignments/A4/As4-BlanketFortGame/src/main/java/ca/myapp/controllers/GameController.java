package ca.myapp.controllers;

import ca.myapp.model.Coordinate;
import ca.myapp.model.Game;
import ca.myapp.model.GameBoard;
import ca.myapp.restapi.ApiBoardDTO;
import ca.myapp.restapi.ApiGameDTO;
import ca.myapp.restapi.ApiLocationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * GameController manages game-related API endpoints,
 * including game creation, moves, and cheat state activation.
 * also handles errors for invalid requests and missing game IDs.
 */
@RestController
public class GameController {
    private List<ApiGameDTO> games = new ArrayList<>();
    private List<Game> gameModels = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/api/about")
    public String getAuthorName() {
        return "Josie Tran";
    }

    @GetMapping("/api/games")
    public List<ApiGameDTO> getAllGames() {
        return games;
    }

    @PostMapping("/api/games")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiGameDTO createGame() {
        Game newGame = new Game(5);
        gameModels.add(newGame);
        ApiGameDTO game = ApiGameDTO.createFromGameModel(newGame);
        game.gameNumber = (int) nextId.incrementAndGet();
        games.add(game);
        return game;
    }

    @GetMapping("/api/games/{id}")
    public ApiGameDTO getGameById (@PathVariable("id") long gameId) {
        for (ApiGameDTO game: games) {
            if (game.gameNumber == gameId) {
                return game;
            }
        }
        throw new FileNotFound("Game Id not found");
    }

    @GetMapping("/api/games/{id}/board")
    public ApiBoardDTO getBoard (@PathVariable("id") long gameId) {
        ApiGameDTO game = getGameById(gameId);
        Game gameModel = gameModels.get(game.gameNumber - 1);
        if (gameModel == null){
            throw new FileNotFound("Game Id not found");
        }
        return ApiBoardDTO.createFromGameBoard(gameModel.getBoard());
    }

    @PostMapping("api/games/{id}/moves")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void makeMove(@PathVariable("id") int gameId,
                         @RequestBody ApiLocationDTO locationDTO) {
        ApiGameDTO game = getGameById(gameId);
        Game gameModel = gameModels.get(game.gameNumber - 1);
        if (gameModel == null){
            throw new FileNotFound("Game Id not found");
        }

        if (locationDTO == null ||
                locationDTO.row < 0 || locationDTO.row >= GameBoard.NUMBER_ROWS ||
                locationDTO.col < 0 || locationDTO.col >= GameBoard.NUMBER_COLS) {
            throw new BadRequest("Invalid location");
        }

        Coordinate moveCoordinate = new Coordinate(locationDTO.row, locationDTO.col);
        gameModel.recordPlayerShot(moveCoordinate);
        gameModel.fireEnemyShots();

        for (ApiGameDTO gameDTO : games) {
            if (gameDTO.gameNumber == gameId) {
                gameDTO.updateFromGame(gameModel);
            }
        }
    }

    @PostMapping("/api/games/{id}/cheatstate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void activateCheatState(@PathVariable("id") int gameId,
                                   @RequestBody String cheat) {
        ApiGameDTO game = getGameById(gameId);
        Game gameModel = gameModels.get(game.gameNumber - 1);
        if (gameModel == null){
            throw new FileNotFound("Game Id not found");
        }

        if (!cheat.equals("SHOW_ALL")) {
            throw new BadRequest("Not a valid cheat string");
        }

        gameModel.getBoard().revealAllCells();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Game Id not found")
    public static class FileNotFound extends RuntimeException {
        public FileNotFound(String str) {
            super(str);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Location is invalid")
    public static class BadRequest extends RuntimeException {
        public BadRequest(String str) {
            super(str);
        }
    }

}
