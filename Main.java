import Character.Character;
import Equipment.Equipment;

public class Main {
    public static void main(String[] args) {
        Registry.characterCache(); // Making game character configurations
        Registry.equipmentCache(); // Making game equipment configurations

        // We use Registry as a library to store the different configurations
        // of Characters, and we use name to return certain character
        Equipment a = Registry.returnEquipment("Crystal");
        Equipment b = Registry.returnEquipment("Crystal");
        Character c = Registry.returnCharacter("Hydra");

        // Player playerP = new Player();
        // Market market = Market.getInstance();
        // market.marketMenu(playerP, 200);

        System.out.println(a);
        System.out.println(b);

        a.setAttack(0);

        System.out.println(a.getAttack() + " " + b.getAttack());

        System.out.println(c.getName());
    }
}
