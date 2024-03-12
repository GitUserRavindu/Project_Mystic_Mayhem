package HomeGround;

import Character.Character;
import java.util.ArrayList;

public class Arcane extends HomeGround {

    public Arcane() {
        super("Arcane");
    }

    public void buff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Mystic")) {
                c.setAttack(c.getAttack() + 2f);
            } else if (c.getTribe().equals("Highlander")) {
                c.setSpeed(c.getSpeed() + 1f);
            } else if (c.getTribe().equals("Marshlander")) {
                c.setSpeed(c.getSpeed() - 1f);
                c.setDefense(c.getDefense() - 1f);
            }
        }
    }

    public void resetBuff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Mystic")) {
                c.setAttack(c.getAttack() - 2f);
            } else if (c.getTribe().equals("Highlander")) {
                c.setSpeed(c.getSpeed() - 1f);
            } else if (c.getTribe().equals("Marshlander")) {
                c.setSpeed(c.getSpeed() + 1f);
                c.setDefense(c.getDefense() + 1f);
            }
        }
    }

}