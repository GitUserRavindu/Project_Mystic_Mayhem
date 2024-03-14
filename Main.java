import core.*;

public class Main {
    
    public static void main (String[] args) {

        PlayerManager PM;

        if(SaveGame.checkSave()) {
            PM = SaveGame.loadGame();
        } else {
            PM = PlayerManager.getInstance();
        }


        System.out.println("-------------------------------");
        System.out.println("         Mystic Mayhem!        ");
        System.out.println("-------------------------------");

        Player selectedPlayer = null;

        selectedPlayer = Console.newPlayer(selectedPlayer, PM);

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
                    selectedPlayer = Console.newPlayer(selectedPlayer, PM);
                    break;
            
                default:
                    break;
            }

        } while (choice != 5);

        System.out.println("-------------------------------");
        System.out.println("Leaving Mystic Mayhem! Goodbye!");
        System.out.println("-------------------------------");

        SaveGame.saveGame(PM);
    }
}