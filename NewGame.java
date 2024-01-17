/*NewGame class
 * NewGame.java
 *
 * Class Description: This class adds a new game to the array
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

import java.util.InputMismatchException;

public class NewGame extends TextUserInterface {
    public void addNewGame() {
        System.out.print("Enter the game's name: ");
        String aGameName;
        while (true) {
            aGameName = scanner.nextLine();
            if (!aGameName.isEmpty()) {
                break;
            }
            System.out.println("Error: Name must be at least 1 character long.");
            System.out.print("Enter the game's name: ");
        }

        float weight;
        while (true) {
            try {
                System.out.print("Enter the game's weight: ");
                weight = scanner.nextFloat();
                if (1 <= weight && weight <= 5) {
                    break;
                } else {
                    System.out.println("Error: Weight must be between 1.0 and 5.0");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        if (!isStorageFull()) {
            if (checkIfGameExists(aGameName)) {
                System.out.println("The game is already exits, " +
                        "its number was incremented");
                BoardGame.countGames++;
            } else {
                for (int i = 0; i < storeGames.length; i++) {
                    if (storeGames[i] == null) {
                        storeGames[i] =
                                new BoardGame(aGameName, weight, 0);
                        break;
                    }
                }
            }
        } else {
            System.out.println("Sorry, the game storage is full!");
        }
        BoardGame.countGames++;
        System.out.println();
    }

    private boolean checkIfGameExists(String aGameName) {
        for (BoardGame game : storeGames) {
            if (game != null && game.getGameName()
                    .equals(aGameName)) {
                game.incrementNumPlayedGames();
                return true;
            }
        }
        return false;
    }

    public boolean isStorageFull() {
        for (BoardGame game : storeGames) {
            if (game == null) {
                return false;
            }
        }
        return true;
    }
}
