package commands;
import core.VectorCore;

public class AddElement extends AbCommand {
    private final VectorCore vector;

    public AddElement(VectorCore vector) {
        super("add", "Adds a new element to the collection");
        this.vector = vector;
    }

    @Override
    public void execute() {

    }
}
