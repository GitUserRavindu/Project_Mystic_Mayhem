package equipment;

import core.GameItem;

public abstract class Equipment extends GameItem {

    public Equipment(int tier, String name, int price, int hp, int atk, int def, int spd) {
        super(tier, name, price, hp, atk, def, spd);
    }
    
}
