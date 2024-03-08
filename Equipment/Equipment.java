package Equipment;

public abstract class Equipment {
    public String name;
    public float health;
    public float attack;
    public float defense;
    public int prize;
    public float speed;

    public void displayStats(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println("Prize: " + prize);
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
