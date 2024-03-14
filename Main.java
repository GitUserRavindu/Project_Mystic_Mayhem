
import java.io.*;

import java.util.Scanner;

import core.Market;
import core.Player;
import core.Profile;
import core.Registry;

// import Character.Character;
// import Equipment.Equipment;

public class Main {
    public static void main(String[] args) {

        //At start we will be here
        //Ask for load save file as player
        System.out.println("------------------------------");
        System.out.println("Welcome to the Mystic Mayhem! ");
        System.out.println("------------------------------");
        
        Scanner scanner = new Scanner(System.in);
        
        //////////////Start of load game//////////////////////////////////////
        // System.out.println("Do you want to load a save file? (y/n)");
        // System.out.println("--------------------------------------");
        // String load = scanner.nextLine();

        // if (load.equals("y")) {
        //     try {
        //         FileInputStream savedfile = new FileInputStream("Player.ser");
        //         ObjectInputStream in = new ObjectInputStream(savedfile);
        //         playerP = (Player) in.readObject();
        //         in.close();
        //     } catch (IOException e) {
        //         playerP = new Player();
        //         System.out.println("Error occured. New player created: " + e);
        //         e.printStackTrace();
        //     } catch (ClassNotFoundException e) {
        //         playerP = new Player();
        //         System.out.println("Error: " + e);
        //         e.printStackTrace();
        //     }
        // } else {
        //     playerP = new Player();
        // }

        // System.out.println("Player Username : " + playerP.getUserName());
        // System.out.println("Player Army : " + playerP.getArmy());
        // System.out.println("Player Goldcoins : " + playerP.getGold());
        //////////////End of Load game//////////////////////////////////////

        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

        // We use Registry as a library to store the different configurations
        // of Characters, and we use name to return certain character
        // Equipment a = Registry.returnEquipment("Crystal");
        // Equipment b = Registry.returnEquipment("Crystal");
        // Character c = Registry.returnCharacter("Hydra");

        // System.out.println(a);
        // System.out.println(b);

        // a.setAttack(0);

        // System.out.println(a.getAttack() + " " + b.getAttack());

        // System.out.println(c.getName());
        Player playerP = Profile.createProfile();

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

        scanner.close();   

    }
}
