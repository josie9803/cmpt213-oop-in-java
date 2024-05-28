package ca.cmpt213.as4fortdefense.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Manage the game Blanket Fort Defense game state.
 */
public class Game {

    private final ScoreTracker enemyScoreTracker = new ScoreTracker();
    private final GameBoard board = new GameBoard();
    private final List<Enemy> enemies = new ArrayList<>();

    private List<Integer> latestEnemyPoints;
    private boolean lastPlayerShotHit;
    private boolean isShowAllCheat;

    public Game(int numEnemies) {
        IntStream.range(1, numEnemies + 1)
                .forEach(enemyNum -> enemies.add(new Enemy(board, enemyNum)));
    }

    public boolean hasUserWon() {
        return enemies.stream().allMatch(Enemy::isFortDestroyed);
    }

    public boolean hasUserLost() {
        return enemyScoreTracker.hasWon();
    }

    public int getEnemyPoints() {
        return enemyScoreTracker.getScore();
    }

    public void recordPlayerShot(Coordinate cell) {
        board.recordUserShot(cell);
        lastPlayerShotHit = board.cellContainsEnemy(cell);
    }

    public boolean didLastPlayerShotHit() {
        return lastPlayerShotHit;
    }

    public Cell getCellState(Coordinate cell) {
        return board.getCellState(cell);
    }

    public void fireEnemyShots() {
        latestEnemyPoints = new ArrayList<>();
        enemies.stream()
                .mapToInt(Enemy::getShotPoints)
                .filter(dmg -> dmg > 0)
                .forEach(dmg ->
                    {
                        enemyScoreTracker.addScore(dmg);
                        latestEnemyPoints.add(dmg);
                    });
    }

    public int[] getLatestEnemyPoints() {
        if (latestEnemyPoints == null) {
            return new int[0];
        }

        return latestEnemyPoints.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public long getNumberActiveOpponentForts() {
        return enemies.stream()
                .filter(e -> !e.isFortDestroyed())
                .count();
    }

    public void setShowAllCheat(boolean isCheating) {
        this.isShowAllCheat = isCheating;
    }

    public boolean isShowAllCheat() {
        return isShowAllCheat;
    }
}
