package commands;
import misc.VectorCore;

public class CountLessThanDistance extends AbCommand {
    private final VectorCore vector;

    public CountLessThanDistance(VectorCore vector) {
        super("count_less_than_distance", "Counts how many elements with distance that is lower than an entered value", "count_less_than_distance <distance>",false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

    }
}
