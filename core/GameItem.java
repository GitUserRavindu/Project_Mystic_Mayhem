package core;

public abstract class GameItem {

    // Shared by Characters and Equipment

    protected short price;
    protected float hp, atk;
    protected byte def, spd;
    
    protected GameItem() {       // This constructor is used for every sub-class
        initStats();             // Sets values as defines by each sub-class
    }
    protected abstract void initStats();  // Resets stats of a game item to default values of that item

    // Getters

    public abstract String getCategory();
    public abstract String getName();

    public String getNameAndCategory() {
        return getName() + " [" + getCategory().substring(0,1) + "]";
    }

    public short getPrice() {
        return price;
    }
    public float getHealth() {
        return hp;
    }
    public float getAttack() {
        return atk;
    }
    public byte getDefense() {
        return def;
    }
    public byte getSpeed() {
        return spd;
    }


    // Printers

    public void printInfo() {
        System.out.println("Name    : " + getName());
        System.out.println("Category: " + getCategory());
        System.out.println("Health  : " + getHealth());
        System.out.println("Attack  : " + getAttack());
        System.out.println("Defense : " + getDefense());
        System.out.println("Speed   : " + getSpeed());
        System.out.println("Value   : " + getPrice() + " gc");
    }

    // Setters
    
    public void addStats(double hp, int atk, int def, int spd) {
        hp += (float) hp;
        atk += (float) atk;
        def += (byte) def;
        spd += (byte) spd;
    }

    public void addPrice(int change) {
        price += (short) change;
    }
    public void addHealth(double change) {
        hp += (float) change;
        hp = Math.round(hp * 10.0f) / 10.0f;
        if (hp < 0) hp = 0;
    }
    public void addAttack(double change) {
        atk += (float) change;
    }
    public void addDefense(int change) {
        def += (byte) change;
    }
    public void addSpeed(int change) {
        spd += (byte) change;
    }
    
}