package commands;
import exceptions.NullException;
import misc.RouteMaker;
import misc.VectorCore;
import misc.Route;

public class AddElement extends AbCommand {
    private final VectorCore vector;

    public AddElement(VectorCore vector) {
        super("add", "Adds a new element to the collection");
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {

        //TODO Route Maker
        RouteMaker rm = new RouteMaker();
        Route route = null;
        try {
            route = rm.makeNewRoute();
        } catch(NullException e) {
            System.out.println(e.getMessage());
        }
        if(route != null) {
            this.vector.addElement(route);
        }

    }
}
