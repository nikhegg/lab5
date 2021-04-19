package commands;
import core.ConsolerMode;
import core.Globals;
import core.RouteMaker;
import exceptions.NonNumberStringException;
import misc.Route;
import misc.VectorCore;

public class Update extends AbCommand {
    private final VectorCore vector;

    public Update(VectorCore vector) {
        super("update", "Updates an elements of collection with a specified ID", "update <id>",false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args, ConsolerMode mode) {
        if(args.length <= 0) System.out.println("There is no ID in the message");
        else if(!Globals.isInt(args[0])) System.out.println("ID should be a number");
        else {
            try {
                int id = Globals.getInt(args[0]);
                if((this.vector.getSize()-1) < id) System.out.println("The collection does not have an element with ID " + id);
                else {
                    int key;
                    Route route = null;
                    key = Integer.parseInt(args[0]);
                    route = new RouteMaker().makeNewRoute(mode);
                    this.vector.updateID(key, route);
                }
            } catch(NonNumberStringException e) {
                System.out.println("ID should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
