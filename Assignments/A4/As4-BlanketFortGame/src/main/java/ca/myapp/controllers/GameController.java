package ca.myapp.controllers;

import ca.myapp.model.Game;
import ca.myapp.restapi.ApiGameDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GameController {
    private List<ApiGameDTO> games = new ArrayList<>();
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
        ApiGameDTO game = ApiGameDTO.fromGame(newGame);
        game.gameNumber = (int) nextId.incrementAndGet();
        games.add(game);
        return game;
    }

    @GetMapping("/api/games/{id}")
    public ApiGameDTO getOneGame(@PathVariable("id") long gameId) {
        for (ApiGameDTO game: games) {
            if (game.gameNumber == gameId) {
                return game;
            }
        }
        throw new IllegalArgumentException();
    }

}
