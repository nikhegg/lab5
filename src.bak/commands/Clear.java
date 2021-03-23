package commands;
import core.VectorCore;

public class Clear extends AbCommand{
    private final VectorCore vector;

    public Clear(VectorCore vector) {
        super("clear", "Clears the collection");
        this.vector = vector;
    }

    public void execute() {
        /* TODO Check if this method doesn't crash the program (vector.clear() as a method n VectorCore class
                && vector.clear() as a method in default Vector class
        */
        this.vector.clear();
    }
}
