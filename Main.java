import core.*;
import core.HomeGrounds.HomeGround;

public class Main {
    @SuppressWarnings("null")
    public static void main (String[] args) {

        PlayerManager PM = PlayerManager.getInstance();

        System.out.println("-------------------------------");
        System.out.println("         Mystic Mayhem!        ");
        System.out.println("-------------------------------");

        Player selectedPlayer = null;

        Console.newPlayer(selectedPlayer, PM);

        int choice;

        do {
            choice = Console.nextAction(selectedPlayer);

            switch (choice) {
                case 1:
                    PM.battleSomeone(selectedPlayer);
                    break;
                case 2:
                    Market.displayMenu(selectedPlayer);
                    break;
                case 3:
                    selectedPlayer.getArmyInfo();
                    break;
                case 4:
                    Console.setHomeGround(selectedPlayer);
                    break;
                case 0:
                    Console.newPlayer(selectedPlayer, PM);
                    break;
            
                default:
                    break;
            }

        } while (choice != 5);

        
        //GameSaveManager gameSaveManager = new GameSaveManager();
        //gameSaveManager.saveGameInsructions();

        System.out.println("-------------------------------");
        System.out.println("Leaving Mystic Mayhem! Goodbye!");
        System.out.println("-------------------------------");



        Player player1 = PM.newPlayer("renfri", "Renfri");
        Player player2 = PM.newPlayer("whitewolf", "Geralt of Rivia");
        // player1.buyCharacter("Archer", 1);
        // player1.battleSomeone();
        player1.buyCharacter("Archer", 4);
        player1.buyCharacter("Healer", 4);
        player1.buyCharacter("Knight", 5);
        player1.buyCharacter("Mythical Creature", 4);

        player2.buyCharacter("Archer", 5);
        player2.buyCharacter("Knight", 5);
        player2.buyCharacter("Mage", 3);

        player1.setHomeGround(HomeGround.HILLCREST);
        player2.setHomeGround(HomeGround.ARCANE);
        System.out.println(Combat.battle(player1, player2));
        //GameItem legolas = CharacterMaker.newCharacter("Archer",1);
        Console.nextAction(player2);
        //legolas.printInfo();
    }
}