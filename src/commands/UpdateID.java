package commands;
import core.Globals;
import exceptions.NonIntStringException;
import misc.Route;
import misc.VectorCore;

public class UpdateID extends AbCommand {
    private final VectorCore vector;

    public UpdateID(VectorCore vector) {
        super("update", "Updates an elements of collection with a specified ID", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
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
                    route = Globals.makeNewRoute();
                    this.vector.updateID(key, route);
                }
            } catch(NonIntStringException e) {
                System.out.println("ID should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
