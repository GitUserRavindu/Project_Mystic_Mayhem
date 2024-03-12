package HomeGround;

import Character.Character;
import java.util.ArrayList;

public class Hillcrest extends HomeGround {

    public Hillcrest() {
        super("Hillcrest");
    }

    public void buff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Highlander")) {
                c.setAttack(c.getAttack() + 1f);
                c.setDefense(c.getDefense() + 1f);
            } else if (c.getTribe().equals("Marshlanders")) {
                c.setAttack(c.getSpeed() - 1f);
            }
        }
    }

    public void resetBuff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Highlander")) {
                c.setAttack(c.getAttack() - 1f);
                c.setDefense(c.getDefense() - 1f);
            } else if (c.getTribe().equals("Marshlanders")) {
                c.setAttack(c.getSpeed() + 1f);
            }
        }
    }
}