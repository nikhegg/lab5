package commands;
import core.Globals;
import exceptions.IncorrectArgumentException;
import exceptions.NullException;
import misc.Route;
import misc.VectorCore;
// DONE
public class AddIfMin extends AbCommand {
    private final VectorCore vector;

    public AddIfMin(VectorCore vector) {
        super("add_if_min", "Adds an element to the collection if it has the smallest value in comparison with elements of the collection", "add_if_min",false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
        Route route = null;
        try {
            route = Globals.makeNewRoute();
        } catch(NullException | IncorrectArgumentException e) {
            System.out.println("Hren'");
            System.out.println(e.getMessage());
        }
        if(route != null) {
            Double minDistance = -1.0;
            for (Route vectorRoute : this.vector.getVector()) {
                if(vectorRoute.getDistance() < minDistance || minDistance == -1.0) minDistance = vectorRoute.getDistance();
            }
            if(minDistance < route.getDistance() || minDistance == -1.0) this.vector.addElement(route);
            else System.out.println("Route " + route.getName() + " has not the smallest value of distance so it was not added to the collection");
        }
    }
}
