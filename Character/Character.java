package Character;
import Equipment.Equipment;

public abstract class Character {
    public String name;
    public float health;
    public float maxHealth;
    public float attack;
    public float defense;
    public float speed;
    public String tribe;
    public int prize;
    public String type;
    public Equipment[] equipment;
    public Boolean status;

    public void displayStats(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Tribe: " + tribe);
        System.out.println("Prize: " + prize);
        System.out.println("Type: " + type);
    }

    public float getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
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

}
