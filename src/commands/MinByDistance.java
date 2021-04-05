package commands;
import misc.VectorCore;

public class MinByDistance extends AbCommand {
    private final VectorCore vector;

    public MinByDistance(VectorCore vector) {
        super("min_by_distance", "Finds one of elements in the collection which has the less distance parameter", "min_by_distance", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
