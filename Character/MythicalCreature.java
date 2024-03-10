package Character;

public class MythicalCreature extends Character {
    // All the structures are same as characters
    public MythicalCreature()
    {

    }

    public MythicalCreature(Character other)
    {
        super(other);
    }

    @Override
    public Character makeClone()
    {
        return (new MythicalCreature(this));
    }
}
