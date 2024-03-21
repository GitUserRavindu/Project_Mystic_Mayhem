package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Utils.ScannerUtil;

import Character.Character;

public class Profile {

    // Profile attributes ----------------------------------------------------------------------------------------------
    private static int profileCount = 0; // how many profiles have been created
    private static ArrayList<String> userNameList = new ArrayList<String>();
    private static HashMap<Integer, Player> playerMap = new HashMap<Integer, Player>(); // map of userIds to profiles.should it be public?
    // End of Profile Attributes ---------------------------------------------------------------------------------------


    // Profile Getters -------------------------------------------------------------------------------------------------
    public static int getProfileCount() { return profileCount; }
    public static ArrayList<String> getUserNameList() { return userNameList; } //This will not be used in the game.
    public static HashMap<Integer, Player> getPlayerMap() { return playerMap; }
    // End of Profile Getters ------------------------------------------------------------------------------------------


    // Need setters for saving and loading purposes.
    // Profile Setters -------------------------------------------------------------------------------------------------
    public static void setProfileCount(int profileCount) { Profile.profileCount = profileCount; }
    public static void setUserNameList(ArrayList<String> userNameList) { Profile.userNameList = userNameList; }
    public static void setPlayerMap(HashMap<Integer, Player> playerMap) { Profile.playerMap = playerMap; }
    // End of Profile Setters ------------------------------------------------------------------------------------------


    // Other Profile Methods -------------------------------------------------------------------------------------------
    public static Player createProfile() {
        System.out.println("---------------------------");
        System.out.println("Let's create your profile! ");
        System.out.println("---------------------------");
        System.out.println("    1. Wish to continue?");
        System.out.println("    2. Go back");
        System.out.println("Please enter the corresponding option : (1/2)\n");

        int choice = ScannerUtil.scanner.nextInt();

        if (choice != 1) {
            System.out.println("Profile is not created. Going back...\n");
            return null;
        }

        Player player = new Player();

        System.out.println("--------------------------------------------");
        System.out.println("Please enter the required details carefully?");
        System.out.println("--------------------------------------------");

        // Player name
        System.out.println("---> Please Enter a name : \n");


        // ScannerUtil.scanner.nextLine(); // This is because we previously used nextInt() and it left a newline character in the buffer.
        String name = ScannerUtil.scanner.nextLine();

        while (name.length() == 0) {
            name = ScannerUtil.scanner.nextLine();
        }

        player.setName(name);
        System.out.println("Your name has been set to : " + player.getName() + "\n");

        // Player Gold
        player.setGold(500);

        // Player XP
        player.setXp(1f);

        // Player userId
        player.setUserId(profileCount); //Zero based

        // Player userName
        System.out.println("---> Please Enter a Username (This has to be unique) : \n");

        String userName = ScannerUtil.scanner.nextLine();
        while (userNameList.contains(userName)) {
            System.out.println("---> Username already exists. Please enter a different username : \n");
            userName = ScannerUtil.scanner.nextLine();
        }
        player.setUserName(userName);
        userNameList.add(userName);
        System.out.println("Your username has been set to : " + player.getUserName() + "\n");

        // Player Homeground
        System.out.println("---> Please Enter a HomeGround : \n");
        player.setHomeGround();
        System.out.println("Your homeground has been set to : " + player.getHomeGround().getName() + "\n");


        // Player String HomeGroundName
        player.setHomeGroundName(player.getHomeGround().getName());

        // Player Army
        System.out.println("---> Please build your army\n");
        System.out.println("You have 500 gold coins to spend on your army.");
        System.out.println("Your army should consist of at least one character from each of the following categories:");
        System.out.println("    1. Archer");
        System.out.println("    2. Knight");
        System.out.println("    3. Mage");
        System.out.println("    4. Healer");
        System.out.println("    5. Mythical Creature\n");
        System.out.println("Since this is your first time in building an army, we encourage you to buy");
        System.out.println("the following 5 characters that represent each category.");
        System.out.println("    1. Shooter  - 80 gold coins");
        System.out.println("    2. Squire   - 85 gold coins");
        System.out.println("    3. Warlock  - 100 gold coins");
        System.out.println("    4. Soother  - 95 gold coins");
        System.out.println("    5. Dragon   - 120 gold coins");
        System.out.println("As you win more battles, you can earn more gold coins and buy more characters.\n");
        System.out.println("Proceed to buy the recommended characters? (y/n)\n");

        String proceed = ScannerUtil.scanner.nextLine();

        while (proceed.length() == 0) {
            proceed = ScannerUtil.scanner.nextLine();
        }

        if (proceed.equals("y")) {
            Character character = Registry.returnCharacter("Shooter");
            player.army.add(character);
            character = Registry.returnCharacter("Squire");
            player.army.add(character);
            character = Registry.returnCharacter("Warlock");
            player.army.add(character);
            character = Registry.returnCharacter("Soother");
            player.army.add(character);
            character = Registry.returnCharacter("Dragon");
            player.army.add(character);
            player.setGold(player.getGold() - 480);

            System.out.println("You have successfully bought the recommended characters.");
            System.out.println("Your available gold coins : " + player.getGold() + "\n");
        }
        else {
            System.out.println("You have chosen to skip buying the recommended characters.");
            System.out.println("You will not be able to battle without a complete army."); 
            System.out.println("No worries, you can buy characters from the market place later.\n");
            System.out.println("Your available gold coins : " + player.getGold() + "\n");
        }

        // Add to playerMap
        playerMap.put(player.getUserId(), player);

        // Profile Created Successfully
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(player.getName() + ", your user Profile has been created successfully!");
        System.out.println("---------------------------------------------------------------------------------");

        // Displaying the current status of the player
        player.displayCurrentStatus();

        System.out.println("Going back to Main Menu...\n");

        // Update profile count
        profileCount++;

        return player;
    }

    public static void changeName(Player player) { // User can change name whenever they want
        System.out.println("You have selected to change your name.");
        System.out.println("Your current name is : " + player.getName() + "\n");
        System.out.println("Please enter the new name : ");

        String newName = ScannerUtil.scanner.nextLine();

        while (newName.length() == 0) {
            newName = ScannerUtil.scanner.nextLine();
        }

        player.setName(newName);
        System.out.println("Name has been changed to : " + player.getName() + "\n");
        player.displayCurrentStatus();

        System.out.println("Going back to Main Menu...\n");

    }

    public static Player selectProfile() {
        System.out.println("-------------------------------");
        System.out.println("Select a profile to play with: ");
        System.out.println("-------------------------------\n");

        if (playerMap.size() == 0) {
            System.out.println("Sorry, No profiles found. Please create a new profile.\n");
            return null;
        }
        else {
            for (Integer key : playerMap.keySet()) {
                System.out.println("  " + key + ". " + playerMap.get(key).getName());
            }
            System.out.println("Enter the number of the profile you want to select: \n");

            while (true) {
                try {
                    int playerChoice = ScannerUtil.scanner.nextInt();
                    Player player = playerMap.get(playerChoice);
                    return player;
                } catch (Exception e) {
                    ScannerUtil.scanner.nextLine();
                    System.out.println("Invalid input. Please enter a valid number.\n");
                }
            }
        }
    }

    public static Player selectOpponent (Player currentPlayer) {
        System.out.println("-------------------------------");
        System.out.println("Select an opponent to Battle : ");
        System.out.println("-------------------------------\n");

        if (playerMap.size() == 0 || playerMap.size() == 1) {
            System.out.println("Sorry, No opponents found. Please create a new profile.\n");
            return null;
        }
        else {
            ArrayList<Player> opponentList = new ArrayList<Player>(playerMap.values());
            Random random = new Random();

            while (true) {
                int randomIndex = random.nextInt(opponentList.size());
                Player randomOpponent = opponentList.get(randomIndex);

                if (randomOpponent.getUserId() != currentPlayer.getUserId()) {
                    System.out.println("Random opponent selected");
                    System.out.println("------------------------");
                    System.out.println("    Opponent        : " + randomOpponent.getName());
                    System.out.println("    Opponent's XP   : " + randomOpponent.getXp() + "\n");
                    System.out.println("What do you want to do?");
                    System.out.println("    1. Challenge this opponent");
                    System.out.println("    2. Skip to another opponent");
                    System.out.println("    3. Go back");
                    System.out.println("Please enter the corresponding option : (1/2/3)\n");

                    int choice = 0;

                    while (true) {
                        try {
                            choice = ScannerUtil.scanner.nextInt();
                            if (choice < 1 || choice > 3) {
                                throw new Exception();
                            }
                            break;
                        } catch (Exception e) {
                            ScannerUtil.scanner.nextLine();
                            System.out.println("Invalid input. Please enter a valid number.\n");
                        }
                    }

                    if (choice == 1) { return randomOpponent; }
                    else if (choice == 2) { continue; }
                    else { return null; }
                }
                else {
                    continue;
                }
            }
        }
    }
    // End of Other Profile Methods ------------------------------------------------------------------------------------
}