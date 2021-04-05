package commands;
import misc.VectorCore;

public class RemoveByID extends AbCommand {
    private final VectorCore vector;

    public RemoveByID(VectorCore vector) {
        super("remove_by_id", "Finds an element in the collection by ID and deletes it", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
