import java.util.ArrayList;

import Character.Character;
import Equipment.Equipment;
import HomeGround.HomeGround;
import HomeGround.Arcane;
import HomeGround.Hillcrest;
import HomeGround.Marshland;

public class Main {
    public static void main(String[] args) {
        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

        Market market = Market.getInstance(); // Creating a market

        ArrayList<Character> army1 = new ArrayList<>();
        army1.add(Registry.returnCharacter("Alchemist"));
        army1.add(Registry.returnCharacter("Warlock"));
        army1.add(Registry.returnCharacter("Shooter"));
        army1.add(Registry.returnCharacter("Cavalier"));
        army1.add(Registry.returnCharacter("Phoenix"));

        ArrayList<Character> army2 = new ArrayList<>();
        army2.add(Registry.returnCharacter("Ranger"));
        army2.add(Registry.returnCharacter("Squire"));
        army2.add(Registry.returnCharacter("Basilisk"));
        army2.add(Registry.returnCharacter("Saint"));
        army2.add(Registry.returnCharacter("Enchanter"));

        Player player1 = new Player("himala", "Himala"); // Creating a player
        player1.homeGround = new Hillcrest();// Setting the home ground
        player1.army = army1;

        Player player2 = new Player("yutharsan", "Yutharsan");
        player2.homeGround = new Arcane();
        player2.army = army2;

        Battle new_battle = new Battle(player1, player2);
        new_battle.fight();

    }
}
