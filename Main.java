import java.util.ArrayList;

import Character.Character;
import Equipment.Equipment;
import HomeGround.HomeGround;
import HomeGround.Hillcrest;
import HomeGround.Marshland;

public class Main {
    public static void main(String[] args) {
        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

        Market market = Market.getInstance(); // Creating a market

        ArrayList<Character> army1 = new ArrayList<>();
        army1.add(Registry.returnCharacter("Shooter"));
        army1.add(Registry.returnCharacter("Warlock"));

        ArrayList<Character> army2 = new ArrayList<>();
        army2.add(Registry.returnCharacter("Ranger"));
        army2.add(Registry.returnCharacter("Squire"));


        Player player1 = new Player("himala", "Himala"); // Creating a player
        player1.homeGround = new Hillcrest();// Setting the home ground
        player1.army = army1;

        Player player2 = new Player("yutharsan", "Yutharsan");
        player2.homeGround = new Marshland();
        player2.army = army2;

        Battle new_battle = new Battle(player1, player2);
        new_battle.fight();

    }
}
