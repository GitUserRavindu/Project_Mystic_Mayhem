package equipment;

public class Artifact extends Equipment{

    public Artifact(int tier, String name, int price, int hp, int atk, int def, int spd) {
        super(tier, name, price, hp, atk, def, spd);
    }
    
    @Override
    public String getCategory () {
        return "Artifact";
    }

}