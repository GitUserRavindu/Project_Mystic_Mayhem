package equipment;

public class Artefact extends Equipment {

    public Artefact()
    {

    }

    public Artefact(Equipment other)
    {
        super(other);
    }

    public Equipment makeClone()
    {
        return (new Artefact(this));
    }

}
