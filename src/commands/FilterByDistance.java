package commands;
import core.ConsolerMode;
import core.Globals;
import exceptions.NonNumberStringException;
import misc.Route;
import misc.VectorCore;

public class FilterByDistance extends AbCommand {
    public final VectorCore vector;

    /**
     * @param vector
     */
    public FilterByDistance(VectorCore vector) {
        super("filter_by_distance", "Displays all elements of the collection with distance value given by user", "filter_by_distance", false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        if(args.length <= 0) System.out.println("There is no number as an argument in the message");
        else if(!Globals.isDouble(args[0])) System.out.println("Distance should be a number");
        else {
            try {
                double distance = Globals.getDouble(args[0]);
                String message = "";
                long foundElements = 0;
                for (Route route : this.vector.getVector()) {
                    if(route.getDistance() != null && route.getDistance() == distance) {
                        message += this.vector.getElementInfo(route);
                    }
                }
                System.out.println("Found " + foundElements + " elements with distance equals to " + distance + "\n" + message);
            } catch(NonNumberStringException e) {
                System.out.println("Distance should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
