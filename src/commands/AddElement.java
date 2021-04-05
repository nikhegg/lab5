package commands;
import core.Globals;
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
    public void execute(String[] args) {
        //TODO Route Maker
        Route route = null;
        try {
            route = Globals.makeNewRoute();
        } catch(NullException | IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }

        if(route != null) {
            this.vector.addElement(route);
        }

    }
}
