import Core.*;

import Utils.MainMenu;
import Utils.ScannerUtil;

public class Main {
    public static void main(String[] args) {

        MainMenu.displayGameStart();

        // Load a saved Game
        GameSaveManager gameLoadManager = new GameSaveManager();
        gameLoadManager.loadGameInstructions();

        // Initializations
        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations
        Market market = Market.getInstance();

        Profile.firstP(); // Geralt Of Rivia
        
        Player currentPlayer = null;

        // Main Menu
        while (true) {
            int choice = MainMenu.displayMainMenu();

            if (choice == 1) {
                currentPlayer = Profile.selectProfile(); // Select a Profile
            }

            else if (choice == 2) {
                currentPlayer = Profile.createProfile(); // Create a New Profile
            }

            else if (choice == 3) {
                if (currentPlayer == null) {
                    System.out.println("No profile selected. Please select a profile or create a new one.\n");
                    continue;
                }
                currentPlayer.displayCurrentStatus(); // See your current Profile
            }

            else if (choice == 4) {
                if (currentPlayer == null) {
                    System.out.println("No profile selected. Please select a profile or create a new one.\n");
                    continue;
                }
                currentPlayer.seeArmyDetails(); // See your Army Details
            }

            else if (choice == 5) {
                if (currentPlayer == null) {
                    System.out.println("No profile selected. Please select a profile or create a new one.\n");
                    continue;
                }
                Profile.changeName(currentPlayer); // Change your Name
            }

            else if (choice == 6) {
                if (currentPlayer == null) {
                    System.out.println("No profile selected. Please select a profile or create a new one.\n");
                    continue;
                }
                market.marketMenu(currentPlayer); // Visit Market Place
            }

            else if (choice == 7) {
                if (currentPlayer == null) {
                    System.out.println("No profile selected. Please select a profile or create a new one.\n");
                    continue;
                }
                if (currentPlayer.getArmy().size() == 0) {
                    System.out.println("You don't have an army to battle. Please visit the market place to buy some soldiers.\n");
                    continue;
                }

                // Select Opponent
                Player opponentPlayer = Profile.selectOpponent(currentPlayer);

                if (opponentPlayer == null) {
                    System.out.println("No opponent selected. Please select an opponent.\n");
                    continue;
                }

                Battle new_battle = new Battle(currentPlayer, opponentPlayer); // Start a New Battle
                new_battle.fight();
            }

            else if (choice == 8) {
                break;
            }
        }

        // Save Game
        GameSaveManager gameSaveManager = new GameSaveManager();
        gameSaveManager.saveGameInsructions();

        // Quit Game
        MainMenu.displayGameEnd();

        // Close Scanner
        ScannerUtil.scanner.nextLine();
        ScannerUtil.scanner.close();
    }
}
