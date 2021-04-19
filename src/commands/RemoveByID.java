package commands;
import core.ConsolerMode;
import core.Globals;
import exceptions.NonNumberStringException;
import misc.VectorCore;

public class RemoveByID extends AbCommand {
    private final VectorCore vector;

    public RemoveByID(VectorCore vector) {
        super("remove_by_id", "Finds an element in the collection by ID and deletes it", "remove_by_id <id>", false);
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
                    key = Integer.parseInt(args[0]);
                    if(this.vector.getVector().get(key) != null) {
                        this.vector.getVector().remove(key);
                        System.out.println("Element with ID " + key + " was successfully removed from the collection");
                    } else System.out.println("Could not remove the element because it does not exist");
                }
            } catch(NonNumberStringException e) {
                System.out.println("ID should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
