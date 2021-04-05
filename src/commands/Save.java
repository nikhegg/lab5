package commands;
import misc.VectorCore;

public class Save extends AbCommand {
    private final VectorCore vector;

    public Save(VectorCore vector) {
        super("save", "Saves the collection to a file", "save", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
