package characters;

public class Mage extends Character {

    public Mage(int tier, String name, int price, int hp, int atk, int def, int spd) {
        super(tier, name, price, hp, atk, def, spd);
    }

    @Override
    public String getCategory () {
        return "Mage";
    }
    
}
