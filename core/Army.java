package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import characters.Character;
import characters.CharacterRegistry;

public class Army implements Cloneable, Serializable {
    
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


    // Setters
    
    public void addCharacter(Character character) {
        armyCharacters.put(character.getCategory(), character);
    }

    
    public void deleteCharacter(String category) {
        armyCharacters.remove(category);
    }



    // Getters

    public ArrayList<Character> getCharacters() {

        ArrayList<Character> characters = new ArrayList<>();
        for (String category : CharacterRegistry.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                characters.add(getCharacter(category));
            }
        }
        return characters;
    }

    public Character getCharacter(String category) {
        return armyCharacters.get(category);
    }

    public String getCharacterbyIndex(int index) {
        int i = 0;
        for (String category : CharacterRegistry.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                ++i;
                if (i == index) {
                    return category;
                }
            }
        }

        return null;
    }

    public String getCharacterName(String category) {
        return getCharacter(category).getName();
    }

    public int getSize() {
        return armyCharacters.size();
    }


    // Print Methods

    public void printSimpleInfo() {
        for (String category : CharacterRegistry.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                System.out.println(category + ": " + getCharacterName(category));
            }
        }
    }
    
    public void printInfo() {
        for (String category : CharacterRegistry.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                getCharacter(category).printInfo();
                System.out.println("");
            }
        }
    }


    public String getInfoString() {
        String info = "";
        for (String category : CharacterRegistry.getCharacterOrder()) {
            if (armyCharacters.containsKey(category)) {
                info += category + ": " + getCharacterName(category) + "  ";
            }
        }
        return info;
    }

}
