import java.util.Scanner;
import java.lang.Math;

import Character.Character;
import Character.Archer;
import Character.Knight;
import Character.Mage;
import Character.Healer;
import Character.MythicalCreature;

import Equipment.Equipment;
import Equipment.Armor;
import Equipment.Artefact;

public class Market {
    private Player player;
    private int existingGoldCoins;
    private int neededGoldCoins;

    //Singleton Design Pattern is used. Only one Market object can be created.
    private static Market instance = null;

    //Constructor is private to prevent creating new Market objects.
    private Market() {
    }

    //If there is no Market object, it creates a new one. Otherwise, it returns the existing one.
    public static Market getInstance() {
        if (instance == null) {
            instance = new Market();
        }
        return instance;
    }

    //Displays the options for the player to choose.
    public void marketMenu(Player player, int goldCoins) {
        this.player = player;
        this.existingGoldCoins = goldCoins;

        System.out.println("----------------------------");
        System.out.println("Welcome to the Market Place!");
        System.out.println("----------------------------");
        System.out.println("What you want to do today? Please select an option: ");
        System.out.println("    1. Buy Army or Equipment");
        System.out.println("    2. Sell Army");
        System.out.println("    3. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                buyMenu();
                break;
            case 2:
                sellArmy();
                break;
            case 3:
                System.out.println("You have selected to exit.");
                return;
                //break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println(choice);

        for(Character cha : player.army) {
            System.out.println(cha.getName());
        }

        // if (choice == 3) {
        //     return;
        // }

        while (choice != 3) {
            marketMenu(player, existingGoldCoins);
            //scanner.close();
            return;
        }
    }

    //Displays the options for the player to choose what to buy.
    private void buyMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("What you want to buy? Please select an option: ");
        System.out.println("-----------------------------------------------");
        System.out.println("    1. Army");
        System.out.println("    2. Equipment");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                buyArmy();
                break;
            case 2:
                buyEquipment();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    //Display items
    private void tableHeader(String type) {
        if (type == "character") {
            System.out.println("---------------------------------------------");
            System.out.println("Please select the character you want to buy: ");
            System.out.println("---------------------------------------------");
            System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");
            System.out.format("%18s %18s %18s %18s %18s %18s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
            System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");
        }

        else {
            System.out.println("------------------------------------------");
            System.out.println("Please select the equipment you want to buy: ");
            System.out.println("------------------------------------------");
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "Type", "Price (gc)", "Attack", "Defence", "Health", "Speed\n");
            System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
        }
    }
    
    private void dispalyItems(String type, String name, int k) { //type: character or equipment
        if (type == "character") {
            Character displayItem = Registry.returnCharacter(name);
            System.out.format("%18s %18s %18s %18s %18s %18s", k + ". " + displayItem.getName(), displayItem.getPrize(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");            
        }

        else if (type == "equipment") {
            Equipment displayItem = Registry.returnEquipment(name);
            System.out.format("%20s %20s %20s %20s %20s %20s", k + ". " + displayItem.getName(), displayItem.getPrize(), displayItem.getAttack(), displayItem.getDefense(), displayItem.getHealth(), displayItem.getSpeed()+"\n");
        }

        else {
            System.out.println("Invalid type.");
        }
    }

    //Displays the characters that can be bought.
    private void buyArmy(){
        System.out.println("You have selected to buy an army.");
        System.out.println("------------------------------------------------------");
        System.out.println("Please select the character category you want to buy: ");
        System.out.println("------------------------------------------------------");
        System.out.println("    1. Archer");
        System.out.println("    2. Knight");
        System.out.println("    3. Mage");
        System.out.println("    4. Healer");
        System.out.println("    5. Mythical Creature");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        int characterChoice;
        String boughtCharacter;
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                System.out.println("You have selected to buy an Archer.");

                //Check whether an archer is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Archer) {
                        System.out.println("You already have an Archer in your army.");
                        return;
                    }
                }

                // System.out.println("---------------------------------------------");
                // System.out.println("Please select the character you want to buy: ");
                // System.out.println("---------------------------------------------");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");

                String[] archer = {"Shooter", "Ranger", "Sunfire", "Zing", "Saggitarius"};

                tableHeader("character");
                for (int i=0; i<archer.length; i++) {
                    dispalyItems("character", archer[i], i+1);
                }
                
                
                // Character displayShooter = Registry.returnCharacter("Shooter");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "1. "+displayShooter.getName(), displayShooter.getPrize(), displayShooter.getAttack(), displayShooter.getDefense(), displayShooter.getHealth(), displayShooter.getSpeed()+"\n");
                // Character dispalyRanger = Registry.returnCharacter("Ranger");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "2. "+dispalyRanger.getName(), dispalyRanger.getPrize(), dispalyRanger.getAttack(), dispalyRanger.getDefense(), dispalyRanger.getHealth(), dispalyRanger.getSpeed()+"\n");
                // Character displaySunfire = Registry.returnCharacter("Sunfire");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "3. "+displaySunfire.getName(), displaySunfire.getPrize(), displaySunfire.getAttack(), displaySunfire.getDefense(), displaySunfire.getHealth(), displaySunfire.getSpeed()+"\n");
                // Character displayZing = Registry.returnCharacter("Zing");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "4. "+displayZing.getName(), displayZing.getPrize(), displayZing.getAttack(), displayZing.getDefense(), displayZing.getHealth(), displayZing.getSpeed()+"\n");
                // Character displaySaggitarius = Registry.returnCharacter("Saggitarius");
                // System.out.format("%18s %18s %18s %18s %18s %18s", "5. "+displaySaggitarius.getName(), displaySaggitarius.getPrize(), displaySaggitarius.getAttack(), displaySaggitarius.getDefense(), displaySaggitarius.getHealth(), displaySaggitarius.getSpeed()+"\n");

                characterChoice = scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        boughtCharacter = "Shooter";
                        buyTransaction(boughtCharacter);
                        break;
                    case 2:
                        boughtCharacter = "Ranger";
                        buyTransaction(boughtCharacter);
                        break;
                    case 3:
                        boughtCharacter = "Sunfire";
                        buyTransaction(boughtCharacter);
                        break;
                    case 4:
                        boughtCharacter = "Zing";
                        buyTransaction(boughtCharacter);
                        break;
                    case 5:
                        boughtCharacter = "Saggitarius";
                        buyTransaction(boughtCharacter);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 2:
                System.out.println("You have selected to buy a Knight.");

                //Check whether a knight is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Knight) {
                        System.out.println("You already have a Knight in your army.");
                        return;
                    }
                }

                String[] knights = {"Squire", "Cavalier", "Templar", "Zoro", "Swiftblade"};

                tableHeader("character");
                for (int i=0; i<knights.length; i++) {
                    dispalyItems("character", knights[i], i+1);
                }
                
                characterChoice = scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        boughtCharacter = "Squire";
                        buyTransaction(boughtCharacter);
                        break;
                    case 2:
                        boughtCharacter = "Cavalier";
                        buyTransaction(boughtCharacter);
                        break;
                    case 3:
                        boughtCharacter = "Templar";
                        buyTransaction(boughtCharacter);
                        break;
                    case 4:
                        boughtCharacter = "Zoro";
                        buyTransaction(boughtCharacter);
                        break;
                    case 5:
                        boughtCharacter = "Swiftblade";
                        buyTransaction(boughtCharacter);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 3:
                System.out.println("You have selected to buy a Mage.");

                //Check whether a mage is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Mage) {
                        System.out.println("You already have a Mage in your army.");
                        return;
                    }
                }

                String[] mages = {"Warlock", "Illusionist", "Enchanter", "Conjurer", "Eldritch"};

                tableHeader("character");
                for (int i=0; i<mages.length; i++) {
                    dispalyItems("character", mages[i], i+1);
                }
                
                characterChoice = scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        boughtCharacter = "Warlock";
                        buyTransaction(boughtCharacter);
                        break;
                    case 2:
                        boughtCharacter = "Illusionist";
                        buyTransaction(boughtCharacter);
                        break;
                    case 3:
                        boughtCharacter = "Enchanter";
                        buyTransaction(boughtCharacter);
                        break;
                    case 4:
                        boughtCharacter = "Conjurer";
                        buyTransaction(boughtCharacter);
                        break;
                    case 5:
                        boughtCharacter = "Eldritch";
                        buyTransaction(boughtCharacter);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 4:
                System.out.println("You have selected to buy a Healer.");

                //Check whether a healer is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Healer) {
                        System.out.println("You already have a Healer in your army.");
                        return;
                    }
                }

                String[] healers = {"Soother", "Medic", "Alchemist", "Saint", "Lightbringer"};

                tableHeader("character");
                for (int i=0; i<healers.length; i++) {
                    dispalyItems("character", healers[i], i+1);
                }

                characterChoice = scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        boughtCharacter = "Soother";
                        buyTransaction(boughtCharacter);
                        break;
                    case 2:
                        boughtCharacter = "Medic";
                        buyTransaction(boughtCharacter);
                        break;
                    case 3:
                        boughtCharacter = "Alchemist";
                        buyTransaction(boughtCharacter);
                        break;
                    case 4:
                        boughtCharacter = "Saint";
                        buyTransaction(boughtCharacter);
                        break;
                    case 5:
                        boughtCharacter = "Lightbringer";
                        buyTransaction(boughtCharacter);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            case 5:
                System.out.println("You have selected to buy a Mythical Creature.");

                //Check whether a mythical creature is already in the army.
                for (Character character : player.army) {
                    if (character instanceof MythicalCreature) {
                        System.out.println("You already have a Mythical Creature in your army.");
                        return;
                    }
                }

                String[] mythicalCreatures = {"Dragon", "Basilisk", "Hydra", "Phoenix", "Pegasus"};

                tableHeader("character");
                for (int i=0; i<mythicalCreatures.length; i++) {
                    dispalyItems("character", mythicalCreatures[i], i+1);
                }

                characterChoice = scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        boughtCharacter = "Dragon";
                        buyTransaction(boughtCharacter);
                        break;
                    case 2:
                        boughtCharacter = "Basilisk";
                        buyTransaction(boughtCharacter);
                        break;
                    case 3:
                        boughtCharacter = "Hydra";
                        buyTransaction(boughtCharacter);
                        break;
                    case 4:
                        boughtCharacter = "Phoenix";
                        buyTransaction(boughtCharacter);
                        break;
                    case 5:
                        boughtCharacter = "Pegasus";
                        buyTransaction(boughtCharacter);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        //scanner.close();
    }

    //Performs the transaction of buying a character. Setting player attributes with updated gold coins and adding the character to the army.
    private void buyTransaction(String boughtCharacter) {
        Character character = Registry.returnCharacter(boughtCharacter);
        neededGoldCoins = character.getPrize();

        if (existingGoldCoins >= neededGoldCoins) {
            existingGoldCoins -= neededGoldCoins;
            //player.setGoldCoins(existingGoldCoins);
            player.army.add(character);
            System.out.println("You have bought " + boughtCharacter + " for " + neededGoldCoins + " gold coins.");
        } else {
            System.out.println("You don't have enough gold!");
        }
    }

    //Displays the equipment that can be bought.
    private void buyEquipment(){
        System.out.println("-----------------------------------");
        System.out.println("You have selected to buy equipment.");
        System.out.println("-----------------------------------");

        System.out.println("Please select which character you want to buy equipment for: ");
        System.out.println("-------------------------------------------------------------");
        
        int i = 1;
        for (Character character : player.army) {
            System.out.println("      " + i + " " +character.getName());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int characterChoice = scanner.nextInt();

        try {
            if (characterChoice < 0 || characterChoice >= player.army.size()) {
                throw new Exception("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        Character selectedCharacter = player.army.get(characterChoice-1);
        System.out.println("You have selected " + characterChoice);
        System.out.println("You have selected " + selectedCharacter.getName());
        //scanner.close();
        
        System.out.println("Please select the equipment you want to buy: ");
        System.out.println("---------------------------------------------");
        System.out.println("    1. Armour");
        System.out.println("    2. Artefact");

        int choice = scanner.nextInt();

        try {
            if (choice < 1 || choice > 2) {
                throw new Exception("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                System.out.println("You have selected to buy armour for " + selectedCharacter.getName());

                //Check whether an armour is equipped by the selectedCharacter.
                if (selectedCharacter.getEquipments() != null) {
                    for (Equipment equipment : selectedCharacter.getEquipments()) {
                        if (equipment instanceof Armor) {
                            System.out.println("You already have an armour equipped by " + selectedCharacter.getName());
                            return;
                        }
                    }
                }
                
                String[] armours = { "Chainmail", "Regalia", "Fleece" };

                tableHeader("equipment");
                for (int j=0; j<armours.length; j++) {
                    dispalyItems("equipment", armours[j], j+1);
                }

                int armourChoice = scanner.nextInt();
                System.out.println("You have selected " + armourChoice);

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
                        System.out.println("Invalid choice.");
                        break;
                }

                break;
            case 2:
                System.out.println("You have selected to buy artefact for " + selectedCharacter.getName());

                //Check whether an artefact is equipped by the selectedCharacter.
                if (selectedCharacter.getEquipments() != null) {
                    for (Equipment equipment : selectedCharacter.getEquipments()) {
                        if (equipment instanceof Artefact) {
                            System.out.println("You already have an artefact equipped by " + selectedCharacter.getName());
                            return;
                        }
                    }
                }

                String[] artefacts = { "Excalibur", "Amulet", "Crystal" };

                tableHeader("equipment");
                for (int j=0; j<artefacts.length; j++) {
                    dispalyItems("equipment", artefacts[j], j+1);
                }

                int artefactChoice = scanner.nextInt();
                System.out.println("You have selected " + artefactChoice);

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
                        System.out.println("Invalid choice.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

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
            // System.out.println("New attributes of " + selectedCharacter.getName() + " are: ");
            // System.out.println("Attack: " + selectedCharacter.getAttack());
            // System.out.println("Defense: " + selectedCharacter.getDefense());
            // System.out.println("Health: " + selectedCharacter.getHealth());
            // System.out.println("Speed: " + selectedCharacter.getSpeed());

            System.out.println("You have bought " + boughtEquipment + " for " + selectedCharacter.getName() + " for " + neededGoldCoins + " gold coins.");
        } else {
            System.out.println("You don't have enough gold!");
        }
    }

    //Displays the characters that can be sold.
    private void sellArmy(){
        System.out.println("You have selected to sell an army character");
        System.out.println("----------------------------------------------");
        System.out.println("Please select the character you want to sell: ");
        System.out.println("----------------------------------------------");

        int i = 1;
        for (Character character : player.army) {
            System.out.println("      " + i + " " +character.getName());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int characterChoice = scanner.nextInt(); //Need to handle invalid inputs

        try {
            if (characterChoice < 0 || characterChoice >= player.army.size()) {
                throw new Exception("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        
        Character selectedCharacter = player.army.get(characterChoice-1);
        System.out.println("You have selected " + selectedCharacter.getName());

        int sellPrice = Math.round(selectedCharacter.getPrize() * 90/100);
        existingGoldCoins += sellPrice;

        player.setGold(existingGoldCoins);
        player.army.remove(selectedCharacter);

        System.out.println("You have sold " + selectedCharacter.getName() + " for " + sellPrice + " gold coins.");
        //scanner.close();
    }

}
