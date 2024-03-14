package homeground;

import java.util.ArrayList;

import character.Character;

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
                c.setSpeed(c.getSpeed() - 1f);
            }else if(c.getTribe().equals("Sunchild")){
                c.setSpeed(c.getSpeed() - 1f);}

                
        }
    }

    public void resetBuff(ArrayList<Character> army) {
        for (Character c : army) {
            if (c.getTribe().equals("Highlander")) {
                c.setAttack(c.getAttack() - 1f);
                c.setDefense(c.getDefense() - 1f);
            } else if (c.getTribe().equals("Marshlanders")) {
                c.setSpeed(c.getSpeed() + 1f);
            }else if(c.getTribe().equals("Sunchild")){
                c.setSpeed(c.getSpeed() + 1f);}
        }
    }
}