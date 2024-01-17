/* RecordGames class
 * RecordGames.java
 *
 * Class Description: By the current class we can
 * update the number of times we played the games
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

import java.util.InputMismatchException;

public class RecordGames extends TextUserInterface {
    public void recordPlayedGames() {
        ListGames temp = new ListGames();
        temp.listGames();
        if (BoardGame.countGames == 0) {
            showMenuItems();
            return;
        }
        System.out.println("(Enter 0 to cancel)");

        int recordIndex = -1;
        while (recordIndex < 0 || recordIndex > BoardGame.countGames) {
            System.out.print("> ");
            try {
                recordIndex = scanner.nextInt();
                if (recordIndex < 0 || recordIndex > BoardGame.countGames) {

                    System.out.println("Error: Please enter a selection between 0 and "
                            + BoardGame.countGames);
                } else if (recordIndex == 0) {
                    return;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                recordIndex = -1;
            }
        }
        int adjustedIndex = recordIndex - 1;
        storeGames[adjustedIndex].incrementNumPlayedGames();
        System.out.println(storeGames[adjustedIndex].getGameName()
                + " has been played " +
                storeGames[adjustedIndex].getNumOfGamesPlayed() + " time(s)!");

        showMenuItems();
    }
}
