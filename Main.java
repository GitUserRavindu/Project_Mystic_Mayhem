import java.util.ArrayList;

import Character.Character;
import Equipment.Equipment;
import HomeGround.HomeGround;

public class Main {
    public static void main(String[] args) {
        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

        // We use Registry as a library to store the different configurations
        // of Characters, and we use name to return certain character
        Character a = Registry.returnCharacter("Ranger");
        Character b = Registry.returnCharacter("Squire");
        Character c = Registry.returnCharacter("Zing");

        Player p = new Player("himala", "Himala");
        p.setHomeGround();

        p.addCharacter(c, 0);
        p.addCharacter(b, 0);
        p.addCharacter(a, 0);

        ArrayList<Character> army = p.getArmy();

        HomeGround hg = p.getHomeGround();

        hg.buff(army);

        for (Character ch : army) {
            ch.displayStats();
            System.out.println("");
        }

        // System.out.println(a);
        // System.out.println(b);

        // a.setAttack(0);

        // System.out.println(a.getAttack() + " " + b.getAttack());

        System.out.println(c.getName());

        // Player playerP = new Player();
        // Market market = Market.getInstance();
        // market.marketMenu(playerP, 800);
    }
}
