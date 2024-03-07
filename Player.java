import java.util.ArrayList;

import Character.Archer;
import Character.Healer;
import Character.Knight;
import Character.Mage;
import Character.MythicalCreatures;

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
