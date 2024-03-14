package core;

import core.HomeGrounds.HomeGround;
import gameutils.Utils;

public final class Console {
    
    private Console() {}  // Cannot be Instantiated


    // For General Use

    public static Player newPlayer(Player player, PlayerManager PM) {
        do {
            System.out.println("Select Action");
            System.out.println("1: New Player");
            System.out.println("2: Log in");
            int choice = Utils.readInt(">>>",1,2);
            switch (choice) {
                case 1:
                    player = PM.newPlayer(); // Returns null if exited
                    break;
                case 2:
                    player = PM.getPlayer(); // Returns null if exited
                    break;        
                default:
                    break;
            }
        } while (player == null);

        return player;
    }

    public static int nextAction(Player player) {
        System.out.println("Selected Player: ");
        printInfoExtended(player);
        System.out.println();
        System.out.println("Select Action");
        System.out.println("1: Look for an opponent to battle");
        System.out.println("2: Enter Marketplace");
        System.out.println("3: Inspect Army");
        System.out.println("4: Change Home Ground");
        System.out.println("5: Exit Game");
        //System.out.println("7: Help");
        System.out.println();
        System.out.println("0: Change Player");
        return Utils.readInt(">>>",0,5);
    }

    public static void printInfo(Player player) {
        System.out.println(player.getName() + " (" + player.getUsername() + ")");
        System.out.println("XP: " + player.getXP());
        System.out.println("Army: " + player.getArmyInfo());
    }

    public static void printInfoExtended(Player player) {
        printInfo(player);
        System.out.println("Gold: " + player.getGold());
        System.out.println("Home Ground: " + player.getHomeGroundName());
    }

    public static void inspectArmy(Player player) {
        player.printArmyInfo();
    }

    public static void setHomeGround(Player player) {
        System.out.println("Select Homeground");

        System.out.println("1: Hillcrest");
        System.out.print("   Highlanders:");
        HomeGrounds.printHomeGroundCharacters(HomeGround.HILLCREST);

        System.out.println("2: Marshland");
        System.out.print("   Marshlanders:");
        HomeGrounds.printHomeGroundCharacters(HomeGround.MARSHLAND);

        System.out.println("3: Desert");
        System.out.print("   Sunchildren:");
        HomeGrounds.printHomeGroundCharacters(HomeGround.DESERT);

        System.out.println("4: Arcane");
        System.out.print("   Mystics:");
        HomeGrounds.printHomeGroundCharacters(HomeGround.ARCANE);


        System.out.println("5: Exit");

        int choice = Utils.readInt(">>>",1,5);

        switch (choice) {
            case 1:
                player.setHomeGround(HomeGround.HILLCREST);
                break;
            case 2:
                player.setHomeGround(HomeGround.MARSHLAND);
                break;
            case 3:
                player.setHomeGround(HomeGround.DESERT);
                break;
            case 4:
                player.setHomeGround(HomeGround.ARCANE);
                break;        
            default:
                break;
        }
    
    }

}
