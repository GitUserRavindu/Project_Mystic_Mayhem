package core;

import equipment.*;
import gameutils.Utils;
import characters.*;
import characters.Character;

public class Market {
    
    private Market() {}

    public static void displayMenu(Player player) {

        System.out.println("--------------------------------------");
        System.out.println("Welcome to the Market, " + player.getName() + "!");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("You have " + player.getGold() + " gold");
        System.out.println();
        System.out.println("What you want to do today? Please select an option: ");
        System.out.println("    1. Buy Character");
        System.out.println("    2. Buy Equipment");
        System.out.println("    3. Sell Character");
        System.out.println("    4. Exit the Market");
        System.out.println();
        int choice = Utils.readInt(">>> ", 1, 4);
        System.out.println();


        switch (choice) {
            case 1:
                buyCharacter(player);
                break;
            case 2:
                buyEquipment(player);
                break;
            case 3:
                sellCharacter(player);
                break;
            case 4:
                System.out.println("---------------------------------------------------------------");
                System.out.println("Thank you for visiting the Market Place! Goodbye! See you soon!");
                System.out.println("---------------------------------------------------------------");
                System.out.println();
                return;
            default:
                // This is handled by readInt
                // System.out.println("Invalid choice. Please enter a valid number.");
                // System.out.println();
                break;
        }

        if (choice != 4) {
            displayMenu(player);
        }
    }


    /////////////////////////// Buy Character //////////////////////////////////////////////////////////////////////

    public static void buyCharacter(Player player) {
        System.out.println("------------------------------------------------------");
        System.out.println("Please select the character category you want to buy: ");
        System.out.println("------------------------------------------------------");
        System.out.println("   1. Archer");
        System.out.println("   2. Knight");
        System.out.println("   3. Mage");
        System.out.println("   4. Healer");
        System.out.println("   5. Mythical Creature");
        System.out.println();
        int choice = Utils.readInt(">>> ", 1, 5);

        

        if (!player.battleCompatible()) {
            System.out.println("Since your army is not consiting of at least one character from each category,");
            System.out.println("we encourage you to buy one character from each category to make your army complete.");
            System.out.println("For now, stick to buying only Level 1 characters");
            System.out.println("You can buy the advanced characters as you win more battles and earn more gold.");
            System.out.println("You can always sell your army characters in the sell menu and buy new ones here.\n");
        }

        switch (choice) {
            case 1:
                buyCharacterCategory(player, "Archer");
                break;
            case 2:
                buyCharacterCategory(player, "Knight");
                break;
            case 3:
                buyCharacterCategory(player, "Mage");
                break;
            case 4:
                buyCharacterCategory(player, "Healer");
                break;
            case 5:
                buyCharacterCategory(player, "Mythical Creature");
                break;    
            default:
                break;
        }

    }

    public static void buyCharacterCategory(Player player, String category) {

        if (player.getArmy().hasCharacter(category)) {
            System.out.println("You already have " + category + " " + player.getArmy().getCharacterName(category) + " in your army.");
            return;
        }

        System.out.println("You have selected to buy a " + category );

        String[] CharNames = CharacterRegistry.getNames(category);

        tableHeader("character");
        for (int i = 0; i < CharNames.length; i++) {
            dispalyItems("character", CharNames[i], i+1);
        }
        System.out.println();

        int tier = Utils.readInt("Please select a number: ", 1, 5);

        Character character = CharacterRegistry.newCharacter(category, tier);
        boolean boughtCharacter = player.buyCharacter(character);  // Returns false if the player doesn't have enough gold

        if (boughtCharacter) {
            System.out.println("--------------------------");
            System.out.println("Transcation is Successful!");
            System.out.println("--------------------------");
            System.out.println();
            System.out.println("You have bought " + character.getName() + " for " + character.getPrice() + " gold.");
            System.out.println("You now have " + player.getGold() + " gold.");
            System.out.println();
            System.out.println("Your army now consists of: " + player.getArmyInfo());
            System.out.println();
            System.out.println("Please come agin. Going back to the Buy menu...");
            System.out.println();
            return;
        } 
    
        System.out.println("----------------------------");
        System.out.println("Transcation is Unsuccessful!");
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("You don't have enough gold!");
        System.out.println("You have " + player.getGold() + " gold.");
        System.out.println("You need " + (character.getPrice() - player.getGold()) + " more gold.");
        System.out.println();
        System.out.println("Please come back later. Going back to the Buy menu...");
        System.out.println();
        return;

    }

    public static void sellCharacter(Player player) {
        System.out.println("----------------------------------------------");
        System.out.println("Please select the character you want to sell: ");
        System.out.println("----------------------------------------------");

        int i = 1;
        for (Character character : player.getArmy().getCharacters()) {
            System.out.println("    " + i + ". " + character.getName() + " - " + character.getEquipNameString());
            i++;
        }

        int armySize = player.getArmy().getSize();
        int choice = Utils.readInt(">>> ",1,armySize);

        String category = player.getArmy().getCharacterbyIndex(choice);
        Character character = player.getArmy().getCharacter(category);

        System.out.println("You have selected " + character.getName());
        System.out.println();
        String choice2 = Utils.readString("Are you sure you want to sell " + character.getName() + "? Y/N");

        if(choice2.toUpperCase().equals("Y")) {

            player.sellCharacter(category);

            System.out.println("--------------------------");
            System.out.println("Transcation is Successful!");
            System.out.println("--------------------------");

            System.out.println("You have sold " + character.getName() + " for " + character.getPrice() + " gold.");
            System.out.println("Your available gold coins are: " + player.getGold() + " gold.");
            System.out.println();
            System.out.println("Your army now consists of: " + player.getArmyInfo());
            System.out.println();
            System.out.println("Please come back later. Going back to the Market Menu...");
            System.out.println();
        }
        else {
            System.out.println("You have selected not to sell " + character.getName() + ".");
            System.out.println("Please come back later. Going back to the Market Menu...");
            System.out.println();
            return;
        }
        
    }
    



    
    /////////////////////////// Buy Equipment //////////////////////////////////////////////////////////////////////////////////////
    
    //Displays the equipment that can be bought.

    private static void buyEquipment(Player player){

        if (!player.battleCompatible()) {
            System.out.println("Since your army is not consiting of at least one character from each category,");
            System.out.println("we encourage you to buy one character from each category to make your army complete.");
            System.out.println("After that, you can buy the equipment for each character.");
            return;
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Please select which character you want to buy equipment for: ");
        System.out.println("-------------------------------------------------------------");
        
        int i = 1;
        for (Character character : player.getArmy().getCharacters()) {
            System.out.println("      " + i + ". " + character.getName() + " - " + character.getEquipNameString());
            i++;
        }

        int armySize = player.getArmy().getSize();
        int choice = Utils.readInt(">>> ",1,armySize);

        String category = player.getArmy().getCharacterbyIndex(choice);
        Character character = player.getArmy().getCharacter(category);
        
        System.out.println("You have selected to buy an equipment for : " + character.getName());
        
        System.out.println("---------------------------------------------");
        System.out.println("Please select the equipment you want to buy: ");
        System.out.println("---------------------------------------------");
        System.out.println("    1. Armor"); 
        System.out.println("    2. Artifact");
        System.out.println();

        int choice2 = Utils.readInt(">>> ",1,2);

        switch (choice2) {
            case 1:
                buyEquipmentCategory(player, character, "Armor");
                break;
            case 2:
                buyEquipmentCategory(player, character, "Artifact");
                break;
            default:
                break;
        }
    }



    private static void buyEquipmentCategory(Player player, Character character, String category) {
        System.out.println("You have selected to buy " + category + " for " + character.getName());

        boolean hasItem = false;

        switch (category) {
            case "Armor":
                if (character.getArmor() != null) {
                    System.out.println("Armor " + character.getArmor().getName() + " is already equipped by " + character.getName());
                    hasItem = true;
                }
                break;
            case "Artifact":
                if (character.getArtifact() != null) {
                    System.out.println("Artifact " + character.getArtifact().getName() + " is already equipped by " + character.getName());
                    hasItem = true;
                }
                break;
        
            default:
                break;
        }

        if (hasItem) {
            String choice = Utils.readString("Buying a new" + category + " will replace the old one. Are you sure you want to contrinue? Y/N");  
            if  (!choice.toUpperCase().equals("Y")) {
                return;
            }      
            
        }
        
        String[] categories = EquipmentCache.getNames(category);

        tableHeader("equipment");
        for (int j = 0; j < categories.length; j++) {
            dispalyItems("equipment", categories[j], j+1);
        }

        System.out.println();
        int tier = Utils.readInt("Please select a number: ", 1, 3);
        
        Equipment equipment = EquipmentCache.getEquipment(category, tier);

        if (hasItem) {
            switch (category) {
                case "Armor":
                    if (character.getArmor() == equipment) {  // because Flyweight
                        System.out.println(character.getName() + " already has this item.");
                        System.out.println("Going back to Market menu...");
                        return;
                    }
                    break;
                case "Artifact":
                    if (character.getArtifact() == equipment) {  // because Flyweight
                        System.out.println(character.getName() + " already has this item.");
                        System.out.println("Going back to Market menu...");
                        return;
                    }
                    break;    
                default:
                    break;
            }
        }

        boolean affordable = (player.getGold() >= equipment.getPrice());  // Returns false if the player doesn't have enough gold

        if (affordable) {
            character.giveEquip(equipment);
            System.out.println("---------------------------");
            System.out.println("Transacation is Successful!");
            System.out.println("---------------------------");
            System.out.println();
            System.out.println("You have bought " + equipment.getName() + " for " + character.getName() + " for " + equipment.getPrice() + " gold.");
            System.out.println("You now have " + player.getGold() + " gold.");
            System.out.println();

            System.out.println("New attributes of " + character.getName() + ": ");
            character.printStats();

            System.out.println("Please come back later. Going back to the Market menu...");
            System.out.println();

            return;
        }
        
        System.out.println("----------------------------");
        System.out.println("Transcation is Unsuccessful!");
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("You don't have enough gold!");
        System.out.println("Available gold: " + player.getGold());
        System.out.println("Needed gold: " + (equipment.getPrice() - player.getGold()));
        System.out.println();
        System.out.println("Please come back later. Going back to the Market menu...");
        System.out.println();
        return;
    }





    
    /////////////////////////// Show Room - Display Items //////////////////////////////////////////////////////////////////////
    
    //Display items - Header of the table
    private static void tableHeader(String type) {
        if (type == "character") {
            System.out.println("---------------------------------------------");
            System.out.println("Please select the character you want to buy: ");
            System.out.println("---------------------------------------------");
            System.out.println();
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
        }

        else {
            System.out.println("---------------------------------------------");
            System.out.println("Please select the equipment you want to buy: ");
            System.out.println("---------------------------------------------");
            System.out.println();
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "Type |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
        }
    }
    
    //Display items - Rows of the table
    private static void dispalyItems(String type, String name, int k) { //type: character/equipment; k: index of the item to display
        if (type == "character") {
            Character displayItem = CharacterRegistry.newCharacterbyName(name);
            System.out.format("%20s %20s %20s %20s %20s %20s", k + ". " + displayItem.getName(), displayItem.getPrice(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");            
        }

        else if (type == "equipment") {
            Equipment displayItem = EquipmentCache.getEquipmentbyName(name);
            System.out.format("%20s %20s %20s %20s %20s %20s", k + ". " + displayItem.getName(), displayItem.getPrice(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");
        }

        else {
            System.out.println("Invalid type."); //Testing purposes
        }
    }


}
