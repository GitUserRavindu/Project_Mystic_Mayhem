package characters;

public class Knight extends Character {
    public Knight()
    {

    }

    public Knight(Character other)
    {
        super(other);
    }

    @Override
    public Character makeClone()
    {
        return (new Knight(this));
    }

    public void Squire(){
        this.name = "Squire";
        this.prize = 85;
        this.attack=8f;
        this.defense=9f;
        this.health=7f;
        this.speed=8f;
    }
    public void Cavalier(){
        this.name = "Cavalier";
        this.prize = 110;
        this.attack=10f;
        this.defense=12f;
        this.health=7f;
        this.speed=10f;
    }
    public void Templar(){
        this.name = "Templar";
        this.prize = 160;
        this.attack=15f;
        this.defense=5f;
        this.health=7f;
        this.speed=14f;
    }
    public void Zoro(){
        this.name = "Zoro";
        this.prize = 200;
        this.attack=16f;
        this.defense=9f;
        this.health=11f;
        this.speed=14f;
    }
}
