package characters;

import core.GameItem;
import equipment.*;

public abstract class Character extends GameItem implements Cloneable {

    // See category classes (Archer, Healer, ...) for category-specific methods
    // subcategories contain name and base stats for each type of character, no changes outside of this has to be made there

    protected float maxHP;
    protected Armor armor;
    protected Artifact artifact;

    public Character(int tier, String name, int price, int hp, int atk, int def, int spd) {
        super(tier, name, price, hp, atk, def, spd);
        maxHP = hp;
    }
/*
    public Character() {
        super();
        setMaxHP();
    }
*/
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void attack(Character target) {
        double damage = 0.5*getAttack() - 0.1*target.getDefense();
        target.addHealth(-damage);
        System.out.print(getName() + " attacks " + target.getName() + " for " + damage + " damage. " + target.getName() + " " + target.getHealth() + "/" + target.getMaxHP() + " HP.");
        if (!target.isAlive()){
            System.out.println(" " + target.getName() + " dies.");
        } else System.out.println();
    }



    public void giveEquip(Equipment item) {
        switch (item.getCategory()) {
            case "Armor":
                this.armor = (Armor) item;
                break;
            case "Artifact":
                this.artifact = (Artifact) item;
                break;
            default:
                break;
        }
        this.addEquipStats(item);
    }


    private void addEquipStats(Equipment item) {
        if (item==null) {
            return;
        }
        price += item.getPrice()*0.2;
        atk += item.getAttack();
        def += item.getDefense();
        hp += item.getHealth();
        spd += item.getSpeed();
    }

    public Armor getArmor() {
        return armor;
    }

    public Artifact getArtifact() {
        return artifact;
    }


    // HP

    public float getMaxHP() {
        return maxHP;
    }

    public void setMaxHP() {
        maxHP = hp;
    }

    public void addMaxHP(double change) {
        maxHP += (float) change;
        maxHP = Math.round(maxHP * 10.0f) / 10.0f;
        addHealth(change);
    }

    public void maxHPIncrease(double change) {
        addMaxHP(change);
        System.out.println(getName() + " max HP increased by " + Math.round(change*10.0f)/10.0f + ". " + getName() + " " + getHealth() + "/" + getMaxHP() + " HP.");
    }


    public boolean atMaxHP() {
        return hp == maxHP;
    }

    public void addHealth(double change) {
        super.addHealth(change);
        if (hp > maxHP) hp = maxHP;
    }



    // Other getters

    public String getEquipNameString() {
        String string = "";
        if (armor != null) {
            string += "Armor: " + armor.getName() + "  ";
        } else {
            string += "Armor: None  ";
        }
        
        if (artifact != null) {
            string += "Artifact: " + artifact.getName() + "  ";
        } else {
            string += "Artifact: None  ";
        }
        return string;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}