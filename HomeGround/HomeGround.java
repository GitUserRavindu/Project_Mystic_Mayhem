package HomeGround;

import Character.Character;

import java.io.Serializable;

import java.util.ArrayList;

public class HomeGround implements Serializable {
    public String groundName;

    public HomeGround(String groundName)
    {
        this.groundName = groundName;
    }

    public String getName()
    {
        return this.groundName;
    }

    public void buff(ArrayList<Character> army)
    {
        System.out.println("Buffing the army");

    };
//
    public void resetBuff(ArrayList<Character> army)
    {
        System.out.println("Resetting the buff");
    };
}
