package core;

import java.util.Collection;
import java.util.HashMap;

import characters.Character;

public class Army implements Cloneable {
    
    private HashMap<String, Character> armyCharacters;

    public Army() {
        armyCharacters = new HashMap<>();
    }

    // Clone the army for fighting, as to not affect the army after battle ends
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Functionalities

    public boolean hasCharacter(String category) {
        if (armyCharacters.containsKey(category)) {
            return true;
        }
        return false;
    }

    public void addCharacter(Character character) {
        armyCharacters.put(character.getCategory(), character);
    }


    // Print Methods

    public void printSimpleInfo() {
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                System.out.println(category + ": " + getCharacterName(category));
            }
        }
    }
    
    public void printInfo() {
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                getCharacter(category).printInfo();
                System.out.println("");
            }
        }
    }

    // Getters

    public Collection<Character> getCharacters() {
        return armyCharacters.values();
    }

    public Character getCharacter(String category) {
        return armyCharacters.get(category);
    }

    public String getCharacterName(String category) {
        return getCharacter(category).getName();
    }

    public String getInfoString() {
        String info = "";
        for (String category : Character.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                info += category + ": " + getCharacterName(category) + "  ";
            }
        }
        return info;
    }

}
