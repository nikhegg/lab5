package commands;
import core.VectorCore;

public class RemoveLast extends AbCommand {
    private final VectorCore vector;

    public RemoveLast(VectorCore vector) {
        super("remove_last", "Removes the last element of the collection");
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
