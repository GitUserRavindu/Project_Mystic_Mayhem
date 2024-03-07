import java.util.ArrayList;

import Mystic_mayhem.Character.Archer;
import Mystic_mayhem.Character.Healer;
import Mystic_mayhem.Character.Knight;
import Mystic_mayhem.Character.Mage;
import Mystic_mayhem.Character.MythicalCreatures;

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
