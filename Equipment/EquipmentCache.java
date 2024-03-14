package equipment;

import java.util.HashMap;

public final class EquipmentCache {
    private static final HashMap<String, Equipment> equipment = new HashMap<>();

    // Flyweight design pattern
    // Every character has the same armor / artifact objects

    static {
        // Armor
        addEquipment("Armor", 1, "Chainmail", 70, 0, 0, 1, -1);
        addEquipment("Armor", 2, "Regalia", 105, 0, 0, 1, 0);
        addEquipment("Armor", 3, "Fleece", 150, 1, 0, 2, -1);
    
        // Artifact
        addEquipment("Artifact", 1, "Excalibur", 150, 0, 2, 0, 0);
        addEquipment("Artifact", 2, "Amulet", 200, 1, 1, -1, 1);
        addEquipment("Artifact", 3, "Crystal", 210, -1, 2, 1, -1);
    }
    
    private static void addEquipment(String category, int tier, String name, int price, int hp,  int atk, int def, int spd) {
        switch (category) {
            case "Armor":
                equipment.put(category + tier, new Armor(tier, name, price, hp, atk, def, spd));
                break;
            case "Artifact":
                equipment.put(category + tier, new Artifact(tier, name, price, hp, atk, def, spd));
                break;
            default:
                throw new IllegalArgumentException("Invalid Category");
        }
    }
}
