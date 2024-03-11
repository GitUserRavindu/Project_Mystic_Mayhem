import java.util.Scanner;

import Character.Character;
import Character.Archer;
import Character.Knight;
import Character.Mage;
import Character.Healer;
import Character.MythicalCreature;

import Equipment.Equipment;

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

                Character displayShooter = Registry.returnCharacter("Shooter");
                System.out.format("%18s %18s %18s %18s %18s %18s", "1. "+displayShooter.getName(), displayShooter.getPrize(), displayShooter.getAttack(), displayShooter.getDefense(), displayShooter.getHealth(), displayShooter.getSpeed()+"\n");
                Character dispalyRanger = Registry.returnCharacter("Ranger");
                System.out.format("%18s %18s %18s %18s %18s %18s", "2. "+dispalyRanger.getName(), dispalyRanger.getPrize(), dispalyRanger.getAttack(), dispalyRanger.getDefense(), dispalyRanger.getHealth(), dispalyRanger.getSpeed()+"\n");
                Character displaySunfire = Registry.returnCharacter("Sunfire");
                System.out.format("%18s %18s %18s %18s %18s %18s", "3. "+displaySunfire.getName(), displaySunfire.getPrize(), displaySunfire.getAttack(), displaySunfire.getDefense(), displaySunfire.getHealth(), displaySunfire.getSpeed()+"\n");
                Character displayZing = Registry.returnCharacter("Zing");
                System.out.format("%18s %18s %18s %18s %18s %18s", "4. "+displayZing.getName(), displayZing.getPrize(), displayZing.getAttack(), displayZing.getDefense(), displayZing.getHealth(), displayZing.getSpeed()+"\n");
                Character displaySaggitarius = Registry.returnCharacter("Saggitarius");
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
                Character displaySquire = Registry.returnCharacter("Squire");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displaySquire.getName(), displaySquire.getPrize(), displaySquire.getAttack(), displaySquire.getDefense(), displaySquire.getHealth(), displaySquire.getSpeed()+"\n");
                Character displayCavalier = Registry.returnCharacter("Cavalier");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayCavalier.getName(), displayCavalier.getPrize(), displayCavalier.getAttack(), displayCavalier.getDefense(), displayCavalier.getHealth(), displayCavalier.getSpeed()+"\n");
                Character displayTemplar = Registry.returnCharacter("Templar");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayTemplar.getName(), displayTemplar.getPrize(), displayTemplar.getAttack(), displayTemplar.getDefense(), displayTemplar.getHealth(), displayTemplar.getSpeed()+"\n");
                Character displayZoro = Registry.returnCharacter("Zoro");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayZoro.getName(), displayZoro.getPrize(), displayZoro.getAttack(), displayZoro.getDefense(), displayZoro.getHealth(), displayZoro.getSpeed()+"\n");
                Character displaySwiftblade = Registry.returnCharacter("Swiftblade");
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
                Character displayWarlock = Registry.returnCharacter("Warlock");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displayWarlock.getName(), displayWarlock.getPrize(), displayWarlock.getAttack(), displayWarlock.getDefense(), displayWarlock.getHealth(), displayWarlock.getSpeed()+"\n");
                Character displayIllusionist = Registry.returnCharacter("Illusionist");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayIllusionist.getName(), displayIllusionist.getPrize(), displayIllusionist.getAttack(), displayIllusionist.getDefense(), displayIllusionist.getHealth(), displayIllusionist.getSpeed()+"\n");
                Character displayEnchanter = Registry.returnCharacter("Enchanter");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayEnchanter.getName(), displayEnchanter.getPrize(), displayEnchanter.getAttack(), displayEnchanter.getDefense(), displayEnchanter.getHealth(), displayEnchanter.getSpeed()+"\n");
                Character displayConjurer = Registry.returnCharacter("Conjurer");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayConjurer.getName(), displayConjurer.getPrize(), displayConjurer.getAttack(), displayConjurer.getDefense(), displayConjurer.getHealth(), displayConjurer.getSpeed()+"\n");
                Character displayEldritch = Registry.returnCharacter("Eldritch");
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
                Character displaySoother = Registry.returnCharacter("Soother");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displaySoother.getName(), displaySoother.getPrize(), displaySoother.getAttack(), displaySoother.getDefense(), displaySoother.getHealth(), displaySoother.getSpeed()+"\n");
                Character displayMedic = Registry.returnCharacter("Medic");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayMedic.getName(), displayMedic.getPrize(), displayMedic.getAttack(), displayMedic.getDefense(), displayMedic.getHealth(), displayMedic.getSpeed()+"\n");
                Character displayAlchemist = Registry.returnCharacter("Alchemist");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayAlchemist.getName(), displayAlchemist.getPrize(), displayAlchemist.getAttack(), displayAlchemist.getDefense(), displayAlchemist.getHealth(), displayAlchemist.getSpeed()+"\n");
                Character displaySaint = Registry.returnCharacter("Saint");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displaySaint.getName(), displaySaint.getPrize(), displaySaint.getAttack(), displaySaint.getDefense(), displaySaint.getHealth(), displaySaint.getSpeed()+"\n");
                Character displayLightbringer = Registry.returnCharacter("Lightbringer");
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
                Character displayDragon = Registry.returnCharacter("Dragon");
                System.out.format("%20s %20s %20s %20s %20s %20s", "1. "+displayDragon.getName(), displayDragon.getPrize(), displayDragon.getAttack(), displayDragon.getDefense(), displayDragon.getHealth(), displayDragon.getSpeed()+"\n");
                Character displayBasilisk = Registry.returnCharacter("Basilisk");
                System.out.format("%20s %20s %20s %20s %20s %20s", "2. "+displayBasilisk.getName(), displayBasilisk.getPrize(), displayBasilisk.getAttack(), displayBasilisk.getDefense(), displayBasilisk.getHealth(), displayBasilisk.getSpeed()+"\n");
                Character displayHydra = Registry.returnCharacter("Hydra");
                System.out.format("%20s %20s %20s %20s %20s %20s", "3. "+displayHydra.getName(), displayHydra.getPrize(), displayHydra.getAttack(), displayHydra.getDefense(), displayHydra.getHealth(), displayHydra.getSpeed()+"\n");
                Character displayPhoenix = Registry.returnCharacter("Phoenix");
                System.out.format("%20s %20s %20s %20s %20s %20s", "4. "+displayPhoenix.getName(), displayPhoenix.getPrize(), displayPhoenix.getAttack(), displayPhoenix.getDefense(), displayPhoenix.getHealth(), displayPhoenix.getSpeed()+"\n");
                Character displayPegasus = Registry.returnCharacter("Pegasus");
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

    //Performs the transaction of buying a character.
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
        System.out.println("You have selected to buy equipment.");
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
