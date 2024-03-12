package Character;

import Equipment.Equipment;
import Interfaces.MakeClone;

public abstract class Character implements MakeClone {
    protected float maxHealth;
    protected String name;
    protected float health;
    protected float attack;
    protected float defense;
    protected float speed;
    protected String tribe;
    protected int prize;
    protected String type;
    protected Equipment[] equipments;
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

    public void displayStats() {
        System.out.println("Name: " + this.name);
        System.out.println("Health: " + this.health);
        System.out.println("Attack: " + this.attack);
        System.out.println("Defense: " + this.defense);
        System.out.println("Speed: " + this.speed);
        System.out.println("Tribe: " + this.tribe);
        System.out.println("Prize: " + this.prize);
        System.out.println("Type: " + this.type);
    }

    // abstract methods
    public abstract Character makeClone();
}