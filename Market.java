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
import Equipment.Artefacts;

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
        System.out.println("    1. Buy");
        System.out.println("    2. Sell");
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
                sellMenu();
                break;
            case 3:
                System.out.println("You have selected to exit.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println(choice);

        for(Character cha : player.army) {
            System.out.println(cha.getName());
        }

        if (choice == 3) {
            return;
        }

        while (choice != 3) {
            marketMenu(player, existingGoldCoins);
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

    //Displays the options for the player to choose what to sell.
    private void sellMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("What you want to sell? Please select an option: ");
        System.out.println("------------------------------------------------");
        System.out.println("    1. Army");
        System.out.println("    2. Equipment");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                sellArmy();
                break;
            case 2:
                sellEquipment();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
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

                System.out.println("---------------------------------------------");
                System.out.println("Please select the character you want to buy: ");
                System.out.println("---------------------------------------------");
                System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");
                System.out.format("%18s %18s %18s %18s %18s %18s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                System.out.format("%18s %18s %18s %18s %18s %18s", "------------------", "------------------", "------------------", "------------------", "------------------", "------------------\n");

                Character displayShooter = CharacterRegistry.returnCharacter("Shooter");
                System.out.format("%18s %18s %18s %18s %18s %18s", "1. "+displayShooter.getName(), displayShooter.getPrize(), displayShooter.getAttack(), displayShooter.getDefense(), displayShooter.getHealth(), displayShooter.getSpeed()+"\n");
                Character dispalyRanger = CharacterRegistry.returnCharacter("Ranger");
                System.out.format("%18s %18s %18s %18s %18s %18s", "2. "+dispalyRanger.getName(), dispalyRanger.getPrize(), dispalyRanger.getAttack(), dispalyRanger.getDefense(), dispalyRanger.getHealth(), dispalyRanger.getSpeed()+"\n");
                Character displaySunfire = CharacterRegistry.returnCharacter("Sunfire");
                System.out.format("%18s %18s %18s %18s %18s %18s", "3. "+displaySunfire.getName(), displaySunfire.getPrize(), displaySunfire.getAttack(), displaySunfire.getDefense(), displaySunfire.getHealth(), displaySunfire.getSpeed()+"\n");
                Character displayZing = CharacterRegistry.returnCharacter("Zing");
                System.out.format("%18s %18s %18s %18s %18s %18s", "4. "+displayZing.getName(), displayZing.getPrize(), displayZing.getAttack(), displayZing.getDefense(), displayZing.getHealth(), displayZing.getSpeed()+"\n");
                Character displaySaggitarius = CharacterRegistry.returnCharacter("Saggitarius");
                System.out.format("%18s %18s %18s %18s %18s %18s", "5. "+displaySaggitarius.getName(), displaySaggitarius.getPrize(), displaySaggitarius.getAttack(), displaySaggitarius.getDefense(), displaySaggitarius.getHealth(), displaySaggitarius.getSpeed()+"\n");

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

                System.out.println("---------------------------------------------");
                System.out.println("Please select the character you want to buy: ");
                System.out.println("---------------------------------------------");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                Character displaySquire = CharacterRegistry.returnCharacter("Squire");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displaySquire.getName(), displaySquire.getPrize(), displaySquire.getAttack(), displaySquire.getDefense(), displaySquire.getHealth(), displaySquire.getSpeed()+"\n");
                Character displayCavalier = CharacterRegistry.returnCharacter("Cavalier");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayCavalier.getName(), displayCavalier.getPrize(), displayCavalier.getAttack(), displayCavalier.getDefense(), displayCavalier.getHealth(), displayCavalier.getSpeed()+"\n");
                Character displayTemplar = CharacterRegistry.returnCharacter("Templar");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayTemplar.getName(), displayTemplar.getPrize(), displayTemplar.getAttack(), displayTemplar.getDefense(), displayTemplar.getHealth(), displayTemplar.getSpeed()+"\n");
                Character displayZoro = CharacterRegistry.returnCharacter("Zoro");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayZoro.getName(), displayZoro.getPrize(), displayZoro.getAttack(), displayZoro.getDefense(), displayZoro.getHealth(), displayZoro.getSpeed()+"\n");
                Character displaySwiftblade = CharacterRegistry.returnCharacter("Swiftblade");
                System.out.format("%20s %20s %20s %20s %20s %20s", "5. "+displaySwiftblade.getName(), displaySwiftblade.getPrize(), displaySwiftblade.getAttack(), displaySwiftblade.getDefense(), displaySwiftblade.getHealth(), displaySwiftblade.getSpeed()+"\n");

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

                System.out.println("---------------------------------------------");
                System.out.println("Please select the character you want to buy: ");
                System.out.println("---------------------------------------------");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                Character displayWarlock = CharacterRegistry.returnCharacter("Warlock");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displayWarlock.getName(), displayWarlock.getPrize(), displayWarlock.getAttack(), displayWarlock.getDefense(), displayWarlock.getHealth(), displayWarlock.getSpeed()+"\n");
                Character displayIllusionist = CharacterRegistry.returnCharacter("Illusionist");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayIllusionist.getName(), displayIllusionist.getPrize(), displayIllusionist.getAttack(), displayIllusionist.getDefense(), displayIllusionist.getHealth(), displayIllusionist.getSpeed()+"\n");
                Character displayEnchanter = CharacterRegistry.returnCharacter("Enchanter");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayEnchanter.getName(), displayEnchanter.getPrize(), displayEnchanter.getAttack(), displayEnchanter.getDefense(), displayEnchanter.getHealth(), displayEnchanter.getSpeed()+"\n");
                Character displayConjurer = CharacterRegistry.returnCharacter("Conjurer");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayConjurer.getName(), displayConjurer.getPrize(), displayConjurer.getAttack(), displayConjurer.getDefense(), displayConjurer.getHealth(), displayConjurer.getSpeed()+"\n");
                Character displayEldritch = CharacterRegistry.returnCharacter("Eldritch");
                System.out.format("%20s %20s %20s %20s %20s %20s", "5. "+displayEldritch.getName(), displayEldritch.getPrize(), displayEldritch.getAttack(), displayEldritch.getDefense(), displayEldritch.getHealth(), displayEldritch.getSpeed()+"\n");

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

                System.out.println("---------------------------------------------");
                System.out.println("Please select the character you want to buy: ");
                System.out.println("---------------------------------------------");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                Character displaySoother = CharacterRegistry.returnCharacter("Soother");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displaySoother.getName(), displaySoother.getPrize(), displaySoother.getAttack(), displaySoother.getDefense(), displaySoother.getHealth(), displaySoother.getSpeed()+"\n");
                Character displayMedic = CharacterRegistry.returnCharacter("Medic");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayMedic.getName(), displayMedic.getPrize(), displayMedic.getAttack(), displayMedic.getDefense(), displayMedic.getHealth(), displayMedic.getSpeed()+"\n");
                Character displayAlchemist = CharacterRegistry.returnCharacter("Alchemist");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayAlchemist.getName(), displayAlchemist.getPrize(), displayAlchemist.getAttack(), displayAlchemist.getDefense(), displayAlchemist.getHealth(), displayAlchemist.getSpeed()+"\n");
                Character displaySaint = CharacterRegistry.returnCharacter("Saint");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displaySaint.getName(), displaySaint.getPrize(), displaySaint.getAttack(), displaySaint.getDefense(), displaySaint.getHealth(), displaySaint.getSpeed()+"\n");
                Character displayLightbringer = CharacterRegistry.returnCharacter("Lightbringer");
                System.out.format("%20s %20s %20s %20s %20s %20s", "5. "+displayLightbringer.getName(), displayLightbringer.getPrize(), displayLightbringer.getAttack(), displayLightbringer.getDefense(), displayLightbringer.getHealth(), displayLightbringer.getSpeed()+"\n");

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

                System.out.println("---------------------------------------------");
                System.out.println("Please select the character you want to buy: ");
                System.out.println("---------------------------------------------");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Character |", "Price (gc) |", "Attack |", "Defence |", "Health |", "Speed |\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                Character displayDragon = CharacterRegistry.returnCharacter("Dragon");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displayDragon.getName(), displayDragon.getPrize(), displayDragon.getAttack(), displayDragon.getDefense(), displayDragon.getHealth(), displayDragon.getSpeed()+"\n");
                Character displayBasilisk = CharacterRegistry.returnCharacter("Basilisk");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayBasilisk.getName(), displayBasilisk.getPrize(), displayBasilisk.getAttack(), displayBasilisk.getDefense(), displayBasilisk.getHealth(), displayBasilisk.getSpeed()+"\n");
                Character displayHydra = CharacterRegistry.returnCharacter("Hydra");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayHydra.getName(), displayHydra.getPrize(), displayHydra.getAttack(), displayHydra.getDefense(), displayHydra.getHealth(), displayHydra.getSpeed()+"\n");
                Character displayPhoenix = CharacterRegistry.returnCharacter("Phoenix");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayPhoenix.getName(), displayPhoenix.getPrize(), displayPhoenix.getAttack(), displayPhoenix.getDefense(), displayPhoenix.getHealth(), displayPhoenix.getSpeed()+"\n");
                Character displayPegasus = CharacterRegistry.returnCharacter("Pegasus");
                System.out.format("%20s %20s %20s %20s %20s %20s", "5. "+displayPegasus.getName(), displayPegasus.getPrize(), displayPegasus.getAttack(), displayPegasus.getDefense(), displayPegasus.getHealth(), displayPegasus.getSpeed()+"\n");

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
        Character character = CharacterRegistry.returnCharacter(boughtCharacter);
        neededGoldCoins = character.getPrize();

        if (existingGoldCoins >= neededGoldCoins) {
            existingGoldCoins -= neededGoldCoins;
            //player.setGold(existingGoldCoins);           
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
        
        int i = 0;
        for (Character character : player.army) {
            System.out.println("      " + i + " " +character.getName());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int characterChoice = scanner.nextInt();

        Character selectedCharacter = player.army.get(characterChoice);
        System.out.println("You have selected " + characterChoice);
        System.out.println("You have selected " + selectedCharacter.getName());
        //scanner.close();
        
        System.out.println("Please select the equipment you want to buy: ");
        System.out.println("---------------------------------------------");
        System.out.println("    1. Armour");
        System.out.println("    2. Artefact");

        int choice = scanner.nextInt();
        //scanner.close();
        System.out.println("You have selected " + choice);

        switch (choice) {
            case 1:
                System.out.println("You have selected to buy armour for " + selectedCharacter.getName());

                //Check whether an armour is equipped by the selectedCharacter.
                for (Equipment equipment : selectedCharacter.getEquipments()) {
                    if (equipment instanceof Armor) {
                        System.out.println("You already have an armour equipped by " + selectedCharacter.getName());
                        return;
                    }
                }

                System.out.println("Please select the armour you want to buy: ");
                System.out.println("-------------------------------------------");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Armour Type", "Price (gc)", "Attack", "Defence", "Health", "Speed\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");

                Armor displayChainmail = EquipmentRegistry.returnEquipment("Chainmail");
                System.out.format("%20s %20s %20s %20s %20s %20s", "01. " + displayChainmail.getName(), displayChainmail.getPrize(), displayChainmail.getAttack(), displayChainmail.getDefense(), displayChainmail.getHealth(), displayChainmail.getSpeed()+"\n");
                Armor displayRegalia = EquipmentRegistry.returnEquipment("Regalia");
                System.out.format("%20s %20s %20s %20s %20s %20s", "02. " + displayRegalia.getName(), displayRegalia.getPrize(), displayRegalia.getAttack(), displayRegalia.getDefense(), displayRegalia.getHealth(), displayRegalia.getSpeed()+"\n");
                Armor displayFleece = EquipmentRegistry.returnEquipment("Fleece");
                System.out.format("%20s %20s %20s %20s %20s %20s", "03. " + displayFleece.getName(), displayFleece.getPrize(), displayFleece.getAttack(), displayFleece.getDefense(), displayFleece.getHealth(), displayFleece.getSpeed()+"\n");

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
                for (Equipment equipment : selectedCharacter.getEquipments()) {
                    if (equipment instanceof Artefacts) {
                        System.out.println("You already have an artefact equipped by " + selectedCharacter.getName());
                        return;
                    }
                }

                System.out.println("Please select the artefact you want to buy: ");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "Artefact Type", "Price (gc)", "Attack", "Defence", "Health", "Speed\n");
                System.out.format("%20s %20s %20s %20s %20s %20s", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------", "--------------------\n");

                Artefacts displayExcalibur= EquipmentRegistry.returnEquipment("Excalibur");
                System.out.format("%20s %20s %20s %20s %20s %20s", "01. " + displayExcalibur.getName(), displayExcalibur.getPrize(), displayExcalibur.getAttack(), displayExcalibur.getDefense(), displayExcalibur.getHealth(), displayExcalibur.getSpeed()+"\n");
                Artefacts displayAmulet = EquipmentRegistry.returnEquipment("Amulet");
                System.out.format("%20s %20s %20s %20s %20s %20s", "02. " + displayAmulet.getName(), displayAmulet.getPrize(), displayAmulet.getAttack(), displayAmulet.getDefense(), displayAmulet.getHealth(), displayAmulet.getSpeed()+"\n");
                Artefacts displayCrystal = EquipmentRegistry.returnEquipment("Crystal");
                System.out.format("%20s %20s %20s %20s %20s %20s", "03. " + displayCrystal.getName(), displayCrystal.getPrize(), displayCrystal.getAttack(), displayCrystal.getDefense(), displayCrystal.getHealth(), displayCrystal.getSpeed()+"\n");

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
        Equipment equipment = EquipmentRegistry.returnEquipment(boughtEquipment);
        neededGoldCoins = equipment.getPrize();

        if (existingGoldCoins >= neededGoldCoins) {
            existingGoldCoins -= neededGoldCoins;

            //set the new gold coins of player
            player.setGold(existingGoldCoins);

            //add the equipment to the character
            selectedCharacter.getEquipments().add(equipment);

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
        System.out.println("You have selected to sell an army.");
    }

    //Displays the equipment that can be sold.
    private void sellEquipment(){
        System.out.println("You have selected to sell equipment.");
    }
}
