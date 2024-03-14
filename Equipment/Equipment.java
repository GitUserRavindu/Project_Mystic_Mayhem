package equipment;

import java.io.Serializable;

import interfaces.MakeClone;

public abstract class Equipment implements MakeClone, Serializable {
    protected String name;
    protected float health;
    protected float attack;
    protected float defense;
    protected int prize;
    protected float speed;

    public String getName() {
        return name;
    }
    public float getHealth() {
        return health;
    }
    public float getAttack() {
        return attack;
    }
    public float getDefense() {
        return defense;
    }
    public int getPrize() {
        return prize;
    }

    public float getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Equipment()
    {

    }

    public Equipment(Equipment other)
    {
        this.name = other.name;
        this.health = other.health;
        this.attack = other.attack;
        this.defense = other.defense;
        this.prize = other.prize;
        this.speed = other.speed;
    }

    public abstract Equipment makeClone();
}
