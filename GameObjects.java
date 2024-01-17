/* GameObject class
 * GameObjects.java
 *
 * Class Description: This class has a method that
 * prints the object of the file
 * Class Invariant: None
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

public class GameObjects extends TextUserInterface {
    public void printAllGameObjects() {
        System.out.println("All game objects:\n");
        for (int i = 0; i < BoardGame.countGames; i++) {
            if (storeGames[i] != null) {
                System.out.println((i + 1) + ". "
                        + storeGames[i].toString());
            }
        }
        showMenuItems();
    }
}
