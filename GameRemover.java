import java.util.InputMismatchException;

/* GameRemover class
 * GameRemover.java
 *
 * Class Description: This class is used to delete a specified game.
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */
public class GameRemover extends TextUserInterface {
    public void removeGame() {
        ListGames myList = new ListGames();
        myList.listGames();

        if (BoardGame.countGames == 0) {
            showMenuItems();
            return;
        }

        int removalIndex = getValidatedInput();

        if (removalIndex == 0) {
            return;
        }

        removalIndex--;

        if (eliminateFromArray(removalIndex)) {
            BoardGame.countGames--;
        } else {
            System.out.println("Failed to remove the game.");
        }
        showMenuItems();
    }
    private int getValidatedInput() {
        int input ;
        System.out.println("(Enter 0 to cancel)");
        do {
            try {
                System.out.print("> ");
                input = scanner.nextInt();
                if (input < 0 || input > BoardGame.countGames) {
                    System.out.println("Error: Please enter a selection between 0 and " +
                            BoardGame.countGames);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error: Please enter a selection between 0 and " +
                        BoardGame.countGames);
                scanner.next();
                input = -1;
            }
        } while (input < 0 || input > BoardGame.countGames);

        return input;
    }
    public boolean eliminateFromArray(int indexToBeEliminated) {
        if (indexToBeEliminated < 0 ||
                indexToBeEliminated >= storeGames.length) {
            return false;
        }
        for (int index = indexToBeEliminated;
             index < BoardGame.countGames - 1; index++) {
            storeGames[index] = storeGames[index + 1];
        }
        storeGames[BoardGame.countGames - 1] = null;
        return true;
    }
}
