package Mystic_mayhem.Equipment;

public abstract class Equipment {
    public String name;
    public float health;
    public float attack;
    public float defense;
    public int prize;
    public float speed;
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

}
