package commands;
import core.VectorCore;

public class Sort extends AbCommand {
    private final VectorCore vector;

    public Sort(VectorCore vector) {
        super("sort", "Sorts the collection in normal order");
        this.vector = vector;
    }

    @Override
    public void execute() {

    }
}
