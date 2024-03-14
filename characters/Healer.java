package characters;
public class Healer extends Character{
    public Healer()
    {

    }

    public Healer(Character other)
    {
        super(other);
    }

    @Override
    public Character makeClone()
    {
        return (new Healer(this));
    }
}
