package commands;
import core.ConsolerMode;
import core.FileOperator;
import misc.VectorCore;

public class Save extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public Save(VectorCore vector) {
        super("save", "Saves the collection to a file", "save", false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        FileOperator fo = new FileOperator();
        fo.saveCSVCollection(this.vector);
    }
}
