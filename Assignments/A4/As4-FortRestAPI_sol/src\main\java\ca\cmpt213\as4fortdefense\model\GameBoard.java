package ca.cmpt213.as4fortdefense.model;

/**
 * Manage the game board, tracking which cells are occupied by enemy forts, and
 * which cells have been hit by the user's shots.
 */
public class GameBoard {
    public static final int NUMBER_ROWS = 10;
    public static final int NUMBER_COLS = 10;

    private final Cell[][] board = new Cell[NUMBER_ROWS][NUMBER_COLS];

    public GameBoard() {
        for (int row = 0; row < NUMBER_ROWS; row++) {
            for (int col = 0; col < NUMBER_COLS; col++) {
                board[row][col] = new Cell(false, 0);
            }
        }
    }

    public Cell getCellState(Coordinate cell) {
        int row = cell.getRowIndex();
        int col = cell.getColIndex();
        return board[row][col];
    }

    public boolean hasCellBeenShot(Coordinate cell) {
        int row = cell.getRowIndex();
        int col = cell.getColIndex();
        return board[row][col].hasBeenShot();
    }

    public boolean cellContainsEnemy(Coordinate cell) {
        int row = cell.getRowIndex();
        int col = cell.getColIndex();
        return board[row][col].hasFort();
    }

    public void recordUserShot(Coordinate pos) {
        if (!isCellCoordinateValid(pos)) {
            throw new IllegalArgumentException();
        }

        Cell current = board[pos.getRowIndex()][pos.getColIndex()];
        board[pos.getRowIndex()][pos.getColIndex()] = current.makeHasBeenShot();
    }

    public boolean cellOpenForEnemy(Coordinate cell) {
        return isCellCoordinateValid(cell) && !cellContainsEnemy(cell);
    }

    public void recordEnemyInCell(Coordinate cell, int enemyNumberAtCell) {
        assert cellOpenForEnemy(cell);

        int row = cell.getRowIndex();
        int col = cell.getColIndex();
        board[row][col] = board[row][col].makeContainEnemy(enemyNumberAtCell);
    }

    private boolean isCellCoordinateValid(Coordinate cell) {
        int row = cell.getRowIndex();
        int col = cell.getColIndex();

        boolean rowOK = row >= 0 && row < NUMBER_ROWS;
        boolean colOK = col >= 0 && col < NUMBER_COLS;

        return rowOK && colOK;
    }
}
