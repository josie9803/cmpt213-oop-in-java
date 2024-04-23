package ca.cmpt213.as4fortdefense.restapi_sol;

import ca.cmpt213.as4fortdefense.model.Cell;
import ca.cmpt213.as4fortdefense.model.Coordinate;
import ca.cmpt213.as4fortdefense.model.Game;
import ca.cmpt213.as4fortdefense.model.GameBoard;
import ca.cmpt213.as4fortdefense.restapi.ApiBoardDTO;

/**
 * SOLUTION: Complete the API DOT with factory methods
 */
public class ApiBoardDTOSol extends ApiBoardDTO {
    public static ApiBoardDTO fromGame(Game game) {
        ApiBoardDTO boardDto = new ApiBoardDTO();
        boardDto.boardWidth = GameBoard.NUMBER_COLS;
        boardDto.boardHeight = GameBoard.NUMBER_ROWS;

        // Build game board info to return
        boardDto.cellStates = new String[boardDto.boardHeight][boardDto.boardWidth];
        for (int rowIdx = 0; rowIdx < boardDto.boardHeight; rowIdx++) {
            for (int colIdx = 0; colIdx < boardDto.boardWidth; colIdx++) {
                Cell state = game.getCellState(new Coordinate(rowIdx, colIdx));

                String cellDescription;
                if (!game.isShowAllCheat() && state.isHidden() && !game.hasUserLost() && !game.hasUserWon()) {
                    cellDescription = "fog";
                } else if (state.hasFort() && state.hasBeenShot()) {
                    cellDescription = "hit";
                } else if (state.hasFort()) {
                    cellDescription = "fort";
                } else if (state.hasBeenShot()){
                    cellDescription = "miss";
                } else {
                    cellDescription = "field";
                }
                boardDto.cellStates[rowIdx][colIdx] = cellDescription;
            }
        }
        return boardDto;
    }
}
