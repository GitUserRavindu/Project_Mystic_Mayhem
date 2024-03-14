package character;

public class Mage extends Character {
    // regular constructor
    public Mage()
    {

    }
    // special constructor for cloning
    public Mage(Character other)
    {
        super(other);
    }

    @Override // cloning method
    public Character makeClone()
    {
        return (new Mage(this));
    }
}
