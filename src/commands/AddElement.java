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

    /**
     * @param vector
     */
    public AddElement(VectorCore vector) {
        super("add", "Adds a new element to the collection", "add",false);
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
            this.vector.addElement(route);
        }
    }
}
