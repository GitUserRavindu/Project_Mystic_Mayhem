package Character;
public class MythicalCreature extends Character{
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
