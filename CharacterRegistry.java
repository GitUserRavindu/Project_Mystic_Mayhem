import java.util.HashMap;

import Character.Archer;
import Character.Character;

public class CharacterRegistry {
    private static HashMap<String, Character> data = new HashMap<>();

    public static void addCharacter(String name, Character character)
    {
        data.put(name, character);
    }

    public static Character returnCharacter(String name)
    {
        return data.get(name).makeClone();
    }

    public static void bundledCache()
    {
        Archer shooter = new Archer();
        shooter.name = "Archer";
        shooter.prize = 100;
        shooter.attack = 11f;
        shooter.defense = 4f;
        shooter.health = 6f;
        shooter.speed = 9f;

        Archer ranger = new Archer();
        ranger.name = "Ranger";
        ranger.prize = 115;
        ranger.attack = 14f;
        ranger.defense = 5f;
        ranger.health = 8f;
        ranger.speed = 10f;

        Archer sunfire = new Archer();
        sunfire.name = "Sunfire";
        sunfire.prize = 160;
        sunfire.attack = 15f;
        sunfire.defense = 5f;
        sunfire.health = 7f;
        sunfire.speed = 14f;

        Archer zing = new Archer();
        zing.name = "Zing";
        zing.prize = 200;
        zing.attack = 16f;
        zing.defense = 9f;
        zing.health = 11f;
        zing.speed = 14f;

        // adding everything to the hashmap
        addCharacter("Zing", zing);
        addCharacter("Sunfire", sunfire);
        addCharacter("Ranger", ranger);
        addCharacter("Archer", shooter);
    }


}
