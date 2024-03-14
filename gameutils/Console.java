package gameutils;

import core.Player;

public final class Console {
    
    private Console() {}  // Cannot be Instantiated

    public static void printState(Player player) {
        System.out.println("Selected Player: ");
        printInfo(player);
        Utils.printStrings(new String[]{
            "",
            "Select Action",
            "1: Look for an opponent to battle",
            "2: Purchase character",
            "3: Purchase equipment",
            "4: Sell character",
            "5: Set Home Ground",
            "6: Inspect Army",
            // "7: Help",
            "",
            "0: Change Player"
        });
    }

    public static void printInfo(Player player) {
        Utils.printStrings(new String[]{
            player.getName() + " (" + player.getUsername() + ")",
            "Gold: " + player.getGold(),
            "XP: " + player.getXP(),
            "Army: " + player.getArmyInfo(),
            "Home Ground: " + player.getHomeGroundName(),
        });
    }

    /*
    public static void printState(Player player) {
        System.out.println(
            "Selected Player: " + player.getName() + " (" + player.getUsername() + ")" + "\n" +
            "Coins: " + player.getCoins() + "\n" +
            "XP: 4" + "\n" +
            "Army: Shooter (Archer), Templar (Knight), Saint (Healer)" + "\n" +
            "Home Ground: None"            + "\n\n" +

            "Select Action"                + "\n" +
            "1: Look for an opponent to battle" + "\n" +
            "2: Purchase character"        + "\n" +
            "3: Purchase equipment"        + "\n" +
            "4: Sell character"            + "\n" +
            "5: Set Home Ground"           + "\n" +
            "6: Inspect Army"              + "\n" +
            "7: Help"                      + "\n\n" +

            "0: Change Player"
        );
    }
*/
}
