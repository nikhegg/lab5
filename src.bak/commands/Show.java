package commands;
import core.VectorCore;

public class Show extends AbCommand {
    private final VectorCore vector;

    public Show(VectorCore vector) {
        super("show", "Shows current collection as a string");
        this.vector = vector;
    }

    public void execute() {
        System.out.println(vector.getCollection());
    }
}
