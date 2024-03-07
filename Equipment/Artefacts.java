package Equipment;

public class Artefacts extends Equipment{
    public void Amulet() {
        
        this.name = "Amulet";
        this.prize = 200;
        this.attack=1f;
        this.defense=-1f;
        this.health=1f;
        this.speed=1f;
    }
    public void Excalibur() {
        
        this.name = "Excalibur";
        this.prize = 150;
        this.attack=2f;
        this.defense=0f;
        this.health=0f;
        this.speed=0f;
    }
    public void Crystal() {
        
        this.name = "Crystal";
        this.prize = 210;
        this.attack=2f;
        this.defense=1f;
        this.health=-1f;
        this.speed=-1f;
    }
}
