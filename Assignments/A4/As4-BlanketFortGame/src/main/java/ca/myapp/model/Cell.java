package ca.myapp.model;

/**
 * Represent the state of a game-board cell.
 */
public class Cell {
    private final boolean hasBeenShot;
    private final int enemyNumberAtCell;
    private boolean isRevealed;

    public Cell(boolean isShot, int enemyNumberAtCell, boolean isRevealed) {
        this.hasBeenShot = isShot;
        this.enemyNumberAtCell = enemyNumberAtCell;
        this.isRevealed = isRevealed;
    }

    public boolean hasFort() {
        return enemyNumberAtCell != 0;
    }

    public boolean hasBeenShot() {
        return hasBeenShot;
    }
    public boolean isRevealed() {
        return isRevealed;
    }
    public void setRevealed(boolean value) {isRevealed = value;}

    public boolean isHidden() {
        return !hasBeenShot;
    }

    // Create new instance based on current state (Immutable)
    public Cell makeHasBeenShot() {
        return new Cell(true, enemyNumberAtCell, false);
    }

    public Cell makeContainEnemy(int enemyNumber) {
        return new Cell(hasBeenShot, enemyNumber, false);
    }

    public int getFortNumberAtCell() {
        return enemyNumberAtCell;
    }
}
