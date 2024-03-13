package HomeGround;

import Character.Character;
import java.util.ArrayList;

public class HomeGround {
    public String ground_name;

    public HomeGround(String ground_name)
    {
        this.ground_name = ground_name;
    }

    public String getName()
    {
        return this.ground_name;
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
