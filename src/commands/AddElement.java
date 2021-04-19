package commands;
import core.ConsolerMode;
import core.Globals;
import core.RouteMaker;
import exceptions.IncorrectArgumentException;
import exceptions.NullException;
import misc.VectorCore;
import misc.Route;

public class AddElement extends AbCommand {
    private final VectorCore vector;

    public AddElement(VectorCore vector) {
        super("add", "Adds a new element to the collection", "add",false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args, ConsolerMode mode) {
        Route route = null;
        try {
            route = new RouteMaker().makeNewRoute(mode);
        } catch(NullException | IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }
        if(route != null) {
            this.vector.addElement(route);
        }

    }
}
