import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Profile {
    private static int profileCount = 0; // how many profiles have been created
    private static ArrayList<String> userNameList = new ArrayList<String>(); // list of usernames
    private static HashMap<Integer, Player> playerMap = new HashMap<Integer, Player>(); // map of userIds to profiles

    public static int getProfileCount() {
        return profileCount;
    }
    
    public static Player createProfile() {
        System.out.println("---------------------------");
        System.out.println("Let's create your profile! ");
        System.out.println("---------------------------");
        System.out.println("    1. Wish to continue?");
        System.out.println("    2. Go back");
        System.out.println("Please enter the corresponding option : (1/2)\n");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice != 1) {
            System.out.println("Profile is not created. Going back...\n");
            //scanner.close();
            return null;
        }

        Player player = new Player();

        System.out.println("--------------------------------------------");
        System.out.println("Please enter the required details carefully?");
        System.out.println("--------------------------------------------");

        //Player name
        System.out.println("---> Please Enter a name : \n");
        scanner.nextLine();
        String name = scanner.nextLine();
        player.setName(name);
        System.out.println("Your name has been set to : " + player.getName() + "\n");

        //Player Gold
        player.setGold(500);

        //Player XP
        player.setXp(1f);

        //Player userId
        player.setUserId(profileCount); //Zero based
        
        //Player userName
        System.out.println("---> Please Enter a Username (This has to be unique) : \n");
        //scanner.nextLine();
        String userName = scanner.nextLine();
        while (userNameList.contains(userName)) {
            System.out.println("---> Username already exists. Please enter a different username : \n");
            //scanner.nextLine();
            userName = scanner.nextLine();
        }
        player.setUserName(userName);
        userNameList.add(userName);
        System.out.println("Your username has been set to : " + player.getUserName() + "\n");

        //Player Homeground
        System.out.println("---> Please Enter a HomeGround : \n");
        player.setHomeGround();
        //System.out.println();
        System.out.println("Your homeground has been set to : " + player.getHomeGround() + "\n");

        //Player Army
        System.out.println("---> For building your army, Please visit to the market menu in the main menu. \n");
              
        //Add to playerMap
        playerMap.put(player.getUserId(), player);

        //Profile Created Successfully
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(player.getName() + ", your user Profile has been created successfully!");
        System.out.println("---------------------------------------------------------------------------------");

        player.displayCurrentStatus();

        System.out.println("Going back to Main Menu...\n");
        //scanner.close();

        //update profile count
        profileCount++;

        return player;
    }

    public static void changeName(Player player) {
        System.out.println("You have selected to change your name.");
        System.out.println("Your current name is : " + player.getName() + "\n");
        System.out.println("Please enter the new name : ");
        
        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();
        String newName = scanner.nextLine();

        player.setName(newName);
        System.out.println("Name has been changed to : " + player.getName() + "\n");
        player.displayCurrentStatus();

        System.out.println("Going back to Main Menu...\n");
        //scanner.close();
    }

}
