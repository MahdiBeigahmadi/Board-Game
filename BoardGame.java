/* BoardGame class
 * BoardGame.java
 *
 * Class Description: This class basically contains
 * the details about the game such as its name, number of played games etc....
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

import java.lang.String;

public class BoardGame {
    private final String gameName;
    private final float gameWeight;
    private int numOfGamesPlayed;
    public static int countGames;

    public BoardGame(String gameName, float gameWeight,
                     int numOfGamesPlayed) {
        this.gameName = gameName;
        this.gameWeight = gameWeight;
        this.numOfGamesPlayed = numOfGamesPlayed;
    }

    public float getGameWeight() {
        return gameWeight;
    }

    public String getGameName() {
        return gameName;
    }

    public int getNumOfGamesPlayed() {
        return numOfGamesPlayed;
    }

    public void incrementNumPlayedGames() {
        numOfGamesPlayed++;
    }

    @Override
    public String toString() {
        return String.format(
                "sfu.cmpt213.as1.Game[Name:%s, Weight:%.2f, Games played:%d]",
                getGameName(),
                getGameWeight(),
                getNumOfGamesPlayed()
        );
    }
}
