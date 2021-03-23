package commands;
import core.VectorCore;

public class Save extends AbCommand {
    private final VectorCore vector;

    public Save(VectorCore vector) {
        super("save", "Saves the collection to a file (collection.csv)");
        this.vector = vector;
    }

    @Override
    public void execute() {

    }
}
