import Core.*;

import Utils.MainMenu;
import Utils.ScannerUtil;
import java.util.ArrayList;

import Character.Character;
import Equipment.Equipment;
import HomeGround.HomeGround;
import HomeGround.Arcane;
import HomeGround.Hillcrest;
import HomeGround.Marshland;

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
        ScannerUtil.scanner.close();

        // Not Needed below, can be deleted after testing
        // ArrayList<Character> army1 = new ArrayList<>();
        // army1.add(Registry.returnCharacter("Alchemist"));
        // army1.add(Registry.returnCharacter("Warlock"));

        // ArrayList<Character> army2 = new ArrayList<>();
        // army2.add(Registry.returnCharacter("Ranger"));
        // army2.add(Registry.returnCharacter("Squire"));

        // Player player1 = new Player("himala", "Himala"); // Creating a player
        // player1.homeGround = new Hillcrest();// Setting the home ground
        // player1.army = army1;

        // // Player player2 = new Player("yutharsan", "Yutharsan");1
        // // player2.homeGround = new Marshland();
        // // player2.army = army2;

        //// Battle new_battle = new Battle(player1, player2);
        //// new_battle.fight();
    }
}
