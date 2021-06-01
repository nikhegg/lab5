package commands;
import core.ConsolerMode;
import core.Globals;
import core.RouteMaker;
import exceptions.IncorrectArgumentException;
import exceptions.NullException;
import misc.Route;
import misc.VectorCore;

public class AddIfMin extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public AddIfMin(VectorCore vector) {
        super("add_if_min", "Adds an element to the collection if it has the smallest value in comparison with elements of the collection", "add_if_min",false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        Route route = new RouteMaker().makeNewRoute(mode);

        if(route != null) {
            Double minDistance = -1.0;
            for (Route vectorRoute : this.vector.getVector()) {
                if(route.getDistance() != null && vectorRoute.getDistance() != null && (vectorRoute.getDistance() < minDistance || minDistance == -1.0)) minDistance = vectorRoute.getDistance();
            }
            if(route.getDistance() == null || minDistance > route.getDistance() || minDistance == -1.0) this.vector.addElement(route);
            else {
                System.out.println("\nRoute " + route.getName() + " has not the smallest value of distance so it was not added to the collection");
                Globals.decRoutesCreated();
            }
        }
    }
}
