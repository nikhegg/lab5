package commands;
import core.VectorCore;

public class Show extends AbCommand {
    private final VectorCore vector;

    public Show(VectorCore vector) {
        super("show", "Shows current collection as a string");
        this.vector = vector;
    }

    public void execute(String[] args) {
        if(!vector.getCollection().equals("")) System.out.println(vector.getCollection());
        else System.out.println("The collection has no content inside");
    }
}
