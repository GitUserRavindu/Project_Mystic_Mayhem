package characters;

public class Archer extends Character {

    public Archer()
    {

    }

    public Archer(Character other)
    {
        super(other);
    }

    @Override
    public Character makeClone()
    {
        return (new Archer(this));
    }
}
