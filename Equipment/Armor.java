package Equipment;

public class Armor extends Equipment {
    public void Chainmail() {
        
        this.name = "Chainmail";
        this.prize = 70;
        this.attack=0f;
        this.defense=1f;
        this.health=0f;
        this.speed=-1f;
    }
    public void Regalia() {
        
        this.name = "Regalia";
        this.prize = 105;
        this.attack=0f;
        this.defense=1f;
        this.health=0f;
        this.speed=-0f;
    }
    public void Fleece() {
        
        this.name = "Fleece";
        this.prize = 150;
        this.attack=0f;
        this.defense=2f;
        this.health=1f;
        this.speed=-1f;
    }
}