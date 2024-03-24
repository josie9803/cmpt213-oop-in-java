package ca.myapp.restapi;

import ca.myapp.model.Cell;
import ca.myapp.model.Coordinate;
import ca.myapp.model.GameBoard;

/**
 * DTO class for the REST API to define object structures required by the front-end.
 * HINT: Create static factory methods (or constructors) which help create this object
 *       from the data stored in the model, or required by the model.
 */
public class ApiBoardDTO {
    public int boardWidth;
    public int boardHeight;

    // celState[row]col] = {"fog", "hit", "fort", "miss", "field"}
    public String[][] cellStates;

    public ApiBoardDTO(int boardWidth, int boardHeight, String[][] cellStates) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.cellStates = cellStates;
    }

    private static String[][] makeBoardStates(GameBoard gameBoard) {
        String[][] boardStates = new String[GameBoard.NUMBER_ROWS][GameBoard.NUMBER_COLS];
        for (int row = 0; row < GameBoard.NUMBER_ROWS; row++) {
            for (int col = 0; col < GameBoard.NUMBER_COLS; col++) {
                Cell cell = gameBoard.getCellState(new Coordinate(row, col));
                boardStates[row][col] = determineCellState(cell);
            }
        }
        return boardStates;
    }

private static String determineCellState(Cell cell) {
    return cell.hasBeenShot() && !cell.isRevealed() ?
            (cell.hasFort() ? "hit" : "miss")
            : (cell.isRevealed() ? (cell.hasFort() ? "fort" : "field") : "fog");
}

    public static ApiBoardDTO createFromGameBoard(GameBoard board){
        String[][] boardStates = makeBoardStates(board);
        return new ApiBoardDTO (GameBoard.NUMBER_ROWS, GameBoard.NUMBER_COLS, boardStates);
    }
}
