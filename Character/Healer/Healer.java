package Character.Healer;

import Character.Character;

public class Healer extends Character{
    public void setAttributes(){
        this.setType("Healer");
    }
    public void heal(Character character,float damage){
        float addHealth = damage*0.1f;
        if (character.getHealth()+addHealth>character.getMaxHealth()) {
            character.setHealth(character.getMaxHealth());
            return;
        }
        character.setHealth(character.getHealth()+addHealth);
        return;
    }
}