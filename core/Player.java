package core;

import java.io.Serializable;

import characters.Character;
import characters.CharacterRegistry;
import core.HomeGrounds.HomeGround;

public class Player implements Serializable {
    private final String username;
    private String name;
    private float gold;
    private byte XP;
    private Army army;
    private HomeGround homeGround;

    protected Player (String username, String name) {
        this.username = username;
        this.name = name;
        gold = 5000;   // Change this back
        XP = 0;
        army = new Army();
    }


    // Getters

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public float getGold() {
        return gold;
    }
    public byte getXP() {
        return XP;
    }
    public Army getArmy() {
        return army;
    }
    public HomeGround getHomeGround() {
        return homeGround;
    }
    public String getHomeGroundName() {
        if (homeGround == null) {
            return "None";
        }
        return homeGround.getName();
    }

    public Army cloneArmy() {
        return (Army) army.clone();
    }


    public void battleSomeone() {
        PlayerManager.getInstance().battleSomeone(this);
    }

    public void setHomeGround(HomeGround homeGround) {
        this.homeGround = homeGround;
    }

    public void buyCharacter(String category, int tier) {
        // Check if player already has someone of the category
        if (army.hasCharacter(category)) {
            System.out.println("You already have a " + category + " (" + army.getCharacterName(category) + ") in your army");
            return;
        }

        Character character = CharacterRegistry.newCharacter(category, tier);

        // Check if player has enough gold
        if (character.getPrice() > gold) {
            System.out.println("You don't have enough Gold");
            return;
        }
        // Remove gold and add character to army
        army.addCharacter(character);
        addGold(-character.getPrice());
    }

    public void printArmySimpleInfo() {
        army.printSimpleInfo();
    }
    public void printArmyInfo() {
        army.printInfo();
    }

    public String getArmyInfo() {
        return army.getInfoString();
    }

    public void addGold (float amount) {
        gold += amount;
    }


/*
    public boolean addCharacter(Character character) {
        if (army.containsKey(character.getCategory())) {
            System.out.println("You already have " + character.getCategory() + " " + character.getName() + " in your Army");
            return false; // Indicate failure
        } else {
            army.put(character.getCategory(), character);
            return true; // Indicate success
        }
    }
    
    public void buyCharacter(String category, String name) {

    }
*/

}