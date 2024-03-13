import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import HomeGround.*;

import Character.Character;
// import Equipment.Equipment;


public class Main {
    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println("Welcome to the Mystic Mayhem! ");
        System.out.println("------------------------------");

        Scanner scanner = new Scanner(System.in);

        GameSaveManager gameLoadManager = new GameSaveManager();
        gameLoadManager.loadGameInstructions();

        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

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

        // System.out.println(c.getName());

        System.out.println("Do you want to select an existing profile or create a new one? ");
        System.out.println("1. Create a new profile");
        System.out.println("2. Select an existing profile");

        int choice = scanner.nextInt();
        Player playerP;

        if (choice == 1) {
            playerP = Profile.createProfile();
        }
        else {
            HashMap<Integer, Player> selectPlayerMap = new HashMap<Integer, Player>();
            selectPlayerMap = Profile.getPlayerMap();

            if (selectPlayerMap.size() == 0) {
                System.out.println("No profiles found. Please create a new profile.");
                playerP = Profile.createProfile();
            }
            else {
                System.out.println("Select a player to play with: ");
                for (Integer key : selectPlayerMap.keySet()) {
                    System.out.println(key + ". " + selectPlayerMap.get(key).getName());
                }
                int playerChoice = scanner.nextInt();
                playerP = selectPlayerMap.get(playerChoice);
            }
            
        }   

        Market market = Market.getInstance();
        market.marketMenu(playerP);

        //Finally, we will be here
        // System.out.println("-------------------------------------");
        // System.out.println("Do you want to save the game? (y/n)");
        // String save = scanner.nextLine();

        // if (save.equals("y")) {
        //     try {
        //         FileOutputStream savefile = new FileOutputStream("Player.ser");
        //         ObjectOutputStream out = new ObjectOutputStream(savefile);
        //         out.writeObject(playerP);
        //         out.close();
        //         System.out.println("Game saved successfully.");
        //     } catch (IOException e) {
        //         System.out.println("Error: " + e);
        //         e.printStackTrace();
        //     }
        // }
        
        GameSaveManager gameSaveManager = new GameSaveManager();
        gameSaveManager.saveGameInsructions();

        System.out.println("-------------------------------");
        System.out.println("Leaving Mystic Mayhem! Goodbye!");
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");

        scanner.close();

    }
}
