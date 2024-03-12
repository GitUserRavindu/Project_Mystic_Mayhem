package HomeGround;

import Character.Character;
import java.util.ArrayList;

public class Desert extends HomeGround {

    public Desert() {
        super("Desert");
    }

    public void buff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Marshlander")) {
                c.setHealth(c.getHealth() - 1f);
            } else if (c.getTribe().equals("Sunchild")) {
                c.setAttack(c.getAttack() + 1f);
            }
        }
    }

    public void resetBuff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Marshlander")) {
                // c.setHealth(c.getHealth() + 1f);
            } else if (c.getTribe().equals("Sunchild")) {
                c.setAttack(c.getAttack() - 1f);
            }
        }
    }

}