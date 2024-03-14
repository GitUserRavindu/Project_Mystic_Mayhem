import java.util.ArrayList;
import java.util.HashMap;

import Utils.ScannerUtil;

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
        System.out.println("---> For building your army, Please visit to the market menu in the main menu. \n");
              
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
                    System.out.println("Invalid input. Please enter a valid number.\n");
                }          
            }
        }
    }
    // End of Other Profile Methods ------------------------------------------------------------------------------------

}
