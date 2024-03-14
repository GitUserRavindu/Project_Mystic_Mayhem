package homeground;

import java.util.ArrayList;

import character.Character;

public class Marshland extends HomeGround {

    public Marshland() {
        super("Marshland");;
    }

    public void buff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Marshlander")) {
                c.setDefense(c.getDefense() + 2f);
            } else if (c.getTribe().equals("Highlander")) {
                c.setAttack(c.getAttack() - 1f);
            } else if (c.getTribe().equals("Mystic")) {
                c.setSpeed(c.getSpeed() - 1f);
            }
        }
    }

    public void resetBuff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Marshlander")) {
                c.setDefense(c.getDefense() - 2f);
            } else if (c.getTribe().equals("Highlander")) {
                c.setAttack(c.getAttack() + 1f);
            } else if (c.getTribe().equals("Mystic")) {
                c.setSpeed(c.getSpeed() + 1f);
            }
        }
    }


}