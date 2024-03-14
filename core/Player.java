package core;
import java.io.IOException;
import java.util.Scanner;
import java.io.Serializable;

import java.util.ArrayList;

import character.Character;
import homeground.Arcane;
import homeground.Desert;
import homeground.Hillcrest;
import homeground.HomeGround;
import homeground.Marshland;

public class Player implements Serializable {

    Scanner sc = new Scanner(System.in);

    public String name;//Can be change after creation
    public int gold;
    public float xp;
    public String UserName;//Can not be change after creation. Like a email.
    public int UserId = 0; // A unique id for each user. Can be generated using number of users.
    public ArrayList<Character> army = new ArrayList<Character>();


    //HomeGround is a class that contains the home ground of the player.
    //Will the Player can change the home ground after creation?
    public HomeGround homeGround;

    public HomeGround getHomeGround() {
        return homeGround;
    }

    public Player() {
        this.gold = 500;
    }

    //How the shop will work? Is it static?
    //public static Shop shop = new Shop();

    //List of all players. Can be used to check if a username is already taken or not.
    //If the game is off, this must be saved to a file and loaded when the game starts.
    public static ArrayList<String> players = new ArrayList<String>();

    public Player(String name, /* byte[]*/ String UserName)/*throws IOException*/ {

        UserId++;
        gold = 500;
        xp = 0;//Should we inclde a level system? If yes, we can use xp to calculate the level.
        this.setName(name);

        //Check if the username is already taken. While loop will be used to check if the username is already taken.
        //Have to check if this loop is working or not.
        Scanner sc=new Scanner(System.in);
        // InputStreamReader in=new InputStreamReader(System.in);
        // BufferedReader bf=new BufferedReader(in);
        while(players.contains(UserName)) {
            UserName="";
            // Handle the case when the UserName is already taken
            System.out.println("Username is already taken");
            System.out.println("Please enter a new username");
            System.out.print("Username: ");
            try {
                UserName=sc.nextLine();
            } catch (Exception e) {
            } finally {
                sc.close();
            }
        }
        players.add(UserName);
        this.setUserName(UserName);

        //Didn't add for equipments. Will be added later.

    }



    public void setUserName(byte[] userName2) {
        this.UserName = new String(userName2);
    }

    public void addCharacter(Character character, int position) {
        for(Character c:army){
            if(c.getName().equals(character.getName())){
                System.out.println("Character is already in the army");
                return;
            }else if(c.getType().equals(character.getType())){
                System.out.println("Character of this type is already in the army");
                System.out.println("Do you want to sell the character in the position? (Y/N)");
                char check = sc.next().charAt(0);
                if (check == 'Y' || check == 'y') {
                    //army.sell(c);
                    //A selling method will be added later.
                    army.remove(c);
                    army.add(character);
                    return;
                } else {
                return;
            }}}
    this.army.add(character);}

    public String getName() {
        return name;
    }

    public void setHomeGround() {
        System.out.println("Choose a home ground");
        System.out.println("1. Hillcrest");
        System.out.println("2. Marshland");
        System.out.println("3. Desert");
        System.out.println("4. Arcane");
        System.out.println("Enter the number of the home ground: \n");

        //Did not implement for invalid integer input.
        int n=0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                n = scanner.nextInt();
                if(n < 1 || n > 4) {
                    throw new IOException();
                }
                break;
            } catch (IOException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        switch (n) {
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

    // public void setHomeGroundBonus() {
    //     //Set the bonus of the home ground.
    //     //Most of them just increase the stats of the characters.
    //     //But Hillcrest can give highlanders a bonus turn with 20% attack power.
    //     homeGround.setBonus(army,bonusTurns);
    // }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
        players.add(userName);
    }

    public ArrayList<Character> getArmy() {
        return army;
    }

    public void setArmy(ArrayList<Character> army) {
        this.army = army;
    }
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void displayCurrentStatus() {
        System.out.println("Here's your profile status :");
        System.out.println("------------------------------------");
        System.out.println("---------- Profile Status ----------");
        System.out.format("%12s %3s %20s", "UserName", " : " , UserName + "\n");
        System.out.format("%12s %3s %20s", "UserId", " : " , UserId + "\n");
        System.out.format("%12s %3s %20s", "Name", " : " , name + "\n");
        System.out.format("%12s %3s %20s", "GoldCoins", " : " , gold + "\n");
        System.out.format("%12s %3s %20s", "XP", " : " , xp + "\n");
        System.out.format("%12s %3s %20s", "HomeGround", " : " , homeGround + "\n");
        System.out.print("        Army  : ");
        for (Character character : army) {
            System.out.print(character.getName() + ", ");
        }
        System.out.println("\n");
        System.out.println("------ End of Profile Status -------");
        System.out.println("------------------------------------");
    }
}