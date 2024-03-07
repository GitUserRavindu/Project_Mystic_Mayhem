import java.util.ArrayList;

import Mystic_mayhem.Character.Archer;

public class Player {
    public ArrayList<Character> army = new ArrayList<Character>();

    public CreateArmy() {
        army.add(new Mage());
        army.add(new Knight());
        army.add(new MythicalCreatures());
        army.add(new Archer());
        army.add(new Healer());
    }
}
