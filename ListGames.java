/* ListGames class
 * ListGames.java
 *
 * Class Description: it holds the list of games
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ListGames extends TextUserInterface {
    public void listGames() {

        System.out.println("List of Games:");
        System.out.println("****************");
        NewGame current = new NewGame();
        if (current.isStorageFull() ||
                BoardGame.countGames == 0) {
            System.out.println("No games found.\n");
            return;
        }

        StringBuilder strBuilder = new StringBuilder();
        Iterator<BoardGame> iterator =
                Arrays.stream(storeGames)
                        .filter(Objects::nonNull).iterator();

        int count = 0;
        while (iterator.hasNext()) {
            BoardGame game = iterator.next();
            count++;
            strBuilder.append(count)
                    .append(". ")
                    .append(game.getGameName())
                    .append(", ")
                    .append(game.getGameWeight())
                    .append(" weight, ")
                    .append(game.getNumOfGamesPlayed())
                    .append(" play(s)");

            if (iterator.hasNext()) {
                strBuilder.append("\n");
            }
        }
        System.out.println(strBuilder);
    }
}
