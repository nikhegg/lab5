package commands;
import core.ConsolerMode;
import core.Globals;
import exceptions.NonNumberStringException;
import misc.Route;
import misc.VectorCore;

public class CountLessThanDistance extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public CountLessThanDistance(VectorCore vector) {
        super("count_less_than_distance", "Counts how many elements with distance that is lower than an entered value", "count_less_than_distance <distance>",false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        if(args.length <= 0) System.out.println("There is no value in the message");
        else if(!Globals.isDouble(args[0])) System.out.println("Minimal value should be a number");
        else {
            try {
                double enteredValue = Globals.getDouble(args[0]);
                if(enteredValue < 0) System.out.println("Distance cannot be negative");
                else {
                    int count = 0;
                    for (Route route : this.vector.getVector()) {
                        if(route.getDistance() != null && route.getDistance() < enteredValue) count += 1;
                    }
                    System.out.println("There are " + count + " elements in a collection with the distance less than " + enteredValue);
                }
            } catch(NonNumberStringException e) {
                System.out.println("Minimal value should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
