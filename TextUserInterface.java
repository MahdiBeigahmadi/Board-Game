/* TextUserInterface class
 * TextUserInterface.java
 *
 * Class Description: This class holds data,
 * that relates to the screen and keyboard
 * Class Invariant: Duplication is not allowed
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: Jan. 2024
 */

import java.util.Scanner;
import java.util.InputMismatchException;
public class TextUserInterface {
    public final Scanner
            scanner = new Scanner(System.in);
    public static BoardGame[]
            storeGames = new BoardGame[50];

    private void getTheInput(int anOption) {
        switch (anOption) {
            case 1:
                ListGames newList = new ListGames();
                newList.listGames();
                break;
            case 2:
                NewGame newGame = new NewGame();
                newGame.addNewGame();
                break;
            case 3:
                GameRemover deleteGame = new GameRemover();
                deleteGame.removeGame();
                break;
            case 4:
                RecordGames record = new RecordGames();
                record.recordPlayedGames();
                break;
            case 5:
                GameObjects objectAccess = new GameObjects();
                objectAccess.printAllGameObjects();
                break;
            case 6:
                scanner.close();
                System.exit(0);
            default:
                showMenuItems();
                break;
        }
    }

    public void greetTheUser() {
        System.out.println("**********************************\n" +
                "Welcome to the Board Game Tracker\n" +
                "by Mahdi Beigahmadi.\n" +
                "**********************************\n");
        showMenuItems();
    }

    public void showMenuItems() {
        boolean showMenu = true;

        while (true) {
            try {
                if (showMenu) {
                    System.out.print(
                            "*************\n" +
                                    "* Main Menu *\n" +
                                    "*************\n" +
                                    "1. List games\n" +
                                    "2. Add a new game\n" +
                                    "3. Remove a game\n" +
                                    "4. Record that you played a game\n" +
                                    "5. DEBUG: Dump objects (toString)\n" +
                                    "6. Exit\n> ");
                }

                int menuOption = scanner.nextInt();
                scanner.nextLine();

                if (menuOption < 1 || menuOption > 6) {
                    System.out.print("Error: Please enter a selection between 1 and 6 \n> ");
                    showMenu = false;
                    continue;
                }

                getTheInput(menuOption);
                showMenu = true;

            } catch (InputMismatchException ex) {
                System.out.println("Error: Please enter a numeric value");
                scanner.next();
                showMenu = false;
            }
        }
    }
}
