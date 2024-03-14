package core;

import java.io.Serializable;

import characters.Character;
import core.HomeGrounds.HomeGround;

public class Player implements Serializable {
    private final String username;
    private String name;
    private float gold;
    private short XP;
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
    public short getXP() {
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


    // Setters
    
    public void addGold (double change) {
        gold += (float) change;
        gold = Math.round(gold * 10.0f) / 10.0f;
    }

    public void setHomeGround(HomeGround homeGround) {
        this.homeGround = homeGround;
    }

    public void addXP(int change) {
        XP += (short) change;
    }

    /*
    public boolean buyCharacter(String category, int tier) {

        Character character = CharacterRegistry.newCharacter(category, tier);

        if (character.getPrice() > gold) {
            return false;
        }

        // Remove gold and add character to army
        army.addCharacter(character);
        addGold(-character.getPrice());
        return true;
    }
    */

    public void sellCharacter(String category) {
        Character character = army.getCharacter(category);
        addGold(character.getPrice()*0.9f);
        army.deleteCharacter(category);
    }

    public boolean buyCharacter(Character character) {

        if (character.getPrice() > gold) {
            return false;
        }

        // Remove gold and add character to army
        army.addCharacter(character);
        addGold(-character.getPrice());
        return true;
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

    public boolean battleCompatible() {
        return (army.getSize() == 5);
    }


}