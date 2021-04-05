package commands;
import core.Globals;
import exceptions.NonIntStringException;
import exceptions.NullException;
import misc.Route;
import misc.VectorCore;

public class UpdateID extends AbCommand {
    private final VectorCore vector;

    public UpdateID(VectorCore vector) {
        super("update_id", "Updates an elements of collection with a specified ID", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
        if(args.length <= 0) System.out.println("No args"); // TODO ARGS MANAGEMENT
        int key;
        Route route = null;
        try {
            key = Integer.parseInt(args[0]);
            route = Globals.makeNewRoute();
            this.vector.updateID(key, route);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } // TODO
    }
}
