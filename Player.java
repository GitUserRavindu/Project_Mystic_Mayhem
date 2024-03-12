import java.io.IOException;
import java.util.ArrayList;

import Character.Character;

public class Player {
    public String name;//Can be change after creation
    public int gold;
    public static float xp;
    public String UserName;//Can not be change after creation. Like a email.
    public static int UserId = 0; // A unique id for each user. Can be generated using number of users.
    public ArrayList<Character> army = new ArrayList<Character>();

    
    public static int  turns = 5; // Thinking of implementing with a seperate class
    public static int  bonusTurns = 0;

    //HomeGround is a class that contains the home ground of the player.
    //Will the Player can change the home ground after creation?
    public String homeGround;
    
    public String getHomeGround() {
        return homeGround;
    }

    public Player() {

    }

    //How the shop will work? Is it static?
    public static Shop shop = new Shop();

    //List of all players. Can be used to check if a username is already taken or not.
    //If the game is off, this must be saved to a file and loaded when the game starts.
    public static ArrayList<Player> players = new ArrayList<Player>();

    public Player(String name, byte[] UserName) throws IOException {
        if(UserName == null || name == null|| name.equals("") || name.equals(null)){
            // Handle the case when the UserName or name is null
            System.out.println("Username or name is empty.\n Please enter a valid username and name.");
            return;
        }
        UserId++;
        gold = 500;
        xp = 0;//Should we inclde a level system? If yes, we can use xp to calculate the level.
        this.setName(name);

        //Check if the username is already taken. While loop will be used to check if the username is already taken.
        //Have to check if this loop is working or not.

        /*while(players.contains(UserName)) {
            // Handle the case when the UserName is already taken
            System.out.println("Username is already taken");
            System.out.println("Please enter a new username");
            System.out.println("Username: ");
            try {
                System.in.read(UserName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            setUserName(UserName);
        }*/
        this.setUserName(UserName);

        //Didn't add for equipments. Will be added later.
        while(true){
            Character c;
            //c=shop.buyCharacter();
            //addCharacter(c);
            //System.out.println("Do you want to buy another character? (Y/N)");
            char ch = (char) System.in.read();
            if(ch == 'N' || ch == 'n') {
                break;
            }
        }
    }

    public void setUserName(byte[] userName2) {
        this.UserName = new String(userName2);
    }

    public void addCharacter(Character character,int position) {
        //Lets set a position for each character in the army. 0-5. It will be much easier to manage the army.
        //If the position is already taken, (A archer already taken) that archer will be sold.
        //If the position is empty, the character will be added to the army.
        try {
            if (army.get(position) != null) {
                // Handle the case when the position is already taken
                System.out.println("Position is already taken");
                System.out.println("Do you want to sell the character in the position? (Y/N)");
                char c = (char) System.in.read();
                if(c == 'Y' || c == 'y') {

                    //Add a sell method to the character class
                    //army.get(position).sell();
                    army.set(position, character);
                    return;
                }
                else{return;}
            }
        } catch (Exception e) {
            // Handle the case when the position is empty
            System.out.println("Position is empty");
            army.add(character);
            return;
        }
        //Following must be implemented in the shop class.

        /*if(army.contains(character)) {
            // Handle the case when the character is already in the army
            System.out.println("Character is already in the army");
            return;
        }*/
    }
    public String getName() {
        return name;
    }

    public void setHomeGround() {
        System.out.println("Choose a home ground");
        System.out.println("1. Hillcrest");
        System.out.println("2. Marshland");
        System.out.println("3. Desert");
        System.out.println("4. Arcane\n\n");
        System.out.println("Enter the number of the home ground: ");

        //Did not implement for invalid integer input.
        int n=0;
        while (true) {
            try {
                n = (int) System.in.read();
                break;
            } catch (IOException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

		switch (n) {
            case 1:
                homeGround = "Hillcrest";
                break;
            case 2:
                homeGround = "Marshland";
                break;
            case 3:
                homeGround = "Desert";
                break;
            case 4:
                homeGround = "Arcane";
                break;
            default:
                System.out.println("Invalid input. Please enter a valid number.");
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
    }    

    public ArrayList<Character> getArmy() {
        return army;
    }
    public void setArmy(ArrayList<Character> army) {
        this.army = army;
    }
    
    public static int getUserId() {
        return UserId;
    }
}
