import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;

import Utils.ScannerUtil;

import Character.Character;

import HomeGround.HomeGround;
import HomeGround.Arcane;
import HomeGround.Desert;
import HomeGround.Hillcrest;
import HomeGround.Marshland;

public class Player implements Serializable {

    // Player attributes ------------------------------------------------------------------------------    
    private String name;//Can be change after creation
    private String userName;//Can not be change after creation. Unique for each user.
    private int userId; // A unique id for each user. Can be generated using number of users.
    private int goldCoins;
    private float xp;
    private HomeGround homeGround; //HomeGround is a class that contains the home ground of the player.
    public ArrayList<Character> army = new ArrayList<Character>(); //////!!!!!Public, Check with market    
    // End of Player Attributes -----------------------------------------------------------------------   
    
    
    // Constructor ------------------------------------------------------------------------------------
    public Player() {}
    // End of Constructor -----------------------------------------------------------------------------
    
    
    // Getters ----------------------------------------------------------------------------------------
    public String getName() { return name;}

    public String getUserName() { return userName; }

    public int getUserId() { return userId; }
    
    public int getGold() { return goldCoins; }
        
    public float getXp() { return xp; }
    
    public HomeGround getHomeGround() { return homeGround; }
  
    public ArrayList<Character> getArmy() { return army; }
    // End of Getters ---------------------------------------------------------------------------------
    
    
    // Setters ----------------------------------------------------------------------------------------
    public void setName(String name) { this.name = name; }
    
    public void setUserName(String userName) { this.userName = userName; }
    
    public void setUserId(int userId) { this.userId = userId; }

    public void setGold(int goldCoins) { this.goldCoins = goldCoins; }

    public void setXp(float xp) { this.xp = xp; }

    public void setHomeGround() {
        System.out.println("Choose a home ground");
        System.out.println("1. Hillcrest");
        System.out.println("2. Marshland");
        System.out.println("3. Desert");
        System.out.println("4. Arcane");
        System.out.println("Enter the number of the home ground: \n");


        int choice;

        while (true) {
            try {
                choice = ScannerUtil.scanner.nextInt();
                if(choice < 1 || choice > 4) {
                    throw new IOException();
                }
                break;
            } catch (IOException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }


		switch (choice) {
            case 1:
                homeGround = new Hillcrest();
                break;
            case 2:
                homeGround = new Marshland();
                break;
            case 3:
                homeGround = new Desert();
                break;
            case 4:
                homeGround = new Arcane();
                break;
            default:
                System.out.println("Invalid input. Please enter a valid number."); //This will never be executed. I guess
        }
    }
    
    //Since army attribute is public, this method is not necessary. 
    //In the market, the characters are added to the army directly.
    public void setArmy(ArrayList<Character> army) { this.army = army; }   
    // End of Setters ---------------------------------------------------------------------------------

    
    // Other Methods ----------------------------------------------------------------------------------
    public void displayCurrentStatus() {
        System.out.println("Here's your profile status :");
        System.out.println("------------------------------------");
        System.out.println("---------- Profile Status ----------");
        System.out.format("%12s %3s %20s", "UserName", " : " , userName + "\n");
        System.out.format("%12s %3s %20s", "UserId", " : " , userId + "\n");
        System.out.format("%12s %3s %20s", "Name", " : " , name + "\n");
        System.out.format("%12s %3s %20s", "GoldCoins", " : " , goldCoins + "\n");
        System.out.format("%12s %3s %20s", "XP", " : " , xp + "\n");
        System.out.format("%12s %3s %20s", "HomeGround", " : " , homeGround.getName() + "\n");
        System.out.print("        Army  : ");
        for (Character character : army) {
            System.out.print(character.getName() + ", ");
        }
        System.out.println("\n");
        System.out.println("------ End of Profile Status -------");
        System.out.println("------------------------------------");
    }
    // End of Other Methods ---------------------------------------------------------------------------
}
