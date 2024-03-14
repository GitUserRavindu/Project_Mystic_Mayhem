package Core;

import java.lang.Math;

import Utils.ScannerUtil;

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

    //....Market Constructor....//
    //Singleton Design Pattern is used.
    private static Market instance = null;

    private Market() {}

    //If there is no Market object, it creates a new one. Otherwise, it returns the existing one.
    public static Market getInstance() {
        if (instance == null) {
            instance = new Market();
        }
        return instance;
    }

    
    //....Market Menu....//
    //Displays the options for the player to choose.
    public void marketMenu(Player player) {
        this.player = player;
        this.existingGoldCoins = player.getGold();

        System.out.println("----------------------------");
        System.out.println("Welcome to the Market Place!");
        System.out.println("----------------------------");
        System.out.println("What you want to do today? Please select an option: ");
        System.out.println("    1. Buy Army");
        System.out.println("    2. Buy Equipment");
        System.out.println("    3. Sell Army");
        System.out.println("    4. Check the balance of your gold coins");
        System.out.println("    5. Exit");
        System.out.println("Please enter the corresponding number: (1/2/3/4/5)\n");

        int choice = ScannerUtil.scanner.nextInt();

        switch (choice) {
            case 1:
                buyArmy();
                break;
            case 2:
                buyEquipment();
                break;
            case 3:
                sellArmy();
                break;
            case 4:
                System.out.println("You have selected to check the balance of your gold coins. Here is your balance details: ");
                System.out.println("You have " + player.getGold() + " gold coins.");
                System.out.println();
                break;
            case 5:
                System.out.println("You have selected to exit.");
                System.out.println("---------------------------------------------------------------");
                System.out.println("Thank you for visiting the Market Place! Goodbye! See you soon!");
                System.out.println("---------------------------------------------------------------");
                System.out.println();
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid number.");
                System.out.println();
                break;
        }

        while (choice != 5) {
            marketMenu(player);
            return;
        }
    }


    //////////////////// Buy Menu /////////////////////////////////////////////////////////////////////////////////////

    //Displays the options for the player to choose what to buy.
    // private void buyMenu() {
    //     System.out.println("You have selected to buy Army or Equipment.");
    //     System.out.println("-----------------------------------------------");
    //     System.out.println("What you want to buy? Please select an option: ");
    //     System.out.println("-----------------------------------------------");
    //     System.out.println("    1. Army");
    //     System.out.println("    2. Equipment");
    //     System.out.println("    3. Check the balance of your gold coins");
    //     System.out.println("    4. Go back to the Market Menu");
    //     System.out.println("Please enter the corresponding number: (1/2/3/4)");
    //     System.out.println();

    //     int choice = ScannerUtil.scanner.nextInt();

    //     switch (choice) {
    //         case 1:
    //             buyArmy();
    //             break;
    //         case 2:
    //             buyEquipment();
    //             break;
    //         case 3:
    //             System.out.println("You have selected to check the balance of your gold coins. Here is your balance details: ");
    //             System.out.println("You have " + player.getGold() + " gold coins.");
    //             System.out.println();
    //             break;
    //         case 4:
    //             System.out.println("You have selected to go back to the Market Menu. Going back to the Market Menu...");
    //             System.out.println("---------------------------------------------------------------------------------");
    //             System.out.println();
    //             return;
    //         default:
    //             System.out.println("Invalid choice. Please enter a valid number.");
    //             System.out.println();
    //             break;
    //     }

    //     while (choice != 4) {
    //         buyMenu();
    //         return;
    //     }
    // }


    /////////////////////////// Show Room - Display Items //////////////////////////////////////////////////////////////////////

    //Display items - Header of the table
    private void tableHeader(String type) {
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
    private void dispalyItems(String type, String name, int k) { //type: character/equipment; k: index of the item to display
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


    /////////////////////////// Buy Army //////////////////////////////////////////////////////////////////////////////////////

    //Displays the characters that can be bought.
    private void buyArmy(){
        System.out.println("You have selected to buy an army.\n");

        if (!player.checkBattleCompatibility()) {
            System.out.println("Since your army is not consiting of at least one character from each category,");
            System.out.println("we encourage you to buy one character from each category to make your army complete.");
            System.out.println("You can buy the advanced characters as you win more battles and earn more golds.");
            System.out.println("You can always sell your army characters in the sell menu and buy new ones here.\n");
        }
        else {
            System.out.println("You army is already complete with at least one character from each category.");
            System.out.println("If you want to buy advanced characters, you can always sell your army characters first.");
            System.out.println("However, check the balance of your gold coins first before proceeding to buy advanced characters.\n");
        }


        System.out.println("------------------------------------------------------");
        System.out.println("Please select the character category you want to buy: ");
        System.out.println("------------------------------------------------------");
        System.out.println("NOTE: You need to have one character from each category in your army.");
        System.out.println("    1. Archer");
        System.out.println("    2. Knight");
        System.out.println("    3. Mage");
        System.out.println("    4. Healer");
        System.out.println("    5. Mythical Creature");
        System.out.println("Please enter the corresponding number: (1/2/3/4/5)");
        System.out.println();

        int choice = ScannerUtil.scanner.nextInt();

        int characterChoice;

        switch (choice) {
            case 1:
                System.out.println("You have selected to buy an Archer.");

                //Check whether an archer is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Archer) {
                        System.out.println("You already have an Archer in your army. Going back to the Buy menu...");
                        System.out.println();
                        return;
                    }
                }

                String[] archer = {"Shooter", "Ranger", "Sunfire", "Zing", "Saggitarius"};

                tableHeader("character");
                for (int i = 0; i < archer.length; i++) {
                    dispalyItems("character", archer[i], i+1);
                }
                System.out.println();
                System.out.println("Please select the corresponding number: (1/2/3/4/5)");
                System.out.println();

                characterChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                while(true) {
                    if (characterChoice < 1 || characterChoice > 5) {
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        System.out.println();
                        return;
                    }
                    else {
                        break;
                    }
                }
                
                
                switch (characterChoice) {
                    case 1:
                        buyTransaction("Shooter");
                        break;
                    case 2:
                        buyTransaction("Ranger");
                        break;
                    case 3:
                        buyTransaction("Sunfire");
                        break;
                    case 4:
                        buyTransaction("Zing");
                        break;
                    case 5:
                        buyTransaction("Saggitarius");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        System.out.println();
                        break;
                }
                break;
            case 2:
                System.out.println("You have selected to buy a Knight.");

                //Check whether a knight is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Knight) {
                        System.out.println("You already have a Knight in your army. Going back to the Buy menu...");
                        System.out.println();
                        return;
                    }
                }

                String[] knights = {"Squire", "Cavalier", "Templar", "Zoro", "Swiftblade"};

                tableHeader("character");
                for (int i=0; i<knights.length; i++) {
                    dispalyItems("character", knights[i], i+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3/4/5)");
                System.out.println();

                characterChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        buyTransaction("Squire");
                        break;
                    case 2:
                        buyTransaction("Cavalier");
                        break;
                    case 3:
                        buyTransaction("Templar");
                        break;
                    case 4:
                        buyTransaction("Zoro");
                        break;
                    case 5:
                        buyTransaction("Swiftblade");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        System.out.println();
                        break;
                }
                break;
            case 3:
                System.out.println("You have selected to buy a Mage.");

                //Check whether a mage is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Mage) {
                        System.out.println("You already have a Mage in your army. Going back to the Buy menu...");
                        System.out.println();
                        return;
                    }
                }

                String[] mages = {"Warlock", "Illusionist", "Enchanter", "Conjurer", "Eldritch"};

                tableHeader("character");
                for (int i=0; i<mages.length; i++) {
                    dispalyItems("character", mages[i], i+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3/4/5)");
                System.out.println();

                characterChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        buyTransaction("Warlock");
                        break;
                    case 2:
                        buyTransaction("Illusionist");
                        break;
                    case 3:
                        buyTransaction("Enchanter");
                        break;
                    case 4:
                        buyTransaction("Conjurer");
                        break;
                    case 5:
                        buyTransaction("Eldritch");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        break;
                }
                break;
            case 4:
                System.out.println("You have selected to buy a Healer.");

                //Check whether a healer is already in the army.
                for (Character character : player.army) {
                    if (character instanceof Healer) {
                        System.out.println("You already have a Healer in your army.");
                        System.out.println();
                        return;
                    }
                }

                String[] healers = {"Soother", "Medic", "Alchemist", "Saint", "Lightbringer"};

                tableHeader("character");
                for (int i=0; i<healers.length; i++) {
                    dispalyItems("character", healers[i], i+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3/4/5)");
                System.out.println();

                characterChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        buyTransaction("Soother");
                        break;
                    case 2:
                        buyTransaction("Medic");
                        break;
                    case 3:
                        buyTransaction("Alchemist");
                        break;
                    case 4:
                        buyTransaction("Saint");
                        break;
                    case 5:
                        buyTransaction("Lightbringer");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        System.out.println();
                        break;
                }
                break;
            case 5:
                System.out.println("You have selected to buy a Mythical Creature.");

                //Check whether a mythical creature is already in the army.
                for (Character character : player.army) {
                    if (character instanceof MythicalCreature) {
                        System.out.println("You already have a Mythical Creature in your army. Going back to the Buy menu...");
                        System.out.println();
                        return;
                    }
                }

                String[] mythicalCreatures = {"Dragon", "Basilisk", "Hydra", "Phoenix", "Pegasus"};

                tableHeader("character");
                for (int i=0; i<mythicalCreatures.length; i++) {
                    dispalyItems("character", mythicalCreatures[i], i+1);
                }
                System.out.println("Please select the corresponding number: (1/2/3/4/5)");
                System.out.println();

                characterChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + characterChoice);

                switch (characterChoice) {
                    case 1:
                        buyTransaction("Dragon");
                        break;
                    case 2:
                        buyTransaction("Basilisk");
                        break;
                    case 3:
                        buyTransaction("Hydra");
                        break;
                    case 4:
                        buyTransaction("Phoenix");
                        break;
                    case 5:
                        buyTransaction("Pegasus");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                        System.out.println();
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid number. Going back to the Buy menu...");
                System.out.println();
                break;
        }

    }


    /////////////////////////// Buy Transaction //////////////////////////////////////////////////////////////////////////////////////

    //Performs the transaction of buying a character. Setting player attributes with updated gold coins and adding the character to the army.
    private void buyTransaction(String boughtCharacter) {
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

        if (!player.checkBattleCompatibility()) {
            System.out.println("Since your army is not consiting of at least one character from each category,");
            System.out.println("we encourage you to buy one character from each category to make your army complete.");
            System.out.println("After that, you can buy the equipment for each character.");
            return;
        }

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

        int characterChoice = ScannerUtil.scanner.nextInt();

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

        int choice = ScannerUtil.scanner.nextInt();

        try {
            if (choice < 1 || choice > 2) {
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
                            System.out.println("Do you want to replace " + selectedCharacter.getArmor().getName() + "? (y/n)");

                            char c = ScannerUtil.scanner.next().charAt(0);

                            if(c == 'N' || c == 'n')
                            {
                                System.out.println("Going back to the Buy menu...");
                                return;
                            }

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

                int armourChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + armourChoice);
                System.out.println();

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

                int artefactChoice = ScannerUtil.scanner.nextInt();
                System.out.println("You have selected " + artefactChoice);
                System.out.println();

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
            selectedCharacter.equipEquipment(equipment);;

            //set the new price of character
            int valueIncrease = Math.round(neededGoldCoins * 20/100);
            selectedCharacter.setPrize(selectedCharacter.getPrize() + valueIncrease);

            System.out.println("---------------------------");
            System.out.println("Transacation is Successful!");
            System.out.println("---------------------------");
            System.out.println();
            System.out.println("You have bought " + boughtEquipment + " for " + selectedCharacter.getName() + " for " + neededGoldCoins + " gold coins.");
            System.out.println("Your available gold coins are: " + existingGoldCoins + " gold coins.");
            System.out.println();

            //display the new character attributes
            System.out.println("Updated attributes of " + selectedCharacter.getName() + " are: ");
            System.out.println("    Attack  : " + selectedCharacter.getAttack());
            System.out.println("    Defense : " + selectedCharacter.getDefense());
            System.out.println("    Health  : " + selectedCharacter.getHealth());
            System.out.println("    Speed   : " + selectedCharacter.getSpeed());
            System.out.println("    Price   : " + selectedCharacter.getPrize());
            System.out.println();

            System.out.println("Please come back later. Going back to the Buy menu...\n");
            return;
        } else {
            System.out.println("----------------------------");
            System.out.println("Transcation is Unsuccessful!");
            System.out.println("----------------------------\n");
            System.out.println("You don't have enough gold!");
            System.out.println("Available gold coins: " + existingGoldCoins + " gold coins.");
            System.out.println("Needed gold coins: " + neededGoldCoins + " gold coins.\n");
            System.out.println("Please come back later. Going back to the Buy menu...\n");
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

        int characterChoice = ScannerUtil.scanner.nextInt();

        try {
            if (characterChoice < 1 || characterChoice > player.army.size()) {
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

        char c = ScannerUtil.scanner.next().charAt(0);
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
        }
        else {
            System.out.println("You have selected not to sell " + selectedCharacter.getName() + ".");
            System.out.println("Please come back later. Going back to the Market Menu...");
            System.out.println();
            return;
        }

    }

}
