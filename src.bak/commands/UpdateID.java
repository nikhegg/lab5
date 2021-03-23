package commands;
import core.VectorCore;

public class UpdateID extends AbCommand {
    private final VectorCore vector;

    public UpdateID(String name, String description, VectorCore vector) {
        super("update_id", "Updates an elements of collection with a specified ID");
        this.vector = vector;
    }

    @Override
    public void execute() {

    }
}
