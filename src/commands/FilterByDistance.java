package commands;
import core.VectorCore;

public class FilterByDistance extends AbCommand {
    public final VectorCore vector;

    public FilterByDistance(VectorCore vector) {
        super("filter_by_distance", "Filters all collection elements by distance");
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
