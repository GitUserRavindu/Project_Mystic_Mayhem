package characters;

import java.util.HashMap;
import java.util.Map;

public final class CharacterRegistry {    // Prototype design pattern

    private static Map<String, Character> characters = new HashMap<>();

    private CharacterRegistry() {}  // Cannot be Instantiated

    static {
        // Archers
        addCharacter("Archer", 1, "Shooter", 80, 6, 11, 4, 9);
        addCharacter("Archer", 2, "Ranger", 115, 8, 14, 5, 10);
        addCharacter("Archer", 3, "Sunfire", 160, 7, 15, 5, 14);
        addCharacter("Archer", 4, "Zing", 200, 11, 16, 9, 14);
        addCharacter("Archer", 5, "Saggitarius", 230, 12, 18, 7, 17);
    
        // Knights
        addCharacter("Knight", 1, "Squire", 85, 7, 8, 9, 8);
        addCharacter("Knight", 2, "Cavalier", 110, 7, 10, 12, 10);
        addCharacter("Knight", 3, "Templar", 155, 12, 14, 16, 12);
        addCharacter("Knight", 4, "Zoro", 180, 13, 17, 16, 14);
        addCharacter("Knight", 5, "Swiftblade", 250, 17, 18, 20, 13);
    
        // Mages
        addCharacter("Mage", 1, "Warlock", 100, 10, 12, 7, 12);
        addCharacter("Mage", 2, "Illusionist", 120, 12, 13, 8, 14);
        addCharacter("Mage", 3, "Enchanter", 160, 13, 16, 10, 16);
        addCharacter("Mage", 4, "Conjurer", 195, 14, 18, 15, 12);
        addCharacter("Mage", 5, "Eldritch", 270, 18, 19, 17, 14);
    
        // Healers
        addCharacter("Healer", 1, "Soother", 95, 9, 10, 8, 6);
        addCharacter("Healer", 2, "Medic", 125, 10, 12, 9, 7);
        addCharacter("Healer", 3, "Alchemist", 150, 13, 13, 13, 9);
        addCharacter("Healer", 4, "Saint", 200, 17, 16, 14, 9);
        addCharacter("Healer", 5, "Lightbringer", 260, 19, 17, 15, 12);
    
        // Mythical Creatures
        addCharacter("Mythical Creature", 1, "Dragon", 120, 15, 12, 14, 8);
        addCharacter("Mythical Creature", 2, "Basilisk", 165, 10, 15, 13, 12);
        addCharacter("Mythical Creature", 3, "Hydra", 205, 15, 12, 16, 11);
        addCharacter("Mythical Creature", 4, "Phoenix", 275, 17, 17, 13, 19);
        addCharacter("Mythical Creature", 5, "Pegasus", 340, 20, 14, 18, 20);
    }


    private static void addCharacter(String category, int tier, String name, int price, int hp,  int atk, int def, int spd) {
        switch (category) {
            case "Archer":
                characters.put(category + tier, new Archer(tier, name, price, hp, atk, def, spd));
                break;
            case "Knight":
                characters.put(category + tier, new Knight(tier, name, price, hp, atk, def, spd));
                break;
            case "Healer":
                characters.put(category + tier, new Healer(tier, name, price, hp, atk, def, spd));
                break;
            case "Mage":
                characters.put(category + tier, new Mage(tier, name, price, hp, atk, def, spd));
                break;
            case "Mythical Creature":
                characters.put(category + tier, new MythicalCreature(tier, name, price, hp, atk, def, spd));
                break;
            default:
                throw new IllegalArgumentException("Invalid Category");
        }
    }

    public static Character newCharacter(String category, int tier) {

        Character prototype = characters.get(category + tier);
        return (Character) prototype.clone();

    }

}
