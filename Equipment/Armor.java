package Equipment;

public class Armor extends Equipment {

    public Armor()
    {

    }

    public Armor(Equipment other)
    {
        super(other);
    }

    public Equipment makeClone()
    {
        return (new Armor(this));
    }

}