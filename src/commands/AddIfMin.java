package commands;
import core.VectorCore;

public class AddIfMin extends AbCommand {
    private final VectorCore vector;

    public AddIfMin(VectorCore vector) {
        super("add_if_min", "Adds an element to the collection if it has the smallest value in comparison with elements of the collection");
        this.vector = vector;
    }

    @Override
    public void execute() {

    }
}
