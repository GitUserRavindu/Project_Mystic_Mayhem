package Utils;

public class MainMenu {
    
    public static void displayGameStart() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("|                  Welcome to the Mystic Mayhem!                   |");
        System.out.println("|  Dive into a realm where legends are born and destinies unfold.  |");
        System.out.println("--------------------------------------------------------------------");
    }
    
    
    public static int displayMainMenu() {
        System.out.println("---------------------------------------");
        System.out.println("|            Main Menu                |");
        System.out.println("---------------------------------------");
        System.out.println("    1. Select a Profile");
        System.out.println("    2. Create a New Profile");
        System.out.println("    3. See your current Profile");
        System.out.println("    4. See your Army Details"); 
        System.out.println("    5. Change your Name");
        System.out.println("    6. Visit Market Place");
        System.out.println("    7. Start a New Battle");
        System.out.println("    8. Quit Game");
        System.out.println("---------------------------------------");
        System.out.println("Enter the number of the option you want to select: \n");
        
        int choice = 0;
        
        while (true) {
            try {
                choice = ScannerUtil.scanner.nextInt();
                if(choice < 1 || choice > 8) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.\n");
            }
        }               
        return choice;
    }

    
    public static void displayGameEnd() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|    Until next time, Noble Adventurer! Your journeys await your return!    |");
        System.out.println("|                   Thank you for playing Mystic Mayhem!                    |");
        System.out.println("-----------------------------------------------------------------------------");
    }

}
