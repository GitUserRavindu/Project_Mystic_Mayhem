package Character;

import Equipment.Armor;
import Equipment.Artefact;
import Equipment.Equipment;
import Interfaces.MakeClone;
import java.io.Serializable;


public abstract class Character implements MakeClone, Serializable {
    protected float maxHealth;
    protected String name;
    protected float health;
    protected float attack;
    protected float defense;
    protected float speed;
    protected String tribe;
    protected int prize;
    protected String type;
    // index 0 - Armor
    // Index 1 - Artefact
    protected Equipment[] equipments = new Equipment[2];
    protected Boolean status=true;

    // Constructors

    // regular constructor
    public Character() {

    }

    // special constructor for cloning
    public Character(Character other)
    {
        if (other != null)
        {
            this.name = other.name;
            this.prize = other.prize;
            this.attack = other.attack;
            this.defense = other.defense;
            this.health = other.health;
            this.speed = other.speed;
            this.tribe = other.tribe;
            this.type = other.type;
            this.maxHealth = this.health;
        }
    }

    // getters and setters

    public Equipment[] getEquipments() {
        return equipments;
    }

    public void setEquipments(Equipment[] equipments) {
        this.equipments = equipments;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }
    public void setHealth(float health) {
        this.health = health;
    }

    public float getAttack() {
        return attack;
    }
    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getDefense() {
        return defense;
    }
    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setMaxHealth(float addHealth) {
        this.maxHealth = addHealth;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public Equipment[] getEquipment() {
        return equipments;
    }

    public Equipment getArmor() {
        return equipments[0];
    }

    public Equipment getArtefact() {
        return equipments[1];
    }

    public void setArmor(Equipment armor) {
        this.equipments[0] = armor;
    }

    public void setArtefact(Equipment artefact) {
        this.equipments[1] = artefact;
    }

    public void removeEquipment(Equipment equipment){
        this.setAttack(this.getAttack() - equipment.getAttack());
        this.setDefense(this.getDefense() - equipment.getDefense());
        this.setHealth(this.getHealth() - equipment.getHealth());
        this.setSpeed(this.getSpeed() - equipment.getSpeed());
        this.setMaxHealth(this.getMaxHealth() - equipment.getHealth());
    }

    public void displayStats() {
        System.out.println("Name: " + this.getName());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Attack: " + this.getAttack());
        System.out.println("Defense: " + this.getDefense());
        System.out.println("Speed: " + this.getSpeed());
        System.out.println("Tribe: " + this.getTribe());
        System.out.println("Prize: " + this.getPrize());
        System.out.println("Type: " + this.getType());
    }

    // Buying Equipment
    public void equipEquipment(Equipment equipment) {

        Equipment current = null;

        if (equipment instanceof Armor) {
            current = this.getArmor();
            this.setArmor(equipment);

        } else if(equipment instanceof Artefact) {
            current = this.getArtefact();
            this.setArtefact(equipment);
        }

        if (current != null) {
            this.removeEquipment(current);
        }

        setAttack(this.getAttack() + equipment.getAttack());
        setDefense(this.getDefense() + equipment.getDefense());
        setHealth(this.getHealth() + equipment.getHealth());
        setSpeed(this.getSpeed() + equipment.getSpeed());
    }


    // abstract methods
    public abstract Character makeClone();
}