package core;

import java.util.Scanner;
import java.lang.Math;
import java.rmi.registry.Registry;

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
        System.out.println("    4. Exit");
        System.out.println();
        int choice = Utils.readInt(">>>", 1, 4);
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
        int choice = Utils.readInt(">>>", 1, 5);

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

        int choice = Utils.readInt("Please select a number", 1, 5);
        buyTransaction(CharNames[choice-1]);

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
            Character displayItem = Registry.returnCharacter(name);
            System.out.format("%20s %20s %20s %20s %20s %20s", k + ". " + displayItem.getName(), displayItem.getPrize(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");            
        }

        else if (type == "equipment") {
            Equipment displayItem = Registry.returnEquipment(name);
            System.out.format("%20s %20s %20s %20s %20s %20s", k + ". " + displayItem.getName(), displayItem.getPrize(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");
        }

        else {
            System.out.println("Invalid type."); //Testing purposes
        }
    }




    













    /////////////////////////// Buy Transaction //////////////////////////////////////////////////////////////////////////////////////  

    //Performs the transaction of buying a character. Setting player attributes with updated gold coins and adding the character to the army.
    private static void buyTransaction(String boughtCharacter) {
        Character character = Registry.returnCharacter(boughtCharacter);
        neededGoldCoins = character.getPrize();

        if (existingGoldCoins >= neededGoldCoins) {
            existingGoldCoins -= neededGoldCoins;
            player.setGold(existingGoldCoins);
            player.army.add(character);
            System.out.println("--------------------------");
            System.out.println("Transcation is Successful!");
            System.out.println("--------------------------");
            System.out.println();
            System.out.println("You have bought " + boughtCharacter + " for " + neededGoldCoins + " gold coins.");
            System.out.println("Your available gold coins are: " + existingGoldCoins + " gold coins.");
            System.out.println();
            System.out.println("Your army is now consisting of: ");
            for (Character c : player.army) {
                System.out.println(c.getName());
            }
            System.out.println();
            System.out.println("Please come back later. Going back to the Buy menu...");
            System.out.println();
            return;
        } else {
            System.out.println("----------------------------");
            System.out.println("Transcation is Unsuccessful!");
            System.out.println("----------------------------");
            System.out.println();
            System.out.println("You don't have enough gold!");
            System.out.println("Available gold coins: " + existingGoldCoins + " gold coins.");
            System.out.println("Needed gold coins: " + neededGoldCoins + " gold coins.");
            System.out.println();
            System.out.println("Please come back later. Going back to the Buy menu...");
            System.out.println();
            return;
        }
    }

    
    /////////////////////////// Buy Equipment //////////////////////////////////////////////////////////////////////////////////////
    
    //Displays the equipment that can be bought.
    private void buyEquipment(){
        System.out.println("You have selected to buy an equipment.");
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("Please select which character you want to buy equipment for: ");
        System.out.println("-------------------------------------------------------------");
        
        int i = 1;
        for (Character character : player.army) {
            System.out.println("      " + i + ". " + character.getName());
            i++;
        }
        System.out.println("Please enter the corresponding number: ");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int characterChoice = scanner.nextInt();

        try {
            if (characterChoice < 1 || characterChoice > player.army.size()) {
                //scanner.close();
                throw new Exception("Invalid choice. Please enter a valid number.");              
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Going back to the Buy menu...");  
            System.out.println();         
            return;
        }

        Character selectedCharacter = player.army.get(characterChoice-1);
        System.out.println("You have selected to buy an equipment for : " + selectedCharacter.getName());
        
        System.out.println("---------------------------------------------");
        System.out.println("Please select the equipment you want to buy: ");
        System.out.println("---------------------------------------------");
        System.out.println("    1. Armour");
        System.out.println("    2. Artefact");
        System.out.println("Please enter the corresponding number: (1/2)");
        System.out.println();

        int choice = scanner.nextInt();

        try {
            if (choice < 1 || choice > 2) {
                //scanner.close();
                throw new Exception("Invalid choice. Please enter a valid number.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Going back to the Buy menu...");
            System.out.println();
            return;
        }

        switch (choice) {
            case 1:
                System.out.println("You have selected to buy an armour for " + selectedCharacter.getName());

                //Check whether an armour is equipped by the selectedCharacter.
                if (selectedCharacter.getEquipments() != null) {
                    for (Equipment equipment : selectedCharacter.getEquipments()) {
                        if (equipment instanceof Armor) {
                            System.out.println("You already have an armour equipped by " + selectedCharacter.getName());
                            System.out.println();
                            System.out.println("Going back to the Buy menu...");
                            //scanner.close();
                            return;
                        }
                    }
                }
                
                String[] armours = { "Chainmail", "Regalia", "Fleece" };

                tableHeader("equipment");
                for (int j=0; j<armours.length; j++) {
                    dispalyItems("equipment", armours[j], j+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3)");
                System.out.println();

                int armourChoice = scanner.nextInt();
                System.out.println("You have selected " + armourChoice);
                System.out.println();
                //scanner.close();

                switch (armourChoice) {
                    case 1:
                        buyEquipmentTransaction(selectedCharacter, "Chainmail");
                        break;
                    case 2:
                        buyEquipmentTransaction(selectedCharacter, "Regalia");
                        break;
                    case 3: 
                        buyEquipmentTransaction(selectedCharacter, "Fleece");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                        System.out.println("Going back to the Buy menu...");
                        System.out.println();
                        return;
                }

                break;
            case 2:
                System.out.println("You have selected to buy artefact for " + selectedCharacter.getName());

                //Check whether an artefact is equipped by the selectedCharacter.
                if (selectedCharacter.getEquipments() != null) {
                    for (Equipment equipment : selectedCharacter.getEquipments()) {
                        if (equipment instanceof Artefact) {
                            System.out.println("You already have an artefact equipped by " + selectedCharacter.getName());
                            System.out.println();
                            System.out.println("Going back to the Buy menu...");
                            //scanner.close();
                            return;
                        }
                    }
                }

                String[] artefacts = { "Excalibur", "Amulet", "Crystal" };

                tableHeader("equipment");
                for (int j=0; j<artefacts.length; j++) {
                    dispalyItems("equipment", artefacts[j], j+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3)");
                System.out.println();

                int artefactChoice = scanner.nextInt();
                System.out.println("You have selected " + artefactChoice);
                System.out.println();
                //scanner.close();

                switch (artefactChoice) {
                    case 1:
                        buyEquipmentTransaction(selectedCharacter, "Excalibur");
                        break;
                    case 2:
                        buyEquipmentTransaction(selectedCharacter, "Amulet");
                        break;
                    case 3: 
                        buyEquipmentTransaction(selectedCharacter, "Crystal");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                        System.out.println("Going back to the Buy menu...");
                        System.out.println();
                        return;
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid number.");
                System.out.println("Going back to the Buy menu...");
                System.out.println();
                //scanner.close();
                return;
        }
    }

    
    /////////////////////////// Buy Transaction - Equipment ///////////////////////////////////////////////////////////////////////
    
    //Performs the transaction of buying an equipment. Setting player attributes with updated gold coins and adding the equipment to the character.
    private void buyEquipmentTransaction(Character selectedCharacter, String boughtEquipment) {
        Equipment equipment = Registry.returnEquipment(boughtEquipment);
        neededGoldCoins = equipment.getPrize();

        if (existingGoldCoins >= neededGoldCoins) {
            existingGoldCoins -= neededGoldCoins;

            //set the new gold coins of player
            player.setGold(existingGoldCoins);

            //add the equipment to the character ///////////////////Make array list
            //selectedCharacter.getEquipments().add(equipment);

            //set the new price of character
            int valueIncrease = Math.round(neededGoldCoins * 20/100);
            selectedCharacter.setPrize(selectedCharacter.getPrize() + valueIncrease);

            //set the new attack, defense, health and speed of character
            selectedCharacter.setAttack(selectedCharacter.getAttack() + equipment.getAttack());
            selectedCharacter.setDefense(selectedCharacter.getDefense() + equipment.getDefense());
            selectedCharacter.setHealth(selectedCharacter.getHealth() + equipment.getHealth());
            selectedCharacter.setSpeed(selectedCharacter.getSpeed() + equipment.getSpeed());

            //display the new character attributes
            System.out.println("---------------------------");
            System.out.println("Transacation is Successful!");
            System.out.println("---------------------------");
            System.out.println();
            System.out.println("You have bought " + boughtEquipment + " for " + selectedCharacter.getName() + " for " + neededGoldCoins + " gold coins.");
            System.out.println("Your available gold coins are: " + existingGoldCoins + " gold coins.");
            System.out.println();

            System.out.println("New attributes of " + selectedCharacter.getName() + " are: ");
            System.out.println("    Attack  : " + selectedCharacter.getAttack());
            System.out.println("    Defense : " + selectedCharacter.getDefense());
            System.out.println("    Health  : " + selectedCharacter.getHealth());
            System.out.println("    Speed   : " + selectedCharacter.getSpeed());
            System.out.println();

            System.out.println("Please come back later. Going back to the Buy menu...");
            System.out.println();
            return;
        } else {
            System.out.println("----------------------------");
            System.out.println("Transcation is Unsuccessful!");
            System.out.println("----------------------------");
            System.out.println();
            System.out.println("You don't have enough gold!");
            System.out.println("Available gold coins: " + existingGoldCoins + " gold coins.");
            System.out.println("Needed gold coins: " + neededGoldCoins + " gold coins.");
            System.out.println();
            System.out.println("Please come back later. Going back to the Buy menu...");
            System.out.println();
            return;
        }
    }

    
    ////////////////////////////// Sell Army //////////////////////////////////////////////////////////////////////////////////////
    
    //Displays the characters that can be sold.
    private void sellArmy(){
        System.out.println("You have selected to sell an army character");
        System.out.println("----------------------------------------------");
        System.out.println("Please select the character you want to sell: ");
        System.out.println("----------------------------------------------");

        int i = 1;
        for (Character character : player.army) {
            System.out.println("      " + i + ". " +character.getName());
            i++;
        }
        System.out.println("Please enter the corresponding number: ");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int characterChoice = scanner.nextInt();

        try {
            if (characterChoice < 1 || characterChoice > player.army.size()) {
                //scanner.close();
                throw new Exception("Invalid choice. Please enter a valid number.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Going back to the Market Menu...");
            System.out.println();
            return;
        }
        
        Character selectedCharacter = player.army.get(characterChoice-1);
        System.out.println("You have selected " + selectedCharacter.getName());
        System.out.println("Are you sure you want to sell " + selectedCharacter.getName() + "? (y/n)");
        System.out.println();

        char c = scanner.next().charAt(0);
        if(c == 'Y' || c == 'y') {
            int sellPrice = Math.round(selectedCharacter.getPrize() * 90/100);
            existingGoldCoins += sellPrice;

            System.out.println("--------------------------");
            System.out.println("Transcation is Successful!");
            System.out.println("--------------------------");
            System.out.println();

            player.setGold(existingGoldCoins);
            player.army.remove(selectedCharacter);

            System.out.println("You have sold " + selectedCharacter.getName() + " for " + sellPrice + " gold coins.");
            System.out.println("Your available gold coins are: " + existingGoldCoins + " gold coins.");
            System.out.println();

            System.out.println("Your army is now consisting of: ");
            for (Character character : player.army) {
                System.out.println(character.getName());
            }
            System.out.println();

            System.out.println("Please come back later. Going back to the Market Menu...");
            System.out.println();
            //scanner.close();
        }
        else {
            System.out.println("You have selected not to sell " + selectedCharacter.getName() + ".");
            System.out.println("Please come back later. Going back to the Market Menu...");
            System.out.println();
            //scanner.close();
            return;
        }
        
    }

}
