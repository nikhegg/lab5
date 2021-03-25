package commands;
import misc.VectorCore;

public class UpdateID extends AbCommand {
    private final VectorCore vector;

    public UpdateID(VectorCore vector) {
        super("update_id", "Updates an elements of collection with a specified ID");
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
